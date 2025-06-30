package fr.Ewanbe.firstmod.objects.items;

import fr.Ewanbe.firstmod.Main;
import fr.Ewanbe.firstmod.init.ItemInit;
import fr.Ewanbe.firstmod.utils.interfaces.IHasModel;
import net.minecraft.creativetab.CreativeTabs;
import net.minecraft.entity.effect.EntityLightningBolt;
import net.minecraft.entity.player.EntityPlayer;
import net.minecraft.item.Item;
import net.minecraft.item.ItemStack;
import net.minecraft.util.ActionResult;
import net.minecraft.util.EnumHand;
import net.minecraft.util.math.RayTraceResult;
import net.minecraft.util.math.Vec3d;
import net.minecraft.world.World;


public class ItemBase extends Item implements IHasModel {

    public ItemBase(String name){
        setRegistryName(name);
        setCreativeTab(CreativeTabs.TOOLS);
        setTranslationKey(name);
        setMaxStackSize(1);
        ItemInit.ITEMS.add(this);
    }

    @Override
    public void registerModels() {
        Main.proxy.registerItemRenderer(this, 0);
    }

    @Override
    public ActionResult<ItemStack> onItemRightClick(World worldIn, EntityPlayer playerIn, EnumHand handIn) {
        if(!worldIn.isRemote) {
            double rayTraceDistance = 50.0;
            RayTraceResult result = playerIn.rayTrace(rayTraceDistance, 0.0F);
            double targetX, targetY, targetZ;
            if (result != null) {
                targetX = result.hitVec.x;
                targetY = result.hitVec.y;
                targetZ = result.hitVec.z;
            } else {
                Vec3d eyePos = playerIn.getPositionEyes(0.0F);
                Vec3d lookVec = playerIn.getLook(0.0F);
                targetX = eyePos.x + lookVec.x * rayTraceDistance;
                targetY = eyePos.y + lookVec.y * rayTraceDistance;
                targetZ = eyePos.z + lookVec.z * rayTraceDistance;
            }
            EntityLightningBolt lightning = new EntityLightningBolt(worldIn, targetX, targetY, targetZ, false);
            worldIn.spawnEntity(lightning);
        }
        return super.onItemRightClick(worldIn, playerIn, handIn);
    }
}

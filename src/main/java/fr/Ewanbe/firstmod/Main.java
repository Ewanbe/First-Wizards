package fr.Ewanbe.firstmod;

import fr.Ewanbe.firstmod.proxy.CommonProxy;
import fr.Ewanbe.firstmod.utils.References;
import net.minecraftforge.fml.common.Mod;
import net.minecraftforge.fml.common.SidedProxy;
import net.minecraftforge.fml.common.event.FMLInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPostInitializationEvent;
import net.minecraftforge.fml.common.event.FMLPreInitializationEvent;

@Mod(modid = References.MODID, name = References.NAME, version = References.VERSION)
public class Main {

    @Mod.Instance(References.MODID)
    public static Main instance;

    @SidedProxy(clientSide = References.CLIENT_PROXY, serverSide = References.SERVER_PROXY)
    public static CommonProxy proxy;

    @Mod.EventHandler
    public void preInit(FMLPreInitializationEvent e){
        proxy.preInit();
    }

    @Mod.EventHandler
    public void init(FMLInitializationEvent e){
        proxy.init();
    }

    @Mod.EventHandler
    public void postInit(FMLPostInitializationEvent e){
        proxy.postInit();

    }
}

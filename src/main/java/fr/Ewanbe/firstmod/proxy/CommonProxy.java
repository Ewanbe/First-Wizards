package fr.Ewanbe.firstmod.proxy;

import net.minecraft.item.Item;

public abstract class CommonProxy {

    public abstract void registerItemRenderer(Item item, int meta);

    public void preInit(){

    }

    public void init(){

    }

    public void postInit(){

    }
}

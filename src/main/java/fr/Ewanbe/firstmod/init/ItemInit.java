package fr.Ewanbe.firstmod.init;

import fr.Ewanbe.firstmod.objects.items.DeathPotion;
import fr.Ewanbe.firstmod.objects.items.ItemBase;
import net.minecraft.item.Item;

import java.util.ArrayList;
import java.util.List;

public class ItemInit {

    public static List<Item> ITEMS = new ArrayList<Item>();

    //Outils
    public static final Item baguette = new ItemBase("baguette_magique");

    //Potions
    public static final Item death_potion = new DeathPotion("death_potion");

}

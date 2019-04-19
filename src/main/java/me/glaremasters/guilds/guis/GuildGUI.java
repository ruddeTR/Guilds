package me.glaremasters.guilds.guis;

import ch.jalu.configme.SettingsManager;
import co.aikar.commands.ACFBukkitUtil;
import co.aikar.commands.CommandManager;
import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import lombok.AllArgsConstructor;
import me.glaremasters.guilds.Guilds;
import me.glaremasters.guilds.configuration.sections.GuildManageSettings;
import me.glaremasters.guilds.guild.GuildHandler;
import me.glaremasters.guilds.utils.ItemBuilder;
import org.bukkit.Material;
import org.bukkit.inventory.ItemStack;

import java.util.List;

/**
 * Created by Glare
 * Date: 4/18/2019
 * Time: 8:53 PM
 */
@AllArgsConstructor
public class GuildGUI {

    private Guilds guilds;
    private SettingsManager settingsManager;
    private GuildHandler guildHandler;
    private CommandManager commandManager;

    public Gui getGuildGUI() {

        Gui gui = new Gui(guilds, 3, ACFBukkitUtil.color(settingsManager.getProperty(GuildManageSettings.MANAGEMENT_NAME)));

        OutlinePane backgroundPane = new OutlinePane(0, 0, 9, 3, Pane.Priority.LOW);
        OutlinePane foregroundPane = new OutlinePane(2, 1, 5, 1,  Pane.Priority.HIGH);

        createPanes(backgroundPane);
        createNormalPane(foregroundPane);

        gui.addPane(backgroundPane);
        gui.addPane(foregroundPane);


        return gui;
    }

    private void createPanes(OutlinePane pane) {
        ItemBuilder builder = new ItemBuilder(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 7));
        for (int i = 0; i < 27; i++) {
            pane.addItem(new GuiItem(builder.build(), event -> event.setCancelled(true)));
        }
    }

    private void createNormalPane(OutlinePane pane) {
        pane.addItem(new GuiItem(quickItem(settingsManager.getProperty(GuildManageSettings.MEMBERS_MATERIAL), settingsManager.getProperty(GuildManageSettings.MEMBERS_NAME), settingsManager.getProperty(GuildManageSettings.MEMBERS_LORE))));
    }

    private ItemStack quickItem(String material, String name, List<String> lore) {
        ItemBuilder builder = new ItemBuilder(Material.valueOf(material));
        builder.setName(ACFBukkitUtil.color(name));
        builder.setLore(lore);
        return builder.build();
    }

}

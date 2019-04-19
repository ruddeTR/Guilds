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

        OutlinePane pane = new OutlinePane(0, 0, 9, 3, Pane.Priority.LOW);

        createPanes(pane);

        gui.addPane(pane);


        return gui;
    }

    public void createPanes(OutlinePane pane) {
        ItemBuilder builder = new ItemBuilder(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 7));
        for (int i = 0; i < 27; i++) {
            pane.addItem(new GuiItem(builder.build(), event -> event.setCancelled(true)));
        }
    }

}

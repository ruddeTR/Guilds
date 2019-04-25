package me.glaremasters.guilds.guis;

import ch.jalu.configme.SettingsManager;
import ch.jalu.configme.properties.Property;
import co.aikar.commands.ACFBukkitUtil;
import co.aikar.commands.CommandManager;
import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.GuiItem;
import com.github.stefvanschie.inventoryframework.pane.OutlinePane;
import com.github.stefvanschie.inventoryframework.pane.Pane;
import lombok.AllArgsConstructor;
import me.glaremasters.guilds.Guilds;
import me.glaremasters.guilds.configuration.sections.GuildManageSettings;
import me.glaremasters.guilds.guild.Guild;
import me.glaremasters.guilds.guild.GuildHandler;
import me.glaremasters.guilds.messages.Messages;
import me.glaremasters.guilds.utils.ItemBuilder;
import me.glaremasters.guilds.utils.SkullUtils;
import org.bukkit.Material;
import org.bukkit.entity.Player;
import org.bukkit.inventory.ItemStack;

import java.util.ArrayList;
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
        OutlinePane foregroundPane = new OutlinePane(2, 1, 5, 1,  Pane.Priority.NORMAL);
        OutlinePane middlePane = new OutlinePane(4, 1, 1, 1, Pane.Priority.HIGH);
        OutlinePane exitPane = new OutlinePane(8, 2, 1, 1, Pane.Priority.HIGH);

        createPanes(backgroundPane);
        createNormalPane(foregroundPane);
        createCenter(middlePane);
        createExitPane(exitPane);

        gui.addPane(backgroundPane);
        gui.addPane(foregroundPane);
        gui.addPane(middlePane);
        gui.addPane(exitPane);


        return gui;
    }

    /**
     * Create the background panes
     * @param pane the pane to add to
     */
    private void createPanes(OutlinePane pane) {
        ItemBuilder builder = new ItemBuilder(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 7));
        for (int i = 0; i < 27; i++) {
            pane.addItem(new GuiItem(builder.build(), event -> event.setCancelled(true)));
        }
    }

    /**
     * Create the center pane for the gui
     * @param pane the pane to add to
     */
    private void createCenter(OutlinePane pane) {
        ItemBuilder builder = new ItemBuilder(new ItemStack(Material.STAINED_GLASS_PANE, 1, (byte) 8));
        pane.addItem(new GuiItem(builder.build(), event -> event.setCancelled(true)));
    }

    /**
     * Create the normal manage pane
     * @param pane the pane to add to
     */
    private void createNormalPane(OutlinePane pane) {
        pane.addItem(new GuiItem(quickItem(GuildManageSettings.MEMBERS_MATERIAL, GuildManageSettings.MEMBERS_NAME, GuildManageSettings.MEMBERS_LORE)));
        pane.addItem(new GuiItem(quickItem(GuildManageSettings.STATUS_MATERIAL, GuildManageSettings.STATUS_NAME, GuildManageSettings.STATUS_LORE), event -> {
            event.setCancelled(true);
            Guild guild = guildHandler.getGuild((Player) event.getWhoClicked());
            guild.toggleStatus();
            commandManager.getCommandIssuer(event.getWhoClicked()).sendInfo(Messages.STATUS__SUCCESSFUL, "{status}", guild.getStatus().name());
        }));
        pane.addItem(new GuiItem(new ItemStack(Material.AIR)));
        pane.addItem(new GuiItem(quickItem(GuildManageSettings.UPGRADE_MATERIAL, GuildManageSettings.UPGRADE_NAME, GuildManageSettings.UPGRADE_LORE)));
        pane.addItem(new GuiItem(quickItem(GuildManageSettings.CODES_MATERIAL, GuildManageSettings.CODES_NAME, GuildManageSettings.CODES_LORE)));
    }

    /**
     * Create the exit button
     * @param pane the pane to add to
     */
    private void createExitPane(OutlinePane pane) {
        pane.addItem(new GuiItem(quickItem(GuildManageSettings.EXIT_MATERIAL, GuildManageSettings.EXIT_NAME, GuildManageSettings.EXIT_LORE), event -> {
            event.setCancelled(true);
            event.getWhoClicked().closeInventory();
        }));
    }

    /**
     * Create items based off base64 codes
     * @param material the base64 code
     * @param name the name of the skull
     * @param lore the lore of the skull
     * @return created itemstack
     */
    private ItemStack quickItem(Property<String> material, Property<String> name, Property<List<String>> lore) {
        ItemBuilder builder = new ItemBuilder(SkullUtils.getSkull(SkullUtils.getEncoded("https://textures.minecraft.net/texture/" + settingsManager.getProperty(material))));
        builder.setName(ACFBukkitUtil.color(settingsManager.getProperty(name)));
        builder.setLore(settingsManager.getProperty(lore));
        return builder.build();
    }

}

package me.glaremasters.guilds.guis;

import ch.jalu.configme.SettingsManager;
import co.aikar.commands.ACFBukkitUtil;
import co.aikar.commands.CommandManager;
import com.github.stefvanschie.inventoryframework.Gui;
import com.github.stefvanschie.inventoryframework.pane.StaticPane;
import lombok.AllArgsConstructor;
import me.glaremasters.guilds.Guilds;
import me.glaremasters.guilds.configuration.sections.GuildManageSettings;
import me.glaremasters.guilds.guild.GuildHandler;

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

        Gui gui = new Gui(guilds, 1, ACFBukkitUtil.color(settingsManager.getProperty(GuildManageSettings.MANAGEMENT_NAME)));

        StaticPane pane = new StaticPane(0, 0, 9 ,1);

        return gui;
    }

}

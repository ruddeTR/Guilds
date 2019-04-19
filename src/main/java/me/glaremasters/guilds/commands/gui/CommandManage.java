package me.glaremasters.guilds.commands.gui;

import co.aikar.commands.BaseCommand;
import co.aikar.commands.annotation.CommandAlias;
import co.aikar.commands.annotation.CommandPermission;
import co.aikar.commands.annotation.Description;
import co.aikar.commands.annotation.Subcommand;
import lombok.AllArgsConstructor;
import me.glaremasters.guilds.Guilds;
import me.glaremasters.guilds.guild.Guild;
import me.glaremasters.guilds.guild.GuildHandler;
import me.glaremasters.guilds.utils.Constants;
import org.bukkit.entity.Player;

/**
 * Created by Glare
 * Date: 4/18/2019
 * Time: 9:00 PM
 */
@AllArgsConstructor @CommandAlias(Constants.ROOT_ALIAS)
public class CommandManage extends BaseCommand {

    private Guilds guilds;
    private GuildHandler guildHandler;

    @Subcommand("manage")
    @Description("{@@descriptions.manage}")
    @CommandPermission(Constants.BASE_PERM + "manage")
    public void execute(Player player, Guild guild) {
        guilds.getGuildGUI().getGuildGUI().show(player);
    }

}
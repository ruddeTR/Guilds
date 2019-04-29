package me.glaremasters.guilds.utils;

import co.aikar.idb.DB;
import co.aikar.idb.Database;
import co.aikar.idb.DatabaseOptions;
import co.aikar.idb.HikariPooledDatabase;
import co.aikar.idb.PooledDatabaseOptions;
import lombok.NonNull;
import me.glaremasters.guilds.guild.Guild;
import me.glaremasters.guilds.guild.GuildCode;
import me.glaremasters.guilds.guild.GuildHome;
import me.glaremasters.guilds.guild.GuildMember;
import org.bukkit.plugin.Plugin;

import java.util.UUID;

/**
 * MIT License
 *
 * Copyright (c) 2014-2018 Daniel Ennis
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy
 * of this software and associated documentation files (the "Software"), to deal
 * in the Software without restriction, including without limitation the rights
 * to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
 * copies of the Software, and to permit persons to whom the Software is
 * furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
 * FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
 * AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
 * LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
 * OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
 * SOFTWARE.
 */
//todo Clean this entire class up when you're not dead-ass tired
public class MySQLUtils {

    public static PooledDatabaseOptions getRecommendedOptions(Plugin plugin, @NonNull String user, @NonNull String pass, @NonNull String db, @NonNull String hostAndPort) {
        DatabaseOptions options = DatabaseOptions
                .builder()
                .poolName(plugin.getDescription().getName() + " DB")
                .logger(plugin.getLogger())
                .mysql(user, pass, db, hostAndPort)
                .build();
        return PooledDatabaseOptions
                .builder()
                .options(options)
                .build();
    }

    public static Database createHikariDatabase(Plugin plugin, @NonNull String user, @NonNull String pass, @NonNull String db, @NonNull String hostAndPort) {
        return createHikariDatabase(plugin, getRecommendedOptions(plugin, user, pass, db, hostAndPort));
    }

    public static Database createHikariDatabase(Plugin plugin, PooledDatabaseOptions options) {
        return createHikariDatabase(plugin, options, true);
    }

    public static Database createHikariDatabase(Plugin plugin, PooledDatabaseOptions options, boolean setGlobal) {
        HikariPooledDatabase db = new HikariPooledDatabase(options);
        if (setGlobal) {
            DB.setGlobalDatabase(db);
        }
        return db;
    }

    /**
     * Turn the GuildHome into a string
     * @param guild the guild of the guild home
     * @return the guildhome as a string
     */
    public static String stringHome(Guild guild) {
        StringBuilder sb = new StringBuilder();

        try {
            GuildHome home = guild.getHome();
            sb.append(home.getWorld() + ":" + home.getX() + ":" + home.getY() + ":" + home.getZ() + ":" + home.getYaw() + ":" + home.getPitch());
        } catch (NullPointerException ex) {
            sb.append("");
        }
        return sb.toString();
    }

    /**
     * Put all the members of a guild to a string
     * @param guild the guild to string members to
     * @return string of members
     */
    public static String stringMembers(Guild guild) {
        StringBuilder sb = new StringBuilder();

        for (GuildMember member : guild.getMembers()) {
            sb.append(member.getUuid().toString() + "," + member.getRole().getLevel() + "//");
        }
        return sb.toString();
    }

    /**
     * Put all the invited members to a string
     * @param guild the guild to string pending members to
     * @return string of pending members
     */
    public static String stringPendingMembers(Guild guild) {
        StringBuilder sb = new StringBuilder();

        for (UUID uuid : guild.getInvitedMembers()) {
            sb.append(uuid.toString() + "//");
        }
        return sb.toString();
    }

    /**
     * Put all allies into a string
     * @param guild the guild to string allies to
     * @return string of allies
     */
    public static String stringAllies(Guild guild) {
        StringBuilder sb = new StringBuilder();

        for (UUID uuid : guild.getAllies()) {
            sb.append(uuid.toString() + "//");
        }
        return sb.toString();
    }

    /**
     * Put all pending allies into a string
     * @param guild the guild to string pending allies to
     * @return string of pending allies
     */
    public static String stringPendingAllies(Guild guild) {
        StringBuilder sb = new StringBuilder();

        for (UUID uuid : guild.getPendingAllies()) {
            sb.append(uuid.toString() + "//");
        }
        return sb.toString();
    }

    /**
     * Turn the guild codes into a string
     * @param guild the guild of the codes
     * @return the codes as as a string
     */
    public static String stringGuildCodes(Guild guild) {
        StringBuilder sb = new StringBuilder();

        for (GuildCode code : guild.getCodes()) {
            sb.append(code.getId() + "," + code.getUses() + "," + code.getRedeemers().toString());
        }
        return sb.toString();
    }

    /**
     * Turn the guild vaults into a string
     * @param guild the guild of the vaults
     * @return the vaults as a string
     */
    public static String stringGuildVault(Guild guild) {
        StringBuilder sb = new StringBuilder();

        for (String vault : guild.getVaults()) {
            sb.append(vault + "//");
        }
        return sb.toString();
    }
}

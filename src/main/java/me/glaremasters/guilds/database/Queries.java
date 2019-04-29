package me.glaremasters.guilds.database;

import org.intellij.lang.annotations.Language;

/**
 * Created by Glare
 * Date: 4/28/2019
 * Time: 6:05 PM
 */
public class Queries {

    @Language("MySQL")
    public static final String CREATE_TABLE_GUILDS = "CREATE TABLE IF NOT EXISTS `guilds`\n" +
            "(\n" +
            "  `id` varchar(36) UNIQUE PRIMARY KEY NOT NULL,\n" +
            "  `name` varchar(60) UNIQUE NOT NULL,\n" +
            "  `prefix` varchar(60) NOT NULL,\n" +
            "  `master` varchar(36) NOT NULL,\n" +
            "  `home` varchar(1000) NULL,\n" +
            "  `skull` varchar(60) NOT NULL,\n" +
            "  `status` varchar(10) NOT NULL,\n" +
            "  `tier` integer(5) NOT NULL,\n" +
            "  `balance` double NOT NULL\n" +
            ");";

    @Language("MySQL")
    public static final String CREATE_TABLE_MEMBERS = "CREATE TABLE IF NOT EXISTS `guild_members`\n" +
            "(\n" +
            "  `id` varchar(36) UNIQUE PRIMARY KEY NOT NULL,\n" +
            "  `members` TEXT NOT NULL,\n" +
            "  `role` integer(5) NOT NULL\n" +
            ");";

    @Language("MySQL")
    public static final String CREATE_TABLE_PENDING_MEMBERS = "CREATE TABLE IF NOT EXISTS `pending_members`\n" +
            "(\n" +
            "  `id` varchar(36) UNIQUE PRIMARY KEY NOT NULL,\n" +
            "  `invites` TEXT\n" +
            ");";

    @Language("MySQL")
    public static final String CREATE_TABLE_ALLIES = "CREATE TABLE IF NOT EXISTS `guild_allies`\n" +
            "(\n" +
            "  `id` varchar(36) UNIQUE PRIMARY KEY NOT NULL,\n" +
            "  `invites` TEXT\n" +
            ");";

    @Language("MySQL")
    public static final String CREATE_TABLE_PENDING_ALLIES = "CREATE TABLE IF NOT EXISTS `pending_allies`\n" +
            "(\n" +
            "  `id` varchar(36) UNIQUE PRIMARY KEY NOT NULL,\n" +
            "  `invites` TEXT\n" +
            ");";

    @Language("MySQL")
    public static final String CREATE_TABLE_CODES = "CREATE TABLE IF NOT EXISTS `guild_codes`\n" +
            "(\n" +
            "  `code` varchar(100) UNIQUE PRIMARY KEY NOT NULL,\n" +
            "  `uses` integer(10) NOT NULL,\n" +
            "  `creator` varchar(36) NOT NULL,\n" +
            "  `redeemers` TEXT\n" +
            ");";

    @Language("MySQL")
    public static final String CREATE_TABLE_VAULTS = "CREATE TABLE IF NOT EXISTS `guild_vaults`\n" +
            "(\n" +
            "  `id` varchar(36) UNIQUE PRIMARY KEY NOT NULL,\n" +
            "  `vaults` TEXT NOT NULL\n" +
            ");";


/*    @Language("MySQL")
    public static final String ADD_NEW_GUILD = "INSERT IGNORE INTO guilds (id, name, prefix, " +
            "master, home, skull, status, tier, balance, " +
            "members, invited_members, allies, " +
            "pending_allies, codes, vaults) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";*/

}

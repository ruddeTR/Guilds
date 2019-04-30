package me.glaremasters.guilds.database;

import org.intellij.lang.annotations.Language;

/**
 * Created by Glare
 * Date: 4/28/2019
 * Time: 6:05 PM
 */
public class Queries {

    @Language("MySQL")
    public static final String CREATE_TABLE_GUILDS = "CREATE TABLE IF NOT EXISTS `guilds` (\n" +
            "  `id` VARCHAR(36) NOT NULL,\n" +
            "  `name` VARCHAR(60) NOT NULL,\n" +
            "  `prefix` VARCHAR(60) NOT NULL,\n" +
            "  `master` VARCHAR(36) NOT NULL,\n" +
            "  `home` VARCHAR(100) NOT NULL,\n" +
            "  `skull` VARCHAR(100) NOT NULL,\n" +
            "  `status` VARCHAR(15) NOT NULL,\n" +
            "  `tier` INT(5) NOT NULL,\n" +
            "  `balance` DOUBLE NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE (`id`),\n" +
            "  UNIQUE (`name`))\n" +
            "ENGINE = InnoDB;";

    @Language("MySQL")
    public static final String CREATE_TABLE_MEMBERS = "CREATE TABLE IF NOT EXISTS `guild_members` (\n" +
            "  `id` VARCHAR(36) NOT NULL,\n" +
            "  `uuid` VARCHAR(36) NOT NULL,\n" +
            "  `role` INT(5) NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE (`uuid`),\n" +
            "  CONSTRAINT `id`\n" +
            "    FOREIGN KEY (`id`)\n" +
            "    REFERENCES `guilds` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB;";

    @Language("MySQL")
    public static final String CREATE_TABLE_PENDING_MEMBERS = "CREATE TABLE IF NOT EXISTS `pending_members` (\n" +
            "  `id` VARCHAR(36) NOT NULL,\n" +
            "  `invites` TEXT NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE (`id`),\n" +
            "  CONSTRAINT `id`\n" +
            "    FOREIGN KEY (`id`)\n" +
            "    REFERENCES `guilds` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB;";

    @Language("MySQL")
    public static final String CREATE_TABLE_ALLIES = "CREATE TABLE IF NOT EXISTS `guild_allies` (\n" +
            "  `id` VARCHAR(36) NOT NULL,\n" +
            "  `allies` TEXT NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE (`id`),\n" +
            "  CONSTRAINT `id`\n" +
            "    FOREIGN KEY (`id`)\n" +
            "    REFERENCES `guilds` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB;";

    @Language("MySQL")
    public static final String CREATE_TABLE_PENDING_ALLIES = "CREATE TABLE IF NOT EXISTS `pending_allies` (\n" +
            "  `id` VARCHAR(36) NOT NULL,\n" +
            "  `invites` TEXT NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE (`id`),\n" +
            "  CONSTRAINT `id`\n" +
            "    FOREIGN KEY (`id`)\n" +
            "    REFERENCES `guilds` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB;";

    @Language("MySQL")
    public static final String CREATE_TABLE_CODES = "CREATE TABLE IF NOT EXISTS `guild_codes` (\n" +
            "  `id` VARCHAR(36) NOT NULL,\n" +
            "  `code` VARCHAR(100) NOT NULL,\n" +
            "  `uses` INT(10) NOT NULL,\n" +
            "  `creator` VARCHAR(36) NOT NULL,\n" +
            "  `redeemers` TEXT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE (`id`),\n" +
            "  CONSTRAINT `id`\n" +
            "    FOREIGN KEY (`id`)\n" +
            "    REFERENCES `guilds` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB;";

    @Language("MySQL")
    public static final String CREATE_TABLE_VAULTS = "CREATE TABLE IF NOT EXISTS `guild_vaults` (\n" +
            "  `id` VARCHAR(36) NOT NULL,\n" +
            "  `vaults` TEXT NOT NULL,\n" +
            "  PRIMARY KEY (`id`),\n" +
            "  UNIQUE (`id`),\n" +
            "  CONSTRAINT `id`\n" +
            "    FOREIGN KEY (`id`)\n" +
            "    REFERENCES `guilds` (`id`)\n" +
            "    ON DELETE NO ACTION\n" +
            "    ON UPDATE NO ACTION)\n" +
            "ENGINE = InnoDB;";


/*    @Language("MySQL")
    public static final String ADD_NEW_GUILD = "INSERT IGNORE INTO guilds (id, name, prefix, " +
            "master, home, skull, status, tier, balance, " +
            "members, invited_members, allies, " +
            "pending_allies, codes, vaults) VALUES (?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";*/

}

package me.glaremasters.guilds.configuration.sections;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;

import java.util.List;

import static ch.jalu.configme.properties.PropertyInitializer.newListProperty;
import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

/**
 * Created by Glare
 * Date: 4/18/2019
 * Time: 8:54 PM
 */
public class GuildManageSettings implements SettingsHolder {

    private static final String MANAGEMENT_PATH = "guis.guild-management.";

    public static final Property<String> MANAGEMENT_NAME =
            newProperty(MANAGEMENT_PATH + "gui-name", "Guild Management");

    public static final Property<String> MEMBERS_MATERIAL =
            newProperty(MANAGEMENT_PATH + "members.material", "KNOWLEDGE_BOOK");

    public static final Property<String> MEMBERS_NAME =
            newProperty(MANAGEMENT_PATH + "members.name", "&r");

    public static final Property<List<String>> MEMBERS_LORE =
            newListProperty(MANAGEMENT_PATH + "members.lore", " &f&l> &a&lManage Members &f&l< ", "", "&8 • &7Demote ", "&8 • &7Kick ", "&8 • &7Promote ", "");

    public static final Property<String> STATUS_MATERIAL =
            newProperty(MANAGEMENT_PATH + "status.material", "BOOK_AND_QUILL");

    public static final Property<String> STATUS_NAME =
            newProperty(MANAGEMENT_PATH + "status.name", "&r");

    public static final Property<List<String>> STATUS_LORE =
            newListProperty(MANAGEMENT_PATH + "status.lore", " &f&l> &a&lToggle Status &f&l< ", "", "&8 • &7Toggle the Status of your Guild ", "");

    public static final Property<String> UPGRADE_MATERIAL =
            newProperty(MANAGEMENT_PATH + "upgrade.material", "ARROW");

    public static final Property<String> UPGRADE_NAME =
            newProperty(MANAGEMENT_PATH + "upgrade.name", "&r");

    public static final Property<List<String>> UPGRADE_LORE =
            newListProperty(MANAGEMENT_PATH + "upgrade.lore", " &f&l> &a&lUpgrade Guild &f&l< ", "", "&8 • &7Upgrade your Guild ", "&8 • &7to a higher tier ", "");

    public static final Property<String> CODES_MATERIAL =
            newProperty(MANAGEMENT_PATH + "codes.material", "EMPTY_MAP");

    public static final Property<String> CODES_NAME =
            newProperty(MANAGEMENT_PATH + "codes.name", "&r");

    public static final Property<List<String>> CODES_LORE =
            newListProperty(MANAGEMENT_PATH + "codes.lore", " &f&l> &a&lCode Management &f&l< ", "", "&8 • &7Create ", "&8 • &7Delete ", "&8 • &7List ", "");

    public static final Property<String> EXIT_MATERIAL =
            newProperty(MANAGEMENT_PATH + "exit.material", "IRON_DOOR");

    public static final Property<String> EXIT_NAME =
            newProperty(MANAGEMENT_PATH + "exit.name", "&r");

    public static final Property<List<String>> EXIT_LORE =
            newListProperty(MANAGEMENT_PATH + "exit.lore", " &c&l&oClose ", "");


}

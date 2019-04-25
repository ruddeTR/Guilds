package me.glaremasters.guilds.configuration.sections;

import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.configurationdata.CommentsConfiguration;
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
            newProperty(MANAGEMENT_PATH + "members.material", "d01afe973c5482fdc71e6aa10698833c79c437f21308ea9a1a095746ec274a0f");

    public static final Property<String> MEMBERS_NAME =
            newProperty(MANAGEMENT_PATH + "members.name", "&r");

    public static final Property<List<String>> MEMBERS_LORE =
            newListProperty(MANAGEMENT_PATH + "members.lore", " &f&l> &a&lManage Members &f&l< ", "", "&8 • &7Demote ", "&8 • &7Kick ", "&8 • &7Promote ", "");

    public static final Property<String> STATUS_MATERIAL =
            newProperty(MANAGEMENT_PATH + "status.material", "c08116712cbe012486d9e5238568b88f4824c4ecae80578c3c9fb33bd97ac976");

    public static final Property<String> STATUS_NAME =
            newProperty(MANAGEMENT_PATH + "status.name", "&r");

    public static final Property<List<String>> STATUS_LORE =
            newListProperty(MANAGEMENT_PATH + "status.lore", " &f&l> &a&lToggle Status &f&l< ", "", "&8 • &7Toggle the Status of your Guild ", "&8 • &7Current Status: &a&l{status}", "");

    public static final Property<String> UPGRADE_MATERIAL =
            newProperty(MANAGEMENT_PATH + "upgrade.material", "cb45c5eb78dff6fc43f7f8e398729414422a8eb6f314505df8ff9a33bdd6d12f");

    public static final Property<String> UPGRADE_NAME =
            newProperty(MANAGEMENT_PATH + "upgrade.name", "&r");

    public static final Property<List<String>> UPGRADE_LORE =
            newListProperty(MANAGEMENT_PATH + "upgrade.lore", " &f&l> &a&lUpgrade Guild &f&l< ", "", "&8 • &7Upgrade your Guild ", "&8 • &7to a higher tier ", "");

    public static final Property<String> CODES_MATERIAL =
            newProperty(MANAGEMENT_PATH + "codes.material", "10184e4ca40f77c7b86309eae4eacb68c7739f206f0c49412f507a1028c316d8");

    public static final Property<String> CODES_NAME =
            newProperty(MANAGEMENT_PATH + "codes.name", "&r");

    public static final Property<List<String>> CODES_LORE =
            newListProperty(MANAGEMENT_PATH + "codes.lore", " &f&l> &a&lCode Management &f&l< ", "", "&8 • &7Create ", "&8 • &7Delete ", "&8 • &7List ", "");

    public static final Property<String> EXIT_MATERIAL =
            newProperty(MANAGEMENT_PATH + "exit.material", "55d5c75f6675edc292ea37846077970d226fbd524e7fd6808f3a4781a549b08c");

    public static final Property<String> EXIT_NAME =
            newProperty(MANAGEMENT_PATH + "exit.name", "&r");

    public static final Property<List<String>> EXIT_LORE =
            newListProperty(MANAGEMENT_PATH + "exit.lore", " &c&l&oClose ", "");


    @Override
    public void registerComments(CommentsConfiguration conf) {
        String[] pluginHeader = {
                "This section of the config handles the overall guild management gui settings.",
                "This gui is used as an alternative to some commands such as managing members",
                "and creating guild codes, toggling status, etc!",
                "",
                "NOTE: The heads in this GUI are all custom. You can find them via the link below:",
                "https://minecraft-heads.com/",
                "Just find a head, click on it, and scroll down till you see a text-box that says: \"MINECRAFT-URL\",",
                "copy that text box and use that as the material for the item!",

        };
        conf.setComment("guis.guild-management", pluginHeader);
    }
}

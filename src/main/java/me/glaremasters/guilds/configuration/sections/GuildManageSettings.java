package me.glaremasters.guilds.configuration.sections;

import ch.jalu.configme.Comment;
import ch.jalu.configme.SettingsHolder;
import ch.jalu.configme.properties.Property;

import static ch.jalu.configme.properties.PropertyInitializer.newProperty;

/**
 * Created by Glare
 * Date: 4/18/2019
 * Time: 8:54 PM
 */
public class GuildManageSettings implements SettingsHolder {

    private static final String MANAGEMENT_PATH = "guis.guild-management.";

    @Comment("What should the name of the inventory be?")
    public static final Property<String> MANAGEMENT_NAME =
            newProperty(MANAGEMENT_PATH + "gui-name", "Guild Management");

}

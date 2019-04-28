package me.glaremasters.guilds.database.providers;

import me.glaremasters.guilds.database.DatabaseProvider;
import me.glaremasters.guilds.guild.Guild;

import java.io.IOException;
import java.util.List;

/**
 * Created by Glare
 * Date: 4/28/2019
 * Time: 5:17 PM
 */
public class MysqlProvider implements DatabaseProvider {

    @Override
    public List<Guild> loadGuilds() throws IOException {
        return null;
    }

    @Override
    public void saveGuilds(List<Guild> guilds) throws IOException {

    }
}

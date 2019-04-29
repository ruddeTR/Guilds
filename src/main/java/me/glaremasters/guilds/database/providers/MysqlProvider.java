package me.glaremasters.guilds.database.providers;

import lombok.AllArgsConstructor;
import me.glaremasters.guilds.Guilds;
import me.glaremasters.guilds.database.DatabaseProvider;
import me.glaremasters.guilds.database.Queries;
import me.glaremasters.guilds.guild.Guild;
import me.glaremasters.guilds.utils.MySQLUtils;

import java.io.IOException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Glare
 * Date: 4/28/2019
 * Time: 5:17 PM
 */
@AllArgsConstructor
public class MysqlProvider implements DatabaseProvider {

    private Guilds guilds;

    @Override
    public List<Guild> loadGuilds() throws IOException {
        List<Guild> loadedGuilds = new ArrayList<>();
        return loadedGuilds;
    }

    @Override
    public void saveGuilds(List<Guild> guilds) throws IOException {

        for (Guild guild : guilds) {
            try {
                this.guilds.getDb().executeInsert(Queries.ADD_NEW_GUILD, guild.getId().toString(), guild.getName(),
                        guild.getPrefix(), guild.getGuildMaster().getUuid().toString(), MySQLUtils.stringHome(guild),
                        guild.getGuildSkull().getSerialized(), guild.getStatus().name(),
                        guild.getTier().getLevel(), guild.getBalance(), MySQLUtils.stringMembers(guild),
                        MySQLUtils.stringPendingMembers(guild), MySQLUtils.stringAllies(guild), MySQLUtils.stringPendingAllies(guild),
                        MySQLUtils.stringGuildCodes(guild), MySQLUtils.stringGuildVault(guild));
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

    }
}

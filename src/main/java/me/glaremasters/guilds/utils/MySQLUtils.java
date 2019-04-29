package me.glaremasters.guilds.utils;

import co.aikar.idb.DB;
import co.aikar.idb.Database;
import co.aikar.idb.DatabaseOptions;
import co.aikar.idb.HikariPooledDatabase;
import co.aikar.idb.PooledDatabaseOptions;
import lombok.NonNull;
import org.bukkit.plugin.Plugin;

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
}

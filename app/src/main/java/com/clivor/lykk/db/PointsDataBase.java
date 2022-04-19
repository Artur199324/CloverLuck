package com.clivor.lykk.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {Entity.class}, version = 1)
public abstract class PointsDataBase extends RoomDatabase {
    public abstract DaoPoints daoTab();

}

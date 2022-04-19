package com.clivor.lykk.db;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(entities = {EntityCL.class}, version =2 )
public abstract class SaveDataBase extends RoomDatabase {
    public abstract DaoCL daoTab();
}

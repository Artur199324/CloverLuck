package com.clivor.lykk.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

@Dao
public interface DaoCL {

    @Insert
    void entity(EntityCL entityCL);

    @Query("SELECT * FROM saveLincCL ORDER BY ID DESC LIMIT 1")
    EntityCL getLastDao();

    @Query("SELECT COUNT (*) FROM saveLincCL")
    int gethowMuchWeHaveDao();
}

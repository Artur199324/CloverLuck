package com.clivor.lykk.db;

import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.Query;

import java.util.List;

@Dao
public interface DaoPoints {

    @Insert
    void entity(Entity entity);

    @Query("SELECT * FROM savePoints")
    List<Entity> getEntity();


}

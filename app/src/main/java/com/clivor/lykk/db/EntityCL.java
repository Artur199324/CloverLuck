package com.clivor.lykk.db;

import androidx.room.ColumnInfo;
import androidx.room.PrimaryKey;

@androidx.room.Entity(tableName = "saveLincCL")
public class EntityCL {

    @PrimaryKey(autoGenerate = true)
    private int id;

    @ColumnInfo(name = "saveLinc")
    private String saveLinc;

    public EntityCL(String saveLinc) {
        this.saveLinc = saveLinc;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSaveLinc() {
        return saveLinc;
    }

    public void setSaveLinc(String saveLinc) {
        this.saveLinc = saveLinc;
    }
}

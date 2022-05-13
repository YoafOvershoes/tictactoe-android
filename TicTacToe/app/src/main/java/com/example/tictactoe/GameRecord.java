package com.example.tictactoe;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity
public class GameRecord {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "player_name")
    public String playerName;

    @ColumnInfo(name = "record")
    public long record;

    public int getId() {
        return id;
    }

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public long getRecord() {
        return record;
    }

    public void setRecord(long record) {
        this.record = record;
    }
}

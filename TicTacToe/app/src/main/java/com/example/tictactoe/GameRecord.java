package com.example.tictactoe;

import androidx.annotation.NonNull;
import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "game_record")
public class GameRecord {
    @PrimaryKey(autoGenerate = true)
    public int id;

    @ColumnInfo(name = "player_name")
    public String playerName;

    @ColumnInfo(name = "record")
    public int record;

    @ColumnInfo(name = "type")
    public int type;

    public GameRecord(@NonNull String playerName, @NonNull int record, @NonNull int type) {
        this.playerName = playerName;
        this.record = record;
        this.type = type;
    }

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

    public void setRecord(int record) {
        this.record = record;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }
}

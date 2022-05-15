package com.example.tictactoe;

import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecordViewHolder extends RecyclerView.ViewHolder {

    private final TextView recordTime;
    private final ImageView playerType;
    private final TextView playerName;

    public RecordViewHolder(@NonNull View itemView) {
        super(itemView);
        this.recordTime = itemView.findViewById(R.id.recordsViewItem);
        this.playerType = itemView.findViewById(R.id.PlayerTypeViewItem);
        this.playerName = itemView.findViewById(R.id.PlayerNameViewItem);

    }


    static RecordViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new RecordViewHolder(view);
    }

    public void bind(String time, int type, String name) {
        recordTime.setText("TIME: " + time + " Seconds!");
        playerName.setText(name);
        if (type == 0)
            playerType.setImageResource(R.drawable.cross);
        else
            playerType.setImageResource(R.drawable.circle);
    }
}

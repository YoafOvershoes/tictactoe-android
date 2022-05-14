package com.example.tictactoe;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class RecordViewHolder extends RecyclerView.ViewHolder {

    private final TextView recordTime;

    public RecordViewHolder(@NonNull View itemView) {
        super(itemView);;
        this.recordTime = itemView.findViewById(R.id.recordsViewItem);
    }


    static RecordViewHolder create(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_item, parent, false);
        return new RecordViewHolder(view);
    }

    public void bind(String text) {
        recordTime.setText(text);
    }
}

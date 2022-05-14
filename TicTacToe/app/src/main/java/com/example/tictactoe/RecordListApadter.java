package com.example.tictactoe;

import android.icu.text.AlphabeticIndex;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.DiffUtil;
import androidx.recyclerview.widget.ListAdapter;

public class RecordListApadter extends ListAdapter <GameRecord, RecordViewHolder> {
    public RecordListApadter(@NonNull DiffUtil.ItemCallback<GameRecord> diffCallback) {
        super(diffCallback);
    }

    @Override
    public RecordViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        return RecordViewHolder.create(parent);
    }

    @Override
    public void onBindViewHolder(RecordViewHolder holder, int position) {
        GameRecord current = getItem(position);
        holder.bind(String.valueOf(current.getRecord()));
    }

    static class RecordDiff extends DiffUtil.ItemCallback<GameRecord> {

        @Override
        public boolean areItemsTheSame(@NonNull GameRecord oldItem, @NonNull GameRecord newItem) {
            return oldItem == newItem;
        }

        @Override
        public boolean areContentsTheSame(@NonNull GameRecord oldItem, @NonNull GameRecord newItem) {
            return oldItem.getRecord() == newItem.getRecord() && oldItem.getPlayerName().equals(newItem.getPlayerName());
        }
    }

}

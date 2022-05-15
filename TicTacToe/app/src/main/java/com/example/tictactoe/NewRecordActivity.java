package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

public class NewRecordActivity extends AppCompatActivity {

    public static final String EXTRA_REPLY = "com.example.android.game_record_database.REPLY";

    private RecordViewModel recordViewModel;

    private EditText mEditNameView;
    private TextView timeRecordView;
    private ImageView playerTypeView;

    private int time;
    private int playerType;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_record);

        recordViewModel = new ViewModelProvider(this).get(RecordViewModel.class);

        time = getIntent().getIntExtra("time", -1);
        playerType = getIntent().getIntExtra("player_type", 0);

        timeRecordView = findViewById(R.id.newRecordViewItem);
        timeRecordView.setText(""+time);
        playerTypeView = findViewById(R.id.PlayerTypeViewItem);

        if (playerType == 0)
            playerTypeView.setImageResource(R.drawable.cross);
        else
            playerTypeView.setImageResource(R.drawable.circle);


        mEditNameView = findViewById(R.id.PlayerNameViewItem);

        final Button button = findViewById(R.id.button_save);
        button.setOnClickListener(view -> {
            Intent replyIntent = new Intent();
            if (TextUtils.isEmpty(mEditNameView.getText())) {
                setResult(RESULT_CANCELED, replyIntent);
            } else {
                String playerName = mEditNameView.getText().toString();
                recordViewModel.insert(new GameRecord(playerName, time, playerType));
                replyIntent.putExtra(EXTRA_REPLY, playerName);
//                replyIntent.putExtra("game_time", time);
//                replyIntent.putExtra("player_type", playerType);
                setResult(RESULT_OK, replyIntent);
            }
            Intent recordsIntent = new Intent(this, GameRecordsActivity.class);
            startActivity(recordsIntent);
            finish();
        });
    }
}
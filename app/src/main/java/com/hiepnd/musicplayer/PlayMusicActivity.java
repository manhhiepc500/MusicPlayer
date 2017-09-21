package com.hiepnd.musicplayer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.ThemedSpinnerAdapter;
import android.widget.TextView;

public class PlayMusicActivity extends AppCompatActivity {
    TextView tvDuration;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_play_music);
        Intent intent=getIntent();

        tvDuration = (TextView) findViewById(R.id.tvDuration);

        setTitle(intent.getStringExtra("MusicName"));
        tvDuration.setText(intent.getStringExtra("Duration"));
    }
}

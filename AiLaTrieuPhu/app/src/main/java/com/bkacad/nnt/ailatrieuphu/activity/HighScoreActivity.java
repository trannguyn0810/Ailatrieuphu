package com.bkacad.nnt.ailatrieuphu.activity;

import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ListAdapter;
import android.widget.ListView;

import androidx.appcompat.app.AppCompatActivity;

import com.bkacad.nnt.ailatrieuphu.App;
import com.bkacad.nnt.ailatrieuphu.R;
import com.bkacad.nnt.ailatrieuphu.adapter.HighScoreAdapter;
import com.bkacad.nnt.ailatrieuphu.manage.DatabaseManager;

public class HighScoreActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_high_score);

        DatabaseManager databaseManager = new DatabaseManager(App.getContext());
        ListView listView = findViewById(R.id.lv_list);
        listView.setAdapter((ListAdapter) new HighScoreAdapter(databaseManager.getHighScore()));
    }

    @Override
    protected void onPause() {
        super.onPause();
        App.getMusicPlayer().pauseBgMusic();
    }

    @Override
    protected void onResume() {
        super.onResume();
        App.getMusicPlayer().resumeBgMusic();

    }
}

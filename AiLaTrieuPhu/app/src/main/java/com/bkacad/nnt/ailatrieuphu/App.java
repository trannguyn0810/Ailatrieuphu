package com.bkacad.nnt.ailatrieuphu;

import android.app.Application;
import android.content.Context;

import com.bkacad.nnt.ailatrieuphu.manage.MusicManager;

public class App extends Application {
    private static Context context;
    private static MusicManager musicPlayer;

    @Override
    public void onCreate() {
        super.onCreate();
        context = this;
        musicPlayer = new MusicManager(this);
    }

    public static MusicManager getMusicPlayer(){
        return musicPlayer;
    }

    public static Context getContext() {
        return context;
    }
}


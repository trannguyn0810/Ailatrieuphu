package com.bkacad.nnt.ailatrieuphu.activity;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bkacad.nnt.ailatrieuphu.App;
import com.bkacad.nnt.ailatrieuphu.R;
import com.bkacad.nnt.ailatrieuphu.dialogs.NoticeDialog;
import com.bkacad.nnt.ailatrieuphu.fragments.HomeFragment;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponents();
    }

    private void initComponents() {
        Animation animation = AnimationUtils.loadAnimation(this, R.anim.bg_circle_rotate);
        animation.setDuration(3000);

        ImageView loadImageView = findViewById(R.id.load);
        loadImageView.startAnimation(animation);

        getSupportFragmentManager().beginTransaction()
                .setCustomAnimations(R.anim.fade_in, R.anim.fade_out)
                .replace(R.id.frame_main, new HomeFragment())
                .commit();
    }

    @Override
    public void onBackPressed() {
        final NoticeDialog noticeDialog = new NoticeDialog(this);
        noticeDialog.setCancelable(true);
        noticeDialog.setNotification("Bạn muốn thoát trò chơi ?", "Đồng ý", "Hủy", new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (v.getId() == R.id.btn_ok) {
                    App.getMusicPlayer().stopBgMusic();
                    finish();
                }
                noticeDialog.dismiss();
            }
        });
        noticeDialog.show();
        super.onBackPressed();
    }
}
package com.bkacad.nnt.ailatrieuphu.dialogs;

import android.app.Dialog;
import android.content.Context;
import android.graphics.drawable.ColorDrawable;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.bkacad.nnt.ailatrieuphu.App;
import com.bkacad.nnt.ailatrieuphu.R;

public class CallDialog extends Dialog implements View.OnClickListener {
    private ImageButton btnHelpCall[];
    private TextView tvAnswer;
    private ConstraintLayout answerLayout, callLayout[];
    private ConstraintLayout callsLayout;


    private String trueAnswer;

    public CallDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setCanceledOnTouchOutside(false);
        setCancelable(false);
        setContentView(R.layout.call_dialog);

        answerLayout = findViewById(R.id.ln_answer);
        callsLayout = findViewById(R.id.rl_calls);

        callLayout = new ConstraintLayout[4];
        callLayout[0] = findViewById(R.id.ln_call_01);
        callLayout[1] = findViewById(R.id.ln_call_02);
        callLayout[2] = findViewById(R.id.ln_call_03);
        callLayout[3] = findViewById(R.id.ln_call_04);

        tvAnswer = findViewById(R.id.tv_answer);

        btnHelpCall = new ImageButton[4];
        btnHelpCall[0] = findViewById(R.id.btn_help_01);
        btnHelpCall[1] = findViewById(R.id.btn_help_02);
        btnHelpCall[2] = findViewById(R.id.btn_help_03);
        btnHelpCall[3] = findViewById(R.id.btn_help_04);

        btnHelpCall[0].setOnClickListener(this);
        btnHelpCall[1].setOnClickListener(this);
        btnHelpCall[2].setOnClickListener(this);
        btnHelpCall[3].setOnClickListener(this);
        findViewById(R.id.btn_close).setOnClickListener(this);

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setLayout(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.MATCH_PARENT);
        getWindow().setBackgroundDrawable(new ColorDrawable(android.graphics.Color.TRANSPARENT));
    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btn_help_01) {
            getAnswer(0);
        } else if (v.getId() == R.id.btn_help_02) {
            getAnswer(1);
        } else if (v.getId() == R.id.btn_help_03) {
            getAnswer(2);
        } else if (v.getId() == R.id.btn_help_04) {
            getAnswer(3);
        } else if (v.getId() == R.id.btn_close) {
            dismiss();
        }
    }

    private void getAnswer(final int index) {
        btnHelpCall[0].setEnabled(false);
        btnHelpCall[1].setEnabled(false);
        btnHelpCall[2].setEnabled(false);
        btnHelpCall[3].setEnabled(false);
        App.getMusicPlayer().play(R.raw.call, new MediaPlayer.OnCompletionListener() {
            @Override
            public void onCompletion(MediaPlayer mp) {
                callsLayout.removeAllViews();
                callsLayout.addView(answerLayout);
                answerLayout.setVisibility(View.VISIBLE);
                answerLayout.addView(callLayout[index], 0);
            }
        });
    }

    public void setTrueAnswer(int trueAnswer) {
        if (trueAnswer == 1) {
            this.trueAnswer = "A";
        } else if (trueAnswer == 2) {
            this.trueAnswer = "B";
        } else if (trueAnswer == 3) {
            this.trueAnswer = "C";
        } else {
            this.trueAnswer = "D";
        }
        tvAnswer.setText("Theo tôi đáp án đúng là " + this.trueAnswer);
    }
}




package com.bkacad.nnt.ailatrieuphu.dialogs;

import android.app.Dialog;
import android.content.ContentValues;
import android.content.Context;
import android.view.View;
import android.view.Window;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.bkacad.nnt.ailatrieuphu.App;
import com.bkacad.nnt.ailatrieuphu.R;

import com.bkacad.nnt.ailatrieuphu.manage.DatabaseManager;
public class ScoreDialog extends Dialog implements View.OnClickListener {
    private int score;
    private EditText edtName;
    private TextView tvScore;

    public ScoreDialog(Context context) {
        super(context);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.score_dialog);
        getWindow().setLayout(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);

        edtName = findViewById(R.id.edt_name);
        tvScore = findViewById(R.id.tv_score);
        findViewById(R.id.btn_ok).setOnClickListener(this);

    }

    public void setScore(String score) {
        tvScore.setText(score + " VNĐ");
        this.score = Integer.parseInt(score.replaceAll(",", ""));
    }

    @Override
    public void onClick(View v) {
        if(v.getId() == R.id.btn_ok){
            if (edtName.getText().toString().isEmpty()) {
                return;
            }
            DatabaseManager databaseManager = new DatabaseManager(App.getContext());
            ContentValues values = new ContentValues();
            values.put("Name", edtName.getText().toString().trim());
            values.put("Score", score);
            databaseManager.insert("HighScore", values);
            dismiss();
        }
    }
}


package com.example.quizplay;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.mikhaellopez.circularprogressbar.CircularProgressBar;

public class WonActivity extends AppCompatActivity {

      CircularProgressBar circularProgressBar;
      TextView resulttext;
      int correct,wrong;
      LinearLayout btnshare;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_won);

        correct=getIntent().getIntExtra("correct",0);
        wrong=getIntent().getIntExtra("wrong",0);

        circularProgressBar=findViewById(R.id.circularProgressBar);
        resulttext=findViewById(R.id.resultview);
        btnshare=findViewById(R.id.btn_share);

        circularProgressBar.setProgress(correct);
        resulttext.setText(correct+"/20");

        btnshare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    Intent ShareIntent=new Intent(Intent.ACTION_SEND);
                    ShareIntent.setType("text/plain");
                    ShareIntent.putExtra(Intent.EXTRA_SUBJECT,"QuizPlay");
                    String shareMessage="\ni got "+correct+" out of 20 Question";
//                  google play agr future me try kiya to
                    ShareIntent.putExtra(Intent.EXTRA_TEXT,shareMessage);
                    startActivity(Intent.createChooser(ShareIntent, "choose"));

                }
                catch (Exception e){

                }
            }
        });
    }
}
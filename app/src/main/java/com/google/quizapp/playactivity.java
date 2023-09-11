package com.google.quizapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class playactivity extends AppCompatActivity {
    String[] questionlist={"Which year was the G-20 Summit first held?","Which country hosted the first G-20 Summit?","Which of the following is not an objective of the G-20 Summit?"
            ,"How often is the G-20 Summit held?"};
    String[] chooselist={"A- 1997","B- 2001 ","C- 2003 ","D- 2008",
            "A- Canada ","B- United States","C- United Kingdom","D- Germany"
            ,"A- Promoting global economic growth  "," B- Enhancing financial regulation","C- Improving international trade relations","D- Promoting religious harmony"
            ,"A- Annually","B- Biennially"," C- Triennially"," D- Quadrennially"};
    String[] correctlist={"D- 2008","C- United Kingdom","D- Promoting religious harmony","A- Annually"};

    TextView cpt_question,text_question;
    Button btnchoose1,btnchoose2,btnchoose3,btnchoose4,btnnext;
    int currentque = 0 ;
    boolean isclickbtn = false;
    String valuechoose="";
    Button btnclick;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_playactivity);
        cpt_question=findViewById(R.id.cpt_question);
        text_question=findViewById(R.id.text_question);
        btnchoose1=findViewById(R.id.choose1);
        btnchoose2=findViewById(R.id.choose2);
        btnchoose3=findViewById(R.id.choose3);
        btnchoose4=findViewById(R.id.choose4);
        btnnext=findViewById(R.id.next);

        findViewById(R.id.arrowback).setOnClickListener(
                a-> finish()
        );

        remplirData();
        btnnext.setOnClickListener(
                v -> {

                    if(isclickbtn){

                        isclickbtn = false;
                        if(valuechoose.equals(correctlist[currentque]))
                        {
                            Toast.makeText(playactivity.this, "correct", Toast.LENGTH_LONG).show();
                            btnclick.setBackgroundResource(R.drawable.bakgroundgreen);

                        } else
                        {
                            Toast.makeText(playactivity.this, "wrong", Toast.LENGTH_LONG).show();
                            btnclick.setBackgroundResource(R.drawable.backgroundcolour);

                        }
                        new Handler().postDelayed(() -> {
                            if(currentque!=questionlist.length-1) {
                                currentque = currentque + 1;
                                remplirData();
                                valuechoose ="";
                                btnchoose1.setBackgroundResource(R.drawable.background);
                                btnchoose2.setBackgroundResource(R.drawable.background);
                                btnchoose3.setBackgroundResource(R.drawable.background);
                                btnchoose4.setBackgroundResource(R.drawable.background);
                            }
                            else {
                                finish();
                            }
                        },2000);

                    }
                    else {
                        Toast.makeText(playactivity.this ,  "please select an option",Toast.LENGTH_LONG).show();
                    }

                }
        );



    }
    void remplirData(){

        cpt_question.setText((currentque+1) + "/" + questionlist.length );
        text_question.setText(questionlist[currentque]);
        btnchoose1.setText(chooselist[4*currentque]);
        btnchoose2.setText(chooselist[4*currentque+1]);
        btnchoose3.setText(chooselist[4*currentque+2]);
        btnchoose4.setText(chooselist[4*currentque+3]);
    }

    public void clickchoose(View view) {

        btnclick=(Button)view;
        if(isclickbtn){
            btnchoose1.setBackgroundResource(R.drawable.background);
            btnchoose2.setBackgroundResource(R.drawable.background);
            btnchoose3.setBackgroundResource(R.drawable.background);
            btnchoose4.setBackgroundResource(R.drawable.background);
        }
        chooseBtn();

    }
     void chooseBtn(){

        btnclick.setBackgroundResource(R.drawable.backgroundbtncolour);
        isclickbtn = true;
        valuechoose = btnclick.getText().toString();
    }
}

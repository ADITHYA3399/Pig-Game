package com.example.piggame;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {
    int randomNum, flag;
    int currVal1 = 0, currVal2 = 0, scoreVal1 = 0, scoreVal2 = 0;
    ImageView newgame, roll, hold;
    TextView score1, curr1, score2, curr2, pointer1, pointer2;
    LinearLayout ll1, ll2;
    VideoView vview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flag = 1;
        newgame = findViewById(R.id.newgame);
        roll = findViewById(R.id.roll);
        hold = findViewById(R.id.hold);
        score1 = findViewById(R.id.score1);
        curr1 = findViewById(R.id.curr1);
        score2 = findViewById(R.id.score2);
        curr2 = findViewById(R.id.curr2);

        ll1 = findViewById(R.id.ll1);
        ll2 = findViewById(R.id.ll2);

        pointer1 = findViewById(R.id.pointer1);
        pointer2 = findViewById(R.id.pointer2);

        roll.setClipToOutline(true);

        //vview = findViewById(R.id.vview);
    }


    public void newgame(View view) {
        score1.setText("0");
        curr1.setText("0");
        score2.setText("0");
        curr2.setText("0");
        scoreVal1 = 0;
        scoreVal2 = 0;
        currVal1 = 0;
        currVal2 = 0;
    }

    public void hold(View view) {
        if(flag == 1) {
            pointer2.setBackgroundResource(R.drawable.pointer);
            pointer1.setBackgroundResource(0);
            scoreVal1 += currVal1;
            score1.setText(Integer.toString(scoreVal1));
            curr1.setText("0");
            currVal1 = 0;
            flag = 2;
        }
        else if(flag == 2) {
            pointer2.setBackgroundResource(0);
            pointer1.setBackgroundResource(R.drawable.pointer);
            scoreVal2 += currVal2;
            score2.setText(Integer.toString(scoreVal2));
            curr2.setText("0");
            currVal2 = 0;
            flag = 1;
        }

        if(scoreVal1 >= 100){
            /*String path = "android.resource://" + getPackageName() + "/" + R.raw.party;
            vview.setVideoURI(Uri.parse(path));
            vview.start();*/
            Toast.makeText(getApplicationContext(),"PLAYER-01 WON 🎉🎉",Toast.LENGTH_LONG).show();
            //newgame(view);
        }
        else if (scoreVal2 >= 100){
            /*String path = "android.resource://" + getPackageName() + "/" + R.raw.party;
            vview.setVideoURI(Uri.parse(path));
            vview.start();*/
            Toast.makeText(getApplicationContext(),"PLAYER-02 WON 🎉🎉",Toast.LENGTH_LONG).show();
            //newgame(view);

        }

    }

    public void rolldice(View view) {
        roll = findViewById(R.id.roll);

        Animation anim = android.view.animation.AnimationUtils.loadAnimation(roll.getContext(), R.anim.shake);
        anim.setDuration(50L);
        roll.startAnimation(anim);

        randomNum = (int) (Math.random() * 6) + 1;
        switch (randomNum){
            case 1:
                hold.setEnabled(true);
                roll.setImageResource(R.mipmap.dices);
                if(flag == 1){
                    currVal1 += 1;
                    curr1.setText(Integer.toString(currVal1));
                }
                else if(flag == 2){
                    currVal2 += 1;
                    curr2.setText(Integer.toString(currVal2));
                }
                break;
            case 2:
                hold.setEnabled(true);
                roll.setImageResource(R.mipmap.dicess);
                if(flag == 1){
                    currVal1 += 2;
                    curr1.setText(Integer.toString(currVal1));
                }
                else if(flag == 2){
                    currVal2 += 2;
                    curr2.setText(Integer.toString(currVal2));
                }
                break;
            case 3:
                hold.setEnabled(true);
                roll.setImageResource(R.mipmap.dicesss);
                if(flag == 1){
                    currVal1 += 3;
                    curr1.setText(Integer.toString(currVal1));
                }
                else if(flag == 2){
                    currVal2 += 3;
                    curr2.setText(Integer.toString(currVal2));
                }
                break;
            case 4:
                hold.setEnabled(true);
                roll.setImageResource(R.mipmap.dicessss);
                if(flag == 1){
                    currVal1 += 4;
                    curr1.setText(Integer.toString(currVal1));
                }
                else if(flag == 2){
                    currVal2 += 4;
                    curr2.setText(Integer.toString(currVal2));
                }
                break;
            case 5:
                hold.setEnabled(true);
                roll.setImageResource(R.mipmap.dicesssss);
                if(flag == 1){
                    currVal1 += 5;
                    curr1.setText(Integer.toString(currVal1));
                }
                else if(flag == 2){
                    currVal2 += 5;
                    curr2.setText(Integer.toString(currVal2));
                }
                break;
            case 6:
                roll.setImageResource(R.mipmap.dicessssss);
                if(flag == 1){
                    pointer2.setBackgroundResource(R.drawable.pointer);
                    pointer1.setBackgroundResource(0);
                    currVal1 = 0;
                    curr1.setText(Integer.toString(currVal1));
                    flag = 2;
                    hold.setEnabled(false);
                }
                else if(flag == 2){
                    pointer2.setBackgroundResource(0);
                    pointer1.setBackgroundResource(R.drawable.pointer);
                    currVal2 = 0;
                    curr2.setText(Integer.toString(currVal2));
                    flag = 1;
                    hold.setEnabled(false);
                }
                break;
            default:
                roll.setImageResource(R.mipmap.dicess);
                break;

        }
    }
}
package com.example.memorymatch;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

public class HighScore_Board extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.highscore_board);

        TextView high_easy = (TextView) findViewById(R.id.textView8);
        TextView high_hard = (TextView) findViewById(R.id.textView9);
        TextView high_2p = (TextView) findViewById(R.id.textView10);

        //high score Easy
        SharedPreferences preferencesEasy = getSharedPreferences("EASY", 0);
        int lastTimeEasy = preferencesEasy.getInt("lastTimeEasy", 0);
        int bestEasy = preferencesEasy.getInt("bestEasy", 0);

        if(lastTimeEasy < bestEasy) {
            bestEasy = lastTimeEasy;
            SharedPreferences.Editor editor = preferencesEasy.edit();
            editor.putInt("bestEasy", bestEasy);
            editor.apply();
            high_easy.setText("00:" + bestEasy);
        } else {
            if(bestEasy == 0) {
                high_easy.setText("00:" + lastTimeEasy);
            } else {
                high_easy.setText("00:" + bestEasy);
            }
        }

        //high score hard
        SharedPreferences preferencesHard = getSharedPreferences("HARD", 0);
        int lastTimeHard = preferencesHard.getInt("lastTimeHard", 0);
        int bestHard = preferencesHard.getInt("bestHard", 0);

        System.out.println(lastTimeHard);

        if(lastTimeHard < bestHard) {
            bestHard = lastTimeHard;
            SharedPreferences.Editor editor = preferencesHard.edit();
            editor.putInt("bestHard", bestHard);
            editor.apply();
            System.out.println(bestHard);
            high_hard.setText("00:" + bestHard);
        } else {
            if(bestHard == 0) {
                high_hard.setText("00:" + lastTimeHard);
            } else {
                high_hard.setText("00:" + bestHard);
            }
            System.out.println(bestHard);
        }

        //High Score 2 Player
        //load old scores
        SharedPreferences preferences = getSharedPreferences("PREFS", 0);
        int lastScore = preferences.getInt("lastScore", 0);
        int best = preferences.getInt("best", 0);

        if(lastScore > best) {
            best = lastScore;
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best", best);
            editor.apply();
        } else {
            SharedPreferences.Editor editor = preferences.edit();
            editor.putInt("best", best);
            editor.apply();
        }

        high_2p.setText(best + " points");

    }

}
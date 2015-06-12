package com.example.tazzie.intervaleartraining;

import android.app.Activity;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.NumberPicker;
import android.widget.Toast;


public class MainActivity extends ActionBarActivity implements NumberPicker.OnValueChangeListener{
    private Button start_button, practice_button, song_button;
    private int level;
    private int round_num, correct_num, attempt_num;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        NumberPicker np1 = (NumberPicker) findViewById(R.id.numberPicker);
        String[] num = new String[5];
        for(int i=0; i<5; i++)
            num[i] = Integer.toString(i + 1);

        np1.setMinValue(1);
        np1.setMaxValue(5);
        np1.setWrapSelectorWheel(true);
        np1.setDisplayedValues(num);
        np1.setOnValueChangedListener(this);

        try{
            Intent intent = getIntent();
            level = intent.getIntExtra("level", 1);
            round_num = intent.getIntExtra("round_num", 0);
            correct_num = intent.getIntExtra("correct_num", 0);
            attempt_num = intent.getIntExtra("attempt_num", 0);
        }
        catch(Exception e){
            level = 1;
            round_num = 0;
            correct_num = 0;
            attempt_num = 0;
        }

        start_button = (Button) findViewById(R.id.start_button);
        start_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,GameActivity.class);
                intent.putExtra("level", level);
                intent.putExtra("attempt_num", attempt_num);
                intent.putExtra("correct_num", correct_num);
                intent.putExtra("round_num", round_num);
                // prevents new stacks of activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Level: " + level, Toast.LENGTH_LONG).show();
            }
        });

        practice_button = (Button) findViewById(R.id.practice_button);
        practice_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PracticeActivity.class);
                intent.putExtra("level", level);
                intent.putExtra("attempt_num", attempt_num);
                intent.putExtra("correct_num", correct_num);
                intent.putExtra("round_num", round_num);
                // prevents new stacks of activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
                Toast.makeText(getApplicationContext(), "Level: " + level, Toast.LENGTH_LONG).show();
            }
        });

        song_button = (Button) findViewById(R.id.songlist_button);
        song_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SongActivity.class);
                // prevents new stacks of activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
    }

    public void onValueChange(NumberPicker picker, int oldVal, int newVal) {
        level = picker.getValue();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
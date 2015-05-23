package com.example.tazzie.intervaleartraining;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.NumberPicker;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.HashMap;

public class GameActivity extends ActionBarActivity {
    private TextView title_page, scoreText, result;
    private ProgressBar sound_progress;
    private Button sound_button, unison_button, minor2_button, major2_button,
            minor3_button, major3_button, perfect4_button,
            perfect5_button, minor6_button, major6_button, minor7_button,
            major7_button, octave_button, rev_ans_button, level_button;
    private Context context;
    private int score, total, level;
    private HashMap<MediaPlayer, String> mPlayerHash;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.game_layout);
        try{
            Intent intent = getIntent();
            level = intent.getIntExtra("level", 0);
        }
        catch(Exception e){
            level = 1;
        }

        Toast.makeText(getApplicationContext(), level+" GAMEACTIVITY", Toast.LENGTH_LONG).show();
        level_button = (Button) findViewById(R.id.level_button);
        level_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(GameActivity.this,MainActivity.class);
                // prevents new stacks of activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        setButtonsVisible(level);
    }


    private void setButtonsVisible(int level){
        /*
        * lv1: Perfect 4th
        *      Perfect 5th
        *      Unison
        *
        * lv2: Major 2nd
        *      Major 3rd
        *
        * lv3: Major 6th
        *      Major 7th
        *      Octave
        *
        * lv4: Minor 2nd
        *      Minor 3rd
        *
        * lv5: Minor 6th
        *      Minor 7th
        *      Augmented 4th(Tritone)
        * */

        level_button = (Button) findViewById(R.id.level_button);
        sound_button = (Button) findViewById(R.id.sound_button);

        if(level >= 1){
            unison_button = (Button) findViewById(R.id.unison_button);
            unison_button.setVisibility(View.VISIBLE);
            final MediaPlayer mPlayer_unison = MediaPlayer.create(this, R.raw.c_unison);
            unison_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlayer_unison.start();
                }
            });

            // Change id of this button in the xml file to perfect4_button
            perfect4_button = (Button) findViewById(R.id.perfect4_button);
            perfect4_button.setVisibility(View.VISIBLE);
            final MediaPlayer mPlayer_perfect4 = MediaPlayer.create(this, R.raw.c_perfect4);
            perfect4_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlayer_perfect4.start();
                }
            });

            perfect5_button = (Button) findViewById(R.id.perfect5_button);
            perfect5_button.setVisibility(View.VISIBLE);
            final MediaPlayer mPlayer_perfect5 = MediaPlayer.create(this, R.raw.c_perfect5);
            perfect5_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlayer_perfect5.start();
                }
            });
        }

        if(level >= 2){
            major2_button = (Button) findViewById(R.id.major2_button);
            major2_button.setVisibility(View.VISIBLE);
            final MediaPlayer mPlayer_major2 = MediaPlayer.create(this, R.raw.c_major2);
            major2_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlayer_major2.start();
                }
            });

            major3_button = (Button) findViewById(R.id.major3_button);
            major3_button.setVisibility(View.VISIBLE);
            final MediaPlayer mPlayer_major3 = MediaPlayer.create(this, R.raw.c_major3);
            major3_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlayer_major3.start();
                }
            });
        }

        if(level >= 3){
            major6_button = (Button) findViewById(R.id.major6_button);
            major6_button.setVisibility(View.VISIBLE);
            final MediaPlayer mPlayer_major6 = MediaPlayer.create(this, R.raw.c_major6);
            major6_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlayer_major6.start();
                }
            });

            major7_button = (Button) findViewById(R.id.major7_button);
            major7_button.setVisibility(View.VISIBLE);
            final MediaPlayer mPlayer_major7 = MediaPlayer.create(this, R.raw.c_major7);
            major7_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlayer_major7.start();
                }
            });

            octave_button = (Button) findViewById(R.id.octave_button);
            octave_button.setVisibility(View.VISIBLE);
            final MediaPlayer mPlayer_octave = MediaPlayer.create(this, R.raw.c_octave);
            octave_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlayer_octave.start();
                }
            });
        }

        if(level >= 4){
            minor2_button = (Button) findViewById(R.id.minor2_button);
            minor2_button.setVisibility(View.VISIBLE);
            final MediaPlayer mPlayer_minor2 = MediaPlayer.create(this, R.raw.c_minor2);
            minor2_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlayer_minor2.start();
                }
            });

            minor3_button = (Button) findViewById(R.id.minor3_button);
            minor3_button.setVisibility(View.VISIBLE);
            final MediaPlayer mPlayer_minor3 = MediaPlayer.create(this, R.raw.c_minor3);
            minor3_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlayer_minor3.start();
                }
            });
        }

        if(level >= 5){
            minor6_button = (Button) findViewById(R.id.minor6_button);
            minor6_button.setVisibility(View.VISIBLE);
            final MediaPlayer mPlayer_minor6 = MediaPlayer.create(this, R.raw.c_minor6);
            minor6_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlayer_minor6.start();
                }
            });

            minor7_button = (Button) findViewById(R.id.minor7_button);
            minor7_button.setVisibility(View.VISIBLE);
            final MediaPlayer mPlayer_minor7 = MediaPlayer.create(this, R.raw.c_minor7);
            minor7_button.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    mPlayer_minor7.start();
                }
            });
        }
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

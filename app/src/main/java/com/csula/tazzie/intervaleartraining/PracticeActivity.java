package com.csula.tazzie.intervaleartraining;

import android.content.Context;
import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.HashMap;

public class PracticeActivity extends ActionBarActivity {

    private final int max_interval = 13;
    private boolean[] available_interval = new boolean[max_interval];
    private Button unison_button, minor2_button, major2_button,
            minor3_button, major3_button, perfect4_button, tritone_button,
            perfect5_button, minor6_button, major6_button, minor7_button,
            major7_button, octave_button, main_menu;
    private Context context;
    private int score, total, level;
    private HashMap<Integer, MediaPlayer> mPlayerHash;
    private HashMap<Integer, Button> buttonHash;
    private HashMap<Integer, String> buttonTextHash;
    private MediaPlayer mPlayerNote1, mPlayerNote2;
    private int answer_value, round_num, correct_num, attempt_num;

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        context = this;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.practice_layout);

        Toast.makeText(getApplicationContext(), level + " PRACTICEACTIVITY", Toast.LENGTH_LONG).show();

        hashSounds();
        unison_button = (Button) findViewById(R.id.unison_button);
        unison_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 0 = unison
                playSounds(mPlayerHash.get(0), mPlayerHash.get(0));
            }
        });


        perfect4_button = (Button) findViewById(R.id.perfect4_button);
        perfect4_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 5 = perfect 4th
                playSounds(mPlayerHash.get(0), mPlayerHash.get(5));
            }
        });



        perfect5_button = (Button) findViewById(R.id.perfect5_button);
        perfect5_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 7 = perfect 5th
                playSounds(mPlayerHash.get(0), mPlayerHash.get(7));
            }
        });



        major2_button = (Button) findViewById(R.id.major2_button);
        major2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 2 = major 2nd
                playSounds(mPlayerHash.get(0), mPlayerHash.get(2));
            }
        });



        major3_button = (Button) findViewById(R.id.major3_button);
        major3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 4 = major 3rd
                playSounds(mPlayerHash.get(0), mPlayerHash.get(4));
            }
        });


        major6_button = (Button) findViewById(R.id.major6_button);
        major6_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 9 = major 6th
                playSounds(mPlayerHash.get(0), mPlayerHash.get(9));
            }
        });



        major7_button = (Button) findViewById(R.id.major7_button);
        major7_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 11 = major 7th
                playSounds(mPlayerHash.get(0), mPlayerHash.get(11));
            }
        });



        octave_button = (Button) findViewById(R.id.octave_button);
        octave_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 12 = octave
                playSounds(mPlayerHash.get(0), mPlayerHash.get(12));
            }
        });



        minor2_button = (Button) findViewById(R.id.minor2_button);
        minor2_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 1 = minor 2nd
                playSounds(mPlayerHash.get(0), mPlayerHash.get(1));
            }
        });



        minor3_button = (Button) findViewById(R.id.minor3_button);
        minor3_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 3 = minor 3rd
                playSounds(mPlayerHash.get(0), mPlayerHash.get(3));
            }
        });

        tritone_button = (Button) findViewById(R.id.tritone_button);
        tritone_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 6 = tritone
                playSounds(mPlayerHash.get(0), mPlayerHash.get(6));
            }
        });

        minor6_button = (Button) findViewById(R.id.minor6_button);
        minor6_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 8 = minor 6th
                playSounds(mPlayerHash.get(0), mPlayerHash.get(8));
            }
        });


        minor7_button = (Button) findViewById(R.id.minor7_button);
        minor7_button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 10 = minor 7th
                playSounds(mPlayerHash.get(0), mPlayerHash.get(10));
            }
        });

        main_menu = (Button) findViewById(R.id.rev_ans);
        main_menu.setOnClickListener (new View.OnClickListener() {
            public void onClick(View v) {
                Intent i = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(i);
            }
        });
    }

    public void playSounds(MediaPlayer media1, MediaPlayer media2){
        media1.start();
        while (media1.isPlaying()) {
            // do nothing and wait
        }
        media2.start();
        while (media2.isPlaying()) {
            // do nothing and wait
        }
    }

    public void hashSounds() {
        int number = 0;
        mPlayerHash = new HashMap<Integer, MediaPlayer>();
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.c4));
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.c_sharp4));
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.d4));
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.d_sharp4));
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.e4));
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.f4));
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.f_sharp4));
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.g4));
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.g_sharp4));
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.a4));
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.a_sharp4));
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.b4));
        mPlayerHash.put(number++, MediaPlayer.create(this, R.raw.c5));
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
package com.example.tazzie.intervaleartraining;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;


public class MainActivity extends ActionBarActivity {
    private TextView score, result;
    private ProgressBar sound_progress;
    private Button sound_button, unison_button, minor2_button, major2_button,
            minor3_button, major3_button, perfect4_button,
            perfect5_button, minor6_button, major6_button, minor7_button,
            major_7button, octave_button, rev_ans_button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        setMajor2_button(major2_button);
        setContentView(R.layout.activity_main);
    }

    public TextView getScore() {
        return score;
    }

    public void setScore(TextView score) {
        this.score = score;
    }

    public TextView getResult() {
        return result;
    }

    public void setResult(TextView result) {
        this.result = result;
    }

    public ProgressBar getSound_progress() {
        return sound_progress;
    }

    public void setSound_progress(ProgressBar sound_progress) {
        this.sound_progress = sound_progress;
    }

    public Button getSound_button() {
        return sound_button;
    }

    public void setSound_button(Button sound_button) {
        this.sound_button = sound_button;
    }

    public Button getUnison_button() {
        return unison_button;
    }

    public void setUnison_button(Button unison_button) {
        this.unison_button = unison_button;
    }

    public Button getMinor2_button() {
        return minor2_button;
    }

    public void setMinor2_button(Button minor2_button) {
        this.minor2_button = minor2_button;
    }

    public Button getMajor2_button() {
        return major2_button;
    }

    public void setMajor2_button(Button major2_button) {
        this.major2_button = major2_button;
    }

    public Button getMinor3_button() {
        return minor3_button;
    }

    public void setMinor3_button(Button minor3_button) {
        this.minor3_button = minor3_button;
    }

    public Button getMajor3_button() {
        return major3_button;
    }

    public void setMajor3_button(Button major3_button) {
        this.major3_button = major3_button;
    }

    public Button getPerfect4_button() {
        return perfect4_button;
    }

    public void setPerfect4_button(Button perfect4_button) {
        this.perfect4_button = perfect4_button;
    }

    public Button getPerfect5_button() {
        return perfect5_button;
    }

    public void setPerfect5_button(Button perfect5_button) {
        this.perfect5_button = perfect5_button;
    }

    public Button getMinor6_button() {
        return minor6_button;
    }

    public void setMinor6_button(Button minor6_button) {
        this.minor6_button = minor6_button;
    }

    public Button getMajor6_button() {
        return major6_button;
    }

    public void setMajor6_button(Button major6_button) {
        this.major6_button = major6_button;
    }

    public Button getMinor7_button() {
        return minor7_button;
    }

    public void setMinor7_button(Button minor7_button) {
        this.minor7_button = minor7_button;
    }

    public Button getMajor_7button() {
        return major_7button;
    }

    public void setMajor_7button(Button major_7button) {
        this.major_7button = major_7button;
    }

    public Button getOctave_button() {
        return octave_button;
    }

    public void setOctave_button(Button octave_button) {
        this.octave_button = octave_button;
    }

    public Button getRev_ans_button() {
        return rev_ans_button;
    }

    public void setRev_ans_button(Button rev_ans_button) {
        this.rev_ans_button = rev_ans_button;
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

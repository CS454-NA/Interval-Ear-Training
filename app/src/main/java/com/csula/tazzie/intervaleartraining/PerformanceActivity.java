package com.csula.tazzie.intervaleartraining;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class PerformanceActivity extends ActionBarActivity {
    SQLiteDatabase mydatabase;
    Button return_button;
    private static final String TrackerTag = "TrackerTag";
    private TextView average, best, worst;

    Analysis A;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_performance);
        mydatabase = openOrCreateDatabase("performance",MODE_PRIVATE,null);
        Cursor resultSet = mydatabase.rawQuery("Select * from history",null);
        resultSet.moveToFirst();
        for(int i=0;i<resultSet.getColumnCount();i++) {
            Log.d(TrackerTag, "dbColumns" + resultSet.getColumnName(i));
        }
        Log.d(TrackerTag, "dbContent within performance activity" + resultSet.getCount());
        while(!resultSet.isAfterLast()) {
            Log.d(TrackerTag, "dbContent " +  resultSet.getInt(4) + " " +resultSet.getInt(1) + " " + resultSet.getInt(2) + " " + resultSet.getInt(3) + " " + resultSet.getInt(0));
            resultSet.moveToNext();

        }

        return_button = (Button) findViewById(R.id.return_button);
        return_button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                Intent intent = new Intent(PerformanceActivity.this, MainActivity.class);
                // prevents new stacks of activity
                intent.setFlags(Intent.FLAG_ACTIVITY_NO_HISTORY);
                startActivity(intent);
            }
        });
        A=new Analysis();
        average = (TextView) findViewById(R.id.averageincorrect);
        average.setText(getResources().getString(R.string.average_attempts)+A.averageAttempts);

        best = (TextView) findViewById(R.id.bestrange);
        best.setText(getResources().getString(R.string.best_range)+A.bestInterval);

        worst = (TextView) findViewById(R.id.worstrange);
        worst.setText((getResources().getString(R.string.worst)+A.problemInterval));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_performance, menu);
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
    class Analysis{
        String averageAttempts;
        String qAnswered;
        String problemInterval;
        String bestInterval;
        String[] range;



        public Analysis() {
            mydatabase = openOrCreateDatabase("performance", MODE_PRIVATE, null);
            range = new String[]{
                    "unison",
                    "minor 2nd",
                    "major 2nd",
                    "minor 3rd",
                    "major 3rd",
                    "perfect 4th",
                    "tritone",
                    "perfect 5th",
                    "minor 6th",
                    "major 6th",
                    "minor 7th",
                    "major 7th",
                    "octave",};

            Cursor resultSet = mydatabase.rawQuery("Select * from history", null);
            Cursor data = mydatabase.rawQuery("Select sum(NumberOfIncorrectAttempts) from history", null);
            resultSet.moveToFirst();
            data.moveToFirst();
            averageAttempts = 1 + (float) resultSet.getCount() / data.getInt(0) + "";

            ////
            resultSet.moveToFirst();
            data.moveToFirst();
            qAnswered = "" + (float) resultSet.getCount();

            data = mydatabase.rawQuery("SELECT startofrange, COUNT(*) AS magnitude \n" +
                    "FROM  history \n" +
                    "GROUP BY numberofincorrectattempts \n" +
                    "ORDER BY magnitude DESC\n" +
                    "LIMIT 1", null);

            resultSet.moveToFirst();
            data.moveToFirst();

            try{
            problemInterval = range[data.getInt(0) - 2];
                Log.d(TrackerTag, "ProblemRange " + problemInterval);

            }catch(Exception e){
                problemInterval=range[7];
            }


            data = mydatabase.rawQuery("SELECT startofrange, COUNT(*) AS magnitude \n" +
                    "FROM  history \n" +
                    "GROUP BY numberofincorrectattempts \n" +
                    "ORDER BY magnitude \n" +
                    "LIMIT 1", null);

            resultSet.moveToFirst();
            data.moveToFirst();

            try{
                bestInterval = range[data.getInt(0) - 2];
                Log.d(TrackerTag, "BestRange " + bestInterval);

            }catch(Exception e){
              bestInterval=range[6];
            }
            resultSet.moveToFirst();
            Log.d(TrackerTag, "dbContent" + resultSet.getCount()+" "+averageAttempts);
            while(!resultSet.isAfterLast()) {
                Log.d(TrackerTag, "dbContent " +  resultSet.getInt(4) + " " +resultSet.getInt(1) + " " + resultSet.getInt(2) + " " + resultSet.getInt(3) + " " + resultSet.getInt(0));
                resultSet.moveToNext();

            }

        }




    }
}

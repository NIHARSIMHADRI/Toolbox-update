package com.example.toolbox;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    DecimalFormat df = new DecimalFormat("####.00");
    double FinalGrade;
    View v;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        v = this.getWindow().getDecorView();

        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    public void calculateGrade(View v){
        EditText Q1grade = (EditText) findViewById(R.id.Q1grade);
        EditText Q2grade = (EditText) findViewById(R.id.Q2grade);
        EditText FinalScore = (EditText) findViewById(R.id.FinalScore);
        TextView finalGrade = (TextView) findViewById(R.id.finalGrade);

        double Q1 = Integer.parseInt(Q1grade.getText().toString());
        double Q2 = Integer.parseInt(Q2grade.getText().toString());
        double Final = Integer.parseInt(FinalScore.getText().toString());

        FinalGrade = ((Final*0.2)+(Q1*0.4)+(Q2*0.4));
        finalGrade.setText("Final Grade: " + df.format(FinalGrade));
    }

    public void message(View v){
        boolean checked = ((CheckBox) v).isChecked();
        TextView message = (TextView) findViewById(R.id.message);
        if (checked) {
            if (FinalGrade >= 0 && FinalGrade <= 50) {
              message.setText("It's been a rough year");
            } else if (FinalGrade >= 50 && FinalGrade <= 75) {
                message.setText("It's been an OK year");
            } else if (FinalGrade >= 75 && FinalGrade <= 100) {
                message.setText("It's been a good year");
            }
    } else {
        message.setText("message");
    }

    }

    public void backgroundChange(View v){
        boolean checked = ((Switch) v).isChecked();
        if (checked) {
            v.setBackgroundResource(R.color.coolblue);
        } else {
            v.setBackgroundResource(R.color.coolgreen);
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

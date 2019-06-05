package com.example.machinelearning;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{
    Button test;
    EditText Type1;
    EditText Type2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        test = (Button) findViewById(R.id.test);
        Type1 = (EditText) findViewById(R.id.text1);
        Type2 = (EditText) findViewById(R.id.text2);
        test.setOnClickListener(this);
    }
        public void onClick(View v) {
            int i;
            int r = 0;
            if (v == (Button) findViewById(R.id.test)) {
                String str1 = Type1.getText().toString();
                String str2 = Type2.getText().toString();
                str1 = str1.replace(",", "");
                str2 = str2.replace(",", "");
                String[] integerStrings = str1.split(" ");
                String[] integerStrings2 = str2.split(" ");
                double x[] = new double[integerStrings.length];
                double y[] = new double[integerStrings2.length];
                for (i = 0; i < integerStrings.length; i++)
                {
                    x[i] = Double.parseDouble(integerStrings[i]);
                    y[i] = Double.parseDouble(integerStrings2[i]);
                }
                double j;
                int m = 3;
                char c;
                // F = 0, D = 1 ... A = 4
                double theta[] = {0, 0};
                regression.setM(m);
                j = 0;
                j = regression.main(x, y, theta,9);
                if (j > 3.5)
                {
                    j = 4;
                }
                if ( j < 0)
                {
                    j = 0;
                    c = (char) ('f' - j);
                    System.out.println("Official Jt: " + c);
                }
                else
                {
                    c = (char) ('f' - j - 1);
                    System.out.println("Official Jt: " + c);
                }
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

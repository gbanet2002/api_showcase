package com.example.liaseptiany.api_showcase;

import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.content.Intent;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private final String _NOTREADY = "Not Ready Yet";

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }

    public void smsClick(View view) {

        Intent intent = new Intent(getBaseContext(), SmsAPIActivity.class );
        startActivity(intent);

        //Toast.makeText(this, "text Clicked", Toast.LENGTH_SHORT).show();
    }

    public void creditScoringClick(View view) {

        Toast.makeText(this, _NOTREADY, Toast.LENGTH_SHORT).show();
    }

    public void lbaClick(View view) {

        Toast.makeText(this, _NOTREADY, Toast.LENGTH_SHORT).show();
    }

    public void viewIDClick(View view) {

        Toast.makeText(this, _NOTREADY, Toast.LENGTH_SHORT).show();
    }

    public void otpClick(View view) {

        Toast.makeText(this, _NOTREADY, Toast.LENGTH_SHORT).show();
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

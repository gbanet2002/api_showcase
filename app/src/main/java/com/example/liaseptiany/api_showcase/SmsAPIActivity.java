package com.example.liaseptiany.api_showcase;

import android.content.Intent;
import android.os.Bundle;
import android.os.StrictMode;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
//import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import java.net.URLEncoder;

public class SmsAPIActivity extends AppCompatActivity {

    private final String _SENT = "Sent";
    private int textViewSender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sms_api);
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

    public void mainMenu(View view) {

        Intent intent = new Intent(getBaseContext(), MainActivity.class );
                startActivity(intent);

        //Toast.makeText(this, "text Clicked", Toast.LENGTH_SHORT).show();
    }

    public void sendSMS(View view) {

        final TextView textView = findViewById(R.id.textViewResult);

        // Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        EditText sender = findViewById(R.id.editTextSender);
        EditText msisdn = findViewById(R.id.editTextMsisdn);
        EditText text = findViewById(R.id.editTextSMS);

        String vsender = sender.getText().toString();
        String vmsisdn = msisdn.getText().toString();
        String vtext = text.getText().toString();
        vtext = URLEncoder.encode(vtext);

        String url = "http://128.199.241.165:10000/SMS-API?sender="+vsender+"&msisdn="+vmsisdn+"&text="+vtext;

        // Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        // Display the first 500 characters of the response string.
                        textView.setText(textView.getText() + " : " + response);
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                textView.setText(textView.getText() + " : "  + error.getMessage());
            }
        });

        // Add the request to the RequestQueue.
        queue.add(stringRequest);

        //Toast.makeText(this, _SENT, Toast.LENGTH_SHORT).show();
    }

}

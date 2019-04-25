package com.sanjay.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Display;
import android.widget.TextView;
import android.widget.Toast;

public class Dispaly extends AppCompatActivity {

    private TextView DisplayMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dispaly);
        DisplayMessage= findViewById(R.id.tvDisplayMessage);

        Bundle bundle = getIntent().getExtras();

        if(bundle !=null){

            String meaning = bundle.getString("message");
            DisplayMessage.setText(meaning);
        }

        else{
            Toast.makeText(this, "NO message", Toast.LENGTH_LONG).show();
        }


    }
}

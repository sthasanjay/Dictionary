package com.sanjay.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MeaningActivity extends AppCompatActivity {

    private TextView Meaning;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_meaning);

        Meaning = findViewById(R.id.tvMeaning);

        Bundle bundle = getIntent().getExtras();

        if(bundle !=null){

            String meaning = bundle.getString("meaning");
            Meaning.setText(meaning);
        }
    }
}

package com.sanjay.dictionary;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintStream;

public class AddWordActivity extends AppCompatActivity {


    private EditText meaning, word;
    private Button buton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_word);



        meaning = findViewById(R.id.etMeaning);
        word = findViewById(R.id.etWord);
        buton = findViewById(R.id.BtnAdd);

        buton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (validate()){
                    Save();
                    clean();
                }
            }
        });
    }

    private void Save(){
        try {


            PrintStream printStream = new PrintStream(openFileOutput("word.txt", MODE_PRIVATE|MODE_APPEND));
            printStream.println(word.getText().toString() + " =>" + meaning.getText().toString());
            printStream.close();
            Toast.makeText(getApplicationContext(), "Saved to :" + getFilesDir(), Toast.LENGTH_LONG).show();
        }catch (IOException e){
            Log.d("Dictionary app:" ,"Error"+ e.toString());
            e.printStackTrace();

        }

    }


    private Boolean validate() {
        boolean validate = true;
        if (TextUtils.isEmpty(word.getText().toString())) {
            word.setError("Please Enter Word");
            word.requestFocus();
            validate = false;
        }
        if (TextUtils.isEmpty(meaning.getText().toString())) {
            meaning.setError("Please Enter Meaning");
            meaning.requestFocus();
            validate = false;
        }
        return validate;
    }




        private void clean() {

        word.setText("");
        meaning.setText("");
    }
    }



package com.sanjay.dictionary;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {

    private static final String TAG = MainActivity.class.getSimpleName();
    private ListView lvCountries;
    private Map<String, String> dictionary;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
/* for list
        dictionary = new HashMap<>();
        dictionary.put("Nepal","Kathmandu");
        dictionary.put("India","New Delhi");
        dictionary.put("China","Bejing");
        dictionary.put("Japan","Tokya");

        */

        lvCountries = findViewById(R.id.lvCountries);


        dictionary = new HashMap<>();
        //this is for a list
        //ArrayAdapter adapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, new ArrayList<String>(dictionary.keySet()));
        //lvCountries.setAdapter(adapter);
        
        


        //read from file
        readFromFile();

        ArrayAdapter arrayAdapter = new ArrayAdapter<>(
                this,
                android.R.layout.simple_list_item_1,
                new ArrayList<String>(dictionary.keySet())





        );

        lvCountries.setAdapter(arrayAdapter);

        lvCountries.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                String key = parent.getItemAtPosition(position).toString();
                String meaning = dictionary.get(key);

                Intent intent = new Intent(MainActivity.this,MeaningActivity.class);
                intent.putExtra("meaning",meaning);
                startActivity(intent);



            }
        });

        }





    private void readFromFile() {


        try{

            FileInputStream fileInputStream = openFileInput("word.txt");
            InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);

            String line ="";

            while((line = bufferedReader.readLine()) !=null){

                String[] parts = line.split("->");
                dictionary.put(parts[0],parts[1]);
            }




        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
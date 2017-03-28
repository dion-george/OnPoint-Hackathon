package com.example.dion.onpoint;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;

public class notepad extends AppCompatActivity {


    EditText et1;
    Intent intent;
    String sub;
//    String save = "Record";
//String input;

    //when back pressed go back.


String eg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notepad);
        et1 = (EditText)findViewById(R.id.notes);
        loadSavedPreferences();
//intent = getIntent();
//        input = intent.getStringExtra("def_copied");
        //et1.setText(input);
        //  SharedPreferences loadRecord = getSharedPreferences(save, 0);
        //sub = loadRecord.getString("",sub);


//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
 // intent = getIntent();


//        SharedPreferences saveRecord = getSharedPreferences(save, MODE_PRIVATE);
//        SharedPreferences.Editor editor = saveRecord.edit();
//        editor.putString(" ", sub);
//        editor.apply();


//  takeFromDef();

//        NoteText.setText(noteDisplay);





//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });

    }


    private void loadSavedPreferences(){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        et1.setText(sharedPreferences.getString("string_et1",""));
    }

    private void savePreferences(String key, String value){
        SharedPreferences sharedPreferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(key,value);
        editor.commit();
    }
    public void saveData(){
        savePreferences("string_et1",et1.getText().toString());
    }


    @Override

    public void onBackPressed(){
    saveData();
        super.onBackPressed();
    }
}




package com.example.dion.onpoint;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;

public class notepad extends AppCompatActivity {

    FloatingActionButton newButton,saveButton,openButton;
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
        saveButton=(FloatingActionButton)findViewById(R.id.saveButton);
        openButton=(FloatingActionButton)findViewById(R.id.openButton);
        newButton = (FloatingActionButton)findViewById(R.id.newButton);
        et1 = (EditText)findViewById(R.id.notes);
//        et1.append(et1.getText());

        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

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
        savePreferences("string_et1", et1.getText().toString());
    }


    @Override

    public void onBackPressed(){
    saveData();
        super.onBackPressed();
    }


    public void buttonAction(View v) {
        final EditText fileName=new EditText(this);
        AlertDialog.Builder ad=new AlertDialog.Builder(this);
        ad.setView(fileName);

        if (v.getId() == R.id.saveButton) {
            ad.setMessage("Save File");

            ad.setPositiveButton("Save",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    try {
                        FileOutputStream fout=openFileOutput(fileName.getText().toString()+".txt",MODE_WORLD_READABLE);
                        fout.write(et1.getText().toString().getBytes());
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error Occured: " + e, Toast.LENGTH_LONG).show();
                    }
                }
            });

            ad.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            ad.show();

        }

        if(v.getId()==R.id.openButton) {
            ad.setMessage("Open File");

            ad.setPositiveButton("Open",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {

                    int c;
                    et1.setText("");

                    try {
                        FileInputStream fin = openFileInput(fileName.getText().toString()+".txt");

                        while ((c = fin.read()) != -1)
                        {
                            et1.setText((et1.getText().toString() + Character.toString((char) c)));
                        }
                    }catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Error Occured: "+e,Toast.LENGTH_LONG).show();
                    }
                }
            });

            ad.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialog, int which) {
                    dialog.cancel();
                }
            });

            ad.show();
        }

        if(v.getId()==R.id.newButton) {
            et1.setText("");
        }
    }


}




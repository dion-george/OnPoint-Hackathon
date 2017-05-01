package com.something.dion.onpoint;

import android.content.Context;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;

import java.io.FileOutputStream;
import java.io.ObjectOutputStream;

//Activity for a old note being opened

public class ENote extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enote);

        //Set the editText with text from notesArray that is text from a old note
        EditText editText = (EditText)findViewById(R.id.text_editor2);
        editText.setText(NoteMain.notesArray.get(NoteMain.itemNumber));


    }


    public void discardNote(View view){
        NoteMain.notesArray.remove(NoteMain.itemNumber);
        NoteMain.displayArray.remove(NoteMain.itemNumber);

        NoteMain.theListView.setAdapter(NoteMain.theAdapter);

        try {
            FileOutputStream fileOutputStream = openFileOutput("noteSaves", Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(NoteMain.notesArray);
            objectOutputStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }
        finish();
    }

    public void saveNote(View view){


        //Get text from user input in the EditText and add it to the listview using adapter
        EditText editText = (EditText)findViewById(R.id.text_editor2);
        String theText = (String)editText.getText().toString();

        //set updated note to notes Array
        NoteMain.notesArray.set(NoteMain.itemNumber, theText);

        //set updated note up to newline to display array
        String[] beforeNewline = theText.split("\n", 20);
        NoteMain.displayArray.set(NoteMain.itemNumber,beforeNewline[0]);

        //update the listview on main activity
        NoteMain.theListView.setAdapter(NoteMain.theAdapter);

        //write notesArray to memory
        try {
            FileOutputStream fileOutputStream = openFileOutput("noteSaves", Context.MODE_PRIVATE);
            ObjectOutputStream objectOutputStream = new ObjectOutputStream(fileOutputStream);

            objectOutputStream.writeObject(NoteMain.notesArray);
            objectOutputStream.close();
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        finish();

    }


}

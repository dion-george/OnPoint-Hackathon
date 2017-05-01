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


public class NewNote extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_note);

    }


    public void saveNoteNew (View view) {


        EditText editText = (EditText)findViewById(R.id.text_editor);

        //Get text from user input in the EditText and add it to the listview using adapter
        String theText = (String)editText.getText().toString();
        NoteMain.notesArray.add(theText);

        String[] beforeNewline = theText.split("\n", 20);
        NoteMain.displayArray.add(beforeNewline[0]);

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

    public void discardNoteNew (View view) {
        finish();
    }

}

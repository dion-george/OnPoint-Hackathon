package com.something.dion.onpoint;


import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.io.FileInputStream;
import java.io.ObjectInputStream;
import java.util.ArrayList;
import java.util.List;


public class NoteMain extends ActionBarActivity {

    static ArrayList<String> notesArray = new ArrayList<String>();
    static ArrayList<String> displayArray = new ArrayList<String>();
    static ListAdapter theAdapter;
    static ListView theListView;
    static int itemNumber;
    @Override
    //Get everything ready
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_note_main);

        try {
            FileInputStream fileInputStream = openFileInput("noteSaves");
            ObjectInputStream objectInputStream = new ObjectInputStream(fileInputStream);

            notesArray = (ArrayList<String>)objectInputStream.readObject();
            objectInputStream.close();
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }

        //copying notes array into displayarray but only the first line
        for(String x : notesArray)
        {
            String[] beforeNewline = x.split("\n", 20);


            displayArray.add(beforeNewline[0]);
        }

        theAdapter= new ArrayAdapter<String>(this,R.layout.list_green_text,
                R.id.list_content,displayArray);

        theListView = (ListView)findViewById(R.id.listView);
        theListView.setAdapter(theAdapter);

        theListView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {

                itemNumber = position;
                Intent intent = new Intent(NoteMain.this, ENote.class);
                startActivity(intent);
            }
        });


    }

    public void newNote (View view) {
        Intent intent = new Intent(this, NewNote.class);
        startActivity(intent);

    }

}

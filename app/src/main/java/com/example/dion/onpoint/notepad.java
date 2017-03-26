//package com.example.dion.onpoint;
//
//import android.content.Intent;
//import android.content.SharedPreferences;
//import android.os.Bundle;
//import android.support.design.widget.FloatingActionButton;
//import android.support.design.widget.Snackbar;
//import android.support.v7.app.AppCompatActivity;
//import android.support.v7.widget.Toolbar;
//import android.view.View;
//import android.widget.EditText;
//
//public class notepad extends AppCompatActivity {
//
//    String noteDisplay;
//    EditText NoteText;
//    Intent intent;
//    Intent intent_notes;
//    String subFinal;
//    String sub;
////    String save = "Record";
//
//
//    //when back pressed go back.
////    @Override
////    public void onBackPressed(){
////       sub = NoteText.getText().toString();
////         super.onBackPressed();
////    }
//
//
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//        super.onCreate(savedInstanceState);
//        setContentView(R.layout.activity_notepad);
//
//      //  SharedPreferences loadRecord = getSharedPreferences(save, 0);
//        //sub = loadRecord.getString("",sub);
//
//
//        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
//        setSupportActionBar(toolbar);
////         intent = getIntent();
////        noteDisplay = intent.getStringExtra("searchedItem");
//
//        NoteText = (EditText) findViewById(R.id.notes);
//        NoteText.setText(sub);
//
//if(SavedInstanceState!=null)
//{
//    NoteText.setText(savedInstanceState.getString("textValue"));
//}
////        SharedPreferences saveRecord = getSharedPreferences(save, MODE_PRIVATE);
////        SharedPreferences.Editor editor = saveRecord.edit();
////        editor.putString(" ", sub);
////        editor.apply();
//
//
////  takeFromDef();
//
////        NoteText.setText(noteDisplay);
//
//
//
//
//
//        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
//        fab.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View view) {
//                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
//                        .setAction("Action", null).show();
//            }
//        });
//    }
//
//    @Override
//    public void onSaveInstanceState(Bundle outState){
//        super.onSaveInstanceState(outState);
//        outState.putInt("textValue",NoteText.getText().toString());
//    }
//
////    public void takeFromDef(){
////        if(intent.getStringExtra("def_copied")!=null) {
////            noteDisplay = noteDisplay + "\n" + intent.getStringExtra("def_copied");
////
////        }
////    }
//
//
//
//
//}

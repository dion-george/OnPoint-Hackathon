package com.example.dion.onpoint;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.Toast;

public class SearchPage extends AppCompatActivity {

    String SearchedItem;
    EditText searchBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_page);

        Intent intent = getIntent();
        SearchedItem = intent.getStringExtra("key");
        searchBar = (EditText) findViewById(R.id.SearchItem);
        searchBar.setText(SearchedItem);


    }

    public void Search(View view){
        if(searchBar.getText().toString()!= SearchedItem){
            SearchedItem = searchBar.getText().toString();
        }
        InputMethodManager mgr = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
        mgr.showSoftInput(searchBar, InputMethodManager.SHOW_IMPLICIT);

        Toast.makeText(getApplicationContext(), "Search successful", Toast.LENGTH_SHORT).show();
    }

    public void goto_OxfordDict(View view)
    {
        Intent intent_def = new Intent(SearchPage.this,Definition.class);
        intent_def.putExtra("searchedItem",SearchedItem);
        startActivity(intent_def);
}
    public void goto_Quotes(View view)
    {
        Intent intent_quote = new Intent(SearchPage.this,quotes.class);
        intent_quote.putExtra("searchedItem",SearchedItem);
        startActivity(intent_quote);
    }

    public void goto_Wikipedia(View view)
    {
        Intent intent_wiki = new Intent(SearchPage.this,wikipedia.class);
        intent_wiki.putExtra("searchedItem",SearchedItem);
        startActivity(intent_wiki);
    }

    public void goto_Quora(View view)
    {
        Intent intent_quora = new Intent(SearchPage.this,quora.class);
        intent_quora.putExtra("searchedItem",SearchedItem);
        startActivity(intent_quora);
    }

    public void goto_Reuters(View view)
    {
        Intent intent_reuters = new Intent(SearchPage.this,reuters.class);
        intent_reuters.putExtra("searchedItem",SearchedItem);
        startActivity(intent_reuters);
    }

    public void goto_Hindu(View view)
    {
        Intent intent_hindu = new Intent(SearchPage.this,hindu.class);
        intent_hindu.putExtra("searchedItem",SearchedItem);
        startActivity(intent_hindu);
    }

    public void goto_Youtube(View view)
    {
        Intent intent_youtube = new Intent(SearchPage.this,youtube.class);
        intent_youtube.putExtra("searchedItem",SearchedItem);
        startActivity(intent_youtube);
    }


}

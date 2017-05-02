package com.something.dion.onpoint;

import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.EditText;

public class StartPage extends AppCompatActivity {

    private String input_String;
    String var="hello";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start_page);
        getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_ADJUST_PAN);

    }

    private String displayInput() {
        EditText editText = (EditText) findViewById(R.id.enterWord);
        String sub = editText.getText().toString();
        return sub;
    }

    public void startSearch(View view){

        input_String = displayInput();
        Intent intent = new Intent(StartPage.this,SearchPage.class);
        intent.putExtra("key", input_String);
        startActivity(intent);
    }

}

package com.example.dion.onpoint;

import android.content.ClipData;
import android.content.ClipboardManager;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;

public class QuoteFinal extends AppCompatActivity {

    String input;
    String final_Input;
    WebView wv;
    String main_paste;

    //when back pressed go back.
    @Override
    public void onBackPressed(){
        if(wv.canGoBack()){
            wv.goBack();
        }
        else {
            super.onBackPressed();
        }
    }

    Intent intent;
    int sdk = android.os.Build.VERSION.SDK_INT;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_quote_final);

        Intent intent_def = getIntent();
        input = intent_def.getStringExtra("searchedItem");

        input = input.replaceAll(" ", "+").toLowerCase();
        final_Input = "https://www.brainyquote.com/search_results.html?q=" + input;
        wv = (WebView) findViewById(R.id.wv);
        // enable javascript
        wv.getSettings().setJavaScriptEnabled(true);
        wv.setFocusable(true);
        wv.setFocusableInTouchMode(true);
        // set render priority to high
        wv.getSettings().setRenderPriority(WebSettings.RenderPriority.HIGH);
        wv.getSettings().setCacheMode(WebSettings.LOAD_NO_CACHE);
        wv.getSettings().setDomStorageEnabled(true);
        wv.getSettings().setDatabaseEnabled(true);
        wv.getSettings().setAppCacheEnabled(true);
        wv.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);

        wv.loadUrl(final_Input);
        wv.setWebViewClient(new WebViewClient());

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @SuppressWarnings("deprecation")
            @Override
            public void onClick(View arg0) {
                String pasteText;

                // TODO Auto-generated method stub
                if(sdk < android.os.Build.VERSION_CODES.HONEYCOMB){
                    android.text.ClipboardManager clipboard = (android.text.ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    pasteText = clipboard.getText().toString();
                    main_paste = main_paste + pasteText;
                    main_paste = main_paste + "\n";
                    Toast.makeText(getApplicationContext(), "Saved to Notepad", Toast.LENGTH_SHORT).show();
                    intent.putExtra("def_copied", main_paste);
                }else{
                    ClipboardManager clipboard = (ClipboardManager) getSystemService(Context.CLIPBOARD_SERVICE);
                    if(clipboard.hasPrimaryClip()== true){
                        ClipData.Item item = clipboard.getPrimaryClip().getItemAt(0);
                        pasteText = item.getText().toString();
                        main_paste = main_paste + pasteText;
                        main_paste = main_paste + "\n";
                        Toast.makeText(getApplicationContext(), "Saved to Notepad", Toast.LENGTH_SHORT).show();
                        intent.putExtra("def_copied", main_paste);
                    }else{

                        Toast.makeText(getApplicationContext(), "Nothing to Paste", Toast.LENGTH_SHORT).show();

                    }
                }

                Intent intent = new Intent(QuoteFinal.this,notepad.class);
                startActivity(intent);

            }
        });

    }

}

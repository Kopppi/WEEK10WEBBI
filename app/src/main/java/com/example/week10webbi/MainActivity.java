package com.example.week10webbi;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    WebView web;
    String newURL;
    EditText editURL;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        web = findViewById(R.id.webView);
        editURL = findViewById(R.id.edit_url);
        web.getSettings().setJavaScriptEnabled(true);
        web.setWebViewClient(new WebViewClient());


        editURL.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View view, int i, KeyEvent keyEvent) {
                if (keyEvent.getAction() == KeyEvent.ACTION_UP) {
                    if (i == KeyEvent.KEYCODE_ENTER) {
                        newURL = "http://" + editURL.getText().toString();
                        if (newURL.equals("http://index.html")) {
                            web.loadUrl("file:///android_asset/index.html");
                        } else {
                            web.loadUrl(newURL);
                            editURL.setText(web.getUrl());
                            return true;
                        }
                    }
                }
                return false;
            }
        });
    }

    public void reloadPage(View v)  {
        web.loadUrl(web.getUrl());
    }

    public void initialize(View v)  {web.evaluateJavascript("javacript:initialize()", null);}
    public void shoutOut(View v)  {web.evaluateJavascript("javacript:shoutOut()", null);}

}

package com.codewithdevesh.osproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;

import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.ActivityWebviewBinding;

public class WebViewActivity extends AppCompatActivity {
    private ActivityWebviewBinding binding;
    private String url;
    private String title;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_webview);
        Intent i = getIntent();
        url = i.getStringExtra("link");
        title = i.getStringExtra("title");

        binding.webView.getSettings().setJavaScriptEnabled(true);
        binding.webView.getSettings().setPluginState(WebSettings.PluginState.ON);
        binding.webView.loadUrl(url);
        binding.tvTitle.setText(title);
        binding.tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });



    }
}
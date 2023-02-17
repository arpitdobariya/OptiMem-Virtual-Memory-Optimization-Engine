package com.codewithdevesh.osproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.ActivityPdfactivityBinding;

public class PDFActivity extends AppCompatActivity {
    private ActivityPdfactivityBinding binding;
    private String pdf;
    private String title;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this, R.layout.activity_pdfactivity);
        Intent i = getIntent();
        pdf = i.getStringExtra("Algorithm");
        title = i.getStringExtra("Title");

        binding.pdfView.fromAsset(pdf).show();
        binding.tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.tvTitle.setText(title);

    }
}
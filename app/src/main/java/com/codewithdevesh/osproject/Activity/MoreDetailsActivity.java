package com.codewithdevesh.osproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.os.Bundle;
import android.view.View;

import com.codewithdevesh.osproject.Adapter.TheoryAdapter;
import com.codewithdevesh.osproject.Models.TheoryModel;
import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.ActivityMoreDetailsBinding;

import java.util.ArrayList;
import java.util.List;

public class MoreDetailsActivity extends AppCompatActivity {
    private ActivityMoreDetailsBinding binding;
    private TheoryAdapter adapter;
    private List<TheoryModel>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this,R.layout.activity_more_details);

        setData();
        binding.tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
        binding.rv.setLayoutManager(new LinearLayoutManager(MoreDetailsActivity.this));
        adapter = new TheoryAdapter(list, MoreDetailsActivity.this);
        binding.rv.setAdapter(adapter);
    }

    private void setData() {
        list = new ArrayList<>();
        list.add(new TheoryModel("Geeks For Geeks","https://www.geeksforgeeks.org/page-replacement-algorithms-in-operating-systems/","Page Replacement","https://media.geeksforgeeks.org/wp-content/uploads/20210224040124/JSBinCollaborativeJavaScriptDebugging6-300x160.png"));
        list.add(new TheoryModel("Java T Point","https://www.javatpoint.com/os-page-replacement-algorithms","Page Replacement","https://static.javatpoint.com/images/logo/jtp_logo.png"));
        list.add(new TheoryModel("Wikipedia","https://en.wikipedia.org/wiki/Page_replacement_algorithm","Page Replacement","https://upload.wikimedia.org/wikipedia/commons/thumb/0/07/Wikipedia_logo_%28svg%29.svg/1200px-Wikipedia_logo_%28svg%29.svg.png"));
        list.add(new TheoryModel("Scaler","https://www.scaler.com/topics/operating-system/page-replacement-algorithm/","Page Replacement","https://www.medianews4u.com/wp-content/uploads/2021/10/Scaler-Academy-acquires-Coding-Minutes-to-strengthen-its-offering-for-beginner-level.jpg"));
        list.add(new TheoryModel("Edcuba","https://www.educba.com/page-replacement-algorithms/","Page Replacement","https://cdn.educba.com/images/website_logo_transparent_background.png"));
    }
}
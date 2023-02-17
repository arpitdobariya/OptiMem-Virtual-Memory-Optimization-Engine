package com.codewithdevesh.osproject.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codewithdevesh.osproject.Activity.TableActivity;
import com.codewithdevesh.osproject.Activity.WebViewActivity;
import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.FragmentProfileBinding;


public class ProfileFragment extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentProfileBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_profile, container, false);
        binding.cvDevesh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), TableActivity.class));
//                .putExtra("link","https://www.linkedin.com/in/devesh-parmar-875990200/")
//                .putExtra("title","Devesh Parmar's Profile"));
            }
        });
        binding.cvSahil.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), WebViewActivity.class)
                        .putExtra("link","https://www.linkedin.com/in/sahilanand30")
                        .putExtra("title","Sahil Anand's Profile"));
            }
        });

        binding.cvTushar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), WebViewActivity.class)
                        .putExtra("link","https://www.linkedin.com/in/bhut-tushar-a581431b6")
                        .putExtra("title","Tushar Bhut's Profile"));
            }
        });


        return binding.getRoot();
    }
}

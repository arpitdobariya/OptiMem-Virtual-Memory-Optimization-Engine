package com.codewithdevesh.osproject.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codewithdevesh.osproject.Activity.EnterDetailsActivity;
import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.FragmentAlgorithmBinding;


public class AlgorithmFragment extends Fragment {

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        FragmentAlgorithmBinding binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_algorithm, container, false);
        binding.cvFifo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), EnterDetailsActivity.class)
                .putExtra("type","fifo")
                .putExtra("title","FIFO Algorithm"));
            }
        });


        binding.cvOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), EnterDetailsActivity.class)
                .putExtra("type","optimal")
                .putExtra("title","Optimal Algorithm"));
            }
        });

        binding.cvLru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), EnterDetailsActivity.class)
                .putExtra("type","lru")
                .putExtra("title","LRU Algorithm"));
            }
        });

        binding.cvMru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(),EnterDetailsActivity.class)
                .putExtra("type","mru")
                .putExtra("title","MRU Algorithm"));
            }
        });

        return binding.getRoot();

    }
}
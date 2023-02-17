package com.codewithdevesh.osproject.Fragments;

import android.content.Intent;
import android.os.Bundle;

import androidx.databinding.DataBindingUtil;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.codewithdevesh.osproject.Activity.MoreDetailsActivity;
import com.codewithdevesh.osproject.Adapter.TheoryAdapter;
import com.codewithdevesh.osproject.Activity.PDFActivity;
import com.codewithdevesh.osproject.Models.TheoryModel;
import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.FragmentTheoryBinding;

import java.util.List;


public class TheoryFragment extends Fragment {
    private RecyclerView recyclerView;
    private List<TheoryModel> list;
    private TheoryAdapter adapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

         FragmentTheoryBinding binding = DataBindingUtil.inflate(inflater,R.layout.fragment_theory, container, false);
        binding.cvFifo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PDFActivity.class)
                .putExtra("Algorithm","Fifo.pdf")
                .putExtra("Title","FIFO Algorithm"));
            }
        });

        binding.cvLru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PDFActivity.class)
                        .putExtra("Algorithm","LRU.pdf")
                        .putExtra("Title","LRU Algorithm"));
            }
        });

        binding.cvOpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PDFActivity.class)
                .putExtra("Algorithm","Optimal.pdf")
                        .putExtra("Title","Optimal Algorithm"));
            }
        });

        binding.cvLearnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), MoreDetailsActivity.class));

            }
        });
        binding.cvMru.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(getActivity(), PDFActivity.class)
                        .putExtra("Algorithm","MRU.pdf")
                        .putExtra("Title","MRU Algorithm"));
            }
        });
        return binding.getRoot();
    }

}
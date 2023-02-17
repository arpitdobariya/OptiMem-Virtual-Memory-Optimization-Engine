package com.codewithdevesh.osproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.databinding.DataBindingUtil;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.InputMethodManager;

import com.codewithdevesh.osproject.Algorithms.Fifo;
import com.codewithdevesh.osproject.Algorithms.LRU;
import com.codewithdevesh.osproject.Algorithms.MRU;
import com.codewithdevesh.osproject.Algorithms.Optimal;
import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.ActivityEnterDetailsBinding;
import com.google.android.material.snackbar.Snackbar;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

public class EnterDetailsActivity extends AppCompatActivity {
    private ActivityEnterDetailsBinding binding;
    private List<String>list;
    private ArrayList<Integer>hitList;
    private String type;
    private String title;
    private int[][]arr;
    private String[][]arr3;
    private int[]arr2;
    private int start;
    private int end;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding= DataBindingUtil.setContentView(this,R.layout.activity_enter_details);

        /* -------------- Handling toolbar Events ---------------*/
        Intent i = getIntent();
        type = i.getStringExtra("type");
        title = i.getStringExtra("title");
        binding.title.setText(title);
        list = new ArrayList<>();

       /* --------------- Handling Click Events of calculation ----------------*/
        binding.btCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String frame = binding.inputFrames.getEditText().getText().toString();
                String pageInputs = binding.etPageInput.getEditText().getText().toString();
                String x;
                int faults=0,hits=0;

                /* checking input conditions */
                if(checkFrame(frame) || checkPage(pageInputs)){
                    Snackbar snackbar = Snackbar.make(binding.layout,"Please Enter the Details",Snackbar.LENGTH_SHORT);
                    snackbar.show();
                    binding.ll.setVisibility(View.GONE);
                    binding.btVisual.setVisibility(View.GONE);
                    return;
                }
                /*----------------------------performing algorithms after the validation--------------*/
                else {
                    x = pageInputs.replaceAll("[^a-zA-Z0-9]","");  // string after removal of ","
                    binding.ll.setVisibility(View.VISIBLE);
                    binding.btVisual.setVisibility(View.VISIBLE);
                    binding.temp.setText(pageInputs);
                    closeKeyBoard();

                    /*----------------converting string input of user to integer array-------------------*/
                    int[]pages = new int[x.length()];
                    arr2 = new int[x.length()];

                    /*--------------------- converting string input to integer array---------------------------*/
                    for(int i=0;i<x.length();i++){
                        final int i1 = Integer.parseInt(String.valueOf(x.charAt(i)));
                        pages[i] = i1;
                        arr2[i] = i1;
                    }

                    /*------------------selecting algorithm type------------*/
                    switch (type) {
                        /*----------------------------for performing optimal algorithm-----------------------------*/
                        case "optimal":
                            Optimal optimal = new Optimal(); // creating instance of optimal class
                            start = pages.length;
                            end = Integer.parseInt(frame);
                            arr = optimal.performOptimal(pages, Integer.parseInt(frame));
                            hits = optimal.getHits();
                            faults = x.length() - hits;
                            hitList = optimal.getHitList();
                            break;

                        /*-------------------------- for performing fifo algorithm----------------------------------*/
                        case "fifo":
                            Fifo fifo = new Fifo();   // creating instance of fifo class
                            start = pages.length;
                            end = Integer.parseInt(frame);
                            arr = fifo.performFifo(pages, Integer.parseInt(frame));
                            hits = fifo.getHits();
                            faults = pages.length - hits;
                            hitList = fifo.getHitList();
                            break;

                        /*-------------------------- for performing lru algorithm----------------------------------*/
                        case "lru":
                            LRU lru = new LRU();   // creating instance of LRU class
                            start = pages.length;
                            end = Integer.parseInt(frame);
                            arr = lru.performLRU(pages, Integer.parseInt(frame));
                            hits = lru.getHits();
                            faults = pages.length - hits;
                            hitList = lru.getHitList();
                            break;

                        /*-------------------------- for performing mru algorithm----------------------------------*/
                        case "mru":
                            MRU mru = new MRU();  // creating instance of mru class
                            start = pages.length;
                            end = Integer.parseInt(frame);
                            arr = mru.performMRU(pages, Integer.parseInt(frame));
                            hits = mru.getHits();
                            faults = mru.getFault();
                            hitList = mru.getHitList();
                            break;
                    }
                    /*-------------------printing outputs to user--------------------------*/
                    binding.tvHits.setText(String.valueOf(hits));
                    binding.tvFaults.setText(String.valueOf(faults));
                    binding.tvHitRatio.setText(String.valueOf((float)hits/x.length()));
                    binding.tvFaultRatio.setText(String.valueOf((float)faults/x.length()));

                }
            }
        });

        /*------------------- click event for visualization of page layout ----------------------------*/
        binding.btVisual.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(getApplicationContext(),TableActivity.class);
                Bundle bundle = new Bundle();
                bundle.putSerializable("array",arr);
                bundle.putInt("start",start);
                bundle.putInt("end",end);
                bundle.putIntegerArrayList("hitList",hitList);
                bundle.putString("input",binding.etPageInput.getEditText().getText().toString());
                i.putExtras(bundle);
                startActivity(i);
            }
        });

        /*------------------- click event for clearing input values ----------------------------*/
        binding.btClear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                binding.etPageInput.getEditText().setText("");
                binding.inputFrames.getEditText().setText("");
                binding.ll.setVisibility(View.GONE);
                binding.btVisual.setVisibility(View.GONE);
            }
        });

        /*-------------------- click event for random input values--------------------------------*/
        binding.btRandom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                /* generating random values */

                list.clear();
                Random random = new Random();
                String value = String.valueOf(3+random.nextInt(8-3+1));
                binding.inputFrames.getEditText().setText(value);
                binding.ll.setVisibility(View.GONE);
                binding.btVisual.setVisibility(View.GONE);

                for(int i=0;i<10;i++){
                    Random random1 = new Random();
                    String val = String.valueOf(random.nextInt(1+8)+1);
                    list.add(val);
                }
                int l = Arrays.toString(list.toArray()).length();

                binding.etPageInput.getEditText().setText(Arrays.toString(list.toArray()).substring(1,l-1));
            }
        });

        /*------------------- click event for back button ----------------------------*/
        binding.tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               onBackPressed();
               finish();
            }
        });
    }
      /* --------------- Handling keyboard -----------------*/
        private void closeKeyBoard() {
        View v = this.getCurrentFocus();
        if(v!=null){
            InputMethodManager manager = (InputMethodManager)getSystemService(Context.INPUT_METHOD_SERVICE);
            manager.hideSoftInputFromWindow(v.getWindowToken(),0);
        }
    }

      /* -------------- Checking validity of frame input -------------------------*/
       private boolean checkFrame(String s){
        if(s.isEmpty()){
            binding.inputFrames.setError("Enter Details");
            binding.inputFrames.setErrorEnabled(true);
            return true;

        }else if(Integer.parseInt(s)<=0){
            binding.inputFrames.setError("Enter Valid Details");
            binding.inputFrames.setErrorEnabled(true);
            return true;
            }
        else if(Integer.parseInt(s)>8){
            binding.inputFrames.setError("Enter frame between 1-8");
            binding.inputFrames.setErrorEnabled(true);
            return true;
        }
        else{
            binding.inputFrames.setError(null);
            binding.inputFrames.setErrorEnabled(false);
            return false;
        }
    }

      /* -------------- Checking validity of frame input -------------------------*/
       private boolean checkPage(String s){
        if(s.isEmpty()){
            binding.etPageInput.setError("Enter Details");
            binding.etPageInput.setErrorEnabled(true);
            return true;

        }else{
            binding.etPageInput.setError(null);
            binding.etPageInput.setErrorEnabled(false);
            return false;
        }
    }
}
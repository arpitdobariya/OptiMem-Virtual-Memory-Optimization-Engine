package com.codewithdevesh.osproject.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.content.res.ResourcesCompat;
import androidx.databinding.DataBindingUtil;
import android.graphics.Color;
import android.graphics.Typeface;
import android.os.Bundle;
import android.util.Log;
import android.view.Gravity;
import android.view.View;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.codewithdevesh.osproject.R;
import com.codewithdevesh.osproject.databinding.ActivityTableBinding;

import java.util.ArrayList;
import java.util.List;

public class TableActivity extends AppCompatActivity {
    private ActivityTableBinding binding;
    private TableLayout tableLayout1,tableLayout2;
    ArrayList<Integer>list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = DataBindingUtil.setContentView(this, R.layout.activity_table);
        tableLayout1 = findViewById(R.id.tableLayout1);
        tableLayout2 = findViewById(R.id.tableLayout2);

        /*--------------retrieving input values for visualization---------------*/
        Bundle bundle = getIntent().getExtras();
        int[][]arr = (int[][]) bundle.getSerializable("array");
        int start = bundle.getInt("start");
        int end = bundle.getInt("end");
        list = bundle.getIntegerArrayList("hitList");
        String input = bundle.getString("input");
        binding.temp.setText(input);

        addHeaders(end,tableLayout1);

        /*----------------calling function for displaying table------------------*/
        addDataToTable(start,end,arr,tableLayout2);

        /*-------------click events of toolbar-------------*/
        binding.tb.setNavigationOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });
    }
        /*---------------function to display table of pages in layout-------------------*/
        private void addDataToTable(final int a,final int b,final int[][]arr,TableLayout tableLayout){
        tableLayout.removeAllViews();
        tableLayout.setBackgroundResource(R.drawable.gradient);
        for(int i=0;i<a;i++){
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
            for(int j=0;j<b;j++){
                TextView tv = new TextView(this);
                Typeface typeface = ResourcesCompat.getFont(this,R.font.ubuntu_m);
                tv.setTypeface(typeface);
                tv.setLayoutParams(getLayoutParams());
                tv.setTextColor(Color.BLACK);
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv.setGravity(View.TEXT_ALIGNMENT_CENTER);
                tv.setPadding(10,10,10,10);
                if(list.contains(i)){
                    tv.setBackgroundResource(R.color.hit);
                    Log.e("executed","it is executed");
                }else {
                    tv.setBackgroundResource(R.color.light_background);
                }
                tv.setText(String.valueOf(arr[i][j]));
                row.addView(tv);

            }
//            tableLayout.setOrientation(LinearLayout.HORIZONTAL);
            tableLayout.addView(row);
        }
     }

        /*-----------------function for styling table----------------------------*/
        private TableRow.LayoutParams getLayoutParams(){
        TableRow.LayoutParams params = new TableRow.LayoutParams(
                TableRow.LayoutParams.WRAP_CONTENT,
                TableRow.LayoutParams.WRAP_CONTENT);
        TableRow.LayoutParams params1 = new TableRow.LayoutParams();
        params.setMargins(10, 10, 10, 10);
        return params;
    }

        private void addHeaders(int n,TableLayout layout){
            layout.setBackgroundResource(R.drawable.gradient);
            TableRow row = new TableRow(this);
            row.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.WRAP_CONTENT,TableRow.LayoutParams.WRAP_CONTENT));
            for(int i=1;i<=n;i++){
                TextView tv = new TextView(this);
                Typeface typeface = ResourcesCompat.getFont(this,R.font.ubuntu_m);
                tv.setTypeface(typeface);
                tv.setLayoutParams(getLayoutParams());
                tv.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
                tv.setTextColor(Color.BLACK);
                tv.setGravity(View.TEXT_ALIGNMENT_CENTER);
                tv.setPadding(10,10,10,10);
                tv.setBackgroundResource(R.color.light_background);
                tv.setText("F"+i);
                row.addView(tv);
            }
            layout.addView(row);
        }

}

package com.codewithdevesh.osproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.codewithdevesh.osproject.Activity.WebViewActivity;
import com.codewithdevesh.osproject.Models.TheoryModel;
import com.codewithdevesh.osproject.R;
import com.mikhaellopez.circularimageview.CircularImageView;

import java.util.List;

import de.hdodenhof.circleimageview.CircleImageView;


public class TheoryAdapter extends RecyclerView.Adapter<TheoryAdapter.ViewHolder> {
    private final List<TheoryModel>list;
    private final Context context;

    public TheoryAdapter(List<TheoryModel> list, Context context) {
        this.list = list;
        this.context = context;
    }

    @NonNull
    @Override
    public TheoryAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.theory_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TheoryAdapter.ViewHolder holder, int position) {
        TheoryModel model = list.get(position);
        if(position%2==0){
            holder.layout.setBackgroundResource(R.drawable.gradient_theory);
        }else{
            holder.layout.setBackgroundResource(R.drawable.gradient_theory2);
        }
        holder.website.setText(model.getSource());
        holder.topic.setText(model.getTopic());
        Glide.with(context).load(model.getLogo()).into(holder.imageView);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                context.startActivity(new Intent(context, WebViewActivity.class)
                .putExtra("title",model.getSource())
                .putExtra("link",model.getLink()));
            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
       CircularImageView imageView;
        TextView topic,website;
        LinearLayout layout;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.logo);
            topic = itemView.findViewById(R.id.topic);
            website = itemView.findViewById(R.id.website);
            layout = itemView.findViewById(R.id.ll_theory);
        }
    }
}

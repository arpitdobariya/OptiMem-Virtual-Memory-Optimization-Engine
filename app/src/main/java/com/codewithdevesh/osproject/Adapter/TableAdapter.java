package com.codewithdevesh.osproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.codewithdevesh.osproject.Models.TableModel;
import com.codewithdevesh.osproject.R;

import java.util.List;

public class TableAdapter extends RecyclerView.Adapter<TableAdapter.ViewHolder> {
    private final Context context;
    private final List<TableModel>list;

    public TableAdapter(Context context, List<TableModel> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public TableAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(context).inflate(R.layout.page_table_layout,parent,false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TableAdapter.ViewHolder holder, int position) {
        TableModel model = list.get(position);
        holder.type.setText(model.getType());
        holder.arr.setText(model.getInputs());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView arr,type;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            arr = itemView.findViewById(R.id.arr);
            type = itemView.findViewById(R.id.type);
        }
    }
}

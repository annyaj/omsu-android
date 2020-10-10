package com.example.recyclerview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CustomDataAdapter extends RecyclerView.Adapter<CustomDataAdapter.ViewHolder> {
    private LayoutInflater inflater;
    private List<String> days;

    public CustomDataAdapter(Context context, List<String> days) {
        this.days = days;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public CustomDataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.recyclerview_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(CustomDataAdapter.ViewHolder holder, int position) {
        String day = days.get(position);
        holder.smallTextView.setText("Position" + position);
        holder.largeTextView.setText(day);
    }

    @Override
    public int getItemCount() {
        return days.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final TextView largeTextView, smallTextView;

        ViewHolder(View view) {
            super(view);
            largeTextView = view.findViewById(R.id.textViewLarge);
            smallTextView = view.findViewById(R.id.textViewSmall);
        }
    }
}

package com.example.referencebook;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

class DataAdapter extends RecyclerView.Adapter<DataAdapter.ViewHolder> {

    private LayoutInflater inflater;
    private List<Picture> pictures;

    public DataAdapter(Context context, List<Picture> pictures) {
        this.pictures = pictures;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public DataAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = inflater.inflate(R.layout.list_item, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(DataAdapter.ViewHolder holder, int position) {
        Picture picture = pictures.get(position);
        holder.imageView.setImageResource(picture.getImage());
        holder.nameView.setText(picture.getName());
        holder.descriptionView.setText(picture.getDescription());
    }

    @Override
    public int getItemCount() {
        return pictures.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        final ImageView imageView;
        final TextView nameView, descriptionView;

        ViewHolder(View view) {
            super(view);
            imageView = (ImageView) view.findViewById(R.id.image);
            nameView = (TextView) view.findViewById(R.id.name);
            descriptionView = (TextView) view.findViewById(R.id.description);
        }
    }
}

package com.example.app_instances.Adapter;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.app_instances.Activity.DetailActivity;
import com.example.app_instances.databinding.ViewholderItemBinding;
import com.example.app_instances.modle.ItemsDomain;

import java.io.Serializable;
import java.util.ArrayList;

public class ItemsAdapter extends RecyclerView.Adapter<ItemsAdapter.ViewHolder> {
    private ArrayList<ItemsDomain> items;
    private Context context;

    public ItemsAdapter(Context context, ArrayList<ItemsDomain> itemArray) {
        this.items = itemArray;
        this.context = context;
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {
        public ViewholderItemBinding binding;

        public ViewHolder(ViewholderItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ViewholderItemBinding binding = ViewholderItemBinding.inflate(
                LayoutInflater.from(parent.getContext()),
                parent,
                false
        );
        return new ViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ItemsAdapter.ViewHolder holder, int position) {
        ItemsDomain item = items.get(position);

        // 设置文本数据
        holder.binding.titleTxt.setText(item.title);
        holder.binding.priceTxt.setText(item.price + "$");
        holder.binding.bedTxt.setText(String.valueOf(item.bed));
        holder.binding.bathTxt.setText(String.valueOf(item.bath));

        // 加载图片 - 确保添加了Glide依赖
        if (item.pickPath != null && !item.pickPath.isEmpty()) {
            try {
                int resourceId = holder.itemView.getContext().getResources()
                        .getIdentifier(item.pickPath, "drawable", holder.itemView.getContext().getPackageName());
                Glide.with(holder.itemView.getContext())
                        .load(resourceId)
                        .into(holder.binding.itemImage);
            } catch (Exception e) {
                Log.e("ItemsAdapter", "Error loading image: " + e.getMessage());
            }
        }

        holder.itemView.setOnClickListener(view -> {
            // 点击事件处理
            Intent intent = new Intent(context, DetailActivity.class);
            intent.putExtra("object", item);
            context.startActivity(intent);
        });
    }

    @Override
    public int getItemCount() {
        return items.size();
    }
}


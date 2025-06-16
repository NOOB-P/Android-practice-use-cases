package com.example.app_instances.Activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.app_instances.R;
import com.example.app_instances.databinding.ActivityDetailBinding;
import com.example.app_instances.modle.ItemsDomain;

public class DetailActivity extends AppCompatActivity {
    private ActivityDetailBinding binding;
    private ItemsDomain item;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityDetailBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );

        Getbundle();
        SetVariable();

        binding.backbtn.setOnClickListener(v -> {
            finish();
        });
    }

    private void SetVariable() {
        binding.titleTxt.setText(item.title);
        binding.typeTxt.setText(item.type);
        binding.priceTxt.setText(item.price + "$");
        binding.bedTxt.setText(String.valueOf(item.bed));
        binding.BathTxt.setText(String.valueOf(item.bath));
        binding.descriptionTxt.setText(item.description);
        binding.sizeTxt.setText(item.size + "m^2");
        binding.scoreTxt.setText(String.valueOf(item.score));
        binding.cargarageTxt.setText(item.isGarage?"yes":"no");
        binding.addressTxt.setText(item.address);

        // 加载图片 - 确保添加了Glide依赖
        if (item.pickPath != null && !item.pickPath.isEmpty()) {
            try {
                int resourceId = getResources()
                        .getIdentifier(item.pickPath, "drawable", getPackageName());
                Glide.with(this)
                        .load(resourceId)
                        .into(binding.detailpic);
            } catch (Exception e) {
                Log.e("ItemsAdapter", "Error loading image: " + e.getMessage());
            }
        }
    }

    private void Getbundle() {
        item = (ItemsDomain)getIntent().getSerializableExtra("object");
    }
}

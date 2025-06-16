package com.example.app_instances.Activity;

import android.os.Bundle;
import android.util.Log;
import android.view.WindowManager;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.app_instances.Adapter.ItemsAdapter;
import com.example.app_instances.R;
import com.example.app_instances.databinding.ActivityMainBinding;
import com.example.app_instances.modle.ItemsDomain;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        InitList();

        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
                WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        );
    }

    private void InitList() {
        ArrayList<ItemsDomain> items = new ArrayList<>();
        items.add(new ItemsDomain(
                "Apartment", // type
                "Sunny Modern Apartment", // title
                "123 Main St, Manhattan, NY", // address
                "item_1", // picPath
                2800, // price (美元/月)
                2, // bed (卧室)
                1, // bath (卫生间)
                950, // size (平方英尺)
                true, // isGarage (有车库)
                4.8, // score (评分)
                "Bright apartment with city views and modern appliances."
        ));
        items.add(new ItemsDomain(
                "House", // type
                "Cozy Suburban House", // title
                "456 Oak Ave, Brooklyn, NY", // address
                "item_2", // picPath
                4200, // price
                4, // bed
                2, // bath
                2000, // size
                true, // isGarage
                4.9, // score
                "Spacious family home with backyard and garage."
        ));
        items.add(new ItemsDomain(
                "Studio", // type
                "Affordable Downtown Studio", // title
                "789 Pine St, Queens, NY", // address
                "item_3", // picPath
                1600, // price
                1, // bed (Studio 通常算1个房间)
                1, // bath
                600, // size
                false, // isGarage (无车库)
                4.2, // score
                "Compact studio ideal for singles, close to subway."
        ));
        items.add(new ItemsDomain(
                "Penthouse", // type
                "Luxury Penthouse with Pool", // title
                "101 Skyline Dr, Manhattan, NY", // address
                "item_4", // picPath
                12000, // price
                3, // bed
                3, // bath
                3500, // size
                true, // isGarage
                5.0, // score
                "Stunning penthouse with private pool and panoramic views."
        ));
        binding.recomendedView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
        binding.recomendedView.setAdapter(new ItemsAdapter(this, items));
        binding.navigationBar.setItemSelected(0, true);
    }
}
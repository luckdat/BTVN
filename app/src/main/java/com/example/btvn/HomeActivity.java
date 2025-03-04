package com.example.btvn;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.viewpager2.widget.ViewPager2;

import java.util.Arrays;
import java.util.List;

public class HomeActivity extends AppCompatActivity {

    ImageView person;
    ViewPager2 weekViewPager;

    // Danh sách hình ảnh và số tuần
    private List<Integer> imageList = Arrays.asList(
            R.drawable.week1,
            R.drawable.week2,
            R.drawable.week3,
            R.drawable.week4,
            R.drawable.week5
    );
    private List<String> weekList = Arrays.asList(
            "Week 31", "Week 32", "Week 33", "Week 34", "Week 35"
    );

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // Xử lý sự kiện khi nhấn vào avatar để mở ProfileActivity
        person = findViewById(R.id.person);
        person.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(HomeActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        // Khởi tạo ViewPager2 để hiển thị tuần
        weekViewPager = findViewById(R.id.weekViewPager);
        WeekPagerAdapter adapter = new WeekPagerAdapter(imageList, weekList);
        weekViewPager.setAdapter(adapter);
    }
}

package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;

import com.team5.adapter.FeedbackAdapter;
import com.team5.adapter.SanPhamAdapter;
import com.team5.model.Product;
import com.team5.model.SanPham;

import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;

public class Activity_LikedProducts extends AppCompatActivity {

    GridView gvSanPham;

    SanPhamAdapter adapter;
    ArrayList<SanPham> sanpham;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_liked_products);

        linkViews();
        initAdapter();
        loadData();
    }

    private void linkViews() {
        gvSanPham = findViewById(R.id.gvSanPham);

    }

    private void initAdapter() {

        sanpham =Activity_TrangChu.mangLikedSP;

    }
    private void loadData() {
        adapter = new SanPhamAdapter(Activity_LikedProducts.this,R.layout.likeditem_list, sanpham);
        gvSanPham.setAdapter(adapter);

    }

    public void trangchu(MenuItem item) {
        Intent intent = new Intent(Activity_LikedProducts.this, com.team5.myapplication.Activity_TrangChu.class);
        startActivity(intent);
    }

    public void yeuthich(MenuItem item) {
        Intent intent = new Intent(Activity_LikedProducts.this, com.team5.myapplication.Activity_LikedProducts.class);
        startActivity(intent);
    }

    public void muasam(MenuItem item) {
        Intent intent = new Intent(Activity_LikedProducts.this, com.team5.myapplication.Activity_GioHang.class);
        startActivity(intent);
    }

    public void timkiem(MenuItem item) {
        Intent intent = new Intent(Activity_LikedProducts.this, com.team5.myapplication.Activity_TimKiem.class);
        startActivity(intent);
    }

    public void taikhoan(MenuItem item) {
        Intent intent = new Intent(Activity_LikedProducts.this, com.team5.myapplication.Activity_TaiKhoan.class);
        startActivity(intent);
    }
}
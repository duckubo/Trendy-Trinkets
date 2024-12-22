package com.team5.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.team5.adapter.ChoXacNhanAdapter;

public class Activity_ChoXacNhan extends AppCompatActivity {

    ImageView btnBack, btnSearch, imvHinh;
    TextView txtTenSanPham,txtChoXacNhan, txtChoLayHang, txtDangGiao, txtDaGiao, txtSumSL, txtSoLuong,txtThongBao;
    Button btnLienHeShop;

    ListView lvChoXacNhan;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cho_xac_nhan);

        linkViews();
        addEvents();
        initData();
    }

    private void linkViews() {
        btnBack = findViewById(R.id.btnBack);
        btnSearch = findViewById(R.id.btnSearch);
        txtChoXacNhan = findViewById(R.id.txtChoXacNhan);
        txtChoLayHang = findViewById(R.id.txtChoLayHang);
        txtDangGiao = findViewById(R.id.txtDangGiao);
        txtDaGiao = findViewById(R.id.txtDaGiao);
        txtSumSL = findViewById(R.id.txtSumSL);
        txtSoLuong = findViewById(R.id.textViewSoLuong);
        txtThongBao = findViewById(R.id.txtThongBao);
        btnLienHeShop = findViewById(R.id.btnLienHeShop);
        lvChoXacNhan = findViewById(R.id.lvChoXacNhan);

        imvHinh =findViewById(R.id.imvHinh);
    }
    private void initData() {

        ChoXacNhanAdapter choXacNhanAdapter = new ChoXacNhanAdapter(Activity_ChoXacNhan.this, Activity_TrangChu.mangChoXacNhan);
        lvChoXacNhan.setAdapter(choXacNhanAdapter);
        if( Activity_TrangChu.mangChoXacNhan.size() <= 0){
            choXacNhanAdapter.notifyDataSetChanged();
            txtThongBao.setVisibility(View.VISIBLE);
            lvChoXacNhan.setVisibility(View.INVISIBLE);
        }else {
            choXacNhanAdapter.notifyDataSetChanged();
            txtThongBao.setVisibility(View.INVISIBLE);
            lvChoXacNhan.setVisibility(View.VISIBLE);
        }
        txtSumSL.setText(""+Activity_TrangChu.mangChoXacNhan.size());
//        } else {
//            Toast.makeText(this,"No Data", Toast.LENGTH_LONG).show();
//            // Handle the case where the key doesn't exist or the JSON string is null
//        }

    }
    private void addEvents() {
        btnBack.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ChoXacNhan.this, Activity_TrangChu.class));
            }
        });

        btnSearch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ChoXacNhan.this, Activity_TimKiem.class));
            }
        });

        btnLienHeShop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ChoXacNhan.this, Activity_Chat.class));
            }
        });
        txtChoLayHang.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ChoXacNhan.this, Activity_ChoLayHang.class));
            }
        });
        txtDangGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ChoXacNhan.this, Activity_DangGiao.class));
            }
        });
        txtDaGiao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(Activity_ChoXacNhan.this, Activity_DaGiao.class));
            }
        });
    }
}
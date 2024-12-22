package com.team5.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;


import com.team5.model.ChoXacNhan;
import com.team5.model.GioHang;
import com.team5.myapplication.R;

import java.text.DecimalFormat;
import java.util.ArrayList;

public class ChoXacNhanAdapter extends BaseAdapter {

    Context context;
    ArrayList<GioHang> choXacNhans;
    public ChoXacNhanAdapter(Context context, ArrayList<GioHang> choXacNhans) {
        this.context = context;
        this.choXacNhans = (choXacNhans != null) ? choXacNhans : new ArrayList<>();
    }

    @Override
    public int getCount() {
        return choXacNhans.size();
    }

    @Override
    public Object getItem(int i) {
        return choXacNhans.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }


    public class ViewHolder{

        public ImageView imvHinh;
        public TextView txtTenSanPham,txtGia, txtGiamGia, textViewSoLuong;

    }
    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ChoXacNhanAdapter.ViewHolder viewHolder = null;
        if(view == null){
            viewHolder = new ChoXacNhanAdapter.ViewHolder();

            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            view = inflater.inflate(R.layout.item_choxacnhan, null);

            viewHolder.imvHinh = view.findViewById(R.id.imvHinh);
            viewHolder.txtTenSanPham = view.findViewById(R.id.txtTenSanPham);
            viewHolder.txtGia = view.findViewById(R.id.txtGia);
            viewHolder.txtGiamGia = view.findViewById(R.id.txtGiamGia);
            viewHolder.textViewSoLuong = view.findViewById(R.id.textViewSoLuong);

            view.setTag(viewHolder);
        }else {
            viewHolder = (ChoXacNhanAdapter.ViewHolder) view.getTag();
        }

        GioHang gioHang = (GioHang) getItem(i);
        viewHolder.imvHinh.setImageResource(gioHang.getSanphamHinh());

        viewHolder.txtTenSanPham.setText(gioHang.getSanphamTen());

        DecimalFormat decimalFormat = new DecimalFormat("###,###,###");
        viewHolder.txtGia.setText(decimalFormat.format(gioHang.getSanphamGia()) + "Đ");
        viewHolder.txtGiamGia.setText(gioHang.getSanphamGiamGia());
        viewHolder.textViewSoLuong.setText(gioHang.getSoluongSP() + "");

        return view;
    }

}

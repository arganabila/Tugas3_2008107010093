package com.example.crud.adapter;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.crud.R;
import com.example.crud.model.data;

import java.util.Date;
import java.util.List;

public class adapter extends BaseAdapter {
    private Activity activity;
    private LayoutInflater inflater;
    private List<data> lists;

    public adapter(Activity activity, List<data> lists){
        this.activity = activity;
        this.lists = lists;
    }

    @Override
    public int getCount() {
        return lists.size();
    }

    @Override
    public Object getItem(int i) {
        return lists.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (inflater == null){
            inflater = (LayoutInflater) activity.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        }
        if (view == null && inflater!= null){
            view = inflater.inflate(R.layout.list_mahasiswa, null);
        }
        if (view != null){
            TextView Nama = view.findViewById(R.id.text_nama);
            TextView Jurusan = view.findViewById(R.id.text_jurusan);
            data data = lists.get(i);
            Nama.setText(data.getNama());
            Jurusan.setText(data.getJurusan());
         }
        return view;
    }
}

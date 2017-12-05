package com.example.tintash.abc.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.tintash.abc.R;

/**
 * Created by Tintash on 12/2/2017.
 */

public class DrawerAdapter extends BaseAdapter {
    private Context ctx;
    String[] names;
    int[] icons;

    public DrawerAdapter(Context ctx, String[] names, int[] icons) {
        this.ctx = ctx;
        this.names = names;
        this.icons = icons;
    }

    @Override
    public int getCount() {
        return names.length;
    }

    @Override
    public Object getItem(int position) {
        return null;
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(ctx).inflate(R.layout.row_drawer_item, null);
        }

        TextView tv = (TextView) convertView.findViewById(R.id.name);
        tv.setText(names[position]);

//        ImageView icon = (ImageView) convertView.findViewById(R.id.icon);
//        icon.setImageResource(icons[position]);

        return convertView;
    }
}


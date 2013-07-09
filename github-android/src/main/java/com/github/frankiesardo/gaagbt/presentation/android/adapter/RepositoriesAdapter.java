package com.github.frankiesardo.gaagbt.presentation.android.adapter;

import android.R;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.frankiesardo.gaagbt.entity.Repository;

public class RepositoriesAdapter extends ArrayListAdapter<Repository> {

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.simple_list_item_1, parent, false);
        }
        ((TextView) convertView).setText(getItem(position).getDescription());
        return convertView;
    }
}

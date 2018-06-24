package com.example.administrator.contactstest;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class PhoneAdapter extends ArrayAdapter<Phone> {
    private int resourceId;

    public PhoneAdapter(Context context, int textViewResourceId, List<Phone> objects){
        super(context,textViewResourceId,objects);
        resourceId = textViewResourceId;
    }

    //getView方法将每个子项被滚动到屏幕内时调用
    public View getView(int position, View convertView, ViewGroup parent){
        Phone phone= getItem(position);
        View view;
        ViewHolder viewHolder;

        //如果convertView为空，加载布局
        if (convertView == null){
            view = LayoutInflater.from(getContext()).inflate(resourceId,parent,false);
            viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.name);
            viewHolder.number = (TextView) view.findViewById(R.id.number);
            view.setTag(viewHolder);
        }
        //否则直接对convertView进行重用
        else{
            view = convertView;
            viewHolder = (ViewHolder)view.getTag();
        }
        viewHolder.name.setText(phone.getName());
        viewHolder.number.setText(phone.getNumber());
        return view;
    }

    //创建内部类用于对控件的缓存
    class ViewHolder{
        TextView name;
        TextView number;
    }
}


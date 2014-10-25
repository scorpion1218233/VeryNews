package com.scorpion.verynews.adapter;

import com.scorpion.verynews.R;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;

import java.util.ArrayList;
import java.util.List;

public class NewsListAdapter extends BaseAdapter {
	
	private LayoutInflater inflater;
    private List<String> list;
	
	public NewsListAdapter(Context context) {

        inflater = LayoutInflater.from(context);
        list  = new ArrayList<String>();
        list.add("String");
        list.add("String");
        list.add("String");
        list.add("String");
        list.add("String");
        list.add("String");
        list.add("String");
        list.add("String");
        list.add("String");
        list.add("String");


	}

    public void bindData(){

    }

	@Override
	public int getCount() {
		return 10;
	}

	@Override
	public Object getItem(int position) {
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {

		if (convertView == null) {
			convertView = inflater.inflate(R.layout.news_list_item_one_img, parent,false);
		}
		
		return convertView;
	}

}

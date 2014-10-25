package com.scorpion.verynews.fragment;

import com.scorpion.verynews.R;
import com.scorpion.verynews.adapter.NewsListAdapter;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class NewsListFragment extends Fragment{
	private NewsListAdapter newsListAdapter ;
	private ListView listView;
	
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		newsListAdapter = new NewsListAdapter(getActivity().getApplicationContext());
	}
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_news_list, container,false);
		
		listView = (ListView)view.findViewById(R.id.news_pulltorefresh);
		listView.setAdapter(newsListAdapter);
		
		return view;
	}
	

}

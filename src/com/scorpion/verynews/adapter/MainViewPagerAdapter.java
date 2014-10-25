package com.scorpion.verynews.adapter;

import java.util.List;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

public class MainViewPagerAdapter extends FragmentStatePagerAdapter {
	private List<Fragment> list ;

	public MainViewPagerAdapter(FragmentManager fm) {
		super(fm);
	}
	
	public void bindData(List<Fragment> list){
		this.list = list;
	}

	@Override
	public Fragment getItem(int position) {
		return list.get(position);
	}

	@Override
	public int getCount() {
		return list.size();
	}

}

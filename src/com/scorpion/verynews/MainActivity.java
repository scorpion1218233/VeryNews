package com.scorpion.verynews;

import java.util.ArrayList;
import java.util.List;


import com.scorpion.verynews.adapter.MainViewPagerAdapter;
import com.scorpion.verynews.fragment.NewsListFragment;

import android.R.integer;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.support.v4.view.ViewPager.OnPageChangeListener;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.Window;
import android.widget.Button;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

public class MainActivity extends FragmentActivity implements OnPageChangeListener, OnClickListener {
	
	private ViewPager viewPager;
	private List<Fragment> list;
	private MainViewPagerAdapter viewPagerAdapter;
	private HorizontalScrollView scrollView;
	private Button clickedButton = null;
	private LinearLayout btnGroup;
	
	//left和top用来定位scrollView中间控件的位置
	private int center;
	

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);           

        viewPager = (ViewPager)this.findViewById(R.id.main_viewpager);
        scrollView = (HorizontalScrollView)this.findViewById(R.id.main_scrollview);
        
        
        //获取ScrollView的子控件LinearLayout
        btnGroup = (LinearLayout)this.findViewById(R.id.btnGroup);
       
        //被选定的button默认是第一个
        clickedButton = (Button) btnGroup.getChildAt(0);
        
        //获取屏幕宽度，以便于达到ScrollView中的button在滑动时有滑动效果
        DisplayMetrics dm = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(dm);
        int widthOfPhone = dm.widthPixels;//宽度
        center = widthOfPhone/2;        
        
        //初始化List<Fragment> list;
        initList();        
        FragmentManager manager = getSupportFragmentManager();
        viewPagerAdapter = new MainViewPagerAdapter(manager);
        viewPagerAdapter.bindData(list);
        viewPager.setAdapter(viewPagerAdapter);        
        viewPager.setOnPageChangeListener(this);
        
        //对ScrollView的子控件btnGroup的所有button进行监控
        for (int i = 0; i < btnGroup.getChildCount(); i++) {
			Button button = (Button) btnGroup.getChildAt(i);
			button.setOnClickListener(this);
		}
        
    }

	/**
     * 初始化List<Fragment> list;
     */
	private void initList() {
		list = new ArrayList<Fragment>();
        list.add(new NewsListFragment());
        list.add(new NewsListFragment());
        list.add(new NewsListFragment());
        list.add(new NewsListFragment());
        list.add(new NewsListFragment());
        list.add(new NewsListFragment());
        list.add(new NewsListFragment());
        list.add(new NewsListFragment());
        list.add(new NewsListFragment());
        list.add(new NewsListFragment());
	}


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void onPageScrollStateChanged(int arg0) {
		
		
	}
	
	/**
	 * scrollView之中被选中的button改变显示效果
	 */
	private void scrollButtonClick(int position){
		//将之前选定的button的选定效果取消
		clickedButton.setBackground(getResources().getDrawable(R.drawable.button_hyaline));
		clickedButton.setTextColor(Color.BLACK);
		
		//设定当前选定的button的选定效果
		clickedButton = (Button) btnGroup.getChildAt(position);
		clickedButton.setBackground(getResources().getDrawable(R.drawable.title_btn_click_bg));
		clickedButton.setTextColor(Color.RED);
		
		//获取控件的宽度
		int btnWidth = clickedButton.getWidth();
		//获取控件的左边的X坐标
		int left = clickedButton.getLeft();
		
		//当前选中控件需要移动的距离，
		//needMove大于0，向左移动；小于0，向右移动
		int needMove = left+btnWidth/2-center;
        scrollView.smoothScrollTo(needMove, 0);
        
        
		
	}


	@Override
	public void onPageScrolled(int arg0, float arg1, int arg2) {
		// TODO Auto-generated method stub
		
	}


	@Override
	public void onPageSelected(int arg0) {
		// 改变ScrollView当前选定的button
		scrollButtonClick(arg0);
		
	}

	@Override
	public void onClick(View v) {
		int position = -1;
		switch (v.getId()) {
		case R.id.main_recommend_btn:
			position = 0;
			break;

		case R.id.main_hot_btn:
			position = 1;
			break;

		case R.id.main_entertainment_btn:
			position = 2;
			break;

		case R.id.main_sports_btn:
			position = 3;
			break;
			
		case R.id.main_social_btn:
			position = 4;
			break;

		case R.id.main_internet_btn:
			position = 5;
			break;
		case R.id.main_car_btn:
			position = 6;
			break;

		case R.id.main_digit_btn:
			position = 7;
			break;
		case R.id.main_military_btn:
			position = 8;
			break;

		case R.id.main_economics_btn:
			position = 9;
			break;

		default:
			break;
		}
		if (position!=-1) {
			scrollButtonClick(position);
			viewPager.setCurrentItem(position);
		}
	}
    
}

package com.example.cnki6187.miui;

import android.content.Context;
import android.net.Uri;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Toast;

import com.example.cnki6187.fragment.f1;
import com.example.cnki6187.fragment.f2;
import com.example.cnki6187.fragment.f3;
import java.util.ArrayList;
import java.util.List;

public class ViewPagerActivity extends AppCompatActivity
        implements f1.OnFragmentInteractionListener,f2.OnFragmentInteractionListener,f3.OnFragmentInteractionListener{

    private ViewPager viewPager;
    private List<Fragment> views;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FORCE_NOT_FULLSCREEN);
        setContentView(R.layout.activity_view_pager);
        viewPager=(ViewPager)findViewById(R.id.viewPager);
        LayoutInflater li=getLayoutInflater();
        views=new ArrayList<Fragment>();
        views.add(new f1());
        views.add(new f2());
        views.add(new f3());

//        views.add(li.inflate(R.layout.v1,null));
//        views.add(li.inflate(R.layout.v2,null));
//        views.add(li.inflate(R.layout.v3,null));

//        PagerAdapter pagerAdapter=new PagerAdapter() {
//            @Override
//            public Object instantiateItem(ViewGroup container, int position) {
//                container.addView(views.get(position));
//                return views.get(position);
//            }
//
//            @Override
//            public void destroyItem(ViewGroup container, int position, Object object) {
//                container.removeView(views.get(position));
//            }
//
//            @Override
//            public int getCount() {
//                return views.size();
//            }
//
//            @Override
//            public boolean isViewFromObject(View view, Object object) {
//                return view==object;
//            }
//
//            @Override
//            public CharSequence getPageTitle(int position) {
//                if(0==position)
//                    return "通讯录";
//                else if(1==position)
//                    return "短信";
//                else
//                    return "照片";
//            }
//        };
        FragmentPagerAdapter pagerAdapter=new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return views.get(position);
            }

            @Override
            public int getCount() {
                return views.size();
            }
        };
        viewPager.setAdapter(pagerAdapter);
        viewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                Toast.makeText(ViewPagerActivity.this,"No"+position+" view is selected",Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onPageScrollStateChanged(int state) {
                Toast.makeText(ViewPagerActivity.this,"the state is "+state ,Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}

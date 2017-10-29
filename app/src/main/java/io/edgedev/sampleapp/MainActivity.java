package io.edgedev.sampleapp;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;

import io.edgedev.sampleapp.databinding.ActivityMainBinding;

public class MainActivity extends AppCompatActivity {

    private final FirstFragment tab1 = new FirstFragment();
    private final SecondFragment tab2 = new SecondFragment();
    private TabLayout mTabLayout;
    private ViewPager mViewPager;
    private int tabPosition = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ActivityMainBinding binding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        mTabLayout = binding.tabLayout;
        mViewPager = binding.viewPager;
        mViewPager.setAdapter(new PagerAdapter(getSupportFragmentManager()));
        mTabLayout.addOnTabSelectedListener(new TabListener());
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(mTabLayout));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.action_change_txt)
            if (tabPosition == 0)
                tab1.changeTxt();
            else
                tab2.changeTxt();
        
        return super.onOptionsItemSelected(item);
    }

    private class TabListener implements TabLayout.OnTabSelectedListener {
        @Override
        public void onTabSelected(TabLayout.Tab tab) {
            tabPosition = tab.getPosition();
            mViewPager.setCurrentItem(tab.getPosition());

        }

        @Override
        public void onTabUnselected(TabLayout.Tab tab) {

        }

        @Override
        public void onTabReselected(TabLayout.Tab tab) {

        }
    }

    private class PagerAdapter extends FragmentStatePagerAdapter {
        public PagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            switch (position) {
                case 0:
                    return tab1;
                case 1:
                    return tab2;
                default:
                    return null;
            }
        }

        @Override
        public int getCount() {
            return mTabLayout.getTabCount();
        }
    }
}

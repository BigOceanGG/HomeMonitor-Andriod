package com.ocean.homemonitor.main;

import android.app.Activity;
import android.content.Intent;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.annotation.StringRes;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.content.ContextCompat;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.Toolbar;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;

import com.ocean.homemonitor.App;
import com.ocean.homemonitor.R;
import com.ocean.homemonitor.databinding.ActivityMainBinding;
import com.ocean.homemonitor.utils.Constants;
import com.ocean.homemonitor.utils.SPUtils;
import com.ocean.homemonitor.widget.BaseActivity;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class MainActivity extends BaseActivity {
    private ActivityMainBinding mBinding;
    private List<Fragment> mFragments = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mBinding = DataBindingUtil.setContentView(this, R.layout.activity_main);
        initView();
        initListener();
    }

    private void initView() {
        mFragments.add(HomeSceneFragment.newInstance());
        mFragments.add(HomeSettingFragment.newInstance());
        FragmentPagerAdapter adapter = new FragmentPagerAdapter(getSupportFragmentManager()) {
            @Override
            public Fragment getItem(int position) {
                return mFragments.get(position);
            }

            @Override
            public int getCount() {
                return mFragments.size();
            }
        };
        mBinding.vpMain.setAdapter(adapter);
        TabLayout tabLayout = mBinding.tlMain;
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.addTab(tabLayout.newTab());
        tabLayout.getTabAt(0).setCustomView(getTab(R.string.nav_scene, R.drawable.tab_wallet));
        tabLayout.getTabAt(1).setCustomView(getTab(R.string.nav_setting, R.drawable.tab_setting));
    }

    private void initListener() {
        mBinding.tlMain.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                mBinding.vpMain.setCurrentItem(tab.getPosition());
                int pos = tab.getPosition();
                for (int i = 0; i < mBinding.tlMain.getTabCount(); i++) {
                    View view = mBinding.tlMain.getTabAt(i).getCustomView();
                    TextView textView = view.findViewById(R.id.tv_text);
                    if (pos == i) {
                        textView.setTextColor(ContextCompat.getColor(mActivity, R.color.text_strong));
                    } else {
                        textView.setTextColor(ContextCompat.getColor(mActivity, R.color.text_weak));
                    }
                }
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
        mBinding.vpMain.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mBinding.tlMain.getTabAt(position).select();
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
    }

    private View getTab(@StringRes int name, int iconID) {
        View tabView = LayoutInflater.from(this).inflate(R.layout.item_tab, null);
        TextView tv = tabView.findViewById(R.id.tv_text);
        tv.setText(name);
        ImageView im = tabView.findViewById(R.id.iv_icon);
        im.setImageResource(iconID);
        return tabView;
    }

    public static void launch(Activity from, boolean closeOther) {
        if (closeOther) {
            App.getInstance().finishAllActivities(MainActivity.class);
        }
        Intent intent = new Intent(from, MainActivity.class);
        from.startActivity(intent);
    }

    public void changeLanguage() {
        changeAppLanguage();
        mApp.setLanguageChange(true);
        recreate();
    }

    private void changeAppLanguage() {
        Resources resources = getResources();
        int languageType = SPUtils.getInt(Constants.LANGUAGE, Constants.LAN_EN_US);
        Configuration config = resources.getConfiguration();
        if (languageType == Constants.LAN_EN_US) {
            config.locale = Locale.ENGLISH;
        } else {
            config.locale = Locale.SIMPLIFIED_CHINESE;
        }
        DisplayMetrics dm = resources.getDisplayMetrics();
        resources.updateConfiguration(config, dm);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}

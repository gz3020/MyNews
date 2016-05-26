package fence.mynews.ui.activity;

import android.support.v4.view.ViewPager;

import com.viewpagerindicator.TabPageIndicator;

import java.util.List;

import fence.mynews.model.entity.Channel;
import fence.mynews.model.mock.ChannelLab;
import fence.mynews.R;
import fence.mynews.ui.adapter.TabAdapter;
import fence.mynews.ui.base.BaseActivity;

public class MainActivity extends BaseActivity {

    private TabPageIndicator mTabTpi;
    private ViewPager mNewsVp;

    private TabAdapter mAdapter;
    private List<Channel> mChannels;

    @Override
    protected int getLayoutResId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initVariables() {
        mChannels = ChannelLab.getChannels();
        mAdapter = new TabAdapter(getSupportFragmentManager(), mChannels);
    }

    @Override
    protected void findViews() {
        mTabTpi = (TabPageIndicator) findViewById(R.id.main_tpi_tab);
        mNewsVp = (ViewPager) findViewById(R.id.main_vp_news);
    }

    @Override
    protected void setViews() {
        mNewsVp.setAdapter(mAdapter);
        mNewsVp.setOffscreenPageLimit(1);
        mTabTpi.setViewPager(mNewsVp);

        mTabTpi.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }

            @Override
            public void onPageSelected(int position) {
                mNewsVp.setCurrentItem(position);
            }

            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });

    }

    @Override
    protected void loadData() {

    }

    @Override
    public void onBackPressed() {
        finish();
    }
}

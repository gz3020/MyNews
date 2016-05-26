package fence.mynews.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import java.util.List;

import fence.mynews.model.entity.Channel;
import fence.mynews.ui.fragment.NewsFragment;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/12/16
 */
public class TabAdapter extends FragmentStatePagerAdapter {

    private final List<Channel> mChannels;

    public TabAdapter(FragmentManager fm, List<Channel> newses) {
        super(fm);
        mChannels = newses;
    }

    @Override
    public Fragment getItem(int position) {
        return NewsFragment.newInstance(mChannels.get(position));
    }

    @Override
    public int getCount() {
        return mChannels.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mChannels.get(position).getName();
    }

    @Override
    public int getItemPosition(Object object) {
        return POSITION_NONE;
    }
}

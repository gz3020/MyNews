package fence.mynews.ui.fragment;import android.os.Bundle;import android.os.Handler;import android.os.Message;import android.support.annotation.Nullable;import android.view.View;import android.widget.AbsListView;import android.widget.ListView;import android.widget.TextView;import android.widget.Toast;import com.handmark.pulltorefresh.library.PullToRefreshBase;import com.handmark.pulltorefresh.library.PullToRefreshListView;import org.litepal.crud.DataSupport;import java.util.ArrayList;import java.util.List;import fence.mynews.R;import fence.mynews.model.entity.Channel;import fence.mynews.model.entity.News;import fence.mynews.model.mock.NewsLab;import fence.mynews.ui.adapter.NewsAdapter;import fence.mynews.ui.base.BaseFragment;/** * @author fence * @version 1.0.0 * @description * @date 5/12/16 */public class NewsFragment extends BaseFragment {    private static final String CHANNEL = "channel";    private static final String NEWS = "news";    private static final String IS_FIRST_TIME_REFRESH = "is_first_time_refresh";    private static final String LAST_LEAVE_TIME = "last_leave_time";    private static final String FIRST_ITEM_TIME = "first_item_time";    private static final String LAST_ITEM_TIME = "last_item_time";    private static final String LISTVIEW_SCROLL_X = "listview_scroll_x";    private static final String LISTVIEW_SCROLL_Y = "listview_scroll_y";    private TextView mTipsTv;    private PullToRefreshListView mNewsListPtrlv;    private Channel mChannel;    private ArrayList<News> mNewses;    private NewsAdapter mAdapter;    private long mLastLeaveTime;    private boolean isFirstTimeRefresh;    private int mScrolledX = -1;    private int mScrolledY = -1;    public static NewsFragment newInstance(Channel channel) {        NewsFragment fragment = new NewsFragment();        Bundle args = new Bundle();        args.putParcelable(CHANNEL, channel);        fragment.setArguments(args);        return fragment;    }    @Override    protected int getLayoutResId() {        return R.layout.fragment_news;    }    @Override    public void onSaveInstanceState(Bundle outState) {        super.onSaveInstanceState(outState);        if (outState != null) {            outState.putParcelable(CHANNEL, mChannel);            // Fragment 上次离开时间（不可见时）            outState.putLong(LAST_LEAVE_TIME, mLastLeaveTime);            // 是否第一次刷新            outState.putBoolean(IS_FIRST_TIME_REFRESH, isFirstTimeRefresh);            // ListView 滚动的位置            outState.putInt(LISTVIEW_SCROLL_X, mScrolledX);            outState.putInt(LISTVIEW_SCROLL_Y, mScrolledY);            // 保存 Fragment 所有数据到数据库            if (mNewses.size() > 0) {                for (News news: mNewses) {                    // 设置入库时间                    news.setAddon(System.currentTimeMillis());                    if (news.isSaved()) {                        // 如果数据库中存在，则更新入库时间                        news.update(news.getId());                    } else {                        // 反之保存                        news.save();                    }                }                // 保存 ListView 中第一个和最后一个 Item 的入库时间，作为恢复查询数据库的条件                outState.putLong(FIRST_ITEM_TIME, mNewses.get(0).getAddon());                outState.putLong(LAST_ITEM_TIME, mNewses.get(mNewses.size() - 1).getAddon());            }        }    }    @Override    protected void initVariables(@Nullable Bundle savedInstanceState) {        if (savedInstanceState != null) {            mChannel = savedInstanceState.getParcelable(CHANNEL);            mLastLeaveTime = savedInstanceState.getLong(LAST_LEAVE_TIME);            isFirstTimeRefresh = savedInstanceState.getBoolean(IS_FIRST_TIME_REFRESH, true);            // ListView 的滚动位置            mScrolledX = savedInstanceState.getInt(LISTVIEW_SCROLL_X);            mScrolledY = savedInstanceState.getInt(LISTVIEW_SCROLL_Y);            // ListView 第一个和最后一个 Item 的入库时间            long firstItemTime = savedInstanceState.getLong(FIRST_ITEM_TIME);            long lastItemTime = savedInstanceState.getLong(LAST_ITEM_TIME);            // 从数据库中获取数据            mNewses = (ArrayList<News>) DataSupport                    .where("addon >= ? and addon <= ?",                            String.valueOf(firstItemTime),                            String.valueOf(lastItemTime))                    .order("addon asc")                    .find(News.class);        } else {            mNewses = (ArrayList<News>) DataSupport                    .where("addon < ?", String.valueOf(System.currentTimeMillis()))                    .limit(30)                    .find(News.class);            mChannel = getArguments().getParcelable(CHANNEL);            mLastLeaveTime = System.currentTimeMillis();            isFirstTimeRefresh = true;        }        mAdapter = new NewsAdapter(getActivity(), mNewses);    }    @Override    protected void findViews(View view) {        mNewsListPtrlv = (PullToRefreshListView) view.findViewById(R.id.news_ptrlv_newslist);        mTipsTv = (TextView) view.findViewById(R.id.news_tv_tips);    }    @Override    protected void setViews() {        mNewsListPtrlv.setAdapter(mAdapter);        if (mScrolledX != -1 && mScrolledY != -1) {            mNewsListPtrlv.scrollTo(mScrolledX, mScrolledY);        }        mNewsListPtrlv.setOnScrollListener(new AbsListView.OnScrollListener() {            @Override            public void onScrollStateChanged(AbsListView view, int scrollState) {                // 不滚动时保存当前滚动到的位置                if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {                        mScrolledX = mNewsListPtrlv.getScrollX();                        mScrolledY = mNewsListPtrlv.getScrollY();                }            }            @Override            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {            }        });        mNewsListPtrlv.setOnRefreshListener(new PullToRefreshBase.OnRefreshListener2<ListView>() {            @Override            public void onPullDownToRefresh(PullToRefreshBase<ListView> refreshView) {                new Thread() {                    @Override                    public void run() {                        try {                            Thread.sleep(1000);                            mHandler.sendEmptyMessage(0);                        } catch (InterruptedException e) {                            e.printStackTrace();                        }                    }                }.start();            }            @Override            public void onPullUpToRefresh(PullToRefreshBase<ListView> refreshView) {                new Thread() {                    @Override                    public void run() {                        try {                            Thread.sleep(1000);                            mHandler.sendEmptyMessage(1);                        } catch (InterruptedException e) {                            e.printStackTrace();                        }                    }                }.start();            }        });    }    private Handler mHandler = new Handler(new Handler.Callback() {        @Override        public boolean handleMessage(Message msg) {            if (isAdded()) {                List<News> newses = NewsLab.getNewsList(mChannel.getName());                switch (msg.what) {                    case 0:                        mNewses.addAll(0, newses);                        showTips(getActivity().getString(R.string.tips, newses.size()));                        break;                    case 1:                        mNewses.addAll(newses);                        break;                }                mAdapter.notifyDataSetChanged();                mNewsListPtrlv.onRefreshComplete();            }            return true;        }    });    private void showTips(final String tips) {        mTipsTv.setVisibility(View.VISIBLE);        mTipsTv.setText(tips);        mTipsTv.postDelayed(new Runnable() {            @Override            public void run() {                mTipsTv.setVisibility(View.GONE);            }        }, 2000);    }    @Override    protected void loadData() {        timedRefreshing();    }    /**     * 对用户可见     */    @Override    protected void lazyLoading() {        timedRefreshing();    }    /**     * 定时刷新     */    private void timedRefreshing() {        if (isVisibleToUser && isViewInited) {            if (mNewses.size() == 0 || isFirstTimeRefresh) {                autoRefresh();            } else {                // 每隔 10s 刷新一次                if (isTimeOut()) {                    Toast.makeText(getActivity(), "out of time", Toast.LENGTH_SHORT).show();                    autoRefresh();                }            }        }    }    /**     * 自动刷新     */    private void autoRefresh() {        isFirstTimeRefresh = false;        mNewsListPtrlv.setRefreshing(true);    }    /**     * 超时     *     * @return     */    private boolean isTimeOut() {        // 每隔 10s 刷新一次        return (System.currentTimeMillis() - mLastLeaveTime) > 10 * 1000;    }    /**     * 对用户不可见     */    @Override    protected void onInvisibleToUser() {        if (!isVisibleToUser && isViewInited) {            mNewsListPtrlv.onRefreshComplete();            mLastLeaveTime = System.currentTimeMillis();        }    }}
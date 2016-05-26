package fence.mynews.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

import fence.mynews.model.entity.News;
import fence.mynews.R;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/12/16
 */
public class NewsAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<News> mNewses;

    public NewsAdapter(Context context, List<News> newses) {
        mContext = context;
        mNewses = newses;
    }

    @Override
    public int getCount() {
        return mNewses.size();
    }

    @Override
    public News getItem(int position) {
        return mNewses.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_listview_news, parent, false);

            holder = new ViewHolder();
            holder.titleTv = (TextView) convertView.findViewById(R.id.item_news_tv_title);
            holder.dateTv = (TextView) convertView.findViewById(R.id.item_news_tv_date);
            holder.channelTv = (TextView) convertView.findViewById(R.id.item_news_tv_channel);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        News news = getItem(position);

        holder.titleTv.setText(news.getTitle());
        holder.dateTv.setText(news.getTime());
        holder.channelTv.setText(news.getChannel());

        return convertView;
    }

    class ViewHolder {
        TextView titleTv;
        TextView dateTv;
        TextView channelTv;
    }
}

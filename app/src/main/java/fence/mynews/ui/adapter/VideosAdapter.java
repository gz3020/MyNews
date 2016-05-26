package fence.mynews.ui.adapter;

import android.content.Context;
import android.net.Uri;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.VideoView;

import com.nostra13.universalimageloader.core.ImageLoader;

import java.util.List;

import fence.mynews.R;
import fence.mynews.model.entity.VideoResp;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/12/16
 */
public class VideosAdapter extends BaseAdapter {

    private final Context mContext;
    private final List<VideoResp.VideoListEntity> mVideos;

    public VideosAdapter(Context context, List<VideoResp.VideoListEntity> videos) {
        mContext = context;
        mVideos = videos;
    }

    @Override
    public int getCount() {
        return mVideos.size();
    }

    @Override
    public VideoResp.VideoListEntity getItem(int position) {
        return mVideos.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        ViewHolder holder = null;

        if (convertView == null) {
            convertView = LayoutInflater.from(mContext).inflate(R.layout.item_listview_video, parent, false);

            holder = new ViewHolder();
            holder.coverRlyt = (RelativeLayout) convertView.findViewById(R.id.item_video_rlyt_cover);
            holder.coverIv = (ImageView) convertView.findViewById(R.id.item_video_iv_cover);
            holder.playBtn = (Button) convertView.findViewById(R.id.item_video_btn_player);
            holder.videoVV = (VideoView) convertView.findViewById(R.id.item_video_vv_video);

            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        VideoResp.VideoListEntity video = getItem(position);
        final String videoUrl = video.getMp4Url();

        ImageLoader.getInstance().displayImage(videoUrl, holder.coverIv);

        final ViewHolder finalHolder = holder;

        holder.playBtn.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                finalHolder.coverRlyt.setVisibility(View.GONE);
                finalHolder.videoVV.setVideoURI(Uri.parse(videoUrl));
            }
        });

        return convertView;
    }

    class ViewHolder {
        RelativeLayout coverRlyt;
        ImageView coverIv;
        Button playBtn;
        VideoView videoVV;
    }
}

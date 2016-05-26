package fence.mynews.model.mock;

import com.google.gson.Gson;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fence.mynews.model.entity.News;
import fence.mynews.model.entity.VideoResp;
import fence.mynews.ui.util.FileUtil;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/12/16
 */
public class NewsLab {

    public static List<News> getNewsList(String channelName) {
        List<News> newses = new ArrayList<>();

        short pageSize = 15;

        for (int i = 0; i < pageSize; i ++) {
            String time = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
                    .format(new Date(System.currentTimeMillis()));

            News news = new News();
            news.setTitle("title " + i);
            news.setTime(time);
            news.setChannel(channelName);
            newses.add(news);
        }

        return newses;
    }

    public static List<VideoResp.VideoListEntity> getVideoList() {
        String videoJson = FileUtil.getAssetsBy("videos");
        VideoResp video = new Gson().fromJson(videoJson, VideoResp.class);
        return video.getVideoList();
    }
}

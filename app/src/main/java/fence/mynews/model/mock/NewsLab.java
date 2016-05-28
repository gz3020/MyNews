package fence.mynews.model.mock;

import org.litepal.crud.DataSupport;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import fence.mynews.model.entity.News;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/12/16
 */
public class NewsLab {

    /**
     * 从服务器获取新闻
     *
     * @param channelName 栏目名
     * @return
     */
    public static List<News> getNewsesFromServer(String channelName) {
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

    /**
     * 从数据库获取所有新闻
     *
     * @param channelName 栏目名
     * @return
     */
    public static List<News> getAllNewsesFromDB(String channelName) {
        return DataSupport
                .where("channel = ?", channelName)
                .find(News.class);
    }

    /**
     * 从数据库分页获取新闻
     *
     * @param channelName 栏目名
     * @param page 页码
     * @param limit 每页数量
     * @return
     */
    public static List<News> getNewsesFromDB(String channelName, int page, int limit) {
        return DataSupport
                .where("channel = ?", channelName)
                .limit(limit)
                .offset(limit * (page -1))
                .find(News.class);
    }

}

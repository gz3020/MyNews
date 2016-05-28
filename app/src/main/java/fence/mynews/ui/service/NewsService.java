package fence.mynews.ui.service;

import android.app.IntentService;
import android.content.Intent;
import android.content.Context;

import org.litepal.crud.DataSupport;

import java.util.ArrayList;

import fence.mynews.model.entity.News;

public class NewsService extends IntentService {

    public static final String NEWSES = "newses";
    public static final String CHANNEL = "channel";

    public static Intent newIntent(Context context, ArrayList<News> newses, String channel) {
        Intent intent = new Intent(context, NewsService.class);
        intent.putExtra(NEWSES, newses);
        intent.putExtra(CHANNEL, channel);
        return intent;
    }

    public NewsService() {
        super("NewsService");
    }

    @Override
    protected void onHandleIntent(Intent intent) {
        if (intent != null) {
            ArrayList<News> newses = (ArrayList<News>) intent.getSerializableExtra(NEWSES);
            String channel = intent.getStringExtra(CHANNEL);

            if (isNotEmpty(newses)) {
                // 删除旧的数据
                DataSupport.deleteAll(News.class, "channel = ?", channel);

                // 插入新的数据
                DataSupport.saveAll(newses);
            }
        }
    }

    private boolean isNotEmpty(ArrayList<News> newses) {
        return newses != null && newses.size() > 0;
    }

}

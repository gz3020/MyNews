package fence.mynews.ui;

import org.litepal.LitePalApplication;
import org.litepal.tablemanager.Connector;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/23/16
 */
public class NewsApplication extends LitePalApplication {

    public static NewsApplication sInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        sInstance = this;
        Connector.getDatabase();
    }

    public static NewsApplication getInstance() {
        return sInstance;
    }
}

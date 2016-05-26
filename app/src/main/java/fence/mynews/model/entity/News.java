package fence.mynews.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import org.litepal.crud.DataSupport;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/12/16
 */
public class News extends DataSupport implements Parcelable {

    private int id;
    private String title;
    private String time;
    private String channel;
    private long addon;

    public News() {}

    protected News(Parcel in) {
        title = in.readString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getChannel() {
        return channel;
    }

    public void setChannel(String channel) {
        this.channel = channel;
    }

    public long getAddon() {
        return addon;
    }

    public void setAddon(long addon) {
        this.addon = addon;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<News> CREATOR = new Creator<News>() {

        @Override
        public News createFromParcel(Parcel in) {
            return new News(in);
        }

        @Override
        public News[] newArray(int size) {
            return new News[size];
        }
    };
}

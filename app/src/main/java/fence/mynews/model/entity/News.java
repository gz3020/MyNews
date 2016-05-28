package fence.mynews.model.entity;

import org.litepal.crud.DataSupport;

import java.io.Serializable;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/12/16
 */
public class News extends DataSupport implements Serializable {

    private int id;
    private String title;
    private String time;
    private String channel;
    private long addon;

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

}

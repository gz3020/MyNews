package fence.mynews.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/12/16
 */
public class Channel implements Parcelable {

    private int mId;

    private String mName;

    public Channel() {}

    protected Channel(Parcel in) {
        mId = in.readInt();
        mName = in.readString();
    }

    public int getId() {
        return mId;
    }

    public void setId(int id) {
        mId = id;
    }

    public String getName() {
        return mName;
    }

    public void setName(String name) {
        mName = name;
    }


    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeInt(mId);
        dest.writeString(mName);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<Channel> CREATOR = new Creator<Channel>() {
        @Override
        public Channel createFromParcel(Parcel in) {
            return new Channel(in);
        }

        @Override
        public Channel[] newArray(int size) {
            return new Channel[size];
        }
    };
}

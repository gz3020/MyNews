package fence.mynews.model.entity;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * @author fence
 * @version 1.0.0
 * @description
 * @date 5/23/16
 */
public class VideoResp implements Parcelable {

    @SerializedName("videoHomeSid")
    private String mVideoHomeSid;

    @SerializedName("videoSidList")
    private List<VideoSidListEntity> mVideoSidList;

    @SerializedName("videoList")
    private List<VideoListEntity> mVideoList;

    public String getVideoHomeSid() {
        return mVideoHomeSid;
    }

    public void setVideoHomeSid(String videoHomeSid) {
        mVideoHomeSid = videoHomeSid;
    }

    public List<VideoSidListEntity> getVideoSidList() {
        return mVideoSidList;
    }

    public void setVideoSidList(List<VideoSidListEntity> videoSidList) {
        mVideoSidList = videoSidList;
    }

    public List<VideoListEntity> getVideoList() {
        return mVideoList;
    }

    public void setVideoList(List<VideoListEntity> videoList) {
        mVideoList = videoList;
    }

    public static class VideoSidListEntity {
        @SerializedName("sid")
        private String mSid;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("imgsrc")
        private String mImgsrc;

        public String getSid() {
            return mSid;
        }

        public void setSid(String sid) {
            mSid = sid;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        public String getImgsrc() {
            return mImgsrc;
        }

        public void setImgsrc(String imgsrc) {
            mImgsrc = imgsrc;
        }
    }

    public static class VideoListEntity {
        @SerializedName("topicImg")
        private String mTopicImg;
        @SerializedName("replyCount")
        private int mReplyCount;
        @SerializedName("videosource")
        private String mVideosource;
        @SerializedName("mp4Hd_url")
        private Object mMp4HdUrl;
        @SerializedName("topicDesc")
        private String mTopicDesc;
        @SerializedName("topicSid")
        private String mTopicSid;
        @SerializedName("cover")
        private String mCover;
        @SerializedName("title")
        private String mTitle;
        @SerializedName("playCount")
        private int mPlayCount;
        @SerializedName("replyBoard")
        private String mReplyBoard;
        @SerializedName("videoTopic")
        private VideoTopicEntity mVideoTopic;
        @SerializedName("sectiontitle")
        private String mSectiontitle;
        @SerializedName("replyid")
        private String mReplyid;
        @SerializedName("description")
        private String mDescription;
        @SerializedName("mp4_url")
        private String mMp4Url;
        @SerializedName("length")
        private int mLength;
        @SerializedName("playersize")
        private int mPlayersize;
        @SerializedName("m3u8Hd_url")
        private Object mM3u8HdUrl;
        @SerializedName("vid")
        private String mVid;
        @SerializedName("m3u8_url")
        private String mM3u8Url;
        @SerializedName("ptime")
        private String mPtime;
        @SerializedName("topicName")
        private String mTopicName;

        public String getTopicImg() {
            return mTopicImg;
        }

        public void setTopicImg(String topicImg) {
            mTopicImg = topicImg;
        }

        public int getReplyCount() {
            return mReplyCount;
        }

        public void setReplyCount(int replyCount) {
            mReplyCount = replyCount;
        }

        public String getVideosource() {
            return mVideosource;
        }

        public void setVideosource(String videosource) {
            mVideosource = videosource;
        }

        public Object getMp4HdUrl() {
            return mMp4HdUrl;
        }

        public void setMp4HdUrl(Object mp4HdUrl) {
            mMp4HdUrl = mp4HdUrl;
        }

        public String getTopicDesc() {
            return mTopicDesc;
        }

        public void setTopicDesc(String topicDesc) {
            mTopicDesc = topicDesc;
        }

        public String getTopicSid() {
            return mTopicSid;
        }

        public void setTopicSid(String topicSid) {
            mTopicSid = topicSid;
        }

        public String getCover() {
            return mCover;
        }

        public void setCover(String cover) {
            mCover = cover;
        }

        public String getTitle() {
            return mTitle;
        }

        public void setTitle(String title) {
            mTitle = title;
        }

        public int getPlayCount() {
            return mPlayCount;
        }

        public void setPlayCount(int playCount) {
            mPlayCount = playCount;
        }

        public String getReplyBoard() {
            return mReplyBoard;
        }

        public void setReplyBoard(String replyBoard) {
            mReplyBoard = replyBoard;
        }

        public VideoTopicEntity getVideoTopic() {
            return mVideoTopic;
        }

        public void setVideoTopic(VideoTopicEntity videoTopic) {
            mVideoTopic = videoTopic;
        }

        public String getSectiontitle() {
            return mSectiontitle;
        }

        public void setSectiontitle(String sectiontitle) {
            mSectiontitle = sectiontitle;
        }

        public String getReplyid() {
            return mReplyid;
        }

        public void setReplyid(String replyid) {
            mReplyid = replyid;
        }

        public String getDescription() {
            return mDescription;
        }

        public void setDescription(String description) {
            mDescription = description;
        }

        public String getMp4Url() {
            return mMp4Url;
        }

        public void setMp4Url(String mp4Url) {
            mMp4Url = mp4Url;
        }

        public int getLength() {
            return mLength;
        }

        public void setLength(int length) {
            mLength = length;
        }

        public int getPlayersize() {
            return mPlayersize;
        }

        public void setPlayersize(int playersize) {
            mPlayersize = playersize;
        }

        public Object getM3u8HdUrl() {
            return mM3u8HdUrl;
        }

        public void setM3u8HdUrl(Object m3u8HdUrl) {
            mM3u8HdUrl = m3u8HdUrl;
        }

        public String getVid() {
            return mVid;
        }

        public void setVid(String vid) {
            mVid = vid;
        }

        public String getM3u8Url() {
            return mM3u8Url;
        }

        public void setM3u8Url(String m3u8Url) {
            mM3u8Url = m3u8Url;
        }

        public String getPtime() {
            return mPtime;
        }

        public void setPtime(String ptime) {
            mPtime = ptime;
        }

        public String getTopicName() {
            return mTopicName;
        }

        public void setTopicName(String topicName) {
            mTopicName = topicName;
        }

        public static class VideoTopicEntity {
            @SerializedName("alias")
            private String mAlias;
            @SerializedName("tname")
            private String mTname;
            @SerializedName("ename")
            private String mEname;
            @SerializedName("tid")
            private String mTid;

            public String getAlias() {
                return mAlias;
            }

            public void setAlias(String alias) {
                mAlias = alias;
            }

            public String getTname() {
                return mTname;
            }

            public void setTname(String tname) {
                mTname = tname;
            }

            public String getEname() {
                return mEname;
            }

            public void setEname(String ename) {
                mEname = ename;
            }

            public String getTid() {
                return mTid;
            }

            public void setTid(String tid) {
                mTid = tid;
            }
        }
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(this.mVideoHomeSid);
        dest.writeList(this.mVideoSidList);
        dest.writeList(this.mVideoList);
    }

    public VideoResp() {
    }

    protected VideoResp(Parcel in) {
        this.mVideoHomeSid = in.readString();
        this.mVideoSidList = new ArrayList<VideoSidListEntity>();
        in.readList(this.mVideoSidList, VideoSidListEntity.class.getClassLoader());
        this.mVideoList = new ArrayList<VideoListEntity>();
        in.readList(this.mVideoList, VideoListEntity.class.getClassLoader());
    }

    public static final Parcelable.Creator<VideoResp> CREATOR = new Parcelable.Creator<VideoResp>() {
        @Override
        public VideoResp createFromParcel(Parcel source) {
            return new VideoResp(source);
        }

        @Override
        public VideoResp[] newArray(int size) {
            return new VideoResp[size];
        }
    };
}

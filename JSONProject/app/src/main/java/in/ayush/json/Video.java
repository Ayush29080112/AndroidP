package in.ayush.json;

import com.google.gson.annotations.SerializedName;

public class Video {

    @SerializedName("name")
    private String mName;
    @SerializedName("Duration")
    private int mDuration;

    public Video(String mName, int mDuration) {
        this.mName = mName;
        this.mDuration = mDuration;
    }

    @Override
    public String toString() {
        return "Video{" +
                "mName='" + mName + '\'' +
                ", mDuration=" + mDuration +
                '}';
    }
}

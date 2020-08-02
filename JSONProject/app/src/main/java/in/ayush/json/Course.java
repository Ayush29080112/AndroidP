package in.ayush.json;

import com.google.gson.annotations.SerializedName;

public class Course {

    @SerializedName("name")
    private String mName;
    @SerializedName("desc")
    private String mdesc;

    public Course(String mName, String mdesc) {
        this.mName = mName;
        this.mdesc = mdesc;
    }

    @Override
    public String toString() {
        return "Course{" +
                "mName='" + mName + '\'' +
                ", mdesc='" + mdesc + '\'' +
                '}';
    }
}

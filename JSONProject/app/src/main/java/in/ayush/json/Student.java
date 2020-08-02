package in.ayush.json;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class Student {
    private String name;
    private String email;
    private int courseCount;
    @SerializedName("course")
    private Course mCourse;

    private List<Video> videos;
    public Student(String name, String email, int courseCount,Course course,List<Video>  videos) {
        this.name = name;
        this.email = email;
        this.courseCount = courseCount;
        this.mCourse = course;
        this.videos = videos;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getCourseCount() {
        return courseCount;
    }

    public void setCourseCount(int courseCount) {
        this.courseCount = courseCount;
    }

    public Course getCourse() {
        return mCourse;
    }

    public void setCourse(Course course) {
        this.mCourse = course;
    }



    public List<Video> getVideos() {
        return videos;
    }

    public void setVideos(List<Video> videos) {
        this.videos = videos;
    }
}

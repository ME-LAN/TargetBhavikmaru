package bhavikmaru.target.augmetic.target_with_bhavikmaru;

public class Chapter {
    private String chapterName;

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    private String teacherName;
    private int numOfChapter;
    private int thumbnail;

    public Chapter() {
    }

    public Chapter(String chapterName, String teacherName) {
        this.chapterName = chapterName;
        this.teacherName = teacherName;
    }

    public Chapter(String chapterName, String teacherName, int thumbnail) {
        this.chapterName = chapterName;
        this.teacherName = teacherName;
        this.thumbnail = thumbnail;
    }

    public String getChapterName() {
        return chapterName;
    }

    public void setChapterName(String chapterName) {
        this.chapterName = chapterName;
    }

    public int getNumOfChapter() {
        return numOfChapter;
    }

    public void setNumOfChapter(int numOfChapter) {
        this.numOfChapter = numOfChapter;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }
}

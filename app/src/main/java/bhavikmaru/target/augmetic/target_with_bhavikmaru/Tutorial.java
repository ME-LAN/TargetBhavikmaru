package bhavikmaru.target.augmetic.target_with_bhavikmaru;

public class Tutorial {
    private String tutName,tutTime;
    private int thumbnail;
    private int numOfChapter;

    public Tutorial() {
    }

    public Tutorial(String tutName, String tutTime) {
        this.tutName = tutName;
        this.tutTime = tutTime;
    }

    public Tutorial(String tutName, String tutTime, int thumbnail) {
        this.tutName = tutName;
        this.tutTime = tutTime;
        this.thumbnail = thumbnail;
    }

    public String getTutName() {
        return tutName;
    }

    public void setTutName(String tutName) {
        this.tutName = tutName;
    }

    public String getTutTime() {
        return tutTime;
    }

    public void setTutTime(String tutTime) {
        this.tutTime = tutTime;
    }

    public int getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(int thumbnail) {
        this.thumbnail = thumbnail;
    }

    public int getNumOfChapter() {
        return numOfChapter;
    }

    public void setNumOfChapter(int numOfChapter) {
        this.numOfChapter = numOfChapter;
    }
}

package bhavikmaru.target.augmetic.target_with_bhavikmaru;

public class UserInfo {

    String uName, uemail, uid;

    public UserInfo() {
    }

    public UserInfo(String uName, String uemail, String uid) {
        this.uName = uName;
        this.uemail = uemail;
        this.uid = uid;
    }

    public String getuName() {
        return uName;
    }

    public void setuName(String uName) {
        this.uName = uName;
    }

    public String getUemail() {
        return uemail;
    }

    public void setUemail(String uemail) {
        this.uemail = uemail;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}

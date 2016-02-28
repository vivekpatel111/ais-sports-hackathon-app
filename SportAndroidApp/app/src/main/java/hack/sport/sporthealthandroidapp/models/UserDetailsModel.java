package hack.sport.sporthealthandroidapp.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by Abhishek Kumar on 2/26/2016.
 */
public class UserDetailsModel {

    public static UserDetailsModel userData = new UserDetailsModel();

    private String userToken;
    private String googleUserId;
    private String serverAuthCode;
    private String emailID;
    private String userName;
    private String DOB;
    private double age;
    private ArrayList<String> diseases;
    private HashMap<String , String> location;
    private String goals;
    private boolean term_accpeptance;
    private MetricsModel height;
    private MetricsModel weight;
    private String imageUrl;
    public UserDetailsModel() {
    }

    public UserDetailsModel(double age, String imageUrl, String serverAuthCode, String userToken, String googleUserId, String emailID, String userName, String DOB, ArrayList<String> diseases, HashMap<String, String> location, String goals, boolean term_accpeptance, MetricsModel height, MetricsModel weight) {
        this.serverAuthCode = serverAuthCode;
        this.userToken = userToken;
        this.age = age;
        this.googleUserId = googleUserId;
        this.emailID = emailID;
        this.userName = userName;
        this.DOB = DOB;
        this.diseases = diseases;
        this.location = location;
        this.goals = goals;
        this.term_accpeptance = term_accpeptance;
        this.height = height;
        this.weight = weight;
        this.imageUrl = imageUrl;
    }

    protected UserDetailsModel(Parcel in) {
        userToken = in.readString();
        googleUserId = in.readString();
        serverAuthCode = in.readString();
        emailID = in.readString();
        userName = in.readString();
        DOB = in.readString();
        diseases = in.createStringArrayList();
        goals = in.readString();
        term_accpeptance = in.readByte() != 0;
    }

    public String getUserToken() {
        return userToken;
    }

    public void setUserToken(String userToken) {
        this.userToken = userToken;
    }

    public String getGoogleUserId() {
        return googleUserId;
    }

    public void setGoogleUserId(String googleUserId) {
        this.googleUserId = googleUserId;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getDOB() {
        return DOB;
    }

    public void setDOB(String DOB) {
        this.DOB = DOB;
    }

    public ArrayList<String> getDiseases() {
        return diseases;
    }

    public void setDiseases(ArrayList<String> diseases) {
        this.diseases = diseases;
    }

    public HashMap<String, String> getLocation() {
        return location;
    }

    public void setLocation(HashMap<String, String> location) {
        this.location = location;
    }

    public String getGoals() {
        return goals;
    }

    public void setGoals(String goals) {
        this.goals = goals;
    }

    public boolean isTerm_accpeptance() {
        return term_accpeptance;
    }

    public void setTerm_accpeptance(boolean term_accpeptance) {
        this.term_accpeptance = term_accpeptance;
    }

    public MetricsModel getHeight() {
        return height;
    }

    public void setHeight(MetricsModel height) {
        this.height = height;
    }

    public MetricsModel getWeight() {
        return weight;
    }

    public void setWeight(MetricsModel weight) {
        this.weight = weight;
    }

    public String getServerAuthCode() {
        return serverAuthCode;
    }

    public void setServerAuthCode(String serverAuthCode) {
        this.serverAuthCode = serverAuthCode;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public double getAge() {
        return age;
    }

    public void setAge(double age) {
        this.age = age;
    }


    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("UserDetailsModel{");
        sb.append("userToken='").append(userToken).append('\'');
        sb.append(", googleUserId='").append(googleUserId).append('\'');
        sb.append(", serverAuthCode='").append(serverAuthCode).append('\'');
        sb.append(", emailID='").append(emailID).append('\'');
        sb.append(", userName='").append(userName).append('\'');
        sb.append(", DOB='").append(DOB).append('\'');
        sb.append(", diseases=").append(diseases);
        sb.append(", location=").append(location);
        sb.append(", goals='").append(goals).append('\'');
        sb.append(", term_accpeptance=").append(term_accpeptance);
        sb.append(", height=").append(height);
        sb.append(", weight=").append(weight);
        sb.append('}');
        return sb.toString();
    }
}

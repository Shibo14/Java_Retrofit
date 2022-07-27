package uz.khan.retrofit_java;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class BaseResponse {
    @SerializedName("total_count")
    int totalCount;
    @SerializedName("incomplete_results")
    boolean incompleteResults;
    List<GithubUser> items;


    public BaseResponse(int totalCount, boolean incompleteResults, List<GithubUser> items) {
        this.totalCount = totalCount;
        this.incompleteResults = incompleteResults;
        this.items = items;
    }
}
class GithubUser {
    String login;
    @SerializedName("avatar_url")
    String avatarUrl;

    public GithubUser(String login, String avatarUrl) {
        this.login = login;
        this.avatarUrl = avatarUrl;
    }
}

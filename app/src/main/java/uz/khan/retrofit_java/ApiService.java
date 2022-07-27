package uz.khan.retrofit_java;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {
    @GET("search/users?q=Game")
    Call<BaseResponse> getUsers();
}

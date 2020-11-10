package zj.com.bluetooth.retrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Path;

public interface MyGithubService {

        @GET("users/{user}/repos")
        Call<List<UserInfoBean>> getData(@Path("user") String user);

}

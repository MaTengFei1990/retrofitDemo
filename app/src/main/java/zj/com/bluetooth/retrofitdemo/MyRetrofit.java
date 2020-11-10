package zj.com.bluetooth.retrofitdemo;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {
    MyGithubService myGithubService;

    public MyRetrofit() {

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://api.github.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
         myGithubService = retrofit.create(MyGithubService.class);
    }

    public void  getUserList(String user, Callback<List<UserInfoBean> > callback ) {
        myGithubService.getData(user).enqueue(callback);
    }








}

package zj.com.bluetooth.retrofitdemo;

import android.security.identity.EphemeralPublicKeyNotFoundException;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class MyRetrofit {
    MyGithubService myGithubService;


    public  static MyRetrofit myRetrofit = new MyRetrofit();

    public static MyRetrofit getInstance(){
        return myRetrofit;
    }

    public MyRetrofit() {
        init();
    }

    private void init() {
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

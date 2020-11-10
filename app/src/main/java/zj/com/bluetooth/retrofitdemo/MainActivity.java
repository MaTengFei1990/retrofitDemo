package zj.com.bluetooth.retrofitdemo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;

import java.util.List;

import okhttp3.internal.Util;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        MyRetrofit myRetrofit=new MyRetrofit();
        /**
         * 替换成自己的github账号；
         */
        myRetrofit.getUserList("替换成自己的github账号", new Callback<List<UserInfoBean>>() {
            @Override
            public void onResponse(Call<List<UserInfoBean>> call, Response<List<UserInfoBean>> response) {
                List<UserInfoBean> body = response.body();
                for (UserInfoBean userInfoBean : body) {
                    Log.d("tag", userInfoBean.toString());
                }
            }

            @Override
            public void onFailure(Call<List<UserInfoBean>> call, Throwable t) {
                Log.d("onFailure",t.toString());
            }
        });


    }
}
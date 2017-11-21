package crazyjone.aacproject.Services;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/11/13.
 */

public class GetServices {


    public static Retrofit getMainHost()
    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.douban.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();
      return   retrofit;
    }
}

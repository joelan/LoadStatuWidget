package crazyjone.aacproject.Interface;

import crazyjone.aacproject.Services.Model.TopRankModel;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

/**
 * Created by Administrator on 2017/11/15.
 */

public interface Api {

    @GET("v2/movie/top250")
    Call<TopRankModel> moiveTopRank(@Query("start") int start, @Query("count") int count);

}

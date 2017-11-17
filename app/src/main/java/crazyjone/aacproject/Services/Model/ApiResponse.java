package crazyjone.aacproject.Services.Model;

import android.arch.lifecycle.MutableLiveData;

import java.io.IOException;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

/**
 * Created by Administrator on 2017/11/16.
 */

public abstract class ApiResponse<T> implements Call<T> {



    public interface Caller<T>
    {
        public void onResponse( MutableLiveData<T>  data,Call<T> call, Response<T> response);
        public void onFailure(Call<T> call, Throwable t);
    }

    public void  reponseenqueue(Caller<T> caller)
    {

        enqueue(new Callback<T>() {
            @Override
            public void onResponse(Call<T> call, Response<T> response) {

                T body=response.body();
                MutableLiveData<T> data=new MutableLiveData<T>();

                data.setValue(body);

                if(caller!=null)
                    caller.onResponse(data,call,response);
            }

            @Override
            public void onFailure(Call<T> call, Throwable t) {
                if(caller!=null)
                    caller.onFailure(call,t);
            }
        });

    }

    public   MutableLiveData<T>  executeresponse() throws IOException
    {
        Response<T>  response =execute() ;
        MutableLiveData<T> data=new MutableLiveData<T>();
        data.setValue(response.body());

        return data;
    }


    @Override
    public ApiResponse<T> clone() {
        try {
            return (ApiResponse<T>) super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }
}

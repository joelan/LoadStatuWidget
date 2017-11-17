package crazyjone.aacproject.Services.Model.CommonModel;

import android.arch.lifecycle.LiveData;
import android.support.annotation.MainThread;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.WorkerThread;

import crazyjone.aacproject.Services.Model.ApiResponse;

/**
 * Created by Administrator on 2017/11/16.
 */

public abstract class NetworkBoundResource<ResultType> {
    @WorkerThread
    protected abstract void saveCallResult(@NonNull ResultType item);

    // Called with the data in the database to decide whether it should be
    // fetched from the network.
    @MainThread
    protected abstract boolean shouldFetch(@Nullable ResultType data);

    // Called to get the cached data from the database
    @NonNull @MainThread
    protected abstract LiveData<ResultType> loadFromDb();

    // Called to create the API call.
    @NonNull @MainThread
    protected abstract LiveData<ApiResponse<ResultType>> createCall();

    // Called when the fetch fails. The child class may want to reset components
    // like rate limiter.


    @MainThread
    protected void onFetchFailed() {
    }

    // returns a LiveData that represents the resource, implemented
    // in the base class.
    public abstract  LiveData<Resource<ResultType>> getAsLiveData();
}

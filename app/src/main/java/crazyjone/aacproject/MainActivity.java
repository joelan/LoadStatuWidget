package crazyjone.aacproject;

import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProviders;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import crazyjone.aacproject.Interface.Api;
import crazyjone.aacproject.LiveData.NameViewModel;
import crazyjone.aacproject.Services.GetServices;
import crazyjone.aacproject.Services.Model.TopRankModel;
import crazyjone.loadinglibrary.View.LoadingStateWidget;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {


    Button change;

    TextView name;

    NameViewModel  mModel;
    LinearLayout contain;

    LoadingStateWidget state;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

      //  change=(Button)findViewById(R.id.change);
      //  name=(TextView)findViewById(R.id.name);
        contain=(LinearLayout)findViewById(R.id.mylayout) ;

        state=new LoadingStateWidget();
        state.Attach(contain);


        findViewById(R.id.button).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state.loadingState();

            }
        });

        findViewById(R.id.button2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state.networkState();

            }
        });

        findViewById(R.id.button3).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state.normalState();
            }
        });

        findViewById(R.id.button4).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state.emptyState();
            }
        });



        // Get the ViewModel.
        mModel = ViewModelProviders.of(this).get(NameViewModel.class);

        // Create the observer which updates the UI.
        final Observer<String> nameObserver = new Observer<String>() {
            @Override
            public void onChanged(@Nullable final String newName) {
                // Update the UI, in this case, a TextView.
                name.setText(newName);
            }
        };

        // Observe the LiveData, passing in this activity as the LifecycleOwner and the observer.

        mModel.getCurrentName().observe(this, nameObserver);
    /*    change.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String anotherName = "John Doe";
                mModel.getCurrentName().setValue(anotherName);

            }
        });*/

        Api service=   GetServices.getMainHost().create(Api.class);

       // ApiResponse<TopRankModel> apiResponse=service.moiveTopRank(0,100);
        Call<TopRankModel> call=service.moiveTopRank(0,100);
       call.enqueue(new Callback<TopRankModel>() {
            @Override
            public void onResponse(Call<TopRankModel> call, Response<TopRankModel> response) {

                TopRankModel model=response.body();

                Toast.makeText(MainActivity.this,  model.getSubjects().get(0).getTitle(), Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<TopRankModel> call, Throwable t) {

                Toast.makeText(MainActivity.this, "failed", Toast.LENGTH_SHORT).show();


            }
        });

   /*     apiResponse.reponseenqueue(new ApiResponse.Caller<TopRankModel>() {
            @Override
            public void onResponse(MutableLiveData<TopRankModel> data, Call<TopRankModel> call, Response<TopRankModel> response) {

                TopRankModel dte=    data.getValue();
                Log.i("titile",dte.getTitle());
            }

            @Override
            public void onFailure(Call<TopRankModel> call, Throwable t) {

            }
        });
*/





    }
}

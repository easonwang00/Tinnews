package com.laioffer.tinnews;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.fragment.NavHostFragment;
import androidx.navigation.ui.NavigationUI;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.laioffer.tinnews.model.NewsResponse;
import com.laioffer.tinnews.network.NewsApi;
import com.laioffer.tinnews.network.RetrofitClient;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;


public class MainActivity extends AppCompatActivity {

    private NavController navController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView navView = findViewById(R.id.nav_view);

        NavHostFragment navHostFragment = (NavHostFragment) getSupportFragmentManager()
                .findFragmentById(R.id.nav_host_fragment);

        navController = navHostFragment.getNavController();

        NavigationUI.setupWithNavController(navView, navController);
        NavigationUI.setupActionBarWithNavController(this, navController);

        // HTTP request test
        NewsApi api = RetrofitClient.newInstance().create(NewsApi.class);

//        api.getEverything("",10).enqueue(new Callback<NewsResponse>() {
//            @Override
//            public void onResponse(Call<NewsResponse> call, Response<NewsResponse> response) {
//                if(response.isSuccessful()){
//                    Log.d("getEverything", "onResponse: " + response.body().toString());
//                }else{
//                    Log.d("getTopHeadlines", "onResponse: " + response.toString());
//                }
//            }
//
//            @Override
//            public void onFailure(Call<NewsResponse> call, Throwable t) {
//                Log.d("getTopHeadlines", "onFailure: " + t.toString());
//            }
//        });


    }

    @Override
    public boolean onSupportNavigateUp() {
        return navController.navigateUp();
    }
}
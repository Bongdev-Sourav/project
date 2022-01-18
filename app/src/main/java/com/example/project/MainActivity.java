package com.example.project;

import static android.service.controls.ControlsProviderService.TAG;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    LinearLayoutManager layoutManager;
    EmployeeAdapter adapter;
    List<EmployeeModel> list=new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        recyclerView=findViewById(R.id.recyclerView);


        layoutManager=new LinearLayoutManager(this);
        recyclerView.setLayoutManager(layoutManager);

        adapter=new EmployeeAdapter((ArrayList<EmployeeModel>) list,this);
        recyclerView.setAdapter(adapter);

        fetchposts();



    }

    public void fetchposts(){
        RetrofitClient.getRetrofitClient().getPosts().enqueue(new Callback<List<EmployeeModel>>() {
            @Override
            public void onResponse(Call<List<EmployeeModel>> call, Response<List<EmployeeModel>> response) {
                if (response.isSuccessful() && response.body() != null){
                    list.addAll(response.body());
//
                    adapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<EmployeeModel>> call, Throwable t) {

                Log.d(TAG,""+t.getMessage());

                Toast.makeText(MainActivity.this, "Problem is:"+ t, Toast.LENGTH_LONG).show();

            }
        });
    }
}
package uz.khan.retrofit_java;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.Objects;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Objects.requireNonNull(getSupportActionBar()).hide();
        RecyclerView recyclerView = findViewById(R.id.rv);
        UsersRecyclerAdapter adapter = new UsersRecyclerAdapter();
        recyclerView.setAdapter(adapter);

        try {
            ApiClient.service.getUsers().enqueue(new Callback<BaseResponse>() {
                @Override
                public void onResponse(@NonNull Call<BaseResponse> call, @NonNull Response<BaseResponse> response) {
                    if (response.isSuccessful()) {
                        assert response.body() != null;
                        adapter.submitData(response.body().items);
                    }
                }

                @Override
                public void onFailure(@NonNull Call<BaseResponse> call, @NonNull Throwable t) {
                    t.printStackTrace();
                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
package android.example.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.List;

import pl.droidsonroids.gif.GifImageView;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Rating extends AppCompatActivity {
    private TextView textViewResult, no_connection;
    public static int count_users = 0;
    public int place = 0, c2 = 0;

    @Override
    protected void onStart() {
        super.onStart();
        GifImageView gifImageView = findViewById(R.id.internet);
        gifImageView.setVisibility(View.INVISIBLE);

        textViewResult = findViewById(R.id.text_view_result);
        no_connection = findViewById(R.id.no_connection);

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://young-reaches-53543.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi jsonPlaceHolderApi = retrofit.create(JsonPlaceHolderApi.class);

        Call<List<Post>> call = jsonPlaceHolderApi.getPosts();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post> posts = response.body();

                for (Post post : posts) {
                    c2++;
                    if (post.getName().equals(MainActivity.savedText)) {
                        place = c2;
                        break;
                    }
                }


                for (Post post : posts) {
                    count_users++;
                    if (count_users < 11) {
                        String content = "";
                        content += count_users + "." + "Игрок: " + post.getName() + "\n\n";
                        if (count_users != 10) {
                            content += "   Очки: " + post.getScore() + "\n\n\n\n";
                        } else content += "    Очки: " + post.getScore() + "\n\n\n\n";
                        textViewResult.append(content);
                    }
                }


                TextView my_top = findViewById(R.id.position_in_top);
                my_top.setText("Вы на " + place + " месте");

            }


            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {
                no_connection.setText("Нет интернет соединения");
                gifImageView.setVisibility(View.VISIBLE);
            }
        });

    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_rating);


        getSupportActionBar().hide();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.rating);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.challenges:
                        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.rating:
                        return true;
                }
                return false;
            }
        });
    }


    @Override
    protected void onPause() { // при смене активности count=0, чтобы выводил каждый раз топ-10,
        // а не увеличивался до бесконечности при каждом открытии активности
        super.onPause();
        count_users = 0;
    }
}
package android.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;

    public boolean is_new_username=false;


    SharedPreferences sPref;

    private EditText Name;
    private Button Login;

    final String SAVED_TEXT = "saved_text";

    public static String savedText;


    private void saveUserName() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        savedText = Name.getText().toString();
        ed.putString(SAVED_TEXT, savedText);
        ed.apply();
        Toast.makeText(MainActivity.this, "Сохраняем имя пользователя: " + savedText, Toast.LENGTH_SHORT).show();
    }

    private String isNewUser() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        savedText = sPref.getString(SAVED_TEXT, "");
        Toast.makeText(MainActivity.this, "Загружаем имя пользователя: " + savedText, Toast.LENGTH_SHORT).show();
        return savedText;
    }


    @Override
    protected void onStart() {
        super.onStart();
        if (!isNewUser().isEmpty()) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        getSupportActionBar().hide();

        Name = (EditText) findViewById(R.id.enterName);
        Login = (Button) findViewById(R.id.btnLogin);

        Name.addTextChangedListener(loginTextWatcher); // блокировка кнопки

        Login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                validate(Name.getText().toString());
            }
        });
    }


    private TextWatcher loginTextWatcher = new TextWatcher() {
        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {

        }

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {
            String usernameInput = Name.getText().toString().trim();
            Login.setEnabled(!usernameInput.isEmpty());
        }

        @Override
        public void afterTextChanged(Editable s) {

        }
    };

    private void validate(String userName) { // получим с сервера всех пользователей и проверим, есть ли уже с таким именем
        textViewResult = findViewById(R.id.is_new_user);
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://young-reaches-53543.herokuapp.com/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApi2 jsonPlaceHolderApi2 = retrofit.create(JsonPlaceHolderApi2.class);

        Call<List<Post2>> call = jsonPlaceHolderApi2.getPosts();

        call.enqueue(new Callback<List<Post2>>() {
            @Override
            public void onResponse(Call<List<Post2>> call, Response<List<Post2>> response) {
                if (!response.isSuccessful()) {
                    textViewResult.setText("Code: " + response.code());
                    return;
                }

                List<Post2> posts = response.body();

                for (Post2 post : posts) {
                    String db_name = post.getName();
                    if (db_name.equals(userName)) {
                        is_new_username=false;
                    } else {
                        is_new_username = true;
                    }


                }

                if (is_new_username) {
                    saveUserName();

                    // добавление пользователя на сервер
                    Gson gson = new GsonBuilder()
                            .setLenient()
                            .create();
                    Retrofit retrofit = new Retrofit.Builder()
                            .baseUrl("https://young-reaches-53543.herokuapp.com/")
                            .addConverterFactory(GsonConverterFactory.create(gson))
                            .build();

                    UsersInfo controller = retrofit.create(UsersInfo.class);

                    Call<Boolean> call2 = controller.add(new Users(userName, 0));
                    call2.enqueue(new Callback<Boolean>() {
                        @Override
                        public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                            Boolean result = response.body();
                        }

                        @Override
                        public void onFailure(Call<Boolean> call, Throwable t) {

                        }
                    });


                    if (!isNewUser().isEmpty()) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                    } // логинимся и добавляемся в бд
                } else {
                    textViewResult.setText("Такое имя уже занято");
                }

            }

            @Override
            public void onFailure(Call<List<Post2>> call, Throwable t) {
                textViewResult.setText(t.getMessage());
            }
        });


    }

}
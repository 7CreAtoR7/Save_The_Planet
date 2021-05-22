package android.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {
    private TextView textViewResult;

    public boolean is_new_username;

    private static List<String> list_names = new ArrayList<>();


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
    }

    private String isNewUser() {
        sPref = getSharedPreferences("MyPref", MODE_PRIVATE);
        savedText = sPref.getString(SAVED_TEXT, "");
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
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

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
                // добавим имена в отдельный список
                for (Post2 post_in_list : posts) {
                    String db_name = post_in_list.getName();
                    list_names.add(db_name);
                }

                System.out.println(list_names);
                System.out.println("В списке имя " + userName + ":" + list_names.contains(userName));


                if (list_names.contains(userName)) {
                    textViewResult.setText(" Такое имя уже занято");
                } else {
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
                            textViewResult.setText("Нет интернет соединения");
                        }
                    });


                    if (!isNewUser().isEmpty()) {
                        Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                        startActivity(intent);
                    }
                }
            }

            @Override
            public void onFailure(Call<List<Post2>> call, Throwable t) {
                textViewResult.setText("Нет интернет соединения");
            }
        });


    }

}
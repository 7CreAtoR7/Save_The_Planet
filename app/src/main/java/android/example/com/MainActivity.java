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
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

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

    private void validate(String userName) {
        saveUserName();
        if (!isNewUser().isEmpty()) {
            Intent intent = new Intent(MainActivity.this, SecondActivity.class);
            startActivity(intent);
        }

    }

}
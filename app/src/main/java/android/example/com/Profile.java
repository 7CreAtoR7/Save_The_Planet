package android.example.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import org.w3c.dom.Text;

public class Profile extends AppCompatActivity {

    private static final String SAVED_COMPLETE_MISSIONS = "";
    private static final String SAVED_ALL_SCORES = "";
    SharedPreferences sPref;

    public static String missions_;
    public static Integer missions;

    public static String scores_;
    public static Integer scores;


    private Integer isNewUserWithNoMissions() { // If application launches first, there are 0 complete missions
        sPref = getSharedPreferences("MyCountMissions", MODE_PRIVATE);
        missions_ = sPref.getString(SAVED_COMPLETE_MISSIONS, "");
        if (missions_.isEmpty()) {
            missions = 0;
        } else {
            missions = Integer.valueOf(missions_);
        }
        Toast.makeText(Profile.this, "Всего выполненных заданий Profile: " + missions, Toast.LENGTH_SHORT).show();

        return missions;
    }

    private Integer isNewUserWithNoScores() { // If application launches first, there are 0 scores
        sPref = getSharedPreferences("MyCountScores", MODE_PRIVATE);
        scores_ = sPref.getString(SAVED_ALL_SCORES, "");
        if (scores_.isEmpty()) {
            scores = 0;
        } else {
            scores = Integer.valueOf(scores_);
        }
        Toast.makeText(Profile.this, "Всего очков: " + scores, Toast.LENGTH_SHORT).show();

        return scores;
    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        TextView count_done_challengers = (TextView) findViewById(R.id.count_done_ex);
        count_done_challengers.setText(String.valueOf(isNewUserWithNoMissions()));

        TextView name_of_level = (TextView) findViewById(R.id.name_level);
        if (isNewUserWithNoMissions() < 5) {
            name_of_level.setText("«Новичок»");
        } else if (isNewUserWithNoMissions() >= 5 && isNewUserWithNoMissions() < 7) {
            name_of_level.setText("«Борец за природу»");
        } else if (isNewUserWithNoMissions() >= 7){
            name_of_level.setText("«Эколог»");
        }

        TextView count_scores = (TextView) findViewById(R.id.count_exp);
        count_scores.setText((String.valueOf(isNewUserWithNoScores())));

        TextView username = (TextView) findViewById(R.id.user_name);
        String name_input = String.valueOf(MainActivity.savedText);
        username.setText(name_input);


        getSupportActionBar().hide();

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.profile);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        return true;
                    case R.id.challenges:
                        startActivity(new Intent(getApplicationContext(), SecondActivity.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.rating:
                        startActivity(new Intent(getApplicationContext(), Rating.class));
                        overridePendingTransition(0, 0);
                        return true;
                }
                return false;
            }
        });
    }
}
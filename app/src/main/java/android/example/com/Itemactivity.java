package android.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Itemactivity extends AppCompatActivity implements DialogApp.DialogAppListener {
    TextView textView, main_info_mission, coins, is_complete_mis;
    Button btn_done;
    ImageView imageView;
    Boolean is_mis_complete = false;
    SharedPreferences sPref;

    private static final String SAVED_MISS1 = "";
    private static final String SAVED_MISS2 = "";
    private static final String SAVED_MISS3 = "";
    private static final String SAVED_MISS4 = "";
    private static final String SAVED_COMPLETE_MISSIONS = "";
    private static final String SAVED_MISS5 = "";
    private static final String SAVED_MISS6 = "";
    private static final String SAVED_MISS7 = "";
    private static final String SAVED_MISS8 = "";
    private static final String SAVED_MISS9 = "";
    private static final String SAVED_MISS10 = "";
    private static final String SAVED_ALL_SCORES = "";


    public int count_scores;
    public static String name_for_save;
    public static String number_mission1;
    public static String number_mission2;
    public static String number_mission3;
    public static String number_mission4;
    public static String number_mission5;
    public static String number_mission6;
    public static String number_mission7;
    public static String number_mission8;
    public static String number_mission9;
    public static String number_mission10;

    public static int count_compl_mis;
    public static int count_all_scores;

    private Integer getCountCompleteMissions() { // получаем количесвто выполненных заданий
        sPref = getSharedPreferences("MyCountMissions", MODE_PRIVATE);
        String missions_count = sPref.getString(SAVED_COMPLETE_MISSIONS, "");
        if (missions_count.isEmpty()) {
            count_compl_mis = 0;
        } else {
            count_compl_mis = Integer.parseInt(missions_count);
        }

        return count_compl_mis;
    }

    private void saveUserMissions(int miss_c) {
        sPref = getSharedPreferences("MyCountMissions", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        String savedText = String.valueOf(miss_c);
        ed.putString(SAVED_COMPLETE_MISSIONS, savedText);
        ed.apply();
    }

    private Integer getCountScores() { // получаем сколько очков
        sPref = getSharedPreferences("MyCountScores", MODE_PRIVATE);
        String scores_count = sPref.getString(SAVED_ALL_SCORES, "");
        if (scores_count.isEmpty()) {
            count_all_scores = 0;
        } else {
            count_all_scores = Integer.parseInt(scores_count);
        }

        return count_all_scores;
    }

    private void saveUserScores(int scores_c) {
        sPref = getSharedPreferences("MyCountScores", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        String savedText = String.valueOf(scores_c);
        ed.putString(SAVED_ALL_SCORES, savedText);
        ed.apply();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        setContentView(R.layout.activity_itemactivity);

        getSupportActionBar().hide();

        textView = (TextView) findViewById(R.id.txtitem);

        is_complete_mis = (TextView) findViewById(R.id.is_complete);

        String Tempholder = getIntent().getStringExtra("Listviewclickvalue");

        // обрабатываем каждое задание:

        if (Tempholder.equals("Задание #1")) {
            name_for_save = "Задание #1";
            imageView = findViewById(R.id.photo_bear);
            imageView.setVisibility(View.INVISIBLE);

            textView.setText(Tempholder);
            main_info_mission = (TextView) findViewById(R.id.mission_description);
            main_info_mission.setText(getApplicationContext().getString(R.string.mission_1));
            coins = (TextView) findViewById(R.id.coins_count);
            count_scores = 100;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "За выполнение задания Вы получите очков: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone1().isEmpty()) {
                is_complete_mis.setText("Задание выполнено!");
                btn_done.setVisibility(View.GONE);
            }

        } else if (Tempholder.equals("Задание #2")) {
            name_for_save = "Задание #2";
            imageView = findViewById(R.id.photo_bear);
            imageView.setVisibility(View.INVISIBLE);

            textView.setText(Tempholder);
            main_info_mission = (TextView) findViewById(R.id.mission_description);
            main_info_mission.setText(getApplicationContext().getString(R.string.mission_2));
            coins = (TextView) findViewById(R.id.coins_count);
            count_scores = 300;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "За выполнение задания Вы получите очков: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone2().isEmpty()) {
                is_complete_mis.setText("Задание выполнено!");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Интересная статья #1")) {
            name_for_save = "Интересная статья #1";
            imageView = findViewById(R.id.photo_bear);
            imageView.setVisibility(View.INVISIBLE);

            textView.setText(Tempholder);
            main_info_mission = (TextView) findViewById(R.id.mission_description);
            main_info_mission.setText(getApplicationContext().getString(R.string.mission_3));
            coins = (TextView) findViewById(R.id.coins_count);
            count_scores = 150;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "За прочтение статьи Вы получите очков: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone3().isEmpty()) {
                is_complete_mis.setText("Задание выполнено!");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Задание #3")) {
            name_for_save = "Задание #3";
            imageView = findViewById(R.id.photo_bear);
            imageView.setVisibility(View.INVISIBLE);

            textView.setText(Tempholder);
            main_info_mission = (TextView) findViewById(R.id.mission_description);
            main_info_mission.setText(getApplicationContext().getString(R.string.mission_4));
            coins = (TextView) findViewById(R.id.coins_count);
            count_scores = 250;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "За выполнение задания Вы получите очков: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone4().isEmpty()) {
                is_complete_mis.setText("Задание выполнено!");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Совет #1")) {
            name_for_save = "Совет #1";
            imageView = findViewById(R.id.photo_bear);
            imageView.setVisibility(View.INVISIBLE);

            textView.setText(Tempholder);
            main_info_mission = (TextView) findViewById(R.id.mission_description);
            main_info_mission.setText(getApplicationContext().getString(R.string.mission_5));
            coins = (TextView) findViewById(R.id.coins_count);
            count_scores = 50;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "За выполнение задания Вы получите очков: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone5().isEmpty()) {
                is_complete_mis.setText("Задание выполнено!");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Интересная статья #2")) {
            name_for_save = "Интересная статья #2";
            imageView = findViewById(R.id.photo_bear);
            imageView.setVisibility(View.VISIBLE);

            textView.setText(Tempholder);
            main_info_mission = (TextView) findViewById(R.id.mission_description);
            main_info_mission.setText(getApplicationContext().getString(R.string.mission_6));
            coins = (TextView) findViewById(R.id.coins_count);
            count_scores = 100;
            coins.setText("");

            TextView textView = findViewById(R.id.coins_count_txt);
            textView.setText("");

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setVisibility(View.INVISIBLE);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "За выполнение задания Вы получите очков: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone6().isEmpty()) {
                is_complete_mis.setText("Задание выполнено!");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Задание #4")) {
            name_for_save = "Задание #4";

            imageView = findViewById(R.id.photo_bear);
            imageView.setVisibility(View.INVISIBLE);

            textView.setText(Tempholder);
            main_info_mission = (TextView) findViewById(R.id.mission_description);
            main_info_mission.setText(getApplicationContext().getString(R.string.mission_7));
            coins = (TextView) findViewById(R.id.coins_count);
            count_scores = 700;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setVisibility(View.VISIBLE);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "За выполнение задания Вы получите очков: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone7().isEmpty()) {
                is_complete_mis.setText("Задание выполнено!");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Интересные факты #1")) {
            name_for_save = "Интересные факты #1";

            imageView = findViewById(R.id.photo_bear);
            imageView.setVisibility(View.INVISIBLE);

            textView.setText(Tempholder);
            main_info_mission = (TextView) findViewById(R.id.mission_description);
            main_info_mission.setText(getApplicationContext().getString(R.string.mission_8));
            coins = (TextView) findViewById(R.id.coins_count);
            count_scores = 50;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "За выполнение задания Вы получите очков: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone8().isEmpty()) {
                is_complete_mis.setText("Задание выполнено!");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Интересная статья #3")) {
            name_for_save = "Интересная статья #3";
            imageView = findViewById(R.id.photo_bear);
            imageView.setVisibility(View.INVISIBLE);

            textView.setText(Tempholder);
            main_info_mission = (TextView) findViewById(R.id.mission_description);
            main_info_mission.setText(getApplicationContext().getString(R.string.mission_9));
            coins = (TextView) findViewById(R.id.coins_count);
            count_scores = 200;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "За выполнение задания Вы получите очков: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone9().isEmpty()) {
                is_complete_mis.setText("Задание выполнено!");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Интересные факты #2")) {
            name_for_save = "Интересные факты #2";
            imageView = findViewById(R.id.photo_bear);
            imageView.setVisibility(View.INVISIBLE);

            textView.setText(Tempholder);
            main_info_mission = (TextView) findViewById(R.id.mission_description);
            main_info_mission.setText(getApplicationContext().getString(R.string.mission_10));
            coins = (TextView) findViewById(R.id.coins_count);
            count_scores = 250;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "За выполнение задания Вы получите очков: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone10().isEmpty()) {
                is_complete_mis.setText("Задание выполнено!");
                btn_done.setVisibility(View.GONE);
            }
        }
    }

    public void openDialog() {
        DialogApp dialogApp = new DialogApp();
        dialogApp.show(getSupportFragmentManager(), "example dialog");
    }


    private void saveCompletedMission1() {
        sPref = getSharedPreferences("MyPref1", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS1, "1");
        ed.apply();

    }

    private String isMissionAlreadyDone1() {
        sPref = getSharedPreferences("MyPref1", MODE_PRIVATE);
        number_mission1 = sPref.getString(SAVED_MISS1, "");

        return number_mission1;
    }

    private void saveCompletedMission2() {
        sPref = getSharedPreferences("MyPref2", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS2, "2");
        ed.apply();

    }

    private String isMissionAlreadyDone2() {
        sPref = getSharedPreferences("MyPref2", MODE_PRIVATE);
        number_mission2 = sPref.getString(SAVED_MISS2, "");

        return number_mission2;
    }

    private void saveCompletedMission3() {
        sPref = getSharedPreferences("MyPref3", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS3, "3");
        ed.apply();

    }

    private String isMissionAlreadyDone3() {
        sPref = getSharedPreferences("MyPref3", MODE_PRIVATE);
        number_mission3 = sPref.getString(SAVED_MISS3, "");

        return number_mission3;
    }

    private void saveCompletedMission4() {
        sPref = getSharedPreferences("MyPref4", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS4, "4");
        ed.apply();

    }

    private String isMissionAlreadyDone4() {
        sPref = getSharedPreferences("MyPref4", MODE_PRIVATE);
        number_mission4 = sPref.getString(SAVED_MISS4, "");

        return number_mission4;
    }

    private void saveCompletedMission5() {
        sPref = getSharedPreferences("MyPref5", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS5, "5");
        ed.apply();

    }

    private String isMissionAlreadyDone5() {
        sPref = getSharedPreferences("MyPref5", MODE_PRIVATE);
        number_mission5 = sPref.getString(SAVED_MISS5, "");

        return number_mission5;
    }

    private void saveCompletedMission6() {
        sPref = getSharedPreferences("MyPref6", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS6, "6");
        ed.apply();

    }

    private String isMissionAlreadyDone6() {
        sPref = getSharedPreferences("MyPref6", MODE_PRIVATE);
        number_mission6 = sPref.getString(SAVED_MISS6, "");

        return number_mission6;
    }

    private void saveCompletedMission7() {
        sPref = getSharedPreferences("MyPref7", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS7, "7");
        ed.apply();

    }

    private String isMissionAlreadyDone7() {
        sPref = getSharedPreferences("MyPref7", MODE_PRIVATE);
        number_mission7 = sPref.getString(SAVED_MISS7, "");
        return number_mission7;
    }

    private void saveCompletedMission8() {
        sPref = getSharedPreferences("MyPref8", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS8, "8");
        ed.apply();

    }

    private String isMissionAlreadyDone8() {
        sPref = getSharedPreferences("MyPref8", MODE_PRIVATE);
        number_mission8 = sPref.getString(SAVED_MISS8, "");

        return number_mission8;
    }

    private void saveCompletedMission9() {
        sPref = getSharedPreferences("MyPref9", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS9, "9");
        ed.apply();

    }

    private String isMissionAlreadyDone9() {
        sPref = getSharedPreferences("MyPref9", MODE_PRIVATE);
        number_mission9 = sPref.getString(SAVED_MISS9, "");

        return number_mission9;
    }

    private void saveCompletedMission10() {
        sPref = getSharedPreferences("MyPref10", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS10, "10");
        ed.apply();

    }

    private String isMissionAlreadyDone10() {
        sPref = getSharedPreferences("MyPref10", MODE_PRIVATE);
        number_mission10 = sPref.getString(SAVED_MISS10, "");

        return number_mission10;
    }


    Gson gson = new GsonBuilder()
            .setLenient()
            .create();
    Retrofit retrofit = new Retrofit.Builder()
            .baseUrl("https://young-reaches-53543.herokuapp.com/")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build();

    UsersInfoUpdate controller = retrofit.create(UsersInfoUpdate.class);


    @Override
    public void applyTexts() {
        is_complete_mis.setText("Задание выполнено");
        is_mis_complete = true;
        btn_done.setVisibility(View.GONE); // спрятали кнопку после выполнения задания

        if (name_for_save.equals("Задание #1")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission1();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 100;
            saveUserScores(c_scores);

            Call<Boolean> call = controller.update(new UsersUpdate(MainActivity.savedText, c_scores));
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    Boolean result = response.body();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                }
            });


        } else if (name_for_save.equals("Задание #2")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission2();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 300;
            saveUserScores(c_scores);

            Call<Boolean> call = controller.update(new UsersUpdate(MainActivity.savedText, c_scores));
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    Boolean result = response.body();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                }
            });

        } else if (name_for_save.equals("Интересная статья #1")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission3();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 150;
            saveUserScores(c_scores);

            Call<Boolean> call = controller.update(new UsersUpdate(MainActivity.savedText, c_scores));
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    Boolean result = response.body();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                }
            });

        } else if (name_for_save.equals("Задание #3")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission4();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 250;
            saveUserScores(c_scores);

            Call<Boolean> call = controller.update(new UsersUpdate(MainActivity.savedText, c_scores));
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    Boolean result = response.body();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                }
            });

        } else if (name_for_save.equals("Совет #1")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission5();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 50;
            saveUserScores(c_scores);

            Call<Boolean> call = controller.update(new UsersUpdate(MainActivity.savedText, c_scores));
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    Boolean result = response.body();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                }
            });

        } else if (name_for_save.equals("Интересная статья #2")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission6();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 100;
            saveUserScores(c_scores);

            Call<Boolean> call = controller.update(new UsersUpdate(MainActivity.savedText, c_scores));
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    Boolean result = response.body();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                }
            });

        } else if (name_for_save.equals("Задание #4")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission7();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 700;
            saveUserScores(c_scores);

            Call<Boolean> call = controller.update(new UsersUpdate(MainActivity.savedText, c_scores));
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    Boolean result = response.body();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                }
            });

        } else if (name_for_save.equals("Интересные факты #1")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission8();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 100;
            saveUserScores(c_scores);

            Call<Boolean> call = controller.update(new UsersUpdate(MainActivity.savedText, c_scores));
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    Boolean result = response.body();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                }
            });

        } else if (name_for_save.equals("Интересная статья #3")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission9();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 200;
            saveUserScores(c_scores);

            Call<Boolean> call = controller.update(new UsersUpdate(MainActivity.savedText, c_scores));
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    Boolean result = response.body();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                }
            });

        } else if (name_for_save.equals("Интересные факты #2")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission10();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 250;
            saveUserScores(c_scores);

            Call<Boolean> call = controller.update(new UsersUpdate(MainActivity.savedText, c_scores));
            call.enqueue(new Callback<Boolean>() {
                @Override
                public void onResponse(Call<Boolean> call, Response<Boolean> response) {
                    Boolean result = response.body();
                }

                @Override
                public void onFailure(Call<Boolean> call, Throwable t) {
                }
            });

        }
    }
}
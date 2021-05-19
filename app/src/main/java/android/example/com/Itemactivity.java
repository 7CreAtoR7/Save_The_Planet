package android.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Itemactivity extends AppCompatActivity implements DialogApp.DialogAppListener{

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

    TextView textView, main_info_mission, coins, is_complete_mis, name_mission;
    Button btn_done;

    Boolean is_mis_complete=false;
    SharedPreferences sPref;
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

    private Integer getCountCompleteMissions() { // получаем сколько заданий всего выполнил
        sPref = getSharedPreferences("MyCountMissions", MODE_PRIVATE);
        String missions_count = sPref.getString(SAVED_COMPLETE_MISSIONS, "");
        if (missions_count.isEmpty()) {
            count_compl_mis = 0;
        } else {
            count_compl_mis = Integer.parseInt(missions_count);
        }
        Toast.makeText(Itemactivity.this, "Всего выполненных заданий Item до подтверждения: " + count_compl_mis, Toast.LENGTH_SHORT).show();

        return count_compl_mis;
    }

    private void saveUserMissions(int miss_c) {
        sPref = getSharedPreferences("MyCountMissions", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        String savedText = String.valueOf(miss_c);
        ed.putString(SAVED_COMPLETE_MISSIONS, savedText);
        ed.apply();
        Toast.makeText(Itemactivity.this, "Сохраняем колво заданий равное : " + savedText, Toast.LENGTH_SHORT).show();
    }

    private Integer getCountScores() { // получаем сколько очков
        sPref = getSharedPreferences("MyCountScores", MODE_PRIVATE);
        String scores_count = sPref.getString(SAVED_ALL_SCORES, "");
        if (scores_count.isEmpty()) {
            count_all_scores = 0;
        } else {
            count_all_scores = Integer.parseInt(scores_count);
        }
        Toast.makeText(Itemactivity.this, "Всего очков Item до подтверждения: " + count_compl_mis, Toast.LENGTH_SHORT).show();

        return count_all_scores;
    }

    private void saveUserScores(int scores_c) {
        sPref = getSharedPreferences("MyCountScores", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        String savedText = String.valueOf(scores_c);
        ed.putString(SAVED_ALL_SCORES, savedText);
        ed.apply();
        Toast.makeText(Itemactivity.this, "Сохраняем колво очков равное : " + savedText, Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemactivity);

        getSupportActionBar().hide();

        textView=(TextView)findViewById(R.id.txtitem);

        is_complete_mis=(TextView)findViewById(R.id.is_complete);

        String Tempholder=getIntent().getStringExtra("Listviewclickvalue");

        // обрабатываем каждое задание:

        if (Tempholder.equals("Задание #1")) {
            name_for_save = "Задание #1";

            textView.setText(Tempholder);
            main_info_mission=(TextView)findViewById(R.id.mission_description);
            main_info_mission.setText("Текст задачи № 1");
            coins=(TextView)findViewById(R.id.coins_count);
            count_scores=100;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "Монет получишь: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone1().isEmpty()){
                is_complete_mis.setText("Задание уже выполнено");
                btn_done.setVisibility(View.GONE);
            }

        } else if (Tempholder.equals("Задание #2")) {
            name_for_save = "Задание #2";

            textView.setText(Tempholder);
            main_info_mission=(TextView)findViewById(R.id.mission_description);
            main_info_mission.setText("Текст задачи № 2");
            coins=(TextView)findViewById(R.id.coins_count);
            count_scores=222;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "Монет получишь: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone2().isEmpty()){
                is_complete_mis.setText("Задание уже выполнено");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Задание #3")) {
            name_for_save = "Задание #3";

            textView.setText(Tempholder);
            main_info_mission=(TextView)findViewById(R.id.mission_description);
            main_info_mission.setText("Текст задачи № 3");
            coins=(TextView)findViewById(R.id.coins_count);
            count_scores=222;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "Монет получишь: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone3().isEmpty()){
                is_complete_mis.setText("Задание уже выполнено");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Задание #4")) {
            name_for_save = "Задание #4";

            textView.setText(Tempholder);
            main_info_mission=(TextView)findViewById(R.id.mission_description);
            main_info_mission.setText("Текст задачи № 4");
            coins=(TextView)findViewById(R.id.coins_count);
            count_scores=400;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "Монет получишь: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone4().isEmpty()){
                is_complete_mis.setText("Задание уже выполнено");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Задание #5")) {
            name_for_save = "Задание #5";

            textView.setText(Tempholder);
            main_info_mission=(TextView)findViewById(R.id.mission_description);
            main_info_mission.setText("Текст задачи № 5");
            coins=(TextView)findViewById(R.id.coins_count);
            count_scores=500;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "Монет получишь: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone5().isEmpty()){
                is_complete_mis.setText("Задание уже выполнено");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Задание #6")) {
            name_for_save = "Задание #6";

            textView.setText(Tempholder);
            main_info_mission=(TextView)findViewById(R.id.mission_description);
            main_info_mission.setText("Текст задачи № 6");
            coins=(TextView)findViewById(R.id.coins_count);
            count_scores=600;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "Монет получишь: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone6().isEmpty()){
                is_complete_mis.setText("Задание уже выполнено");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Задание #7")) {
            name_for_save = "Задание #7";

            textView.setText(Tempholder);
            main_info_mission=(TextView)findViewById(R.id.mission_description);
            main_info_mission.setText("Текст задачи № 7");
            coins=(TextView)findViewById(R.id.coins_count);
            count_scores=777;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "Монет получишь: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone7().isEmpty()){
                is_complete_mis.setText("Задание уже выполнено");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Задание #8")) {
            name_for_save = "Задание #8";

            textView.setText(Tempholder);
            main_info_mission=(TextView)findViewById(R.id.mission_description);
            main_info_mission.setText("Текст задачи № 8");
            coins=(TextView)findViewById(R.id.coins_count);
            count_scores=800;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "Монет получишь: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone8().isEmpty()){
                is_complete_mis.setText("Задание уже выполнено");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Задание #9")) {
            name_for_save = "Задание #9";

            textView.setText(Tempholder);
            main_info_mission=(TextView)findViewById(R.id.mission_description);
            main_info_mission.setText("Текст задачи № 9");
            coins=(TextView)findViewById(R.id.coins_count);
            count_scores=900;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "Монет получишь: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone9().isEmpty()){
                is_complete_mis.setText("Задание уже выполнено");
                btn_done.setVisibility(View.GONE);
            }
        } else if (Tempholder.equals("Задание #10")) {
            name_for_save = "Задание #10";

            textView.setText(Tempholder);
            main_info_mission=(TextView)findViewById(R.id.mission_description);
            main_info_mission.setText("Текст задачи № 10");
            coins=(TextView)findViewById(R.id.coins_count);
            count_scores=1000;
            coins.setText(String.valueOf(count_scores));

            btn_done = (Button) findViewById(R.id.button_complete_mission);
            btn_done.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    openDialog();
                    Toast.makeText(getApplicationContext(), "Монет получишь: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

            if (!isMissionAlreadyDone10().isEmpty()){
                is_complete_mis.setText("Задание уже выполнено");
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
        Toast.makeText(Itemactivity.this, "Задание выполнено. Сохраняем", Toast.LENGTH_SHORT).show();
    }

    private String isMissionAlreadyDone1() {
        sPref = getSharedPreferences("MyPref1", MODE_PRIVATE);
        number_mission1 = sPref.getString(SAVED_MISS1, "");
        Toast.makeText(Itemactivity.this, "Загружаем выполнено ли задание", Toast.LENGTH_SHORT).show();
        return number_mission1;
    }

    private void saveCompletedMission2() {
        sPref = getSharedPreferences("MyPref2", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS2, "2");
        ed.apply();
        Toast.makeText(Itemactivity.this, "Задание выполнено. Сохраняем", Toast.LENGTH_SHORT).show();
    }

    private String isMissionAlreadyDone2() {
        sPref = getSharedPreferences("MyPref2", MODE_PRIVATE);
        number_mission2 = sPref.getString(SAVED_MISS2, "");
        Toast.makeText(Itemactivity.this, "Загружаем выполнено ли задание", Toast.LENGTH_SHORT).show();
        return number_mission2;
    }

    private void saveCompletedMission3() {
        sPref = getSharedPreferences("MyPref3", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS3, "3");
        ed.apply();
        Toast.makeText(Itemactivity.this, "Задание выполнено. Сохраняем", Toast.LENGTH_SHORT).show();
    }

    private String isMissionAlreadyDone3() {
        sPref = getSharedPreferences("MyPref3", MODE_PRIVATE);
        number_mission3 = sPref.getString(SAVED_MISS3, "");
        Toast.makeText(Itemactivity.this, "Загружаем выполнено ли задание", Toast.LENGTH_SHORT).show();
        return number_mission3;
    }

    private void saveCompletedMission4() {
        sPref = getSharedPreferences("MyPref4", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS4, "4");
        ed.apply();
        Toast.makeText(Itemactivity.this, "Задание выполнено. Сохраняем", Toast.LENGTH_SHORT).show();
    }

    private String isMissionAlreadyDone4() {
        sPref = getSharedPreferences("MyPref4", MODE_PRIVATE);
        number_mission4 = sPref.getString(SAVED_MISS4, "");
        Toast.makeText(Itemactivity.this, "Загружаем выполнено ли задание", Toast.LENGTH_SHORT).show();
        return number_mission4;
    }

    private void saveCompletedMission5() {
        sPref = getSharedPreferences("MyPref5", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS5, "5");
        ed.apply();
        Toast.makeText(Itemactivity.this, "Задание выполнено. Сохраняем", Toast.LENGTH_SHORT).show();
    }

    private String isMissionAlreadyDone5() {
        sPref = getSharedPreferences("MyPref5", MODE_PRIVATE);
        number_mission5 = sPref.getString(SAVED_MISS5, "");
        Toast.makeText(Itemactivity.this, "Загружаем выполнено ли задание", Toast.LENGTH_SHORT).show();
        return number_mission5;
    }

    private void saveCompletedMission6() {
        sPref = getSharedPreferences("MyPref6", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS6, "6");
        ed.apply();
        Toast.makeText(Itemactivity.this, "Задание выполнено. Сохраняем", Toast.LENGTH_SHORT).show();
    }

    private String isMissionAlreadyDone6() {
        sPref = getSharedPreferences("MyPref6", MODE_PRIVATE);
        number_mission6 = sPref.getString(SAVED_MISS6, "");
        Toast.makeText(Itemactivity.this, "Загружаем выполнено ли задание", Toast.LENGTH_SHORT).show();
        return number_mission6;
    }

    private void saveCompletedMission7() {
        sPref = getSharedPreferences("MyPref7", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS7, "7");
        ed.apply();
        Toast.makeText(Itemactivity.this, "Задание выполнено. Сохраняем", Toast.LENGTH_SHORT).show();
    }

    private String isMissionAlreadyDone7() {
        sPref = getSharedPreferences("MyPref7", MODE_PRIVATE);
        number_mission7 = sPref.getString(SAVED_MISS7, "");
        Toast.makeText(Itemactivity.this, "Загружаем выполнено ли задание", Toast.LENGTH_SHORT).show();
        return number_mission7;
    }

    private void saveCompletedMission8() {
        sPref = getSharedPreferences("MyPref8", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS8, "8");
        ed.apply();
        Toast.makeText(Itemactivity.this, "Задание выполнено. Сохраняем", Toast.LENGTH_SHORT).show();
    }

    private String isMissionAlreadyDone8() {
        sPref = getSharedPreferences("MyPref8", MODE_PRIVATE);
        number_mission8 = sPref.getString(SAVED_MISS8, "");
        Toast.makeText(Itemactivity.this, "Загружаем выполнено ли задание", Toast.LENGTH_SHORT).show();
        return number_mission8;
    }

    private void saveCompletedMission9() {
        sPref = getSharedPreferences("MyPref9", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS9, "9");
        ed.apply();
        Toast.makeText(Itemactivity.this, "Задание выполнено. Сохраняем", Toast.LENGTH_SHORT).show();
    }

    private String isMissionAlreadyDone9() {
        sPref = getSharedPreferences("MyPref9", MODE_PRIVATE);
        number_mission9 = sPref.getString(SAVED_MISS9, "");
        Toast.makeText(Itemactivity.this, "Загружаем выполнено ли задание", Toast.LENGTH_SHORT).show();
        return number_mission9;
    }

    private void saveCompletedMission10() {
        sPref = getSharedPreferences("MyPref10", MODE_PRIVATE);
        SharedPreferences.Editor ed = sPref.edit();
        ed.putString(SAVED_MISS10, "10");
        ed.apply();
        Toast.makeText(Itemactivity.this, "Задание выполнено. Сохраняем", Toast.LENGTH_SHORT).show();
    }

    private String isMissionAlreadyDone10() {
        sPref = getSharedPreferences("MyPref10", MODE_PRIVATE);
        number_mission10 = sPref.getString(SAVED_MISS10, "");
        Toast.makeText(Itemactivity.this, "Загружаем выполнено ли задание", Toast.LENGTH_SHORT).show();
        return number_mission10;
    }



    @Override
    public void applyTexts() {
        is_complete_mis.setText("Задание выполнено");
        is_mis_complete=true;
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
            Toast.makeText(Itemactivity.this, "первое готово, заданий: " + c, Toast.LENGTH_SHORT).show();
        } else if (name_for_save.equals("Задание #2")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission2();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 222;
            saveUserScores(c_scores);
            Toast.makeText(Itemactivity.this, "второе готово, заданий: " + c, Toast.LENGTH_SHORT).show();
        } else if (name_for_save.equals("Задание #3")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission3();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 222;
            saveUserScores(c_scores);
            Toast.makeText(Itemactivity.this, "третье готово, заданий: " + c, Toast.LENGTH_SHORT).show();
        } else if (name_for_save.equals("Задание #4")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission4();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 400;
            saveUserScores(c_scores);
            Toast.makeText(Itemactivity.this, "четвёртое готово, заданий: " + c, Toast.LENGTH_SHORT).show();
        } else if (name_for_save.equals("Задание #5")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission5();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 500;
            saveUserScores(c_scores);
            Toast.makeText(Itemactivity.this, "пятое готово, заданий: " + c, Toast.LENGTH_SHORT).show();
        }
        else if (name_for_save.equals("Задание #6")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission6();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 600;
            saveUserScores(c_scores);
            Toast.makeText(Itemactivity.this, "шестое готово, заданий: " + c, Toast.LENGTH_SHORT).show();
        }
        else if (name_for_save.equals("Задание #7")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission7();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 777;
            saveUserScores(c_scores);
            Toast.makeText(Itemactivity.this, "седьмое готово, заданий: " + c, Toast.LENGTH_SHORT).show();
        }
        else if (name_for_save.equals("Задание #8")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission8();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 800;
            saveUserScores(c_scores);
            Toast.makeText(Itemactivity.this, "восьмое готово, заданий: " + c, Toast.LENGTH_SHORT).show();
        }
        else if (name_for_save.equals("Задание #9")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission9();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 900;
            saveUserScores(c_scores);
            Toast.makeText(Itemactivity.this, "девятое готово, заданий: " + c, Toast.LENGTH_SHORT).show();
        }
        else if (name_for_save.equals("Задание #10")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission10();
            int c = getCountCompleteMissions();
            c += 1;
            saveUserMissions(c);
            int c_scores = getCountScores();
            c_scores += 1000;
            saveUserScores(c_scores);
            Toast.makeText(Itemactivity.this, "десятое готово, заданий: " + c, Toast.LENGTH_SHORT).show();
        }
    }
}
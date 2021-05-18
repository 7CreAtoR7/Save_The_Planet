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



    @Override
    public void applyTexts() {
        is_complete_mis.setText("Задание выполнено");
        is_mis_complete=true;
        btn_done.setVisibility(View.GONE); // спрятали кнопку после выполнения задания

        if (name_for_save.equals("Задание #1")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission1();
        } else if (name_for_save.equals("Задание #2")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission2();
        } else if (name_for_save.equals("Задание #3")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission3();
        } else if (name_for_save.equals("Задание #4")) {
            is_complete_mis.setText("Задание выполнено!");
            saveCompletedMission4();
        }
    }
}
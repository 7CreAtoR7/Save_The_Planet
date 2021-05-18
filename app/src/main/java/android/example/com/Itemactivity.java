package android.example.com;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class Itemactivity extends AppCompatActivity {

    TextView textView, main_info_mission, coins;
    Button btn_done;

    public int count_scores;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_itemactivity);

        getSupportActionBar().hide();

        textView=(TextView)findViewById(R.id.txtitem);

        String Tempholder=getIntent().getStringExtra("Listviewclickvalue");

        //textView.setText(Tempholder);

        // обрабатываем каждое задание:

        if (Tempholder.equals("Задание #1")) {
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
                    Toast.makeText(getApplicationContext(), "Монет получишь: " + count_scores, Toast.LENGTH_SHORT).show();

                }
            });

        }
    }




}
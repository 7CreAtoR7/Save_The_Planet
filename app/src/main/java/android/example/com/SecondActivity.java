package android.example.com;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.android.material.bottomnavigation.BottomNavigationView;

public class SecondActivity extends AppCompatActivity {

    ListView listView;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        getSupportActionBar().hide();

        listView=(ListView)findViewById(R.id.listview1);
        String []listviewitems=new String[]{

                "Задание #1", "Задание #2", "Задание #3", "Задание #4", "Задание #5", "Задание #6", "Задание #7", "Задание #8", "Задание #9", "Задание #10"
        };

        ArrayAdapter<String>adapter=new ArrayAdapter<String>(this, android.R.layout.simple_list_item_2, android.R.id.text1,listviewitems);
        listView.setAdapter(adapter);



        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String Templistview=listviewitems[position].toString();

                Intent intent=new Intent(SecondActivity.this, Itemactivity.class);
                intent.putExtra("Listviewclickvalue", Templistview);

                startActivity(intent);
            }
        });


        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        bottomNavigationView.setSelectedItemId(R.id.challenges);

        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.profile:
                        startActivity(new Intent(getApplicationContext(), Profile.class));
                        overridePendingTransition(0, 0);
                        return true;
                    case R.id.challenges:
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
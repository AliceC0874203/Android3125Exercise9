package com.example.android_3125_exercise9;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ArrayList<String> items = new ArrayList<>();
        ArrayAdapter<String> adapter = new ArrayAdapter(
                this,
                android.R.layout.simple_list_item_1,
                items
        );

        ListView listView = findViewById(R.id.listView);
        listView.setAdapter(adapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Toast.makeText(MainActivity.this, "HI", Toast.LENGTH_SHORT).show();
            }
        });

        Button btnAdd = findViewById(R.id.btnAdd);
        EditText edtText = findViewById(R.id.edtText);
        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                items.add(edtText.getText().toString());
                edtText.setText("");
                adapter.notifyDataSetChanged();
            }
        });
    }
}
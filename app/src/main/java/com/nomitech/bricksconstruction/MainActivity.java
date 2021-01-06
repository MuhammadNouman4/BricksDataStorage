package com.nomitech.bricksconstruction;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
Button btnbricks, btnemploye;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnbricks= findViewById(R.id.btnbricks);
        btnemploye= findViewById(R.id.btnemployee);

        btnemploye.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, EmployesData.class);
                startActivity(intent);
            }
        });

        btnbricks.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this, BricksData.class);
                startActivity(intent);

            }
        });
    }
}
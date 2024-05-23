package com.example.arackiralama;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ListView;


import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.List;

public class MovementActivity extends AppCompatActivity {
    private int buttonIndex;
    public static boolean isImageButtonVisible;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_movement);

        // ImageButton'un bulunduğu farklı bir layout dosyasını yükle
        LayoutInflater inflater = LayoutInflater.from(this);
        View layout = inflater.inflate(R.layout.list_item_with_button, null);

        // ImageButton'u bul
        ImageButton imageButton74 = layout.findViewById(R.id.imageButton74);


        ListView listView = findViewById(R.id.listView);
        CustomAdapter adapter = new CustomAdapter(this);
        listView.setAdapter(adapter);

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }


    public void onHome(View view)
    {
        Intent intent=new Intent(MovementActivity.this, MainActivity.class);
        startActivity(intent);
    }
    public void onAccount(View view)
    {
        Intent intent=new Intent(MovementActivity.this,AccountActivity.class);
        startActivity(intent);
    }
}
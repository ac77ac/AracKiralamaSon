package com.example.arackiralama;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class focussatinalim extends AppCompatActivity {

    DatePicker datepicker,datepicker2;
    int yil,ay,gun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_focussatinalim);

        datepicker=findViewById(R.id.datepicker3);
        datepicker2=findViewById(R.id.datepicker4);
        Calendar bugun=Calendar.getInstance();
        Calendar mindate=Calendar.getInstance();
        yil=bugun.get(Calendar.YEAR);
        ay=bugun.get(Calendar.MONTH);
        gun=bugun.get(Calendar.DAY_OF_MONTH);

        datepicker.init(yil, ay, gun, new DatePicker.OnDateChangedListener() {
            @Override
            public void onDateChanged(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                mindate.set(year,monthOfYear,(dayOfMonth+1));
                datepicker2.setMinDate(mindate.getTimeInMillis());

            }
        });
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
    }
    public void backclick(View view)
    {
        Intent intent=new Intent(focussatinalim.this,fordfocus.class);
        startActivity(intent);
    }
}
package com.example.arackiralama;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.Calendar;

public class egeasatinalim extends AppCompatActivity {
public static boolean visibellel2;
    DatePicker datepicker,datepicker2;
    int yil,ay,gun;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_egeasatinalim);

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
        Intent intent=new Intent(egeasatinalim.this, fiategea.class);
        startActivity(intent);
    }
    public void Onayla(View view) {
        // Seçili tarihleri al
        int year1 = datepicker.getYear();
        int month1 = datepicker.getMonth();
        int day1 = datepicker.getDayOfMonth();

        int year2 = datepicker2.getYear();
        int month2 = datepicker2.getMonth();
        int day2 = datepicker2.getDayOfMonth();

        // Seçili tarihleri bir Calendar nesnesine dönüştür
        Calendar selectedDate1 = Calendar.getInstance();
        selectedDate1.set(year1, month1, day1);

        Calendar selectedDate2 = Calendar.getInstance();
        selectedDate2.set(year2, month2, day2);

        // Bugünün tarihini al
        Calendar today = Calendar.getInstance();

        // Seçili tarihler bugünden ilerideyse MovementActivity'e geçiş yap
        if (selectedDate1.after(today) || selectedDate2.after(today)) {
            // AlertDialog oluştur
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setMessage("Fiat Egea aracı başarıyla kiralandı")
                    .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        public void onClick(DialogInterface dialog, int id) {
                            // MovementActivity'e geçiş yap
                            Intent intent = new Intent(egeasatinalim.this, MovementActivity.class);
                            visibellel2=true;
                            startActivity(intent);
                        }
                    });
            // AlertDialog'u göster
            AlertDialog dialog = builder.create();
            dialog.show();
        } else {
            // Seçilen tarihler bugünden önceyse kullanıcıya uyarı ver
            Toast.makeText(this, "Lütfen uygun bir tarih seçin", Toast.LENGTH_SHORT).show();
        }
    }
}
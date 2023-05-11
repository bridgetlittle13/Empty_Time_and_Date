package sg.edu.rp.c346.id22013272.emptytimeanddate;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    DatePicker dp;
    TimePicker tp;
    Button btnDisplayDate;
    Button btnDisplayTime;
    Button btnReset;
    TextView tvDisplay;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        dp=findViewById(R.id.datepicker);
        tp=findViewById(R.id.timepicker);
        btnDisplayDate=findViewById(R.id.buttonDisplayDate);
        btnDisplayTime=findViewById(R.id.buttonDisplayTime);
        btnReset=findViewById(R.id.buttonReset);
        tvDisplay=findViewById(R.id.textViewDisplay);


        btnDisplayTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int hour, minute;
                hour = tp.getHour();
                minute = tp.getMinute();
                String timeString = String.format(Locale.getDefault(), "Time is %02d:%02d", hour, minute);
                tvDisplay.setText(timeString);


            }
        });
        btnDisplayDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int day,month,year;
                day=dp.getDayOfMonth();
                month=dp.getMonth()+1;
                year=dp.getYear();
                String dateString=String.format(Locale.getDefault(),"Date is %02d/ %02d/ %02d",day,month,year);
                tvDisplay.setText(dateString);
            }
        });

        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tp.setHour(0);
                tp.setMinute(0);
                dp.updateDate(2020,0,01);
                tvDisplay.setText("");


            }
        });

    }
}
package com.example.workstation.hackathontask;

import android.app.DatePickerDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    TextView startDateTxtView,endDateTextView;
    EditText minCountEdtTxt, maxCountEdtTxt;
    Button searchRecordsBtn;
    int year,month,day;
    String startDate,endDate;
    int minCount,maxCount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Calendar c = Calendar.getInstance();
        year = c.get(Calendar.YEAR);
        month = c.get(Calendar.MONTH);
        day = c.get(Calendar.DAY_OF_MONTH);

        init();

        startDateTxtView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        startDate = year + "-" + (monthOfYear+1) + "-" + dayOfMonth;
                        startDateTxtView.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                }, year, month, day);
                datePicker.setTitle("Start Date");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ok", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Cancel", datePicker);
                datePicker.show();
            }
        });

        endDateTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DatePickerDialog datePicker = new DatePickerDialog(MainActivity.this, new DatePickerDialog.OnDateSetListener() {

                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear,
                                          int dayOfMonth) {
                        endDate = year + "-" + (monthOfYear + 1) + "-" + dayOfMonth;
                        endDateTextView.setText(dayOfMonth + "/" + (monthOfYear+1) + "/" + year);
                    }
                }, year, month, day);
                datePicker.setTitle("End Date");
                datePicker.setButton(DatePickerDialog.BUTTON_POSITIVE, "Ok", datePicker);
                datePicker.setButton(DatePickerDialog.BUTTON_NEGATIVE, "Cancel", datePicker);
                datePicker.show();

            }
        });

        searchRecordsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(TextUtils.isEmpty(startDate)){
                    startDateTxtView.setError("Please choose a start date");
                } else if(TextUtils.isEmpty(endDate)){
                    endDateTextView.setError("Please choose a end date");
                } else if(TextUtils.isEmpty(minCountEdtTxt.getText().toString())){
                    minCountEdtTxt.setError("min count is required");
                } else if(TextUtils.isEmpty(maxCountEdtTxt.getText().toString())){
                    maxCountEdtTxt.setError("max count is required");
                } else {
                    minCount = Integer.valueOf(minCountEdtTxt.getText().toString());
                    maxCount = Integer.valueOf(maxCountEdtTxt.getText().toString());

                    Intent intent = new Intent(MainActivity.this,RecordsActivity.class);
                    intent.putExtra("startDate",startDate);
                    intent.putExtra("endDate",endDate);
                    intent.putExtra("minCount",minCount);
                    intent.putExtra("maxCount",maxCount);
                    startActivity(intent);

                }
            }
        });
    }


    void init(){
        startDateTxtView = findViewById(R.id.startDateTxtView);
        endDateTextView  = findViewById(R.id.endDateTxtView);
        minCountEdtTxt   = findViewById(R.id.minCountEdtTxt);
        maxCountEdtTxt   = findViewById(R.id.maxCountEdtTxt);
        searchRecordsBtn = findViewById(R.id.searchRecordsBtn);
    }
}

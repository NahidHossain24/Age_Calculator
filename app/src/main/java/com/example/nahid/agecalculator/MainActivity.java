package com.example.nahid.agecalculator;

import android.annotation.SuppressLint;
import android.app.DatePickerDialog;
import android.app.Dialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button btnStart;
    static final int DATE_START_DIALOG_ID = 0;
    private int startYear=1970;
    private int startMonth=6;
    private int startDay=15;
    private AgeCalculation age = null;
    private TextView currentDate;
    private TextView birthDate;
    private TextView result;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        age=new AgeCalculation();
        currentDate=(TextView) findViewById(R.id.textView1);
        currentDate.setText( age.getCurrentDate());
        birthDate=(TextView) findViewById(R.id.textView2);
        result=(TextView) findViewById(R.id.textView3);
        btnStart=(Button) findViewById(R.id.button1);
        btnStart.setOnClickListener(this);

    }

    @Override
    protected Dialog onCreateDialog(int id) {
        switch (id) {
            case DATE_START_DIALOG_ID:
                return new DatePickerDialog(this,
                        mDateSetListener,
                        startYear, startMonth, startDay);
        }
        return null;
    }

    private DatePickerDialog.OnDateSetListener mDateSetListener
            = new DatePickerDialog.OnDateSetListener() {
        @SuppressLint("SetTextI18n")
        public void onDateSet(DatePicker view, int selectedYear,
                              int selectedMonth, int selectedDay) {
            startYear=selectedYear;
            startMonth=selectedMonth;
            startDay=selectedDay;
            age.setDateOfBirth(startYear, startMonth, startDay);
            birthDate.setText(""+selectedDay+":"+(startMonth+1)+":"+startYear);
            calculateAge();
        }
    };
    public void onClick(View v) {
// TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.button1:
                showDialog(DATE_START_DIALOG_ID);
                break;

            default:
                break;
        }
    }
    private void calculateAge()
    {
        age.calcualteYear();
        age.calcualteMonth();
        age.calcualteDay();
        Toast.makeText(getBaseContext(), "Thanks for Using My App\n Md. Nahid Hossain" , Toast.LENGTH_SHORT).show();
        result.setText(age.getResult());
    }

    @Override
    public void onPointerCaptureChanged(boolean hasCapture) {

    }
}

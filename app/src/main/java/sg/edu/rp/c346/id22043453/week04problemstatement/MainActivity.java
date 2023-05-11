package sg.edu.rp.c346.id22043453.week04problemstatement;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextView tvName;
    TextView tvContactNum;
    TextView tvGroupSize;
    DatePicker dp;
    TimePicker tp;
    RadioGroup rgSmoking;
    RadioButton rbSmoking;
    RadioButton rbNonSmoking;
    Button btnBook;
    Button btnReset;
    TextView tvDisplay;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvName = findViewById(R.id.editTextName);
        tvContactNum = findViewById(R.id.editTextContactNum);
        tvGroupSize = findViewById(R.id.editTextGroupSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        rgSmoking = findViewById(R.id.smokingRadioGrp);
        rbSmoking = findViewById(R.id.radioButtonSmoking);
        rbNonSmoking = findViewById(R.id.radioButtonNonSmoking);
        btnBook = findViewById(R.id.buttonBook);
        btnReset = findViewById(R.id.buttonReset);
        tvDisplay = findViewById(R.id.textViewDisplay);

        // Set default date and time
        tp.setHour(19);
        tp.setMinute(30);
        dp.updateDate(2020, 6-1, 1);


        btnBook.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String strName = tvName.getText().toString();
                String strContactNum = tvContactNum.getText().toString();
                String intGrpSize = tvGroupSize.getText().toString();
                int hour = tp.getHour();
                int minute = tp.getMinute();
                int year = dp.getYear();
                int month = dp.getMonth();
                int dayOfMonth = dp.getDayOfMonth();
                boolean isSmoking = rgSmoking.isClickable();

                StringBuilder displayInfo = new StringBuilder();
                displayInfo.append("Name: ").append(strName).append("\n");
                displayInfo.append("Mobile: ").append(strContactNum).append("\n");
                displayInfo.append("Group Size: ").append(intGrpSize).append("\n");
                displayInfo.append("Date: ").append(dayOfMonth).append("/").append(month).append("/").append(year).append("\n");
                displayInfo.append("Time: ").append(String.format(Locale.getDefault(), "%02d:%02d", hour, minute)).append("\n");
                displayInfo.append("Smoking Area: ").append(isSmoking ? "Yes" : "No");

                // Set the textview to visible
                tvDisplay.setText(displayInfo.toString());
                tvDisplay.setVisibility(View.VISIBLE);

                // Set how long does the textview can be shown
                tvDisplay.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        tvDisplay.setVisibility(View.GONE);
                    }
                }, 5000);

                Toast.makeText(MainActivity.this, "Inputs successfully.", Toast.LENGTH_SHORT).show();
            }
        });


        btnReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                // To reset all the elements
                tvName.setText("");
                tvContactNum.setText("");
                tvGroupSize.setText("");
                rbSmoking.setChecked(false);
                rbNonSmoking.setChecked(false);
                tp.setHour(19);
                tp.setMinute(30);
                dp.updateDate(2020, 6-1, 1);

                Toast.makeText(MainActivity.this, "Inputs cleared.", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
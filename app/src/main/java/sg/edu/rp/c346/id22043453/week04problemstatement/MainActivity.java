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


        btnBook.setOnClickListener(new View.OnClickListener() {

            String strName = tvName.getText().toString();
            String strContactNum = tvContactNum.getText().toString();
            int intGrpSize = Integer.parseInt(tvGroupSize.getText().toString());

            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, strName + strContactNum + intGrpSize, Toast.LENGTH_LONG).show();
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
                tp.setHour(7);
                tp.setMinute(30);
                dp.updateDate(2020, 6, 1);
            }
        });

    }
}
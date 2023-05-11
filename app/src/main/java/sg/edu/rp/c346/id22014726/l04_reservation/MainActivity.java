package sg.edu.rp.c346.id22014726.l04_reservation;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.QuickContactBadge;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

EditText editName;
EditText editPhone;
EditText editSize;
DatePicker dp;
TimePicker tp;
RadioGroup tableChoice;
RadioButton smoking;
RadioButton nonsmoking;
Button btnReset;
Button btnConfirm;
TextView tvDisplay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editName = findViewById(R.id.etName);
        editPhone = findViewById(R.id.etPhone);
        editSize = findViewById(R.id.etSize);
        dp = findViewById(R.id.datePicker);
        tp = findViewById(R.id.timePicker);
        tableChoice = findViewById(R.id.TableChoice);
        smoking = findViewById(R.id.Smoking);
        nonsmoking = findViewById(R.id.NonSmoking);
        btnReset = findViewById(R.id.Reset);
        btnConfirm = findViewById(R.id.Confirm);
        tvDisplay = findViewById(R.id.textViewDisplay);

    tp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int hour, minute;
            hour = tp.getHour();
            minute = tp.getMinute();

            tvDisplay.setText("Time: " + hour + ":" + minute);
        }
    });

    dp.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int day, month, year;
            day = dp.getDayOfMonth();
            month = dp.getMonth() + 1;
            year = dp.getYear();

            tvDisplay.setText("Date is " + day + "/" + month + "/" + year);
        }
    });


    btnConfirm.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String name = editName.getText().toString();
            String phone = editPhone.getText().toString();
            String size = editSize.getText().toString();
            String date = String.format("%02d/%02d/%04d", dp.getDayOfMonth(), dp.getMonth() + 1, dp.getYear());
            String time = String.format("%02d:%02d", tp.getCurrentHour(), tp.getCurrentMinute());
            String tableChoiceText = "";

            int checkedRadioId = tableChoice.getCheckedRadioButtonId();
            if (checkedRadioId == R.id.Smoking) {
                tableChoiceText = "Smoking";
            } else if (checkedRadioId == R.id.NonSmoking) {
                tableChoiceText = "Non-Smoking";
            }

            String reservationInfo = "Name: " + name + "\nPhone: " + phone + "\nGroup Size: " + size +
                    "\nDate: " + date + "\nTime: " + time + "\nTable Choice: " + tableChoiceText;

            tvDisplay.setText(reservationInfo);

            Toast.makeText(MainActivity.this, reservationInfo, Toast.LENGTH_LONG).show();
        }

    });

    btnReset.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            tp.setHour(19);
            tp.setMinute(30);
            dp.updateDate(2020, 6 - 1, 1);
            tvDisplay.setText("");
            editName.setText("");
            editPhone.setText("");
            editSize.setText("");
            smoking.setChecked(false);
            nonsmoking.setChecked(false);
            }

         });
    }
}
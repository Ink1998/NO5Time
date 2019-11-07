package com.example.no5_time;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText editText_Y;
    private EditText editText_M;
    private EditText editText_D;
    private EditText editText_Hr;
    private EditText editText_Min;
    private EditText editText_Sec;
    private Button button;
    private TextView Data_text;
    private TextView Time_text;
    private TextView LeapY_text;
    int Y,M,D,Hr,Min,Sec=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editText_Y = findViewById(R.id.Year);
        editText_M = findViewById(R.id.Month);
        editText_D = findViewById(R.id.Day);
        editText_Hr = findViewById(R.id.Hour);
        editText_Min = findViewById(R.id.Minute);
        editText_Sec = findViewById(R.id.Second);
        button = findViewById(R.id.Conversion);
        Data_text = findViewById(R.id.DataTable);
        Time_text = findViewById(R.id.TimeTable);
        LeapY_text = findViewById(R.id.LeapYear);

        button.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                if(editText_Y.getText().toString().matches("")
                        || editText_M.getText().toString().matches("")
                        || editText_D.getText().toString().matches("")
                        ||editText_Hr.getText().toString().matches("")
                        ||editText_Min.getText().toString().matches("")
                        ||editText_Sec.getText().toString().matches("")) {
                    Toast toast = Toast.makeText(MainActivity.this, "欄位不要空白!!", Toast.LENGTH_LONG);
                    toast.show();
                }
                else{
                    Y = Integer.parseInt(editText_Y.getText().toString());
                    M = Integer.parseInt(editText_M.getText().toString());
                    D = Integer.parseInt(editText_D.getText().toString());
                    Hr = Integer.parseInt(editText_Hr.getText().toString());
                    Min = Integer.parseInt(editText_Min.getText().toString());
                    Sec = Integer.parseInt(editText_Sec.getText().toString());
                    Data_text.setText(Y+"/"+M+"/"+D);
                    Time_text.setText(Hr+"："+Min+"："+Sec);
                    if(Y%4!=0)
                        LeapY_text.setText("閏年：不是");
                    else if(Y%100!=0)
                        LeapY_text.setText("閏年：是");
                    else if(Y%400!=0)
                        LeapY_text.setText("閏年：不是");
                    else
                        LeapY_text.setText("閏年：是");


                }
            }
        });
    }
}

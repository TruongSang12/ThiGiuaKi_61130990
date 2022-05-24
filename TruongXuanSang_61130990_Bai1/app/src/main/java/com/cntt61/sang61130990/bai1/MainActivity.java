package com.cntt61.sang61130990.bai1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    EditText editCa, editCb, editCh;
    TextView textviewKQ;
    Button Chuvi, Dientich;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TimWidget();
    }
    void TimWidget()
    {
        editCa = (EditText) findViewById(R.id.edCa);
        editCb = (EditText) findViewById(R.id.edCb);
        editCh = (EditText) findViewById(R.id.edCh);
        Chuvi = (Button) findViewById(R.id.btnCV);
        Dientich = (Button) findViewById(R.id.btnDT);
        textviewKQ = (EditText) findViewById(R.id.edKq);
    }
    public void Tinh_Chuvi(View v)
    {
        String CanhA = editCa.getText().toString();
        String CanhB = editCb.getText().toString();
        String CanhH = editCh.getText().toString();
        float CanhA = Float.parseFloat(String.valueOf(editCa));
        float CanhB = Float.parseFloat(String.valueOf(editCb));
        float CanhH = Float.parseFloat(String.valueOf(editCh));
        float CV = (CanhA+CanhB)*CanhH;
        float DT = CanhA*CanhH;
        String KQ = String.valueOf(CV);
        textviewKQ.setText(KQ);
    }
}
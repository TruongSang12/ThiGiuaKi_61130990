package com.cntt61.sang61130990.bai2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    EditText edTenBT;
    Button btnThem ,btnSua;
    ListView listView;
    ArrayList<String> listData;
    ArrayAdapter adapter;
    int vt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edTenBT = (EditText) findViewById(R.id.edTenBT);
        btnThem = (Button) findViewById(R.id.btnThem);
        btnSua = (Button) findViewById(R.id.btnSua);
        listView = (ListView) findViewById(R.id.lv);

        listData = new ArrayList<String>();
        listData.add("Yêu lắm quê hương");
        listData.add("Quê hương nỗi nhớ");
        listData.add("Tình quê");
        listData.add("Quê hương qua lời mẹ kể");
        listData.add("Lưng tựa bến quê");

        adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, listData);
        listView.setAdapter(adapter);

        btnThem.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String item = edTenBT.getText().toString().trim();
                if(TextUtils.isEmpty(item)) {
                    Toast.makeText(MainActivity.this, "Bạn chưa nhập dữ liệu", Toast.LENGTH_LONG).show();
                    return;
                }
                listData.add(item);
                adapter.notifyDataSetChanged();
            }
        });
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                edTenBT.setText(listData.get((int) i));
                vt = i;
            }
        });
        btnSua.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String tenbt = edTenBT.getText().toString();
                listData.set(vt, tenbt);
                adapter.notifyDataSetChanged();
            }
        });

        listView.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> adapterView, View view, int vt, long l) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Xac nhan");
                dialog.setMessage("Ban co muon xoa khong?");
                dialog.setPositiveButton("Co", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        listData.remove(vt);
                        adapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("Khong", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.cancel();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();
                return false;
            }
        });
    }
}
package com.example.login_data;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


public class MainActivity extends AppCompatActivity {
    private EditText Uname, Pwd;
    private Button Add;
    private Logindb db1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Uname = (EditText) findViewById(R.id.username);
        Pwd = (EditText) findViewById(R.id.password);
        Add = (Button) findViewById(R.id.add);
        db1=new Logindb(this);
        Add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String S1=Uname.getText().toString();
                String S2=Pwd.getText().toString();
                if (S1.isEmpty() || S2.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Data Not Entered",
                            Toast.LENGTH_SHORT).show();
                    return;
                }
                db1.addNewUser(S1,S2);
                Toast.makeText(MainActivity.this, "New User added.",
                        Toast.LENGTH_SHORT).show();
                Uname.setText("");
                Pwd.setText("");
            }
        });
    }

}
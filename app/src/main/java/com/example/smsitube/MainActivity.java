package com.example.smsitube;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private EditText phone,message;
    private Button send;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        phone=findViewById(R.id.phone);
        message=findViewById(R.id.message);
        send=findViewById(R.id.send);
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String phoneNumber=phone.getText().toString();
                String mess=message.getText().toString();
                Uri uri=Uri.parse("smsto:"+phoneNumber);
                Intent smsIntent=new Intent(Intent.ACTION_SENDTO,uri);
                smsIntent.putExtra("sms_body",mess);
                try {

                    startActivity(smsIntent);
                }
                catch (Exception ex)
                {
                    Toast.makeText(MainActivity.this,"Your sms has failed..",Toast.LENGTH_LONG).show();
                }
            }
        });
    }

}
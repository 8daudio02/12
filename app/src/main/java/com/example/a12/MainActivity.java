package com.example.a12;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
public class MainActivity extends AppCompatActivity {
    EditText Editsubject,Editcontent,Editemail;
    Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button = findViewById(R.id.btnSend);
        Editsubject = findViewById(R.id.subject);
        Editcontent = findViewById(R.id.content1);
        Editemail = findViewById(R.id.email);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String subject,content,email;
                subject = Editsubject.getText().toString();
                content = Editcontent.getText().toString();
                email = Editemail.getText().toString();
                if(subject.equals("") && content.equals("") && email.equals("")){
                    Toast.makeText(MainActivity.this, "All fields are required", Toast.LENGTH_SHORT).show();
                }else {
                    sendEmail(subject,content,email);
                }
            }
        });
    }
    public void sendEmail(String Editsubject,String Editcontent, String email){
        Intent intent = new Intent(Intent.ACTION_SEND);
        intent.putExtra(Intent.EXTRA_EMAIL, new String[]{email});
        intent.putExtra(Intent.EXTRA_SUBJECT, Editsubject);
        intent.putExtra(Intent.EXTRA_TEXT,Editcontent);
        intent.setType("message/rfc822");
        startActivity(Intent.createChooser(intent,"Choose email client"));
    }
}
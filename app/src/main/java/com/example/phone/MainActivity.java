package com.example.phone;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button button1,button2,button3,button4;
    private TextView e1,e2,e3,e4,e5,e6,e7,e8;
    String s1,s2,s3,s4,s5,s6,s7,s8;
    dbcon mydb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mydb=new dbcon(this);
        button1 =(Button)findViewById(R.id.button3);
        button2=(Button)findViewById(R.id.button6);
        button3=(Button)findViewById(R.id.button9);
        button4=(Button)findViewById(R.id.button12);
        e1=(TextView)findViewById(R.id.textView2);
        e2=(TextView)findViewById(R.id.textView3);
        e3=(TextView)findViewById(R.id.textView5);
        e4=(TextView)findViewById(R.id.textView6);
        e5=(TextView)findViewById(R.id.textView8);
        e6=(TextView)findViewById(R.id.textView9);
        e7=(TextView)findViewById(R.id.textView10);
        e8=(TextView)findViewById(R.id.textView11);



        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {




                Intent intent1=new Intent(MainActivity.this,addcart.class);

                s1=e1.getText().toString();
                s2=e2.getText().toString();
                intent1.putExtra("value1",s1);
                intent1.putExtra("value2",s2);
                startActivity(intent1);


            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent2=new Intent(MainActivity.this,addcart.class);

                s3=e3.getText().toString();
                s4=e4.getText().toString();
                intent2.putExtra("value1",s3);
                intent2.putExtra("value2",s4);
                startActivity(intent2);


            }
        });
        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent3=new Intent(MainActivity.this,addcart.class);

                s5=e5.getText().toString();
                s6=e6.getText().toString();
                intent3.putExtra("value1",s5);
                intent3.putExtra("value2",s6);
                startActivity(intent3);


            }
        });
        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent4=new Intent(MainActivity.this,addcart.class);

                s7=e7.getText().toString();
                s8=e8.getText().toString();
                intent4.putExtra("value1",s7);
                intent4.putExtra("value2",s8);
                startActivity(intent4);


            }
        });
    }

}

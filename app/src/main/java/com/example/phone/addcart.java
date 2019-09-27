package com.example.phone;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class addcart extends AppCompatActivity {



    TextView tv1, tv2, tv3, total;
    Button add,car;
    String st1, st2, st3;
    int counter;
    RadioGroup r1,r2;
    RadioButton rb1,rb2;
    dbcon mydb1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_addcart);
        mydb1=new dbcon(this);
        tv2 = findViewById(R.id.textView16);
        tv1 = findViewById(R.id.textView14);
        car=findViewById(R.id.button16);


        tv3 = (TextView) findViewById(R.id.counterValue);
        total = (TextView) findViewById(R.id.textView21);
        add = (Button) findViewById(R.id.button13);
        /*r1=(RadioGroup)findViewById(R.id.radioGroup);
        r2=(RadioGroup)findViewById(R.id.radioGroup2);*/
        /*int rad1=r1.getCheckedRadioButtonId();
        rb1=findViewById(rad1);
        int rad2=r2.getCheckedRadioButtonId();
        rb2=findViewById(rad2);*/


        st1 = getIntent().getExtras().getString("value1");
        tv2.setText(st1);

        st2 = getIntent().getExtras().getString("value2");
        tv1.setText(st2);
        Viewall();
       add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv1 = findViewById(R.id.textView14);
                tv3 = (TextView) findViewById(R.id.counterValue);
                total = (TextView) findViewById(R.id.textView21);
                add = (Button) findViewById(R.id.button13);
                /*r1=(RadioGroup)findViewById(R.id.radioGroup);
                r2=(RadioGroup)findViewById(R.id.radioGroup2);
                int rad1=r1.getCheckedRadioButtonId();
                rb1=findViewById(rad1);
                int rad2=r2.getCheckedRadioButtonId();
                rb2=findViewById(rad2);*/


                String Item = tv1.getText().toString();
               /* String Color = rb1.getText().toString();
                String Memory = rb2.getText().toString();*/
                String qnt = tv3.getText().toString();
                String tot = total.getText().toString();


                    //Insert infor to Database
                    Contact contact = new Contact();
                    contact.Setitem(Item);
                    //contact.Setcolor(Color);
                    //contact.Setmemory(Memory);
                    contact.Setqnt(qnt);
                    contact.Settotal(tot);
                    mydb1.InsertContacts(contact);
                Toast.makeText(addcart.this,"Add cart success",Toast.LENGTH_LONG).show();



                }

        });


          /* add.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {


                    AlertDialog.Builder a_buid = new AlertDialog.Builder(addcart.this);
                    a_buid.setMessage("Do you want to add this item to cart!!").setCancelable(false)
                            .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Toast.makeText(addcart.this,"Add cart success",Toast.LENGTH_LONG).show();


                        }
                    })
                            .setNegativeButton("no", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialogInterface, int i) {


                                }
                            });
                    AlertDialog alert = a_buid.create();
                    alert.setTitle("WOW!!");
                    alert.show();
                }
            });*/

        tv3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                int num1 = Integer.parseInt(tv3.getText().toString());
                int num2 = Integer.parseInt(tv2.getText().toString());
                int sum = num1 * num2;
                total.setText(Integer.toString(sum));

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });
    }

public void Viewall(){
        car.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Cursor resu=mydb1.getdata();
                if(resu.getCount()==0){
                show("Erorr","empty");

                }
                StringBuffer buffer=new StringBuffer();
                while (resu.moveToNext()){
                    buffer.append("Id :"+resu.getString(0)+"\n");
                    buffer.append("Item :"+resu.getString(1)+"\n");
                    buffer.append("Qnt :"+resu.getString(2)+"\n");
                    buffer.append("Totl :"+resu.getString(3)+"\n\n");

                }
                show("Data",buffer.toString());
            }
        });
}

public void show(String tit,String msg){
        AlertDialog.Builder builder=new AlertDialog.Builder(this);
        builder.setCancelable(true);
        builder.setTitle(tit);
        builder.setMessage(msg);
        builder.show();
}
    public void counterIn(View v) {


            counter++;

        tv3.setText(Integer.toString(counter));


    }

    public void counterDe(View view) {



            counter--;

        tv3.setText(Integer.toString(counter));


    }






}

/*public void addRecord(View view)
{

        dbcon db = new dbcon(this);
        String res=db.addrecord(tv1.getText().toString(),rb1.getText().toString(),rb2.getText().toString(),tv3.getText().toString(),total.getText().toString());
        Toast.makeText(this,res,Toast.LENGTH_LONG).show();


}
*/










package com.example.covidteeka;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity2 extends AppCompatActivity {

    EditText username,password,repassword,pincode,adharno;
    Button signup,signin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        username=(EditText)findViewById(R.id.username);
        password=(EditText)findViewById(R.id.password);
        repassword=(EditText)findViewById(R.id.repassword);
        pincode = (EditText)findViewById(R.id.pincode);
        adharno=(EditText)findViewById(R.id.adharno);
        signup=(Button) findViewById(R.id.btnsignup);
        signin=(Button) findViewById(R.id.btnsignin);
        DB =new DBHelper(this);

        signup.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user=username.getText().toString();
                String pin=pincode.getText().toString();
                String adhar=adharno.getText().toString();
                String pass=password.getText().toString();
                String repass=repassword.getText().toString();

                if(user.equals("")|| pass.equals("")|| repass.equals("")|| pin.equals("")|| adhar.equals(""))
                    Toast.makeText(MainActivity2.this,"please enter all the fields",Toast.LENGTH_SHORT).show();
                else{
                    if(pass.equals(repass)){
                        Boolean checkuser=DB.checkadharno(adhar);
                        if(checkuser==false) {
                            Boolean insert = DB.insertData(user, pin, adhar, pass);
                            if (insert==true){
                                Toast.makeText(MainActivity2.this,"Registered successfully",Toast.LENGTH_SHORT).show();                         
                            }
                            else{
                                Toast.makeText(MainActivity2.this,"Registeration failed",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{
                            Toast.makeText(MainActivity2.this,"User Already exists! please sign in",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{
                        Toast.makeText(MainActivity2.this,"Password not matching",Toast.LENGTH_SHORT).show();
                    }
                }

            }
        });

        signin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent intent = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(intent);
            }
        });
    }
}
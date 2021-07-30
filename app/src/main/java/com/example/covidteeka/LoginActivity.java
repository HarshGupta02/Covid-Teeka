package com.example.covidteeka;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.security.PublicKey;

public class LoginActivity extends AppCompatActivity {

    EditText username,password,adharno;// edit here
    Button btnlogin;
    DBHelper DB;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        username=(EditText)findViewById(R.id.username1);
        password=(EditText)findViewById(R.id.password1);
        adharno=(EditText)findViewById(R.id.adharno1); //edit here
        btnlogin=(Button) findViewById(R.id.btnsignin1);
        DB= new DBHelper(this);

        btnlogin.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                String user=username.getText().toString();
                String adhar=adharno.getText().toString(); //edit here
                String pass=password.getText().toString();

                if(user.equals("")||pass.equals("")||adhar.equals("")) //edit here
                    Toast.makeText(LoginActivity.this,"please enter all the fields",Toast.LENGTH_SHORT).show();
                else{
                    Boolean checkuserpass=DB.checkusernamepasswordadhar(user,pass,adhar);//edit here
                    if(checkuserpass==true){
                        Toast.makeText(LoginActivity.this,"Sign in successfull",Toast.LENGTH_SHORT).show();
                        Intent intent=new Intent(getApplicationContext(),CovidMainActivity.class);
                        // we go from login activity -> 3rd page
                        startActivity(intent);
                    }
                    else{
                        Toast.makeText(LoginActivity.this,"invalid Crenditials",Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}
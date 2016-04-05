package in.ac.imsec.testapplication;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private Button loginButton;
    private EditText username;
    private EditText password;

    private String usernameText;
    private String passwordText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        username = (EditText) findViewById(R.id.username);
        password = (EditText) findViewById(R.id.password);
        loginButton = (Button) findViewById(R.id.loginButton);


        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getData();
                if(usernameText.equals("") || passwordText.equals("")){
                    Toast.makeText(MainActivity.this,
                            "Username or Password may be empty",
                            Toast.LENGTH_LONG).show();
                }
                else{

                    SharedPreferences sharedPreferences = getSharedPreferences("usernameAndPassword", Context.MODE_APPEND);
                    SharedPreferences.Editor editor = sharedPreferences.edit();
                    editor.putString("username", usernameText);
                    editor.putString("password",passwordText);
                    editor.apply();


                    Intent intent = new Intent(MainActivity.this,HomePage.class);
                    startActivity(intent);
                }
            }
        });

    }

    public void getData(){
        usernameText = username.getText().toString();
        passwordText = password.getText().toString();

    }


}

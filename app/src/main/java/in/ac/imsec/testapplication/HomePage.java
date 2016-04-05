package in.ac.imsec.testapplication;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;


public class HomePage extends AppCompatActivity {

    private TextView username;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_home_page);

        username = (TextView) findViewById(R.id.username);

        SharedPreferences sharedPreferences = getSharedPreferences("usernameAndPassword", this.MODE_PRIVATE);
        String usernameText = sharedPreferences.getString("username", "USERNAME");

        username.setText(usernameText);
    }
}

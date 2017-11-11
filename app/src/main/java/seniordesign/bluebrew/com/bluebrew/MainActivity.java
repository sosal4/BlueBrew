package seniordesign.bluebrew.com.bluebrew;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    //this function helps in link with the reading.java class
    public void xykR(View view) {

        Intent intent = new Intent(MainActivity.this, reading.class);
        startActivity(intent);

    }
}

package seniordesign.bluebrew.com.bluebrew;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView text = (TextView) findViewById(R.id.text1);
        text.setMovementMethod(LinkMovementMethod.getInstance());

    }

    //this function helps in link with the reading.java class
    public void xykR(View view) {


        //ths function helps linking main activity with the reading class
        Intent intent = new Intent(MainActivity.this, reading.class);
        startActivity(intent);

    }
}

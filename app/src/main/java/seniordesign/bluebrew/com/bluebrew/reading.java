package seniordesign.bluebrew.com.bluebrew;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by xakR on 8/29/2017.
 */

public class reading extends Activity {

    Button click;
    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readings);

        click = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.data);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backstage process = new backstage();
                process.execute();

            }
        });

    }
}

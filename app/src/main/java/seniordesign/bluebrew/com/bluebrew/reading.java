package seniordesign.bluebrew.com.bluebrew;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

/**
 * Created by sakar on 8/29/2017.
 */

public class reading extends Activity {

    Button click;
    public static TextView data;

    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.readings);


        data = (TextView)findViewById(R.id.data);
        Button click = (Button)findViewById(R.id.button);

        //for json class json_parsed calling
        click = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.data);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                json_parsed process = new json_parsed();
                process.execute();

            }
        });

    }

}

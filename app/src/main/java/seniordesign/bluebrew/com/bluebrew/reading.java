package seniordesign.bluebrew.com.bluebrew;

import android.app.Activity;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

import java.io.IOException;

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

        data = (TextView)findViewById(R.id.data);
        Button click = (Button)findViewById(R.id.button);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                new doit().execute();
            }
        });




        /*click = (Button) findViewById(R.id.button);
        data = (TextView) findViewById(R.id.data);

        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                backstage process = new backstage();
                process.execute();

            }
        });*/

    }

    public class doit  extends AsyncTask<Void, Void, Void>{

        String words;
        @Override
        protected Void doInBackground(Void... params) {

            try {
                Document doc = Jsoup.connect("http:/192.168.42.1").get();

                words = doc.text();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);

        data.setText(words);
        }
    }
}

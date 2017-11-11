package seniordesign.bluebrew.com.bluebrew;

import android.os.AsyncTask;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

/**
 * Created by xakR on 11/11/2017.
 */

public class backstage extends AsyncTask<Void, Void, Void> {

    String data="";
    String dataPrased = "";
    String singleParsed = "";
    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

        reading.data.setText(this.dataPrased);
    }

    @Override
    protected Void doInBackground(Void... params) {

        try {
            URL url = new URL("https://api.myjson.com/bins/f3jc7");

            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while (line != null){

                line = bufferedReader.readLine();
                data = data + line;

            }

            JSONArray JA = new JSONArray(data);

            for (int i = 0; i<JA.length(); i++){

                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "Name:"+JO.get("name")+"\n"+
                        "Password:"+JO.get("pw")+"\n"+
                        "Contact information:"+JO.get("cell")+"\n"+
                        "Country:"+JO.get("nation")+"\n";


                dataPrased = dataPrased + singleParsed+ "\n";

            }

        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return null;
    }
}

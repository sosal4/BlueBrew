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
 * Created by sakar on 11/11/2017.
 */

public class json_parsed extends AsyncTask<Void, Void, Void> {

    //declaring string variables
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
            //url linked from where data is being retrieve
            URL url = new URL("https://api.myjson.com/bins/pptzr");

            //creating new http url connection
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";

            while (line != null){

                line = bufferedReader.readLine();
                data = data + line;

            }

            //creating new JSON array
            //this variable is used in parsing data to show records in table form from website
            JSONArray JA = new JSONArray(data);

            for (int i = 0; i<JA.length(); i++){

                JSONObject JO = (JSONObject) JA.get(i);
                singleParsed = "R_ID-------------------------->"+JO.get("R_ID")+"\n"+
                        "Batchname---------------->"+JO.get("BATCH_NAME")+"\n"+
                        "DATE-------------------------> "+JO.get("DATE")+"\n"+
                        "TIME-------------------------->"+JO.get("TIME")+"\n"+
                        "TEMPERATURE--------->"+JO.get("TEMPERATURE")+"\n"+
                        "SPECIFIC GRAVITY--->"+JO.get("SPECIFIC_GRAVITY")+"\n";

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

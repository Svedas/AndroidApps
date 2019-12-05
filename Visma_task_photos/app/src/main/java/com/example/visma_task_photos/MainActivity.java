/** Made by Mantas Švedas
 * For Visma Paid Mobile Development (iOS/Android) Internship
 */

package com.example.visma_task_photos;

import android.content.Intent;
import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements PhotoFragment.OnListFragmentInteractionListener{

    JSONArray jsonArr;  // Array for storing urls

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Getting urls
        jsonArr = getJSON();
        List<String> jsonList = new ArrayList<>();
        for(int i=0; i < jsonArr.length(); i++) {
            try {
                //Log.d("App", jsonArr.getString(i));
                jsonList.add(jsonArr.getString(i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }
        // Adding urls to photos list
        for(String s : jsonList){
            PhotoContent.addItem(new Photo(s));
        }
    }

    // Opening new window for one photo
    @Override
    public void onListFragmentInteraction(Photo item) {
        Intent intent = new Intent(getApplicationContext(), PhotoActivity.class);
        intent.putExtra("_url", item.getUrl());
        startActivity(intent);
    }

    private JSONArray getJSON(){
        JSONObject jsonO;
        JSONArray jsonArray = null;
        try {
            jsonO = new JSONObject(loadJSONFromAsset());
            jsonArray = jsonO.getJSONArray("urls");
        } catch (JSONException e) {
            e.printStackTrace();
        }
        return jsonArray;
    }

    private String loadJSONFromAsset() {
        String json;
        try {
            InputStream is = getApplicationContext().getAssets().open("dog_urls.json");
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
        return json;
    }
}

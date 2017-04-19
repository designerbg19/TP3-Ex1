package com.example.walid.tp3_1;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.walid.tp1_6.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView myrcv;
    EtudiantAdapter myAdapter;
    String  url="http://gestionetudiants-samplewalid.rhcloud.com/students.json";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //Make call to AsyncTask
        new LoadInfo().execute();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.mymenu, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.search) {
            Toast.makeText(getApplicationContext(), "Rechercher un etudiant", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.add) {
            Toast.makeText(getApplicationContext(), "Ajouter un etudiant", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.delete) {
            Toast.makeText(getApplicationContext(), "Supprimer un etudiant", Toast.LENGTH_LONG).show();
        }
        if (id == R.id.edit) {
            Toast.makeText(getApplicationContext(), "Modifier un etudiant", Toast.LENGTH_LONG).show();
        }
        return super.onOptionsItemSelected(item);
    }

    private class LoadInfo extends AsyncTask<String, String, String> {
        ProgressDialog pdLoading = new ProgressDialog(MainActivity.this);
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
            pdLoading.setMessage("Loading students. Please wait...");
            pdLoading.setCancelable(false);
            pdLoading.show();
        }
        @Override
        protected String doInBackground(String... params) {
            HttpHandler sh = new HttpHandler();
            String result = sh.makeServiceCall(url);
            return result;
        }
        @Override
        protected void onPostExecute(String result) {
            pdLoading.dismiss();
            List<Etudiant> data=new ArrayList<>();
            pdLoading.dismiss();
            try {
                JSONArray jArray = new JSONArray(result);
                for(int i=0;i<jArray.length();i++){
                    JSONObject json_data = jArray.getJSONObject(i);
                    Etudiant etudiant = new Etudiant(json_data.getString("nom"),
                    json_data.getString("option"),
                    json_data.getString("email"),
                    json_data.getInt("abs"),
                    json_data.getString("avatar"));
                    data.add(etudiant);
                }
                myrcv = (RecyclerView) findViewById(R.id.rcv);
                myAdapter = new EtudiantAdapter(MainActivity.this, data);
                myrcv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                myrcv.setAdapter(myAdapter);

            } catch (JSONException e) {
                Toast.makeText(MainActivity.this, e.toString(), Toast.LENGTH_LONG).show();
            }

        }

    }


}

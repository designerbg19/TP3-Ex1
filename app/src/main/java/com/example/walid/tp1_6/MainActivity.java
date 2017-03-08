package com.example.walid.tp1_6;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView myrcv;
    EtudiantAdapter myAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // Setup and Handover data to recyclerview
        myrcv = (RecyclerView) findViewById(R.id.rcv);
        List<Etudiant> data = genererEtudiants();
        myAdapter = new EtudiantAdapter(MainActivity.this, data);
        myrcv.setLayoutManager(new LinearLayoutManager(MainActivity.this));
        myrcv.setAdapter(myAdapter);
    }
    private List<Etudiant> genererEtudiants(){
        List<Etudiant> etudiants = new ArrayList<Etudiant>();
        etudiants.add(new Etudiant("GLID","Etudiant 1", "nom.prenom@gmail.com",1));
        etudiants.add(new Etudiant("SRS", "Etudiant 2", "nom.prenom@gmail.com",2));
        etudiants.add(new Etudiant("SRS", "Etudiant 3", "nom.prenom@gmail.com",0));
        etudiants.add(new Etudiant("GLID", "Etudiant 4", "nom.prenom@gmail.com",4));
        etudiants.add(new Etudiant("SRS", "Etudiant 5", "nom.prenom@gmail.com",0));
        return etudiants;
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
}

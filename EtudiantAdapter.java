package com.example.walid.tp3_1;


import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.walid.tp1_6.R;

import java.util.Collections;
import java.util.List;

/**
 * Created by walid on 26/02/2017.
 */

public class EtudiantAdapter extends RecyclerView.Adapter<EtudiantAdapter.EtudiantHolder> {
    private Context context;
    private LayoutInflater inflater;
    List<Etudiant> data = Collections.emptyList();
    Etudiant etudiant;
    // créer le constructeur pour initialiser le contexte et les données à afficher
    public EtudiantAdapter(Context context, List<Etudiant> data) {
        this.context = context;
        inflater = LayoutInflater.from(context);
        this.data = data;
    }
    // créer notre vue à partir du fichier layout
    @Override
    public EtudiantHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view=inflater.inflate(R.layout.etudiantinfo2, parent,false);
        EtudiantHolder holder=new EtudiantHolder(view);
        return holder;
    }

    // Bind data
    @Override
    public void onBindViewHolder(EtudiantHolder holder, int position) {
        //recuperer la position courante de l'item et mettre à jour le RecyclerView
        etudiant=data.get(position);
        holder.nom.setText(etudiant.getNom());
        holder.email.setText(etudiant.getEmail());
        holder.option.setText(etudiant.getOption());
        holder.abs.setText(""+etudiant.getAbs());
        //charger
       Glide.with(context).load("http://gestionetudiants-samplewalid.rhcloud.com/images/" + etudiant.getAvatar())
                .placeholder(R.drawable.contact1)
                .error(R.drawable.contact1)
                .into(holder.avatar);
    }
    //retourner la taille de la liste d'item
    @Override
    public int getItemCount() {
        return data.size();
    }

    class EtudiantHolder extends RecyclerView.ViewHolder {
        public TextView nom;
        public TextView email;
        public TextView option;
        public TextView abs;
        public ImageView avatar;

        public EtudiantHolder(View itemView) {
            super(itemView);
            nom = (TextView) itemView.findViewById(R.id.nom);
            email = (TextView) itemView.findViewById(R.id.email);
            option = (TextView) itemView.findViewById(R.id.option);
            abs = (TextView) itemView.findViewById(R.id.nbabs);
            avatar = (ImageView) itemView.findViewById(R.id.avatar);
        }
    }
}
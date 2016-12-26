package com.android.curso.logotipo.adaptador;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.curso.logotipo.R;
import com.android.curso.logotipo.pojo.Mascota;

import java.util.ArrayList;

public class PerfilMascotasFragmentAdaptador extends RecyclerView.Adapter<PerfilMascotasFragmentAdaptador.PerfilMascotaViewHolder> {

    ArrayList<Mascota> mascotas;
    Activity activity;

    public PerfilMascotasFragmentAdaptador(ArrayList<Mascota> mascotas, Activity activity) {
        this.mascotas = mascotas;
        this.activity = activity;
    }

    @Override
    public PerfilMascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Damos vida al layout, asociandolo al RecycleView del cardview_contacto.xml
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_perfil_mascota, parent, false);
        return new PerfilMascotaViewHolder(v);
    }

    // Asocia cada elemento de la lista con cada View
    @Override
    public void onBindViewHolder(final PerfilMascotaViewHolder mascotaViewHolder, int position) {




        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoCVP.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvRaitingCVP.setText(Integer.toString(mascota.getVotos()));




        // Haremos que nuestros items sean clickeables

        mascotaViewHolder.imgFotoCVP.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Toast.makeText(activity, "Like", Toast.LENGTH_SHORT).show();
                mascota.setVotos(mascota.getVotos()+1);
                mascotaViewHolder.tvRaitingCVP.setText(Integer.toString(mascota.getVotos()));


            }
        });

    }


    @Override
    public int getItemCount() {  // Cantidad de elementos que tiene la lista contactos
        return mascotas.size();
    }

    public static class PerfilMascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCVP;
        private TextView tvRaitingCVP;

        public PerfilMascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCVP     = (ImageView)   itemView.findViewById(R.id.imgFotoCVP);
            tvRaitingCVP   = (TextView)    itemView.findViewById(R.id.tvRaitingCVP);
        }
    }



}

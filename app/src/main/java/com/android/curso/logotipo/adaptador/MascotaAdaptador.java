package com.android.curso.logotipo.adaptador;

import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.curso.logotipo.R;
import com.android.curso.logotipo.db.ConstructorMascotas;
import com.android.curso.logotipo.pojo.Mascota;

import java.util.ArrayList;


public class MascotaAdaptador extends RecyclerView.Adapter<MascotaAdaptador.MascotaViewHolder>{


    ArrayList<Mascota> mascotas;
    Activity activity;


    public MascotaAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    // Infla el layout y lo pasará al viewHolder par que el tenga cada elemento (view)
    @Override
    public MascotaViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // Damos vida al layout, asociandolo al RecycleView del cardview_contacto.xml
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaViewHolder(v);
    }

    // Asocia cada elemento de la lista con cada View
    @Override
    public void onBindViewHolder(final MascotaViewHolder mascotaViewHolder, int position) {



        final Mascota mascota = mascotas.get(position);
        mascotaViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaViewHolder.tvRaitingCV.setText(Integer.toString(mascota.getVotos()));




        // Haremos que nuestros items sean clickeables

        mascotaViewHolder.imgFotoCV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                Toast.makeText(activity, mascota.getNombre(), Toast.LENGTH_SHORT).show();


            }
        });

        mascotaViewHolder.btnLikeCV.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                //Toast.makeText(activity, contacto.getNombre(), Toast.LENGTH_SHORT).show();
                //Toast.makeText(activity, "Diste like desde el huesito a " +mascota.getNombre(), Toast.LENGTH_SHORT).show();
/*
                mascota.setVotos(mascota.getVotos()+1);
                mascotaViewHolder.tvRaitingCV.setText(Integer.toString(mascota.getVotos()));
*/
                ConstructorMascotas constructorMascotas = new ConstructorMascotas(activity);
                constructorMascotas.darVotoMascota(mascota);

                mascotaViewHolder.tvRaitingCV.setText(String.valueOf(constructorMascotas.obtenerVotosMascota(mascota)));





            }
        });
    }

    @Override
    public int getItemCount() {  // Cantidad de elementos que tiene la lista contactos
        return mascotas.size();
    }

    public static class MascotaViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private ImageButton btnLikeCV;
        private TextView tvRaitingCV;

        public MascotaViewHolder(View itemView) {
            super(itemView);
            imgFotoCV     = (ImageView)   itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV    = (TextView)    itemView.findViewById(R.id.tvNombreCV);
            btnLikeCV     = (ImageButton) itemView.findViewById(R.id.btnLikeCV);
            tvRaitingCV   = (TextView)    itemView.findViewById(R.id.tvRaitingCV);
        }
    }

}

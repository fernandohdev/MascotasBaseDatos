package com.android.curso.logotipo.adaptador;


import android.app.Activity;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.curso.logotipo.R;
import com.android.curso.logotipo.pojo.Mascota;

import java.util.ArrayList;

public class MascotaRaitingAdaptador extends RecyclerView.Adapter<MascotaRaitingAdaptador.MascotaRaitingViewHolder>{

    ArrayList<Mascota> mascotas;
    Activity activity;


    public MascotaRaitingAdaptador(ArrayList<Mascota> mascotas, Activity activity){
        this.mascotas = mascotas;
        this.activity = activity;
    }


    @Override
    public MascotaRaitingAdaptador.MascotaRaitingViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview_mascota, parent, false);
        return new MascotaRaitingAdaptador.MascotaRaitingViewHolder(v);
    }


    @Override
    public void onBindViewHolder(final MascotaRaitingAdaptador.MascotaRaitingViewHolder mascotaRaitingViewHolder, int position) {

        final Mascota mascota = mascotas.get(position);
        mascotaRaitingViewHolder.imgFotoCV.setImageResource(mascota.getFoto());
        mascotaRaitingViewHolder.tvNombreCV.setText(mascota.getNombre());
        mascotaRaitingViewHolder.tvRaitingCV.setText(Integer.toString(mascota.getVotos()));

    }

    @Override
    public int getItemCount() {  // Cantidad de elementos que tiene la lista contactos
        return mascotas.size();
    }

    public static class MascotaRaitingViewHolder extends RecyclerView.ViewHolder {

        private ImageView imgFotoCV;
        private TextView tvNombreCV;
        private ImageButton btnLikeCV;
        private TextView tvRaitingCV;

        public MascotaRaitingViewHolder(View itemView) {
            super(itemView);
            imgFotoCV     = (ImageView)   itemView.findViewById(R.id.imgFotoCV);
            tvNombreCV    = (TextView)    itemView.findViewById(R.id.tvNombreCV);
            btnLikeCV     = (ImageButton) itemView.findViewById(R.id.btnLikeCV);
            tvRaitingCV   = (TextView)    itemView.findViewById(R.id.tvRaitingCV);
        }
    }
}

package com.android.curso.logotipo.vista;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.curso.logotipo.R;
import com.android.curso.logotipo.adaptador.PerfilMascotasFragmentAdaptador;
import com.android.curso.logotipo.pojo.Mascota;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class PerfilMascotaFragment extends Fragment {

    public static ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    public PerfilMascotasFragmentAdaptador adaptador;

    public PerfilMascotaFragment() {
        // Required empty public constructor
        mascotas = new ArrayList<Mascota>();
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_perfil_mascota, container, false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotasPerfil);

        //LinearLayoutManager llm = new LinearLayoutManager(getActivity());

        GridLayoutManager glm = new GridLayoutManager(getActivity(), 3);
        listaMascotas.setLayoutManager(glm);

        inicializarListaPerfilMascotas();
        inicializarAdaptador();


        return v;

    }

    public void inicializarAdaptador(){
        adaptador = new PerfilMascotasFragmentAdaptador(mascotas, getActivity());
        listaMascotas.setAdapter(adaptador);
    }

    public void inicializarListaPerfilMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Alvin", 11, R.drawable.alvin01));
        mascotas.add(new Mascota("Alvin", 12, R.drawable.alvin02));
        mascotas.add(new Mascota("Alvin", 13, R.drawable.alvin03));
        mascotas.add(new Mascota("Alvin", 42, R.drawable.alvin04));
        mascotas.add(new Mascota("Alvin", 51, R.drawable.alvin05));
        mascotas.add(new Mascota("Alvin", 64, R.drawable.alvin06));
        mascotas.add(new Mascota("Alvin", 17, R.drawable.alvin07));
        mascotas.add(new Mascota("Alvin", 29, R.drawable.alvin09));
        mascotas.add(new Mascota("Alvin", 10, R.drawable.alvin10));

    }
}

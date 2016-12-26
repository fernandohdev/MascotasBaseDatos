package com.android.curso.logotipo.vista;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.android.curso.logotipo.R;
import com.android.curso.logotipo.adaptador.MascotaAdaptador;
import com.android.curso.logotipo.pojo.Mascota;
import com.android.curso.logotipo.presentador.IMascotasFragmentPresenter;
import com.android.curso.logotipo.presentador.MascotasFragmentPresenter;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class MascotasFragment extends Fragment implements IMascotasFragmentView {

    public static ArrayList<Mascota> mascotas;
    private RecyclerView listaMascotas;
    private IMascotasFragmentPresenter presenter;


    public MascotasFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View v = inflater.inflate(R.layout.fragment_mascotas, container, false);

        listaMascotas = (RecyclerView)v.findViewById(R.id.rvMascotas);

        presenter = new MascotasFragmentPresenter(this, getContext());


        //inicializarListaMascotas();




        return v;
    }

/*
    public void inicializarListaMascotas(){

        mascotas = new ArrayList<Mascota>();

        mascotas.add(new Mascota("Ardillita", 0, R.drawable.ardilla));
        mascotas.add(new Mascota("Dino",      0, R.drawable.dino));
        mascotas.add(new Mascota("Garfield",  0, R.drawable.garfield));
        mascotas.add(new Mascota("Gata",      0, R.drawable.gata));
        mascotas.add(new Mascota("Gato",      0, R.drawable.gato));
        mascotas.add(new Mascota("Odi",       0, R.drawable.odi));
        mascotas.add(new Mascota("Pluto",     0, R.drawable.pluto));

    }*/


    @Override
    public void generarLinearLayoutVertical() {
        LinearLayoutManager llm = new LinearLayoutManager(getActivity());
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotas.setLayoutManager(llm);
    }

    @Override
    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas) {
        MascotaAdaptador adaptador = new MascotaAdaptador(mascotas, getActivity());
        return adaptador;
    }

    @Override
    public void inicializarAdaptadorM(MascotaAdaptador adaptador) {

        listaMascotas.setAdapter(adaptador);
    }
}

package com.android.curso.logotipo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import com.android.curso.logotipo.adaptador.MascotaRaitingAdaptador;
import com.android.curso.logotipo.pojo.Mascota;

import java.util.ArrayList;


public class ActivityRaiting extends AppCompatActivity{


    ArrayList<Mascota> mascotasRaiting;
    private RecyclerView listaMascotasRaiting;
    public MascotaRaitingAdaptador adaptadorRaiting;


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raiting);




        Toolbar miActionBar = (Toolbar) findViewById(R.id.miActionBarRaiting);
        miActionBar.setLogo(R.drawable.huella);
        miActionBar.setTitleMarginStart(165);
        setSupportActionBar(miActionBar);

        // agregamos soporte para Navegacion SUBIR
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);



        listaMascotasRaiting = (RecyclerView)findViewById(R.id.rvMascotasRaiting);


        LinearLayoutManager llm = new LinearLayoutManager(this);
        llm.setOrientation(LinearLayoutManager.VERTICAL);
        listaMascotasRaiting.setLayoutManager(llm);

        inicializarListaMascotasRaiting();
        inicializarAdaptador();

        mascotasRaiting.addAll(EnlaceMascotas.getMascotas());


    }

    public void inicializarAdaptador(){
        adaptadorRaiting = new MascotaRaitingAdaptador(mascotasRaiting, this);
        listaMascotasRaiting.setAdapter(adaptadorRaiting);
    }



    public void inicializarListaMascotasRaiting(){
        mascotasRaiting = new ArrayList<Mascota>();
    }

}

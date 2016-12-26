package com.android.curso.logotipo.presentador;


import android.content.Context;

import com.android.curso.logotipo.adaptador.MascotaAdaptador;
import com.android.curso.logotipo.db.ConstructorMascotas;
import com.android.curso.logotipo.pojo.Mascota;
import com.android.curso.logotipo.vista.IMascotasFragmentView;

import java.util.ArrayList;

public class MascotasFragmentPresenter implements IMascotasFragmentPresenter {

    private IMascotasFragmentView iMascotasFragmentView;
    private Context context;
    private ConstructorMascotas constructorMascotas;
    private ArrayList<Mascota> mascotas;


    public MascotasFragmentPresenter(IMascotasFragmentView iMascotasFragmentView, Context context) {
        this.iMascotasFragmentView = iMascotasFragmentView;
        this.context = context;
        obtenerMascotasBaseDatos();
    }


    @Override
    public void obtenerMascotasBaseDatos() {
        constructorMascotas = new ConstructorMascotas(context);
        mascotas = constructorMascotas.obtenerDatos();
        mostartMascotasM();
    }

    @Override
    public void mostartMascotasM() {
        iMascotasFragmentView.inicializarAdaptadorM(iMascotasFragmentView.crearAdaptador(mascotas));
        iMascotasFragmentView.generarLinearLayoutVertical();
    }
}

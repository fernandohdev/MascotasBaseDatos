package com.android.curso.logotipo.vista;


import com.android.curso.logotipo.adaptador.MascotaAdaptador;
import com.android.curso.logotipo.pojo.Mascota;

import java.util.ArrayList;

public interface IMascotasFragmentView {



    public void generarLinearLayoutVertical();

    public MascotaAdaptador crearAdaptador(ArrayList<Mascota> mascotas);

    public void inicializarAdaptadorM(MascotaAdaptador adaptador);




}

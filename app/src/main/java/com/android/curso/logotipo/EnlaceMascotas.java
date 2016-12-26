package com.android.curso.logotipo;

import com.android.curso.logotipo.pojo.Mascota;

import java.util.ArrayList;


public class EnlaceMascotas {

    private static ArrayList<Mascota> mascotas = new ArrayList<Mascota>();

    public static ArrayList<Mascota> getMascotas() {
        return mascotas;
    }

    public static void setMascotas(Mascota mascota) {
        mascotas.add(mascota);
    }

    public static void setMascotasAll(ArrayList<Mascota> mascotasAll) {
        mascotas.addAll(mascotasAll);
    }

    public static void clear(){
        mascotas.clear();
    }
}

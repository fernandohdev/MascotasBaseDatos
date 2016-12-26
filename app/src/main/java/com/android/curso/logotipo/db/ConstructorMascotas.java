package com.android.curso.logotipo.db;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.android.curso.logotipo.R;
import com.android.curso.logotipo.pojo.Mascota;

import java.util.ArrayList;

public class ConstructorMascotas {

    private static final int VOTO = 1;
    private Context context;

    public ConstructorMascotas(Context context) {
        this.context = context;
    }


    public ArrayList<Mascota> obtenerDatos(){

        /*ArrayList<Mascota> mascotas = new ArrayList<>();

        mascotas.add(new Mascota("Ardillita",  5, R.drawable.ardilla));
        mascotas.add(new Mascota("Dino",       1, R.drawable.dino));
        mascotas.add(new Mascota("Garfield",  45, R.drawable.garfield));
        mascotas.add(new Mascota("Gata",       9, R.drawable.gata));
        mascotas.add(new Mascota("Gato",      12, R.drawable.gato));
        mascotas.add(new Mascota("Odi",       35, R.drawable.odi));
        mascotas.add(new Mascota("Pluto",     26, R.drawable.pluto));

        return mascotas;*/

        BaseDatos db = new BaseDatos(context);
        insertarMascotas(db);
        return db.obtenerTodasLasMascotas();
    }


    public void insertarMascotas(BaseDatos db){

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Ardillita");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,   R.drawable.ardilla);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Dino");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,   R.drawable.dino);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Garfield");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,   R.drawable.garfield);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Gata");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,   R.drawable.gata);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Gato");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,   R.drawable.gato);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Odi");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,   R.drawable.odi);
        db.insertarMascota(contentValues);

        contentValues = new ContentValues();
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE, "Pluto");
        contentValues.put(ConstantesBaseDatos.TABLE_MASCOTAS_FOTO,   R.drawable.pluto);
        db.insertarMascota(contentValues);
    }



    public void darVotoMascota(Mascota mascota){

        BaseDatos db = new BaseDatos(context);

        ContentValues contentValues = new ContentValues();

        contentValues.put(ConstantesBaseDatos.TABLE_VOTOS_MASCOTA_ID_MASCOTA, mascota.getId());
        contentValues.put(ConstantesBaseDatos.TABLE_VOTOS_MASCOTA_VOTOS, VOTO);

        db.insertarVotoMascota(contentValues);

    }

    public int obtenerVotosMascota(Mascota mascota){
        BaseDatos db = new BaseDatos(context);
        return db.obtenerVotosMascota(mascota);
    }


}

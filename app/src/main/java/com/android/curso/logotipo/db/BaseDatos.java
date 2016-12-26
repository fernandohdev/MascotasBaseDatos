package com.android.curso.logotipo.db;


import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import com.android.curso.logotipo.pojo.Mascota;

import java.util.ArrayList;

public class BaseDatos extends SQLiteOpenHelper {

    private Context context;


    public BaseDatos(Context context) {
        super(context, ConstantesBaseDatos.DATA_BASE_NAME, null, ConstantesBaseDatos.DATA_BASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String queryCrearTablaMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_MASCOTAS + "(" +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_ID     + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_NOMBRE + " TEXT, " +
                                        ConstantesBaseDatos.TABLE_MASCOTAS_FOTO   + " INTEGER" +
                                        ")";

        String queryCrearTablaVotosMascota = "CREATE TABLE " + ConstantesBaseDatos.TABLE_VOTOS_MASCOTA + "(" +
                ConstantesBaseDatos.TABLE_VOTOS_MASCOTA_ID          + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ConstantesBaseDatos.TABLE_VOTOS_MASCOTA_ID_MASCOTA  + " INTEGER, " +
                ConstantesBaseDatos.TABLE_VOTOS_MASCOTA_VOTOS       + " INTEGER, " +
                "FOREIGN KEY(" + ConstantesBaseDatos.TABLE_VOTOS_MASCOTA_ID_MASCOTA + ") " +
                "REFERENCES "  + ConstantesBaseDatos.TABLE_MASCOTAS + "(" + ConstantesBaseDatos.TABLE_MASCOTAS_ID + ")" +
                 ")";


        db.execSQL(queryCrearTablaMascota);
        db.execSQL(queryCrearTablaVotosMascota);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_MASCOTAS);
        db.execSQL("DROP TABLE IF EXIST " + ConstantesBaseDatos.TABLE_VOTOS_MASCOTA);
        onCreate(db);

    }

    public ArrayList<Mascota> obtenerTodasLasMascotas(){

        ArrayList<Mascota> mascotas = new ArrayList<>();

        String query = "SELECT * FROM " + ConstantesBaseDatos.TABLE_MASCOTAS;
        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        while( registros.moveToNext() ){

            Mascota mascotaActual = new Mascota();
            mascotaActual.setId(registros.getInt(0));
            mascotaActual.setNombre(registros.getString(1));
            mascotaActual.setFoto(registros.getInt(2));

            String queryVotos = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_VOTOS_MASCOTA_VOTOS + ") as votos " +
                    " FROM " + ConstantesBaseDatos.TABLE_VOTOS_MASCOTA +
                    " WHERE " + ConstantesBaseDatos.TABLE_VOTOS_MASCOTA_ID_MASCOTA + "=" + mascotaActual.getId();

            Cursor registrosVotos = db.rawQuery(queryVotos, null);
            if(registrosVotos.moveToNext()){
                mascotaActual.setVotos(registrosVotos.getInt(0));
            }
            else{
                mascotaActual.setVotos(0);
            }


            mascotas.add(mascotaActual);
        }

        db.close();

        return mascotas;

    }

    public void insertarMascota(ContentValues contentValues){

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_MASCOTAS, null, contentValues);
        db.close();

    }

    public void insertarVotoMascota(ContentValues contentValues) {

        SQLiteDatabase db = this.getWritableDatabase();
        db.insert(ConstantesBaseDatos.TABLE_VOTOS_MASCOTA, null, contentValues);
        db.close();

    }

    public int obtenerVotosMascota(Mascota mascota){
        int votos = 0;
        String query = "SELECT COUNT(" + ConstantesBaseDatos.TABLE_VOTOS_MASCOTA_VOTOS + ")" +
                " FROM " + ConstantesBaseDatos.TABLE_VOTOS_MASCOTA +
                " WHERE " + ConstantesBaseDatos.TABLE_VOTOS_MASCOTA_ID_MASCOTA + "=" + mascota.getId();

        SQLiteDatabase db = this.getWritableDatabase();

        Cursor registros = db.rawQuery(query, null);

        if(registros.moveToNext()){
            votos = registros.getInt(0);
        }


        db.close();

        return votos;

    }
}

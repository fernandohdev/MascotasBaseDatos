package com.android.curso.logotipo.db;


public class ConstantesBaseDatos {

    public static final String DATA_BASE_NAME = "Mascotas";
    public static final int DATA_BASE_VERSION = 1;

    public static final String  TABLE_MASCOTAS        = "mascota";
    public static final String  TABLE_MASCOTAS_ID     = "id";
    public static final String  TABLE_MASCOTAS_NOMBRE = "nombre";
    public static final String  TABLE_MASCOTAS_FOTO   = "foto";


    public static final String TABLE_VOTOS_MASCOTA            = "mascota_votos";
    public static final String TABLE_VOTOS_MASCOTA_ID         = "id";
    public static final String TABLE_VOTOS_MASCOTA_ID_MASCOTA = "id_mascota";
    public static final String TABLE_VOTOS_MASCOTA_VOTOS      = "numero_votos";
}

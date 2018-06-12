package com.example.user.agenda;

// TODO: 1 Nuestra clase DatabaseHelper hereda metodos de SQLiteOpenHelper para poder usar sentencias de SQL

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper{

// TODO: 2 definimos dos constantes para el nombre de nuestra DB y la version
    private static final String DATABASE_NAME = "Contactos";
    private static final int DATABASE_VERSION = 1;

// TODO: 3 usamos una constante para almacenar una instruccion de SQL para crear la tabla contactos
    private static final String DATABASE_CREATE_CONTACTOS =
        "create table contactos (_id integer primary key autoincrement, "+ "nombre text not null, email text not null, edad integer not null)";

    // TODO: 4 usamos otra constante para eliminar la tabla con una instruccion SQL
    private static final String DATABASE_DELETE_CONTACTOS =
            "drop table if exists contactos";

    //TODO: constructor de la clase
    public DatabaseHelper(Context context){
        //TODO: esta linea hace referencia al constructor de la clase padre
        super(context, DATABASE_NAME,null, DATABASE_VERSION);
    }

// TODO: se ejecuta automatico
    @Override
    public void onCreate(SQLiteDatabase db) {
        //TODO: creamos nuestras tablas para la db actual
        createTables(db);

    }

// TODO: se ejecuta automatico
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        deleteTables(db);
        createTables(db);
        //TODO: actualizamos/modificamos tabla
    }


    // TODO:  metodos para crear y eliminar nuestra unica tabla
    private void createTables(SQLiteDatabase db) {
        db.execSQL(DATABASE_CREATE_CONTACTOS);
    }

    private void deleteTables(SQLiteDatabase db) {
        db.execSQL(DATABASE_DELETE_CONTACTOS);
    }

}
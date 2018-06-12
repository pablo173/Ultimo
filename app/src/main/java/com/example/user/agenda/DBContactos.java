package com.example.user.agenda;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DBContactos {

//TODO: variable tipo SQLite (para ejecutar instrucciones SQL
    private SQLiteDatabase db = null;
    //TODO: variable tipo database helper (clase que contiene todas las instrucciones para crear un DB, tablas...
    private DatabaseHelper dbhelper = null;
//TODO: variable de tipo context
    Context context;

    //TODO: constructor de la clase actual
    public DBContactos(Context contexto){
        //TODO: pasamos el contexto cuando usamos este constructor
        this.context=contexto;

        //TODO: crea una instancia del helper
        dbhelper=new DatabaseHelper(context);

        //TODO: crea un objeto de SQLiteDatabase para operar contra la base de datos
        db=dbhelper.getWritableDatabase();
    }

    //TODO: metodo para cerrar la base de datos
    public void close(){
        dbhelper.close();
    }

    //TODO: metodo para insertar un registro en nuestra base de datos
    public long guardarContacto(Contacto c){
        ContentValues initialValues=new ContentValues();
        initialValues.put("key_nombre", c.getNombre());
        initialValues.put("key_email", c.getEmail());
        initialValues.put("key_edad", c.getEdad());
        //TODO:
        return db.insert("contacto", null, initialValues);
    }

    //TODO: metodo para buscar un contacto
    public Contacto buscarPorEmail(String email){
        Contacto con = null;

        //TODO: el cursosr guarda el rsultado de nuestra query
        Cursor c = db.query("contactos",
                new String[]{"_id", "nombre","email","edad"},
                "email=?", new String[]{email}, null,
                null,null);

        //TODO: Preguntamos si podemos movernos en cada registro
        if(c.moveToNext()){
            con = new Contacto(c.getString(1),c.getString(2),c.getInt(3));
            }

        return con;


    }

    //TODO: metodo que devuelve un Cursos (sqlite) del resultado de una query
    public Cursor recuperarContactos (){
        return db.query(table: "contactos"),
        new String[]{"id nombre edad}
    }

}
package com.example.user.agenda;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class AgregarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar);
    }

    //TODO: metodo que inserta un registro en la db
    public void guardar (View v){

//TODO: creamos una referencia a cada uno de los componenetes (editText) de la vista y recogemos sus valores
        String nombre = ((EditText)this.findViewById(R.id.edtNombre)).getText().toString();
        String email = ((EditText)this.findViewById(R.id.edtBuscar)).getText().toString( );
        int edad = Integer.parseInt(((EditText) this.findViewById(R.id.edtEdad)).getText().toString());

        //TODO: creamos un objeto del tipo contacto
        Contacto c = new Contacto (nombre, email, edad);
        //TODO: creamos un objeto del tipo DBContactos
        DBContactos gestion = new DBContactos(this);
        //TODO: añadimos el contacto usando guardarcontacto (contacto c)
        gestion.guardarContacto(c);
        //TODO: cerramos db con metodo close
        gestion.close();
        //TODO: finalizamos la actividad
        this.finish();

    }
}

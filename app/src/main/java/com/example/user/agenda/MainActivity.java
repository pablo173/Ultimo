package com.example.user.agenda;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //TODO: metodo para asociar el boton añadir (usando on click)
    public void agregar(View v){
        Intent intent = new Intent(this,AgregarActivity.class);
        this.startActivity (intent);
    }

    //TODO: metodo para asociar el boton buscar (usando on click)
    public void abrirBuscar(View v){
        Intent intent = new Intent(this,BuscarActivity.class);
        this.startActivity (intent);
    }

    //TODO metodo para mostrar los contactos de la tabla contactos
    public void abrirLista (View view) {
        Intent intent = new Intent(this, ListadoActivity.class);
        this.startActivity(intent);
    }
}

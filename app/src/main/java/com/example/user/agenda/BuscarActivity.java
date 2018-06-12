package com.example.user.agenda;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class BuscarActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buscar);
    }

    //TODO: busca un contacto en la agenda(boton buscar: onclick)
    public void buscar(View v){

        //TODO: referenciar nuestro objeto que esta en la pantalla
        String email=((EditText)this.findViewById(R.id.edtEmailBusca)).getText().toString();


        //TODO: creamos una instancia llamada "c" y la inicializamos en null
        Contacto c = null;

        //TODO: creamos un objeto de tipo DBContactos llamado gestion
        DBContactos gestion = new DBContactos(this);

        //TODO: usamos nuestro objeto gestion para acceder al metodo buscarPorEmail y devolver el resultado al otro objeto "c"
        c = gestion.buscarPorEmail(email);

        //TODO: usamos el metodo mostrardato para visualizar el resultado en un toast (mensaje pqeño q aparece unos segundos)
        mostrarDato(c);

        //TODO: cerramos gestion
        gestion.close();


    }


    //TODO: metodo que muestra un AlertDialog con el resultado (Dato de un contacto)
    public void mostrarDato (Contacto c){

        if(c == null){
            //TODO: creamos un cuadro de dialogo para mostrar un error al usuario
            AlertDialog.Builder cuadro = new AlertDialog.Builder(this);

            cuadro.setMessage (R.string.error_message);

           //TODO: establecemos boton no
            cuadro.setNegativeButton(android.R.string.no,
                    new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {

            //TODO: cerramos activity buscar
                        BuscarActivity.this.finish();
                        });

                    //TODO: establecemos boton yes
                        cuadro.setPositiveButton(android.R.string.yes,null);


        //TODO: caso contrario mostramos datos obtenidos en un toast
        else {
            String datos = "Nombre: " + c.getNombre() +
                    "\nEmail:" + c.getEmail() + "\n Edad:" + c.getEdad();

            Toast.makeText(this,datos,Toast.LENGTH_LONG).show();
        }
    }

}

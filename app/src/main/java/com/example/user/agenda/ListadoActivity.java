package com.example.user.agenda;

import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CursorAdapter;
import android.widget.ListView;
import android.widget.SimpleCursorAdapter;

public class ListadoActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listado);

        ListView lstContactos;

        //TODO: crea un objeto llamado gestion de tipo DBContactos
        DBContactos gestion = new DBContactos(this);

        //TODO: creamos un cursor para recuperarr el resultado del metodo recuperrcontactos (return db.query)
        Cursor cur = gestion.recuperarContactos();

        //TODO: referenciamos nuestro listview de la vista
        lstContactos = (ListView)this.findViewById(R.id.lstContactos);

        //TODO: creamos una array de tipo strring para hacer referencia a las columnas de la tabla contactos y poder usarlos en el adaptador
        String [] columns = new String[]{"nombre","email","edad"};


        //TODO: Creamos un simple cursor adapter (adaptador) que permite usar un cursor (sqlite)
        SimpleCursorAdapter sc = new SimpleCursorAdapter(this,
                                                            android.R.layout.simple_list_item_1,
                                                            cur,
                                                            columns,
                                                            new int[]{android.R.id.text1},
                                                            CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);

        //TODO: establecemos en nuestro listview el adapatador
        lstContactos.setAdapter(sc);

        //TODO: cerramos nuestra base de datos
        gestion.close();



        public void salir(View){
            this.finish();
        }



    }
}

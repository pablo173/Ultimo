package com.example.user.agenda;

import java.io.Serializable;

public class Contacto implements Serializable {

    //TODO: atributos de la clase contacto
    private String nombre;
    private String email;
    private int edad;


//TODO: constructor de la clase contacto
    public Contacto(String nombre, String email, int edad) {
        this.nombre = nombre;
        this.email = email;
        this.edad = edad;
    }

    //TODO: getters y setters de los atributos
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }




}

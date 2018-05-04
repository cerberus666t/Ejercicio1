package com.example.cerbe.ejercicio1;

import android.content.Context;

public class Alumno {
    private String nombre;
    private String apellido;
    private long numCuenta;
    private String correo;
    private String genero;
    private String facultad;
    private Context contexto;


    public Alumno(String nombre, String apellido, long numCuenta, String correo, String genero, String facultad) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numCuenta = numCuenta;
        this.correo = correo;
        this.genero = genero;
        this.facultad = facultad;
    }

    public Alumno(String nombre, String apellido, long numCuenta, String correo, String genero, String facultad,Context contexto) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.numCuenta = numCuenta;
        this.correo = correo;
        this.genero = genero;
        this.facultad = facultad;
        this.contexto = contexto;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public long getNumCuenta() {
        return numCuenta;
    }

    public void setNumCuenta(long numCuenta) {
        this.numCuenta = numCuenta;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getGenero() {
        return genero;
    }

    public void setGenero(String genero) {
        this.genero = genero;
    }

    public String getFacultad() {
        return facultad;
    }

    public void setFacultad(String facultad) {
        this.facultad = facultad;
    }

    @Override
    public String toString() {
        return  contexto.getResources().getString(R.string.toastIni)+contexto.getResources().getString(R.string.toastNombre)+
                getNombre()+contexto.getResources().getString(R.string.toastApellido)+getApellido()+
                contexto.getResources().getString(R.string.toastNumC)+getNumCuenta()+
                contexto.getResources().getString(R.string.toastCorreo)+getCorreo()+
                contexto.getResources().getString(R.string.toastGenero)+getGenero()+
                contexto.getResources().getString(R.string.toastFacultad)+getFacultad();
    }
}

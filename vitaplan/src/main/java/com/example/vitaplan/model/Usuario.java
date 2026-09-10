package com.example.vitaplan.model;

public class Usuario {
 private Long id;
 private String nombre;
 private String apellido;
 private String correo;
 private String contrasena;
 private String telefono;
 
 public Usuario(){
     
 }
 
 public Usuario(Long id, String nombre, String apellido, String correo, String contrasena, String telefono){
     this.id = id;
     this.nombre = nombre;
     this.apellido = apellido;
     this.correo = correo;
     this.contrasena = contrasena;
     this.telefono = telefono;
 }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getContrasena() {
        return contrasena;
    }

    public void setContrasena(String contraseña) {
        this.contrasena = contraseña;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
 
 
}

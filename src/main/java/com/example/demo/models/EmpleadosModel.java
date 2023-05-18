/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.demo.models;

import jakarta.persistence.*;

/**
 *
 * @author gamc1
 */


@Entity
@Table(name = "empleados")
public class EmpleadosModel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)
    private Long id;
    private String apellido;
    private String email;
    private String nombre;
    private String otros_nombres;
    private String pais;

    public void setId(Long id){
        this.id = id;
    }
    public Long getId(){
        return id;
    }
    //
    public void setApellido(String apellido){
        this.apellido = apellido;
    }
    public String getApellido(){
        return apellido;
    }
    //
    public void setEmail(String email){
        this.email = email;
    }
    public String getEmail(){
        return email;
    }
    //
    public void setNombre(String nombre){
        this.nombre = nombre;
    }
    public String getNombre(){
        return nombre;
    }
    //
    public void setOtrosNombres(String otros_nombres){
        this.otros_nombres = otros_nombres;
    }
    public String getOtrosNombres(){
        return otros_nombres;
    }
    //
    public void setPais(String pais){
        this.pais = pais;
    }
    public String getPais(){
        return pais;
    }

}

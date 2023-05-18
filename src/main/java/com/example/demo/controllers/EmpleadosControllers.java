package com.example.demo.controllers;


import org.springframework.beans.factory.annotation.Autowired;

import com.example.demo.models.EmpleadosModel;
import com.example.demo.repositories.EmpleadoRepository;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestBody;


@RestController
@RequestMapping("/")
public class EmpleadosControllers {
    //we will use it to handle the data
    @Autowired
    private EmpleadoRepository empleadoRepository;


    //Map ONLY POST Requests
    @PostMapping(path = "/add")
    public @ResponseBody EmpleadosModel addNewUser (@RequestBody EmpleadosModel user){
        
        // Creamos el usuario para guardarlo en la base
        EmpleadosModel newUser = new EmpleadosModel();
        newUser.setNombre(user.getNombre());
        newUser.setApellido(user.getApellido());
        newUser.setPais(user.getPais());
        newUser.setOtrosNombres(user.getOtrosNombres());

        // Si de colombia agraga el dominio correspondiente
        String dominio = user.getPais() == "Colombia" ? "com": "com.us";

        // Busca en la base si existe el nombre y usuario duplicado
        if ( empleadoRepository.countUserDuplicate(user.getNombre(), user.getApellido()) > 0 ){
            int total = empleadoRepository.countUserDuplicate(user.getApellido(),user.getApellido()) + 1;
            newUser.setEmail( user.getEmail() + total + "@jvntecnologias." + dominio );
        }else{
            newUser.setEmail( user.getEmail() + "@jvntecnologias." + dominio );
        }
        // Una vez realizado la creacion de usuario procedemos a guardar en la BD
        empleadoRepository.save(newUser);
        return user;
    }



    // Returns All the Empleados at path `./all`
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<EmpleadosModel> getAllUsers() {
        // This returns a JSON or XML with the users
        return empleadoRepository.findAll();
    }


}

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
        
        EmpleadosModel newUser = new EmpleadosModel();

        newUser.setNombre(user.getNombre());
        newUser.setApellido(user.getApellido());
        newUser.setPais(user.getPais());
        newUser.setOtrosNombres(user.getOtrosNombres());


        boolean userExist = true;
        while ( userExist ) {
            if(empleadoRepository.existsByEmail(user.getEmail())){
                userExist = true;
            }else{
                
                newUser.setEmail(null);
                userExist = false;
            }
            
        }
        return user;
    }
    // Returns All the Empleados at path `./all`
    @GetMapping(path = "/all")
    public @ResponseBody Iterable<EmpleadosModel> getAllUsers() {
        // This returns a JSON or XML with the users
        return empleadoRepository.findAll();
    }


}

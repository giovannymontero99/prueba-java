package com.example.demo.repositories;

import com.example.demo.models.EmpleadosModel;


import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpleadoRepository extends CrudRepository<EmpleadosModel, Long> {

    @Query(value = "SELECT COUNT(*) FROM empleados WHERE nombre LIKE %:nombre% AND apellido LIKE %:apellido%" , nativeQuery = true )
    int countUserDuplicate( @Param("nombre") String nombre, @Param("apellido") String apellido);
}
package com.example.TurismoApp.repositorio;

import com.example.TurismoApp.modelos.Compañia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EmpresaRepositorio extends JpaRepository <Compañia, Integer>{

}

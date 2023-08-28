package com.example.TurismoApp.servicio;
import com.example.TurismoApp.Validaciones.EmpresaValidacion;
import com.example.TurismoApp.modelos.Compañia;
import com.example.TurismoApp.repositorio.EmpresaRepositorio;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;
import java.util.Optional;

public class EmpresaServicio {
    @Autowired
    EmpresaRepositorio empresaRepositorio;
    @Autowired
    EmpresaValidacion empresaValidacion;

    public Compañia registrarEmpresa(Compañia datosARegistrar) throws Exception
    {
        try
        {
            if(!this.empresaValidacion.validarNombre(datosARegistrar.getNombre())){
                throw new Exception("error en el servicio");
            }
            //SI PASO TODOS LOS IF ESTOY LISTO PARA LLAMAR AL REPO
            return (this.empresaRepositorio.save(datosARegistrar));

        }catch (Exception error) {
            throw new Exception(error.getMessage());

        }

    }

    public Compañia modificarEmpresa(Integer id, Compañia datosAModificar) throws Exception
    {
        try {
            //validamos la informacion
            if(!this.empresaValidacion.validarNombre(datosAModificar.getNombre())){
                throw new Exception("Error en el dato entregado");
            }

            //Buscar que la empresa que tiene el id que envia el usuario exista en BD
           Optional<Compañia>empresaEncontrada=this.empresaRepositorio.findById(id);
            //pregunto si lo que busque esta vacio
            if(empresaEncontrada.isEmpty()){
                throw new Exception("Empresa no encontrada");
            }
            //rutina por si la encontre
            //1.convierto el opcional en la entidad respectiva
            Compañia empresaQueExiste=empresaEncontrada.get();
            //2. a la empresa que existe le cambio la informacion que el usuario necesita
            empresaQueExiste.setNombre(datosAModificar.getNombre());

            //3. guardar la informaicon que se acaba de editar (SET)
            return (this.empresaRepositorio.save(datosAModificar));

        }catch (Exception error){
            throw new Exception(error.getMessage());

        }


    }
    public Compañia buscarEmpresaPorId(Integer id) throws Exception {
        try{
            Optional<Compañia> empresaOpcional= this.empresaRepositorio.findById(id);
            if (empresaOpcional.isEmpty()){
                throw new Exception("Empresa no encontrada");
            }
            return empresaOpcional.get();

        }catch (Exception error){
            throw new Exception(error.getMessage());
        }
    }


    public Boolean  eliminarEmpresa(Integer id) throws Exception
    {
       try {
           Optional<Compañia> empresaOpcional=this.empresaRepositorio.findById(id);
           if (empresaOpcional.isPresent()){
               this.empresaRepositorio.deleteById(id);
               return true;
           }else {
               throw new Exception("empresa no encontrada");
           }
       }catch (Exception error)
       {
           throw new Exception(error.getMessage());
       }
    }

}

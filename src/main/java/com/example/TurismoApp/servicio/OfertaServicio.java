package com.example.TurismoApp.servicio;
import com.example.TurismoApp.modelos.Oferta;
import com.example.TurismoApp.repositorio.RepositorioOferta;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Optional;

public class OfertaServicio {


    @Autowired
    RepositorioOferta repositorioOferta;


    public Oferta registrarOferta(Oferta datosARegistrar) throws Exception {
        try {

            //SI PASO TODOS LOS IF ESTOY LISTO PARA LLAMAR AL REPO
            return (this.repositorioOferta.save(datosARegistrar));

        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }

    }

    public Oferta modificarOferta(Integer id, Oferta datosAModificar) throws Exception {
        try {
            //validamos la informacion


            //Buscar que la oferta que tiene el id que envia el usuario exista en BD
            Optional<Oferta> ofertaEncontrada = this.repositorioOferta.findById(id);
            //pregunto si lo que busque esta vacio
            if (ofertaEncontrada.isEmpty()) {
                throw new Exception("Oferta no encontrada");
            }
            //rutina por si la encontre
            //1.convierto el opcional en la entidad respectiva
            Oferta ofertaQueExiste = ofertaEncontrada.get();
            //2. a la oferta que existe le cambio la informacion que el usuario necesita
            ofertaQueExiste.setTitulo(datosAModificar.getTitulo());


            //3. guardar la informaicon que se acaba de editar (SET)
           return(this.repositorioOferta.save(ofertaQueExiste));


        } catch (Exception error) {
            throw new Exception(error.getMessage());

        }
    }

        public Oferta buscarOfertaPorId(Integer id) throws Exception {
            try {
                Optional<Oferta> ofertaOptional = this.repositorioOferta.findById(id);
                if (ofertaOptional.isEmpty()) {
                    throw new Exception("Oferta no encontrada");
                }
                return ofertaOptional.get();

            } catch (Exception error) {
                throw new Exception(error.getMessage());
            }
        }

        public Boolean eliminarOferta(Integer id) throws Exception
        {
            try {
                Optional<Oferta> ofertaOptional = this.repositorioOferta.findById(id);
                if (ofertaOptional.isPresent()) {
                    this.repositorioOferta.deleteById(id);
                    return true;
                } else {
                    throw new Exception("empresa no encontrada");
                }
            } catch (Exception error) {
                throw new Exception(error.getMessage());
            }
        }

    }






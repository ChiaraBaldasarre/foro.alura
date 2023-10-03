package com.foro.alura.controller;

import com.foro.alura.dto.DatosListadoTopico;
import com.foro.alura.dto.DatosRegistroTopico;
import com.foro.alura.topico.DatosActualizarTopico;
import com.foro.alura.topico.Topico;
import com.foro.alura.topico.repository.TopicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/topicos")
public class TopicoController {

    @Autowired
    private TopicoRepository topicoRepository;

    @PostMapping
    public void registrarTopico(@RequestBody @Valid DatosRegistroTopico datosRegistroTopico){
        topicoRepository.save(new Topico(datosRegistroTopico));
    }

    @GetMapping
    public Page<DatosListadoTopico> listadoTopico(@PageableDefault Pageable paginacion){
        // return topicoRepository.findAll(paginacion).map(DatosListadoTopico::new);
        return topicoRepository.findByActivoTrue(paginacion).map(DatosListadoTopico::new);
    }

    /*
    @GetMapping("/{id}")
    @ResponseBody
    public Topico listadoTopicosId(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        return topico;
    }
    */

    @PutMapping
    @Transactional
    public void actualizarTopico(@RequestBody @Valid DatosActualizarTopico datosActualizarTopico){
        Topico topico = topicoRepository.getReferenceById(datosActualizarTopico.id());
        topico.actualizarDatos(datosActualizarTopico);
    }

    // Delete logico
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topico.desactivarTopico();
    }

    /*
    DELETE EN BASE DE DATOS
    @DeleteMapping("/{id}")
    @Transactional
    public void eliminarTopico(@PathVariable Long id){
        Topico topico = topicoRepository.getReferenceById(id);
        topicoRepository.delete(topico);
    }
    */
}

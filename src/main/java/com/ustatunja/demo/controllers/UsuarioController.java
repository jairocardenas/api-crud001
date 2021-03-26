package com.ustatunja.demo.controllers;

import com.ustatunja.demo.models.UsuarioModel;
import com.ustatunja.demo.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/api/usuario")
public class UsuarioController {
    @Autowired
    UsuarioService usuarioService;

    @GetMapping()
    public ArrayList<UsuarioModel> obtenerUsuario() {
        return usuarioService.ObtenerUsuario();
    }

    @PostMapping
    public UsuarioModel guardarUusuario(@Validated @RequestBody UsuarioModel usuario) {
        return this.usuarioService.guardarUsuario(usuario);
    }


    @GetMapping(path = "/{id}")
    public Optional<UsuarioModel> obtenerUsuarioPorId(@PathVariable("id") Long id) {
        return this.usuarioService.obtenerPorId(id);
    }

    @GetMapping(path = "/query")
    public ArrayList<UsuarioModel> obtenerUsuarioPorPrioridad(@RequestParam("prioridad") Integer prioridad) {
        return this.usuarioService.obtenerPorPriopridad(prioridad);
    }

    @DeleteMapping(path = "/{id}")
    public String eliminarPorId(@PathVariable("id") Long id) {
        boolean ok;
        ok = this.usuarioService.eliminarUusuario(id);
        if (ok) {
            return "Se elimino el usuario numero" + id;
        } else {
            return "No se pudo elimnar el id numero " + id;
        }
    }

}

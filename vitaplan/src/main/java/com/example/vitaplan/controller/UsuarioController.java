package com.example.vitaplan.controller;

import com.example.vitaplan.model.Usuario;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
public class UsuarioController {

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios() {

        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario(
                1L,
                "Juan",
                "Perez",
                "juan@gmail.com",
                "123456",
                "987654321"
        ));

        usuarios.add(new Usuario(
                2L,
                "Maria",
                "Gomez",
                "maria@gmail.com",
                "abcdef",
                "912345678"
        ));

        return usuarios;
    }

    @GetMapping("/usuarios/{id}")
    public Usuario buscarUsuario(@PathVariable Long id) {

        List<Usuario> usuarios = new ArrayList<>();

        usuarios.add(new Usuario(
                1L,
                "Juan",
                "Perez",
                "juan@gmail.com",
                "123456",
                "987654321"
        ));

        usuarios.add(new Usuario(
                2L,
                "Maria",
                "Gomez",
                "maria@gmail.com",
                "abcdef",
                "912345678"
        ));

        for (Usuario usuario : usuarios) {
            if (usuario.getId().equals(id)) {
                return usuario;
            }
        }

        return null;
    }
    @PostMapping("/usuarios")
    public Usuario crearUsuario(@RequestBody Usuario usuario) {
        return usuario;
    }
    @PutMapping("/usuarios/{id}")
    public Usuario actualizarUsuario(@PathVariable Long id, @RequestBody Usuario usuario) {
        usuario.setId(id);
        return usuario;
    }
    // ojo aca todavia no se esta eliminando nada ya que aun no se esta trabajando con base de datos
    @DeleteMapping("/usuarios/{id}")
    public String eliminarUsuario(@PathVariable Long id) {
        return "Usuario con ID " + id + " eliminado correctamente";
    }
    // falta probar todo esto en postman con el desktop agent
}
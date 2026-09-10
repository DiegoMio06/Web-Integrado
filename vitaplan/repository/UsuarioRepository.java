/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.example.vitaplan.repository;

import com.example.vitaplan.model.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<Usuario, Long> {
    
    // Método utilitario para buscar usuarios por su correo electrónico (útil para login o validaciones)
    Optional<Usuario> findByEmail(String email);
    
    // Verificar si un correo ya está registrado
    boolean existsByEmail(String email);
}
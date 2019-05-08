package br.com.senac.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

import br.com.senac.servico.UsuarioService;



@Controller
public class ControleUsuario {

	@Autowired
	private UsuarioService usuarioService;
}

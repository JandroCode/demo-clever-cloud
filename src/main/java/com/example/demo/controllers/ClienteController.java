package com.example.demo.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.models.dao.IClienteDAO;
import com.example.demo.models.entities.Cliente;

@Controller
public class ClienteController {
	
	@Autowired
	private IClienteDAO clienteDao;
	
	@GetMapping("/")
	private String home(Model model) {
		model.addAttribute("titulo", "home");
		return "home";
	}
	
	@GetMapping("/listado")
	public String listadoClientes(Model model) {
		model.addAttribute("titulo", "listado");
		model.addAttribute("clientes", clienteDao.findAll());
		return "listado";
	}
	
	@GetMapping("/form")
	public String crearCliente(Model model) {
		model.addAttribute("titulo", "agregar clientes");
		model.addAttribute("cliente", new Cliente());
		return "form";
	}
	
	@PostMapping("/form")
	public String guardarCliente(Cliente cliente) {
		clienteDao.save(cliente);
		return "redirect:/listado";
	}
	
	

}

package com.cayetano.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.cayetano.entity.Enlace;
import com.cayetano.entity.Usuario;
import com.cayetano.services.UsuarioServices;


@SessionAttributes({"datos","enlaces"})
@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	@Autowired
	private UsuarioServices servicio;
	
	@RequestMapping("/validar")
	public String index() {
		
		return "login";
	}
	
	@RequestMapping("/intranet")
	public String intranet(Authentication auth,Model model) {
		String nomLogin=auth.getName();
		Usuario bean=servicio.validarUsuario(nomLogin);
		List<Enlace> datos=servicio.enlacesDelUsuario(bean.getRol().getCodigo());
		model.addAttribute("enlaces",datos);
		model.addAttribute("datos",bean.getApellido()+" "+bean.getNombre());
		return "intranet";
	}
	
	
}

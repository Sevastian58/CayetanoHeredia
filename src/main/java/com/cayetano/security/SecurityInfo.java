package com.cayetano.security;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;


import com.cayetano.entity.Usuario;
import com.cayetano.services.UsuarioServices;



@Service
public class SecurityInfo implements UserDetailsService{
	@Autowired
	private UsuarioServices servicio;
		
	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		UserDetails obj=null;
		//invocar al método validarUsuario
		Usuario bean=servicio.validarUsuario(username);
		//rol del usuario
		Set<GrantedAuthority> rol=new HashSet<GrantedAuthority>();
		//adcionar rol
		rol.add(new SimpleGrantedAuthority(bean.getRol().getDescripcion()));
		//crear objeto obj
		obj=new User(username,bean.getClave(),rol);
		return obj;
	}

}






package com.javarevolutions.ws.rest.service;

import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import com.javarevolutions.ws.rest.vo.VOUsuario;

@Path("/JavaRevolutions")
public class ServiceLoginJR {
	
	@POST
	@Path("/validaUsuario")
	@Consumes({MediaType.APPLICATION_JSON})//ESPECIFICAMOS QUE ESTE MÉTODO VA A CONSUMIR JSON
	@Produces({MediaType.APPLICATION_JSON})//SE REFIERE A LO QUE VA A REGRESAR EL MÉTODO. POR LO TANTO VA A TRANSFORMAR AL OBJ "VO" EN JSON.
	//EN RESUMEN CON @CONSUMES Y @PRODUCES, VAMOS A RECIBIR JSON Y REGRESAREMOS JSON.
	public VOUsuario validaUsuario(VOUsuario vo) {
		vo.setUserValido(false);//SETEAMOS LA VALIDEZ DEL USUARIO
		if(vo.getUsuario().equals("Java")&& vo.getPassword().equals("Revolutions")) {
			vo.setUserValido(true);
		}
		vo.setPassword("#########");
		return vo;
	}
	
	
	

}

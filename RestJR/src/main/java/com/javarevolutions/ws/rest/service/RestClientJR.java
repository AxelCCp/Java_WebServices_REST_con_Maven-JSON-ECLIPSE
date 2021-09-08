package com.javarevolutions.ws.rest.service;

import com.javarevolutions.ws.rest.vo.VOUsuario;
import com.sun.jersey.api.client.Client;
import com.sun.jersey.api.client.ClientResponse;
import com.sun.jersey.api.client.WebResource;
import com.sun.jersey.api.client.config.ClientConfig;
import com.sun.jersey.api.client.config.DefaultClientConfig;
import com.sun.jersey.api.json.JSONConfiguration;

//CREAMOS CLIENTE REST

public class RestClientJR {
	
	public void main(String[]args) {
		String urlRestService = "http://localhost:8080/RestJR/restJR/JavaRevolutions/validaUsuario";
		System.out.println("####### invoke Rest Service: " + urlRestService);
		
		VOUsuario vo = new VOUsuario();
		vo.setUsuario("Dr.Gero");
		vo.setPassword("Gero");
		vo.setUserValido(false); //LE PONEMOS FALSE PARA QUE INICIALICE EN FALSE.
		
		//CON ESTE CÓDIGO SE PUEDE INVOCAR A CUALQUIER CLIENTE REST. HAY QUE CAMBIAR ESO SÍ LA URL DEL SERVICIO REST Y EL type("application/json"), POR SI ES QUE NO ES JSON.(PODRÍA SER XML)  
		//---------------------------------------------------------------------------------------------------------------------------
		ClientConfig clientConfig = new DefaultClientConfig();
		//OBTENEMOS LAS CARACTERÍSTICAS DEL OBJ clientConfig Y LE PONEMOS AS CONFIGURACIONES DE JSON
		clientConfig.getFeatures().put(JSONConfiguration.FEATURE_POJO_MAPPING,Boolean.TRUE);
		//CREAMOS OBJ DE TIPO CLIENT Y LE APLICAMOS LA CONFIGURACIÓN DEFINIDA.
		Client client = Client.create(clientConfig);
		//CREAMOS OBJ webResource Y LE DECIMOS DONDE ESTÁ LA URL DE NUESTRO SERVICIO REST.
		WebResource webResource = client.resource(urlRestService);
		//CREAMOS OBJ response PARA CACHEAR LA RESPUESTA DEL SERVICIO REST.  
		//Y CON EL OBJ webResource.type(), LE DECIMOS EL TIPO DE FORMATO QUE SE VA A INTERCAMBIAR.
		//Y SE OBTENDRÁ UN POST, EN EL (), 1RO SE PONE ClientResponse.class Y DESPUÉS LE MANDAMOS EL OBJ "vo".
		ClientResponse response = webResource.type("application/json").post(ClientResponse.class,vo);
		//DEFINIMOS EL OBJ QUE VAMOS A RECIBIR. UN OBJ DE TIPO VOUsuario. YLO ALMACENAMOS EN "vo"
		vo = response.getEntity(VOUsuario.class);
		System.out.println("####### Response: [Usuario: " + vo.getUsuario() + "]");
		System.out.println("####### Response: [User is valid: " + vo.isUserValido() + "]");
		//---------------------------------------------------------------------------------------------------------------------------
	
		
		
	}

}


package com.example.dondeeshoy;

import java.util.ArrayList;


public class Lugar {

	String Nombre;
	String listaEspectaculos; 
	String Descripcion;
	String Ubicacion;
	String Contacto;
	Double Latitud;
	Double Longitud;
	String Imagen; 
	int Id;
	
	public Lugar(String Nombre, String listaEspectaculos, String Descripcion,
	String Ubicacion, String Contacto, String Imagen, double Latitud, double Longitud, int id  ){
		this.Nombre = Nombre;
		this.listaEspectaculos = listaEspectaculos;
		this.Descripcion = Descripcion;
		this.Ubicacion = Ubicacion;
		this.Contacto = Contacto;
		this.Imagen = Imagen;	
		this.Latitud = Latitud;
		this.Longitud = Longitud;
		this.Id = id;
	}
	
}

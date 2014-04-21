package com.example.dondeeshoy;

import java.util.ArrayList;


public class Lugar {

	String Nombre;
	ArrayList <String>listaEspectaculos; 
	String Descripcion;
	String Ubicacion;
	String Contacto;
	int Imagen; 
	
	public Lugar(String Nombre, ArrayList <String>listaEspectaculos, String Descripcion,
	String Ubicacion, String Contacto, int Imagen ){
		this.Nombre = Nombre;
		this.listaEspectaculos = listaEspectaculos;
		this.Descripcion = Descripcion;
		this.Ubicacion = Ubicacion;
		this.Contacto = Contacto;
		this.Imagen = Imagen;		
	}
	
}

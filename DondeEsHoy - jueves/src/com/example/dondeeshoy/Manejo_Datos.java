package com.example.dondeeshoy;

import java.util.ArrayList;

public class Manejo_Datos {

	public ArrayList<Evento> mArray = new ArrayList<Evento>(); 
	public ArrayList<Evento> lista_final = new ArrayList<Evento>(); 
	public ArrayList<Integer> lista_eliminar = new ArrayList<Integer>(); 
	
	
	public void Buscar_Nombre(String Cadena, String fecha_a_Buscar, String tipo_a_Buscar){
		System.out.println("---------"+Cadena);
		int temp = mArray.size(); int temp2 = 0;
		while (temp > temp2) { 
			for (int number2 = 0; number2 < mArray.size(); number2++) { 		
				if (mArray.get(number2).mhorario.indexOf (Cadena) == -1 && 
					mArray.get(number2).mTitle.indexOf (Cadena) == -1 &&
					mArray.get(number2).medades.indexOf (fecha_a_Buscar) == -1 &&
					mArray.get(number2).mtipo.indexOf(tipo_a_Buscar) == -1)
				mArray.remove(number2);			
			}
			temp2 ++;
		}
	}
	
	
	public void setData(){
		this.mArray.clear();
		
		Evento nodo1 = new Evento(); 
		nodo1.mTitle = "Teatro Urbano";
		nodo1.mhorario = "Made in Tikicia";
		nodo1.medades = "10/03/2014";
		nodo1.mImageResource = R.drawable.urbano; 
		nodo1.mtipo = "Teatro";
		nodo1.mDescripcion = "Obra teatral ampliamente reconocido en la Capital de Costa Rica";
		nodo1.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		this.mArray.add(nodo1); 
		
		Evento nodo2 = new Evento(); 
		nodo2.mTitle = "Teatro Nacional";
		nodo2.mhorario = "FIA";
		nodo2.medades = "12/03/2014";
		nodo2.mImageResource = R.drawable.nacional; 
		nodo2.mtipo = "Teatro";
		nodo2.mDescripcion = "Festival Internaciona que se presenta en Costa Rica anualmente";
		nodo2.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		this.mArray.add(nodo2); 
		
		Evento nodo3 = new Evento(); 
		nodo3.mTitle = "Teatro Moliere";
		nodo3.mhorario = "Papichulo";
		nodo3.medades = "12/03/2014";
		nodo3.mImageResource = R.drawable.moliere; 
		nodo3.mtipo = "Teatro";
		nodo3.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		nodo3.mDescripcion = "La historia se basa en un ladrón que entra en una casa, pero encuentra una gran cantidad de problemas";
		mArray.add(nodo3); 
		
		Evento nodo4 = new Evento(); 
		nodo4.mTitle = "Teatro Variedades";
		nodo4.mhorario = "La Dama de negro";
		nodo4.medades = "12/03/2014";
		nodo4.mImageResource = R.drawable.variedades; 
		nodo4.mtipo = "Danza";
		nodo4.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		nodo4.mDescripcion = "Reiras y de asustaras, todo en la misma noche";
		mArray.add(nodo4); 
		
		Evento nodo5 = new Evento(); 
		nodo5.mTitle = "Teatro Arlequin";
		nodo5.mhorario = "Dos Arriba una Abajo";
		nodo5.medades = "12/03/2014";
		nodo5.mImageResource = R.drawable.arlequin; 
		nodo5.mtipo = "Danza";
		nodo5.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		nodo5.mDescripcion = "Obra teatral con más de 10 años en cartelera";
		mArray.add(nodo5); 
		
		Evento nodo6 = new Evento(); 
		nodo6.mTitle = "Teatro la Mascara";
		nodo6.mhorario = "Apartamento de Soltero";
		nodo6.medades = "12/03/2014";
		nodo6.mImageResource = R.drawable.mascara; 
		nodo6.mtipo = "Teatro";
		nodo6.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		nodo6.mDescripcion = "Nueva obra de teatro acerca de la infidelidad en la sociedad actual";
		mArray.add(nodo6); 
		
		Evento nodo7 = new Evento(); 
		nodo7.mTitle = "Teatro Metropolitano";
		nodo7.mhorario = "Ojos que no ven";
		nodo7.medades = "12/03/2014";
		nodo7.mImageResource = R.drawable.metropolitano; 
		nodo7.mtipo = "Teatro";
		nodo7.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		nodo7.mDescripcion = "Super comedia apta para todo público";
		mArray.add(nodo7); 
	}
}

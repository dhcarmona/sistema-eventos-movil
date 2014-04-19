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
		
		ArrayList <String>listaEspectaculos = new ArrayList<String>(); 
		listaEspectaculos.add("Una vida loca"); listaEspectaculos.add("La otra cara del matrimonio"); 
		
		Lugar place1 = new Lugar("Teatro Urbano", listaEspectaculos, 
				"Teatro reconocido por sus producciones nacionales", "San José", 
				"2279-5857 / fakemail@fake.com",  R.drawable.urbano);
		Lugar place2 = new Lugar("Teatro Variedades", listaEspectaculos, 
				"Teatro reconocido por sus producciones a lo largo de su historia", "San José", 
				"2279-5857 / fakemail@fake.com",  R.drawable.variedades);
		Lugar place3 = new Lugar("Teatro Nacional", listaEspectaculos, 
				"Teatro con amplio valor historico ", "San José", 
				"2279-5857 / fakemail@fake.com",  R.drawable.nacional);
		Lugar place4 = new Lugar("Teatro Arlequin", listaEspectaculos, 
				"Teatro con amplio repertorio teatral ", "San José", 
				"2279-5857 / fakemail@fake.com",  R.drawable.arleq);
		Lugar place5 = new Lugar("Teatro Moliere", listaEspectaculos, 
				"Teatro con amplio valor historico ", "San José", 
				"2279-5857 / fakemail@fake.com",  R.drawable.molieree);
		Lugar place6 = new Lugar("Teatro La Mascara", listaEspectaculos, 
				"A cargo de un gran elenco reconocido en CentroAmerica ", "San José", 
				"2279-5857 / fakemail@fake.com",  R.drawable.mascara);
		Lugar place7 = new Lugar("Teatro Metropolitano", listaEspectaculos, 
				"Teatro con un año de existencia en la capita de CR. ", "San José", 
				"2279-5857 / fakemail@fake.com",  R.drawable.metro);
		

	
		
		Evento nodo1 = new Evento(); 
		nodo1.mTitle = "Made in Tikicia";
		nodo1.mhorario = "8:00 pm";
		nodo1.medades = "10/03/2014";
		nodo1.mImageResource = R.drawable.made; 
		nodo1.mtipo = "Teatro";
		nodo1.mDescripcion = "Obra teatral ampliamente reconocido en la Capital de Costa Rica";
		nodo1.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		nodo1.mWebsite = "https://www.facebook.com/TeatroUrbano";
		nodo1.Lugar = place1;
		this.mArray.add(nodo1); 
		
		Evento nodo2 = new Evento(); 
		nodo2.mTitle = "FIA";
		nodo2.mhorario = "8:00 pm";
		nodo2.medades = "12/03/2014";
		nodo2.mImageResource = R.drawable.fia; 
		nodo2.mtipo = "Teatro";
		nodo2.mDescripcion = "Festival Internaciona que se presenta en Costa Rica anualmente";
		nodo2.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		nodo2.mWebsite = "https://www.facebook.com/TeatroNacionalCostaRica";
		nodo2.Lugar = place3;
		this.mArray.add(nodo2); 
		
		Evento nodo3 = new Evento(); 
		nodo3.mTitle = "Papichulo";
		nodo3.mhorario = "8:00 pm";
		nodo3.medades = "12/03/2014";
		nodo3.mImageResource = R.drawable.moliere; 
		nodo3.mtipo = "Teatro";
		nodo3.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		nodo3.mWebsite = "https://www.facebook.com/teatro.costarica";
		nodo3.Lugar = place5;
		nodo3.mDescripcion = "La historia se basa en un ladrón que entra en una casa, pero encuentra una gran cantidad de problemas";
		mArray.add(nodo3); 
		
		Evento nodo4 = new Evento(); 
		nodo4.mTitle = "La Dama de Negro";
		nodo4.mhorario = "8:00 pm";
		nodo4.medades = "12/03/2014";
		nodo4.mImageResource = R.drawable.negro; 
		nodo4.mtipo = "Danza";
		nodo4.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		nodo4.mWebsite = "https://www.facebook.com/TeatroVariedades";
		nodo4.Lugar = place2;
		nodo4.mDescripcion = "Reiras y de asustaras, todo en la misma noche";
		mArray.add(nodo4); 
		
		Evento nodo5 = new Evento(); 
		nodo5.mTitle = "Dos Arriba una Abajo";
		nodo5.mhorario = "8:00 pm";
		nodo5.medades = "12/03/2014";
		nodo5.mImageResource = R.drawable.arlequin; 
		nodo5.mtipo = "Danza";
		nodo5.Lugar = place4;
		nodo5.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		nodo5.mWebsite = "https://www.facebook.com/teatroarlequincr";
		nodo5.mDescripcion = "Obra teatral con más de 10 años en cartelera";
		mArray.add(nodo5); 
		
		Evento nodo6 = new Evento(); 
		nodo6.mTitle = "Apartamento de Soltero";
		nodo6.mhorario = "8:00 pm";
		nodo6.medades = "12/03/2014";
		nodo6.mImageResource = R.drawable.soltero; 
		nodo6.mtipo = "Teatro";
		nodo6.Lugar = place6;
		nodo6.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		nodo6.mWebsite = "https://www.facebook.com/teatrolamascara.sa";
		nodo6.mDescripcion = "Nueva obra de teatro acerca de la infidelidad en la sociedad actual";
		mArray.add(nodo6); 
		
		Evento nodo7 = new Evento(); 
		nodo7.mTitle = "Ojos que no ven";
		nodo7.mhorario = "7:00 pm";
		nodo7.medades = "12/03/2014";
		nodo7.mImageResource = R.drawable.metropolitano; 
		nodo7.mtipo = "Teatro";
		nodo7.Lugar = place7;
		nodo7.mWebsite = "https://www.facebook.com/teatro.metropolitano";
		nodo7.mContacto = "22796363 / 88368603 / suteatropreferido@siempre.com";
		nodo7.mDescripcion = "Super comedia apta para todo público";
		mArray.add(nodo7); 
	}
}

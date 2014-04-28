package com.example.dondeeshoy;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.URI;
import java.util.ArrayList;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.ResponseHandler;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.BasicResponseHandler;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONArray;
import org.json.JSONObject;

public class Manejo_Datos {

	public ArrayList<Evento> mArray = new ArrayList<Evento>(); 
	public ArrayList<Evento> lista_final = new ArrayList<Evento>(); 
	public ArrayList<Integer> lista_eliminar = new ArrayList<Integer>(); 
	public ArrayList<Lugar> lista_lugares = new ArrayList<Lugar>();
	public ArrayList<Integer> id_eventos = new ArrayList<Integer>(); 
	public ArrayList<Evento> lista_eventos = new ArrayList<Evento>(); 
	
	
	
	public void Buscar_Nombre(String Cadena, String fecha_a_Buscar, String tipo_a_Buscar, String gps1, String gps2){
		System.out.println("---------"+Cadena);
		int temp = mArray.size(); int temp2 = 0;
		double Latitud = Double.parseDouble(gps1); 
		double Longitud = Double.parseDouble(gps2);
		
		while (temp > temp2) { 
			for (int number2 = 0; number2 < mArray.size(); number2++) { 
				double Latitud_com = mArray.get(number2).Lugar.Longitud;
				double Longitud_com = mArray.get(number2).Lugar.Latitud;
				double Dif_latitud = Math.abs(Latitud_com - Latitud);
				double Dif_longitud = Math.abs(Longitud_com - Longitud);
				System.out.println("Latitud_com"+Latitud_com);
				System.out.println("Latitud"+Latitud);
				System.out.println("LATITUD"+Dif_latitud);
				System.out.println("Longitud_com"+Latitud_com);
				System.out.println("Longitud"+Latitud);
				System.out.println("LONGITUD"+Dif_longitud);
				boolean GPS;
				if((Dif_latitud + Dif_longitud) < 0.5 ) GPS = false;
				else GPS = true;
				
				if (mArray.get(number2).mhorario.indexOf (Cadena) == -1 && 
					mArray.get(number2).mTitle.indexOf (Cadena) == -1 &&
					mArray.get(number2).medades.indexOf (fecha_a_Buscar) == -1 &&
					mArray.get(number2).mtipo.indexOf(tipo_a_Buscar) == -1 &&
					GPS
						)
				mArray.remove(number2);	
				
			}
			temp2 ++;
		}
	}
	
	private void Establecimientos()
	{
		 new Thread(new Runnable() {
	
			    InputStream is;
			    String result = "";
			    
			    public void run() {
			    	HttpGet httpRequest = new HttpGet( "http://semcr.no-ip.biz/establecimientos.json?appkey=1405ee0b5234c53980d46d493ae2a0cb");				
					HttpClient httpclient = new DefaultHttpClient();					
					HttpResponse response;
					try {
						response = httpclient.execute(httpRequest);
						HttpEntity entity = response.getEntity();
				    	is = entity.getContent();
				    	try{
					         BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
					         StringBuilder sb = new StringBuilder();
					         String line = null;
					         while ((line = reader.readLine()) != null) {
					             sb.append(line + "\n");
					         }
					         is.close();
					         result=sb.toString();					     
					         
					         //Aqui se empieza a desglosar el string Json en los objetos respectivos
					         
					         JSONArray jsonArray = new JSONArray(result);
					         for (int i = 0; i < jsonArray.length(); i++) {
					        	 System.out.println("elemento =" + i);
					             JSONObject jsonObject = jsonArray.getJSONObject(i);
					             
					             //Lista Espectaculos
					          
					             String Lista_Espectaculos = "";
					             
						         String json_tipo = jsonObject.getString("eventos");
						         JSONArray tipos = new JSONArray(json_tipo);
						         for (int y = 0; y < tipos.length(); y++){
							         JSONObject tipo = tipos.getJSONObject(y);				         
							         Lista_Espectaculos = Lista_Espectaculos + "  -  " + tipo.getString("nombre");
							      }
	
					             // Preparacion de URL de la imagen
					             
					             String urlImagen = "http://semcr.no-ip.biz" + jsonObject.getString("imagen");					             					             
					            
					             
					             Lugar Establecimiento = new Lugar(
					            		 jsonObject.getString("nombre_establecimiento"),
					            		 Lista_Espectaculos,
					            		 jsonObject.getString("descripcion"),
					            		 jsonObject.getString("direccion"),
					            		 "22796350 - fakemail@gmail.com",
					            		 urlImagen,
					            		 jsonObject.getDouble("longitud"),
					            		 jsonObject.getDouble("latitud"),
					            		 jsonObject.getInt("id")
					            		 );
					         
						         lista_lugares.add(Establecimiento);
						         Lista_Espectaculos = "";
						         urlImagen  = "";
					         }
					         //setData2();
					         
					     } catch(Exception e){System.out.println("------->Error de conexión con Json al pasar a String");}				    	
						} 
					catch (ClientProtocolException e) {
							e.printStackTrace();
							 System.out.println("------->Error de conexión con Json");
						} 
					catch (IOException e) {
							e.printStackTrace();
							 System.out.println("------->Error de conexión con Json");
						}					
					
			    }
			  }).start();
	}
	
	private void Id_Eventos()
	{
		 new Thread(new Runnable() {
	
			    InputStream is;
			    String result = "";
						    
			    public void run() {
			    	HttpGet httpRequest = new HttpGet( "http://semcr.no-ip.biz/eventos.json?appkey=1405ee0b5234c53980d46d493ae2a0cb");				
					HttpClient httpclient = new DefaultHttpClient();					
					HttpResponse response;
					try {
						response = httpclient.execute(httpRequest);
						HttpEntity entity = response.getEntity();
				    	is = entity.getContent();
				    	try{
					         BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
					         StringBuilder sb = new StringBuilder();
					         String line = null;
					         while ((line = reader.readLine()) != null) {
					             sb.append(line + "\n");
					         }
					         is.close();
					         result=sb.toString();					     
					         
					         //Aqui se empieza a desglosar el string Json en los objetos respectivos
					         
					         JSONArray jsonArray = new JSONArray(result);
					         for (int i = 0; i < jsonArray.length(); i++) {
					        	 
					             JSONObject jsonObject = jsonArray.getJSONObject(i);
					           
					             // Se obtienen los id de los eventos a analizar
					             
					             id_eventos.add(jsonObject.getInt("id"));					           					       
						         System.out.println("El id del evento es = " + jsonObject.getInt("id"));
					         }
					         ;
					         
					     } catch(Exception e){System.out.println("------->Error de conexión con Json al pasar a String");}				    	
						} 
					catch (ClientProtocolException e) {
							e.printStackTrace();
							 System.out.println("------->Error de conexión con Json");
						} 
					catch (IOException e) {
							e.printStackTrace();
							 System.out.println("------->Error de conexión con Json");
						}					
					
			    }
			  }).start();
	}
	
	private void Eventos(){
		new Thread(new Runnable() {
			
		    InputStream is;
		    String result = "";
					    
		    public void run() {
		    	  System.out.println("ENTROOOOOOOOOOO");
		    	for (int contador = 0; contador < id_eventos.size(); contador++){
		    	String URL = "http://semcr.no-ip.biz/eventos/" + id_eventos.get(contador) +  ".json?appkey=1405ee0b5234c53980d46d493ae2a0cb";
		    	HttpGet httpRequest = new HttpGet(URL);				
				HttpClient httpclient = new DefaultHttpClient();					
				HttpResponse response;
				try {
					response = httpclient.execute(httpRequest);
					HttpEntity entity = response.getEntity();
			    	is = entity.getContent();
			    	try{
				         BufferedReader reader = new BufferedReader(new InputStreamReader(is,"iso-8859-1"),8);
				         StringBuilder sb = new StringBuilder();
				         String line = null;
				         while ((line = reader.readLine()) != null) {
				             sb.append(line + "\n");
				         }
				         is.close();
				         result=sb.toString();					     
				         
				         //Aqui se empieza a desglosar el string Json en los objetos respectivos
				         
				         System.out.println(result);
				         JSONArray jsonArray = new JSONArray("["+result+"]");	
                         JSONObject jsonObject = jsonArray.getJSONObject(0);
				         String Fecha = jsonObject.getString("horario");
				         Fecha = Fecha.substring(0, 10);
				         String Hora = jsonObject.getString("horario");
				         Hora = Hora.substring(12, 16);
				         System.out.println("UNOOOOOOOO");
				         
				         // Imagen 
				         
				         String json_imagen = jsonObject.getString("imagenes");
				         JSONArray imagenes = new JSONArray(json_imagen);
				         JSONObject imagen = imagenes.getJSONObject(0);				         
				         String url_imagen = "http://semcr.no-ip.biz" + imagen.getString("url");
				         System.out.println("DOSSSSSSS");
				         
				         // Tipo
				         
				         String json_tipo = jsonObject.getString("tipos");
				         JSONArray tipos = new JSONArray(json_tipo);
				         JSONObject tipo = tipos.getJSONObject(0);				         
				         String nombre_tipo = tipo.getString("nombre"); 
				         System.out.println("TRESSSSSSSSS");
				         //Establecimiento
				         
				         Evento Espectaculo = new Evento();
				         int id_establecimiento = jsonObject.getInt("establecimiento_id");				         
				         for (int cont = 0; cont < lista_lugares.size(); cont++) {
				        	 if(lista_lugares.get(cont).Id == id_establecimiento){
				        		 Espectaculo.Lugar = lista_lugares.get(cont); 
				        	 }
				         }
				         System.out.println("CUATROOOOOO");
				         
				             // Se obtienen los id de los eventos a analizar
                             
                             Espectaculo.mTitle = jsonObject.getString("nombre");
                             Espectaculo.mDescripcion = jsonObject.getString("descripcion");
                             Espectaculo.mhorario ="Horario : " + Hora;
                             Espectaculo.mContacto = "22796350 - fakemail@gmail.com";
                             Espectaculo.medades = Fecha;
                             Espectaculo.mtipo = "Teatro";
                             Espectaculo.mWebsite = "http://semcr.no-ip.biz/";
                             Espectaculo.mImageResource = url_imagen;
				                   
                             mArray.add(Espectaculo);
                             System.out.println("CINCOOOOOOO");
				         ;
				         
				     } catch(Exception e){System.out.println("------->Error de conexión con Json al pasar a String");}				    	
					} 
				catch (ClientProtocolException e) {
						e.printStackTrace();
						 System.out.println("------->Error de conexión con Json");
					} 
				catch (IOException e) {
						e.printStackTrace();
						 System.out.println("------->Error de conexión con Json");
					}					
		    	}
		    }
		  }).start();
		
	}
	
	public void setData(){
		this.mArray.clear();
		Establecimientos();	
		 try {
				Thread.sleep(2000);
			} catch (InterruptedException e) {

				e.printStackTrace();
			}
	    Id_Eventos();
	    try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
	    Eventos();
		
	}
}

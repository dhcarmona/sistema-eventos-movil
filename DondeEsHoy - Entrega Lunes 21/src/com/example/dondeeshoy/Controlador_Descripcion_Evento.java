package com.example.dondeeshoy;


import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class Controlador_Descripcion_Evento extends Fragment {

		TextView titulo;
		TextView horarios;
		TextView descripcion; 
		ImageView imagen; 
		Controlador_Log_in log_in;
		public ImageView imageView;
	    public Bitmap loadedImage;
		
		public Controlador_Descripcion_Evento(Controlador_Log_in log_in) {
			// TODO Auto-generated constructor stub
			this.log_in = log_in;
		}

		@Override
		
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
			//setContentView(R.layout.descripcion_evento);
			
			 View v = inflater.inflate(R.layout.descripcion_evento, container, false);
			
		     Bundle args2 = new Bundle();
		    // ListView lista = (ListView) v.findViewById(R.id.lista_eventos);
		     
		     titulo = (TextView) v.findViewById(R.id.titulo); 
		     horarios = (TextView) v.findViewById(R.id.horarios); 
		     descripcion = (TextView) v.findViewById(R.id.descripcion);
		     imagen = (ImageView) v.findViewById(R.id.imagen);
		     
		     titulo.setText(getArguments().getString("titulo"));
		     horarios.setText(getArguments().getString("horarios"));
		     descripcion.setText(getArguments().getString("descripcion"));
		     carga_Imagen();
		     
		     final Button button = (Button) v.findViewById(R.id.contacto);
	         button.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Context context = getActivity();
	            	 CharSequence text = getArguments().getString("contacto");
	            	 Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
	            	 toast.show();
	             }
	         });
	         

		     final Button compartir = (Button) v.findViewById(R.id.compartir);
		     compartir.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 log_in.publishStory(getArguments().getString("titulo"),
	            			 			getArguments().getString("titulo"),
	            			 			getArguments().getString("descripcion"),
	            			 			getArguments().getString("website"));
	            	 Toast toast = Toast.makeText(getActivity(), "Evento Compartido en tu Muro", Toast.LENGTH_LONG);
	            	 toast.show();
	             }
	         });
	         
		     final Button ubicacion = (Button) v.findViewById(R.id.ubicacion);
		     ubicacion.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	// Aqui va para cargar la pagina 
	            	 
	            	Controlador_Establecimiento fragment = new Controlador_Establecimiento(log_in);
	      	        Bundle argumentos = new Bundle();
	      	        argumentos.putString("estable_nombre", getArguments().getString("estable_nombre"));
		            argumentos.putString("estable_descripcion", getArguments().getString("estable_descripcion"));
		            argumentos.putString("estable_contacto", getArguments().getString("estable_contacto"));
		            argumentos.putString("estable_ubicacion", getArguments().getString("estable_ubicacion"));
		            argumentos.putString("estable_imagen", getArguments().getString("estable_imagen"));   
		            argumentos.putString("estable_espectaculos", getArguments().getString("estable_espectaculos")); 
		            argumentos.putDouble("estable_latitud",  getArguments().getDouble("estable_latitud"));
		            argumentos.putDouble("estable_longitud",  getArguments().getDouble("estable_longitud"));
		            		                  			                  			            
		            fragment.setArguments(argumentos);
		            getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
	             }
	         });
		     
	                  
		  	 return v;
			
		}
		
		public void carga_Imagen() {
			
			 new Thread (new Runnable() {
				 URL imageUrl = null;
			     HttpURLConnection conn = null;
			     
			     public void run() {
			     try {
			    	 imageUrl = new URL(getArguments().getString("imagen"));
			    	 System.out.println("uno");
			         HttpURLConnection conn = (HttpURLConnection) imageUrl.openConnection();
			         System.out.println("dos");
			         conn.connect();
			         System.out.println("tres");
			         loadedImage = BitmapFactory.decodeStream(conn.getInputStream());
			         System.out.println("cuatro");			        
			     
			     
			     } catch (IOException e) {
			     
			     e.printStackTrace();
			     
			     }
		     } 
			 }).start();
			 try {
					Thread.sleep(1000);
					System.out.println("y el programa durmio 1 segundos");
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			imagen.setImageBitmap(loadedImage);
			System.out.println("seis");
			//return loadedImage;
		}
		
	
}

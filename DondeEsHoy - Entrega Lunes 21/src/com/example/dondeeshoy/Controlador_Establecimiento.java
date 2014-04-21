package com.example.dondeeshoy;


import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Rect;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

@SuppressLint("ValidFragment")
public class Controlador_Establecimiento extends Fragment {

		TextView titulo;
		TextView espectaculos;
		TextView descripcion; 
		ImageView imagen; 
		Controlador_Log_in log_in;
		public ImageView imageView;
	    public Bitmap loadedImage;
		
		public Controlador_Establecimiento(Controlador_Log_in log_in) {
			// TODO Auto-generated constructor stub
			this.log_in = log_in;
		}

		@Override
		
		public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){
			//setContentView(R.layout.descripcion_evento);
			
			 View v = inflater.inflate(R.layout.lugar, container, false);
			
		     Bundle args2 = new Bundle();
		     
		     titulo = (TextView) v.findViewById(R.id.nombre); 
		     espectaculos = (TextView) v.findViewById(R.id.espectaculos); 
		     descripcion = (TextView) v.findViewById(R.id.descripcion);
		     imagen = (ImageView) v.findViewById(R.id.imagen);
		     
		     titulo.setText(getArguments().getString("estable_nombre"));
		     espectaculos.setText(getArguments().getString("estable_espectaculos"));
		     descripcion.setText(getArguments().getString("estable_descripcion"));
			     
		     carga_Imagen();
		     
		     final Button button = (Button) v.findViewById(R.id.cont);
	         button.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 Context context = getActivity();
	            	 CharSequence text = getArguments().getString("estable_contacto");
	            	 Toast toast = Toast.makeText(context, text, Toast.LENGTH_LONG);
	            	 toast.show();
	             }
	         });
	         

		     final Button compartir = (Button) v.findViewById(R.id.comp);
		     compartir.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	 log_in.publishStory(getArguments().getString("estable_nombre"),
	            			 			getArguments().getString("estable_nombre"),
	            			 			getArguments().getString("estable_descripcion"),
	            			 			"http://www.mcj.go.cr/");
	            	 Toast toast = Toast.makeText(getActivity(), "Evento Compartido en tu Muro", Toast.LENGTH_LONG);
	            	 toast.show();
	             }
	         });
	         
		     final Button ubicacion = (Button) v.findViewById(R.id.ubic);
		     ubicacion.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	Double Latitud = getArguments().getDouble("estable_latitud"); 
	            	Double Longitud = getArguments().getDouble("estable_longitud");
	            	String ubicacion = getArguments().getString("estable_ubicacion") + " (" +  Latitud + " - " + Longitud + " ) ";
	            	Toast toast = Toast.makeText(getActivity(), ubicacion, Toast.LENGTH_LONG);
	            	 toast.show();
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
			         System.out.println("Entro----" + getArguments().getString("estable_imagen"));
			    	 imageUrl = new URL(getArguments().getString("estable_imagen"));
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
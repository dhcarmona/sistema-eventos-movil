package com.example.dondeeshoy;


import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
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
public class Controlador_Establecimiento extends Fragment {

		TextView titulo;
		TextView espectaculos;
		TextView descripcion; 
		ImageView imagen; 
		Controlador_Log_in log_in;
		
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
	//	     espectaculos.setText(getArguments().getString("titulo"));
		     descripcion.setText(getArguments().getString("estable_descripcion"));
		     imagen.setImageDrawable(getResources().getDrawable(getArguments().getInt("estable_imagen")));
		     
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
	            	// Aqui va para cargar la pagina 
	            	 
	             }
	         });
		     
	                  
		  	 return v;
			
		}
		
	
}
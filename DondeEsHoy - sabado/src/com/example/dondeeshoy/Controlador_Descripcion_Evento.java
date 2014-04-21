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
public class Controlador_Descripcion_Evento extends Fragment {

		TextView titulo;
		TextView horarios;
		TextView descripcion; 
		ImageView imagen; 
		Controlador_Log_in log_in;
		
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
		     horarios.setText(getArguments().getString("titulo"));
		     descripcion.setText(getArguments().getString("descripcion"));
		     imagen.setImageDrawable(getResources().getDrawable(getArguments().getInt("imagen")));
		     
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
		            argumentos.putInt("estable_imagen", getArguments().getInt("estable_imagen"));       	
		            		                  			                  			            
		            fragment.setArguments(argumentos);
		            getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
	             }
	         });
		     
	                  
		  	 return v;
			
		}
		
	
}

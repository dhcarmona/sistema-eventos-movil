package com.example.dondeeshoy;


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

public class Controlador_Descripcion_Evento extends Fragment {

		TextView titulo;
		TextView horarios;
		TextView descripcion; 
		ImageView imagen; 
		
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
	         
	                  
		  	 return v;
			
		}
		
	
}

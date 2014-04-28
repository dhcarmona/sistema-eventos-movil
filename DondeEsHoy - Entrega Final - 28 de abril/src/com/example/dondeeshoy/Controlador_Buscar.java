package com.example.dondeeshoy;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;


@SuppressLint("ValidFragment")
public class Controlador_Buscar extends Fragment {
	
	public ArrayList<Evento> mArray = new ArrayList<Evento>(); 
	EditText edit_text ;
	EditText edit_text_fecha ;
	EditText edit_text_tipo;
	EditText edit_text_gps1;
	EditText edit_text_gps2;
	Controlador_Log_in log_in;
	 
	public Controlador_Buscar(ArrayList<Evento> mArray, Controlador_Log_in log_in) {
		// TODO Auto-generated constructor stub
		 this.mArray = mArray;
		 this.log_in = log_in;
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState ) {
	 
	 
	        View v = inflater.inflate(R.layout.buscar, container, false);
	        this.edit_text = (EditText) v.findViewById(R.id.editText1);
	        this.edit_text_fecha = (EditText) v.findViewById(R.id.editText2);
	        this.edit_text_tipo = (EditText) v.findViewById(R.id.editText3);
	        this.edit_text_gps1 = (EditText) v.findViewById(R.id.editText4);
	        this.edit_text_gps2 = (EditText) v.findViewById(R.id.EditText5);

	        
	        final Button button = (Button) v.findViewById(R.id.busca);
	        button.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	
	            	 String value = null; String value_fecha = null; String value_tipo = null; String value_gps1= null; String value_gps2= null;
	            	 value = edit_text.getText().toString();
	            	 if(value.equals("")){
	            		 value = "cadenavacia";
	            	 }
	            	 value_fecha = edit_text_fecha.getText().toString(); 
	            	 if(value_fecha.equals("")){
	            		 value_fecha = "cadenavacia";
	            	 }
	            	 value_tipo = edit_text_tipo.getText().toString();
	            	 if(value_tipo.equals("")){
	            		 value_tipo = "cadenavacia";
	            	 }
	            	 value_gps1 = edit_text_gps1.getText().toString();
	            	 if(value_gps1.equals("")){
	            		 value_gps1 = "0.0";
	            	 }
	            	 value_gps2 = edit_text_gps2.getText().toString();
	            	 if(value_gps2.equals("")){
	            		 value_gps2 = "0.0";
	            	 }
	            	 Controlador_Evento_Buscar fragment = new Controlador_Evento_Buscar(value,value_fecha, value_tipo, log_in, value_gps2, value_gps1); 
	                 Bundle args = new Bundle();
	                 fragment.setArguments(args);
	                 getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
	                 
	             }
	        });
	        
	        final Button localizador = (Button) v.findViewById(R.id.gps);
	        localizador.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            		            			 
	            	 LocationManager lm = (LocationManager)getActivity().getSystemService(Context.LOCATION_SERVICE);
	            	 Location location = lm.getLastKnownLocation(LocationManager.GPS_PROVIDER);
	            	 double longitude = location.getLongitude();
	            	 double latitude = location.getLatitude();
	                 edit_text_gps1.setText(longitude + "");
	                 edit_text_gps2.setText(latitude + "");
	             }
	        });
	         
			return v;
	        
	 }
}
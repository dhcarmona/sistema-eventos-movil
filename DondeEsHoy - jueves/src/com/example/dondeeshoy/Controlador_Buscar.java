package com.example.dondeeshoy;

import java.util.ArrayList;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import com.google.android.gms.maps.MapFragment;


@SuppressLint("ValidFragment")
public class Controlador_Buscar extends Fragment {
	
	public ArrayList<Evento> mArray = new ArrayList<Evento>(); 
	EditText edit_text ;
	EditText edit_text_fecha ;
	EditText edit_text_tipo;
	 
	public Controlador_Buscar(ArrayList<Evento> mArray) {
		// TODO Auto-generated constructor stub
		 this.mArray = mArray; 
	}

	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState ) {
	 
	 
	        View v = inflater.inflate(R.layout.buscar, container, false);
	        this.edit_text = (EditText) v.findViewById(R.id.editText1);
	        this.edit_text_fecha = (EditText) v.findViewById(R.id.editText2);
	        this.edit_text_tipo = (EditText) v.findViewById(R.id.editText3);
	        
	      /*  Fragment videoFragment = new Controlador_Mapa();
	        FragmentTransaction transaction = getChildFragmentManager().beginTransaction();
	        transaction.add(R.layout.mapa, videoFragment).commit();
	        Bundle args2 = new Bundle();*/
	        
	        final Button button = (Button) v.findViewById(R.id.busca);
	        button.setOnClickListener(new View.OnClickListener() {
	             public void onClick(View v) {
	            	
	            	 String value = null; String value_fecha = null; String value_tipo = null;
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
	            	 
	            	 Controlador_Evento_Buscar fragment = new Controlador_Evento_Buscar(value,value_fecha, value_tipo); 
	                 Bundle args = new Bundle();
	                 fragment.setArguments(args);
	                 getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
	                 
	             }
	        });
	         
			return v;
	        
	 }
}
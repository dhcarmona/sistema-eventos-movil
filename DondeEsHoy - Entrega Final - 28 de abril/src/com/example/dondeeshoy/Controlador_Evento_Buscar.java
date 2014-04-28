package com.example.dondeeshoy;

import java.util.ArrayList;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
 
@SuppressLint("ValidFragment")
public class Controlador_Evento_Buscar extends Fragment {
 
    public final static String KEY_TEXT = "key_text";
 
    private String mText;
    private CharSequence mTitle;
    public ArrayList<Evento> mArray = new ArrayList<Evento>(); 
    public Manejo_Datos Datos;
	public String Nombre_a_Buscar;
	public String Fecha_a_Buscar;
	public String Tipo_a_Buscar;
	public Controlador_Log_in log_in;
	public String Gps1;
	public String Gps2;
	
	
	
    public Controlador_Evento_Buscar(String string, String value_fecha, String value_tipo, Controlador_Log_in log_in, String value_gps1, String value_gps2) {
		// TODO Auto-generated constructor stub
    	this.Nombre_a_Buscar = string;
    	this.Fecha_a_Buscar = value_fecha; 
    	this.Tipo_a_Buscar = value_tipo;
    	this.log_in = log_in;
    	this.Gps1 = value_gps1;
    	this.Gps2 = value_gps2;
	}

	@Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
 
        mText = getArguments().getString(KEY_TEXT);
 
        View v = inflater.inflate(R.layout.lista_evento, container, false);
        Bundle args2 = new Bundle();
        ListView lista = (ListView) v.findViewById(R.id.lista_eventos);
        
        // Creo el adapter personalizado
        this.Datos = new Manejo_Datos();
        this.Datos.setData();
        try {
			Thread.sleep(7000);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
        this.Datos.Buscar_Nombre(this.Nombre_a_Buscar, this.Fecha_a_Buscar, this.Tipo_a_Buscar, this.Gps1, this.Gps2);
        this.mArray = this.Datos.mArray;
        Adaptador_Evento adapter = new Adaptador_Evento(this, this.Datos.mArray);
        lista.setAdapter(adapter);
        
        
        //Se establece el listener para los eventos del click a la lista 
        lista.setOnItemClickListener(new android.widget.AdapterView.OnItemClickListener() {
        	@Override
        	public void onItemClick(AdapterView<?> parent, View view,int position, long id) {
        		
        			Evento nodox = new Evento();
        			Bundle argumentos = new Bundle();
        			       			
        			for (int number = 0; number < mArray.size(); number++) { 			    
        			        if(number == position) {
        			        	nodox = mArray.get(number);
        			        	argumentos.putString("titulo", nodox.mTitle);
        			        	argumentos.putString("horarios", nodox.mhorario);
        			        	argumentos.putString("descripcion", nodox.mDescripcion);
        			        	argumentos.putString("imagen", nodox.mImageResource);
        			        	argumentos.putString("contacto", nodox.mContacto);
        			        	argumentos.putString("website", nodox.mWebsite);
        			        	
        			            argumentos.putString("estable_nombre", nodox.Lugar.Nombre);
        			            argumentos.putString("estable_descripcion", nodox.Lugar.Descripcion);
        			            argumentos.putString("estable_contacto", nodox.Lugar.Contacto);
        			            argumentos.putString("estable_ubicacion", nodox.Lugar.Ubicacion);
        			            argumentos.putString("estable_imagen", nodox.Lugar.Imagen);
        			            argumentos.putString("estable_espectaculos", nodox.Lugar.listaEspectaculos);
        			            argumentos.putDouble("estable_latitud", nodox.Lugar.Latitud);
        			            argumentos.putDouble("estable_longitud", nodox.Lugar.Longitud);      	
        			        	        			        	       			     
        			        	Controlador_Descripcion_Evento fragment = new Controlador_Descripcion_Evento(log_in);        			                  			            
        			            fragment.setArguments(argumentos);
        			            getFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        			            
        			            return;		        	
        			        }
        			    }
             
        	        }
        	  }
        );
        
        
        return v;
    }
}

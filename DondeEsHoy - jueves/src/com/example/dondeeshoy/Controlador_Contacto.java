package com.example.dondeeshoy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

public class Controlador_Contacto extends Fragment{
	
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
	 
	        View v = inflater.inflate(R.layout.contacto, container, false);
	        Bundle args2 = new Bundle();
			return v;
	        
	 }
}
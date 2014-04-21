package com.example.dondeeshoy;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import com.google.android.gms.maps.MapFragment;

public class Controlador_Mapa extends Fragment {
	
	 public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
	 
	        View v = inflater.inflate(R.layout.mapa, container, false);
	        Bundle args2 = new Bundle();
			return v;
	        
	 }
}
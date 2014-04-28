package com.example.dondeeshoy;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.MapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.Marker;
import com.google.android.gms.maps.model.MarkerOptions;

public class Controlador_Mapa extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mapa);
        
        GoogleMap mMap;
        MapFragment mMapFragment;

        mMapFragment = ((MapFragment)getFragmentManager().findFragmentById(R.id.map));
        mMap = mMapFragment.getMap();
        double latitud = getIntent().getDoubleExtra("latitud", 0.0);
        double longitud = getIntent().getDoubleExtra("longitud", 0.0);
        mMap.moveCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(latitud, longitud),30));
        mMap.setMyLocationEnabled(true);
        Marker myMaker = mMap.addMarker(new MarkerOptions()
	        .position(new LatLng(latitud, longitud))
	        .title("Su lugar")  //Agrega un titulo al marcador
	        .snippet("Debe llegar aca"));   //Agrega información detalle relacionada con el marcador 
       
    }
    
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {             
        View rootView = inflater.inflate(R.layout.mapa, container, false);
        return rootView;
    }
}
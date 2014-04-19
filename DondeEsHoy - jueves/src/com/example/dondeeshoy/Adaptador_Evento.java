package com.example.dondeeshoy;

import java.util.ArrayList;
import android.app.Activity;
import android.content.Context;
import android.location.LocationManager;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class Adaptador_Evento extends BaseAdapter{
	
	 protected Fragment fragment;
	 protected ArrayList<Evento> eventos;
	 
	 public Adaptador_Evento(Fragment fragment, ArrayList<Evento> items) {
		    this.fragment = fragment;
		    this.eventos = items;
		  }
	 
	 @Override
	  public int getCount() {
	    return eventos.size();
	  }
	 
	  @Override
	  public Object getItem(int position) {
	    return eventos.get(position);
	  }
	 
	  @Override
	  public View getView(int position, View contentView, ViewGroup parent) {
	    View vi=contentView;
	         
	    if(contentView == null) {
	    	
	      LayoutInflater inflater = (LayoutInflater) fragment.getLayoutInflater(null);
	      vi = inflater.inflate(R.layout.activity_principal, null);	      
		
	    }
	             
	    Evento item = eventos.get(position);
	         
	    ImageView image = (ImageView) vi.findViewById(R.id.logo);
		image.setImageDrawable(fragment.getResources().getDrawable(eventos.get(position).mImageResource));
	         
		TextView tTitle = (TextView) vi.findViewById(R.id.nomEspectaculo);
		tTitle.setText(eventos.get(position).mTitle);
		
		TextView hTitle = (TextView) vi.findViewById(R.id.ubicacion);
		hTitle.setText(eventos.get(position).mhorario);
		
		TextView eTitle = (TextView) vi.findViewById(R.id.nomLugar);
		eTitle.setText(eventos.get(position).medades);
		
		TextView tipoTitle = (TextView) vi.findViewById(R.id.nomTipo);
		tipoTitle.setText(eventos.get(position).mtipo);
	 
	    return vi;
	  }

	

	@Override
	public long getItemId(int arg0) {
		// TODO Auto-generated method stub
		return 0;
	}
}

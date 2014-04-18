package com.example.lista_android;

import java.util.ArrayList;

import android.os.Bundle;
import android.app.Activity;
import android.app.ListActivity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
//import android.view.Menu;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.TextView;

public class Principal extends ListActivity{
	
	private MyAdapter mAdapter = null;
	
	public class Node
	{
		public String mTitle;
		public Integer mImageResource;
		public String mhorario;
		public String medades; 
		public String mtipo;
	}
	
	private void setData(){
		mArray.clear();
		
		Node nodo1 = new Node(); 
		nodo1.mTitle = "Teatro Urbano";
		nodo1.mhorario = "Made in Tikicia";
		nodo1.medades = "10/03/2014";
		nodo1.mImageResource = R.drawable.urbano; 
		nodo1.mtipo = "Teatro";
		mArray.add(nodo1); 
		
		Node nodo2 = new Node(); 
		nodo2.mTitle = "Teatro Nacional";
		nodo2.mhorario = "FIA";
		nodo2.medades = "12/03/2014";
		nodo2.mImageResource = R.drawable.nacional; 
		nodo2.mtipo = "Teatro";
		mArray.add(nodo2); 
		
		Node nodo3 = new Node(); 
		nodo3.mTitle = "Teatro Moliere";
		nodo3.mhorario = "Papichulo";
		nodo3.medades = "12/03/2014";
		nodo3.mImageResource = R.drawable.moliere; 
		nodo3.mtipo = "Teatro";
		mArray.add(nodo3); 
		
		Node nodo4 = new Node(); 
		nodo4.mTitle = "Teatro Variedades";
		nodo4.mhorario = "La Dama de negro";
		nodo4.medades = "12/03/2014";
		nodo4.mImageResource = R.drawable.variedades; 
		nodo4.mtipo = "Teatro";
		mArray.add(nodo4); 
		
		Node nodo5 = new Node(); 
		nodo5.mTitle = "Teatro Arlequin";
		nodo5.mhorario = "Dos Arriba una Abajo";
		nodo5.medades = "12/03/2014";
		nodo5.mImageResource = R.drawable.arlequin; 
		nodo5.mtipo = "Teatro";
		mArray.add(nodo5); 
		
		Node nodo6 = new Node(); 
		nodo6.mTitle = "Teatro la Mascara";
		nodo6.mhorario = "Apartamento de Soltero";
		nodo6.medades = "12/03/2014";
		nodo6.mImageResource = R.drawable.mascara; 
		nodo6.mtipo = "Teatro";
		mArray.add(nodo6); 
		
		Node nodo7 = new Node(); 
		nodo7.mTitle = "Teatro Metropolitano";
		nodo7.mhorario = "Ojos que no ven";
		nodo7.medades = "12/03/2014";
		nodo7.mImageResource = R.drawable.metropolitano; 
		nodo7.mtipo = "Teatro";
		mArray.add(nodo7); 
	}
	
	public static ArrayList<Node> mArray = new ArrayList<Node>(); 

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setData();
		mAdapter = new MyAdapter(this); 
		setListAdapter (mAdapter); 
		
	/*@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.principal, menu);
		return true;
	}*/  }

	public static class MyAdapter extends BaseAdapter{
		
		private Context mContext;
		public MyAdapter(Context c){
			mContext = c;
		}
		
		public int getCount(){
			return mArray.size();
		}
		
		public Object getItem(int position){
			return mArray.get(position);
		}
		
		public long getItemId(int position){
			return 0;
		}
		
		public View getView(int position, View convertView, ViewGroup parent){
			
			View view = null;
			
			if(convertView == null){
				LayoutInflater inflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
				view = inflater.inflate(R.layout.activity_principal, null);			
			}
			else{
				view = convertView; 
			}
			
			ImageView img = (ImageView) (ImageView) view.findViewById(R.id.logo);
			img.setImageDrawable(mContext.getResources().getDrawable(mArray.get(position).mImageResource));
			
			TextView tTitle = (TextView) view.findViewById(R.id.nomEspectaculo);
			tTitle.setText(mArray.get(position).mTitle);
			
			TextView hTitle = (TextView) view.findViewById(R.id.ubicacion);
			hTitle.setText(mArray.get(position).mhorario);
			
			TextView eTitle = (TextView) view.findViewById(R.id.nomLugar);
			eTitle.setText(mArray.get(position).medades);
			
			TextView tipoTitle = (TextView) view.findViewById(R.id.nomTipo);
			tipoTitle.setText(mArray.get(position).mtipo);
			
			return view; 
		}
	}	
	
	
}
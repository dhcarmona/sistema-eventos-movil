package com.example.dondeeshoy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
 
public class MainActivity extends ActionBarActivity {
 
    private DrawerLayout drawerLayout;
    private ListView navList;
    private CharSequence mTitle;
 
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
 
        mTitle = getTitle();
        this.drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        this.navList = (ListView) findViewById(R.id.left_drawer);
 
        // Load an array of options names
        final String[] names = getResources().getStringArray(
                R.array.nav_options);
 
        // Set previous array as adapter of the list
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
                android.R.layout.simple_list_item_1, names);
        navList.setAdapter(adapter);
        navList.setOnItemClickListener(new DrawerItemClickListener());
        
    }
 
    private class DrawerItemClickListener implements
            ListView.OnItemClickListener {
    	
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
            selectItem(position);
        }
        
    }
 
    /** Swaps fragments in the main content view */
    private void selectItem(int position) {
        // Get text from resources
        mTitle = getResources().getStringArray(R.array.nav_options)[position];
 
        // Create a new fragment and specify the option to show based on
        // position
        MyFragment2 fragment = new MyFragment2();
        Bundle args = new Bundle();
        args.putString(MyFragment.KEY_TEXT, mTitle.toString());
        fragment.setArguments(args);
 
        // Insert the fragment by replacing any existing fragment
        // FragmentManager fragmentManager = getSupportFragmentManager();
        // fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();     
			
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();    
       
        
     /*   lista.setAdapter(new Lista_adaptador(this, R.layout.entrada, datos){
        	
			@Override
			public void onEntrada(Object entrada, View view) {
		            TextView texto_superior_entrada = (TextView) view.findViewById(R.id.textView_superior); 
		            texto_superior_entrada.setText(((Lista_entrada) entrada).get_textoEncima()); 

		            TextView texto_inferior_entrada = (TextView) view.findViewById(R.id.textView_inferior); 
		            texto_inferior_entrada.setText(((Lista_entrada) entrada).get_textoDebajo()); 

		            ImageView imagen_entrada = (ImageView) view.findViewById(R.id.imageView_imagen); 
		            imagen_entrada.setImageResource(((Lista_entrada) entrada).get_idImagen());
			} } );*/
        
        
        // Highlight the selected item, update the title, and close the drawer
        navList.setItemChecked(position, true);
        getSupportActionBar().setTitle(mTitle);
        drawerLayout.closeDrawer(navList);
    }
    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }
    
    private class StableArrayAdapter extends ArrayAdapter<String> {

        HashMap<String, Integer> mIdMap = new HashMap<String, Integer>();

        public StableArrayAdapter(Context context, int textViewResourceId, List<String> objects) {
            super(context, textViewResourceId, objects);
            for (int i = 0; i < objects.size(); ++i) {
            mIdMap.put(objects.get(i), i);
          }
        }

        @Override
        public long getItemId(int position) {
          String item = getItem(position);
          return mIdMap.get(item);
        }

        @Override
        public boolean hasStableIds() {
          return true;
        }

      }
 
}
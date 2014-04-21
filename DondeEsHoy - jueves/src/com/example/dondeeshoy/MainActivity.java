 package com.example.dondeeshoy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends ActionBarActivity {
 
    private DrawerLayout drawerLayout;
    private ListView navList;
    private CharSequence mTitle;
    public Controlador_Log_in log_in;
    public ArrayList<Evento> mArray = new ArrayList<Evento>(); 
 
    
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
        
        // Perfil
        
         this.log_in = new Controlador_Log_in();
		 Bundle args3 = new Bundle();
         args3.putString(Controlador_Evento.KEY_TEXT, mTitle.toString());
         this.log_in.setArguments(args3);
         
        //Se presenta la pagina inicial
        
        Controlador_Evento fragment = new Controlador_Evento();
        this.mArray = fragment.mArray;
        Bundle args = new Bundle();
        args.putString(Controlador_Evento.KEY_TEXT, mTitle.toString());
        fragment.setArguments(args);
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        
        
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
 
        // Dependiendo de la opción del menú que el usuario seleccione, se carga el fragment respectivo 
        
        // Lista de Eventos
        if(position==0){
        	
	        Controlador_Evento fragment = new Controlador_Evento();
	        Bundle args = new Bundle();
	        args.putString(Controlador_Evento.KEY_TEXT, mTitle.toString());
	        fragment.setArguments(args);
	        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();      
	        
	        // Highlight the selected item, update the title, and close the drawer	        
	        navList.setItemChecked(position, true);
	        getSupportActionBar().setTitle(mTitle);
	        drawerLayout.closeDrawer(navList);	 
	        }
        
        // Usuario
        if(position==1){
        	
        	if (this.log_in == null ){
        		System.out.println("XXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXXX-LA JUGADA ES NULL");
        		 this.log_in = new Controlador_Log_in();
        		 Bundle args = new Bundle();
     	         args.putString(Controlador_Evento.KEY_TEXT, mTitle.toString());
     	         this.log_in.setArguments(args);
        	}
        	else System.out.println("YYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYYY-LA JUGADA YA NO ES NULL");
	        
	        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, this.log_in).commit();      	        
	        // Highlight the selected item, update the title, and close the drawer	        
	        navList.setItemChecked(position, true);
	        getSupportActionBar().setTitle(mTitle);
	        drawerLayout.closeDrawer(navList);	 
	        }
        
        // Buscar 
        if(position==2){
        	
	        Controlador_Buscar fragment = new Controlador_Buscar(this.mArray);
	        Bundle args = new Bundle();
	        args.putString(Controlador_Evento.KEY_TEXT, mTitle.toString());
	        fragment.setArguments(args);
	        
	        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();      
	        
	        // Highlight the selected item, update the title, and close the drawer	        
	        navList.setItemChecked(position, true);
	        getSupportActionBar().setTitle(mTitle);
	        drawerLayout.closeDrawer(navList);	 
	        }
        
        // Contacto 
        if(position==3){
        	
	        Controlador_Contacto fragment = new Controlador_Contacto();
	        Bundle args = new Bundle();
	        args.putString(Controlador_Evento.KEY_TEXT, mTitle.toString());
	        fragment.setArguments(args);
	        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();      
	        
	        // Highlight the selected item, update the title, and close the drawer        
	        navList.setItemChecked(position, true);
	        getSupportActionBar().setTitle(mTitle);
	        drawerLayout.closeDrawer(navList);	 
	        }
        
        //Salir
        if(position==4){
        	finish();
        }
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
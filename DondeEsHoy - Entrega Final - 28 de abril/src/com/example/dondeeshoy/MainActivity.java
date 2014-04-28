 package com.example.dondeeshoy;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import android.content.Context;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends ActionBarActivity {
 
    private DrawerLayout drawerLayout;
    private ListView navList;
    private CharSequence mTitle;
    public Controlador_Log_in log_in;
    public ArrayList<Evento> mArray = new ArrayList<Evento>(); 
    public Manejo_Datos Datos ;
    public ActionBarDrawerToggle drawerToggle;
 
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    	
    	super.onCreate(savedInstanceState);
    	
    	getSupportActionBar().setLogo(R.drawable.icono);

    	
    	// Se obtienen los datos
        this.Datos = new Manejo_Datos();
        this.Datos.setData();
        try {
			Thread.sleep(5400);
		} catch (InterruptedException e) {

			e.printStackTrace();
		}
        this.mArray = Datos.mArray;
        
        //super.onCreate(savedInstanceState);
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
        
        Controlador_Evento fragment = new Controlador_Evento(log_in, mArray);        
        Bundle args = new Bundle();
        args.putString(Controlador_Evento.KEY_TEXT, mTitle.toString());
        fragment.setArguments(args);      
        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, fragment).commit();
        
        //Boton action bar
        this.drawerToggle = new ActionBarDrawerToggle(this, drawerLayout,
                R.drawable.rayas2, R.string.open_drawer,
                R.string.close_drawer) {
        	
        	 public void onDrawerOpened(View drawerView) {
                 getSupportActionBar().setTitle("Selecciona opción");
                 // creates call to onPrepareOptionsMenu()
                 supportInvalidateOptionsMenu();
             }
        	 
        	 public void onDrawerClosed(View view) {
                 getSupportActionBar().setTitle(mTitle);
                 // creates call to onPrepareOptionsMenu()
                 supportInvalidateOptionsMenu();
             }       	 
        	
        };
            
     // Set the drawer toggle as the DrawerListener
        drawerLayout.setDrawerListener(drawerToggle);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setHomeButtonEnabled(true);
        
        }
    
    @Override
    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        // Sync the toggle state after onRestoreInstanceState has occurred.
        drawerToggle.syncState();
    }
 
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        // Called by the system when the device configuration changes while your
        // activity is running
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
    }
 
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Pass the event to ActionBarDrawerToggle, if it returns
        // true, then it has handled the app icon touch event
        if (drawerToggle.onOptionsItemSelected(item)) {
            return true;
        }
        // Handle your other action bar items...
        return super.onOptionsItemSelected(item);
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
        	
	        Controlador_Evento fragment = new Controlador_Evento(this.log_in, this.Datos.mArray);
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
        		 this.log_in = new Controlador_Log_in();
        		 Bundle args = new Bundle();
     	         args.putString(Controlador_Evento.KEY_TEXT, mTitle.toString());
     	         this.log_in.setArguments(args);
        	}

	        getSupportFragmentManager().beginTransaction().replace(R.id.content_frame, this.log_in).commit();      	        
	        // Highlight the selected item, update the title, and close the drawer	        
	        navList.setItemChecked(position, true);
	        getSupportActionBar().setTitle(mTitle);
	        drawerLayout.closeDrawer(navList);	 
	        }
        
        // Buscar 
        if(position==2){
        	
	        Controlador_Buscar fragment = new Controlador_Buscar(this.mArray, this.log_in);
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
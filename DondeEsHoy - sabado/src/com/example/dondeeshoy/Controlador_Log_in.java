package com.example.dondeeshoy;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;

import org.json.JSONException;
import org.json.JSONObject;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.FacebookRequestError;
import com.facebook.HttpMethod;
import com.facebook.RequestAsyncTask;
import com.facebook.Response;
import com.facebook.Session;
import com.facebook.Request;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;

public class Controlador_Log_in extends Fragment{
	public static final int SPLASH = 0;
	public static final int SELECTION = 1;
	public Fragment[] fragments = new Fragment[FRAGMENT_COUNT];	
	public boolean isResumed = false;
	public UiLifecycleHelper uiHelper;
	public static final int SETTINGS = 2;
	public MenuItem settings;
	public static final int FRAGMENT_COUNT = SETTINGS +1;
	public Button shareButton;
	public static final List<String> PERMISSIONS = Arrays.asList("publish_actions");
	public static final String PENDING_PUBLISH_KEY = "pendingPublishReauthorization";
	public boolean pendingPublishReauthorization = false;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        
	    View v = inflater.inflate(R.layout.log_in, container, false);
	    
	    uiHelper = new UiLifecycleHelper(getActivity(), callback);
	    uiHelper.onCreate(savedInstanceState);
	    FragmentManager fm = getFragmentManager();
	    shareButton = (Button) v.findViewById(R.id.shareButton);
	    fragments[SPLASH] = fm.findFragmentById(R.id.splashFragment);
	    fragments[SELECTION] = fm.findFragmentById(R.id.selectionFragment);
	    fragments[SELECTION] = fm.findFragmentById(R.id.selectionFragment);
	    fragments[SETTINGS] = fm.findFragmentById(R.id.userSettingsFragment);

	    FragmentTransaction transaction = fm.beginTransaction();

	    transaction.hide(fragments[1]);
	    transaction.hide(fragments[0]);
	    transaction.commit();
	    
	    if (savedInstanceState != null) {
	        pendingPublishReauthorization = 
	            savedInstanceState.getBoolean(PENDING_PUBLISH_KEY, false);
	    }
	    
	    shareButton = (Button) v.findViewById(R.id.shareButton);
	    shareButton.setOnClickListener(new View.OnClickListener() {
	        @Override
	        public void onClick(View v) {
	            publishStory("Donde es hoy","Aplicacion hechar por Bryan Munoz y Diego Carmona","Instituto Tecnologico de CR","https://www.facebook.com/bryanmuvi");        
	        }
	    });
		    
		return v;
	}
	
	public void showFragment(int fragmentIndex, boolean addToBackStack) {
	    FragmentManager fm = getFragmentManager();
	    FragmentTransaction transaction = fm.beginTransaction();
	    for (int i = 0; i < 2; i++) {
	        if (i == fragmentIndex) {
	            transaction.show(fragments[i]);
	        } else {
	            transaction.hide(fragments[i]);
	        }
	    }
	    if (addToBackStack) {
	        transaction.addToBackStack(null);
	    }
	    transaction.commit();
	}
	
	
	public void onSessionStateChange(Session session, SessionState state, Exception exception) {
	    // Only make changes if the activity is visible
		//Compartir
		
		if (state.isOpened()) {
	        shareButton.setVisibility(View.VISIBLE);
	    } else if (state.isClosed()) {
	        shareButton.setVisibility(View.INVISIBLE);
	    }
		
		shareButton.setVisibility(View.VISIBLE);
		if (pendingPublishReauthorization && 
		        state.equals(SessionState.OPENED_TOKEN_UPDATED)) {
		    pendingPublishReauthorization = false;
		  //  publishStory();
		}
		
		//Codigo de prueba de cambiar fragments
		System.out.println("------------------------Notó el cambio en la sesión -----------------------------");
	    if (isResumed) {
	    	System.out.println("------------------------ 222222 Notó el cambio en la sesión -----------------------------");
	        FragmentManager manager = getFragmentManager();
	        // Get the number of entries in the back stack
	        int backStackSize = manager.getBackStackEntryCount();
	        // Clear the back stack
	        for (int i = 0; i < backStackSize; i++) {
	        	System.out.println("------------------------3333333Notó el cambio en la sesión -----------------------------");
	            manager.popBackStack();
	        }
	        if (state.isOpened()) {
	        	System.out.println("------------------------44444444Notó el cambio en la sesión -----------------------------");
	            // If the session state is open:
	            // Show the authenticated fragment
	            showFragment(SELECTION, false);
	        } else if (state.isClosed()) {
	        	System.out.println("------------------------5555555555Notó el cambio en la sesión -----------------------------");
	            // If the session state is closed:
	            // Show the login fragment
	            showFragment(SPLASH, false);
	        }
	    }
	}
	
	
	public void onResumeFragments() {
	//    super.onResumeFragments();
	    super.onResume(); 
	    Session session = Session.getActiveSession();

	    if (session != null && session.isOpened()) {
	    	 // if the session is already open,
	        // try to show the selection fragment
	        showFragment(SELECTION, false);
	    } else {
	        // otherwise present the splash screen
	        // and ask the person to login.
	        showFragment(SPLASH, false);
	    }
	}
	
	/*public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);

	    uiHelper = new UiLifecycleHelper(getActivity(), callback);
	    uiHelper.onCreate(savedInstanceState);
	    
	}*/

	@Override
	public void onResume() {
	    super.onResume();
	    uiHelper.onResume();
	    isResumed = true;
	}

	@Override
	public void onPause() {
	    super.onPause();
	    uiHelper.onPause();
	    isResumed = false;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
	    super.onActivityResult(requestCode, resultCode, data);
	    uiHelper.onActivityResult(requestCode, resultCode, data);
	}

	@Override
	public void onDestroy() {
	    super.onDestroy();
	    uiHelper.onDestroy();
	}

	@Override
	public void onSaveInstanceState(Bundle outState) {
	    super.onSaveInstanceState(outState);
	    outState.putBoolean(PENDING_PUBLISH_KEY, pendingPublishReauthorization);
	    uiHelper.onSaveInstanceState(outState);
	}
	
	public Session.StatusCallback callback =  new Session.StatusCallback() {
	    @Override
	    public void call(Session session, 
	            SessionState state, Exception exception) {
	        onSessionStateChange(session, state, exception);
	    }
	};
	
	@Override
	public void onPrepareOptionsMenu(Menu menu) {
	    // only add the menu when the selection fragment is showing
	    if (fragments[SELECTION].isVisible()) {
	        if (menu.size() == 0) {
	            settings = menu.add(R.string.settings);
	        }
	     //   return true;
	    } else {
	        menu.clear();
	        settings = null;
	    }
	  //  return false;
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    if (item.equals(settings)) {
	        showFragment(SETTINGS, true);
	        return true;
	    }
	    return false;
	}
	
	public void publishStory(String lugar, String nombre, String descripcion, String link) {
	    Session session = Session.getActiveSession();

	    if (session != null){

	        // Check for publish permissions    
	        List<String> permissions = session.getPermissions();
	        if (!isSubsetOf(PERMISSIONS, permissions)) {
	            pendingPublishReauthorization = true;
	            Session.NewPermissionsRequest newPermissionsRequest = new Session
	                    .NewPermissionsRequest(this, PERMISSIONS);
	        session.requestNewPublishPermissions(newPermissionsRequest);
	            return;
	        }

	        Bundle postParams = new Bundle();
	        postParams.putString("name", lugar);
	        postParams.putString("caption", nombre);
	        postParams.putString("description", descripcion);
	        postParams.putString("link", link);
	        postParams.putString("picture", "https://fbcdn-sphotos-b-a.akamaihd.net/hphotos-ak-prn1/t1.0-9/523447_10151082071021637_254365757_n.jpg");

	        Request.Callback callback= new Request.Callback() {
	            public void onCompleted(Response response) {
	                JSONObject graphResponse = response
	                                           .getGraphObject()
	                                           .getInnerJSONObject();
	                String postId = null;
	                try {
	                    postId = graphResponse.getString("id");
	                } catch (JSONException e) {
	                    Log.i("TAG",
	                        "JSON error "+ e.getMessage());
	                }
	                FacebookRequestError error = response.getError();
	           /*     if (error != null) {
	                    Toast.makeText(getActivity()
	                         .getApplicationContext(),
	                         "Evento Compartido en tu Muro",
	                         Toast.LENGTH_SHORT).show();
	                    } else {
	                        Toast.makeText(getActivity()
	                             .getApplicationContext(), 
	                             postId,
	                             Toast.LENGTH_LONG).show();
	                }*/
	            }
	        };

	        Request request = new Request(session, "me/feed", postParams, 
	                              HttpMethod.POST, callback);

	        RequestAsyncTask task = new RequestAsyncTask(request);
	        task.execute();
	    }

	}
	
	private boolean isSubsetOf(Collection<String> subset, Collection<String> superset) {
	    for (String string : subset) {
	        if (!superset.contains(string)) {
	            return false;
	        }
	    }
	    return true;
	}
	 
}

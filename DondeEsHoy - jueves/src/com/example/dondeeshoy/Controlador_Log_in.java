package com.example.dondeeshoy;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import com.facebook.Session;
import com.facebook.SessionState;
import com.facebook.UiLifecycleHelper;

public class Controlador_Log_in extends Fragment{
	private static final int SPLASH = 0;
	private static final int SELECTION = 1;
	private Fragment[] fragments = new Fragment[FRAGMENT_COUNT];	
	private boolean isResumed = false;
	private UiLifecycleHelper uiHelper;
	private static final int SETTINGS = 2;
	private MenuItem settings;
	private static final int FRAGMENT_COUNT = SETTINGS +1;
	
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        
	    System.out.println("ENTROOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	    View v = inflater.inflate(R.layout.log_in, container, false);
	    System.out.println("PASOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOOO");
	    
	    uiHelper = new UiLifecycleHelper(getActivity(), callback);
	    uiHelper.onCreate(savedInstanceState);
	    FragmentManager fm = getFragmentManager();
	    fragments[SPLASH] = fm.findFragmentById(R.id.splashFragment);
	    fragments[SELECTION] = fm.findFragmentById(R.id.selectionFragment);
	    fragments[SELECTION] = fm.findFragmentById(R.id.selectionFragment);
	    fragments[SETTINGS] = fm.findFragmentById(R.id.userSettingsFragment);

	    FragmentTransaction transaction = fm.beginTransaction();

	    transaction.hide(fragments[1]);
	    transaction.hide(fragments[0]);
	    transaction.commit();
		    
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
	 
}

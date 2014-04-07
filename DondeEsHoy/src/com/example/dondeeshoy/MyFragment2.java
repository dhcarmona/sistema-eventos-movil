package com.example.dondeeshoy;

import java.util.ArrayList;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

public class MyFragment2 extends Fragment{
	
	public final static String KEY_TEXT = "key_text";	 
    private String mText;
    
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState) {
		  
        View v = inflater.inflate(R.layout.listado, container, false);
     
        
        return v;
    }
}

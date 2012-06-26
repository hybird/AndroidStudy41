package com.androidstudy;

import android.app.Activity;
import android.app.FragmentManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class AndroidStudy4Activity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        
        FragmentManager fm = getFragmentManager();  
        fm.findFragmentById(R.id.fragment1);
    }
    
    public void toFrag(View view)
	{
		
    	Intent intent = new Intent();
    	intent.setClass(this, ItemDetailActivity.class);
    	startActivity(intent);
	}
    
    public void toCursor(View view)
	{
    	Intent intent = new Intent();
    	intent.setClass(this, LoaderCursor.class);
    	startActivity(intent);
	}
}
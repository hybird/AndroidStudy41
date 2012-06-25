package com.androidstudy;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.Bundle;

public class ItemDetailActivity extends Activity
{

	protected void onCreate(Bundle savedInstanceState) {  
        super.onCreate(savedInstanceState);  
        setContentView(R.layout.itemdetail);  
    }  
    /** 
     * This is a secondary activity, to show what the user has selected 
     * when the screen is not large enough to show it all in one activity. 
     */  
    public class DetailsActivity extends Activity {  
        @Override  
        protected void onCreate(Bundle savedInstanceState) {  
            super.onCreate(savedInstanceState);  

            if (getResources().getConfiguration().orientation  
                    == Configuration.ORIENTATION_LANDSCAPE) {  
                // If the screen is now in landscape mode, we can show the  
                // dialog in-line with the list so we don't need this activity.  
                finish();  
                return;  
            }  
            if (savedInstanceState == null) {  
                // During initial setup, plug in the details fragment.  
                DetailsFragment details = new DetailsFragment();  
                details.setArguments(getIntent().getExtras());  
                getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();  
            }  
        }  
    }  
}

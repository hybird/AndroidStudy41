package com.androidstudy;

import android.app.Service;
import android.content.Intent;
import android.os.Binder;
import android.os.IBinder;
import android.util.Log;
import android.widget.Toast;

public class ServiceTest extends Service
{
	private final MyIBinder myIBinder = new MyIBinder();

	@Override
	public IBinder onBind(Intent intent)
	{
		
		return myIBinder;
	}

	@Override
	public void onCreate()
	{
		// TODO Auto-generated method stub
		super.onCreate();
	}

	@Override
	public void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	public class MyIBinder extends Binder {  
        public Service getService() {  
        	ServiceActivity.tv.setText("MyIBinder...");
            return ServiceTest.this;  
        }  
    } 
	
	public void test1()
	{
		try
		{
			
			Thread.sleep(3000);
		} catch (InterruptedException e)
		{
			// TODO Auto-generated catch block
			e.printStackTrace();
		} 
		Log.i("Service", "service.test1");
	}

}

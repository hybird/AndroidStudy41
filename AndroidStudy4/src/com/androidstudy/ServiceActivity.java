package com.androidstudy;

import com.androidstudy.ServiceTest.MyIBinder;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.ServiceConnection;
import android.os.Binder;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

public class ServiceActivity extends Activity
{
	public static TextView tv ;
	ServiceTest bsi;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{
		// TODO Auto-generated method stub
		super.onCreate(savedInstanceState);
		setContentView(R.layout.service);
		tv = (TextView)findViewById(R.id.tvService);
	}

	@Override
	protected void onDestroy()
	{
		// TODO Auto-generated method stub
		super.onDestroy();
	}
	
	private ServiceConnection myLocalServiceConnection = new ServiceConnection() {  
        public void onServiceConnected(android.content.ComponentName name,  
                android.os.IBinder service) {  
        	Log.i("ServiceActivity", "onServiceConnected");
             
            // 因为 客户端 与 服务 在同一个进程内，这样一来，就可以知道参数 "service"的类型了，也就可以进行显示的强制类型转换了。  
            // 而如果 客户端与服务不在同一个进程中的话，那么此处是不可以进行显示强制类型转换的，  
            // 因为，通过Debug，可以发现此时传进来的 Service 的类型是 BinderProxy  
            MyIBinder myIBinder = (MyIBinder) service;  
            bsi = (ServiceTest) myIBinder.getService();  
            
  
            bsi.test1();  
        };  
  
        public void onServiceDisconnected(android.content.ComponentName name) {  
        	Log.i("ServiceActivity", "onServiceDisconnected");
           
        };  
    };  
    
    public void bindServiceTest(View view)
	{
    	Intent intent = new Intent();
    	intent.setClass(this, ServiceTest.class);
    	bindService(intent, myLocalServiceConnection, Context.BIND_AUTO_CREATE);  
	}
    
    public void unBindServiceTest(View view)
	{
    	Log.i("ServiceActivity", "unBindServiceTest");
		unbindService(myLocalServiceConnection);
	}

}

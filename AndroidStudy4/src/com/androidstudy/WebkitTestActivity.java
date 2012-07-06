package com.androidstudy;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationManager;
import android.os.Bundle;
import android.os.Handler;
import android.webkit.WebView;

public class WebkitTestActivity extends Activity
{
	private Handler mHandler = new Handler(); 
	WebView wv;

	@Override
	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		wv = new WebView(this);
		wv.getSettings().setJavaScriptEnabled(true);
		//JsObj jo = new JsObj(this);

		wv.addJavascriptInterface(new DemoJavaScriptInterface(), "demo");
		setContentView(wv);
		wv.loadUrl("file:///android_asset/jquerytest.html");
	}

	// 这是他定义由 addJavascriptInterface 提供的一个Object  
    final class DemoJavaScriptInterface {  
        DemoJavaScriptInterface() {  
        }  
  
        /** 
         * This is not called on the UI thread. Post a runnable to invoke 
         * 这不是界面线程。发表一个运行调用 
         * loadUrl on the UI thread. 
         * loadUrl在UI线程。 
         */  
        public void clickOnAndroid() {        // 注意这里的名称。它为clickOnAndroid(),注意，注意，严重注意  
            mHandler.post(new Runnable() {  
                public void run() {  
                    // 此处调用 HTML 中的javaScript 函数  
                    wv.loadUrl("javascript:wave()");  
                }  
            });  
        }  
    }  
	
}

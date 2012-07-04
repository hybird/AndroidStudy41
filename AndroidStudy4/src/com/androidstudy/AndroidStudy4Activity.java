package com.androidstudy;

import android.app.Activity;
import android.app.FragmentManager;
import android.app.PendingIntent;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.telephony.SmsManager;
import android.view.View;
import android.widget.Toast;

public class AndroidStudy4Activity extends Activity
{
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState)
	{
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

	public void toWebkit(View view)
	{
		Intent intent = new Intent();
		intent.setClass(this, WebkitTestActivity.class);
		startActivity(intent);
	}

	public void toService(View view)
	{
		Intent intent = new Intent();
		intent.setClass(this, ServiceActivity.class);
		startActivity(intent);
	}

	public void openSms(View view)
	{
		// 调出短信发送界面发送短信
		Uri uri = Uri.parse("smsto:10086");
		Intent intent = new Intent(Intent.ACTION_SENDTO, uri);

		intent.putExtra("sms_body", "短信预警");

		startActivity(intent);
	}

	public void sendSms(View view)
	{
		// 后台直接发送
		String messageAddress = "10086";
		String messageContent = "短信预警";

		// 构建一取得default instance的SmsManager对象
		
		SmsManager smsManager = SmsManager.getDefault();
		// 检查输入内容是否为空,这里为了简单就没有判断是否是号码,短信内容长度的限制也没有做
		if (messageAddress.trim().length() != 0
				&& messageContent.trim().length() != 0)
		{
			try
			{
				PendingIntent pintent = PendingIntent.getBroadcast(
						AndroidStudy4Activity.this, 0, new Intent(), 0);
				smsManager.sendTextMessage(messageAddress, null,
						messageContent, pintent, null);

			} catch (Exception e)
			{
				e.printStackTrace();
			}
			// 提示发送成功
			Toast.makeText(AndroidStudy4Activity.this, "发送成功",
					Toast.LENGTH_LONG).show();
		} else
		{
			Toast.makeText(AndroidStudy4Activity.this, "发送地址或者内容不能为空",
					Toast.LENGTH_SHORT).show();
		}
	}
}
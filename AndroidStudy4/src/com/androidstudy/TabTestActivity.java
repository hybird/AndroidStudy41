package com.androidstudy;

import android.app.Activity;
import android.app.TabActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.RadioGroup;
import android.widget.RadioGroup.OnCheckedChangeListener;
import android.widget.TabHost;
import android.widget.TabHost.TabSpec;

public class TabTestActivity extends TabActivity
{

	public TabHost mth;
	public static final String TAB_HOME = "TabHome";
	public static final String TAB_MSG = "TabMSG";
	public RadioGroup mainbtGroup;

	protected void onCreate(Bundle savedInstanceState)
	{

		super.onCreate(savedInstanceState);
		setContentView(R.layout.maintabs);

		mth = this.getTabHost();
		// 创建2个子页
		TabSpec ts1 = mth.newTabSpec(TAB_HOME).setIndicator(TAB_HOME);

		ts1.setContent(new Intent(TabTestActivity.this, ServiceActivity.class));
		mth.addTab(ts1);
		TabSpec ts2 = mth.newTabSpec(TAB_MSG).setIndicator(TAB_MSG);
		ts2.setContent(new Intent(TabTestActivity.this,
				WebkitTestActivity.class));
		mth.addTab(ts2);

		// 得到RadioGroup对象
		this.mainbtGroup = (RadioGroup) this.findViewById(R.id.radiogroup1);
		mainbtGroup.setOnCheckedChangeListener(new OnCheckedChangeListener()
		{

			
			public void onCheckedChanged(RadioGroup group, int checkedId)
			{
				// TODO Auto-generated method stub
				Log.d("select ID", "---------------" + checkedId);
				switch (checkedId)
				{
				case R.id.radio_button0:// 首页
					mth.setCurrentTabByTag(TAB_HOME);
					break;
				case R.id.radio_button1:// 信息
					mth.setCurrentTabByTag(TAB_MSG);
					break;
			

				}
			}

		});
	}

}

package com.androidstudy;

import android.app.Fragment;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ScrollView;
import android.widget.TextView;

public class DetailsFragment extends Fragment
{

	public static final String[] DIALOGUE = { "Detail1", "Detail2", "Detail3" };
	public static final String[] TITLES = { "H1", "H2", "H3" };

	/**
	 * Create a new instance of DetailsFragment, initialized to show the text at
	 * 'index'.
	 */
	public static DetailsFragment newInstance(int index)
	{
		DetailsFragment f = new DetailsFragment();
		// Supply index input as an argument.
		Bundle args = new Bundle();
		args.putInt("index", index);
		// 给Fragment初始化参数
		f.setArguments(args);
		return f;
	}

	public int getShownIndex()
	{
		return getArguments().getInt("index", 0);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState)
	{
		if (container == null)
		{
			// We have different layouts, and in one of them this
			// fragment's containing frame doesn't exist. The fragment
			// may still be created from its saved state, but there is
			// no reason to try to create its view hierarchy because it
			// won't be displayed. Note this is not needed -- we could
			// just run the code below, where we would create and return
			// the view hierarchy; it would just never be used.
			return null;
		}

		ScrollView scroller = new ScrollView(getActivity());
		TextView text = new TextView(getActivity());
		int padding = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getActivity().getResources().getDisplayMetrics());
		// hetao：设置边框大小
		text.setPadding(padding, padding, padding, padding);
		scroller.addView(text);
		text.setText(DIALOGUE[getShownIndex()]);
		return scroller;
	}

}

package com.example.horizontallistviewdemo;

import it.sephiroth.android.library.widget.HListView;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.LinearLayout.LayoutParams;
import android.widget.TextView;

public class MainActivity extends Activity {

	private HListView mHListView;
	private ArrayList<Build> mData;
	boolean isfirst = true;
	private int layoutHeight = 0;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		initData();
		initView();
	}

	public void initData() {

		mData = new ArrayList<>();
		mData.add(new Build("北京", "", "", "", "", true));
		mData.add(new Build("", "", "", "", ""));
		mData.add(new Build("", "", "", "", ""));
		mData.add(new Build("", "", "", "", ""));
		mData.add(new Build("", "", "", "", ""));
		mData.add(new Build("", "", "", "", ""));
		mData.add(new Build("", "", "", "", ""));

		mData.add(new Build("贵州", "", "", "", "", true));

		mData.add(new Build("", "", "", "", ""));
		mData.add(new Build("", "", "", "", ""));
		mData.add(new Build("", "", "", "", ""));

		mData.add(new Build("上海", "", "", "", "", true));
		mData.add(new Build("", "", "", "", ""));
		mData.add(new Build("", "", "", "", ""));
		mData.add(new Build("", "", "", "", ""));
		mData.add(new Build("", "", "", "", ""));
		mData.add(new Build("", "", "", "", ""));

	}

	public void initView() {
		mHListView = (HListView) findViewById(R.id.list_view);
		mHListView.setAdapter(new CustomAdapter());
		mHListView.setSelection(4);
	}

	class CustomAdapter extends BaseAdapter {

		@Override
		public int getCount() {

			return mData.size();
		}

		@Override
		public Object getItem(int position) {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public long getItemId(int position) {
			// TODO Auto-generated method stub
			return position;
		}

		@Override
		public int getItemViewType(int position) {

			if (mData.get(position).isHeader) {
				return 0;
			} else {
				return 1;
			}

		}

		@Override
		public int getViewTypeCount() {
			// TODO Auto-generated method stub
			return 2;
		}

		@Override
		public View getView(final int position, View convertView,
				ViewGroup parent) {

			if (convertView == null && getItemViewType(position) == 0) {
				convertView = getLayoutInflater().inflate(
						R.layout.item_type_one, parent, false);
			} else if (convertView == null && getItemViewType(position) == 1) {
				convertView = getLayoutInflater().inflate(
						R.layout.item_type_two, parent, false);
			}

			if (getItemViewType(position) == 0) {

				TextView tv = (TextView) convertView
						.findViewById(R.id.city_name_ch);
				tv.setText(mData.get(position).getBuildName());

			} else {
				final LinearLayout mLayout = (LinearLayout) convertView
						.findViewById(R.id.layout);

				LinearLayout.LayoutParams layoutParams = (LayoutParams) mLayout
						.getLayoutParams();

				layoutHeight = layoutParams.height;
				int w = View.MeasureSpec.makeMeasureSpec(0,
						View.MeasureSpec.UNSPECIFIED);
				int h = View.MeasureSpec.makeMeasureSpec(0,
						View.MeasureSpec.UNSPECIFIED);
				mLayout.measure(w, h);
				int height = mLayout.getMeasuredHeight();
				int width = mLayout.getMeasuredWidth();

				layoutParams.height = height + position * 5;
				mLayout.setLayoutParams(layoutParams);

			}

			return convertView;
		}
	}

}

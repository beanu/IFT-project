package com.beanu.ifthen.ui.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.beanu.ifthen.R;

public class THENAdapter extends BaseAdapter {
	
	private ImageView image;
	private String[] mText;
	private Integer[] mThumbIds;
	private LayoutInflater mlinflater;
	
	public THENAdapter(Context context){
		Integer[] arrayOfInteger = new Integer[3];
		arrayOfInteger[0] = Integer.valueOf(R.drawable.sms);
		arrayOfInteger[1] = Integer.valueOf(R.drawable.call);
		arrayOfInteger[2] = Integer.valueOf(R.drawable.display);
		this.mThumbIds = arrayOfInteger;
		String[] arrayOfString = new String[3];
		arrayOfString[0] = "短信";
		arrayOfString[1] = "打电话";
		arrayOfString[2] = "显示";
		this.mText = arrayOfString;
		this.mlinflater = LayoutInflater.from(context);
		
	}

	public int getCount() {
		return mText.length;
	}

	public Object getItem(int position) {
		return Integer.valueOf(position);
	}

	public long getItemId(int position) {
		return position;
	}

	public View getView(int position, View convertView, ViewGroup parent) {
		if (convertView == null) {
			convertView = mlinflater.inflate(R.layout.trigger_item, null);
			image = ((ImageView) convertView.findViewById(R.id.trigger_item_imageView));
		}

		image.setImageResource(mThumbIds[position]);
		return convertView;
	}

}

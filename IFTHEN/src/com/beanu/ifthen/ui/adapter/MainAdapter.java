package com.beanu.ifthen.ui.adapter;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.beanu.ifthen.R;

/**
 * 显示所有的列表
 * 
 * @author beanu
 * 
 */
public class MainAdapter extends CursorAdapter {

	private LayoutInflater mInflater;

	public MainAdapter(Context context, Cursor c, int flags) {
		super(context, c, flags);
		mInflater = LayoutInflater.from(context);
	}

	@Override
	public void bindView(View view, Context arg1, Cursor cursor) {
		String a = cursor.getString(cursor.getColumnIndex("a"));
		String atype = cursor.getString(cursor.getColumnIndex("atype"));
		String b = cursor.getString(cursor.getColumnIndex("b"));
		String btype = cursor.getString(cursor.getColumnIndex("btype"));

		TextView aText = (TextView) view.findViewById(R.id.textView2);
		TextView bText = (TextView) view.findViewById(R.id.textView4);

		// All.parseFrom(Des.decryptDES(data, Des.KEY));
		aText.setText(atype);
		bText.setText(btype);
	}

	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {
		return mInflater.inflate(R.layout.main_item, parent, false);
	}

}

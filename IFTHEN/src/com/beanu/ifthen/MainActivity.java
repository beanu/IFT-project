package com.beanu.ifthen;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.widget.CursorAdapter;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.ListView;

import com.actionbarsherlock.view.Menu;
import com.beanu.ifthen.application.IFTApplication;
import com.beanu.ifthen.core.BaseActivity;
import com.beanu.ifthen.ui.IFActivity;
import com.beanu.ifthen.ui.adapter.MainAdapter;

public class MainActivity extends BaseActivity {

	private ListView lview;
	private Button addBtn;
	private MainAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		lview = (ListView) findViewById(R.id.main_listView);
		lview.setDivider(null);

		new Handler().post(new Runnable() {
			@Override
			public void run() {
				adapter = new MainAdapter(MainActivity.this,
						((IFTApplication) getApplication()).adapter.getIFTDao()
								.getAllData());
				lview.setAdapter(adapter);

			}
		});

		addBtn = (Button) findViewById(R.id.main_add_button);
		addBtn.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View v) {
				Intent intent = new Intent(MainActivity.this, IFActivity.class);
				startActivity(intent);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getSupportMenuInflater().inflate(R.menu.activity_main, menu);
		return true;
	}

}

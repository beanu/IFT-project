package com.beanu.ifthen.ui;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.beanu.ifthen.R;
import com.beanu.ifthen.ui.IF.ReceiveSmsActivity;
import com.beanu.ifthen.ui.THEN.DisplayActivity;
import com.beanu.ifthen.ui.adapter.THENAdapter;

public class THENActivity extends Activity {
	private GridView trigger_grid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.then_trigger);
		final long triggerId = getIntent().getLongExtra("id", 0);

		trigger_grid = (GridView) findViewById(R.id.then_trigger_gridView);
		trigger_grid.setAdapter(new THENAdapter(this));
		trigger_grid.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = null;

				switch (position) {
				case 0:
					intent = new Intent(THENActivity.this,
							ReceiveSmsActivity.class);
					break;
				case 1:
					// intent=new
					// Intent(ThenTriggerActivity.this,CallActivity.class);
					break;
				case 2:
					intent = new Intent(THENActivity.this,
							DisplayActivity.class);
					break;
				default:
					break;

				}
				if (null != intent) {
					intent.putExtra("triggerId", triggerId);
					// Log.d("triggerId:"+triggerId);
					startActivity(intent);
				}
			}
		});
	}

}

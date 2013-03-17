package com.beanu.ifthen.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

import com.beanu.ifthen.R;
import com.beanu.ifthen.core.BaseActivity;
import com.beanu.ifthen.ui.IF.ReceiveSmsActivity;
import com.beanu.ifthen.ui.adapter.IFAdapter;

/**
 * 第一步 IF
 * 
 * @author beanu
 * 
 */
public class IFActivity extends BaseActivity {
	private GridView trigger_grid;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.if_trigger);

		trigger_grid = (GridView) findViewById(R.id.if_trigger_gridView);
		trigger_grid.setAdapter(new IFAdapter(this));
		trigger_grid.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> parent, View view,
					int position, long id) {
				Intent intent = null;

				switch (position) {
				case 0:
					intent = new Intent(IFActivity.this,
							ReceiveSmsActivity.class);
					break;
				// case 1:
				// intent=new
				// Intent(IfTriggerActivity.this,MissedCallActivity.class);
				// break;
				// case 2:
				// intent=new
				// Intent(IfTriggerActivity.this,DisplayActivity.class);
				// break;
				// case 3:
				// intent=new
				// Intent(IfTriggerActivity.this,SensorsActivity.class);
				// break;
				// case 4:
				// intent=new Intent(IfTriggerActivity.this,LBSActivity.class);
				// break;
				default:
					break;
				}
				if (null != intent)
					startActivity(intent);
			}
		});
	}

}

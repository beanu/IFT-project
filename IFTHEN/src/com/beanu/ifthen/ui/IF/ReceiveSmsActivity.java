package com.beanu.ifthen.ui.IF;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.beanu.ifthen.R;
import com.beanu.ifthen.core.BaseActivity;
import com.beanu.ifthen.ui.THENActivity;

public class ReceiveSmsActivity extends BaseActivity {
	private EditText txt_sender;
	private EditText txt_hashtag;
	private Button btn;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.reveiversms);

		txt_sender = (EditText) findViewById(R.id.txt_sender);
		txt_hashtag = (EditText) findViewById(R.id.txt_hashtag);

		btn = (Button) findViewById(R.id.btn);
		btn.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {
				// Trigger tri =
				// Dao.instance.createTri(ReceiveSms.class.getName());
				// tri = tri
				// .toBuilder()
				// .setReceiveSms(
				// ReceiveSms.newBuilder().setSender(txt_sender.getText().toString())
				// .setHashtag(txt_hashtag.getText().toString()).build())
				// .setIntent(Sms.class.getName()).build();
				// Dao.instance.saveTri(tri);
				//
				// Helper.addObserver(new ObserverSmsReceive(tri.getId(),
				// SubjectSmsReceive.getInstance()));
				//
				Intent intent = new Intent(ReceiveSmsActivity.this,
						THENActivity.class);
				// intent.putExtra("triggerId", tri.getId());
				startActivity(intent);
			}
		});

	}
}

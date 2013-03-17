package com.beanu.ifthen.ui.IF;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.beanu.ifthen.R;
import com.beanu.ifthen.bean.DBItem;
import com.beanu.ifthen.bean.IFTBean.AReceiveSms;
import com.beanu.ifthen.bean.IFTBean.Sms;
import com.beanu.ifthen.core.BaseActivity;
import com.beanu.ifthen.cryption.Des;
import com.beanu.ifthen.dao.Dao;
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
				DBItem item = new DBItem();
				item.setId(System.currentTimeMillis());
				item.setaType(AReceiveSms.class.getName());
				item.setContent(Sms.class.getName());

				AReceiveSms ars = AReceiveSms.newBuilder()
						.setSender(txt_sender.getText().toString())
						.setHashTag(txt_hashtag.getText().toString()).build();
				item.setA(Des.encryptDES(ars.toByteArray(), Des.KEY));
				Dao.instance.saveDBItem(item);

				Intent intent = new Intent(ReceiveSmsActivity.this,
						THENActivity.class);
				intent.putExtra("id", item.getId());
				startActivity(intent);
			}
		});

	}
}

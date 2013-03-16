package com.beanu.ifthen.ui.THEN;

import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.beanu.ifthen.R;
import com.beanu.ifthen.core.BaseActivity;

public class DisplayActivity extends BaseActivity {
	private EditText editText_display;
	private Spinner spinner;
	private ArrayAdapter<String> adapter;
	private Button btn_ok;

	// Trigger tri;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.display);
		// tri=Dao.instance.getTrigger(getIntent().getLongExtra("triggerId",
		// 0));

		// class name
		// String intent=tri.getIntent();

		btn_ok = (Button) findViewById(R.id.btn_ok);
		editText_display = (EditText) findViewById(R.id.editText_display);
		spinner = (Spinner) findViewById(R.id.spinner_info);
		// 下拉列表
		// 第一步：添加一个下拉列表项的list，这里添加的项就是下拉列表的菜单项
		// List<String> list=new ArrayList<String>();
		// try {
		// Class<?> cls=Class.forName(intent);
		// Field[] f=cls.getDeclaredFields();
		// for(int i=0;i<f.length;i++){
		// if(f[i].getName().endsWith("_") &&
		// !f[i].getName().equals("bitField0_")){
		// String name=f[i].getName();
		// name=name.substring(0, name.length()-1);
		// name=name.substring(0,1).toUpperCase()+name.substring(1);
		// list.add(name);
		// }
		// }
		// } catch (ClassNotFoundException e) {
		// e.printStackTrace();
		// }

		// 第二步：为下拉列表定义一个适配器，这里就用到里前面定义的list。
		// adapter = new
		// ArrayAdapter<String>(this,android.R.layout.simple_spinner_item,
		// list);
		// 第三步：为适配器设置下拉列表下拉时的菜单样式。
		adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
		// 第四步：将适配器添加到下拉列表上
		spinner.setAdapter(adapter);
		// 第五步：为下拉列表设置各种事件的响应，这个事响应菜单被选中
		spinner.setOnItemSelectedListener(new OnItemSelectedListener() {

			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				editText_display.setText(editText_display.getText().toString()
						+ "#" + adapter.getItem(arg2) + "#");
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}

		});

		btn_ok.setOnClickListener(new OnClickListener() {

			public void onClick(View v) {

				// Dao.instance.getTriggerBuilder(tri).setDisplay(
				// Display.newBuilder()
				// .setContent(editText_display.getText().toString()).build()).setThen(Display.class.getName());
				// Dao.instance.buildAll();

				// Intent intent=new Intent(DisplayActivity.this,Main.class);
				// startActivity(intent);
			}
		});

	}
}

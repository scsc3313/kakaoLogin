package com.kakao.sample.kakaotalk;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class CheckingkActivity extends Activity {
	
	EditText editName, editAge, editArea;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_checking);
		getPreferences();
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		
		editName = (EditText) findViewById(R.id.editName);
		editAge = (EditText) findViewById(R.id.editAge);		
		editArea = (EditText) findViewById(R.id.editArea);
		editName.setText(pref.getString("name", ""));
		editAge.setText(pref.getString("age", ""));
		editArea.setText(pref.getString("area", ""));
		
		Button passBtn = (Button) findViewById(R.id.pass);
		passBtn.setOnClickListener(passOnclickListener);
		
		Button closeBtn = (Button) findViewById(R.id.close);
		closeBtn.setOnClickListener(closeOnclickListener);
		
	}
	
	Button.OnClickListener passOnclickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
			final Intent intent = new Intent(CheckingkActivity.this, KakaoTalkMainActivity.class);
	        intent.putExtra("name", editName.getText().toString());
	        intent.putExtra("age", editAge.getText().toString());
	        intent.putExtra("area", editArea.getText().toString());
	        savePreferences();
			startActivity(intent);
	        finish();
		}
	};
	
	Button.OnClickListener closeOnclickListener = new View.OnClickListener() {
		@Override
		public void onClick(View v) {
	        finish();
		}
	};
	
	private void getPreferences(){
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		pref.getString("name", "");
		pref.getString("age", "");
		pref.getString("area", "");
	}
	
	private void savePreferences(){
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.putString("name", editName.getText().toString());
		editor.putString("age", editAge.getText().toString());
		editor.putString("area", editArea.getText().toString());
		editor.commit();
	}
	
	private void removePreferences(){
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.remove("name");
		editor.remove("age");
		editor.remove("area");
		editor.commit();
	}
	
	private void removeAllPreferences(){
		SharedPreferences pref = getSharedPreferences("pref", MODE_PRIVATE);
		SharedPreferences.Editor editor = pref.edit();
		editor.clear();
		editor.commit();
	}
	
	

	
    
}

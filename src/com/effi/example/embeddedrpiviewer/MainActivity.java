package com.effi.example.embeddedrpiviewer;

import java.util.ArrayList;
import java.util.UUID;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		final EditText editText1 = (EditText) findViewById(R.id.editText1);
		Button button1 = (Button) findViewById(R.id.button1);
		button1.setOnClickListener(new OnClickListener() {
			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent("pl.effisoft.rpicamviewer2.PREVIEW");
				int camera =0;
				
				//--------- Basic settings
				intent.putExtra("full_screen", true);
				
				intent.putExtra("name"+camera, "My pipeline name");
				intent.putExtra("host"+camera, "192.168.0.1");
				intent.putExtra("port"+camera, 5000);
				intent.putExtra("description"+camera, "My pipeline description");
				intent.putExtra("uuid"+camera, UUID.randomUUID().toString() );
				intent.putExtra("aspectRatio"+camera, 1.6);
				intent.putExtra("autoplay"+camera, true);
				
				//--------- Enable advanced mode
				intent.putExtra("advanced"+camera, true);
				intent.putExtra("custom_pipeline"+camera, editText1.getText().toString());
				
				//--------- Enable application extra features
				intent.putExtra("extraFeaturesEnabled"+camera, false);
				
				//--------- Add autoaudiosink to featured pipeline
				intent.putExtra("extraFeaturesSoundEnabled"+camera, false);
				
				//--------- Scale Video Stream option
				intent.putExtra("extraResizeVideoEnabled"+camera, false);
				intent.putExtra("width"+camera, 320);
				intent.putExtra("height"+camera, 200);
				
				//--------- Add plugins
				ArrayList<String> plugins = new ArrayList<String>();
				intent.putExtra("plugins"+camera, plugins);
				
				intent.setPackage("pl.effisoft.rpicamviewer2");
		        startActivityForResult(intent, 0);
			}
		});
	}

	public void onActivityResult(int requestCode, int resultCode, Intent intent) {
	    if (requestCode == 0) {
	        if (resultCode == RESULT_OK) {

	        } else if (resultCode == RESULT_CANCELED) {

	        }
	    }
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}

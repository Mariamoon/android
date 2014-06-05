package com.greeting;

import java.io.IOException;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.CookieStore;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.client.protocol.ClientContext;
import org.apache.http.impl.client.BasicCookieStore;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.protocol.BasicHttpContext;
import org.apache.http.protocol.HttpContext;
import org.apache.http.util.EntityUtils;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends ActionBarActivity {
	TextView tvOut;
	Button btn_9;
//	RegisterUser ru;
	Activity act;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);
		tvOut = (TextView) findViewById(R.id.tvOut);
		btn_9 = (Button) findViewById(R.id.btn_9);
		act = this;
		OnClickListener oclBtn = new OnClickListener() {
			@Override
			public void onClick(View v) {
				
//				ru = new RegisterUser(act);
//				ru.execute (); 
//				
				switch (v.getId()) {
				case R.id.btn_9:
					RegisterUser longOp = new RegisterUser(act);
					longOp.execute();
					break;

				
		}
	}
};
			btn_9.setOnClickListener(oclBtn);
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

	/**
	 * A placeholder fragment containing a simple view.
	 */
	public static class PlaceholderFragment extends Fragment {

		public PlaceholderFragment() {
		}

		@Override
		public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,false);
			return rootView;
		}
	}
	
	
	public class RegisterUser extends AsyncTask<String[], Integer, String> {
		private Activity ctx;
		private String[] preferences;
		private boolean close = false;
		private ProgressDialog dialog;
		private Dialog dlg;
		
		public RegisterUser(Activity myCtx) {
			ctx = myCtx;
			
		}

		protected void onPreExecute() {
		}

		@Override
		// params comes from the execute() call: params[0] What i've passed.
		protected String doInBackground(String[]... arg0) {

			HttpClient httpclient = new DefaultHttpClient();
			CookieStore cookieStore = new BasicCookieStore();
			HttpContext httpContext = new BasicHttpContext();
			httpContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);

			
			HttpGet site = new HttpGet("http://konstructor.pro/cgi-bin/demo.py");
			
			site.addHeader("accept", "application/json");
			try {
				//получаем сессию
				HttpResponse response = httpclient.execute(site, httpContext);
				HttpEntity entity = response.getEntity();
				String res = EntityUtils.toString(entity);
				
				
				//анализируем чего там пришло
				if (res.equals("")){
					return "Fail";
				}
				try {
					JSONObject mJson = new JSONObject(res);
					mJson.toString();
					String result = mJson.getString("advice");
						return result;
				} catch (JSONException jex) {
					return "Fail";
				}

			} catch (IOException ioex) {
				// Ответим что ошибка соединения с сервером
				return "NetError";
			}

		}

		protected void onPostExecute(String result) {

			dialog.dismiss();
			//это то, что ответит нам сервер
			tvOut.setText(result);

			super.onPostExecute(result);
			

		}

	}

	}

	
	



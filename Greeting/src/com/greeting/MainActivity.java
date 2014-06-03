package com.greeting;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
import android.app.AlertDialog;
import android.app.Dialog;
import android.app.ProgressDialog;
import android.content.DialogInterface;
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
					tvOut.setText("�����");
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
		public View onCreateView(LayoutInflater inflater, ViewGroup container,
				Bundle savedInstanceState) {
			View rootView = inflater.inflate(R.layout.fragment_main, container,
					false);
			return rootView;
		}
	}
	
	
//	public class RegisterUser extends AsyncTask<String[], Integer, String> {
//		private Activity ctx;
//		private String[] preferences;
//		private boolean close = false;
//		private ProgressDialog dialog;
//		private Dialog dlg;
//		
//		public RegisterUser(Activity myCtx) {
//			ctx = myCtx;
//			
//		}
//
//		protected void onPreExecute() {
//		}
//
//		@Override
//		// params comes from the execute() call: params[0] What i've passed.
//		protected String doInBackground(String[]... arg0) {
//			String[] params;
//			if (arg0[0] instanceof String[]) {
//				params = (String[]) arg0[0];
//				preferences = params;
//			} else {
//				params = null;
//			}
//
//			HttpClient httpclient = new DefaultHttpClient();
//			CookieStore cookieStore = new BasicCookieStore();
//			HttpContext httpContext = new BasicHttpContext();
//			httpContext.setAttribute(ClientContext.COOKIE_STORE, cookieStore);
//
//			HttpGet start = new HttpGet(Constants.MAIN_URL+Constants.REGISTRATION);
//			String registrationURL = Constants.MAIN_URL + Constants.REGISTRATION_MODULE+Constants.USER_REGISTRATION_METHOD;
//			
//			for (String item:params){
//				registrationURL+=Constants.REGISTRATION_PARAM_PREFIX+item;
//			}
//			for (int i=0;i<6;i++){
//				registrationURL+=Constants.REGISTRATION_PARAM_PREFIX+"";
//			}
//			HttpGet register = new HttpGet(registrationURL);
//			
//			register.addHeader("accept", "application/json");
//			try {
//				//получаем сессию
//			HttpResponse response = httpclient.execute(start, httpContext);
//				HttpEntity entity = response.getEntity();
//				String res = EntityUtils.toString(entity);
//				
//				пробуем зарегистрироваться
//				response = httpclient.execute(register, httpContext);
//				entity = response.getEntity();
//				res = EntityUtils.toString(entity);
//				
//				//анализируем чего там пришло
//				if (res.equals("")){
//					return ctx.getString(R.string.regFail);
//				}
//				try {
//					JSONObject mJson = new JSONObject(res);
//					mJson.toString();
//					String result = mJson.getString("error");
//					if (result.equals("")) {
//						return ctx.getString(R.string.regSucsess);
//					}else{
//						return result;
//					}
//				} catch (JSONException jex) {
//					// Тоже ответить что проблема соединения с сервером
//					return ctx.getString(R.string.regNetError);
//				}
//
//			} catch (IOException ioex) {
//				// Ответим что ошибка соединения с сервером
//				return ctx.getString(R.string.regNetError);
//			}
//
//		}
//
//		protected void onPostExecute(String result) {
//
//			dialog.dismiss();
//			if (result.equals(ctx.getString(R.string.regNetError))
//					|| result.equals(ctx.getString(R.string.userExist))) {
//				Utils.clearUser(ctx);
//			} else if (result.equals(ctx.getString(R.string.regSucsess))) {
//				Utils.saveUser(preferences[0], preferences[1],ctx);
//				this.callback.onAuthorized();
//				dlg.dismiss();
//			}
//
//			AlertDialog.Builder builder = new AlertDialog.Builder(ctx);
//			// Add the buttons
//			builder.setPositiveButton(	R.string.regOK,
//										new DialogInterface.OnClickListener() {
//											public void onClick(DialogInterface dialog,
//																int id) {
////												// User clicked OK button
////												if (close) {
////													
////												}
//											}
//										});
//			builder.setMessage(result);
//			// Create the AlertDialog
//			AlertDialog dialog = builder.create();
//			dialog.show();
//
//			super.onPostExecute(result);
//			
//
//		}



	}

	
	



package com.example.bab1prakmc2_1;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;

public class MainActivity extends Activity {
	TextView output;
    String strJson = 
			  "{ " +
					  "\"Employee\" :[" +
					  "{" +
					  		"\"id\":\"01\"," +
					  		"\"name\":\"Joko Widodo\"," +
					  		"\"salary\":\"500000\" " +
					   "}," +
					   "{" +
					   		"\"id\":\"02\"," +
					   		" \"name\":\"Susilo Bambang Yudoyono\"," +
					   		"\"salary\":\"500000\" " +
					   	"}," +
					   	"{" +
					   		"\"id\":\"03\"," +
					   		"\"name\":\"Megawati Soekarnoputri\", " +
					   		"\"salary\":\"600000\" " +
					   	"} " +
					   	"]" +
			    "}";
	  
	String data = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		output = (TextView) findViewById(R.id.output);
		try {
			JSONObject jsonObject = new JSONObject(strJson);
			JSONArray jsonArray = jsonObject.getJSONArray("Employee");

			for (int i = 0; i < jsonArray.length(); i++) {
				JSONObject jsonObject2 = jsonArray.getJSONObject(i);
				int id = Integer.parseInt(jsonObject2.optString("id")
						.toString());
				String name = jsonObject2.optString("name").toString();
				float salary = Float.parseFloat(jsonObject2.optString("salary")
						.toString());
				data += "Urutan ke-" + i + "\n " 
						+ "Id = " + id + "\n"
						+ "Nama = " + name + "\n" 
						+ "Gaji =" + salary + "\n";
			}
			output.setText(data);
		} catch (JSONException e) {
			e.printStackTrace();
		}
	}
}

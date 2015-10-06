package ca.ualberta.cs.lonelytwitter;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class LonelyTwitterActivity extends Activity implements MyObserver{

	private static final String FILENAME = "file.sav";//move to model
	private EditText bodyText;//move to model
	private ListView oldTweetsList;//move to model
	private ArrayList<Tweet> tweets = new ArrayList<Tweet>();//move to model
	private ArrayAdapter<Tweet> adapter;//move to model


	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {//all

		super.onCreate(savedInstanceState);//move to view
		setContentView(R.layout.main);//move to view

		bodyText = (EditText) findViewById(R.id.body);//move to view
		Button saveButton = (Button) findViewById(R.id.save);//move to view
		oldTweetsList = (ListView) findViewById(R.id.oldTweetsList);//move to view

		saveButton.setOnClickListener(new View.OnClickListener() {

			public void onClick(View v) {
				setResult(RESULT_OK);
				String text = bodyText.getText().toString();//move to controller
				tweets.add(new NormalTweet(text));//move to controller
				saveInFile();//move to model
				adapter.notifyDataSetChanged();//move to model
			}
		});
	}

	@Override
	protected void onStart() {//model
		// TODO Auto-generated method stub
		super.onStart();
		loadFromFile();//move to model
		adapter = new ArrayAdapter<Tweet>(this, R.layout.list_item, tweets);//move to model
		oldTweetsList.setAdapter(adapter);//move to model
	}

	private void loadFromFile() {//move to model
		ArrayList<Tweet> tweets = new ArrayList<Tweet>();//move to model
		try {
			FileInputStream fis = openFileInput(FILENAME);//move to model
			BufferedReader in = new BufferedReader(new InputStreamReader(fis));//move to model
			Gson gson = new Gson();//move to model
			Type listType = new TypeToken<ArrayList<NormalTweet>>() {}.getType();//move to model
			this.tweets = gson.fromJson(in, listType);//move to model

		} catch (FileNotFoundException e) {//move to model
			// TODO Auto-generated catch block
			tweets = new ArrayList<Tweet>();//move to model
		} catch (IOException e) {//move to model
			// TODO Auto-generated catch block
			throw new RuntimeException(e);//move to model
		}
	}
	
	private void saveInFile() {//move to model
		try {
			FileOutputStream fos = openFileOutput(FILENAME, 0);//move to model
			OutputStreamWriter writer = new OutputStreamWriter(fos);//move to model
			Gson gson = new Gson();//move to model
			gson.toJson(tweets, writer);//move to model
			writer.flush();//move to model
			fos.close();//move to model
		} catch (FileNotFoundException e) {//move to model
			// TODO Auto-generated catch block
			throw new RuntimeException(e);//move to model
		} catch (IOException e) {//move to model
			// TODO Auto-generated catch block
			throw new RuntimeException(e);//move to model
		}
	}

	public void myNotify(MyObservable observable) {
		adapter.notifyDataSetChanged();//move to model
	}
}
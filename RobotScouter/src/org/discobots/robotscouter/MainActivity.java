package org.discobots.robotscouter;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.discobots.robotscouter.R;
import org.discobots.robotscouter.data.Robot;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MenuItem.OnMenuItemClickListener;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	ArrayList<Robot> robots;
	ArrayAdapter<Robot> adapter;
	
	public MainActivity() {
		super();
		this.robots = new ArrayList<Robot>();
		System.out.println(robots.size());
	}
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		
		final MainActivity instance = this;
		ListView listview = (ListView) findViewById(R.id.listView1);
		listview.setVerticalScrollBarEnabled(true);
		
		adapter = new ArrayAdapter<Robot>(this,
				android.R.layout.simple_list_item_1, robots);
		listview.setAdapter(adapter);
		listview.setOnItemClickListener(new AdapterView.OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, final View view,
					int position, long id) {
				System.out.println(robots.size());
				final Robot item = (Robot) (parent.getItemAtPosition(position));
				openPreScoutingActivity(item);
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.team_management, menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void openPreScoutingActivity(Robot item) {;
		Intent intent = new Intent(this, PreScoutingActivity.class);
		intent.putExtra(PreScoutingActivity.ROBOT_DATA, item);
		startActivity(intent);
	}
	
	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
	    // Handle item selection
	    switch (item.getItemId()) {
	        case R.id.add_team:
	        	Robot r = new Robot();
	        	this.adapter.add(r);
	        	System.out.println(this.robots.size());
	            openPreScoutingActivity(r);
	            return true;
	        case R.id.action_settings:
	            // DO SOMETHING
	            return true;
	        default:
	            return super.onOptionsItemSelected(item);
	    }
	}
	
}

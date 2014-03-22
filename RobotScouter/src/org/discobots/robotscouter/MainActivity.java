package org.discobots.robotscouter;

import java.util.ArrayList;
import java.util.logging.Logger;

import org.discobots.robotscouter.R;
import org.discobots.robotscouter.data.Robot;

import android.os.Bundle;
import android.app.Activity;
import android.content.Intent;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class MainActivity extends Activity {

	String[] contextMenuItems = { "Edit", "Delete" };
	ArrayList<Robot> robots;
	ArrayAdapter<Robot> adapter;
	boolean deletionMode = false;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main); // Content UI stuff

		this.robots = new ArrayList<Robot>(); // Robot Data

		final MainActivity instance = this; // UI List stuff
		ListView listview = (ListView) findViewById(R.id.listView1);
		listview.setVerticalScrollBarEnabled(true);
		this.registerForContextMenu(listview);
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
	public boolean onCreateOptionsMenu(Menu menu) { // Action bar creator
		getMenuInflater().inflate(R.menu.team_management, menu);
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	public void onCreateContextMenu(ContextMenu menu, View v,
			ContextMenuInfo menuInfo) {
		if (v.getId() == R.id.listView1) {
			AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) menuInfo;
			menu.setHeaderTitle("Options");
			String[] menuItems = contextMenuItems;
			for (int i = 0; i < menuItems.length; i++) {
				menu.add(Menu.NONE, i, i, menuItems[i]);
			}
		}
	}

	public boolean onContextItemSelected(MenuItem item) {
		AdapterView.AdapterContextMenuInfo info = (AdapterView.AdapterContextMenuInfo) item
				.getMenuInfo();
		int menuItemIndex = item.getItemId();
		String[] menuItems = contextMenuItems;
		String menuItemName = menuItems[menuItemIndex];
		Robot r = this.robots.get(info.position);
		if (menuItemName.equalsIgnoreCase(contextMenuItems[0])) {
			openPreScoutingActivity(r);
		} else if (menuItemName.equalsIgnoreCase(contextMenuItems[1])) {
			this.adapter.remove(r);
		} 

		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) { // Action bar listener
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

	public void openPreScoutingActivity(Robot item) {
		Intent intent = new Intent(this, PreScoutingActivity.class);
		intent.putExtra(PreScoutingActivity.ROBOT_DATA, item);
		startActivity(intent);
	}

}

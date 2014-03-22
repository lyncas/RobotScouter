package org.discobots.robotscouter;

import org.discobots.robotscouter.data.Robot;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;

public class PreScoutingActivity extends Activity {
	
	public static final String ROBOT_DATA = "PRESCOUTINGACTIVITY_ROBOTDATA_546874321684";
	
	public PreScoutingActivity() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
	    super.onCreate(savedInstanceState);
        setContentView(R.layout.activty_prescouting);
	}
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

}

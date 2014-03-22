package org.discobots.robotscouter.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Robot implements Serializable {
	private static final long serialVersionUID = 987653754962438491L;

	private int teamNumber;
	private String teamName;
	private boolean autonMobility;
	private boolean autonOneBall;
	private boolean autonTwoBall;
	private boolean autonThreeBall;
	private int autonPointsScorable;
	private boolean autonVision;
	
	public Robot() {
		teamNumber = 0000;
	}
	
	public Robot(int teamNumber) {
		this.teamNumber = teamNumber;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.write(teamNumber);
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		this.teamNumber = in.readInt();
	}
	
	public String toString() {
		return "" + teamNumber;
	}
}

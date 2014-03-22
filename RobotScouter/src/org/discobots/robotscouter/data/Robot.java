package org.discobots.robotscouter.data;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;

public class Robot implements Serializable {
	private static final long serialVersionUID = 987653754962438491L;

	private int teamNumber;
	private String teamName;
	
	private String robotDriveType;
	private String robotBumperQuality;
	public static final String robotBumperQuality_GOOD = "GOOD";
	public static final String robotBumperQuality_NEUTRAL = "NEUTRAL";
	public static final String robotBumperQuality_BAD = "BAD";
	private boolean robotIntakeGround;
	private boolean robotCatch;
	private boolean robotOuttakeGround;
	private boolean robotLaunch;
	
	private boolean autonMobility;
	private boolean autonOneBall;
	private boolean autonTwoBall;
	private boolean autonThreeBall;
	private int autonPointsScorable;
	private boolean autonVsetion;
	private String autonLocation;
	public static final String autonLocation_RIGHT = "RIGHT";
	public static final String autonLocation_CENTER = "CENTER";
	public static final String autonLocation_LEFT = "LEFT";
	
	private boolean teleopOffensive;
	private boolean teleopDefensive;
	private boolean teleopBlockHighGoal;
	private boolean teleopBlockLowGoal;
	private boolean teleopPushRobots;
	private String teleopZonePreference;
	public static final String teleopZonePreference_BACK = "BACK";
	public static final String teleopZonePreference_MIDDLE = "MIDDLE";
	public static final String teleopZonePreference_GOAL = "GOAL";
	
	public Robot() {
		teamNumber = 0000;
	}
	
	public Robot(int teamNumber) {
		this.teamNumber = teamNumber;
	}

	public int getTeamNumber() {
		return teamNumber;
	}

	public void setTeamNumber(int teamNumber) {
		this.teamNumber = teamNumber;
	}

	public String getTeamName() {
		return teamName;
	}

	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}

	public String getRobotDriveType() {
		return robotDriveType;
	}

	public void setRobotDriveType(String robotDriveType) {
		this.robotDriveType = robotDriveType;
	}

	public String getRobotBumperQuality() {
		return robotBumperQuality;
	}

	public void setRobotBumperQuality(String robotBumperQuality) {
		this.robotBumperQuality = robotBumperQuality;
	}

	public boolean setRobotIntakeGround() {
		return robotIntakeGround;
	}

	public void setRobotIntakeGround(boolean robotIntakeGround) {
		this.robotIntakeGround = robotIntakeGround;
	}

	public boolean setRobotCatch() {
		return robotCatch;
	}

	public void setRobotCatch(boolean robotCatch) {
		this.robotCatch = robotCatch;
	}

	public boolean setRobotOuttakeGround() {
		return robotOuttakeGround;
	}

	public void setRobotOuttakeGround(boolean robotOuttakeGround) {
		this.robotOuttakeGround = robotOuttakeGround;
	}

	public boolean setRobotLaunch() {
		return robotLaunch;
	}

	public void setRobotLaunch(boolean robotLaunch) {
		this.robotLaunch = robotLaunch;
	}

	public boolean setAutonMobility() {
		return autonMobility;
	}

	public void setAutonMobility(boolean autonMobility) {
		this.autonMobility = autonMobility;
	}

	public boolean setAutonOneBall() {
		return autonOneBall;
	}

	public void setAutonOneBall(boolean autonOneBall) {
		this.autonOneBall = autonOneBall;
	}

	public boolean setAutonTwoBall() {
		return autonTwoBall;
	}

	public void setAutonTwoBall(boolean autonTwoBall) {
		this.autonTwoBall = autonTwoBall;
	}

	public boolean setAutonThreeBall() {
		return autonThreeBall;
	}

	public void setAutonThreeBall(boolean autonThreeBall) {
		this.autonThreeBall = autonThreeBall;
	}

	public int getAutonPointsScorable() {
		return autonPointsScorable;
	}

	public void setAutonPointsScorable(int autonPointsScorable) {
		this.autonPointsScorable = autonPointsScorable;
	}

	public boolean setAutonVsetion() {
		return autonVsetion;
	}

	public void setAutonVsetion(boolean autonVsetion) {
		this.autonVsetion = autonVsetion;
	}

	public String getAutonLocation() {
		return autonLocation;
	}

	public void setAutonLocation(String autonLocation) {
		this.autonLocation = autonLocation;
	}

	public boolean setTeleopOffensive() {
		return teleopOffensive;
	}

	public void setTeleopOffensive(boolean teleopOffensive) {
		this.teleopOffensive = teleopOffensive;
	}

	public boolean setTeleopDefensive() {
		return teleopDefensive;
	}

	public void setTeleopDefensive(boolean teleopDefensive) {
		this.teleopDefensive = teleopDefensive;
	}

	public boolean setTeleopBlockHighGoal() {
		return teleopBlockHighGoal;
	}

	public void setTeleopBlockHighGoal(boolean teleopBlockHighGoal) {
		this.teleopBlockHighGoal = teleopBlockHighGoal;
	}

	public boolean setTeleopBlockLowGoal() {
		return teleopBlockLowGoal;
	}

	public void setTeleopBlockLowGoal(boolean teleopBlockLowGoal) {
		this.teleopBlockLowGoal = teleopBlockLowGoal;
	}

	public boolean setTeleopPushRobots() {
		return teleopPushRobots;
	}

	public void setTeleopPushRobots(boolean teleopPushRobots) {
		this.teleopPushRobots = teleopPushRobots;
	}

	public String getTeleopZonePreference() {
		return teleopZonePreference;
	}

	public void setTeleopZonePreference(String teleopZonePreference) {
		this.teleopZonePreference = teleopZonePreference;
	}

	private void writeObject(ObjectOutputStream out) throws IOException {
		out.write(teamNumber);
		if (this.teamName != null) {
			out.writeChars(teamName);
		}
	}

	private void readObject(ObjectInputStream in) throws IOException, ClassNotFoundException {
		this.teamNumber = in.readInt();
	}
	
	public String toString() {
		return "" + teamNumber + (teamName != null ? teamName : "");
	}
}

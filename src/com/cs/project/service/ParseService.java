package com.cs.project.service;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ParseService {

	public static final String RESOURCE_REGEX = "Resources are (.*) meters away";
	public static final String ENEMY_REGEX = "(.*) is Enemy";
	public static final String HEALTH_POWER_REGEX = "has (.*) hp";
	public static final String ATTACK_REGEX = "attack is (.*)";
	public static final String POSITION_REGEX = "at position (.*)";

	private ParseService() {

	}

	/**
	 * 
	 * @param buffer
	 * @return
	 */
	public static int getResource(String buffer) {
		int result = 0;
		Pattern r = Pattern.compile(RESOURCE_REGEX);
		Matcher m = r.matcher(buffer);
		if (m.find()) {
			result = Integer.parseInt(m.group(1));
		}

		return result;
	}

	/**
	 * 
	 * @param buffer
	 * @return
	 */
	public static ArrayList<String> getEnemy(String buffer) {
		ArrayList<String> result = new ArrayList<>();
		Pattern r = Pattern.compile(ENEMY_REGEX);
		Matcher m = r.matcher(buffer);
		while (m.find()) {
			result.add(m.group(1));
		}
		return result;

	}

	/**
	 * 
	 * @param name
	 * @param buffer
	 * @return
	 */
	public static int getEnemyHealthPower(String name, String buffer) {
		int result = 0;
		Pattern r = Pattern.compile(name + " " + HEALTH_POWER_REGEX);
		Matcher m = r.matcher(buffer);
		if (m.find()) {
			result = Integer.parseInt(m.group(1));
		}

		return result;
	}

	/**
	 * 
	 * @param name
	 * @param buffer
	 * @return
	 */
	public static int getEnemyAttackPower(String name, String buffer) {
		int result = 0;
		Pattern r = Pattern.compile(name + " " + ATTACK_REGEX);
		Matcher m = r.matcher(buffer);
		if (m.find()) {
			result = Integer.parseInt(m.group(1));
		}

		return result;
	}

	/**
	 * 
	 * @param name
	 * @param buffer
	 * @return
	 */
	public static ArrayList<Integer> getEnemyPosition(String name, String buffer) {
		ArrayList<Integer> result = new ArrayList<>();
		Pattern r = Pattern.compile(name + " " + POSITION_REGEX);
		Matcher m = r.matcher(buffer);
		while (m.find()) {
			result.add(Integer.parseInt(m.group(1)));
		}

		return result;
	}

}

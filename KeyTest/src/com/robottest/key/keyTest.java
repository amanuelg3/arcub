package com.robottest.key;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class keyTest {

	/**
	 * @param args
	 */
	private static void keyPressWithShift(Robot robot, int keyValue) {
		robot.keyPress(KeyEvent.VK_SHIFT);
		robot.keyPress(keyValue);
		robot.keyRelease(keyValue);
		robot.keyRelease(KeyEvent.VK_SHIFT);
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Robot robot = new Robot();
			Runtime.getRuntime().exec("notepad");
			robot.delay(1000);
			// Robot write "Hello World"
			keyPressWithShift(robot, KeyEvent.VK_H);
			robot.keyPress(KeyEvent.VK_E);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_L);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_L);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_O);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.delay(1000);
			keyPressWithShift(robot, KeyEvent.VK_W);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_O);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_R);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_L);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_D);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_PERIOD);

		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

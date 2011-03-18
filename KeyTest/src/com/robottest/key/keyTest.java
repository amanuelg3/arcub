package com.robottest.key;

import java.awt.AWTException;
import java.awt.Robot;
import java.awt.event.KeyEvent;
import java.io.IOException;


public class keyTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			Robot robot = new Robot();
			Runtime.getRuntime().exec("notepad");

			// Robot write
			robot.keyPress(KeyEvent.VK_D);
			robot.delay(100);
			robot.keyPress(KeyEvent.VK_LEFT);
			robot.delay(2000);
			robot.keyPress(KeyEvent.VK_SPACE);
			robot.keyPress(KeyEvent.VK_H);
			robot.keyPress(KeyEvent.VK_I);
			robot.delay(1000);

		} catch (AWTException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}


	}

}

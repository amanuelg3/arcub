package com.robottest.mouse;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.Robot;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import java.io.InputStreamReader;

public class mouseTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// Read move event file, and simulate the mouse move
		File mm = new File("resources/mouseMoveEvent");
		Point mousePoint;
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(mm)));
			String line;
			Robot robot = new Robot();
			robot.delay(1000);
			while ((line = br.readLine()) != null) {
				/*
				 * Direction definition
				 *               North(2)  
				 *                 |
				 *     West(3) --     -- East(1)
				 *                 |
				 *               South(4)   
				 *            
				 * 1 East
				 * 2 North
				 * 3 West
				 * 4 South
				 * 21 NorthEast
				 * 23 NorthWest
				 * 43 SouthWest
				 * 41 SouthEast
				 */
				// Get the direction and distance
				String dire = line.substring(0, line.indexOf(","));				
				String dist = line.substring(line.indexOf(",") + 1, line.length());
				Integer di = new Integer(dire);
				Integer dis = new Integer(dist);
				//System.out.println("Direction :" + di + "  Distance :" + dis);
				mousePoint = MouseInfo.getPointerInfo().getLocation();
				System.out.println("Now mouse at X=" + mousePoint.x + "  Y=" + mousePoint.y);
				System.out.println("move Direction :" + di + "  Distance :" + dis);
				switch (di) {				
				case 1 : // East
					robot.mouseMove(mousePoint.x + dis, mousePoint.y);
					break;
				case 2 : // North
					robot.mouseMove(mousePoint.x, mousePoint.y + dis);
					break;
				case 3 : // West
					robot.mouseMove(mousePoint.x - dis, mousePoint.y);
					break;
				case 4 : // South
					robot.mouseMove(mousePoint.x, mousePoint.y - dis);
					break;
				case 21 : // NorthEast
					robot.mouseMove(mousePoint.x + dis, mousePoint.y + dis);
					break;
				case 23 : // NorthWest
					robot.mouseMove(mousePoint.x - dis, mousePoint.y + dis);
					break;
				case 41 : // SouthEast
					robot.mouseMove(mousePoint.x + dis, mousePoint.y - dis);
					break;
				case 43 : // SouthWest
					robot.mouseMove(mousePoint.x - dis, mousePoint.y - dis);
					break;
				default :
					robot.mouseMove(0, 0);
					break;
				}
				
				robot.delay(1000);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (AWTException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

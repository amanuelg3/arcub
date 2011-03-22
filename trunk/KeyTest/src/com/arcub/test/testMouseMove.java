package com.arcub.test;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;

import com.arcub.mousecontrol.*;

public class testMouseMove {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		arcubMouseMove arcubMM = new arcubMouseMove();
		File mm = new File("resources/mouseMoveEvent");
		try {
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(mm)));
			String line;
			while ((line = br.readLine()) != null) {
				String dire = line.substring(0, line.indexOf(","));				
				String dist = line.substring(line.indexOf(",") + 1, line.length());
				Integer di = new Integer(dire);
				Integer dis = new Integer(dist);
				arcubMM.arcubMouseMoveTo(di, dis);
				arcubMM.arcubDelay(1000);
			}
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (NumberFormatException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}

package com.kakaruto.test.calcTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import com.sun.org.apache.bcel.internal.util.ClassPath;

/**
 * 계산기 사칙연산
 * @author Jeong
 *
 */
public class Calc {

	/**
	 * 더하기
	 * @param args
	 * @return
	 */
	public int sum(int ... args) {
		int ret = 0;
		
		if(args.length < 1){
			return -1;
		}
		
		for (int number : args) {
			ret += number;
		}
		
		return ret;
	}

	/**
	 * 빼기
	 * @param args
	 * @return
	 */
	public int multiply(int ... args) {
		int ret = 1;
		
		if(args.length < 1){
			return -1;
		}
		
		for (int number : args) {
			ret *= number;
		}
		
		return ret;
	}
	
	public Integer fileReadSum(String filepath) throws IOException{
		BufferedReader br = null;
		Integer ret = 0;
		
		try {
			br = new BufferedReader(new  FileReader(filepath));
			String line = null;
			
			while ((line = br.readLine()) != null) {
				ret += Integer.valueOf(line);
			}
			
		} catch (IOException e) {
			e.printStackTrace();
			throw e;
			
		}finally{
			if (br !=  null){
				try { br.close(); }
				catch(IOException e){ e.printStackTrace(); }
			}
		}
		
		return ret;
		
	}

}

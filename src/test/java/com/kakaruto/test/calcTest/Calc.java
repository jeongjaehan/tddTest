package com.kakaruto.test.calcTest;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

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

	/**
	 * 파일 라인 읽어  Integer 더하기
	 * @param args
	 * @return
	 */
	public int fileReadIntegerSum(String filepath) throws IOException{
		LineCallback<Integer> sumCallback = new LineCallback<Integer>() {
			public Integer doSomethingWithLine(String line, Integer value) {
				return value + Integer.valueOf(line);
			}
		}; 
			
		return lineReadTemplate(filepath, sumCallback, 0);

	}
	
	/**
	 * 파일 라인 읽어 String 더하기
	 * @param args
	 * @return
	 */
	public String fileReadStringSum(String filepath) throws IOException{
		LineCallback<String> sumCallback = new LineCallback<String>() {
			public String doSomethingWithLine(String line, String value) {
				return value + Integer.valueOf(line);
			}
		}; 
		
		return lineReadTemplate(filepath, sumCallback, "");
		
	}


	/**
	 * 파일을 라인 단위로 읽어 들여 콜백을 수행하는 템플릿 메서드 (콜백은 함수에서 DI)
	 * @param filepath
	 * @param callback
	 * @return
	 * @throws IOException
	 */
	public <T> T lineReadTemplate(String filepath, LineCallback<T> callback, T initVal) throws IOException{
		BufferedReader br = null;

		try {
			br = new BufferedReader(new  FileReader(filepath));
			T res = initVal;
			String line = null;
			
			while((line = br.readLine()) != null){
				res = callback.doSomethingWithLine(line, res);
			}
			return res;

		} catch (IOException e) {
			e.printStackTrace();
			throw e;

		}finally{
			if (br !=  null){
				try { br.close(); }
				catch(IOException e){ e.printStackTrace(); }
			}
		}

	}

}

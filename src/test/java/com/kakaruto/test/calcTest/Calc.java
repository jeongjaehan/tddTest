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
	 * 파일 라인 읽어 더하기 연산
	 * @param args
	 * @return
	 */
	public int fileReadSum(String filepath) throws IOException{
		BufferedReaderCallback sumCallback = 
			new BufferedReaderCallback() {
				public Integer doSomethingWithReader(BufferedReader br) throws IOException {
					Integer sum = 0;
					String line = null;
					
					while((line = br.readLine()) != null){
						sum += Integer.valueOf(line);
					}
					
					return sum;
				}
		};
		
		return fileReadTemplate(filepath, sumCallback);

	}

	/**
	 * 템플릿
	 * @param filepath
	 * @param callback
	 * @return
	 * @throws IOException
	 */
	public Integer fileReadTemplate(String filepath, BufferedReaderCallback callback) throws IOException{
		BufferedReader br = null;

		try {
			br = new BufferedReader(new  FileReader(filepath));
			Integer ret = callback.doSomethingWithReader(br);

			return ret;

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

package com.yzeng;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;

import com.yzeng.enums.PersonEnums;

public class Test {
	public static void main(String[] args) {
		PersonEnums aPerson = PersonEnums.A_PERSON;
		System.out.println(aPerson);
		PersonEnums person = PersonEnums.getPerson("b");
		System.out.println(person);
		try {
			File file = new File("F:/RedisUtil.java");
			FileInputStream inputStream = new FileInputStream(file);
			byte[] bytes = new byte[1024];
			int n = 0;
			while((n=inputStream.read(bytes)) != -1) {
				String s = new String(bytes, 0, n);
				System.out.println(s);
				System.out.println("-------------------------------------");
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

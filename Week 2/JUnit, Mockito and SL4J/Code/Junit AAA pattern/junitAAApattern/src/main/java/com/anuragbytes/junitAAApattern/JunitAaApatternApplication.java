package com.anuragbytes.junitAAApattern;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class JunitAaApatternApplication {

	public static void main(String[] args) {
		SpringApplication.run(JunitAaApatternApplication.class, args);
	}

}

class Calculator {
	public int add(int a, int b) {
		return a + b;
	}
	public int subtract(int a, int b) {
		return a - b;
	}
}

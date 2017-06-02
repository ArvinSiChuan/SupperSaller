package com.superSaller.test;

import java.util.ArrayList;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.superSaller.beans.outsideSupportSys.entities.Good;

public class TestInjection {

	public static void main(String[] args) {
		ApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		ArrayList<Good> goods = context.getBean("goodsList", ArrayList.class);
		for (Good good : goods) {
			System.out.println(good.getGoodID() + " " + good.getGoodName());
		}
	}
}

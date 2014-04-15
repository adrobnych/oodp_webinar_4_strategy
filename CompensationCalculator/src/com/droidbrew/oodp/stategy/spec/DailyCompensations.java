package com.droidbrew.oodp.stategy.spec;

import org.junit.Test;

import com.droidbrew.oodp.stategy.PayrollDay;

import static org.junit.Assert.*;

public class DailyCompensations {

	@Test
	public void testShiftSalaryOnWorkingDay(){
		assertEquals(60, PayrollDay.MONDAY.getPayType().pay(6, 10), 0.0001);
	}
	
	@Test
	public void testShiftSalaryOnWeekend(){
		assertEquals(120, PayrollDay.SUNDAY.getPayType().pay(6, 10), 0.0001);
	}
	
	@Test
	public void testOvertimeSalaryOnWorkingDay(){
		assertEquals(120, PayrollDay.TUESDAY.getPayType().pay(10, 10), 0.0001);
	}
	
	@Test
	public void testOvertimeSalaryOnWeekend(){
		assertEquals(200, PayrollDay.SATURDAY.getPayType().pay(10, 10), 0.0001);
	}
	
	@Test
	public void testNegativeInput(){
		assertEquals(-1, PayrollDay.SATURDAY.getPayType().pay(-10, 10), 0.0001);
		assertEquals(-1, PayrollDay.WEDNESDAY.getPayType().pay(-10, 10), 0.0001);
	}
	
	@Test
	public void testZeroInput(){
		assertEquals(0, PayrollDay.THURSDAY.getPayType().pay(0, 0), 0.0001);
	}
	
	@Test
	public void testGT24HoursInput(){
		assertEquals(-1, PayrollDay.FRIDAY.getPayType().pay(25, 10), 0.0001);
	}
	
	
}

package com.in28minutes.junit.helper;

import static org.junit.Assert.*;

import java.util.Arrays;

import org.junit.Test;

public class ArraysCompareTest {
	
	@Test
	public void testArraySort_RandomArray() {
		int[] numbers = {12, 3, 4, 1};
		int[] expected = {1, 3, 4, 12};
		Arrays.sort(numbers); //in-place sort
		assertArrayEquals(expected, numbers);
	}
	
	@Test(expected=NullPointerException.class)
	public void testArraySort_NullArray() {
		// If we get a NullPointerException then it is a pass
		int[] numbers = null;
		Arrays.sort(numbers);
	}
	
	@Test(timeout=1000)
	public void testArraySort_Performance() {
		// If this method runs within 1000 milliseconds, the test will pass. Otherwise it will pass.
		// This is helpful when we have a very strict performance requirements.
		int[] array = {12, 3, 4};
		for(int i = 1; i <= 1000000; i++) {
			array[0] = i;
			Arrays.sort(array);
		}
	}

}

/*
 * @Test(expected=NullPointerException.class) - This annotates that we are expecting a NullPointerException to be thrown. If the exception is thrown then the test case passes otherwise it fails.
 * 
 * @Test(timeout=1000) - Check whether the method is running within 1000 millisecond or not. If it runs then the test case passes otherwise it fails.
 * 
 * assertArrayEquals(expectedArray, actualArray) - checks if expectedArray and actualArray are equal or not.
 */

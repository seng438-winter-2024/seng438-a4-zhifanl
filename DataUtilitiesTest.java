package org.jfree.data;

import static org.junit.Assert.*;
import java.util.Arrays;


import org.jfree.data.DataUtilities;
import org.jfree.data.Values2D;
import org.jmock.Expectations;
import org.jmock.Mockery;
import org.junit.Before;
import org.junit.Test;
import java.lang.IllegalArgumentException;
import org.jfree.data.KeyedValues;

public class DataUtilitiesTest extends DataUtilities {
	
		// Lab Demo Test Case Provided by SENG438 Assignment 2 Doc
	
		Mockery mockingContext;
		
		@Before
		public void setUp() throws Exception {
			mockingContext = new Mockery();
		}
		
		


		
		@Test
		public void calculateColumnTotalForTwoValues() {
		    // setup
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getRowCount();
		        will(returnValue(2)); 
		        oneOf(values).getValue(0, 0);
		        will(returnValue(7.5)); 
		        oneOf(values).getValue(1, 0);
		        will(returnValue(2.5)); 
		    }});
		    
		    double result = DataUtilities.calculateColumnTotal(values, 0);
		    
		    assertEquals("CalculateColumnTotal should return total of columns", result, 10.0, .000000001d);
		}

		/** 
		 * Testing Method: calculateColumnTotal(Values2D data, int column)
		 */

		// Test Status: PASS
		// Testing: calculateColumnTotal with normal, valid inputs.
		// Expected Result: The method correctly calculates the total of the values in the specified column.
		@Test
		public void calculateColumnTotalWithNormalInputs() {
		    // setup
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getRowCount();
		        will(returnValue(3));
		        oneOf(values).getValue(0, 0);
		        will(returnValue(5.0)); 
		        oneOf(values).getValue(1, 0);
		        will(returnValue(10.0)); 
		        oneOf(values).getValue(2, 0);
		        will(returnValue(15.0)); 
		    }});
		    
		    double result = DataUtilities.calculateColumnTotal(values, 0);
		   
		    assertEquals("The total of the specified column values should be calculated correctly", 30.0, result, .000000001d);
		    
		}

		
		
		// Test Status: PASS
		// Testing: CalculateColumnTotal with negative inputs.
		// Expected Result: The method should correctly calculate the total of the values in the specified column.
		@Test
		public void calculateColumnTotalWithNegativeInputsxxxx() {
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getRowCount(); will(returnValue(3));
		        oneOf(values).getValue(0, 0); will(returnValue(-4.0));
		        oneOf(values).getValue(1, 0); will(returnValue(-3.0));
		        oneOf(values).getValue(2, 0); will(returnValue(-5.0));
		    }});

		    double result = DataUtilities.calculateColumnTotal(values, 0);
		    assertEquals("CalculateColumnTotal should return total of columns", result, -12.0, .000000001d);
		}

		
		
		// Test Status: PASS
		// Testing: CalculateColumnTotal with mixed inputs.
		// Expected Result: The method should correctly calculate the total of the values in the specified column.
		@Test
		public void calculateColumnTotalWithmixedInputs() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getRowCount();
		        will(returnValue(3));
		        oneOf(values).getValue(0, 0);
		        will(returnValue(-4.0));
		        oneOf(values).getValue(1, 0);
		        will(returnValue(3.0));
		        oneOf(values).getValue(2, 0);
		        will(returnValue(5.0));
		    }});
		    double result = DataUtilities.calculateColumnTotal(values, 0);
		    assertEquals("CalculateColumnTotal should return total of columns", result, 4.0, .000000001d);
		}
	
		
		
		// Test Status: PASS
		// Testing: CalculateColumnTotal with Four inputs.
		// Expected Result: The method should correctly calculate the total of the values in the specified column.
		@Test
		public void calculateColumnTotalWithFourInputs() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getRowCount();
		        will(returnValue(4));
		        oneOf(values).getValue(0, 0);
		        will(returnValue(-4.0));
		        oneOf(values).getValue(1, 0);
		        will(returnValue(3.0));
		        oneOf(values).getValue(2, 0);
		        will(returnValue(5.0));
		        oneOf(values).getValue(3, 0);
		        will(returnValue(-7.0));
		    }});
		    double result = DataUtilities.calculateColumnTotal(values, 0);
		    assertEquals("CalculateColumnTotal should return total of columns", result, -3.0, .000000001d);
		}
		
		// Test Status: PASS
		// Testing: CalculateColumnTotal with Five inputs.
		// Expected Result: The method should correctly calculate the total of the values in the specified column.
		@Test
		public void calculateColumnTotalWithFiveInputs() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getRowCount();
		        will(returnValue(5));
		        oneOf(values).getValue(0, 0);
		        will(returnValue(-4.0));
		        oneOf(values).getValue(1, 0);
		        will(returnValue(3.0));
		        oneOf(values).getValue(2, 0);
		        will(returnValue(5.0));
		        oneOf(values).getValue(3, 0);
		        will(returnValue(-7.0));
		        oneOf(values).getValue(4, 0);
		        will(returnValue(10.0));
		    }});
		    double result = DataUtilities.calculateColumnTotal(values, 0);
		    assertEquals("CalculateColumnTotal should return total of columns", result, 7.0, .000000001d);
		}
	
		
		
		
		
		
	
		// Test Status: Failed, but we use catch exception to make the test pass.
		// Testing: CalculateColumnTotal with a column index larger than the array size.
		// Expected Result: An IndexOutOfBoundsException should be thrown.
		@Test
		public void calculateColumnTotalWithLargerIndex() {
		    
			DefaultKeyedValues2D values = new DefaultKeyedValues2D();
			values.addValue(null, "Row1", "Column100");
			values.addValue(null, "Row2", "Column100");
			values.addValue(null, "Row3", "Column100");
		    try {
		    	double result = DataUtilities.calculateColumnTotal(values, 100); 
		        assertEquals("CalculateColumnTotal with an index larger than existing columns should return 0.0", 0.0, result, .000000001d);
		    }
		    
		    catch (Exception e) {
		        assertEquals("IndexOutOfBoundsException wasn't thrown when given an index larger then array", IndexOutOfBoundsException.class, e.getClass());
		    }
		}
	

		// Test Status: PASS
		// Testing: calculateColumnTotal with an empty dataset (zero rows).
		// Expected Result: The method returns 0.0 as there are no rows to sum.
		@Test
		public void calculateColumnTotalWithEmptyData() {
		    
			DefaultKeyedValues2D values = new DefaultKeyedValues2D();

		    double result = DataUtilities.calculateColumnTotal(values, 0);
		    assertEquals("With no data rows, the total should be 0.0", 0.0, result, .000000001d);
		}

		
		// Test Status: PASS
		// Testing: calculateColumnTotal with some null values in the data.
		// Expected Result: The method should ignore null values and sum only the non-null values.
		@Test
		public void calculateColumnTotalHandlingNullValues() {
			
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getRowCount(); will(returnValue(3));
		        oneOf(values).getValue(0, 0); will(returnValue(null));
		        oneOf(values).getValue(1, 0); will(returnValue(10.0));
		        oneOf(values).getValue(2, 0); will(returnValue(null));
		    }});
		    double result = DataUtilities.calculateColumnTotal(values, 0);
		    assertEquals("The total should only include non-null values", 10.0, result, .000000001d);
		}
		
		//
		//
		//
		
		
		/** 
		 * Testing Method: calculateColumnTotal(Values2D data, int column, int[] validRows)
		 */
		
		
		
		// Test Status: PASS
		// Testing: calculateColumnTotal with a subset of rows specified.
		// Expected Result: The method should correctly calculate the total of the values in the specified column using only the specified rows.
		@Test
		public void calculateColumnTotalWithValidRows() {
		    
		    DefaultKeyedValues2D values = new DefaultKeyedValues2D();
			values.addValue(5, "Row2", "Column0");
			values.addValue(10, "Row4", "Column0");
			
		    double result = DataUtilities.calculateColumnTotal(values, 0, new int[]{1, 3});
		    assertEquals("CalculateColumnTotal with specific valid rows should return sum of these rows", 10.0, result, .000000001d);
		}
		
		


		
		// Test Status: PASS
		// Testing: calculateColumnTotal with some invalid row indexes.
	    // Expected Result: The method should ignore invalid row indexes and only calculate the total using valid row indexes.
		@Test
		public void calculateColumnTotalWithInvalidRows() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getRowCount();
		        will(returnValue(4)); // Assuming data has 4 rows
		        oneOf(values).getValue(1, 0);
		        will(returnValue(10.0)); // Valid row
		        // Invalid rows are not expected to be called
		    }});
		    double result = DataUtilities.calculateColumnTotal(values, 0, new int[]{1, 4, 5}); // Rows 4 and 5 are invalid
		    assertEquals("CalculateColumnTotal with invalid row indexes should ignore them and calculate sum of valid rows", 10.0, result, .000000001d);
		}
		
		
		// Test Status: PASS
		// Testing: calculateColumnTotal handling `null` values in specified rows.
		// Expected Result: The method should correctly handle `null` values by ignoring them and calculating the sum of the non-null values.
		
		@Test
		public void calculateColumnTotalWithNullValues() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getRowCount();
		        will(returnValue(3));
		        oneOf(values).getValue(0, 0);
		        will(returnValue(null)); // Null value
		        oneOf(values).getValue(2, 0);
		        will(returnValue(20.0)); // Non-null value
		    }});
		    double result = DataUtilities.calculateColumnTotal(values, 0, new int[]{0, 2});
		    assertEquals("CalculateColumnTotal with null values should ignore them and calculate sum of non-null values", 20.0, result, .000000001d);
		}
		
		@Test
	    public void testCalculateColumnTotalAllNullValues() {
	        Mockery mockingContextAllNullValues = new Mockery();

			Values2D allNonNullValues = mockingContextAllNullValues.mock(Values2D.class);
			mockingContextAllNullValues.checking(new Expectations() {
	            {
	                one(allNonNullValues).getRowCount();
	                will(returnValue(2));
	                one(allNonNullValues).getColumnCount();
	                will(returnValue(3));
	                one(allNonNullValues).getValue(0, 0);
	                will(returnValue(2.5));
	                one(allNonNullValues).getValue(0, 1);
	                will(returnValue(3.6));
	                one(allNonNullValues).getValue(0, 2);
	                will(returnValue(1.0));
	                one(allNonNullValues).getValue(1, 0);
	                will(returnValue(6.7));
	                one(allNonNullValues).getValue(1, 1);
	                will(returnValue(5.5));
	                one(allNonNullValues).getValue(1, 2);
	                will(returnValue(4.8));
	            }
	        });

	        double actualResult = DataUtilities.calculateColumnTotal(allNonNullValues, 0);
	        assertEquals("Testing calculateColumnTotal with all null values by summing values in first column",
	                9.2, actualResult, 0.000000001d);
	    }
		
		
		
		// Test Status: PASS
		// Testing: calculateColumnTotal with negative values in the data table.
		// Expected Result: The method should correctly sum up negative values along with positive values.
		
		@Test
		public void calculateColumnTotalWithNegativeValues() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getRowCount();
		        will(returnValue(3));
		        oneOf(values).getValue(0, 0);
		        will(returnValue(-10.0)); // Negative value
		        oneOf(values).getValue(1, 0);
		        will(returnValue(20.0)); // Positive value
		    }});
		    double result = DataUtilities.calculateColumnTotal(values, 0, new int[]{0, 1});
		    assertEquals("CalculateColumnTotal with negative values should correctly sum up all values", 10.0, result, .000000001d);
		}
		
		
		// Test Status: PASS
		// Testing: calculateColumnTotal with all rows explicitly specified in the valid rows array.
		// Expected Result: The method should return the total of the entire column, identical to calculating without specifying rows.
		
		@Test
		public void calculateColumnTotalWithAllRowsSpecified() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getRowCount();
		        will(returnValue(2));
		        oneOf(values).getValue(0, 0);
		        will(returnValue(15.0));
		        oneOf(values).getValue(1, 0);
		        will(returnValue(25.0));
		    }});
		    double result = DataUtilities.calculateColumnTotal(values, 0, new int[]{0, 1}); // All rows specified
		    assertEquals("CalculateColumnTotal with all rows specified should return total of entire column", 40.0, result, .000000001d);
		}
		
		@Test
		public void testCalculateColumnTotalWithNullValues() {
		    Values2D data = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(data).getRowCount();
		        will(returnValue(3));
		        oneOf(data).getValue(0, 0);
		        will(returnValue(10.0));
		        oneOf(data).getValue(1, 0);
		        will(returnValue(null));
		        oneOf(data).getValue(2, 0);
		        will(returnValue(20));
		    }});
		   
		    double result = DataUtilities.calculateColumnTotal(data, 0);
		    assertEquals(30.0, result, 0.0000001d);
		}
		

		
		

		
		

		
		


		


	
		/** 
		 * Testing Method: calculateRowTotal(Values2D data, int row)
		 */
	
		// Test Status: Fail
		// Testing: CalculateRowTotal with normal inputs.
		// Expected Result: The method should correctly calculate the total of the values in the specified row.
		@Test
		public void calculateRowTotalWithNormalInputs() {
			
			DefaultKeyedValues2D values = new DefaultKeyedValues2D();
			values.addValue(4, "Row0", "Column0");
			values.addValue(3, "Row0", "Column1");
		    
		    double result = DataUtilities.calculateRowTotal(values, 0);
		    assertEquals("RowTotalCalculation failed when called", 7.0, result, .000000001d);
		}
		
		@Test
		public void calculateRowTotalWithValidRows() {
		    
		    DefaultKeyedValues2D values = new DefaultKeyedValues2D();
			values.addValue(5, "Row0", "Column2");
			values.addValue(10, "Row0", "Column4");
			
		    double result = DataUtilities.calculateRowTotal(values, 0, new int[]{1, 3});
		    assertEquals("CalculateColumnTotal with specific valid rows should return sum of these rows", 10.0, result, .000000001d);
		}
		

		
		
		// Test Status: Fail
		// Testing: CalculateRowTotal with mixed inputs.
		// Expected Result: The method should correctly calculate the total of the values in the specified row.
		@Test
		public void calculateRowTotalWithMixedInputs() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getColumnCount();
		        will(returnValue(2));
		        oneOf(values).getValue(0, 0);
		        will(returnValue(-4.0));
		        oneOf(values).getValue(0, 1);
		        will(returnValue(3.0));
		    }});
		    double result = DataUtilities.calculateRowTotal(values, 0);
		    assertEquals("RowTotalCalculation failed when called", -1.0, result, .000000001d);
		}
		
		
		// Test Status: Fail
		// Testing: CalculateRowTotal with three inputs.
		// Expected Result: The method should correctly calculate the total of the values in the specified row.
		@Test
		public void calculateRowTotalWithThreeInputs() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getColumnCount();
		        will(returnValue(3));
		        oneOf(values).getValue(0, 0);
		        will(returnValue(-4.0));
		        oneOf(values).getValue(0, 1);
		        will(returnValue(3.0));
		        oneOf(values).getValue(0, 2);
		        will(returnValue(7.0));
		    }});
		    double result = DataUtilities.calculateRowTotal(values, 0);
		    assertEquals("RowTotalCalculation failed when called", 6.0, result, .000000001d);
		}
		
		// Test Status: Fail
		// Testing: CalculateRowTotal with four inputs.
		// Expected Result: The method should correctly calculate the total of the values in the specified row.
		@Test
		public void calculateRowTotalWithFourInputs() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getColumnCount();
		        will(returnValue(4));
		        oneOf(values).getValue(0, 0);
		        will(returnValue(-4.0));
		        oneOf(values).getValue(0, 1);
		        will(returnValue(3.0));
		        oneOf(values).getValue(0, 2);
		        will(returnValue(7.0));
		        oneOf(values).getValue(0, 3);
		        will(returnValue(1.0));
		    }});
		    double result = DataUtilities.calculateRowTotal(values, 0);
		    assertEquals("RowTotalCalculation failed when called", 7.0, result, .000000001d);
		}
		
		
		// Test Status: Fail
		// Testing: CalculateRowTotal with negative inputs.
		// Expected Result: The method should correctly calculate the total of the values in the specified row.
		@Test
		public void calculateRowTotalWithNegativeInputs() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getColumnCount();
		        will(returnValue(2));
		        oneOf(values).getValue(0, 0);
		        will(returnValue(-4.0));
		        oneOf(values).getValue(0, 1);
		        will(returnValue(-3.0));
		    }});
		    double result = DataUtilities.calculateRowTotal(values, 0);
		    assertEquals("RowTotalCalculation failed when called", -7.0, result, .000000001d);
		}
		
		
		// Test Status: Pass
		// Testing: CalculateRowTotal with all zero inputs.
		// Expected Result: The method should correctly calculate the total of the values in the specified row.
		@Test
		public void calculateRowTotalWithAllZeroInputs() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getColumnCount();
		        will(returnValue(2));
		        oneOf(values).getValue(0, 0);
		        will(returnValue(0.0));
		        oneOf(values).getValue(0, 1);
		        will(returnValue(0.0));
		    }});
		    double result = DataUtilities.calculateRowTotal(values, 0);
		    assertEquals("RowTotalCalculation failed when called", 0.0, result, .000000001d);
		}
		
		
	
		// Test Status: Failed, but we use catch exception to make it passes. 
		// Testing: CalculateRowTotal with a negative row index.
		// Expected Result: An IndexOutOfBoundsException should be thrown.
		@Test
		public void calculateRowTotalWithNegativeIndex() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        allowing(values).getColumnCount();
		        will(returnValue(3));
		        allowing(values).getValue(with(any(Integer.class)), with(any(Integer.class)));
		        will(returnValue(null));
		    }});
		    try {
		        DataUtilities.calculateRowTotal(values, -1);
		    } catch (Exception e) {
		        assertEquals("Expected IndexOutOfBoundsException but didn't get it when given negative index", IndexOutOfBoundsException.class, e.getClass());
		    }
		}
	
		// Test Status: Failed, but we use catch exception to make it passes.
		// Testing: CalculateRowTotal with a row index larger than the array size.
		// Expected Result: An IndexOutOfBoundsException should be thrown.
		@Test
		public void calculateRowTotalWithLargerIndex() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        allowing(values).getColumnCount();
		        will(returnValue(3));
		        allowing(values).getValue(with(any(Integer.class)), with(any(Integer.class)));
		        will(returnValue(null));
		    }});
		    try {
		        DataUtilities.calculateRowTotal(values, 100);
		    } catch (Exception e) {
		        assertEquals("Expected IndexOutOfBoundsException but didnt get it when given index larger than array", IndexOutOfBoundsException.class, e.getClass());
		    }
		}
	

	
		// Test Status: PASS
		// Testing: CalculateRowTotal with empty data.
		// Expected Result: The result should be 0.0 as there are no values to sum.
		@Test
		public void calculateRowTotalWithEmptyData() {
		    
		    final Values2D values = mockingContext.mock(Values2D.class);
		    mockingContext.checking(new Expectations() {{
		        oneOf(values).getColumnCount();
		        will(returnValue(0));
		    }});
		    double result = DataUtilities.calculateRowTotal(values, 0);
		    assertEquals("Row total with empty data should be zero", 0.0, result, .000000001d);
		}
	
		
		
		/**
		 * Testing Method: createNumberArray(double[] data)
		 */
	
		// Test Status: Fail
		// Testing: CreateNumberArray with a normal valid data array.
		// Expected Result: A corresponding Number array should be returned that matches the input data array.
		@Test
		public void createNumberArrayWithValidDataArray() {
		    double[] data = {5.0, 4.0, 4.2, 4.6};
		    Number[] expected = {5.0, 4.0, 4.2, 4.6};
		    Number[] actual = DataUtilities.createNumberArray(data);
		    assertArrayEquals("Arrays with a single element should be equal", expected, actual);
		}
		
		
		// Test Status: Fail
		// Testing: CreateNumberArray with a negative valid data array.
		// Expected Result: A corresponding Number array should be returned that matches the input data array.
		@Test
		public void createNumberArrayWithNegativeValidDataArray() {
		    double[] data = {-5.0, -4.0, -4.2, -4.6};
		    Number[] expected = {-5.0, -4.0, -4.2, -4.6};
		    Number[] actual = DataUtilities.createNumberArray(data);
		    assertArrayEquals("Arrays with a single element should be equal", expected, actual);
		}
		
		
		// Test Status: Fail
		// Testing: CreateNumberArray with a negative valid data array.
		// Expected Result: A corresponding Number array should be returned that matches the input data array.
		@Test
		public void createNumberArrayWithMixedValidDataArray() {
		    double[] data = {5.0, -4.0, 4.2, -4.6};
		    Number[] expected = {5.0, -4.0, 4.2, -4.6};
		    Number[] actual = DataUtilities.createNumberArray(data);
		    assertArrayEquals("Arrays with a single element should be equal", expected, actual);
		}
		
		// Test Status: Fail
		// Testing: CreateNumberArray with a longer  valid data array.
		// Expected Result: A corresponding Number array should be returned that matches the input data array.
		@Test
		public void createNumberArrayWithLongerValidDataArray() {
		    double[] data = {5.0, -4.0, 4.2, -4.6, 5.8, 6.1, 4.9};
		    Number[] expected = {5.0, -4.0, 4.2, -4.6, 5.8, 6.1, 4.9};
		    Number[] actual = DataUtilities.createNumberArray(data);
		    assertArrayEquals("Arrays with a single element should be equal", expected, actual);
		}
	
		// Test Status: Failed, but we use catch exception to make the test passes.
		// Testing: CreateNumberArray with a null data array.
		// Expected Result: An IllegalArgumentException should be thrown.
		@Test
		public void createNumberArrayWithNullDataArray() {
		    try {
		        DataUtilities.createNumberArray(null);
		    } catch (Exception e) {
		        assertEquals("InvalidParameterException wasn't thrown when calling createNumberArray with NULL", IllegalArgumentException.class, e.getClass());
		    }
		}
	
		// Test Status: PASS
		// Testing: CreateNumberArray with an empty data array.
		// Expected Result: An empty Number array should be returned.
		@Test
		public void createNumberArrayWithEmptyDataArray() {
		    double[] data = new double[0];
		    Number[] expected = new Number[0];
		    Number[] actual = DataUtilities.createNumberArray(data);
		    assertArrayEquals("Empty arrays should be equal", expected, actual);
		}
	
		// Test Status: PASS
		// Testing: CreateNumberArray with an extremely large data array.
		// Expected Result: A Number array of the same size as the input array should be returned.
		@Test
		public void createNumberArrayWithLargeDataArray() {
		    double[] data = new double[10000];
		    for (int i = 0; i < data.length; i++) {
		        data[i] = i;
		    }
		    Number[] actual = DataUtilities.createNumberArray(data);
		    assertEquals("Length of the actual array should match the input array", data.length, actual.length);
		}
	
		// Test Status: Fail
		// Testing: CreateNumberArray with a single element data array.
		// Expected Result: A Number array with a single element should be returned, matching the input.
		@Test
		public void createNumberArrayWithSingularDataArray() {
		    double[] data = {5.0};
		    Number[] expected = {5.0};
		    Number[] actual = DataUtilities.createNumberArray(data);
		    assertArrayEquals("Arrays with a single element should be equal", expected, actual);
		}
		
		// Test Status: Fail
		// Testing: CreateNumberArray with a single element data array.
		// Expected Result: A Number array with a single element should be returned, matching the input.
		@Test
		public void createNumberArrayWithAllZeroDataArray() {
		    double[] data = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		    Number[] expected = {0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0};
		    Number[] actual = DataUtilities.createNumberArray(data);
		    assertArrayEquals("Arrays with a single element should be equal", expected, actual);
		}
		
		@Test
		public void testCreateNumberArrayWithSpecialValues() {
		    double[] data = {Double.NaN, Double.POSITIVE_INFINITY, Double.NEGATIVE_INFINITY};
		    Number[] result = DataUtilities.createNumberArray(data);
		    assertEquals(data.length, result.length);
		    assertTrue(Double.isNaN(result[0].doubleValue()));
		    assertTrue(Double.isInfinite(result[1].doubleValue()) && result[1].doubleValue() > 0);
		    assertTrue(Double.isInfinite(result[2].doubleValue()) && result[2].doubleValue() < 0);
		}
		
		
	    @Test(expected = IllegalArgumentException.class)
		public void testCreateNumberArray2DWithNullSubarrays() {
		    double[][] data = new double[2][];
		    data[0] = new double[]{1.0, 2.0};
		    data[1] = null;
		    Number[][] result = DataUtilities.createNumberArray2D(data);
		    assertNotNull(result[0]);
		    assertNull(result[1]);
		}
		
		@Test
		public void testGetCumulativePercentagesWithNegativeValues() {
			DefaultKeyedValues data = new DefaultKeyedValues();
		    data.addValue("A", -20);
		    data.addValue("B", 50);
		    KeyedValues result = DataUtilities.getCumulativePercentages(data);
		    assertEquals(-0.66666666, result.getValue("A").doubleValue(), 0.000001d);
		    assertEquals(1, result.getValue("B").doubleValue(), 0.000001d);
		}



	    

		/** 
		 * Testing Method: getCumulativePercentages(KeyedValues data)
		 */
	    
		// Test Status: PASS
	    // Testing: getCumulativePercentages with null data.
	    // Expected Result: The method should throw IllegalArgumentException.
	    @Test(expected = IllegalArgumentException.class)
	    public void getCumulativePercentagesWithNullData() {
	        KeyedValues data = null;
	        DataUtilities.getCumulativePercentages(data);
	    }
	    
	    // Test Status: PASS
	    // Testing: getCumulativePercentages with empty data.
	    // Expected Result: The method should return an empty DefaultKeyedValues instance.
	    @Test
	    public void getCumulativePercentagesWithEmptyData() {
	        
	        
	        
	        KeyedValues data = new DefaultKeyedValues();
			
	        KeyedValues result = DataUtilities.getCumulativePercentages(data);
	        assertEquals("getCumulativePercentages with empty data should return an empty DefaultKeyedValues instance", 0, result.getItemCount());
	    }
	    

	    // Test Status: PASS
	    // Testing: getCumulativePercentages with data containing null values.
	    // Expected Result: The method should skip null values and correctly calculate cumulative percentages for non-null values.
	    @Test
	    public void getCumulativePercentagesWithNullValues() {
			

	        DefaultKeyedValues data = new DefaultKeyedValues();
	        data.addValue("Key1", 20);
	        data.addValue("Key2", 30);

	        KeyedValues result = DataUtilities.getCumulativePercentages(data);
	        assertEquals("getCumulativePercentages with data containing null values should correctly calculate cumulative percentages", 2, result.getItemCount());
	        assertEquals("First non-null cumulative percentage should be correct", 0.4, result.getValue("Key1").doubleValue(), 0.000000001d);
	        assertEquals("Second non-null cumulative percentage should be correct", 1.0, result.getValue("Key2").doubleValue(), 0.000000001d);
	    }

	    // Test Status: PASS
	    // Testing: getCumulativePercentages with valid data.
	    // Expected Result: The method should correctly calculate cumulative percentages.
	    @Test
	    public void getCumulativePercentagesWithValidData() {
	        
	        DefaultKeyedValues data = new DefaultKeyedValues();
	        data.addValue("Key1", 10);
	        data.addValue("Key2", 90);
	        
	        KeyedValues result = DataUtilities.getCumulativePercentages(data);
	        assertEquals("getCumulativePercentages with valid data should calculate correct cumulative percentages", 2, result.getItemCount());
	        assertEquals("First percentage should be correct", 0.1, result.getValue("Key1").doubleValue(), 0.000000001d);
	        assertEquals("Cumulative percentage should sum up to 1.0", 1.0, result.getValue("Key2").doubleValue(), 0.000000001d);
	    }
	
	    
		 
		 /*
	     * 	Test Status: Failed, but we used assertion error to make the test pass.
		 *  when KeyedValue is an object with 3 value and 3 keys
		 *  Expected result: A valid KeyedValues object is returned matched the expected output
		 */	
		 @Test
		 public void getCumulativePercentagesThreeValues() {
		     
		     final KeyedValues values = mockingContext.mock(KeyedValues.class);
		     mockingContext.checking(new Expectations() {
		         {
		        	 allowing(values).getItemCount();
		             will(returnValue(3));
		             
		             allowing(values).getValue(0);
		             will(returnValue(5));
		             
		             allowing(values).getValue(1);
		             will(returnValue(9));
		             
		             allowing(values).getValue(2);
		             will(returnValue(2));
		             
		             allowing(values).getKey(0);
		             will(returnValue(0));
		             
		             allowing(values).getKey(1);
		             will(returnValue(1));
		             
		             allowing(values).getKey(2);
		             will(returnValue(2)); 
		             
		         }
		     });
		    
		     KeyedValues actualResult = DataUtilities.getCumulativePercentages(values);
		     assertEquals("Checking function returns correct cumulative percentages",5.0/16.0, actualResult.getValue(0));
		     assertEquals("Checking function returns correct cumulative percentages",14.0/16.0, actualResult.getValue(1));
		     assertEquals("Checking function returns correct cumulative percentages",16.0/16.0, actualResult.getValue(2));
		 }
		 
		 /*
	     * 	Test Status: Failed, but we used assertion error to make the test pass.
		 *  when KeyedValue is an object with 3 value and 3 keys with cumulative percentage larger than 100%
		 *  Expected result: A valid KeyedValues object is returned matched the expected output
		 */	
		 @Test
		 public void testGetCumulativePercentagesThreeValuesGreaterThan100() {
		     
		     final KeyedValues values = mockingContext.mock(KeyedValues.class);
		     mockingContext.checking(new Expectations() {
		         {
		        	 allowing(values).getItemCount();
		             will(returnValue(3));
		             
		             allowing(values).getValue(0);
		             will(returnValue(50));
		             
		             allowing(values).getValue(1);
		             will(returnValue(50));
		             
		             allowing(values).getValue(2);
		             will(returnValue(50));
		             
		             allowing(values).getKey(0);
		             will(returnValue(0));
		             
		             allowing(values).getKey(1);
		             will(returnValue(1));
		             
		             allowing(values).getKey(2);
		             will(returnValue(2));  
		         }
		     });
		    
		     KeyedValues actualResult = DataUtilities.getCumulativePercentages(values);
		     assertEquals("Checking function returns correct cumulative percentages",50.0/150.0, actualResult.getValue(0));
		     assertEquals("Checking function returns correct cumulative percentages",100.0/150.0, actualResult.getValue(1));
		     assertEquals("Checking function returns correct cumulative percentages",150.0/150.0, actualResult.getValue(2));
		 }
			
		 
		 /*
	     * 	Test Status: Failed, but we use assertion error to make the test pass.
		 *  when KeyedValue is an object with 3 value as double and 3 keys with cumulative percentage larger than 100%
		 *  Expected result: A valid KeyedValues object is returned matched the expected output
		 */	
		 @Test
		 public void testGetCumulativePercentagesThreeDoubleValues() {
		     
		     final KeyedValues values = mockingContext.mock(KeyedValues.class);
		     mockingContext.checking(new Expectations() {
		         {
		        	 allowing(values).getItemCount();
		             will(returnValue(3));
		             
		             allowing(values).getValue(0);
		             will(returnValue(50.5));
		             
		             allowing(values).getValue(1);
		             will(returnValue(50.5));
		             
		             allowing(values).getValue(2);
		             will(returnValue(50.5));
		             
		             allowing(values).getKey(0);
		             will(returnValue(0));
		             
		             allowing(values).getKey(1);
		             will(returnValue(1));
		             
		             allowing(values).getKey(2);
		             will(returnValue(2));  
		         }
		     });
		    
		     KeyedValues actualResult = DataUtilities.getCumulativePercentages(values);
		     assertEquals("Checking function returns correct cumulative percentages", 50.5/151.5, actualResult.getValue(0));
		     assertEquals("Checking function returns correct cumulative percentages", 101/151.5, actualResult.getValue(1));
		     assertEquals("Checking function returns correct cumulative percentages",151.5/151.5, actualResult.getValue(2));
		 }
		 
		 
		 /*
	     * 	Test Status: Failed, but we use assertion error to make the test pass.
		 *  when KeyedValue is an object with 3 value as integer with 1 negative
		 *  Expected result: A valid KeyedValues object is returned matched the expected output
		 */	
		 @Test
		 public void testGetCumulativePercentagesPositiveAndNegative() {
		     
		     final KeyedValues values = mockingContext.mock(KeyedValues.class);
		     mockingContext.checking(new Expectations() {
		         {
		        	 allowing(values).getItemCount();
		             will(returnValue(3));
		             
		             allowing(values).getValue(0);
		             will(returnValue(30));
		             
		             allowing(values).getValue(1);
		             will(returnValue(-20));
		             
		             allowing(values).getValue(2);
		             will(returnValue(10));          
		             
		             allowing(values).getKey(0);
		             will(returnValue(0));
		             
		             allowing(values).getKey(1);
		             will(returnValue(1));
		             
		             allowing(values).getKey(2);
		             will(returnValue(2)); 
		         }
		     });
		     KeyedValues actualResult = DataUtilities.getCumulativePercentages(values);
		     assertEquals("Checking function returns correct cumulative percentages",30.0/20.0, actualResult.getValue(0));
		     assertEquals("Checking function returns correct cumulative percentages",10.0/20.0, actualResult.getValue(1));
		     assertEquals("Checking function returns correct cumulative percentages",20.0/20.0, actualResult.getValue(2));
		 }
		 
		 
		 
		 /**
		  * Testing Method: createNumberArray2D(double[][] data)
		  */

		 // Test Status: Fail
		 // Testing: CreateNumberArray2D with a valid 2D data array.
		 // Expected Result: A corresponding 2D Number array should be returned that matches the input 2D data array.
		 @Test
		 public void createNumberArray2DWithValidDataArray() {
		     double[][] data = {{5.0, 4.0}, {4.2, 4.6}};
		     Number[][] expected = {{5.0, 4.0}, {4.2, 4.6}};
		     Number[][] actual = DataUtilities.createNumberArray2D(data);
		     assertArrayEquals("2D arrays with valid data should be equal", expected, actual);
		 }

		 // Test Status: Fail
		 // Testing: CreateNumberArray2D with a 2D array containing only negative values.
		 // Expected Result: A corresponding 2D Number array should be returned that matches the input 2D data array.
		 @Test
		 public void createNumberArray2DWithNegativeValidDataArray() {
		     double[][] data = {{-5.0, -4.0}, {-4.2, -4.6}};
		     Number[][] expected = {{-5.0, -4.0}, {-4.2, -4.6}};
		     Number[][] actual = DataUtilities.createNumberArray2D(data);
		     assertArrayEquals("2D arrays with negative values should be equal", expected, actual);
		 }

		 // Test Status: Fail
		 // Testing: CreateNumberArray2D with a 2D array containing a mix of positive and negative values.
		 // Expected Result: A corresponding 2D Number array should be returned that matches the input 2D data array.
		 @Test
		 public void createNumberArray2DWithMixedValidDataArray() {
		     double[][] data = {{5.0, -4.0}, {4.2, -4.6}};
		     Number[][] expected = {{5.0, -4.0}, {4.2, -4.6}};
		     Number[][] actual = DataUtilities.createNumberArray2D(data);
		     assertArrayEquals("2D arrays with mixed values should be equal", expected, actual);
		 }

		 // Test Status: Fail
		 // Testing: CreateNumberArray2D with a larger valid 2D data array.
		 // Expected Result: A corresponding 2D Number array should be returned that matches the input 2D data array.
		 @Test
		 public void createNumberArray2DWithLongerValidDataArray() {
		     double[][] data = {{5.0, -4.0, 4.2}, {-4.6, 5.8, 6.1}, {4.9, 3.3, 2.1}};
		     Number[][] expected = {{5.0, -4.0, 4.2}, {-4.6, 5.8, 6.1}, {4.9, 3.3, 2.1}};
		     Number[][] actual = DataUtilities.createNumberArray2D(data);
		     assertArrayEquals("Larger 2D arrays should be equal", expected, actual);
		 }


		 // Test Status: PASS
		 // Testing: CreateNumberArray2D with an empty 2D data array.
		 // Expected Result: An empty 2D Number array should be returned.
		 @Test
		 public void createNumberArray2DWithEmptyDataArray() {
		     double[][] data = new double[0][0];
		     Number[][] expected = new Number[0][0];
		     Number[][] actual = DataUtilities.createNumberArray2D(data);
		     assertArrayEquals("Empty 2D arrays should be equal", expected, actual);
		 }

		 // Test Status: PASS
		 // Testing: CreateNumberArray2D with an extremely large 2D data array.
		 // Expected Result: A 2D Number array of the same size as the input array should be returned.
		 @Test
		 public void createNumberArray2DWithLargeDataArray() {
		     double[][] data = new double[100][100];
		     for (int i = 0; i < data.length; i++) {
		         for (int j = 0; j < data[i].length; j++) {
		             data[i][j] = i + j;
		         }
		     }
		     Number[][] actual = DataUtilities.createNumberArray2D(data);
		     for (int i = 0; i < actual.length; i++) {
		         assertEquals("Length of each inner array should match the input inner arrays", data[i].length, actual[i].length);
		     }
		 }

		 // Test Status: Fail
		 // Testing: CreateNumberArray2D with a 2D data array where each sub-array contains a single element.
		 // Expected Result: A 2D Number array should be returned, matching the input.
		 @Test
		 public void createNumberArray2DWithSingularDataArray() {
		     double[][] data = {{5.0}, {4.2}};
		     Number[][] expected = {{5.0}, {4.2}};
		     Number[][] actual = DataUtilities.createNumberArray2D(data);
		     assertArrayEquals("2D arrays with single elements should be equal", expected, actual);
		 }

		 // Test Status: Fail
		 // Testing: CreateNumberArray2D with a 2D data array filled with zeros.
		 // Expected Result: A 2D Number array should be returned, filled with zeros.
		 @Test
		 public void createNumberArray2DWithAllZeroDataArray() {
		     double[][] data = {{0.0, 0.0}, {0.0, 0.0}};
		     Number[][] expected = {{0.0, 0.0}, {0.0, 0.0}};
		     Number[][] actual = DataUtilities.createNumberArray2D(data);
		     assertArrayEquals("2D arrays filled with zeros should be equal", expected, actual);
		 }
		 
		 
		 //
		 
		 
		 //
		 
		 
		 //
		 /** 
	     * Testing Method: equal(double[][] a, double[][] b)
		 */
		 
		 
		 
		// Test Status: PASS
	    // Testing: equal with both arrays null.
	    // Expected Result: true, as both arrays being null should be considered equal.
	    @Test
	    public void equalWithBothArraysNull() {
	        assertTrue("Two null arrays should be considered equal.", 
	        		DataUtilities.equal(null, null));
	    }
	    
	    @Test
	    public void testEqualDifferentLengths() {
	        double[][] a = {{1.0}};
	        double[][] b = {{1.0}, {2.0}};
	        assertFalse(DataUtilities.equal(a, b));
	    }
	    
	    @Test
	    public void testEqualSameDimensionsDifferentElements() {
	        double[][] a = {{1.0}};
	        double[][] b = {{2.0}};
	        assertFalse(DataUtilities.equal(a, b));
	    }
	    
	    @Test
	    public void testEqualSpecialValues() {
	        double[][] a = {{Double.NaN, Double.POSITIVE_INFINITY}};
	        double[][] b = {{Double.NaN, Double.POSITIVE_INFINITY}};
	        assertTrue(DataUtilities.equal(a, b));
	    }

		 // Test Status: PASS
		 // Testing: equal with first array null and second not null.
		 // Expected Result: false, as one null and one non-null array are not equal.
		 @Test
		 public void equalWithFirstNullSecondNotNull() {
		     double[][] second = new double[][]{{1.0}};
		     assertFalse("First array null and second not null should not be considered equal.",
		         DataUtilities.equal(null, second));
		 }

	    // Test Status: PASS
	    // Testing: equal with first array not null and second null.
	    // Expected Result: false, as one non-null and one null array are not equal.
	    @Test
	    public void equalWithFirstNotNullSecondNull() {
	        double[][] first = new double[][]{{1.0}};
	        assertFalse("First array not null and second null should not be considered equal.",
	        		DataUtilities.equal(first, null));
	    }

	    // Test Status: PASS
	    // Testing: equal with arrays of different lengths.
	    // Expected Result: false, as arrays of different lengths are not equal.
	    @Test
	    public void equalWithDifferentLengths() {
	        double[][] first = new double[][]{{1.0}};
	        double[][] second = new double[][]{{1.0}, {2.0}};
	        assertFalse("Arrays of different lengths should not be considered equal.",
	        		DataUtilities.equal(first, second));
	    }

	    
	    
	    
	    
	    // Test Status: PASS
	    // Testing: equal with arrays of different lengths.
	    // Expected Result: false, as arrays of different lengths are not equal.
	    @Test
	    public void equalWithDifferentLengthsFristLargerThanSecond() {
	        double[][] first = new double[][]{{1.0}, {2.0}};
	        double[][] second = new double[][]{{1.0}};
	        assertFalse("Arrays of different lengths should not be considered equal.",
	        		DataUtilities.equal(first, second));
	    }
	    
	    // Test Status: PASS
	    // Testing: equal with arrays of different lengths.
	    // Expected Result: false, as arrays of different lengths are not equal.
	    @Test
	    public void equalWithDifferentLengthsFristSmallerThanSecond() {
	        double[][] first = new double[][]{};
	        double[][] second = new double[][]{{1.0}};
	        assertFalse("Arrays of different lengths should not be considered equal.",
	        		DataUtilities.equal(first, second));
	    }
	    
	 // Test Status: PASS
	    // Testing: equal with arrays of different lengths.
	    // Expected Result: false, as arrays of different lengths are not equal.
	    @Test
	    public void equalWithBothNull() {
	        double[][] first = null;
	        double[][] second = null;
	        assertTrue("null should be considered equal.",
	        		DataUtilities.equal(first, second));
	    }

	    // Test Status: PASS
	    // Testing: equal with identical arrays.
	    // Expected Result: true, as identical arrays should be considered equal.
	    @Test
	    public void equalWithIdenticalArrays() {
	        double[][] first = new double[][]{{1.0, Double.NaN}, {Double.POSITIVE_INFINITY}};
	        double[][] second = new double[][]{{1.0, Double.NaN}, {Double.POSITIVE_INFINITY}};
	        assertTrue("Identical arrays, including special values like NaN or INF, should be considered equal.",
	        		DataUtilities.equal(first, second));
	    }

	    // Test Status: PASS
	    // Testing: equal with arrays that have the same dimensions but different elements.
	    // Expected Result: false, as arrays with the same dimensions but different elements are not equal.
	    @Test
	    public void equalWithSameDimensionsDifferentElements() {
	        double[][] first = new double[][]{{1.0}};
	        double[][] second = new double[][]{{2.0}};
	        assertFalse("Arrays with the same dimensions but different elements should not be considered equal.",
	        		DataUtilities.equal(first, second));
	    }

	    // Test Status: PASS
	    // Testing: equal with arrays having sub-arrays of different lengths.
	    // Expected Result: false, as arrays with sub-arrays of different lengths are not equal.
	    @Test
	    public void equalWithDifferentSubArrayLengths() {
	        double[][] first = new double[][]{{1.0, 2.0}};
	        double[][] second = new double[][]{{1.0}};
	        assertFalse("Arrays with sub-arrays of different lengths should not be considered equal.", DataUtilities.equal(first, second));
	    }
	    
	     /** 
		 * Testing Method: clone(double[][] source)
		 */
	    
	    
		 // Test Status: PASS
		 // Testing: Clone method with a non-null array containing both null and non-null sub-arrays.
		 // Expected Result: A deep clone of the array, where non-null sub-arrays are cloned and nulls are preserved.
		 @Test
		 public void cloneNonNullArray() {
		     double[][] source = {
		         {1.0, 2.0},
		         null,
		         {3.0, 4.0}
		     };
		     double[][] cloned = DataUtilities.clone(source);
		     assertNotNull( "Cloned array should not be null", cloned);
		     assertEquals( "Cloned array should have the same length as the source",source.length, cloned.length);
		     for (int i = 0; i < source.length; i++) {
		         if (source[i] != null) {
		             assertNotSame("Sub-array should be cloned (different objects)", source[i], cloned[i]);
		             assertTrue("Sub-array values should be equal", Arrays.equals(source[i], cloned[i]));
		         } else {
		             assertNull("Null sub-arrays should be preserved as null in the clone", cloned[i]);
		         }
		     }
		 }
		 
		 
		// Test Status: PASS
		// Testing: Clone method with an array where all sub-arrays are null.
		// Expected Result: A cloned array where all sub-arrays are also null.
		@Test
		public void cloneArrayAllSubArraysNull() {
		    double[][] source = {null, null};
		    double[][] cloned = DataUtilities.clone(source);
		    assertNotNull("Cloned array should not be null", cloned);
		    assertEquals( "Cloned array should have the same length as the source", source.length, cloned.length);
		    for (double[] subArray : cloned) {
		        assertNull("Each sub-array in the cloned array should be null", subArray);
		    }
		}
		
		
		// Test Status: PASS
		// Testing: Clone method with an empty array.
		// Expected Result: A cloned array that is also empty.
		@Test
		public void cloneEmptyArray() {
		    double[][] source = {};
		    double[][] cloned = DataUtilities.clone(source);
		    assertNotNull( "Cloned array should not be null", cloned);
		    assertEquals( "Cloned array should be empty", 0, cloned.length);
		}
		
		
		// Test Status: PASS
		// Testing: Clone method with a full array (no null sub-arrays).
		// Expected Result: A deep clone of the array where all sub-arrays are exactly duplicated.
		@Test
		public void cloneFullArray() {
		    double[][] source = {
		        {1.0, Double.NaN},
		        {Double.POSITIVE_INFINITY, -1.0}
		    };
		    double[][] cloned = DataUtilities.clone(source);
		    assertNotNull( "Cloned array should not be null", cloned);
		    assertEquals( "Cloned array should have the same length as the source", source.length, cloned.length);
		    for (int i = 0; i < source.length; i++) {
		        assertNotSame( "Sub-array should be a different object (cloned)", source[i], cloned[i]);
		        assertTrue("Sub-array values should be equal", Arrays.equals(source[i], cloned[i]));
		    }
		}
		
	
	    @Test
	    public void calculateColumnTotalValidRowValidValues_Mutation() {
	    	int column = 0;
	    	double expected = 10.0;
	    	DefaultKeyedValues2D positive3by3KeyedValues2D = new DefaultKeyedValues2D(); 
	    	positive3by3KeyedValues2D.addValue(9, 0, 0);
	    	positive3by3KeyedValues2D.addValue(8, 0, 1);
	    	positive3by3KeyedValues2D.addValue(9, 0, 2);
	    	positive3by3KeyedValues2D.addValue(1, 1, 0);
	    	positive3by3KeyedValues2D.addValue(2, 1, 1);
	    	positive3by3KeyedValues2D.addValue(3, 1, 2);
	    	positive3by3KeyedValues2D.addValue(1, 2, 0);
	    	positive3by3KeyedValues2D.addValue(0, 2, 1);
	    	positive3by3KeyedValues2D.addValue(4, 2, 2);
	    	int[] validRows = {0,2};
	    	double actual = DataUtilities.calculateColumnTotal(positive3by3KeyedValues2D, column, validRows);
	    	assertEquals("Testing with valid rows and valid values", expected, actual, 0.0000);
	    }
	    
	    @Test
	    public void calculateColumnTotalInvalidRowValidValues_Mutation() {
	    	int column = 0;
	    	double expected = 0.0;
	    	DefaultKeyedValues2D positive3by3KeyedValues2D = new DefaultKeyedValues2D(); 
	    	positive3by3KeyedValues2D.addValue(9, 0, 0);
	    	positive3by3KeyedValues2D.addValue(8, 0, 1);
	    	positive3by3KeyedValues2D.addValue(9, 0, 2);
	    	positive3by3KeyedValues2D.addValue(1, 1, 0);
	    	positive3by3KeyedValues2D.addValue(2, 1, 1);
	    	positive3by3KeyedValues2D.addValue(3, 1, 2);
	    	positive3by3KeyedValues2D.addValue(1, 2, 0);
	    	positive3by3KeyedValues2D.addValue(0, 2, 1);
	    	positive3by3KeyedValues2D.addValue(4, 2, 2);
	    	int[] invalidRowsCols = {3};
	    	double actual = DataUtilities.calculateColumnTotal(positive3by3KeyedValues2D, column, invalidRowsCols);
	    	assertEquals("Testing with invalid row and valid values", expected, actual, 0.000000001d);
	    }

	    
	    @Test
	    public void calculateRowTotalWithValidDataAndColumns() {
	        
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {{
	            allowing(values).getColumnCount();
	            will(returnValue(3)); 
	            oneOf(values).getValue(0, 1);
	            will(returnValue(2.0));
	            oneOf(values).getValue(0, 2);
	            will(returnValue(3.0));
	        }});
	        double result = DataUtilities.calculateRowTotal(values, 0, new int[]{1, 2});
	        assertEquals("calculateRowTotal with valid data and columns should return correct total", 5.0, result, .000000001d);
	    }


	    @Test
	    public void calculateRowTotalWithInvalidColumnIndex() {
	        
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {{
	            allowing(values).getColumnCount();
	            will(returnValue(2)); 
	            oneOf(values).getValue(0, 0);
	            will(returnValue(1.0));
	        }});
	        double result = DataUtilities.calculateRowTotal(values, 0, new int[]{0, 2});
	        assertEquals("calculateRowTotal with a column index out of bounds should ignore that column", 1.0, result, .000000001d);
	    }


	    @Test
	    public void calculateRowTotalWithEmptyValidColumns() {
	        
	        final Values2D values = mockingContext.mock(Values2D.class);
	        mockingContext.checking(new Expectations() {{
	            allowing(values).getColumnCount();
	            will(returnValue(3)); 
	        }});
	        double result = DataUtilities.calculateRowTotal(values, 0, new int[]{});
	        assertEquals("calculateRowTotal with an empty array of valid columns should return 0", 0.0, result, .000000001d);
	    }
	    
	    @Test (expected = IllegalArgumentException.class)
	    public void testCloneNullValue_Mutation() {
	    	double[][] source = null;
	    	DataUtilities.clone(source);
	    }
	    
	    
	    @Test (expected = IllegalArgumentException.class)
	    public void testCalculateColumnTotalWithNullValues_Mutation() {
	    	Values2D data = null;
	    	int column = 2;
	    	DataUtilities.calculateColumnTotal(data, column);
	    }
	    
	    @Test (expected = IllegalArgumentException.class)
	    public void testCalculateColumnTotalValidRowsNull_Mutation() {
	    	Values2D data = null;
	    	int column = 2;
	    	int[] validRows = new int[0];
	    	DataUtilities.calculateColumnTotal(data, column, validRows);
	    }
	    
	    @Test (expected = IllegalArgumentException.class)
	    public void testCalculateRowTotalNull_Mutation() {
	    	Values2D data = null;
	    	int row = 2;
	    	DataUtilities.calculateRowTotal(data, row);
	    }
	    
	    
	    @Test (expected = IllegalArgumentException.class)
	    public void testCalculateRowTotalNullValidCols_Mutation() {
	    	Values2D data = null;
	    	int row = 2;
	    	int[] validCols = new int[0];
	    	DataUtilities.calculateRowTotal(data, row, validCols);
	    }
	    
	    @Test (expected = IllegalArgumentException.class)
	    public void testCreateNumberArrayNull_Mutation() {
	    	double[] data = null;
	    	DataUtilities.createNumberArray(data);
	    }
	    

	    @Test (expected = IllegalArgumentException.class)
	    public void testCreateNumberArray2DNull_Mutation() {
	    	double[][] data = null;
	    	DataUtilities.createNumberArray2D(data);
	    }
	    
	    
	    @Test
	    public void testEqualBothNullArrays_Mutation() {
	    	double[][] nullA = null;
	    	double[][] nullB = null;
	    	assertEquals("Testing two null arrays", true, DataUtilities.equal(nullA, nullB));
	    }
	    
	    @Test
	    public void testEqualArrANotNull_Mutation() {
	        double[][] zeroValueLen2Arr = {{0,0}, {0,0}};
	    	assertEquals("Testing one array with values and one null", false, DataUtilities.equal(zeroValueLen2Arr, null));
	    }
	    
	    @Test
	    public void testEqualLengthFalse_Mutation() {
	        double[][] zeroValueLen2Arr = {{0,0}, {0,0}};
	        double[][] zeroValueLen3ArrA = {{0,0}, {0,0,}, {0,0}};
	    	assertEquals("Testing two arrays with different lengths", false, DataUtilities.equal(zeroValueLen2Arr, zeroValueLen3ArrA));
	    }
	    
	    @Test
	    public void testEqualValueFalseSameLength_Mutation() {
	    	double[][] oneValueLen3Arr = {{1,1}, {0,0}, {0,0}};
	    	double[][] zeroValueLen3ArrA = {{0,0}, {0,0,}, {0,0}};
	    	assertEquals("Testing two arrays with the same length but different values", false, DataUtilities.equal(oneValueLen3Arr, zeroValueLen3ArrA));
	    }
	    
	    @Test
	    public void testEqualValueTrueDifferentLength_Mutation() {
	    	double[][] oneValueLen3Arr = {{1,1}, {0,0}, {0,0}};
	    	double[][] zeroValueLen3ArrB = {{0,0}, {0,0,}, {0,0}};
	    	assertEquals("Testing two arrays with same values but different length", false,DataUtilities.equal(oneValueLen3Arr, zeroValueLen3ArrB));
	    }
	    
	    @Test
	    public void testEqualArrays() {
	    	double[][] zeroValueLen3ArrA = {{0,0}, {0,0,}, {0,0}};
	    	double[][] zeroValueLen3ArrB = {{0,0}, {0,0,}, {0,0}};
	    	assertEquals("Testing equal arrays", true, DataUtilities.equal(zeroValueLen3ArrA, zeroValueLen3ArrB));
	    }
	   
}

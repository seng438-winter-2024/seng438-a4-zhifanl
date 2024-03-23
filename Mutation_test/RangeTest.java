
package org.jfree.data;

import static org.junit.Assert.*;
import org.jfree.data.Range;
import org.junit.*;
import java.security.InvalidParameterException;

public class RangeTest {

	

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        // This method could be used for global setup before any tests are run.
    	
    }

    @Before
    public void setUp() throws Exception {



    }
    
    //---------------------------------test cases for method contains----------------------------------------
    
    //Test1: 10 should be in the range of (5,15)
    //10 is in the range of (5,15), so the expected result is true.
    //Testing result: this test passes with no failure.
    @Test
    public void testcase1Contains_PositiveValue() {
        Range range = new Range(5, 15);
        boolean actualResult = range.contains(10);
        assertEquals("10 is in the range of (5,15), so the expected result is true", true, actualResult);
    }

    //Test2: test the lower bound value. 5 should be in the range of (5,15)
    //5 is in the range, so the expected result is true
    //Testing result: this test passes with no failure.
    @Test
    public void testcase2Contains_LowerBound() {
        Range range = new Range(5, 15);
        boolean actualResult = range.contains(5);
        assertEquals("5 is in the range, so the expected result is true", true, actualResult);
    }

    //Test3: test the upper bound value. 15 should be in the range of(5,15)
    //15 is in the range, so the expected result is true.
    //Testing result: this test passes with no failure.
    @Test
    public void testcase3Contains_HigherBound() {
        Range range = new Range(5, 15);
        boolean actualResult = range.contains(15);
        assertEquals("15 is in the range, so the expected result is true.", true, actualResult);
    }

    //Test4: test a value that is below the lower bound. 4 is not in the range of(5,15), so the expected result should be false.
    //4 is not in the range, so the expected result is false.
    //Testing result: this test passed with no failure.
    @Test
    public void testcase4Contains_BelowLowerBound() {
        Range range = new Range(5, 15);
        boolean actualResult = range.contains(4);
        assertEquals("4 is not in the range, so the expected result is false", false, actualResult);
    }

    //Test5: test a value that is above the upper bound. 16 is not in the range of(5,15), so the expected result should be false.
    //16 is not in the range, so the expected result is false.
    //Testing result: this test passed with no failure.
    @Test
    public void testcase5Contains_AboveUpperBound() {
        Range range = new Range(5, 15);
        boolean actualResult = range.contains(16);
        assertEquals("16 is not in the range, so the expected result is false", false, actualResult);
    }

    //Test6: test negative range. -10 is in the range of (-15,5), so the expected result should be true.
    //this test passes with no failure
    //Testing result: -10 is in the range, so the expected result is true.
    @Test
    public void testcase6Contains_NegativeValue() {
        Range range = new Range(-15, -5);
        boolean actualResult = range.contains(-10);
        assertEquals("this test passes with no failure", true, actualResult);
    }

	 // Test 7: Test the value that is slightly higher than the lower bound.
	 // 5.0001 is in the range of (5,15), so the expected result is true.
	 // Testing result: This test passes with no failure.
	 @Test
	 public void testcase7Contains_SlightlyAboveLowerBound() {
	     Range range = new Range(5, 15);
	     boolean actualResult = range.contains(5.0001);
	     assertEquals("5.0001 is in the range of (5,15), so the expected result is true", true, actualResult);
	 }
	
	 // test 8: Test the value that is slightly lower than the lower bound.
	 // 4.9999 is not in the range, so the expected result should be false.
	 // Testing result: This test passes with no failure.
	 @Test
	 public void testcase8Contains_SlightlyBelowLowerBound() {
	     Range range = new Range(5, 15);
	     boolean actualResult = range.contains(4.9999);
	     assertEquals("4.9999 is not in the range, so the expected result should be false", false, actualResult);
	 }
	
	 // test 9: Test the value that is slightly lower than the upper bound.
	 // 14.9999 is in the range, so the expected result is true.
	 // Testing result: This test passes with no failure.
	 @Test
	 public void testcase9Contains_SlightlyBelowUpperBound() {
	     Range range = new Range(5, 15);
	     boolean actualResult = range.contains(14.9999);
	     assertEquals("14.9999 is in the range, so the expected result is true", true, actualResult);
	 }
	
	 // test 10: Test the value that is slightly higher than the upper bound.
	 // 15.0001 is not in the range, so the expected result is false.
	 // Testing result: This test passes with no failure.
	 @Test
	 public void testcase10Contains_SlightlyAboveUpperBound() {
	     Range range = new Range(5, 15);
	     boolean actualResult = range.contains(15.0001);
	     assertEquals("15.0001 is not in the range, so the expected result is false", false, actualResult);
	 }
	
	 // test 11: Test the extreme value.
	 // The expected result should be true.
	 // Testing result: This test passes with no failure.
	 @Test
	 public void testcase11Contains_ExtremeLowerBound() {
	     Range range = new Range(Double.MIN_VALUE, 10);
	     boolean actualResult = range.contains(Double.MIN_VALUE);
	     assertEquals("The expected result should be true", true, actualResult);
	 }
	
	 // Test 12: Test extreme values.
	 // The expected result should be true.
	 // Testing result: This test passes with no failure.
	 @Test
	 public void testcase12Contains_ExtremeValues() {
	     Range range = new Range(Double.MIN_VALUE, Double.MAX_VALUE);
	     boolean actualResult = range.contains(Double.MAX_VALUE);
	     assertEquals("The expected result should be true", true, actualResult);
	 }
	 
	 
	 
	 




	 

   
  //---------------------------------test cases for method intersects----------------------------------------
    
	// Test1: test partial overlap between ranges
	// The expected result should be true because 10,11,12,13,14,15 are overlapping values.
	// Testing result: this test failed after we run the program. Therefore, intersect method is wrong.
	@Test
	public void testcase1Intersect_PartialOverlap() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(10, 20);
	    assertEquals("The expected result should be true because 10,11,12,13,14,15 are overlapping values", true, actualResult);
	}

	// Test2: test ranges with no overlapping values.
	// The expected result is false as there are no overlapping values.
	// Testing result: this test passes with no failure.
	@Test
	public void testcase2Intersect_NoOverlap() {
	    Range range = new Range(5, 10);
	    boolean actualResult = range.intersects(11, 20);
	    assertEquals("The expected result is false as there are no overlapping values", false, actualResult);
	}

	// Test3: one range within another range.
	// The expected result is true because (6,10) is completely in the range of (5,15)
	// Testing result: this test passes with no failure.
	@Test
	public void testcase3Intersect_RangeWithinRange() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(6, 10);
	    assertEquals("The expected result is true because (6,10) is completely in the range of (5,15)", true, actualResult);
	}

	// Test4: test two negative ranges
	// The expected result is true because (-10,-1) is partially in the range of (-15,-5).
	// Testing result: this test failed after we run the program. Therefore, intersect method is wrong.
	@Test
	public void testcase4Intersect_NegativeRanges() {
	    Range range = new Range(-15, -5);
	    boolean actualResult = range.intersects(-10, -1);
	    assertEquals("The expected result is true because (-10,-1) is partially in the range of (-15,-5)", true, actualResult);
	}

	// Test5: test two ranges that overlap at lower bound
	// The expected result is true because 5,6,7,8,9,10 are overlapping
	// Testing result: this test passes with no failure.
	@Test
	public void testcase5Intersect_OverlapAtLowerBound() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(3, 10);
	    assertEquals("The expected result is true because 5,6,7,8,9,10 are overlapping", true, actualResult);
	}

	// Test6: test two ranges that overlap at upper bound
	// The expected result is true because 14,15 are overlapping values.
	// Testing result: this test failed.
	@Test
	public void testcase6Intersect_OverlapAtUpperBound() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(14, 17);
	    assertEquals("The expected result is true because 14,15 are overlapping values", true, actualResult);
	}

	// Test7: test two same ranges
	// The expected result is true because both ranges are identical.
	// Testing result: this test passes with no failure.
	@Test
	public void testcase7Intersect_IdenticalRanges() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(5, 15);
	    assertEquals("The expected result is true because both ranges are identical", true, actualResult);
	}

//	// Test8: test two ranges with the same lower bound
//	// The expected result is true because they share the same value 5.
//	// Testing result: this test passes with no failure.
//	@Test
//	public void testcase8Intersect_SameLowerBound() {
//	    Range range = new Range(5, 15);
//	    boolean actualResult = range.intersects(5, 5);
//	    assertEquals("The expected result is true because they share the same value 5", true, actualResult);
//	}
//
//	// Test9: test two ranges with the same upper bound
//	// The expected result is true because they share the same value 15.
//	// Testing result: this test failed after we run the program.
//	@Test
//	public void testcase9Intersect_SameUpperBound() {
//	    Range range = new Range(5, 15);
//	    boolean actualResult = range.intersects(15, 15);
//	    assertEquals("The expected result is true because they share the same value 15", true, actualResult);
//	}
	


    
    
  //---------------------------------test cases for getLength method----------------------------------------

	// Test1: test the length of a negative range
	// The expected result is 5 because (-5) - (-10) = 5
	// Testing result: this test passes with no failure.
	@Test
	public void testcase1Length_NegativeRange() {
	    Range range = new Range(-10, -5);
	    assertEquals("The expected result is 5 because (-5) - (-10) = 5", 5, range.getLength(), 0.000000001d);
	}

	// Test2: test the length of a positive range
	// The expected result is 5 because 10 - 5 = 5
	// Testing result: this test passes with no failure.
	@Test
	public void testcase2Length_PositiveRange() {
	    Range range = new Range(5, 10);
	    assertEquals("The expected result is 5 because 10 - 5 = 5", 5, range.getLength(), 0.000000001d);
	}

	// Test3: test the length of a range with positive upper bound and negative lower bound.
	// The expected result is 20 because 10 - (-10) = 20.
	// Testing result: this test passes with no failure.
	@Test
	public void testcase3Length_MixedRange() {
	    Range range = new Range(-10, 10);
	    assertEquals("The expected result is 20 because 10 - (-10) = 20", 20, range.getLength(), 0.000000001d);
	}

	// Test4: test the length of a range with positive upper bound and negative lower bound.
	// Creating a range with lower > upper is invalid and should throw an IllegalArgumentException.
	// Testing result: this test passes with no failure.
	@Test(expected = IllegalArgumentException.class)
	public void testcase4Length_InvalidRange() {
	    new Range(10, -10);
	}

	// Test5: test the length of a range with a zero length.
	// The expected result is 0 because 0 - 0 = 0.
	// Testing result: this test passes with no failure.
	@Test
	public void testcase5Length_ZeroLength() {
	    Range range = new Range(0, 0);
	    assertEquals("The expected result is 0 because 0 - 0 = 0", 0, range.getLength(), 0.000000001d);
	}

	// test6: test the length of a range with a zero lower bound and a positive upper bound.
	// The expected result is 10 because 10 - 0 = 10.
	// Testing result: this test passes with no failure.
	@Test
	public void testcase6Length_ZeroToLowerBound() {
	    Range range = new Range(0, 10);
	    assertEquals("The expected result is 10 because 10 - 0 = 10", 10,range.getLength(), 0.000000001d);
	}

	// Test7: test the length of a range with extreme values.
	// The expected result is 2000000 because 1000000 - (-1000000) = 2000000.
	// Testing result: this test passes with no failure.
	@Test
	public void testcase7Length_ExtremeValues() {
	    Range range = new Range(-1000000, 1000000);
	    assertEquals("The expected result is 2000000 because 1000000 - (-1000000) = 2000000", 2000000,range.getLength(), 0.000000001d);
	}

    
	
	
	

    
    
    
  //---------------------------------test cases for getCentralValue method----------------------------------------
    
	// Test1: test the central value of a range with negative upper bound and lower bound.
	// The expected result is -7.5 because ((-10) + (-5)) / 2 = -7.5
	// Testing result: this test passes with no failure.
	@Test
	public void testcase1CentralValue_NegativeRange() {
	    Range range = new Range(-10, -5);
	    assertEquals("-7.5 is the central value because ((-10) + (-5)) / 2 = -7.5", -7.5, range.getCentralValue(), 0.000000001d);
	}

	// Test2: test the central value of a range with positive upper bound and lower bound.
	// The expected result is 7.5 because ((5) + (10)) / 2 = 7.5
	// Testing result: this test passes with no failure.
	@Test
	public void testcase2CentralValue_PositiveRange() {
	    Range range = new Range(5, 10);
	    assertEquals("7.5 is the central value because ((5) + (10)) / 2 = 7.5", 7.5, range.getCentralValue(), 0.000000001d);
	}

	// Test3: test the central value of a range with a positive upper bound and a negative lower bound.
	// The expected result is 0 because ((-10) + (10)) / 2 = 0
	// Testing result: this test passes with no failure.
	@Test
	public void testcase3CentralValue_MixedRange() {
	    Range range = new Range(-10, 10);
	    assertEquals("0 is the central value because ((-10) + (10)) / 2 = 0", 0, range.getCentralValue(), 0.000000001d);
	}

	// Test4: test the central value of a range with a negative upper bound and a positive lower bound.
	// This setup is incorrect and will throw an IllegalArgumentException.
	// Testing result: this test passes with no failure.
	@Test(expected = IllegalArgumentException.class)
	public void testcase4CentralValue_InvalidRange() {
	    new Range(10, -10);
	}

	// Test5: test the central value of a range with a zero length range.
	// The expected result is 0 because ((0) + (0)) / 2 = 0
	// Testing result: this test passes with no failure.
	@Test
	public void testcase5Central() {
	    Range range = new Range(0, 0);
	    assertEquals("0 is the central value because ((0) + (0)) / 2 = 0", 0, range.getCentralValue(), 0.000000001d);
	}

	// Test6: test the central value of a range with extreme values.
	// The expected result is 0 because ((-1000000) + (1000000)) / 2 = 0
	// Testing result: this test passes with no failure.
	@Test
	public void testcase6CentralValue_ExtremeValues() {
	    Range range = new Range(-1000000, 1000000);
	    assertEquals("0 is the central value because ((-1000000) + (1000000)) / 2 = 0", 0, range.getCentralValue(), 0.000000001d);
	}

	// Test7: test the central value of a range with a zero lower bound.
	// The expected result is 5 because ((10) + (0)) / 2 = 5
	// Testing result: this test passes with no failure.
	@Test
	public void testcase7CentralValue_ZeroLowerBound() {
	    Range range = new Range(0, 10);
	    assertEquals("5 is the central value because ((10) + (0)) / 2 = 5", 5, range.getCentralValue(), 0.000000001d);
	}

	// Test8: test the central value of a range with a zero higher bound.
	// The expected result is -5 because ((-10) + (0)) / 2 = -5
	// Testing result: this test passes with no failure.
	@Test
	public void testcase8CentralValue_ZeroUpperBound() {
	    Range range = new Range(-10, 0);
	    assertEquals("-5 is the central value because ((-10) + (0)) / 2 = -5", -5, range.getCentralValue(), 0.000000001d);
	}
	
	
	

	////Additional test cases to address survived mutants
	

	
	
    
    

    
  //---------------------------------test cases for getLowerBound and getUpperBound method----------------------------------------
    
	// Test1: test the upper bound and the lower bound of a range with a positive upper bound and a negative lower bound.
	// The expected result is -1 and 8 because the lower bound of -1 is -1 and the upper bound of 8 is 8.
	// Testing result: this test failed after we run the program.
	@Test
	public void testcase1Bounds_PositiveUpper_NegativeLower() {
	    Range range = new Range(-1, 8);
	    assertEquals("The lower bound should be -1", -1, range.getLowerBound(), 0.000000001d);
	    assertEquals("The upper bound should be 8", 8, range.getUpperBound(), 0.000000001d);
	}

	// Test2: test the upper bound and the lower bound of a range with a zero upper bound and a zero lower bound.
	// The expected result is 0 and 0 because the lower bound of 0 is 0 and the upper bound of 0 is 0.
	// Testing result: this test passes with no failure.
	@Test
	public void testcase2Bounds_ZeroUpper_ZeroLower() {
	    Range range = new Range(0, 0);
	    assertEquals("Both bounds should be 0", 0, range.getLowerBound(), 0.000000001d);
	    assertEquals("Both bounds should be 0", 0, range.getUpperBound(), 0.000000001d);
	}

	// Test3: test the upper bound and the lower bound of a range with the same negative upper bound and lower bound.
	// The expected result is -1 and -1 because the lower bound of -1 is -1 and the upper bound of -1 is -1.
	// Testing result: this test passes with no failure.
	@Test
	public void testcase3Bounds_NegativeSame() {
	    Range range = new Range(-1, -1);
	    assertEquals("Both bounds should be -1", -1, range.getLowerBound(), 0.000000001d);
	    assertEquals("Both bounds should be -1", -1, range.getUpperBound(), 0.000000001d);
	}

	// Test4: test the upper bound and the lower bound of a range with a negative upper bound and lower bound.
	// The expected result is -10 and -1 because the lower bound of -10 is -10 and the upper bound of -1 is -1.
	// Testing result: this test failed after we run the program.
	@Test
	public void testcase4Bounds_NegativeUpper_Lower() {
	    Range range = new Range(-10, -1);
	    assertEquals("The lower bound should be -10", -10, range.getLowerBound(), 0.000000001d);
	    assertEquals("The upper bound should be -1", -1, range.getUpperBound(), 0.000000001d);
	}

	// Test5: test the upper bound and the lower bound of a range with extreme values.
	// The expected result is -1000000 and 1000000 because the lower bound of -1000000 is -1000000 and the upper bound of 1000000 is 1000000.
	// Testing result: this test failed after we run the program.
	@Test
	public void testcase5Bounds_ExtremeValues() {
	    Range range = new Range(-1000000, 1000000);
	    assertEquals("The lower bound should be -1000000", -1000000, range.getLowerBound(), 0.000000001d);
	    assertEquals("The upper bound should be 1000000", 1000000, range.getUpperBound(), 0.000000001d);
	}

	// Test6: test the upper bound and the lower bound of a range with a zero lower bound.
	// The expected result is 0 and 10 because the lower bound of 0 is 0 and the upper bound of 10 is 10.
	// Testing result: this test failed after we run the program.
	@Test
	public void testcase6Bounds_ZeroLower() {
	    Range range = new Range(0, 10);
	    assertEquals("The lower bound should be 0", 0, range.getLowerBound(), 0.000000001d);
	    assertEquals("The upper bound should be 10", 10, range.getUpperBound(), 0.000000001d);
	}

	// Test7: test the case when the lower bound is greater than the upper bound.
	// The expected result is throwing an IllegalArgumentException.
	// Testing result: this test passes with no failure.
	@Test(expected = IllegalArgumentException.class)
	public void testcase7Bounds_LowerGreaterThanUpper() {
	    new Range(10, 1); // This should throw an IllegalArgumentException
	}

	// Test8: test the upper bound and the lower bound of a range with the same positive upper bound and lower bound.
	// The expected result is 10 and 10 because the lower bound of 10 is 10 and the upper bound of 10 is 10.
	// Testing result: this test passes with no failure.
	@Test
	public void testcase8Bounds_PositiveSame() {
	    Range range = new Range(10, 10);
	    assertEquals("Both bounds should be 10", 10, range.getLowerBound(), 0.000000001d);
	    assertEquals("Both bounds should be 10", 10, range.getUpperBound(), 0.000000001d);
	}
	
	
	
	
	
	//--------------------------------- additional test cases for assignment3----------------------------------------
   
	//---------------------------------test cases for method constrain----------------------------------------

	//Test1: Constrain a value within the range
	//10 is within the range of (5,15), so it should remain unchanged.
	//Testing result: this test passes with no failure.
	@Test
	public void testcase1Constrain_WithinRange() {
	    Range range = new Range(5, 15);
	    double actualResult = range.constrain(10);
	    assertEquals("10 is within the range of (5,15)", 10, actualResult, 0.0001);
	}

	//Test2: Constrain a value equal to the lower bound
	//5 is equal to the lower bound of the range (5,15), so it should remain unchanged.
	//Testing result: this test passes with no failure.
	@Test
	public void testcase2Constrain_EqualToLowerBound() {
	    Range range = new Range(5, 15);
	    double actualResult = range.constrain(5);
	    assertEquals("5 is equal to the lower bound of the range (5,15)", 5, actualResult, 0.0001);
	}

	//Test3: Constrain a value equal to the upper bound
	//15 is equal to the upper bound of the range (5,15), so it should remain unchanged.
	@Test
	public void testcase3Constrain_EqualToUpperBound() {
	    Range range = new Range(5, 15);
	    double actualResult = range.constrain(15);
	    assertEquals("15 is equal to the upper bound of the range (5,15)", 15, actualResult, 0.0001);
	}

	//Test4: Constrain a value below the lower bound
	//4 is below the lower bound of the range (5,15), so it should be constrained to 5.
	@Test
	public void testcase4Constrain_BelowLowerBound() {
	    Range range = new Range(5, 15);
	    double actualResult = range.constrain(4);
	    assertEquals("4 is below the lower bound of the range (5,15)", 5, actualResult, 0.0001);
	}

	//Test5: Constrain a value above the upper bound
	//16 is above the upper bound of the range (5,15), so it should be constrained to 15.
	@Test
	public void testcase5Constrain_AboveUpperBound() {
	    Range range = new Range(5, 15);
	    double actualResult = range.constrain(16);
	    assertEquals("16 is above the upper bound of the range (5,15)", 15, actualResult, 0.0001);
	}

	//Test6: Constrain a negative value within a negative range
	//-10 is within the range of (-15,-5), so it should not be altered.
	@Test
	public void testcase6Constrain_NegativeValueWithinRange() {
	    Range range = new Range(-15, -5);
	    double actualResult = range.constrain(-10);
	    assertEquals("-10 is within the range of (-15,-5)", -10, actualResult, 0.0001);
	}
	
	
	

	


	
	
	

	
	//---------------------------------test cases for method intersects(Range range)----------------------------------------

	//Test1: test partial overlap with another range object.
	//The expected result should be true because the ranges partially overlap.
	@Test
	public void testcase1Intersects_PartialOverlapWithRangeObject() {
	    Range range1 = new Range(5, 15);
	    Range range2 = new Range(10, 20);
	    boolean actualResult = range1.intersects(range2);
	    assertEquals("The expected result should be true because the ranges partially overlap", true, actualResult);
	}

	//Test2: test no overlap with another range object.
	//The expected result is false as there are no overlapping values.
	@Test
	public void testcase2Intersects_NoOverlapWithRangeObject() {
	    Range range1 = new Range(5, 10);
	    Range range2 = new Range(11, 20);
	    boolean actualResult = range1.intersects(range2);
	    assertEquals("The expected result is false as there are no overlapping values", false, actualResult);
	}


	
	//---------------------------------test cases for method expand----------------------------------------

	// Test1: Expand both bounds with positive margins
	// Both bounds should be correctly expanded, so the new range is larger than the original.
//	@Test
//	public void testcase1Expand_PositiveMargins() {
//	    Range originalRange = new Range(10, 20);
//	    Range expandedRange = Range.expand(originalRange, 0.1, 0.1); 
//	    assertEquals("New range should be from 9 to 22", new Range(9, 22), expandedRange);
//	}

	// Test2: Expand with a negative lower margin and positive upper margin
	// Lower bound should decrease and upper bound should increase, expanding the range.
//	@Test
//	public void testcase2Expand_NegativeLowerPositiveUpper() {
//	    Range originalRange = new Range(10, 20);
//	    Range expandedRange = Range.expand(originalRange, -0.1, 0.2); 
//	    assertEquals("New range should be from 11 to 24", new Range(11, 24), expandedRange);
//	}


	// Test3: Larger negative lower margin, slight positive upper margin increase
//	@Test
//	public void testcase3Expand_LargerNegativeLowerThanPositiveUpper() {
//	    Range originalRange = new Range(1, 2);
//	    Range expandedRange = Range.expand(originalRange, -2, 0.5); 
//	    assertEquals("New range should be from -1 to 2.5", new Range(-1, 2.5), expandedRange);
//	}

	

	
	//---------------------------------test cases for method expandToInclude----------------------------------------

	// Test1: Expanding a null range to include a value.
	// A null range is expanded to include 5, so the expected range is (5,5).
	@Test
	public void testcase1ExpandToInclude_NullRange() {
	    Range expectedRange = new Range(5, 5);
	    Range actualRange = Range.expandToInclude(null, 5);
	    assertEquals("A null range is expanded to include 5, so the expected range is (5,5)", expectedRange, actualRange);
	}

	// Test2: Expanding a range to include a value within the range.
	// Including 10 in the range of (5,15) does not change the range.
	@Test
	public void testcase2ExpandToInclude_ValueWithinRange() {
	    Range range = new Range(5, 15);
	    Range actualRange = Range.expandToInclude(range, 10);
	    assertEquals("Including 10 in the range of (5,15) does not change the range", range, actualRange);
	}

	// Test3: Expanding a range to include a value below the lower bound.
	// Including 2 in the range of (5,15) expands the range to (2,15).
	@Test
	public void testcase3ExpandToInclude_ValueBelowLowerBound() {
	    Range range = new Range(5, 15);
	    Range expectedRange = new Range(2, 15);
	    Range actualRange = Range.expandToInclude(range, 2);
	    assertEquals("Including 2 in the range of (5,15) expands the range to (2,15)", expectedRange, actualRange);
	}

	// Test4: Expanding a range to include a value above the upper bound.
	// Including 20 in the range of (5,15) expands the range to (5,20).
	@Test
	public void testcase4ExpandToInclude_ValueAboveUpperBound() {
	    Range range = new Range(5, 15);
	    Range expectedRange = new Range(5, 20);
	    Range actualRange = Range.expandToInclude(range, 20);
	    assertEquals("Including 20 in the range of (5,15) expands the range to (5,20)", expectedRange, actualRange);
	}




	//---------------------------------test cases for method combineIgnoringNaN----------------------------------------

	// Test1: Combining two non-null ranges without NaN values.
	// The expected result should be a new range that encompasses both ranges.
	@Test
	public void testcase1CombineIgnoringNaN_BothNonNull() {
	    Range range1 = new Range(1, 5);
	    Range range2 = new Range(6, 10);
	    Range expected = new Range(1, 10);
	    Range actual = Range.combineIgnoringNaN(range1, range2);
	    assertEquals("The expected result should be a new range from 1 to 10", expected, actual);
	}

	// Test2: Combining one null range and one non-null range.
	// The expected result should be the non-null range.
	@Test
	public void testcase2CombineIgnoringNaN_OneNullOneNonNull() {
	    Range range1 = null;
	    Range range2 = new Range(5, 15);
	    Range actual = Range.combineIgnoringNaN(range1, range2);
	    assertEquals("The expected result should be the non-null range (5, 15)", range2, actual);
	}

	// Test3: Combining two null ranges.
	// The expected result should be null.
	@Test
	public void testcase3CombineIgnoringNaN_BothNull() {
	    Range actual = Range.combineIgnoringNaN(null, null);
	    assertNull("The expected result should be null", actual);
	}

	// Test4: Combining ranges where one has NaN bounds.
	// The expected result should ignore the NaN range and return the valid one.
	@Test
	public void testcase4CombineIgnoringNaN_OneRangeWithNaN() {
	    Range range1 = new Range(Double.NaN, Double.NaN);
	    Range range2 = new Range(5, 15);
	    Range actual = Range.combineIgnoringNaN(range1, range2);
	    assertEquals("The expected result should ignore the NaN range and return the valid one (5, 15)", range2, actual);
	}

	// Test5: Combining two ranges where both have NaN bounds.
	// The expected result should be null since both ranges are considered invalid.
	@Test
	public void testcase5CombineIgnoringNaN_BothRangesWithNaN() {
	    Range range1 = new Range(Double.NaN, Double.NaN);
	    Range range2 = new Range(Double.NaN, Double.NaN);
	    Range actual = Range.combineIgnoringNaN(range1, range2);
	    assertNull("The expected result should be null since both ranges are considered invalid", actual);
	}

	// Test6: Combining two overlapping ranges without NaN.
	// The expected result should be a new range that spans the union of both ranges.
	@Test
	public void testcase6CombineIgnoringNaN_OverlappingRanges() {
	    Range range1 = new Range(1, 10);
	    Range range2 = new Range(5, 15);
	    Range expected = new Range(1, 15);
	    Range actual = Range.combineIgnoringNaN(range1, range2);
	    assertEquals("The expected result should be a new range from 1 to 15", expected, actual);
	}

	// Test7: Combining two identical ranges.
	// The expected result should be equal to either of the original ranges.
	@Test
	public void testcase7CombineIgnoringNaN_IdenticalRanges() {
	    Range range1 = new Range(5, 15);
	    Range range2 = new Range(5, 15);
	    Range actual = Range.combineIgnoringNaN(range1, range2);
	    assertEquals("The expected result should be equal to the original range (5, 15)", range1, actual);
	}
	
	
	// Test8: Combining a non-null range with a null range.
	// The expected result should be the non-null range.
	@Test
	public void testcase8CombineIgnoringNaN_Range2Null() {
	    Range range1 = new Range(10, 15);
	    Range range2 = null;
	    Range actual = Range.combineIgnoringNaN(range1, range2);
	    assertEquals("The expected result should be the non-null range (10, 15)", range1, actual);
	}

	// Test9: Combining a non-null range with a range that has NaN bounds.
	// The expected result should be the non-null range.
	@Test
	public void testcase9CombineIgnoringNaN_Range2NaN() {
	    Range range1 = new Range(10, 15);
	    Range range2 = new Range(Double.NaN, Double.NaN);
	    Range actual = Range.combineIgnoringNaN(range1, range2);
	    assertEquals("The expected result should be the non-null range (10, 15)", 10, actual.getLowerBound(), 0);
	    assertEquals(15, actual.getUpperBound(), 0);
	}

	// Test10: Combining a null range with a range that has NaN bounds.
	// The expected result should be null since both inputs are considered invalid.
	@Test
	public void testcase10CombineIgnoringNaN_Range1NullAndRange2NaN() {
	    Range range1 = null;
	    Range range2 = new Range(Double.NaN, Double.NaN);
	    Range actual = Range.combineIgnoringNaN(range1, range2);
	    assertNull("The expected result should be null since both inputs are considered invalid", actual);
	}

	// Test11: Combining a range with NaN bounds with a null range.
	// The expected result should be null since both inputs are considered invalid.
	@Test
	public void testcase11CombineIgnoringNaN_Range2NullAndRange1NaN() {
	    Range range1 = new Range(Double.NaN, Double.NaN);
	    Range range2 = null;
	    Range actual = Range.combineIgnoringNaN(range1, range2);
	    assertNull("The expected result should be null since both inputs are considered invalid", actual);
	}

	
	//---------------------------------test cases for method shift----------------------------------------

	// Test3: Shift a negative range by a positive delta.
	// Shifting (-15, -5) by 10 results in a new range of (-5, 5).
//	@Test
//	public void testcase3Shift_NegativeRangePositiveDelta() {
//	    Range base = new Range(-15, -5);
//	    Range expected = new Range(-5, 5);
//	    Range actual = Range.shift(base, 10);
//	    assertEquals("Shifting (-15, -5) by 10 results in a new range of (-5, 5)", expected, actual);
//	}

	// Test4: Shift a range resulting in zero crossing.
	// Shifting (5, 15) by -10 results in a new range of (-5, 5).
//	@Test
//	public void testcase4Shift_ZeroCrossing() {
//	    Range base = new Range(5, 15);
//	    Range expected = new Range(-5, 5);
//	    Range actual = Range.shift(base, -10);
//	    assertEquals("Shifting (5, 15) by -10 results in a new range of (-5, 5)", expected, actual);
//	}

	
	//---------------------------------test cases for method scale----------------------------------------

	
	// Test4: Scale a range by a factor of 0 (to a single point)
	// Scaling the range (5, 15) by a factor of 0 should result in (0, 0)
	@Test
	public void testcase4Scale_ToSinglePoint() {
	    Range base = new Range(5, 15);
	    Range expected = new Range(0, 0);
	    Range actual = Range.scale(base, 0);
	    assertEquals("Scaling (5, 15) by 0 should result in (0, 0)", expected, actual);
	}

	// Test5: Attempt to scale a range by a negative factor (expect IllegalArgumentException)
	// Scaling any range by a negative factor should throw IllegalArgumentException
	@Test(expected = IllegalArgumentException.class)
	public void testcase5Scale_NegativeFactor() {
	    Range base = new Range(5, 15);
	    Range.scale(base, -1);
	}



	//---------------------------------test cases for method combine----------------------------------------

	

	// Test3: Combining two null ranges
	// Combining null with null should return null as per method definition.
	@Test
	public void testcase3Combine_NullRanges() {
	    Range range1 = null;
	    Range range2 = null;
	    Range actualResult = Range.combine(range1, range2);
	    assertNull("Combining null with null should return null", actualResult);
	}


	// Test5: Combining ranges with negative bounds
	// Combines (-10,-5) with (-15,-1) which should result in (-15,-1) as it encompasses both negative ranges.
	@Test
	public void testcase5Combine_NegativeBounds() {
	    Range range1 = new Range(-10, -5);
	    Range range2 = new Range(-15, -1);
	    Range expectedResult = new Range(-15, -1);
	    Range actualResult = Range.combine(range1, range2);
	    assertEquals("Combines (-10,-5) with (-15,-1) which should result in (-15,-1)", expectedResult, actualResult);
	}


	
	
	// Test4: Combining a non-null range with a null range
	// Combining (10,20) with null should return (10,20) as combining with null returns the non-null range.
	@Test
	public void testcase7Combine_NonNullAndNull() {
	    Range range1 = new Range(10, 20);
	    Range range2 = null;
	    Range expectedResult = new Range(10, 20);
	    Range actualResult = Range.combine(range1, range2);
	    assertEquals("Combining (10,20) with null should return (10,20)", expectedResult, actualResult);
	}

	
	
	
	//---------------------------------test cases for method hashCode----------------------------------------

	// Test1: Test hashCode consistency for the same range values
	// The expected result is that the hash codes for the same range should be identical.
	@Test
	public void testcase1HashCode_Consistency() {
	    Range range1 = new Range(5, 15);
	    Range range2 = new Range(5, 15);
	    assertEquals("The hash codes for the same range should be identical", range1.hashCode(), range2.hashCode());
	}



	
	//---------------------------------test cases for method equals----------------------------------------

	// Test 1: Test a range is not equal to an object that is not an instance of Range.
	// The expected result should be false.
	@Test
	public void testcase1Equals_DifferentObject() {
	    Range range = new Range(5, 15);
	    Object obj = new Object();
	    assertEquals("A range should not be equal to an object that is not a range", false, range.equals(obj));
	}

	
	
	//---------------------------------test cases for method shiftWithNoZeroCrossing(double value, double delta)----------------------------------------
	// Test1: Shift with no zero crossing value
	// Shifts (0,0) by 6 which should result in (6,6) as the new range.
	@Test
	public void test1ShiftWithNoZeroCrossingValue() {
	    Range testRange = new Range(0, 0);
	    Range shiftedRange = Range.shift(testRange, 6); 
	    assertEquals("Shifts (0,0) by 6 which should result in (6,6)", 6, shiftedRange.getLowerBound(), .000000001d);
	}

	// Test8: Intersect with b0 exactly the lower bound of the range
	// Checks if (5,15) intersects with (5,16) which should be true as b0 is exactly the lower bound.
	@Test
	public void testcase8Intersect_ExactLowerBound() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(5, 16);
	    assertEquals("Checks if (5,15) intersects with (5,16) which should be true", true, actualResult);
	}

	// Test9: Intersect when b0 is just below the lower bound of the range
	// Checks if (5,15) intersects with (4.9,10) which should be true as b0 is just below the lower bound and b1 is within the range.
	@Test
	public void testcase9Intersect_JustBelowLowerBound() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(4.9, 10);
	    assertEquals("Checks if (5,15) intersects with (4.9,10) which should be true", true, actualResult);
	}

	// Test10: Intersect when b1 is exactly the lower bound of the range
	// Checks if (5,15) intersects with (4,5) which should be false as b1 is exactly the lower bound.
	@Test
	public void testcase10Intersect_ExactLowerBoundB1() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(4, 5);
	    assertEquals("Checks if (5,15) intersects with (4,5) which should be false", false, actualResult);
	}

	// Test11: Intersect when b1 is exactly the upper bound of the range
	// Checks if (5,15) intersects with (5,15) which should be true as b1 is exactly the upper bound.
	@Test
	public void testcase11Intersect_ExactUpperBound() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(5, 15);
	    assertEquals("Checks if (5,15) intersects with (5,15) which should be true", true, actualResult);
	}

	// Test12: Intersect when b0 is within the range but b1 is below the lower bound
	// Checks if (5,15) intersects with (6,4) which should be false as b1 is below the lower bound of the range.
	@Test
	public void testcase12Intersect_B0WithinButB1Below() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(6, 4);
	    assertEquals("Checks if (5,15) intersects with (6,4) which should be false", false, actualResult);
	}

	// Test for intersect at lower boundary
	// Checks if (5,15) intersects with (5,20) which should be true as b0 is exactly at the lower boundary of the range.
	@Test
	public void testcaseIntersect_AtLowerBoundary() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(5, 20);
	    assertEquals("Checks if (5,15) intersects with (5,20) which should be true", true, actualResult);
	}

	// Test for intersect at upper boundary
	// Checks if (5,15) intersects with (15,20) which should be false as b0 is at the upper boundary of the range, hence not less than upper.
	@Test
	public void testcaseIntersect_AtUpperBoundary() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(15, 20);
	    assertEquals("Checks if (5,15) intersects with (15,20) which should be false", false, actualResult);
	}



	
	// Test for intersecting at the upper boundary with exact, just below, and just above scenarios
	// Examines if (5,15) intersects with (15,20), (14.9999,20), and (15.0001,20) under various boundary conditions.
	@Test
	public void testcaseIntersect_UpperBoundary() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(15, 20);
	    assertEquals("Expected false as b0 is exactly at the upper boundary of the range", false, actualResult);
	    actualResult = range.intersects(14.9999, 20);
	    assertEquals("Expected true as b0 is just below the upper boundary of the range", true, actualResult);
	    actualResult = range.intersects(15.0001, 20);
	    assertEquals("Expected false as b0 is just above the upper boundary of the range", false, actualResult);
	}

	// Test for shifting a positive range to negative values
	// Shifts (1,2) by -5 resulting in a new range of (-4,-3).
	@Test
	public void testcaseShift_PositiveRangeToNegative() {
	    Range rangeShift = new Range(1, 2);
	    Range shifted = Range.shift(rangeShift, -5, true);
	    assertEquals("Expected lower bound is -4 after shift", -4, shifted.getLowerBound(), 0.000000001d);
	    assertEquals("Expected upper bound is -3 after shift", -3, shifted.getUpperBound(), 0.000000001d);
	}

	// Test for getting the central value of a range
	// Calculates and verifies the central value of (2,10) is 6.
	@Test
	public void testcaseGetCentralValue() {
	    Range exRange = new Range(2, 10);
	    double actual = exRange.getCentralValue();
	    assertEquals("Central value of (2,10) should be 6", 6, actual, 0.000000001);
	}

	// Test for intersection with a higher number than the lower boundary
	// Verifies if a range (-10,10) intersects with (-11,15), expecting true.
	@Test
	public void testcaseIntersects_HigherNumberThanLower() {
	    Range range = new Range(-10, 10);
	    assertTrue("(-10,10) intersecting with (-11,15) should return true", range.intersects(-11, 15));
	}

	// Test for intersection with conditional boundaries outside of the range
	// Verifies if a range (-10,10) intersects with (-15,-15), expecting false.
	@Test
	public void testcaseIntersects_ConditionalBoundaries() {
	    Range range = new Range(-10, 10);
	    assertFalse("(-10,10) intersecting with (-15,-15) should return false", range.intersects(-15, -15));
	}

	// Test for hashCode consistency
	// Generates and checks the hash code for the range (2,6).
	@Test
	public void testcaseHashCode() {
	    Range range = new Range(2, 6);
	    int result = range.hashCode();
	    assertEquals("Hash code for (2,6) should be consistent", -2145910784, result);
	}

	// Test for combining ranges ignoring NaN
	// Combines two NaN ranges and verifies the result is null.
	@Test
	public void testcaseCombineIgnoringNaN_NullDoubleDoubleIfNaN() {
	    Range actual = Range.combineIgnoringNaN(new Range(Double.NaN, Double.NaN), new Range(Double.NaN, Double.NaN));
	    Range expected = null;
	    assertEquals("Combining two NaN ranges should result in null", expected, actual);
	}

	// Test for combining a NaN range with a valid range using combineIgnoringNaN
	// Combines a NaN range with (5, 10) and verifies (5, 10) is returned.
	@Test
	public void testcaseCombineIgnoringNaN_IfStatementDoubleDoubleNaN() {
	    Range actual = Range.combineIgnoringNaN(new Range(Double.NaN, Double.NaN), new Range(5, 10));
	    Range expected = new Range(5, 10);
	    assertEquals("Combining a NaN range with (5,10) should return (5,10)", expected, actual);
	}

	// Test for shifting a negative range to positive values
	// Shifts (-10,-2) by 5 resulting in a new range of (-5,3).
	@Test
	public void testcaseShift_NegativeRangeToPositive() {
	    Range range = new Range(-10, -2);
	    Range shifted = Range.shift(range, 5, true);
	    assertEquals("Expected lower bound is -5 after shift", -5, shifted.getLowerBound(), 0.000000001d);
	    assertEquals("Expected upper bound is 3 after shift", 3, shifted.getUpperBound(), 0.000000001d);
	}

	// Test shifting a range without crossing zero for the upper bound
	// Shifts range (0,0) by 5 expecting the upper bound to be 5.
	@Test
	public void testcaseShift_WithNoZeroCrossing_UpperBound() {
	    Range range = new Range(0, 0);
	    Range shiftedRange = Range.shift(range, 5);
	    assertEquals("Shifts range (0,0) by 5 expecting upper bound to be 5", 5, shiftedRange.getUpperBound(), 0.000000001d);
	}

	// Test shifting a range without crossing zero for the lower bound
	// Shifts range (0,0) by 5 expecting the lower bound to be 5.
	@Test
	public void testcaseShift_WithNoZeroCrossing_LowerBound() {
	    Range range = new Range(0, 0);
	    Range shiftedRange = Range.shift(range, 5);
	    assertEquals("Shifts range (0,0) by 5 expecting lower bound to be 5", 5, shiftedRange.getLowerBound(), 0.000000001d);
	}

	// Test equality with different range objects
	// Checks if ranges (-1,1) and (-10,10) are considered unequal.
	@Test
	public void testcaseEquals_DifferentObject() {
	    Range range1 = new Range(-1, 1);
	    Range range2 = new Range(-10, 10);
	    assertFalse("Checks if ranges (-1,1) and (-10,10) are considered unequal", range1.equals(range2));
	}

	// Test combining ranges with one null range
	// Combines null with range (1.0,2.0) expecting the result to be (1.0,2.0).
	@Test
	public void testcaseCombine_NullRange1() {
	    Range testRange1 = null;
	    Range testRange2 = new Range(1.0, 2.0);
	    assertEquals("Combines null with range (1.0,2.0) expecting (1.0,2.0)", testRange2, Range.combine(testRange1, testRange2));
	}

	// Test shifting under multiple conditions
	// Shifts (0,10) by 10 expecting (10,20), and shifts (-2,-1) by 5 expecting (0.0,0.0).
	@Test
	public void testcaseShift_MultipleConditions() {
	    Range range = Range.shift(new Range(0, 10), 10);
	    assertEquals("Shifts (0,10) by 10 expecting (10,20)", new Range(10, 20), range);
	    
	    range = Range.shift(new Range(-2, -1), 5);
	    assertEquals("Shifts (-2,-1) by 5 expecting (0.0,0.0)", new Range(0.0, 0.0), range);
	}

	// Test intersecting close values around the upper boundary
	// Checks close values around the upper boundary of range (-5,5) for intersection.
	@Test
	public void testcaseIntersect_CloseValues() {
	    Range range = new Range(-5, 5);
	    boolean actualResult = range.intersects(5.0001, 5.001);
	    assertEquals("Expected false as both b0 and b1 are just outside the upper boundary", false, actualResult);
	    actualResult = range.intersects(4.9999, 5);
	    assertEquals("Expected true as b0 is inside the range and b1 is at the upper boundary", true, actualResult);
	}

	// Test intersecting around the upper boundary with very close values
	// Examines intersection around the upper boundary of range (5,15) with close values.
	@Test
	public void testcaseIntersect_AroundUpperBoundary() {
	    Range range = new Range(5, 15);
	    boolean actualResult = range.intersects(14.999999, 20);
	    assertEquals("Expected true as b0 is just below the upper boundary", true, actualResult);
	    
	    actualResult = range.intersects(15.000001, 20);
	    assertEquals("Expected false as b0 is just above the upper boundary", false, actualResult);
	}
	
	// Test shifting a positive range by a positive amount
	// Shifts range (1,2) by 5 expecting new range to be (6,7).
	@Test
	public void testShift2PositiveRangePositive() {
	    Range range = new Range(1, 2);
	    Range shifted = Range.shift(range, 5, true);
	    assertEquals("Shifts range (1,2) by 5 expecting lower bound to be 6", 6, shifted.getLowerBound(), 0.000000001d);
	    assertEquals("Expecting upper bound to be 7 after shift", 7, shifted.getUpperBound(), 0.000000001d);
	}

	// Test equality with the same range object
	// Verifies a range is equal to itself.
	@Test
	public void testcaseEquals_SameRangeObject() {
	    Range range = new Range(-5, 5);
	    assertTrue("Verifies a range of [-5, 5] is equal to itself", range.equals(range));
	}

	// Test equality comparison with a non-Range object
	// Verifies a Range object is not equal to a Double object.
	@Test
	public void testcaseEquals_NotARangeObject() {
	    Range range = new Range(-15, 15);
	    assertFalse("Verifies a Range object is not equal to a non-Range (Double) object", range.equals((Double) 1.5d));
	}

	// Test equality with mismatch in lower bounds
	// Verifies two ranges are not equal if their lower bounds do not match.
	@Test
	public void testcaseEquals_LowerBoundMismatch() {
	    Range range = new Range(-5, 1);
	    assertFalse("Verifies two ranges are not equal if their lower bounds do not match", range.equals(new Range(-6, 1)));
	}

	// Test equality with mismatch in upper bounds
	// Verifies two ranges are not equal if their upper bounds do not match.
	@Test
	public void testcaseEquals_UpperBoundMismatch() {
	    Range range = new Range(-1, 5);
	    assertFalse("Verifies two ranges are not equal if their upper bounds do not match", range.equals(new Range(-1, 6)));
	}


    @After
    public void tearDown() throws Exception {
        // Teardown method for cleanup after each test method.
    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        // This method could be used for global cleanup after all tests are run.
    }
}

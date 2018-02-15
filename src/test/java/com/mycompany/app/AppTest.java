package com.mycompany.app;

import java.util.ArrayList;

import java.util.Arrays;

import junit.framework.TestCase;
import junit.framework.Test;
import junit.framework.TestCase;
import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
public class AppTest 
    extends TestCase
{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    public AppTest( String testName )
    {
        super( testName );
    }

    /**
     * @return the suite of tests being tested
     */
    public static Test suite()
    {
        return new TestSuite( AppTest.class );
    }

    /**
     * Rigourous Test :-)
     */
    public void testApp()
    {
        assertTrue( true );
    }

    public void testInputSizeNotMatch() {

      assertEquals("error",new App().calculateGrades(new String[]{"ali"},new Integer[]{1,2},new Integer[]{1,2},new Integer[]{1,2}));

    }

    public void testSuccess() {

     
            assertEquals(",1.0 ,2.0 ",new App().calculateGrades(new String[]{"ali","veli"},new Integer[]{1,2},new Integer[]{1,2},new Integer[]{1,2}));
   

    }

    public void testEmptyInput() {

       assertEquals("",new App().calculateGrades(new String[]{},new Integer[]{},new Integer[]{},new Integer[]{}));

    }

    public void testMid1Null() {

      assertEquals("names null",new App().calculateGrades(null,new Integer[]{1,2},new Integer[]{1,2},new Integer[]{1,2}));

    }

    public void testNameNull() {

      assertEquals("mid1 null",new App().calculateGrades(new String[]{"ali","veli"},null,new Integer[]{1,2},new Integer[]{1,2}));

    }

    public void testMid2Null() {

      assertEquals("mid2 null",new App().calculateGrades(new String[]{"ali","veli"},new Integer[]{1,2},null,new Integer[]{1,2}));

    }

    public void testFinalsNull() {

      assertEquals("finals null",new App().calculateGrades(new String[]{"ali","veli"},new Integer[]{1,2},new Integer[]{1,2},null));

    }
}

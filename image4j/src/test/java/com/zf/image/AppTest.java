package com.zf.image;

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

    public void testApp()
    {
    	
    	double i = 0.3;
    	double j = 0.1 ;
    	double m = i - j ;
    	System.out.println(m);
    	
    }
    
    public void test02(){
    	
    	/* 单位（分） */
    	int i = 30 ;
    	int j = 10 ;
    	int m = i - j ; 
    	
    	//转换为单位（圆）
    	double y = m * 0.01;
    	
    	System.out.println(y);  
    	
    }
    
}

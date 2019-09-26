package com.kausha.algo;

// https://www.geeksforgeeks.org/write-a-c-program-to-calculate-powxn/
/**
 * Input : x = 2, n = 3
Output : 8

Input : x = 7, n = 2
Output : 49

float x = 2;  int y = -3;
    Output = 0.12500

 * @author sinkar
 *
 */
public class XPowerN {

	static float power(float x, int y) 
    { 
        float temp; 
        if( y == 0) 
            return 1; 
        temp = power(x, y/2);  
          
        if (y%2 == 0) 
            return temp*temp; 
        else
        { 
            if(y > 0) 
                return x * temp * temp; 
            else
                return (temp * temp) / x; 
        } 
    }  
      
    /* Program to test function power */
    public static void main(String[] args) 
    { 
        float x = 2;
        int y = -3;
        System.out.printf("%f", power(x, y)); 
    } 
}

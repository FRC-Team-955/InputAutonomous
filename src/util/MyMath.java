/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 *
 * @author Merfoo
 */
public class MyMath
{
    /**
     * Sets the double to be only at the hundreth's place, ex. 12.34.
     */
    public static double SetDoublePrecision(double dDouble)
    {
        return (Double.valueOf(Math.floor(dDouble * 100 + 0.5) / 100)).doubleValue();
    }
}
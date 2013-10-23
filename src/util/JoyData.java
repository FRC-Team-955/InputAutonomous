/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package util;

/**
 * Holds data corresponding to the values of the robot.
 * @author Fauzi
 */ 
public class JoyData
{
    private double m_dTime = 0;
    private double m_dX = 0;
    private double m_dY = 0;
    
    public void setValues(double dTimer, double dX, double dY)
    {
        m_dTime = dTimer;
        m_dX = dX;
        m_dY = dY;
    }
    
    /**
     * Sets the values.
     * @param bot 
     */
    public void setValues(double dTime, MyJoystick joy)
    {
        setValues(dTime, joy.getMyX(), joy.getMyY());
    }
    
    public void setValues(JoyData emu)
    {
        m_dTime = emu.getTimer();
        m_dX = emu.getX();
        m_dY = emu.getY();
    }
    
    /**
     * Returns time stamp of the data.
     * @return 
     */
    public double getTimer()
    {
        return m_dTime;
    }
    
    /**
     * Gets the x value.
     * @return 
     */
    public double getX()
    {
        return m_dX;
    }
    
    /**
     * Gets the y value.
     * @return 
     */
    public double getY()
    {
        return m_dY;
    }
}
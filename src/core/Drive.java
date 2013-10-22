/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package core;
import edu.wpi.first.wpilibj.Talon;
import util.MyJoystick;
import util.Config;

/**
 *
 * @author Merfoo
 */
public class Drive 
{
    private MyJoystick joy;
    private double motorLeftSpeed;
    private double motorRightSpeed;
    private Talon motorLeft;
    private Talon motorRight;
    
    public Drive(MyJoystick stick)
    {
        joy = stick;
        motorLeft = new Talon(Config.chanMotorLeft);
        motorRight = new Talon(Config.chanMotorRight);
    }
    
    public void runArcade()
    {
        double joyX = joy.getMyX()*Math.abs(joy.getMyX());
        double joyY = joy.getMyY()*Math.abs(joy.getMyY());
        
        motorLeftSpeed = joyY+joyX;
        motorRightSpeed = joyY-joyX;
        setSpeed(motorLeftSpeed, motorRightSpeed);
    }
    
    private void setSpeed(double left, double right)
    {
        motorLeft.set(left);
        motorRight.set(right);
    }
    
    public double getLeftSpeed()
    {
        return motorLeft.get();
    }
    
    public double getRightSpeed()
    {
        return motorRight.get();
    }
}
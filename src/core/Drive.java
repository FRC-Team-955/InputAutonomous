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
    private Talon motorLeft1;
    private Talon motorLeft2;
    private Talon motorRight1;
    private Talon motorRight2;
    
    public Drive(MyJoystick stick)
    {
        joy = stick;
        motorLeft1 = new Talon(Config.chanDriveLeft1);
        motorLeft2 = new Talon(Config.chanDriveLeft2);
        motorRight1 = new Talon(Config.chanDriveRight1);
        motorRight2 = new Talon(Config.chanDriveRight2);
    }
    
    public void runArcade()
    {
        double joyX = joy.getMyX()*Math.abs(joy.getMyX());
        double joyY = joy.getMyY()*Math.abs(joy.getMyY());
        
        motorLeftSpeed = joyY+joyX;
        motorRightSpeed = joyY-joyX;
        setSpeed(motorLeftSpeed, motorRightSpeed);
        
        if(joy.gotPressed(Config.btPush))
            System.out.println("Button got Pressed");
    }
    
    private void setSpeed(double left, double right)
    {
        if(Math.abs(getLeftSpeed() - left) > Config.rampRate)
            left = getLeftSpeed() + (Config.rampRate * (getLeftSpeed() > left ? -1:1));
        
        if(Math.abs(getRightSpeed() - right) > Config.rampRate)
            right = getRightSpeed() + (Config.rampRate * (getRightSpeed() > right ? -1:1));
        
        motorLeft1.set(left);
        motorLeft2.set(left);
        motorRight1.set(right);
        motorRight2.set(right);
    }
    
    public double getLeftSpeed()
    {
        return motorLeft1.get();
    }
    
    public double getRightSpeed()
    {
        return motorRight1.get();
    }
}
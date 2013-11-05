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
        
        if(joy.gotPressed(Config.btEjector))
            System.out.println("Ejector got Pressed");
    }
    
    private void setSpeed(double newLeft, double newRight)
    {
        double currentLeft = motorLeft1.get();
        double currentRight = motorRight1.get();
        newLeft = -newLeft;
        
        if(Math.abs(currentLeft - newLeft) > Config.rampRate)
            newLeft = currentLeft + (Config.rampRate * (currentLeft > newLeft ? -1:1));
        
        if(Math.abs(currentRight - newRight) > Config.rampRate)
            newRight = currentRight + (Config.rampRate * (currentRight > newRight ? -1:1));
        
        motorLeft1.set(newLeft);
        motorLeft2.set(newLeft);
        motorRight1.set(newRight);
        motorRight2.set(newRight);
    }
}
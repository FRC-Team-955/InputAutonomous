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
public class Config 
{
    // Motors
    public static final double rampRate = 0.1;
    public static final int chanDriveLeft1 = 7;
    public static final int chanDriveLeft2= 8;
    public static final int chanDriveRight1 = 9;
    public static final int chanDriveRight2 = 10;

    // Ints
    public static final int ps3Port = 1;
    public static final int ps3Buttons = 13;
    
    // Button channel on the joystick
    public static final int btRecord = 9;
    public static final int btAllowEdit = 10;
    public static final int btReplay = 12;
    public static final int btPush = 1;
    
    // DriverStation Autonomous Button Channels
    public static final int stDigInAutoCenter = 1;
    public static final int stDigInAutoLeft = 2;
    public static final int stDigInAutoRight = 3;
    public static final int stDigInReg = 4;
    
    // Driverstation line
    public static final int stLineFile = 2;
    public static final int stLineAutonomous = 3;
}

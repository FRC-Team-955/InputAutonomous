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
    public static final int btEjector = 1;
    
    // DriverStation Digital Input Channels 1-8 available
    public static final int stDigInAutoCenter = 1;
    public static final int stDigInAutoLeft = 2;
    public static final int stDigInAutoRight = 3;
    public static final int stDigInReg = 4;
    public static final int stDigInDrive = 5;
    public static final int stDigInAutonomous = 6;
    public static final int stDigInRecorder = 7;
    public static final int stDigInReplayer = 8;
    
    // Driverstation line
    public static final int stLineFile = 2;
    public static final int stLineAutonomous = 3;
    
    // Output ids
    public static final int IdDrive = 1;
    public static final int IdAutonomous = 2;
    public static final int IdRecorder = 3;
    public static final int IdReplayer= 4;
}
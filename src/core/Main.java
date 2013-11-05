/*----------------------------------------------------------------------------*/
/* Copyright (c) FIRST 2008. All Rights Reserved.                             */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package core;


import edu.wpi.first.wpilibj.IterativeRobot;
import util.MyJoystick;
import util.Config;
import auto.Autonomous;

/**
 * The VM is configured to automatically run this class, and to call the
 * functions corresponding to each mode, as described in the IterativeRobot
 * documentation. If you change the name of this class or the package after
 * creating this project, you must also update the manifest file in the resource
 * directory.
 */
public class Main extends IterativeRobot 
{
    MyJoystick ps3Joy;
    Drive driveSystem;
    Autonomous auto;
    /**
     * This function is run when the robot is first started up and should be
     * used for any initialization code.
     */
    public void robotInit() 
    {
        ps3Joy = new MyJoystick(Config.ps3Port, Config.ps3Buttons);
        ps3Joy.setAxisChannel(MyJoystick.AxisType.kX, 3);
        ps3Joy.setAxisChannel(MyJoystick.AxisType.kY, 2);
        driveSystem = new Drive(ps3Joy);
        auto = new Autonomous(ps3Joy);
    }
    
     // This function is called when we disable the robot.
    public void disabledInit()
    {
        // Resets the replay to false if it was true before
        auto.resetAutonomous(); 
    }
    
    /* Called once in m_autonomous, tells m_autonomous which file to play based on
     * the value of "iFileType"
     */
    public void autonomousInit()
    {
        auto.setFile();
    }
    
    /**
     * This function is called periodically during autonomous
     */
    public void autonomousPeriodic() 
    {
        auto.replay();
        driveSystem.runArcade();
    }

    /**
     * This function is called periodically during operator control
     */
    public void teleopPeriodic() 
    {
        ps3Joy.updateButtons();
        driveSystem.runArcade();
        auto.run();
    }
    
    /**
     * This function is called periodically during test mode
     */
    public void testPeriodic() 
    {
    
    }    
}
/*----------------------------------------------------------------------------*/
/* Copyright (c) 2017-2018 FIRST. All Rights Reserved.                        */
/* Open Source Software - may be modified and shared by FRC teams. The code   */
/* must be accompanied by the FIRST BSD license file in the root directory of */
/* the project.                                                               */
/*----------------------------------------------------------------------------*/

package frc.robot;

/**
 * The RobotMap is a mapping from the ports sensors and actuators are wired into
 * to a variable name. This provides flexibility changing wiring, makes checking
 * the wiring easier and significantly reduces the number of magic numbers
 * floating around.
 */
public class RobotMap {
	// For example to map the left and right motors, you could define the
	// following variables to use with your drivetrain subsystem.
	// public static int leftMotor = 1;
	// public static int rightMotor = 2;

	// If you are using multiple modules, make sure to define both the port
	// number and the module. For example you with a rangefinder:
	
	public static final int xbox1 = 0;			//Drive Contoller
	public static final int xbox2 = 1;		    //Auxillary Controller
    public static final int LFSpark = 1;
    public static final int LBSpark = 2;
    public static final int RFSpark = 3;
	public static final int RBSpark = 4;
	
	public static final int intakeM = 5;
	public static final int shooterM = 8;
	public static final int indexM = 7;

	//Pnuematics
	public static final int ArmDoubleA = 7;			//Initial Double
	public static final int ArmDoubleB = 6;
	public static final int ArmB = 5;			//Secondary Solenoid
	public static final int Drive = 3;
	public static final int Lift = 2;

	public static final int PDP = 62;
	public static final int PCM = 0;
}
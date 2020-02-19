package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.IntakeCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
    Solenoid ArmOne;
    Solenoid ArmTwo;
    WPI_TalonSRX intakeMotor;

    public IntakeSubsystem() {
        ArmOne = new Solenoid(RobotMap.ArmA);
        ArmTwo = new Solenoid(RobotMap.ArmB);
        intakeMotor = new WPI_TalonSRX(RobotMap.intakeM);
    }

    public void Up() {
        ArmOne.set(false);
        ArmTwo.set(true);
    }

    public void Down() {
        ArmOne.set(true);
    }

    public void Turn(double x) {
		intakeMotor.set(x);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new IntakeCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }
}
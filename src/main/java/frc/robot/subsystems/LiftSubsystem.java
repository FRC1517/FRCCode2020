package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.LiftCommand;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {
    Solenoid LiftSolenoid;

    public LiftSubsystem() {
        LiftSolenoid = new Solenoid(RobotMap.Lift);
    }

    public void Up() {
        LiftSolenoid.set(true);
    }

    public void Down() {
        LiftSolenoid.set(false);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new LiftCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }
}
package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.LiftCommand;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.command.Subsystem;

public class LiftSubsystem extends Subsystem {
    DoubleSolenoid LiftDouble;

    public LiftSubsystem() {
        LiftDouble = new DoubleSolenoid(RobotMap.Lift, 3, 4);
    }

    public void Up() {
        LiftDouble.set(Value.kForward);
        LiftDouble.set(Value.kOff);
    }

    public void Down() {
        LiftDouble.set(Value.kReverse);
        LiftDouble.set(Value.kOff);
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
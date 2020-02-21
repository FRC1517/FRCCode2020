package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.ShooterCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.command.Subsystem;

public class ShooterSubsystem extends Subsystem {
    WPI_TalonSRX shooterMotor;
    WPI_TalonSRX indexMotor;

    public ShooterSubsystem() {
        shooterMotor = new WPI_TalonSRX(RobotMap.shooterM);
        indexMotor = new WPI_TalonSRX(RobotMap.indexM);
    }

    public void shoot(double x) {
		shooterMotor.set(x);
    }

    public void index(double x) {
		indexMotor.set(x);
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ShooterCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop

    }
}
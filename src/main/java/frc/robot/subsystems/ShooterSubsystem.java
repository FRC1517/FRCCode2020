package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.Robot;
import frc.robot.commands.ShooterCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.*;

public class ShooterSubsystem extends Subsystem {
    CANSparkMax shooterMotor;
    WPI_TalonSRX indexMotor;
    Servo tilter;

    public ShooterSubsystem() {
        shooterMotor = new CANSparkMax(RobotMap.shooterM, MotorType.kBrushless);
        shooterMotor.setInverted(true);

        indexMotor = new WPI_TalonSRX(RobotMap.indexM);

        tilter = new Servo (RobotMap.tilterS);

        shooterMotor.restoreFactoryDefaults();

    }

    public void shoot(double x) {
	    shooterMotor.set(-x);
    }

    public void index(double x) {
        indexMotor.set(x);
    }

    public void tiltUp() {
        tilter.set(0.5);
    }

    public void tiltDown() {
        tilter.set(1.0);
    }


    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ShooterCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        if (Robot.oi.getXbox2().getAButton()) {
            tiltDown();
            Robot.ShooterSub.shoot(.75);
            Robot.ShooterSub.index(.75);
        }


    }
}
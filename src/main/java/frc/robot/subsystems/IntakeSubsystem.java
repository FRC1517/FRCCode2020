package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.Robot;
import frc.robot.commands.IntakeCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
    DoubleSolenoid ArmOne;
    Solenoid ArmTwo;
    WPI_TalonSRX intakeMotor;

    public IntakeSubsystem() {
        ArmOne = new DoubleSolenoid(RobotMap.PCM, RobotMap.ArmDoubleA, RobotMap.ArmDoubleB);
        ArmTwo = new Solenoid(RobotMap.ArmB);
        intakeMotor = new WPI_TalonSRX(RobotMap.intakeM);

    }

    public void Up() {
        ArmOne.set(Value.kReverse);
        ArmTwo.set(true);
    }

    public void Down() {
        ArmOne.set(Value.kForward);
        ArmOne.set(Value.kOff);;
    }

    public void Hold() {
        ArmOne.set(Value.kReverse);
        ArmTwo.set(false);
    }

    // public void GoTo() {
    //     if (Robot.potentiometer.get() < 2.5) {
    //         while (Robot.potentiometer.get() < 2.5) 
    //             Up();
                
    //     }
    //     else if (Robot.potentiometer.get() > 2.5) {
    //         while (Robot.potentiometer.get() > 2.5 )
    //             Down();
    //     }
    //     Hold();
    // }

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
package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.IntakeCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
    DoubleSolenoid ArmOne;
    Solenoid ArmTwo;
    WPI_TalonSRX intakeMotor;
    int count;

    public IntakeSubsystem() {
        ArmOne = new DoubleSolenoid(RobotMap.PCM, RobotMap.ArmDoubleA, RobotMap.ArmDoubleB);
        ArmTwo = new Solenoid(RobotMap.ArmB);
        intakeMotor = new WPI_TalonSRX(RobotMap.intakeM);

    }

    public void Up() {
        //count = 0;
        ArmOne.set(Value.kReverse);
        ArmTwo.set(true);
    }

    public void Down() {
        //count = 0;
        ArmOne.set(Value.kForward);
    }

    public void Hold() {
        //count = 0;
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
        // count++;
        // if (count >= 25)
        //     ArmOne.set(Value.kOff);

    }
}
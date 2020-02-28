package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.IntakeCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.AnalogPotentiometer;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

import edu.wpi.first.wpilibj.command.Subsystem;

public class IntakeSubsystem extends Subsystem {
    DoubleSolenoid ArmOne;
    Solenoid ArmTwo;
    WPI_TalonSRX intakeMotor;
    AnalogPotentiometer potentiometer;
    int count;
    private boolean positionMode;
    private double position;
    private int lastAction;

    public IntakeSubsystem() {
        ArmOne = new DoubleSolenoid(RobotMap.PCM, RobotMap.ArmDoubleA, RobotMap.ArmDoubleB);
        ArmTwo = new Solenoid(RobotMap.ArmB);
        intakeMotor = new WPI_TalonSRX(RobotMap.intakeM);
        potentiometer = new AnalogPotentiometer(3, 270, -45);
        positionMode = false;
        lastAction = 0;
    }

    public void Up() {
        MoveUp();
        positionMode = false;
    }

    public void Down() {
        MoveDown();
        positionMode = false;
    }

    private void MoveUp() {
        ArmOne.set(Value.kReverse);
        ArmTwo.set(true);
    }

    private void MoveDown() {
        ArmOne.set(Value.kForward);
        ArmTwo.set(true);
    }

    public void Hold() {
        // count = 0;
        ArmOne.set(Value.kReverse);
        ArmTwo.set(false);
    }

    public void GoTo(double x) {
        positionMode = true;
        position = x;
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
        double value;
        double lowerPosition;
        double upperPosition;

        if (positionMode) {
            lowerPosition = position - 5;
            upperPosition = position + 10;
            value = potentiometer.get();
            SmartDashboard.putNumber("Potentiometer Value", value);
            if ((value < lowerPosition + 5) && (lastAction == 1)) {}
            else if (value < lowerPosition) {
                MoveUp();
                lastAction = 1;
            } 
            else if (value > upperPosition) {
                MoveDown();
                lastAction = -1;
            } 
            else {
                Hold();
                lastAction = 0;
            }
        }

    }
}
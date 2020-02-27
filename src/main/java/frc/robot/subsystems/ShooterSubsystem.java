package frc.robot.subsystems;

import frc.robot.RobotMap;
import frc.robot.commands.ShooterCommand;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import com.revrobotics.CANSparkMax;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;
import com.revrobotics.CANEncoder;
import com.revrobotics.CANPIDController;
import com.revrobotics.ControlType;

import edu.wpi.first.wpilibj.command.Subsystem;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

public class ShooterSubsystem extends Subsystem {
    CANSparkMax shooterMotor;
    WPI_TalonSRX indexMotor;
    Servo tilter;
    private CANPIDController pidControllerShooter;
    private CANEncoder encoderShooter;
    public double kP, kI, kD, kIz, kFF, kMaxOutput, kMinOutput, maxRPM;

    public ShooterSubsystem() {
        shooterMotor = new CANSparkMax(RobotMap.shooterM, MotorType.kBrushless);
        shooterMotor.setInverted(true);
        indexMotor = new WPI_TalonSRX(RobotMap.indexM);
        tilter = new Servo(RobotMap.tilterS);
        shooterMotor.restoreFactoryDefaults();
        pidControllerShooter = shooterMotor.getPIDController();

        // Encoder object created to display position values
        encoderShooter = shooterMotor.getEncoder();
    
        // PID coefficients
        kP = 0; 
        kI = 0;
        kD = 0; 
        kIz = 0; 
        kFF = 0.0001100; 
        kMaxOutput = 1; 
        kMinOutput = -1;
        maxRPM = 5700;
    
        // set PID coefficients
        pidControllerShooter.setP(kP);
        pidControllerShooter.setI(kI);
        pidControllerShooter.setD(kD);
        pidControllerShooter.setIZone(kIz);
        pidControllerShooter.setFF(kFF);
        pidControllerShooter.setOutputRange(kMinOutput, kMaxOutput);
    
        // display PID coefficients on SmartDashboard
        SmartDashboard.putNumber("P Gain", kP);
        SmartDashboard.putNumber("I Gain", kI);
        SmartDashboard.putNumber("D Gain", kD);
        SmartDashboard.putNumber("I Zone", kIz);
        SmartDashboard.putNumber("Feed Forward", kFF);
        SmartDashboard.putNumber("Max Output", kMaxOutput);
        SmartDashboard.putNumber("Min Output", kMinOutput);
    }

    public void shoot(double x) {
	    shooterMotor.set(-x);
    }

    public void index(double x) {
        indexMotor.set(x);
    }

    public void tiltUp() {
        tilter.set(0.6);
    }

    public void tiltDown() {
        tilter.set(1.0);
    }

    public void setSpeed(double setPoint) {
        double p = SmartDashboard.getNumber("P Gain", 0);
        double i = SmartDashboard.getNumber("I Gain", 0);
        double d = SmartDashboard.getNumber("D Gain", 0);
        double iz = SmartDashboard.getNumber("I Zone", 0);
        double ff = SmartDashboard.getNumber("Feed Forward", 0);
        double max = SmartDashboard.getNumber("Max Output", 0);
        double min = SmartDashboard.getNumber("Min Output", 0);
    
        // if PID coefficients on SmartDashboard have changed, write new values to controller
        if((p != kP)) { pidControllerShooter.setP(p); kP = p; }
        if((i != kI)) { pidControllerShooter.setI(i); kI = i; }
        if((d != kD)) { pidControllerShooter.setD(d); kD = d; }
        if((iz != kIz)) { pidControllerShooter.setIZone(iz); kIz = iz; }
        if((ff != kFF)) { pidControllerShooter.setFF(ff); kFF = ff; }
        if((max != kMaxOutput) || (min != kMinOutput)) { 
            pidControllerShooter.setOutputRange(min, max); 
          kMinOutput = min; kMaxOutput = max; 
        }

          pidControllerShooter.setReference(setPoint, ControlType.kVelocity);
          
          SmartDashboard.putNumber("SetPoint", setPoint);
          SmartDashboard.putNumber("ProcessVariable", encoderShooter.getVelocity());
    }

    @Override
    protected void initDefaultCommand() {
        setDefaultCommand(new ShooterCommand());
    }

    @Override
    public void periodic() {
        // Put code here to be run every loop
        SmartDashboard.putNumber("Motor", encoderShooter.getVelocity());
    }
}
package frc.robot.commands;

import frc.robot.Robot;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;

/**
 * 
 *
 */
public class DriveTrainCommand extends Command {

    public DriveTrainCommand() {
        // Use requires() here to declare subsystem dependencies
        requires(Robot.DriveSub);
    }

    // Called just before this Command runs the first time
    protected void initialize() {
    }

    // Called repeatedly when this Command is scheduled to run
    protected void execute() {
        Robot.DriveSub.arcadeDrive(Robot.oi.getXbox1().getY(Hand.kLeft), -Robot.oi.getXbox1().getX(Hand.kLeft));
        if (Robot.oi.getXbox1().getBumper(Hand.kLeft))
            Robot.DriveSub.arcadeDrive(Robot.oi.getXbox1().getY(Hand.kLeft) * .5, -Robot.oi.getXbox1().getX(Hand.kLeft) * .5);
    }

    // Make this return true when this Command no longer needs to run execute()
    protected boolean isFinished() {
        return false;
    }

    // Called once after isFinished returns true
    protected void end() {
    }

    // Called when another command which requires one or more of the same
    // subsystems is scheduled to run
    protected void interrupted() {
    }
}
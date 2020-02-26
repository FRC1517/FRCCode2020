package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;


public class ShooterCommand extends Command {

    private int delayCount;

	public ShooterCommand() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.ShooterSub);
	}

	// Called once when the command executes
	@Override
	protected void initialize() {
        Robot.ShooterSub.tiltUp();
        delayCount = 0;
    }
    
    @Override
    protected void execute() {
        Robot.ShooterSub.shoot(Robot.oi.getXbox2().getTriggerAxis(Hand.kRight)*.7);
        Robot.ShooterSub.index(Robot.oi.getXbox2().getY(Hand.kLeft)*.75);
        if (Robot.oi.getXbox2().getYButtonPressed()) {
            Robot.ShooterSub.tiltUp();
        }
        else if (Robot.oi.getXbox2().getBButtonPressed()) {
            Robot.ShooterSub.tiltDown();
        }
        else if (Robot.oi.getXbox2().getAButton()) {
            if (delayCount == 0){
                Robot.ShooterSub.setSpeed(4250.0);
                delayCount = 40;
            }
            else if (delayCount == 1){
                Robot.ShooterSub.index(.75);
                Robot.ShooterSub.tiltDown();
            }
        }
        if (delayCount > 0){
            delayCount--;
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
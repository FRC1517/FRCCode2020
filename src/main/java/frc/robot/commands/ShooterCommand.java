package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;
import edu.wpi.first.wpilibj.Timer;


public class ShooterCommand extends Command {

	public ShooterCommand() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.ShooterSub);
	}

	// Called once when the command executes
	@Override
	protected void initialize() {
		//Robot.ShooterSub.Up();
    }
    
    @Override
    protected void execute() {
        Robot.ShooterSub.shoot(Robot.oi.getXbox2().getTriggerAxis(Hand.kRight)*.75);
        Robot.ShooterSub.index(Robot.oi.getXbox2().getY(Hand.kLeft)*.75);
        while (Robot.oi.getXbox2().getAButton()) {
            Robot.ShooterSub.shoot(.75);
            Robot.ShooterSub.index(.75);
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
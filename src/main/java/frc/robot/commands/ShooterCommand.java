package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;


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
        Robot.ShooterSub.tiltUp();
    }
    
    @Override
    protected void execute() {
        Robot.ShooterSub.shoot(Robot.oi.getXbox2().getTriggerAxis(Hand.kRight)*.5);
        //Robot.ShooterSub.shoot(Robot.oi.getXbox2().getTriggerAxis(Hand.kLeft)*.45);
        Robot.ShooterSub.index(Robot.oi.getXbox2().getY(Hand.kLeft)*.75);
        if (Robot.oi.getXbox2().getYButtonPressed()) {
            Robot.ShooterSub.tiltUp();
        }
        else if (Robot.oi.getXbox2().getBButtonPressed()) {
            Robot.ShooterSub.tiltDown();
        }
    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
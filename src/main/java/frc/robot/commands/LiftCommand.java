package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class LiftCommand extends Command {

	public LiftCommand() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.LiftSub);
	}

	// Called once when the command executes
	@Override
	protected void initialize() {
		Robot.LiftSub.Down();
	}
	
    @Override
    protected void execute() {
		if (Robot.oi.getXbox2().getBumperPressed(Hand.kRight)) {
			Robot.LiftSub.Up();
		}
		else if (Robot.oi.getXbox2().getBumperPressed(Hand.kLeft)) {
			Robot.LiftSub.Down();
        }
    }
    @Override
    protected boolean isFinished() {
        return false;
    }
}
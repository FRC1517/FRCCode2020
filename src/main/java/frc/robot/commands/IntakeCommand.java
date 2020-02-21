package frc.robot.commands;

import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj.command.Command;
import frc.robot.Robot;

public class IntakeCommand extends Command {

	public IntakeCommand() {
		super();
		// Use requires() here to declare subsystem dependencies
		// eg. requires(chassis);
		requires(Robot.IntakeSub);
	}

	// Called once when the command executes
	@Override
	protected void initialize() {
		Robot.IntakeSub.Up();
	}
	
    @Override
    protected void execute() {
		Robot.IntakeSub.Turn(Robot.oi.getXbox2().getY(Hand.kLeft));
		if (Robot.oi.getXbox2().getBButtonPressed()) {
			Robot.IntakeSub.Down();
		}
		else if (Robot.oi.getXbox2().getYButtonPressed()) {
			Robot.IntakeSub.Up();
		}
		
    }
    @Override
    protected boolean isFinished() {
        return false;
    }
}
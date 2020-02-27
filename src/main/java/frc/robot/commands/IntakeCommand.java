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
		if (Robot.oi.getXbox1().getBButtonPressed())
			Robot.IntakeSub.Down();
		else if (Robot.oi.getXbox1().getXButtonPressed())
			Robot.IntakeSub.GoTo(45);
		else if (Robot.oi.getXbox1().getAButtonPressed())
			Robot.IntakeSub.Up();
		Robot.IntakeSub.Turn(Robot.oi.getXbox1().getTriggerAxis(Hand.kRight));



    }
    @Override
    protected boolean isFinished() {
        return false;
    }
}
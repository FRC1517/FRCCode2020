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
        Robot.ShooterSub.shoot(Robot.oi.getXbox2().getY(Hand.kRight));
        Robot.ShooterSub.index(Robot.oi.getXbox2().getY(Hand.kRight)*.25);
        if (Robot.oi.getXbox2().getYButtonPressed()) {
            
            
            Robot.ShooterSub.shoot(.75);
            Robot.ShooterSub.index(1);
        }
        else if (Robot.oi.getXbox2().getAButtonPressed()){
            Robot.ShooterSub.shoot(1);
        }
        else if (Robot.oi.getXbox2().getBButtonPressed()){
            Robot.ShooterSub.shoot(-1);
        }
        else if (Robot.oi.getXbox2().getBumperPressed(Hand.kRight)){
            Robot.ShooterSub.shoot(.25);
        }
        else if (Robot.oi.getXbox2().getBumperPressed(Hand.kRight)){
            Robot.ShooterSub.shoot(-.25);
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
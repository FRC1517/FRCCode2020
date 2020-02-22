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
            Timer time = new Timer();
            double currentTime = time.getFPGATimestamp();
            double markTime = 0;
            while (!(markTime - 10 > currentTime)) {
                Robot.ShooterSub.shoot(.75);
                Timer.delay(.5);
                Robot.ShooterSub.index(1);
                markTime = time.getFPGATimestamp();
            }
        }
        while (Robot.oi.getXbox2().getAButtonPressed()){
            Robot.ShooterSub.shoot(1);
        }
        while (Robot.oi.getXbox2().getBButtonPressed()){
            Robot.ShooterSub.shoot(-1);
        }
        while (Robot.oi.getXbox2().getBumperPressed(Hand.kRight)){
            Robot.ShooterSub.shoot(.25);
        }
        while (Robot.oi.getXbox2().getBumperPressed(Hand.kRight)){
            Robot.ShooterSub.shoot(-.25);
        }

    }

    @Override
    protected boolean isFinished() {
        return false;
    }
}
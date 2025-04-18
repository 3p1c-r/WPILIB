package frc.robot.commands;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.subsystems.Drivetrain;

public class driveCommands extends Command{
    private final Drivetrain drivetrain;
    private final Joystick controller;
    
    public driveCommands(Drivetrain drivetrain, Joystick controller){
        this.drivetrain = drivetrain;
        this.controller = controller;

        addRequirements(drivetrain);

    }

    @Override
    public void execute(){
        double speed = -controller.getY();
        double turn = controller.getX();

        drivetrain.drive(speed,turn);
    }

    @Override
    public void end(boolean interrupted){
        drivetrain.stopMotors();
    }

    @Override
    public boolean isFinished(){
        return false;
    }

}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.controls;
import edu.wpi.first.wpilibj.Joystick;
import frc.robot.Robot;
import frc.robot.commands.driveCommands;
import frc.robot.subsystems.Drivetrain;


public class RobotContainer {

  private static final int joystickPort = 0;

  private final Joystick controller = new Joystick(joystickPort);
  private final Drivetrain drivetrain = new Drivetrain();

  private final driveCommands driveCommand;

  public RobotContainer() {
    // Configure the trigger bindings
    this.driveCommand = new driveCommands(drivetrain, controller);
    configureBindings();
  }

  
  
  private void configureBindings() {
    drivetrain.setDefaultCommand(driveCommand);
  }
}
  

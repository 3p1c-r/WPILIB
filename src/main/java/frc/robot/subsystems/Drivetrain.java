package frc.robot.subsystems;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.PWMSparkMax;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class Drivetrain extends SubsystemBase {
    //Hardware Components for Motor Channel
    private static final int leftMotorChannel = 0;
    private static final int rightMotorChannel = 1;

    private PWMSparkMax leftMotor;
    private PWMSparkMax rightMotor;

    private DifferentialDrive robotDrive;

    public Drivetrain(){
        leftMotor = new PWMSparkMax(leftMotorChannel);
        rightMotor = new PWMSparkMax(rightMotorChannel);

        //Inverting the Motors
        rightMotor.setInverted(true);
        leftMotor.setInverted(false);

        robotDrive = new DifferentialDrive(leftMotor,rightMotor);

        robotDrive.setSafetyEnabled(true);
        robotDrive.setExpiration(0.1);
    }

    public void drive(double speed, double turn){
        robotDrive.arcadeDrive(speed, turn);
    }

    public void stopMotors(){
        drive(0, 0);
    }

    @Override
    public void periodic(){
        SmartDashboard.putNumber("Left Motor Speed", leftMotor.getPwmHandle());
        SmartDashboard.putNumber("Right Motor Speed", rightMotor.getPwmHandle());
    }

}

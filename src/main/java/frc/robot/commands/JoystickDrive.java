// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj.GenericHID.Hand;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.RobotContainer;
import frc.robot.subsystems.DriveTrain;

public class JoystickDrive extends CommandBase {
  
  private final DriveTrain driveSubsystem;
  private final static XboxController driverController = RobotContainer.driverController;

  /** Creates a new JoyStickDrive. */
  public JoystickDrive(DriveTrain drivetrain) {
    driveSubsystem = drivetrain;
    addRequirements(driveSubsystem);
    // Use addRequirements() here to declare subsystem dependencies.
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    //driveSubsystem.stop();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {

    double throttle = driverController.getY(Hand.kLeft);
    double rotate = driverController.getX(Hand.kRight);

    if((throttle > 0 && throttle < 0.25) || (throttle < 0 && throttle > -0.25)) {
      throttle = 0;
    } else if (throttle < -0.25) {
      throttle = -0.3;
    }
    else {
      throttle = 0.3;
    }

    if((rotate > 0 && rotate < 0.25) || (rotate < 0 && rotate > -0.25)) {
      rotate = 0;
    }

    rotate = rotate * 0.4;

    driveSubsystem.drive(throttle,rotate);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {}

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

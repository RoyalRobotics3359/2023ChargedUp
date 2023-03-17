// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elbow;

public class DriveForwardBackTimedDrive extends CommandBase {
  
  private Drive drive;

  private double seconds;

  private double power;

  private Timer timer;

  /** Creates a new AutonomousCommand. */
  public DriveForwardBackTimedDrive(Drive d, double s, double p) {

    timer = new Timer();

    drive = d;

    seconds = s;

    power = p;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {
    if (timer == null) {
      timer = new Timer();
    }
    timer.start();
  }

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    // elbow.extendShoulder();
    // if (timer.get() < seconds) {
    //   drive.setVoltage(power * Constants.MAX_VOLTAGE, power * Constants.MAX_VOLTAGE);
    // } else if (timer.get() > seconds && timer.get() < 2.0 * seconds) {
    //   drive.setVoltage(-1.0 * power * Constants.MAX_VOLTAGE, -1.0 * power * Constants.MAX_VOLTAGE);
    // } else {
    //   drive.motorStop();
    // }

    if (!timer.hasElapsed(seconds)) {
      drive.setVoltage(power * Constants.MAX_VOLTAGE, power * Constants.MAX_VOLTAGE);
    } else if (timer.hasElapsed(seconds) && !timer.hasElapsed(2.0 * seconds)) {
      drive.setVoltage(-1.0 * power * Constants.MAX_VOLTAGE, -1.0 * power * Constants.MAX_VOLTAGE);
    } else {
      drive.motorStop();
    }

  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    timer.stop();
    drive.motorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    if (timer.get() > 2.0 * seconds) {
      return true;
    }
    return false;
  }
}

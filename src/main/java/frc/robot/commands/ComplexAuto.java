// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.Timer;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elbow;

public class ComplexAuto extends CommandBase {
  
  private Drive drive;

  private double seconds;

  private double power;

  private Timer timer;

  /** Creates a new AutonomousCommand. */
  public ComplexAuto(Drive d) {

    timer = new Timer();

    drive = d;
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
    drive.setVoltage(power * Constants.MAX_VOLTAGE, power * Constants.MAX_VOLTAGE);

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
    if (timer.get() >= seconds) {
      return true;
    }
    return false;
  }
}

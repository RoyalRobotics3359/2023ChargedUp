// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OperatorConsole;
import frc.robot.subsystems.Drive;

public class JoystickDrive extends CommandBase {

  private Drive drive;
  
  private OperatorConsole console;
  
  /** Creates a new JoystickDrive. */
  public JoystickDrive(Drive d, OperatorConsole oc) {

    drive = d;
    console = oc;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    double leftPower = console.getDriveLeftStickY() * Constants.MAX_VOLTAGE * Constants.Speeds.maxDriveSpeed.getSpeed();
    double rightPower = console.getDriveRightStickY() * Constants.MAX_VOLTAGE * Constants.Speeds.maxDriveSpeed.getSpeed();
    drive.setVoltage(leftPower, rightPower);
    SmartDashboard.putNumber("Left Power", leftPower);
    SmartDashboard.putNumber("Right Power", rightPower);
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    drive.motorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

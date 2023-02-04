// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OperatorConsole;
import frc.robot.subsystems.TankDrive;

public class JoystickTankDrive extends CommandBase {
  OperatorConsole console;
  TankDrive drive;
  /** Creates a new JoystickTankDrive. */
  public JoystickTankDrive(OperatorConsole OC, TankDrive TD) {
    super();
    OC = console;
    TD = drive;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(drive);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (Constants.TANK_DRIVE_EXISTS) {
      double leftPower = console.getDriveLeftStickY() * Constants.MAX_SPEED * Constants.MAX_VOLTAGE;
      double rightPower = console.getDriveLeftStickY() * Constants.MAX_SPEED * Constants.MAX_VOLTAGE;
      drive.tankDriveVolts(leftPower, rightPower);
    }
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

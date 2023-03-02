// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;

import frc.robot.OperatorConsole;
import frc.robot.subsystems.Elbow;

public class OperateElbow extends CommandBase {

  private Elbow elbow;
  private OperatorConsole console;

  /** Creates a new OperateElbow. */
  public OperateElbow(Elbow e, OperatorConsole oc) {

    elbow = e;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(elbow);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (console.getGameLeftStickY() != 0.0 && console.getGameLeftStickY() > 0.0) {
      elbow.rotateUp();
    } else if (console.getGameLeftStickY() != 0.0 && console.getGameLeftStickY() < 0.0){
      elbow.rotateDown();
    } else {
      elbow.motorStop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    elbow.motorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

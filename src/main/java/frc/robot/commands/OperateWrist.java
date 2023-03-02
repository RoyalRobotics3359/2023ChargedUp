// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OperatorConsole;
import frc.robot.subsystems.Wrist;

public class OperateWrist extends CommandBase {

  private Wrist wrist;
  private OperatorConsole console;

  /** Creates a new OperateWrist. */
  public OperateWrist(Wrist w, OperatorConsole oc) {

    wrist = w;
    console = oc;

    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(wrist);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (console.getGameRightStickY() != 0.0 && console.getGameRightStickY() > 0.0) {
      wrist.rotateUp();
    } else if (console.getGameRightStickY() != 0.0 && console.getGameRightStickY() < 0.0){
      wrist.rotateDown();
    } else {
      wrist.motorStop();
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

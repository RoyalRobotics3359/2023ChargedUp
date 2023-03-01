// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.OperatorConsole;
import frc.robot.subsystems.Lift;

public class OperateLift extends CommandBase {

  private Lift lift;

  private OperatorConsole console;
  
  /** Creates a new OperateLift. */
  public OperateLift(Lift l, OperatorConsole oc) {
    lift = l;
    console = oc;
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(lift);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    if (console.getDriveDpadAngle() == 0 /* FIX ME: Change from Drive Controller to Game Controller*/) {
      lift.extendLift();
    } else if (console.getDriveDpadAngle() == 180 /* FIX ME: Change from Drive Controller to Game Controller*/) {
      lift.retractLift();
    } else {
      lift.motorStop();
    }
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    lift.motorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

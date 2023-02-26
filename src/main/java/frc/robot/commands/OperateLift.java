// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Constants;
import frc.robot.OperatorConsole;
import frc.robot.subsystems.Lift;

public class OperateLift extends CommandBase {

  private Lift lift;

  private OperatorConsole console;
  
  private double direction;
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
    if (console.getDriveDpadAngle() == Constants.D_PAD.UP /* FIX ME */) {
      direction = Constants.LIFT_SPEED;
    } else if (console.getDriveDpadAngle() == Constants.D_PAD.DOWN /* FIX ME */) {
      direction = -1.0 * Constants.LIFT_SPEED;
    } else {
      direction = 0.0;
    }
    lift.setPercentPower(direction);
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

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.commands;

import edu.wpi.first.wpilibj2.command.CommandBase;
import frc.robot.Lights;
import frc.robot.OperatorConsole;
import frc.robot.subsystems.Hand;

public class OpenHand extends CommandBase {

  private Hand hand;

  private OperatorConsole console;

  private Lights leds;
  /** Creates a new ControlHand. */
  public OpenHand(Hand h, OperatorConsole oc, Lights l) {

    hand = h;
    console = oc;
    leds = l;
    
    // Use addRequirements() here to declare subsystem dependencies.
    addRequirements(hand);
  }

  // Called when the command is initially scheduled.
  @Override
  public void initialize() {}

  // Called every time the scheduler runs while the command is scheduled.
  @Override
  public void execute() {
    hand.openHand();
    leds.setColorRed();
  }

  // Called once the command ends or is interrupted.
  @Override
  public void end(boolean interrupted) {
    hand.motorStop();
  }

  // Returns true when the command should end.
  @Override
  public boolean isFinished() {
    return false;
  }
}

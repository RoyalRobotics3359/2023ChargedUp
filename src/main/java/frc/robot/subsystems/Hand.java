// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.shuffleboard.Shuffleboard;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;
import frc.robot.Lights;

public class Hand extends SubsystemBase {

  private CANSparkMax handMotor;
  private RelativeEncoder handEncoder;

  // private Lights lights;

  /** Creates a new Hand. */
  public Hand(/*Lights l*/) {

    // lights = l;

    handMotor = new CANSparkMax(Constants.Motors.handMotor.getCAN_ID(), MotorType.kBrushless);

    handMotor.restoreFactoryDefaults();

    // Change isReversed to true if need be
    handMotor.setInverted(Constants.Motors.handMotor.isReversed());

    handMotor.setIdleMode(IdleMode.kBrake);

    handEncoder = handMotor.getEncoder();
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
    SmartDashboard.putNumber("Hand Encoder", getEncoderValue());
  }

  public void openHand() {
    handMotor.set(Constants.Speeds.handSpeed.getSpeed());
    // System.out.println("Hand.openHand() Encoder: " + handEncoder.getPosition());
  }

  public void closeHand() {
    handMotor.set(-1.0 * Constants.Speeds.handSpeed.getSpeed());
    // System.out.println("Hand.closeHand() Encoder: " + handEncoder.getPosition());
  }

  public void motorStop() {
    handMotor.set(0.0);
    // lights.setColorPurple();
  }

  public double getEncoderValue() {
    double encoderVal = handEncoder.getPosition();
    return encoderVal;
  }

}

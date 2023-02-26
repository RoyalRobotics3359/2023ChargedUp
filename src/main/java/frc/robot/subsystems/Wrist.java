// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Wrist extends SubsystemBase {

  private TalonSRX wristMotor;
  /** Creates a new Wrist. */
  public Wrist() {

    wristMotor = new TalonSRX(Constants.Motors.wristMotor.getCAN_ID());

    wristMotor.configFactoryDefault();

    wristMotor.setInverted(Constants.Motors.wristMotor.isReversed());

    wristMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void rotateUp() {
    wristMotor.set(TalonSRXControlMode.PercentOutput, Constants.WRIST_SPEED);
  }

  public void rotateDown() {
    wristMotor.set(TalonSRXControlMode.PercentOutput, Constants.WRIST_SPEED);
  }

  public void motorStop() {
    wristMotor.set(TalonSRXControlMode.PercentOutput, 0.0);
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elbow extends SubsystemBase {

  private TalonSRX elbowMotor;
  /** Creates a new Shoulder. */
  public Elbow() {

    elbowMotor = new TalonSRX(Constants.Motors.elbowMotor.getCAN_ID());

    elbowMotor.configFactoryDefault();

    elbowMotor.setInverted(Constants.Motors.elbowMotor.isReversed());

    elbowMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void rotateUp() {
    elbowMotor.set(TalonSRXControlMode.PercentOutput, Constants.ELBOW_SPEED);
  }

  public void rotateDown() {
    elbowMotor.set(TalonSRXControlMode.PercentOutput, -1.0 * Constants.ELBOW_SPEED);
  }

  public void motorStop() {
    elbowMotor.set(TalonSRXControlMode.PercentOutput, 0.0);
  }
}

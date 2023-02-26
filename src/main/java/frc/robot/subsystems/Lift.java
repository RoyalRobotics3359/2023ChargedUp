// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import com.revrobotics.CANSparkMax;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Lift extends SubsystemBase {

  private TalonSRX liftMotor;
  /** Creates a new Lift. */
  public Lift() {
    liftMotor = new TalonSRX(Constants.Motors.liftMotor.getCAN_ID());

    liftMotor.configFactoryDefault();
    
    liftMotor.setInverted(Constants.Motors.liftMotor.isReversed());

    liftMotor.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setPercentPower(double power) {
    liftMotor.set(TalonSRXControlMode.PercentOutput, power);
  }

  public void extendLift() {
    liftMotor.set(TalonSRXControlMode.PercentOutput, Constants.LIFT_SPEED);
  }

  public void retractLift() {
    liftMotor.set(TalonSRXControlMode.PercentOutput, Constants.LIFT_SPEED);
  }
}

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.AlternateEncoderType;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import com.ctre.phoenix.motorcontrol.InvertType;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;
import frc.robot.Constants;
import frc.robot.Constants.CanId;

public class SwerveModule extends SubsystemBase {

  private CANSparkMax driveMotor;
  private TalonSRX turnMotor;

  private RelativeEncoder driveEncoder;

  private AnalogInput absEncoder;

  private PIDController driveController;
  private PIDController turnController;

  private boolean absEncoderReversed;

  private double turnOffsetInRadians;

  /** Creates a new SwerveModule. */
  public SwerveModule(int driveCanId, int turnCanId, boolean driveReversed) {
    driveMotor = new CANSparkMax(driveCanId, MotorType.kBrushed);
    turnMotor = new TalonSRX(turnCanId);

    driveMotor.restoreFactoryDefaults();

    driveMotor.setInverted(driveReversed);
    turnMotor.setInverted(InvertType.None);

    driveMotor.setIdleMode(IdleMode.kBrake);
    turnMotor.setNeutralMode(NeutralMode.Brake);

    // driveMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, false);
    // driveMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, false);

    // driveController = new PIDController(DRIVE_kP, DRIVE_kI, DRIVE_kD);
    // turnController = new PIDController(TURN_kP, TURN_kI, TURN_kD);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setDriveVoltage(double volts) {
    driveMotor.setVoltage(volts);
  }

  public void setTurnVoltage(double volts) {
    turnMotor.set(TalonSRXControlMode.PercentOutput, volts / Constants.MAX_VOLTAGE);
  }

  // Sets angle of module in degrees
  public void setAngle(double angle) {

  }

  public double getTurnAngle() {
    System.out.println(turnMotor.getSelectedSensorPosition());
    return turnMotor.getSelectedSensorPosition();
  }
}

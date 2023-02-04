// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.AbsoluteEncoder;
import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.SparkMaxAbsoluteEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.math.kinematics.SwerveModuleState;
import edu.wpi.first.wpilibj.AnalogInput;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants.CanId;

public class SwerveModule extends SubsystemBase {

  private CANSparkMax driveMotor;
  private CANSparkMax turnMotor;

  private RelativeEncoder driveEncoder;
  private RelativeEncoder turnEncoder;

  private AnalogInput absEncoder;

  private PIDController driveController;
  private PIDController turnController;

  private boolean absEncoderReversed;

  private double turnOffsetInRadians;

  // PIDCONTROLLER CONSTANTS FOR DRIVE MOTORS
  public final double DRIVE_kP = 0.0;
  public final double DRIVE_kI = 0.0;
  public final double DRIVE_kD = 0.0;

  // PIDCONTROLLER CONSTANTS FOR TURN MOTORS
  public final double TURN_kP = 0.0;
  public final double TURN_kI = 0.0;
  public final double TURN_kD = 0.0;

  /** Creates a new SwerveModule. */
  public SwerveModule(int driveCanId, int turnCanId, boolean driveReversed) {
    driveMotor = new CANSparkMax(driveCanId, MotorType.kBrushed);
    turnMotor = new CANSparkMax(turnCanId, MotorType.kBrushed);

    driveMotor.restoreFactoryDefaults();
    turnMotor.restoreFactoryDefaults();

    driveMotor.setInverted(driveReversed);
    turnMotor.setInverted(false);

    driveMotor.setIdleMode(IdleMode.kBrake);
    turnMotor.setIdleMode(IdleMode.kBrake);

    // driveMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kForward, false);
    // driveMotor.enableSoftLimit(CANSparkMax.SoftLimitDirection.kReverse, false);

    driveController = new PIDController(DRIVE_kP, DRIVE_kI, DRIVE_kD);
    turnController = new PIDController(TURN_kP, TURN_kI, TURN_kD);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setDriveVoltage(double volts) {
    driveMotor.setVoltage(volts);
  }

  public void setTurnVoltage(double volts) {
    turnMotor.setVoltage(volts);
  }

  // Sets angle of module in degrees
  public void setAngle(double angle) {

  }
}

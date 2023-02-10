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

import com.ctre.phoenix.motorcontrol.FeedbackDevice;
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
  private RelativeEncoder turnEncoder;

  private AnalogInput absEncoder;

  private PIDController driveController;
  private PIDController turnController;

  private boolean absEncoderReversed;

  private double turnOffsetInRadians;

  /** Creates a new SwerveModule. */
  public SwerveModule(int driveCanId, int turnCanId, boolean driveReversed/*, boolean turnReversed, 
  int absEncoderId, double absEncoderOffset, boolean absoluteEncoderReversed*/) {

    driveMotor = new CANSparkMax(driveCanId, MotorType.kBrushed);
    turnMotor = new TalonSRX(turnCanId);

    driveMotor.restoreFactoryDefaults();
    turnMotor.configFactoryDefault();

    driveMotor.setInverted(driveReversed);
    turnMotor.setInverted(/*turnIsReversed(turnReversed)*/InvertType.None);

    driveMotor.setIdleMode(IdleMode.kBrake);
    turnMotor.setNeutralMode(NeutralMode.Brake);

    turnMotor.configSelectedFeedbackSensor(FeedbackDevice.CTRE_MagEncoder_Absolute, Constants.PID_LOOP_IDX, Constants.CAN_TIMEOUT);
    turnMotor.config_kF(0, Constants.Pid.TURN_MOTOR.getFeedForward(), Constants.CAN_TIMEOUT);
		turnMotor.config_kP(0, Constants.Pid.TURN_MOTOR.getP(), Constants.CAN_TIMEOUT);
		turnMotor.config_kI(0, Constants.Pid.TURN_MOTOR.getI(), Constants.CAN_TIMEOUT);
		turnMotor.config_kD(0, Constants.Pid.TURN_MOTOR.getD(), Constants.CAN_TIMEOUT);

    // driveEncoder = driveMotor.getEncoder();
    /* FIX ME: Set up turn motor encoder */

    // driveEncoder.setPositionConversionFactor(Constants.DRIVE_ENCODER_ROTATIONS_TO_METERS);
    // driveEncoder.setVelocityConversionFactor(Constants.DRIVE_ENCODER_RPM_TO_RAD_PER_SEC);


    // driveController = new PIDController(
    //   Constants.SWERVE_PID_ID.DRIVE_MOTOR_kP.getSWERVE_PID_ID(), 
    //   Constants.SWERVE_PID_ID.DRIVE_MOTOR_kI.getSWERVE_PID_ID(), 
    //   Constants.SWERVE_PID_ID.DRIVE_MOTOR_kD.getSWERVE_PID_ID());

    // turnController = new PIDController(
    //   Constants.SWERVE_PID_ID.TURN_MOTOR_kP.getSWERVE_PID_ID(), 
    //   Constants.SWERVE_PID_ID.TURN_MOTOR_kI.getSWERVE_PID_ID(), 
    //   Constants.SWERVE_PID_ID.TURN_MOTOR_kD.getSWERVE_PID_ID());

    // turnController.enableContinuousInput(-1.0 * Math.PI, Math.PI);

    // turnOffsetInRadians = absEncoderOffset;
    // absEncoderReversed = absoluteEncoderReversed;
    // absEncoder = new AnalogInput(absEncoderId);

  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  // public double getDrivePosition() {
  //   return driveEncoder.getPosition();
  // }

  // // public double getTurnPosition() {
    
  // // }

  // public double getDriveVelocity() {
  //   return driveEncoder.getVelocity();
  // }

  // public double getTurnVelocity() {

  // }

  // public double getAbsEncoderRad() {
  //   double angle = turnMotor.;
  // }

  public void setDriveVoltage(double volts) {
    driveMotor.setVoltage(volts);
  }

  public void setTurnVoltage(double volts) {
    turnMotor.set(TalonSRXControlMode.PercentOutput, volts / Constants.MAX_VOLTAGE);
  }

  // Sets turn angle of module in degrees
  public void setTurnAngle(double angle) {
    turnMotor.set(TalonSRXControlMode.Position, angle);
  }

  public double getTurnAngle() {
    System.out.println(turnMotor.getSensorCollection().getPulseWidthPosition());
    return turnMotor.getSelectedSensorPosition();
  }

  public static InvertType turnIsReversed(boolean isReversed) {
    // Checks to see which invert type for the talon srx (turn motor)
    if (isReversed == true) {
      return InvertType.InvertMotorOutput;
    } else {
      return InvertType.None;
    }
  }
}

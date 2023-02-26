// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Drive extends SubsystemBase {

  private CANSparkMax frontLeft;
  private CANSparkMax backLeft;
  private CANSparkMax frontRight;
  private CANSparkMax backRight;

  private DifferentialDrive drive;

  private RelativeEncoder leftEncoder;
  private RelativeEncoder rightEncoder;

  private MotorControllerGroup leftMotors;
  private MotorControllerGroup rightMotors;
  
  /** Creates a new Drive. */
  public Drive() {
    frontLeft = new CANSparkMax(Constants.Motors.leftFront.getCAN_ID(), MotorType.kBrushless);
    backLeft = new CANSparkMax(Constants.Motors.leftBack.getCAN_ID(), MotorType.kBrushless);
    frontRight = new CANSparkMax(Constants.Motors.rightFront.getCAN_ID(), MotorType.kBrushless);
    backRight = new CANSparkMax(Constants.Motors.rightBack.getCAN_ID(), MotorType.kBrushless);

    frontLeft.restoreFactoryDefaults();
    backLeft.restoreFactoryDefaults();
    frontRight.restoreFactoryDefaults();
    backRight.restoreFactoryDefaults();

    backLeft.follow(frontLeft);
    backRight.follow(frontRight);

    frontLeft.setInverted(Constants.Motors.leftFront.isReversed());
    backLeft.setInverted(Constants.Motors.leftBack.isReversed());
    frontRight.setInverted(Constants.Motors.rightFront.isReversed());
    backRight.setInverted(Constants.Motors.rightBack.isReversed());

    leftMotors = new MotorControllerGroup(frontLeft, backLeft);
    rightMotors = new MotorControllerGroup(frontRight, backRight);

    frontLeft.setIdleMode(IdleMode.kBrake);
    backLeft.setIdleMode(IdleMode.kBrake);
    frontRight.setIdleMode(IdleMode.kBrake);
    backRight.setIdleMode(IdleMode.kBrake);

    drive = new DifferentialDrive(leftMotors, rightMotors);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void setVoltage(double leftVolts, double rightVolts) {
    leftMotors.setVoltage(leftVolts);
    rightMotors.setVoltage(rightVolts);
    drive.feed();
  }

  public void motorStop() {
    leftMotors.setVoltage(0);
    rightMotors.setVoltage(0);
  }

}

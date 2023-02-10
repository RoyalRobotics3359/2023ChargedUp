// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.revrobotics.CANSparkMax;
import com.revrobotics.RelativeEncoder;
import com.revrobotics.CANSparkMax.IdleMode;
import com.revrobotics.CANSparkMaxLowLevel.MotorType;

import edu.wpi.first.math.controller.PIDController;
import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import edu.wpi.first.wpilibj.motorcontrol.MotorControllerGroup;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class TankDrive extends SubsystemBase {
  CANSparkMax leftFront, leftRear;
  CANSparkMax rightFront, rightRear;

  DifferentialDrive drive;

  MotorControllerGroup leftMotorControllerGroup, rightMotorControllerGroup;

  RelativeEncoder leftEncoder, rightEncoder;

  PIDController leftController, rightController;

  // PIDCONTROLLER CONSTANTS FOR DRIVE MOTORS
  public final double DRIVE_kP = 0.0;
  public final double DRIVE_kI = 0.0;
  public final double DRIVE_kD = 0.0;
  
  /** Creates a new TankDrive. */
  public TankDrive() {
    leftFront = new CANSparkMax(0, MotorType.kBrushed); /* FIX ME */
    leftRear = new CANSparkMax(1, MotorType.kBrushed); /* FIX ME */
    rightFront = new CANSparkMax(2, MotorType.kBrushed); /* FIX ME */
    rightRear = new CANSparkMax(3, MotorType.kBrushed); /* FIX ME */

    leftFront.restoreFactoryDefaults();
    leftRear.restoreFactoryDefaults();
    rightFront.restoreFactoryDefaults();
    rightRear.restoreFactoryDefaults();

    leftRear.follow(leftFront);
    rightRear.follow(rightFront);

    leftMotorControllerGroup = new MotorControllerGroup(leftFront, leftRear);
    rightMotorControllerGroup = new MotorControllerGroup(rightFront, rightRear);

    leftMotorControllerGroup.setInverted(false);
    rightMotorControllerGroup.setInverted(true);

    drive = new DifferentialDrive(leftMotorControllerGroup, rightMotorControllerGroup);

    leftEncoder = leftFront.getEncoder();
    rightEncoder = rightFront.getEncoder();

    leftController = new PIDController(DRIVE_kP, DRIVE_kI, DRIVE_kD);
    rightController = new PIDController(DRIVE_kP, DRIVE_kI, DRIVE_kD);

    leftFront.setIdleMode(IdleMode.kBrake);
    leftRear.setIdleMode(IdleMode.kBrake);
    rightFront.setIdleMode(IdleMode.kBrake);
    rightRear.setIdleMode(IdleMode.kBrake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void tankDriveVolts(double leftVolts, double rightVolts) {
    leftFront.setVoltage(leftVolts);
    rightFront.setVoltage(rightVolts);
    drive.feed();
  }
}

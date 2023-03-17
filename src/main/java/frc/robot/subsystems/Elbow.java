// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.TalonSRXControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Constants;

public class Elbow extends SubsystemBase {

  private TalonSRX elbowMotor1;
  private TalonSRX elbowMotor2;

  private DoubleSolenoid shoulder;

  private String shoulderState = "";
  /** Creates a new Shoulder. */
  public Elbow() {

    shoulder = new DoubleSolenoid(PneumaticsModuleType.CTREPCM, Constants.Pneumatics.shoulderOut.getId(), Constants.Pneumatics.shoulderIn.getId());

    elbowMotor1 = new TalonSRX(Constants.Motors.elbowMotor1.getCAN_ID());
    elbowMotor2 = new TalonSRX(Constants.Motors.elbowMotor2.getCAN_ID());

    elbowMotor1.configFactoryDefault();
    elbowMotor2.configFactoryDefault();

    elbowMotor1.setInverted(Constants.Motors.elbowMotor1.isReversed());
    elbowMotor2.setInverted(Constants.Motors.elbowMotor2.isReversed());

    elbowMotor1.setNeutralMode(NeutralMode.Brake);
    elbowMotor2.setNeutralMode(NeutralMode.Brake);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

  public void rotateUp() {
    elbowMotor1.set(TalonSRXControlMode.PercentOutput, Constants.Speeds.elbowSpeed.getSpeed());
    elbowMotor2.set(TalonSRXControlMode.PercentOutput, Constants.Speeds.elbowSpeed.getSpeed());
  }

  public void rotateDown() {
    elbowMotor1.set(TalonSRXControlMode.PercentOutput, -1.0 * Constants.Speeds.elbowSpeed.getSpeed());
    elbowMotor2.set(TalonSRXControlMode.PercentOutput, -1.0 * Constants.Speeds.elbowSpeed.getSpeed());
  }

  public void motorStop() {
    elbowMotor1.set(TalonSRXControlMode.PercentOutput, 0.0);
    elbowMotor2.set(TalonSRXControlMode.PercentOutput, 0.0);
  }

  public void extendShoulder() {
    shoulder.set(Value.kForward);
    System.out.println("Im extending");
  }

  public void retractShoulder() {
    shoulder.set(Value.kReverse);
    shoulderState = "retracted";
    System.out.println("Im retracting");

  }

  public void turnOffShoulder() {
    shoulder.set(Value.kOff);
    shoulderState = "extended";
  }

  public String getShoulderState() {
    return shoulderState;
  }


}

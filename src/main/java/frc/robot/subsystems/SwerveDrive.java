// // Copyright (c) FIRST and other WPILib contributors.
// // Open Source Software; you can modify and/or share it under the terms of
// // the WPILib BSD license file in the root directory of this project.

// package frc.robot.subsystems;

// import com.ctre.phoenix.motorcontrol.can.TalonSRX;

// import edu.wpi.first.wpilibj.motorcontrol.Talon;
// import edu.wpi.first.wpilibj2.command.SubsystemBase;
// import frc.robot.Constants;
// import frc.robot.Constants.WheelPosition;
// import frc.robot.Constants.CanId;

// public class SwerveDrive extends SubsystemBase {

//   private SwerveModule frontLeft;
//   private SwerveModule frontRight;
//   private SwerveModule rearLeft;
//   private SwerveModule rearRight;

//   /** Creates a new SwerveDrive. */
//   public SwerveDrive() {
    
//     frontLeft = new SwerveModule(CanId.frontLeftDrive.getId(), 
//       CanId.frontLeftTurn.getId(), 
//       CanId.frontLeftDrive.isReversed(), Constants.TurnOffset.FRONT_LEFT_OFFSET.getOffset());

//     // FIX ME: INITIALIZE REMAINING DRIVE MODULES

//   }

//   @Override
//   public void periodic() {
//     // This method will be called once per scheduler run
//   }

//   public void setDriveVoltage(double volts) {
//     frontLeft.setDriveVoltage(volts);
//     // FIX ME: SET REMAINING DRIVE MODULES
//   }

//   public void setTurnVoltage(double volts) {
//     frontLeft.setTurnVoltage(volts);
//   }

//   public void setTurnAngle(double angle) {
//     frontLeft.setTurnAngle(angle);
//   }

//   // public void applyOffset(double theta) {
//   //   frontleft.set(TalonSRX)
//   // }

//   public Double getTurnAngle(Constants.WheelPosition position) {
//     Double angle = null;
//     if (position == WheelPosition.FRONT_LEFT) {
//       angle = frontLeft.getTurnAngle();
//     }
//     return angle;
//   }
// }

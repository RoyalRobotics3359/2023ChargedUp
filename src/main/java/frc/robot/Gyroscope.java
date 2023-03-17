// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.ADIS16470_IMU;
import edu.wpi.first.wpilibj.SPI;
import edu.wpi.first.wpilibj.ADIS16448_IMU.IMUAxis;
import edu.wpi.first.wpilibj.ADIS16470_IMU.CalibrationTime;
import edu.wpi.first.wpilibj.SPI.Port;

/** Add your docs here. */
public class Gyroscope {

    private ADIS16470_IMU gyro;
    
    public Gyroscope() {

        // gyro = new ADIS16470_IMU(IMUAxis.kX, SPI.Port.kMXP, CalibrationTime._1s);

        gyro.calibrate();

    }

    public double getGyroAngle() {
        System.out.println("y-axis angle: " + gyro.getAngle());
        System.out.println("x-axis angle: " + gyro.getXComplementaryAngle());
        System.out.println("z-axis angle: " + gyro.getAngle());
        return gyro.getAngle();
    }





}

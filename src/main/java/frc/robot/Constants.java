// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.math.util.Units;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.XboxController;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {
  public static class OperatorConstants {
    public static final int kDriverControllerPort = 0;
  }

  // Enumeration of all wheel positions
  public enum WheelPosition {
    FRONT_LEFT,
    FRONT_RIGHT,
    REAR_LEFT,
    REAR_RIGHT;
  }

  //  Enumeration of all the CAN devices on the CAN bus
  //
  public enum CanId {
    // motor controllers on 40 amp breaker
    frontLeftDrive(6, false /* FIX ME */),
    frontLeftTurn(3, false  /* FIX ME */);
    
    private final int id;
    private final boolean reversed;
    
    private CanId(int newId, boolean rev) {
      id = newId;
      reversed = rev;
    }

    public int getId() {
      return id;
    }

    public boolean isReversed() {
      return reversed;
    }
  }

  public enum ControllerId {


  }

  public enum Pneumatics {

  }

  public enum Camera {
    HEIGHT(360),
    WIDTH(720),
    FPS(40),
    BRIGHTNESS(50);
    private final int val;

    private Camera(int value) {
      val = value;
    }

    public int getValue() {
      return val;
    }
  }

  public enum LED_COLORS {
    RED(0.61),
    BLUE(0.87),
    GREEN(0.77),
    ORANGE(0.65),
    PURPLE(0.91),
    YELLOW(0.69),
    RAINBOW(-0.99),
    TEAM(0.53); // This is the power level for switching between two teams

    private final double color;

    private LED_COLORS(double clr) {
      color = clr;
    }
    
    public double getColor() {
      return color;
    }
  }

  public final static int DRIVE_CONTROLLER_ID = 0;
  public final static int GAME_CONTROLLER_ID = 1;

  public final static double CONTROLLER_DEADBAND = 0.10;

  public final static double CONTROLLER_TRIGGER_DEADBAND = 0.5;

  public final static int LED_LIGHTS_PWM_PORT = 0;

  public final static String TEAM = "Blue";

  public final static double MAX_VOLTAGE = 10;

  public final static double MAX_SPEED = 0.7;

  public final static boolean TANK_DRIVE_EXISTS = false;

  public final static boolean SWERVE_DRIVE_EXISTS = true;

  // Swerve Gear Ratios
  public final static double WHEEL_DIAMETER_METERS = Units.inchesToMeters(4.0);
  public final static double DRIVE_MOTOR_GEAR_RATIO = (12/42)*(42/42)*(24/22)*(15/45);
  public final static double TURN_MOTOR_GEAR_RATIO = (8/34)*(34/24)*(24/72);
  public final static double DRIVE_ENCODER_ROTATIONS_TO_METERS = DRIVE_MOTOR_GEAR_RATIO * Math.PI * WHEEL_DIAMETER_METERS;
  public final static double TURN_ENCODER_ROTATIONS_TO_RAD = TURN_MOTOR_GEAR_RATIO * 2.0 * Math.PI;
  public final static double DRIVE_ENCODER_RPM_TO_RAD_PER_SEC = DRIVE_ENCODER_ROTATIONS_TO_METERS / 60.0;
  public final static double TURN_ENCODER_RPM_TO_RAD_PER_SEC = TURN_ENCODER_ROTATIONS_TO_RAD / 60.0;
  public final static int ENCODER_COUNTS_PER_REVOLUTION = 4096;
}
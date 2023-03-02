// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

/**
 * The Constants class provides a convenient place for teams to hold robot-wide numerical or boolean
 * constants. This class should not be used for any other purpose. All constants should be declared
 * globally (i.e. public static). Do not put anything functional in this class.
 *
 * <p>It is advised to statically import this class (or one of its inner classes) wherever the
 * constants are needed, to reduce verbosity.
 */
public final class Constants {

  public enum Motors {
    /* Motor(CAN_ID, isReversed) */
    leftFront(3,false), /* FIX ME */
    leftBack(4,false), /* FIX ME */
    rightFront(1,true), /* FIX ME */
    rightBack(2,true), /* FIX ME */
    handMotor(5,false), /* FIX ME */
    liftMotor(6, false), /* FIX ME */
    wristMotor(7,false), /* FIX ME */
    elbowMotor(8, false); /* FIX ME */

    private final int CAN_ID;
    private final boolean isReversed;

    private Motors(int canId, boolean reversed) {
      CAN_ID = canId;
      isReversed = reversed;
    }

    public int getCAN_ID() {
      return CAN_ID;
    }

    public boolean isReversed() {
      return isReversed;
    }
  }

  public enum Speeds {
    maxDriveSpeed(0.7),
    liftSpeed(0.4), /* FIX ME */
    handSpeed(0.15),
    wristSpeed(0.0), /* FIX ME */
    elbowSpeed(0.0); /* FIX ME */

    private final double speed;

    private Speeds(double s) {
      speed = s;
    }

    public double getSpeed() {
      return speed;
    }
  }

  public enum Pneumatics {
    shoulderOut(0),
    shoulderIn(1);

    private final int Id;

    private Pneumatics(int id) {
      Id = id;
    }

    public int getId() {
      return Id;
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

  public final static boolean TANK_DRIVE_EXISTS = false;

  public final static double POV_DEVIATION = 15.0;

  public final static int CAMERA_HEIGHT = 400;

  public final static int CAMERA_WIDTH = 500;

  public final static int CAMERA_BRIGHTNESS = 50;

  public final static int CAMERA_FPS = 15;
}

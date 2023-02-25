// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import java.lang.ModuleLayer.Controller;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** Add your docs here. */

// General class to make a new  Xbox driveController with general nethods for each physical feature on the driveController

public class OperatorConsole {

    
    private XboxController driveController, gameController;

    private JoystickButton Drive_A_Button, Drive_B_Button, Drive_X_Button, Drive_Y_Button, Drive_Start_Button, Drive_Back_Button, Drive_Left_Bumper, Drive_Right_Bumper;
    private JoystickButton Game_A_Button, Game_B_Button, Game_X_Button, Game_Y_Button, Game_Start_Button, Game_Back_Button, Game_Left_Bumper, Game_Right_Bumper;

    // This constructor has the parameter for the Controller Id a.k.a. its port
    public OperatorConsole(int driveControllerId, int gameControllerId) {
        driveController = new XboxController(driveControllerId);
        gameController = new XboxController(gameControllerId);

        // DRIVE BUTTONS AND TRIGGERS
        Drive_A_Button = new JoystickButton(driveController, XboxController.Button.kA.value);
        Drive_B_Button = new JoystickButton(driveController, XboxController.Button.kB.value);
        Drive_X_Button = new JoystickButton(driveController, XboxController.Button.kX.value);
        Drive_Y_Button = new JoystickButton(driveController, XboxController.Button.kY.value);

        Drive_Start_Button = new JoystickButton(driveController, XboxController.Button.kStart.value);
        Drive_Back_Button = new JoystickButton(driveController, XboxController.Button.kBack.value);

        Drive_Left_Bumper = new JoystickButton(driveController, XboxController.Button.kLeftBumper.value);
        Drive_Right_Bumper = new JoystickButton(driveController, XboxController.Button.kRightBumper.value);

        // Game BUTTONS AND TRIGGERS
        Game_A_Button = new JoystickButton(gameController, XboxController.Button.kA.value);
        Game_B_Button = new JoystickButton(gameController, XboxController.Button.kB.value);
        Game_X_Button = new JoystickButton(gameController, XboxController.Button.kX.value);
        Game_Y_Button = new JoystickButton(gameController, XboxController.Button.kY.value);

        Game_Start_Button = new JoystickButton(gameController, XboxController.Button.kStart.value);
        Game_Back_Button = new JoystickButton(gameController, XboxController.Button.kBack.value);

        Game_Left_Bumper = new JoystickButton(gameController, XboxController.Button.kLeftBumper.value);
        Game_Right_Bumper = new JoystickButton(gameController, XboxController.Button.kRightBumper.value);
    }

    /* These methods will let you grab the values for the joystick
     * and buttons on driveController.
    */

    public double getDriveLeftStickY() {
        double driveLeftStickY = -1.0 * driveController.getLeftY();
        // if jostick in between -Deadband < joystick < Deadband
        if (driveLeftStickY < Constants.CONTROLLER_DEADBAND && driveLeftStickY > -1.0 * Constants.CONTROLLER_DEADBAND) {
            driveLeftStickY = 0.0;
        }
        return driveLeftStickY;
    }

    public double getDriveLeftStickX() {
        double driveLeftStickX = driveController.getLeftX();
        // if jostick in between -Deadband < joystick < Deadband
        if (driveLeftStickX < Constants.CONTROLLER_DEADBAND && driveLeftStickX > -1.0 * Constants.CONTROLLER_DEADBAND) {
            driveLeftStickX = 0.0;
        }
        return driveLeftStickX;
    }

    public double getDriveRightStickY() {
        double driveRightStickY = -1.0 * driveController.getRightY();
        // if jostick in between -Deadband < joystick < Deadband
        if (driveRightStickY < Constants.CONTROLLER_DEADBAND && driveRightStickY > -1.0 * Constants.CONTROLLER_DEADBAND) {
            driveRightStickY = 0.0;
        }
        return driveRightStickY;
    }

    public double getDriveRightStickX() {
        double driveRightStickX = driveController.getRightX();
        // if jostick in between -Deadband < joystick < Deadband
        if (driveRightStickX < Constants.CONTROLLER_DEADBAND && driveRightStickX > -1.0 * Constants.CONTROLLER_DEADBAND) {
            driveRightStickX = 0.0;
        }
        return driveRightStickX;
    }

    public double driveMotorSpeed() {
        double speed = Math.sqrt(Math.pow(getDriveLeftStickY(), 2) + Math.pow(getDriveLeftStickX(), 2));
        return speed;
    }

    // Retruns angle of Dpad on driveController
    public int getDriveDpadAngle() {
        int driveDpadAngle = driveController.getPOV();
        return driveDpadAngle;
    }

    public static double applyDeadband(double a) {
        double val = a;
        if (a < Constants.CONTROLLER_DEADBAND && a > -1.0 * Constants.CONTROLLER_DEADBAND) {
            val = 0;
        }
        return val;
    }

    // Returns angle of left joystick
    public double getDriveLeftStickAngle() {
        // This is measured in degrees
        double angle;
        double x = applyDeadband(driveController.getLeftX());
        double y = applyDeadband(-1.0 * driveController.getLeftY());
        
        if (x < 0 && y < 0) {
            angle = Math.atan2(-1.0 * y,-1.0 * x) * (180.0/Math.PI);
            angle += 180.0;
        } else if (x > 0 && y < 0) {
            angle = Math.atan2(-1.0 * y,-1.0 * x) * (180.0/Math.PI);
            angle += 180.0;
        } else {
            angle = Math.atan2(y,x) * (180.0/Math.PI);
        }

        if (angle == -180) {
            angle *= -1.0;
        } else if (angle == -0) {
            angle *= -1.0;
        } else {}
        System.out.printf("X: %4.2f,  Y: %4.2f, Angle: %4.2f\n", x, y, angle);
        return angle;
    }
    
    public double convertAngleToRadians() {
        double angle = getDriveLeftStickAngle() * (Math.PI/180.0);
        return angle;
    }

    public double degrees2ticks() {
        double ticks = getDriveLeftStickAngle() * (4096.0/360.0);
        return ticks;
    }

    public double getDriveLeftTrigger() {
        double driveLeftTriggerVal = driveController.getRawAxis(XboxController.Axis.kLeftTrigger.value);
        return driveLeftTriggerVal;
    }

    public double getDriveRightTrigger() {
        double driveRightTriggerVal = driveController.getRawAxis(XboxController.Axis.kRightTrigger.value);
        return driveRightTriggerVal;
    }

    public JoystickButton getDriveAButton() {
        return Drive_A_Button;
    }

    public JoystickButton getDriveBButton() {
        return Drive_B_Button;
    }

    public JoystickButton getDriveXButton() {
        return Drive_X_Button;
    }

    public JoystickButton getDriveYButton() {
        return Drive_Y_Button;
    }

    public JoystickButton getDriveStartButton() {
        return Drive_Start_Button;
    }

    public JoystickButton getDriveBackButton() {
        return Drive_Back_Button;
    }

    public JoystickButton getDriveLeftBumper() {
        return Drive_Left_Bumper;
    }

    public JoystickButton getDriveRightBumber() {
        return Drive_Right_Bumper;
    }

    /* These methods will let you grab the values for the joystick
     * and buttons on driveController.
    */

    public double getGameLeftStickY() {
        double gameLeftStickY = -1.0 * gameController.getLeftY();
        // if jostick in between -Deadband < joystick < Deadband
        if (gameLeftStickY < Constants.CONTROLLER_DEADBAND && gameLeftStickY > -1.0 * Constants.CONTROLLER_DEADBAND) {
            gameLeftStickY = 0.0;
        }
        return gameLeftStickY;
    }

    public double getGameLeftStickX() {
        double gameLeftStickX = gameController.getLeftX();
        // if jostick in between -Deadband < joystick < Deadband
        if (gameLeftStickX < Constants.CONTROLLER_DEADBAND && gameLeftStickX > -1.0 * Constants.CONTROLLER_DEADBAND) {
            gameLeftStickX = 0.0;
        }
        return gameLeftStickX;
    }

    public double getGameRightStickY() {
        double gameRightStickY = -1.0 * gameController.getRightY();
        // if jostick in between -Deadband < joystick < Deadband
        if (gameRightStickY < Constants.CONTROLLER_DEADBAND && gameRightStickY > -1.0 * Constants.CONTROLLER_DEADBAND) {
            gameRightStickY = 0.0;
        }
        return gameRightStickY;
    }

    public double getGameRightStickX() {
        double gameRightStickX = gameController.getRightX();
        // if jostick in between -Deadband < joystick < Deadband
        if (gameRightStickX < Constants.CONTROLLER_DEADBAND && gameRightStickX > -1.0 * Constants.CONTROLLER_DEADBAND) {
            gameRightStickX = 0.0;
        }
        return gameRightStickX;
    }

    // Retruns angle of Dpad on gameController
    public int getGameDpadAngle() {
        int gameDpadAngle = gameController.getPOV();
        return gameDpadAngle;
    }

    public double getGameLeftTrigger() {
        double gameLeftTriggerVal = gameController.getRawAxis(XboxController.Axis.kLeftTrigger.value);
        return gameLeftTriggerVal;
    }

    public double getGameRightTrigger() {
        double gameRightTriggerVal = gameController.getRawAxis(XboxController.Axis.kRightTrigger.value);
        return gameRightTriggerVal;
    }

    public JoystickButton getGameAButton() {
        return Game_A_Button;
    }

    public JoystickButton getGameBButton() {
        return Game_B_Button;
    }

    public JoystickButton getGameXButton() {
        return Game_X_Button;
    }

    public JoystickButton getGameYButton() {
        return Game_Y_Button;
    }

    public JoystickButton getGameStartButton() {
        return Game_Start_Button;
    }

    public JoystickButton getGameBackButton() {
        return Game_Back_Button;
    }

    public JoystickButton getGameLeftBumper() {
        return Game_Left_Bumper;
    }

    public JoystickButton getGameRightBumber() {
        return Game_Right_Bumper;
    }
}

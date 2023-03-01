// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.XboxController;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

/** Add your docs here. */
public class OperatorConsole {

    private XboxController driveController, gameController;

    private JoystickButton Drive_A_Button, Drive_B_Button, Drive_X_Button, Drive_Y_Button, Drive_Start_Button, Drive_Back_Button, Drive_Left_Bumper, Drive_Right_Bumper;
    private JoystickButton Game_A_Button, Game_B_Button, Game_X_Button, Game_Y_Button, Game_Start_Button, Game_Back_Button, Game_Left_Bumper, Game_Right_Bumper;

    // This constructor has the parameter for the Controller Id a.k.a. its port
    public OperatorConsole() {
        driveController = new XboxController(Constants.DRIVE_CONTROLLER_ID);
        gameController = new XboxController(Constants.GAME_CONTROLLER_ID);

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

    // Retruns angle of Dpad on driveController
    public int getDriveDpadAngle() {
        int driveDpadAngle = driveController.getPOV();
        return driveDpadAngle;
    }

    public boolean getDriveLeftTrigger() {
        boolean isActive = false;
        double driveLeftTriggerVal = driveController.getRawAxis(XboxController.Axis.kLeftTrigger.value);
        if (driveLeftTriggerVal > Constants.CONTROLLER_TRIGGER_DEADBAND) {
            isActive = true;
        }
        return isActive;
    }

    public boolean getDriveRightTrigger() {
        boolean isActive = false;
        double driveRightTriggerVal = driveController.getRawAxis(XboxController.Axis.kRightTrigger.value);
        if (driveRightTriggerVal > Constants.CONTROLLER_TRIGGER_DEADBAND) {
            isActive = true;
        }
        return isActive;
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

    public boolean getGameLeftTrigger() {
        boolean isActive = false;
        double gameLeftTriggerVal = gameController.getRawAxis(XboxController.Axis.kLeftTrigger.value);
        if (gameLeftTriggerVal > Constants.CONTROLLER_TRIGGER_DEADBAND) {
            isActive = true;
        }
        return isActive;
    }

    public boolean getGameRightTrigger() {
        boolean isActive = false;
        double gameRightTriggerVal = gameController.getRawAxis(XboxController.Axis.kRightTrigger.value);
        if (gameRightTriggerVal > Constants.CONTROLLER_TRIGGER_DEADBAND) {
            isActive = true;
        }
        return isActive;
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

// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import com.fasterxml.jackson.databind.cfg.ContextAttributes;

import edu.wpi.first.wpilibj.XboxController;

/** Add your docs here. */
public class OperatorConsole {

    private XboxController driveController, gameController;
    
    public OperatorConsole() {
        driveController = new XboxController(Constants.DRIVE_CONTROLLER_ID);
        gameController = new XboxController(Constants.GAME_CONTROLLER_ID);
    }

    // GENERAL-TO-BOTH CONTROLLER METHODS

    public int dPadVal(int controllerId) {
        // Sets dpad return value to -1
        int pov = -1;

        // This checks which controller (drive/game) will be return which ever value
        if (controllerId == Constants.DRIVE_CONTROLLER_ID) {
            pov = driveController.getPOV();
        } else if (controllerId == Constants.GAME_CONTROLLER_ID) {
            pov = gameController.getPOV();
        }
        return pov;
    }

    // DRIVE CONTROLLER METHODS

    public double getDriveSpeedY() {
        double speedY = driveController.getLeftY();
        if (speedY < Constants.CONTROLLER_DEADBAND || speedY > -1.0 * Constants.CONTROLLER_DEADBAND) {
            speedY = 0.0;
        }
        return speedY;
    }

    public double getDriveSpeedX() {
        double speedX = driveController.getLeftX();
        if (speedX < Constants.CONTROLLER_DEADBAND || speedX > -1.0 * Constants.CONTROLLER_DEADBAND) {
            speedX = 0.0;
        }
        return speedX;
    }

    public double getDriveTurnSpeed() {
        double driveTurnSpeed = driveController.getRightX();
        if (driveTurnSpeed < Constants.CONTROLLER_DEADBAND || driveTurnSpeed > -1.0 * Constants.CONTROLLER_DEADBAND) {
            driveTurnSpeed = 0.0;
        }
        return driveTurnSpeed;
    }

    // GAME CONTROLLER METHODS

    public double getArmShoulder() {
        double percentPower = gameController.getLeftY();
        if (percentPower < Constants.CONTROLLER_DEADBAND || percentPower > -1.0 * Constants.CONTROLLER_DEADBAND) {
            percentPower = 0.0;
        }
        return percentPower;
    }



}

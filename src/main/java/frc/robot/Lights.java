// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.motorcontrol.Spark;

/** Add your docs here. */
public class Lights {
    private Spark leds;

    public Lights() {
        leds = new Spark(Constants.LED_LIGHTS_PWM_PORT);
    }

    public void setColorRed() {
        leds.set(Constants.LED_COLORS.RED.getColor());
    }

    public void setColorBlue() {
        leds.set(Constants.LED_COLORS.BLUE.getColor());
    }

    public void setColorGreen() {
        leds.set(Constants.LED_COLORS.GREEN.getColor());
    }

    public void setColorOrange() {
        leds.set(Constants.LED_COLORS.ORANGE.getColor());
    }

    public void setColorYellow() {
        leds.set(Constants.LED_COLORS.YELLOW.getColor());
    }

    public void setColorPurple() {
        leds.set(Constants.LED_COLORS.PURPLE.getColor());
    }

    public void setColorRainbow() {
        leds.set(Constants.LED_COLORS.RAINBOW.getColor());
    }

    public void setTeamColors() {
        leds.set(Constants.LED_COLORS.TEAM.getColor());
    }

    public void setAllianceColors() {
        if (Constants.TEAM.equalsIgnoreCase("blue")) {
            leds.set(Constants.LED_COLORS.BLUE.getColor());
        }
        if (Constants.TEAM.equalsIgnoreCase("red")) {
            leds.set(Constants.LED_COLORS.RED.getColor());
        }
    }

}

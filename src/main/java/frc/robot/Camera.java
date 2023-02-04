// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;

/** Add your docs here. */
public class Camera {

    UsbCamera camera;
    CvSink sink;
    CvSource outputStream;

    public Camera() {
        camera = CameraServer.startAutomaticCapture();

        camera.setResolution(Constants.Camera.WIDTH.getValue(), Constants.Camera.HEIGHT.getValue());
        camera.setBrightness(Constants.Camera.BRIGHTNESS.getValue());

        sink = CameraServer.getVideo();
        outputStream = CameraServer.putVideo("Camera 1", 0, 0);

        camera.setFPS(Constants.Camera.FPS.getValue());
    }
}

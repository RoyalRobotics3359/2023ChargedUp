// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.cameraserver.CameraServer;
import edu.wpi.first.cscore.CvSink;
import edu.wpi.first.cscore.CvSource;
import edu.wpi.first.cscore.UsbCamera;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;

/** Add your docs here. */
public class Camera {

    private UsbCamera camera;

    private CvSink sink;
    
    private CvSource source;

    public Camera() {
        // Enables the camera
        camera = CameraServer.startAutomaticCapture();

        // Setting Frames Per Second
        camera.setFPS(Constants.CAMERA_FPS);

        // Setting up the resolution and brightness of the camera
        camera.setResolution(Constants.CAMERA_WIDTH, Constants.CAMERA_HEIGHT);
        
        // sink = CameraServer.getVideo();

        // source = CameraServer.putVideo("FRC 3359", Constants.CAMERA_WIDTH, Constants.CAMERA_HEIGHT);
    }
}

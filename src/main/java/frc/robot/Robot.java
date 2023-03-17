// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.PneumaticsModuleType;
import edu.wpi.first.wpilibj.Servo;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.Commands;
import frc.robot.commands.OpenHand;
import frc.robot.commands.OperateElbow;
import frc.robot.commands.CloseHand;
import frc.robot.commands.ExtendShoulder;
import frc.robot.commands.JoystickDrive;
import frc.robot.commands.LowerElbow;
import frc.robot.commands.LowerWrist;
import frc.robot.commands.OperateLift;
import frc.robot.commands.OperateWrist;
import frc.robot.commands.RaiseElbow;
import frc.robot.commands.RaiseWrist;
import frc.robot.commands.RetractShoulder;
import frc.robot.subsystems.Drive;
import frc.robot.subsystems.Elbow;
import frc.robot.subsystems.Hand;
import frc.robot.subsystems.Lift;
import frc.robot.subsystems.Wrist;

/**
 * The VM is configured to automatically run this class, and to call the functions corresponding to
 * each mode, as described in the TimedRobot documentation. If you change the name of this class or
 * the package after creating this project, you must also update the build.gradle file in the
 * project.
 */
public class Robot extends TimedRobot {

  /**
   * This function is run when the robot is first started up and should be used for any
   * initialization code.
   */

  // Subsytems
  private Drive drive;
  private Lift lift;
  private Hand hand;
  private Elbow elbow;
  private Wrist wrist;

  //  Commands
  private RaiseElbow raiseElbow;
  private LowerElbow lowerElbow;

  //  Other
  private OperatorConsole console;
  private RobotContainer container;
  private Lights lights;
  private Camera camera;
  private Compressor compressor;
  private SendableChooser<Command> chooser;
  private Command autonomousCommand;

  private Servo gripperTest;

  @Override
  public void robotInit() {
    // Instantiate our RobotContainer.  This will perform all our button bindings, and put our
    // autonomous chooser on the dashboard.

    // Subsystems
    drive = new Drive();
    lift = new Lift();
    hand = new Hand(/*lights*/);
    elbow = new Elbow();
    // wrist = new Wrist();

    // Commands
    raiseElbow = new RaiseElbow(elbow);
    lowerElbow = new LowerElbow(elbow);
    // autonomousCommand = new DriveForwardTimedDrive(drive, 2.0, 0.7);
    // defaultAutonomousCommand = new DriveForwardTimedDrive(drive, 2.0, 0.8);

    // Other
    console = new OperatorConsole();
    container = new RobotContainer(drive);
    camera = new Camera();
    compressor = new Compressor(PneumaticsModuleType.CTREPCM);
    compressor.enableDigital();
    // lights = new Lights();
    chooser = new SendableChooser<>();
    gripperTest = new Servo(0);
    // lights.setColorPurple();

    // Setting up basic functions of all subsytems
    CommandScheduler.getInstance().setDefaultCommand(drive, new JoystickDrive(drive, console));

    CommandScheduler.getInstance().setDefaultCommand(lift, new OperateLift(lift, console));

    // CommandScheduler.getInstance().setDefaultCommand(elbow, new OperateElbow(elbow, console));

    // CommandScheduler.getInstance().setDefaultCommand(wrist, new OperateWrist(wrist, console));

    console.getGameAButton().whileTrue(new OpenHand(hand));
    console.getGameBButton().whileTrue(new CloseHand(hand));

    // console.getGameXButton().whenPressed(elbow::extendShoulder, elbow);
    // console.getGameYButton().whenPressed(elbow::retractShoulder, elbow);

    console.getGameYButton().whileTrue(new ExtendShoulder(elbow));
    console.getGameXButton().whileTrue(new RetractShoulder(elbow));

    // console.getGameLeftBumper().whileTrue(new LowerWrist(wrist));
    // console.getGameRightBumper().whileTrue(new RaiseWrist(wrist));
  }

  /**
   * This function is called every 20 ms, no matter the mode. Use this for items like diagnostics
   * that you want ran during disabled, autonomous, teleoperated and test.
   *
   * <p>This runs after the mode specific periodic functions, but before LiveWindow and
   * SmartDashboard integrated updating.
   */
  @Override
  public void robotPeriodic() {
    // Runs the Scheduler.  This is responsible for polling buttons, adding newly-scheduled
    // commands, running already-scheduled commands, removing finished or interrupted commands,
    // and running subsystem periodic() methods.  This must be called from the robot's periodic
    // block in order for anything in the Command-based framework to work.  
    CommandScheduler.getInstance().run();

    SmartDashboard.putNumber("Drive LeftStickY", console.getDriveLeftStickY());
    SmartDashboard.putNumber("Game LeftStickY", console.getGameLeftStickY());

    SmartDashboard.putNumber("Commpresor PSI", compressor.getPressure());
  }

  /** This function is called once each time the robot enters Disabled mode. */
  @Override
  public void disabledInit() {}

  @Override
  public void disabledPeriodic() {}

  /** This autonomous runs the autonomous command selected by your {@link RobotContainer} class. */
  @Override
  public void autonomousInit() {

    // // schedule the autonomous command (example)
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.schedule();
    // }

    // Setting up autonomous
    autonomousCommand = container.getAutonomousRoutine();

    if (autonomousCommand != null) {
      autonomousCommand.schedule();
    }
  }

  /** This function is called periodically during autonomous. */
  @Override
  public void autonomousPeriodic() {
    CommandScheduler.getInstance().run();
  }

  @Override
  public void teleopInit() {
    // This makes sure that the autonomous stops running when
    // teleop starts running. If you want the autonomous to
    // continue until interrupted by another command, remove
    // this line or comment it out.
    // if (m_autonomousCommand != null) {
    //   m_autonomousCommand.cancel();
    // }

    if (autonomousCommand != null) {
      autonomousCommand.cancel();
    }
  }

  /** This function is called periodically during operator control. */
  @Override
  public void teleopPeriodic() {

    // /**
    //  * Quick and dirty servo gripper test
    //  */
    // int dpad = console.getDriveDpadAngle();
    // System.out.println("D-Pad angle: " + dpad + ", servo: " + gripperTest.getPosition() + ", " + gripperTest.getAngle());
    // if (dpad == 90) {
    //   gripperTest.setAngle(0.03);
    //   System.out.print("+");
    // }
    // else if (dpad == 270) {
    //   gripperTest.setAngle(0.05));
    //   System.out.print("-");
    // }


    if (console.getGameRightTrigger() == true) {
      lowerElbow.end(true);
      raiseElbow.execute();
      SmartDashboard.putBoolean("Elbow Retracting", true);
      SmartDashboard.putBoolean("Elbow Extending", false);
      SmartDashboard.putBoolean("Elbow Stopped", false);
      System.out.println("executing raise");
    } else if (console.getGameLeftTrigger() == true) {
      raiseElbow.end(true);
      lowerElbow.execute();
      SmartDashboard.putBoolean("Elbow Retracting", false);
      SmartDashboard.putBoolean("Elbow Extending", true);
      SmartDashboard.putBoolean("Elbow Stopped", false);
      System.out.println("executing lower");
    } else {
      raiseElbow.end(true);
      lowerElbow.end(true);
      SmartDashboard.putBoolean("Elbow Retracting", false);
      SmartDashboard.putBoolean("Elbow Extending", false);
      SmartDashboard.putBoolean("Elbow Stopped", true);
    }

    if (console.getGameLeftBumper().getAsBoolean() == true && console.getGameRightBumper().getAsBoolean() == false) {
      SmartDashboard.putBoolean("Wrist Extending", true);
      SmartDashboard.putBoolean("Wrist Retracting", false);
      SmartDashboard.putBoolean("Wrist Stopped", false);    
    } else if (console.getGameRightBumper().getAsBoolean() == true && console.getGameLeftBumper().getAsBoolean() == false) {
      SmartDashboard.putBoolean("Wrist Extending", false);
      SmartDashboard.putBoolean("Wrist Retracting", true);
      SmartDashboard.putBoolean("Wrist Stopped", false);
    } else {
      SmartDashboard.putBoolean("Wrist Extending", false);
      SmartDashboard.putBoolean("Wrist Retracting", false);
      SmartDashboard.putBoolean("Wrist Stopped", true);
    }

    CommandScheduler.getInstance().run();
  }

  @Override
  public void testInit() {
    // Cancels all running commands at the start of test mode.
    CommandScheduler.getInstance().cancelAll();
  }

  /** This function is called periodically during test mode. */
  @Override
  public void testPeriodic() {}

  /** This function is called once when the robot is first started up. */
  @Override
  public void simulationInit() {}

  /** This function is called periodically whilst in simulation. */
  @Override
  public void simulationPeriodic() {}
}

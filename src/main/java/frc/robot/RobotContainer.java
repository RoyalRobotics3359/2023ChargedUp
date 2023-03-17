// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot;


import edu.wpi.first.wpilibj.smartdashboard.SendableChooser;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.Command;
import frc.robot.commands.ComplexAuto;
import frc.robot.commands.DriveForwardBackTimedDrive;
import frc.robot.commands.DriveForwardTimedDrive;
import frc.robot.commands.SimpleComplexAuto;
import frc.robot.subsystems.Drive;

/**
 * This class is where the bulk of the robot should be declared. Since Command-based is a
 * "declarative" paradigm, very little robot logic should actually be handled in the {@link Robot}
 * periodic methods (other than the scheduler calls). Instead, the structure of the robot (including
 * subsystems, commands, and trigger mappings) should be declared here.
 */
public class RobotContainer {

    private SendableChooser<Command> chooser;

    private Command defaultAuto;

    private Command twoPointAuto;

    private Command balanceOnTiltAuto;

    private Command driveForwardTurnBalance;

    private Drive drive;

  // The robot's subsystems and commands are defined here...

  /** The container for the robot. Contains subsystems, OI devices, and commands. */
  public RobotContainer(Drive d) {

    drive = d;
    
    chooser = new SendableChooser<>();

    defaultAuto = new DriveForwardTimedDrive(drive, 2.0, 0.7);

    twoPointAuto = new DriveForwardBackTimedDrive(drive, 2.0, 0.7);

    balanceOnTiltAuto = new SimpleComplexAuto(drive, 2.0, 0.8);

    driveForwardTurnBalance = new ComplexAuto(drive);

    chooser.setDefaultOption("Default Autonomous", defaultAuto);
    chooser.addOption("Two Point Auto", twoPointAuto);
    chooser.addOption("Balnce On Tilt", balanceOnTiltAuto);
    chooser.addOption("ComplexAuto", driveForwardTurnBalance);

    SmartDashboard.putData(chooser);
  }

  public Command getAutonomousRoutine() {
    return chooser.getSelected();
  }

//   /**
//    * Use this method to define your trigger->command mappings. Triggers can be created via the
//    * {@link Trigger#Trigger(java.util.function.BooleanSupplier)} constructor with an arbitrary
//    * predicate, or via the named factories in {@link
//    * edu.wpi.first.wpilibj2.command.button.CommandGenericHID}'s subclasses for {@link
//    * CommandXboxController Xbox}/{@link edu.wpi.first.wpilibj2.command.button.CommandPS4Controller
//    * PS4} controllers or {@link edu.wpi.first.wpilibj2.command.button.CommandJoystick Flight
//    * joysticks}.
//    */
//   private void configureBindings() {
//     // Schedule `ExampleCommand` when `exampleCondition` changes to `true`
//     // new Trigger(m_exampleSubsystem::exampleCondition)
//     //     .onTrue(new ExampleCommand(m_exampleSubsystem));

//     // Schedule `exampleMethodCommand` when the Xbox controller's B button is pressed,
//     // // cancelling on release.
//     // m_driverController.b().whileTrue(m_exampleSubsystem.exampleMethodCommand());
//   }

  /**
   * Use this to pass the autonomous command to the main {@link Robot} class.
   *
   * @return the command to run in autonomous
  //  */
  // public Command getAutonomousCommand() {
  //   // // An example command will be run in autonomous
  //   // return Autos.exampleAuto(m_exampleSubsystem);
  // }
}

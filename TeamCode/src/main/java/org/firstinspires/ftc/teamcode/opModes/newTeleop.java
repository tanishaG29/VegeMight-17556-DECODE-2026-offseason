package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Gamepad;

import org.firstinspires.ftc.teamcode.Essentials.intakeComm;
import org.firstinspires.ftc.teamcode.Subsystems.dtSubSystem;
import org.firstinspires.ftc.teamcode.Subsystems.intakeSubSystem;

public class newTeleop extends CommandOpMode {
    dtSubSystem driveTrain;
    GamepadEx gamePad1;
    intakeSubSystem intakeSub;


    @Override
    public void initialize() {
        driveTrain = new dtSubSystem(hardwareMap);
        gamePad1 = new GamepadEx(gamepad1);
        intakeSub = new intakeSubSystem(hardwareMap);

        //stage 3 setting default commands (just driving rn cause we only want it driving forever)
        driveTrain.setDefaultCommand(new RunCommand(() ->
                driveTrain.driveRobotCentric(
                        gamePad1.getLeftX(),
                        gamePad1.getLeftY(),
                        gamePad1.getRightX()
                ), driveTrain
        ));
        schedule(driveTrain.getDefaultCommand());
        // these 3 get things automatically get how much you have pushed the joysticks and does all the calculations to give power to the motors. change direction if its opposite
        //never stops until opmode ends. RunCommand is a shortform for simple systems where it excapsulates the initalise, execute and end phases together
        //in initalize phase becasue it is like setting an alarm once but it runs multiple times.

        //section 4 which binds everything to buttons i think
        gamePad1.getGamepadButton(GamepadKeys.Button.X)
                .whenPressed(new InstantCommand(() -> driveTrain.resetHeading(), driveTrain));

        gamePad1.getGamepadButton(GamepadKeys.Button.A).whenPressed(new intakeComm(intakeSub));
        gamePad1.getGamepadButton(GamepadKeys.Button.RIGHT_BUMPER).whenHeld(new InstantCommand(intakeSub::spin, (Subsystem) intakeSub));
        //i think that when this is held it will spin the axel for the intake as long as you want
    }}

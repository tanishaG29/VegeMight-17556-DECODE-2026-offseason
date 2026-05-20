package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.command.InstantCommand;
import com.arcrobotics.ftclib.command.RunCommand;
import com.arcrobotics.ftclib.command.button.GamepadButton;
import com.arcrobotics.ftclib.gamepad.GamepadEx;
import com.arcrobotics.ftclib.gamepad.GamepadKeys;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.Gamepad
import org.firstinspires.ftc.teamcode.Subsystems.dtSubSystem;

public class newTeleop extends CommandOpMode {
    dtSubSystem driveTrain;
    GamepadEx gamePad;


    @Override
    public void initialize() {
        driveTrain = new dtSubSystem(hardwareMap);
        gamePad = new GamepadEx(gamepad1);

        new RunCommand(() ->
                driveTrain.driveRobotCentric(
                        gamePad.getLeftX(),
                        gamePad.getLeftY(),
                        gamePad.getRightX()
                ), driveTrain
        ).schedule();
        // these 3 get things automatically get how much you have pushed the joysticks and does all the calculations to give power to the motors. change direction if its opposite
        //never stops until opmode ends. RunCommand is a shortform for simple systems where it excapsulates the initalise, execute and end phases together
        //in initalize phase becasue it is like setting an alarm once but it runs multiple times.

        gamePad.getGamepadButton(GamepadKeys.Button.X)
                .whenPressed(new InstantCommand(() -> driveTrain.resetHeading(), driveTrain));

    }}

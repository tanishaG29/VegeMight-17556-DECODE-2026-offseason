package org.firstinspires.ftc.teamcode.opModes;

import com.arcrobotics.ftclib.command.CommandOpMode;
import com.arcrobotics.ftclib.gamepad.GamepadEx;

import org.firstinspires.ftc.teamcode.Subsystems.dtSubSystem;

public class newTeleop extends CommandOpMode {
    dtSubSystem driveTrain;
    GamepadEx gamePad;

    @Override
    public void initialize() {
        driveTrain = new dtSubSystem(hardwareMap);
        gamePad = new GamepadEx(gamepad1);

    }
}

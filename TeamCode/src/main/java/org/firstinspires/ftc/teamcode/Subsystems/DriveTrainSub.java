/* package org.firstinspires.ftc.teamcode.Subsystems;

import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.CommandScheduler;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.drivebase.MecanumDrive;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.hardware.motors.MotorGroup;

import org.firstinspires.ftc.teamcode.Essentials.OpModeReference;

public class DriveTrainSub extends SubsystemBase {

    public MotorEx FL;
    public MotorEx FR;
    public MotorEx BL;
    public MotorEx BR;
    public MecanumDrive driveTrain;

    public DriveTrainSub(final HardwareMap hMap, final String namee){
        FL = hMap.get(MotorEx.class, "frontLeftmotor");
        FR = hMap.get(MotorEx.class, "frontRightMotor");
        BL = hMap.get(MotorEx.class, "backLeftMotor");
        BR = hMap.get(MotorEx.class, "backRightMotor");
    }
    MotorGroup leftSideBros = new MotorGroup(FL, BL);
    MotorGroup rightSideHoes = new MotorGroup(FR, BR);

    // rightSideHoes.isInverted(true);
    boolean isInverted = rightSideHoes.getInverted();

    DriveTrainSub.setDefaultCommand()


}

 */

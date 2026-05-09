package org.firstinspires.ftc.teamcode.Essentials;

import com.qualcomm.robotcore.robot.RobotState;
import com.seattlesolvers.solverslib.command.Subsystem;
import com.seattlesolvers.solverslib.command.SubsystemBase;

public class Globals extends SubsystemBase {
    //public double robotWidth = 12;

    public static final Globals INSTANCE = new Globals();
    public RobotState robotState;
    public RobotState lastRobotState;

    public enum robotState {
        INTAKE,
        DRIVEDEFENCE,
        TRANSFER,
        SHOOTING,
        STOP
    }

    public RobotState getRobotState() {
        return robotState;
    }
    public RobotState getLastRobotState(){
        return lastRobotState;
    }

    public static boolean drivingOn = true;
    public static boolean shooterOn = false;
    public static boolean transferOn = false;
    public static final double gateClosed = 0.7;
    public static final double gateOpen = 0.05;
}

package org.firstinspires.ftc.teamcode.Essentials;

import static org.firstinspires.ftc.robotcore.external.BlocksOpModeCompanion.hardwareMap;

import com.qualcomm.robotcore.robot.RobotState;
import com.seattlesolvers.solverslib.command.InstantCommand;
import com.seattlesolvers.solverslib.command.Subsystem;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;

import java.util.HashMap;

public class Globals {
    //public double robotWidth = 12;
    public MotorEx FL =  hardwareMap.get(MotorEx.class,"frontleftmotor");
    public MotorEx BL =  hardwareMap.get(MotorEx.class,"backleftmotor");
    public MotorEx BR =  hardwareMap.get(MotorEx.class,"backrightmotor");
    public MotorEx FR =  hardwareMap.get(MotorEx.class,"frontrightmotor");

    public static final Globals INSTANCE = new Globals();
    public RobotState currentRobotState;
    public RobotState lastRobotState;
    Globals globals;

    public enum RobotState robotState{
        INTAKE,
        DRIVEDEFENCE,
        TRANSFER,
        SHOOTING,
        STOP
    }

    private HashMap<RobotState, RobotState> goForwardStateOnly;
    private HashMap <RobotState, RobotState> goBackwardStateOnly;


    public RobotState originalRobotState() {
        return RobotState.STOP;
    }
    public RobotState getLastRobotState(){
        return lastRobotState;
    }
//ADD IN THE HASHMAPS TO MAP THIS OUT
    public static boolean drivingOn = true;
    public static boolean shooterOn = false;
    public static boolean transferOn = false;
    public static final double gateClosed = 0.7;
    public static final double gateOpen = 0.05;

    }
}

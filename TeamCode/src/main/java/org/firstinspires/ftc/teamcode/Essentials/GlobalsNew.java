package org.firstinspires.ftc.teamcode.Essentials;

public class GlobalsNew {
    public enum RobotState {
        STOP,
        INTAKE,
        DRIVE,
        TRANSFER,
        SCORING
    }

    //a single truth for the entire robot. it knows that the first state is stop
    public static RobotState state = RobotState.STOP;
    //aagaga

}

package org.firstinspires.ftc.teamcode.Essentials;

import com.arcrobotics.ftclib.command.InstantCommand;

public class backwardStateComm extends InstantCommand {

    public backwardStateComm(){
        super(() -> {
            switch (GlobalsNew.state){
                case STOP: GlobalsNew.state = GlobalsNew.RobotState.SCORING; break;
                case SCORING: GlobalsNew.state = GlobalsNew.RobotState.TRANSFER;
                case TRANSFER: GlobalsNew.state = GlobalsNew.RobotState.INTAKE;
                case INTAKE: GlobalsNew.state = GlobalsNew.RobotState.DRIVE;
                case DRIVE: GlobalsNew.state = GlobalsNew.RobotState.SCORING;
            }
                }

        );
    }
}
//ahaha

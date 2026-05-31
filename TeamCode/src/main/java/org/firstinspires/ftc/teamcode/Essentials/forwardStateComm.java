package org.firstinspires.ftc.teamcode.Essentials;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.InstantCommand;

public class forwardStateComm extends InstantCommand {
    public forwardStateComm(){
        super(() -> {
            switch (GlobalsNew.state) {
                case STOP: GlobalsNew.state = GlobalsNew.RobotState.DRIVE; break;
                case DRIVE: GlobalsNew.state = GlobalsNew.RobotState.INTAKE; break;
                case INTAKE: GlobalsNew.state = GlobalsNew.RobotState.TRANSFER; break;
                case TRANSFER: GlobalsNew.state = GlobalsNew.RobotState.SCORING; break;
                case SCORING: GlobalsNew.state = GlobalsNew.RobotState.DRIVE; break;
            }});
    }
}
//ahahha
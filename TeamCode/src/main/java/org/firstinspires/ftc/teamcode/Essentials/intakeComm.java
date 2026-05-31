package org.firstinspires.ftc.teamcode.Essentials;

import com.arcrobotics.ftclib.command.CommandBase;
import com.arcrobotics.ftclib.command.Subsystem;

import org.firstinspires.ftc.teamcode.Subsystems.intakeSubSystem;

public class intakeComm extends CommandBase {
    private final intakeSubSystem intake;
    private double startTime;

    public intakeComm(intakeSubSystem intake){
        this.intake = intake;
    }

    @Override
    public void initialize(){
        startTime = System.currentTimeMillis(); //recording the time started
        intake.spin(); //spins at 1.0 which is a action thing ive made in the subsystem
    }

    @Override
    public boolean isFinished(){
        return System.currentTimeMillis() - startTime >= 3000; //this is in ms. it means get the current time in ms now and if it is >= 3000ms more then stop it
    }

    public void end(boolean interrupted){
        intake.stop();
    }
}
//ahahaa

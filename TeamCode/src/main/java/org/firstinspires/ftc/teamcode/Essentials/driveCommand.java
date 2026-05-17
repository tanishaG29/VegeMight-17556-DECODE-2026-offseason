package org.firstinspires.ftc.teamcode.Essentials;

public class driveCommand {
    driveCommand drive;

    public driveCommand(driveCommand drive){
        this.drive = drive;
    }
    public void execute(){
        driveCommand.drive();
    }
}

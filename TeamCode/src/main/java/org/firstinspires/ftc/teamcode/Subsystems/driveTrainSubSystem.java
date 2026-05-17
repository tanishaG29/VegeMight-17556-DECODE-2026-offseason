package org.firstinspires.ftc.teamcode.Subsystems;

import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.StartEndCommand;
import com.seattlesolvers.solverslib.command.SubsystemBase;
import com.seattlesolvers.solverslib.drivebase.MecanumDrive;
import com.seattlesolvers.solverslib.hardware.motors.Motor;
import com.seattlesolvers.solverslib.hardware.motors.MotorEx;
import com.seattlesolvers.solverslib.hardware.motors.MotorGroup;

import org.firstinspires.ftc.teamcode.Essentials.Globals;
import org.firstinspires.ftc.teamcode.Essentials.OpModeReference;

//import Essentials.OpModeReference;

public class driveTrainSubSystem extends SubsystemBase {
    public MotorEx FL;
    public MotorEx FR;
    public MotorEx BL;
    public MotorEx BR;
    public MecanumDrive driveTrain;
    Globals globals;

       public driveTrainSubSystem() {
        FL = new MotorEx(OpModeReference.getInstance().getHardwareMap(), "frontLeftMotor", MotorEx.GoBILDA.RPM_312);
        FR = new MotorEx(OpModeReference.getInstance().getHardwareMap(), "frontRightMotor", MotorEx.GoBILDA.RPM_312);
        BL = new MotorEx(OpModeReference.getInstance().getHardwareMap(), "backLeftMotor", MotorEx.GoBILDA.RPM_312);
        BR = new MotorEx(OpModeReference.getInstance().getHardwareMap(), "backRightMotor", MotorEx.GoBILDA.RPM_312);
        MotorGroup leftSideBros = new MotorGroup (FL, BL);
        MotorGroup rightSideHoes = new MotorGroup (FR, BR);
        leftSideBros.setInverted(true);
        globals = OpModeReference.getInstance().globalsSubSystem; //making an instance of the whole GSS
        driveTrain = new MecanumDrive(FL, FR, BL, BR);
        //setting their running modes to velcity controlled (in ticks per second)
            FL.setRunMode(MotorEx.RunMode.VelocityControl);
            BL.setRunMode(MotorEx.RunMode.VelocityControl);
            FR.setRunMode(MotorEx.RunMode.VelocityControl);
            BR.setRunMode(MotorEx.RunMode.VelocityControl);
        //setting them to brake when there is no power given
            leftSideBros.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);
            rightSideHoes.setZeroPowerBehavior(Motor.ZeroPowerBehavior.BRAKE);

    public void setSpeed(double speed){
                FL.set(speed);
                BL.set(speed);
                FR.set(speed);
                BR.set(speed);
                leftSideBros.set(speed);
                rightSideHoes.set(speed);
           }

           public void stop() {
               leftSideBros.set(0);
               rightSideHoes.set(0);
           }

    public Command runMotorCommand(double speed){
        return new StartEndCommand(
                () -> this.setSpeed(speed),
                () -> this.stop(),
                this
        );
    }

    public void periodic(){

           }
    }


}

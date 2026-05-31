package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.PIDCoefficients;
import com.seattlesolvers.solverslib.command.Command;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Essentials.GlobalsNew;

public class outtakeSubSystem extends SubsystemBase{
    public MotorEx shooterM;
    public HardwareMap hMap;
    PIDCoefficients kP;
    PIDCoefficients kI;
    PIDCoefficients kD;
    public outtakeSubSystem(HardwareMap hMap){
        shooterM = hMap.get(MotorEx.class, "flywheelMotor");
        shooterM.setRunMode(Motor.RunMode.VelocityControl);
    }

    public void initialize(){

    }
    public void periodic(){
        //gonna put in the state changes
        switch (GlobalsNew.state){
            case STOP:
                shooterM.set(0);
                break;
            case SCORING: break;
            case INTAKE:
                shooterM.set(1);
                break;
            case TRANSFER:
                shooterM.set(0.8);
                break;
            case DRIVE: break;
}}

    public void shooterSpin(){
    shooterM.set(0.8);
    }

    public void stop(){
        shooterM.set(0);
    }
}


/*
fields (hardware + state)
    ↓
constructor which are the things that only happen once when the subsystem is made. eg wiring the motors, setting their run modes
    ↓
initialize()     ← optional, only if you want it. things you might want to reset between runs eg. timers, etc
    ↓
periodic()       ← always override this from SubsystemBase. things that need to happen every single loop. eg. sensor readings, telemetry, etc
    ↓
action methods   ← raise(), drive(), stop(), etc.
        ↓
getters          ← getState(), isAtTarget(), etc.
XD
        */
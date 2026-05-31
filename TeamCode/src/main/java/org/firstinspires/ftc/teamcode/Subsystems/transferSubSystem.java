package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Essentials.GlobalsNew;

public class transferSubSystem extends SubsystemBase {
    public MotorEx transNotCis;
    public MotorGroup spinningLogs;
    HardwareMap hMap;

    public transferSubSystem(HardwareMap hMap){
        transNotCis = hMap.get(MotorEx.class, "transferMotor");
        transNotCis.setRunMode(Motor.RunMode.RawPower);
    }

    public void initialize(){}

    @Override
    public void periodic(){
        switch (GlobalsNew.state) {
            case DRIVE: break;
            case TRANSFER:
                transNotCis.set(0.8);
                break;
            case INTAKE:
                transNotCis.set(0.67);
                break;
            case SCORING:
                transNotCis.set(0.9);
                break;
            case STOP:
                transNotCis.set(0);
                break;
        }
    }

    public void conveyor(){
        transNotCis.set(0.85);
    }

    public void stop() {
        transNotCis.set(0);
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
        */

//yayyy its completeee
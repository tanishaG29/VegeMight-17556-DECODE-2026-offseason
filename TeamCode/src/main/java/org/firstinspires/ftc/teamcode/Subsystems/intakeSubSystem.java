package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.seattlesolvers.solverslib.command.SubsystemBase;

import org.firstinspires.ftc.teamcode.Essentials.GlobalsNew;

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
public class intakeSubSystem extends SubsystemBase {
    public MotorEx intakeMotor;
    ElapsedTime timer;

    public intakeSubSystem(HardwareMap hMap){
        intakeMotor = hMap.get(MotorEx.class,"intakeMotor");
        intakeMotor.setRunMode(Motor.RunMode.RawPower);
        intakeMotor.setInverted(true);
    }

    public void initialize(){
        timer.reset();
    }

    public void periodic(){
        //gonna put in the state changes
        switch (GlobalsNew.state){
            case STOP:
                intakeMotor.set(0);
                break;
            case SCORING: break;
            case INTAKE:
                intakeMotor.set(1);
                break;
            case TRANSFER:
                intakeMotor.set(0.8);
            break;
            case DRIVE: break;
        }

    }

    public void spin(){
        intakeMotor.set(1.0);
    }

    public void stop(){
        intakeMotor.set(0);
    }

}
//hello

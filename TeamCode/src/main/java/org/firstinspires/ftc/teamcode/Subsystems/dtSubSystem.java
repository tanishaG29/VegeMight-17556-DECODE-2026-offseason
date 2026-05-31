package org.firstinspires.ftc.teamcode.Subsystems;

import com.arcrobotics.ftclib.command.Subsystem;
import com.arcrobotics.ftclib.command.SubsystemBase;
import com.arcrobotics.ftclib.drivebase.MecanumDrive;
import com.arcrobotics.ftclib.hardware.motors.Motor;
import com.arcrobotics.ftclib.hardware.motors.MotorEx;
import com.arcrobotics.ftclib.hardware.motors.MotorGroup;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.Essentials.GlobalsNew;

public class dtSubSystem extends SubsystemBase {
    public MotorEx FL;
    public MotorEx FR;
    public MotorEx BL;
    public MotorEx BR;
    public MecanumDrive driveTrain;
    public MotorGroup leftSideBros;
    public MotorGroup rightSideHoes;
    private IMU imu;
    private boolean fieldCentric = false;
    public dtSubSystem(HardwareMap hMap) {
        FL = hMap.get(MotorEx.class, "FL");
        FR = hMap.get(MotorEx.class, "FR");
        BL = hMap.get(MotorEx.class,"BL");
        BR = hMap.get(MotorEx.class,"BR");
        imu = hMap.get(IMU.class,"IMU");
        IMU.Parameters imuParameters = new IMU.Parameters(new RevHubOrientationOnRobot(RevHubOrientationOnRobot.LogoFacingDirection.LEFT, RevHubOrientationOnRobot.UsbFacingDirection.UP));
            imu.initialize(imuParameters);
            imu.resetYaw();

        FL.setRunMode(MotorEx.RunMode.RawPower);
        BL.setRunMode(MotorEx.RunMode.RawPower);
        BR.setRunMode(MotorEx.RunMode.RawPower);
        FR.setRunMode(MotorEx.RunMode.RawPower);

        rightSideHoes = new MotorGroup(
                FR,
                BR
        );

        leftSideBros = new MotorGroup(
                FL, //leader of group
                BL
        );
        leftSideBros.setInverted(true);

        driveTrain = new MecanumDrive(FL,BL,BR,FR);
    }

    public void initialize() {
        imu.resetYaw();
    }

    @Override
    public void periodic() {
       //add anything that needs to be run on a loop like getting sensor readings
        //rn we want to make it check which subsystem its in all the time in case it has been switched
        //we want the drivetrain to be contrlled by inputs so keep it in the default command in teleop (i think) but want it to stop when its in idle so stop it here
        switch (GlobalsNew.state){
            case STOP:
                driveTrain.stop();
                rightSideHoes.set(0);
                leftSideBros.set(0); //just doing this if the stop doesnt work
                break;
            case DRIVE: break;
            case INTAKE: break;
            case SCORING: break;
            case TRANSFER: break;

    }}

    public void driveRobotCentric(double strafe, double forward, double rotate) {
        driveTrain.driveRobotCentric(strafe, forward, rotate);
    }
    //this is going to be wherever the front of the robot is, it travels in that direction

    public void stop() {
        driveTrain.stop();
    }

    public void resetHeading(){
    imu.resetYaw(); //whenever you have changed the position of the robot
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

//yayyy its completee
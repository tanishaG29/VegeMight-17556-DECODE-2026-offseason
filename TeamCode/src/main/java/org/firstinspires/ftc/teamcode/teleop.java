package org.firstinspires.ftc.teamcode;


import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.Servo;

public class teleop extends OpMode {
        DcMotor frontLeftMotor;    DcMotor backRightMotor;  DcMotor frontRightMotor;  DcMotor backLeftMotor;
        DcMotor intakeMotor;
        DcMotor rampWheels; //for 2 sunken wheels in ramp to push ball up into turret
        DcMotor flyWheel; //flywheel and geared up to give power to the red rollers loc. back top robot
        Servo gateServo;
        Limelight3A limeLight;
        public enum intakeState {
            STATE_SHUT2, //EMERGENCY SWITCH OFF STATE
            STATE_ONE
        }
        public enum shootState {
            STATE_SHUT, //OVERRIDE EMERGENCY STATE SWITCH OFF
            STATE_TWOSTART,
            STATE_GATE,
            STATE_LIMELIGHTDECT,
            STATE_FLYWHEELSHOOT
        }
    @Override
    public void init() {
        frontLeftMotor = hardwareMap.get(DcMotor.class,"frontLeftMotor");
        frontRightMotor = hardwareMap.get(DcMotor.class,"frontRightMotor");
        backLeftMotor = hardwareMap.get(DcMotor.class,"backLeftMotor");
        backRightMotor = hardwareMap.get(DcMotor.class,"backRightMotor");
        intakeMotor = hardwareMap.get(DcMotor.class,"intakeMotor");
        rampWheels = hardwareMap.get(DcMotor.class,"rampWheelsMotor");
        flyWheel = hardwareMap.get(DcMotor.class,"flyWheelMotor");
        gateServo = hardwareMap.get(Servo.class,"gateServo");
        limeLight = hardwareMap.get(Limelight3A.class,"limelight");

    }

    public void start() {
        limeLight.pipelineSwitch(0);
        limeLight.start();
    }

    @Override
    public void loop() {
            double y = -gamepad1.left_stick_y;
            double x = gamepad1.left_stick_x;
            double xturn = gamepad1.right_stick_x;
            double denominator = Math.max(Math.abs(y) + Math.abs(x) + Math.abs(xturn), 1); //total maximum motor power is 1
            double frontLeftPower = (y + x + xturn) / denominator;
            double backLeftPower = (y - x + xturn) / denominator;
            double frontRightPower = (y - x - xturn) / denominator;
            double backRightPower = (y + x - xturn) / denominator;
            //this is to say add all of the numbers up (how much the throttles have been pushed)
            //and do maths with them and divide by the maximum power you can give to the motor
            //to give the power to the motor that is needed
            //this is used so that when its pressed a bit, it will go slower and if its pressed a lot, it'll go faster

            frontLeftMotor.setPower(frontLeftPower);




        }
}
}

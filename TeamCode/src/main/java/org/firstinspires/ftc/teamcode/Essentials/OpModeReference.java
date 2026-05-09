
package org.firstinspires.ftc.teamcode.Essentials;

import com.qualcomm.hardware.limelightvision.Limelight3A;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.seattlesolvers.solverslib.command.Subsystem;
import com.seattlesolvers.solverslib.gamepad.GamepadEx;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.Subsystems.driveTrainSubSystem;
import org.firstinspires.ftc.teamcode.Subsystems.intakeSubSystem;
import org.firstinspires.ftc.teamcode.Subsystems.transferSubSystem;
import org.firstinspires.ftc.teamcode.Subsystems.outtakeSubSystem;


public class    OpModeReference {
    private static OpModeReference instance = null;
    HardwareMap hardwareMap;
    GamepadEx gamePad1;
    GamepadEx gamePad2;
    Telemetry telemetry;
    public boolean isRedAlliance = true;
    public Globals globalsSubSystem;
    public Subsystem driveTrainSubsystem;
    public Subsystem intakeTrainSubsystem;
    public Subsystem LimeLightTrainSubsystem;
    public Subsystem outtakeSubsystem;
    public Subsystem transferSubsystem;
    public driveTrainSubSystem driveTrain;
    public intakeSubSystem intake;

    public outtakeSubSystem shooter;
    public Limelight3A limeLightSubSystem;
    public transferSubSystem transfer;
    //public UpdateAndPowerScheduler updateAndPowerScheduler;


    //private Pose robotPose = new Pose(0, 0, 0);


    public static OpModeReference getInstance() {
        if (instance == null) instance = new OpModeReference();
        return instance;
    }

    public void initHardware(final HardwareMap hardwareMap, GamepadEx gamepad1, GamepadEx gamepad2, Telemetry telemetry, double xStart, double yStart, double headingStart, boolean visionTesting) {
        this.hardwareMap = hardwareMap;
        this.gamePad1 = gamepad1;
        this.gamePad2 = gamepad2;
        this.telemetry = telemetry;

        globalsSubSystem = new Globals();
        //limelightSubsystem = new Limelight();
        //shooterCalcs = new ShooterCalcs();
        if (!visionTesting) {
            driveTrain = new driveTrainSubSystem();
            intake = new intakeSubSystem();
            shooter = new outtakeSubSystem();
            transfer = new transferSubSystem();
            //this says whenever i type in the lhs, create a new object or version of the whole premade subsystem
            //the if is saying if vision testing is not on ie. false then make these new objects...can change this
            //to something else.
        }
    }

    public void nullify() {
        instance = null;
    }

    public HardwareMap getHardwareMap() {
        return this.hardwareMap;
    }

    public GamepadEx getGamePad1() {
        return gamePad1;
    }

    public GamepadEx getGamePad2() {
        return gamePad2;
    }

    public Telemetry getTelemetry() {
        return telemetry;
    }

    public boolean isBusy() {
        return intakeSubSystem.isBusy();
    }

    public void updateGlobalRobotPose(Pose newRobotPose) {
        robotPose = newRobotPose;
    }

    public Pose getGlobalRobotPose() {
        return robotPose;
    }
}

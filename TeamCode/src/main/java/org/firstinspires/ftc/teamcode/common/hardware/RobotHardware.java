package org.firstinspires.ftc.teamcode.common.hardware;

import com.acmerobotics.dashboard.FtcDashboard;
import com.acmerobotics.dashboard.telemetry.MultipleTelemetry;
import com.qualcomm.robotcore.hardware.HardwareMap;
import com.qualcomm.robotcore.hardware.Servo;

import org.firstinspires.ftc.robotcore.external.Telemetry;
import org.firstinspires.ftc.teamcode.common.RR.drive.SampleMecanumDrive;


public class RobotHardware {
    boolean cLeftActive, cRightActive;

    public Servo
            //claw servos
            cLeft,
            cRight;
    public SampleMecanumDrive drivetrain;

    private static RobotHardware instance = null;
    public boolean enabled;
    private HardwareMap hardwareMap;
    private Telemetry telemetry;

    public static RobotHardware getInstance(){
        if (instance == null) {
            instance = new RobotHardware();
        }
        instance.enabled=true;
        return instance;
    }

    public void init (final HardwareMap hardwareMap, final Telemetry telemetry){
        this.hardwareMap = hardwareMap;
        this.telemetry = (Globals.USING_DASH) ? new MultipleTelemetry(telemetry, FtcDashboard.getInstance().getTelemetry()) : telemetry;

        //TODO: ADD ENCODERS
        //extension = new Encoder()
        
        //TODO: SET PWM RANGES
        cLeft = hardwareMap.get(Servo.class, "cLeft");
        cRight = hardwareMap.get(Servo.class, "cRight");

        drivetrain = new SampleMecanumDrive(hardwareMap);
    }

    public void update(){
        if(cRightActive){
            cRight.setPosition(1);
        } else{
            cRight.setPosition(0.75);
        }

        if(cLeftActive){
            cLeft.setPosition(0.75);
        } else{
            cLeft.setPosition(1);
        }

        telemetry.addData("are the servos active: left:", String.valueOf(cLeftActive)+", right:"+String.valueOf(cRightActive));
        telemetry.update();
    }

    public void setcLeftActive(boolean cLeftActive) {
        this.cLeftActive = cLeftActive;
    }

    public void setcRightActive(boolean cRightActive) {
        this.cRightActive = cRightActive;
    }
    public void setcLeftActive() {
       cLeftActive = !cLeftActive;
    }

    public void setcRightActive() {
        cRightActive = !cRightActive;
    }
}

package org.firstinspires.ftc.teamcode.OPModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.Gamepad;
import com.qualcomm.robotcore.hardware.IMU;

import org.firstinspires.ftc.teamcode.common.RR.drive.SampleMecanumDrive;
import org.firstinspires.ftc.teamcode.common.hardware.RobotHardware;
@TeleOp
public class MainTeleOp extends LinearOpMode {
    RobotHardware robotHardware = RobotHardware.getInstance();
    boolean lastA;

    boolean lGrabbed, rGrabbed;


    @Override
    public void runOpMode() throws InterruptedException {
        robotHardware.init(hardwareMap, telemetry);
        lastA=gamepad1.a;
        lGrabbed = false;
        rGrabbed = false;
        waitForStart();
        while(opModeIsActive()) {

            robotHardware.drivetrain.setDrivePower(new Pose2d(-gamepad1.left_stick_y, -gamepad1.left_stick_x, gamepad1.right_stick_x));
            if(gamepad1.a)robotHardware.setcLeftActive(true);
            else if(gamepad1.b) robotHardware.setcLeftActive(false);

            if(gamepad1.x)robotHardware.setcRightActive(true);
            else if(gamepad1.y) robotHardware.setcRightActive(false);

            robotHardware.update();
        }
    }
}

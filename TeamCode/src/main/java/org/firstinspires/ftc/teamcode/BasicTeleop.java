package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.PoseVelocity2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.google.ar.core.Pose;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.rr.MecanumDrive;

@TeleOp(name = "basicteleop")
public class BasicTeleop extends LinearOpMode {
    MecanumDrive robot;
    boolean a = false;
    PoseVelocity2d pose;

    @Override
    public void runOpMode(){
        robot = new MecanumDrive(hardwareMap, new Pose2d(new Vector2d(0,0), 0));
        waitForStart();
        while(opModeIsActive()){
            pose = new PoseVelocity2d(new Vector2d(Math.pow(-gamepad1.left_stick_y, 3), Math.pow(-gamepad1.left_stick_x, 3)), Math.pow(-gamepad1.right_stick_x, 3));
            robot.setDrivePowers(pose);
        }
    }
}

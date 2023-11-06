package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import org.firstinspires.ftc.teamcode.rr.MecanumDrive;

@TeleOp(name = "basicteleop")
public class BasicTeleop extends OpMode {
    MecanumDrive robot;
    Pose2d pose;
    @Override
    public void init() {
        robot = new MecanumDrive(hardwareMap, new Pose2d(new Vector2d(0,0), 0));
    }

    @Override
    public void loop() {
        double weight = Math.max(0.7, gamepad1.right_trigger
        );
        boolean a = false;
        if(gamepad1.a){
            a=!a;
        }
        if(a) {
            pose = new Pose2d(new Vector2d( gamepad1.left_stick_x * weight, gamepad1.right_trigger-gamepad1.left_trigger * weight), gamepad1.right_stick_x * weight);

        }
        if(!a) {
            pose = new Pose2d(gamepad1.left_stick_x * weight, gamepad1.left_stick_y * weight, gamepad1.right_stick_x*weight);
        }
    }
}

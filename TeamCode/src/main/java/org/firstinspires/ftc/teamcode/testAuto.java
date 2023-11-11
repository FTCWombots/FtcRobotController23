package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.rr.MecanumDrive;
@Autonomous(name = "testAuto")
public class testAuto extends LinearOpMode {
    public MecanumDrive robot;
    @Override
    public void runOpMode() {
        robot = new MecanumDrive(hardwareMap, new Pose2d(new Vector2d(0,0), 0));
        waitForStart();
        Actions.runBlocking(
                robot.actionBuilder(new Pose2d(0, 0, 0))
                        .lineToX(42)
                        .build());

    }
}

package org.firstinspires.ftc.teamcode.Auto.CV;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.acmerobotics.roadrunner.trajectory.Trajectory;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.teamcode.common.RR.drive.SampleMecanumDrive;
@Autonomous
public class Auto extends LinearOpMode {
    SampleMecanumDrive dt;
    @Override
    public void runOpMode() throws InterruptedException {
        dt = new SampleMecanumDrive(hardwareMap);

        Trajectory t1 = dt.trajectoryBuilder(new Pose2d(0,0,0))
                .lineTo(new Vector2d(46,0))
            .build();
        Trajectory t2 = dt.trajectoryBuilder(new Pose2d(46,0,0))
                .lineTo(new Vector2d(40,0))
                .build();

        waitForStart();

        if(isStopRequested()) return;

        dt.followTrajectory(t1);
        dt.followTrajectory(t2);
    }
}

package org.firstinspires.ftc.teamcode;

import com.acmerobotics.roadrunner.Pose2d;
import com.acmerobotics.roadrunner.Vector2d;
import com.acmerobotics.roadrunner.ftc.Actions;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;

import org.firstinspires.ftc.teamcode.rr.MecanumDrive;
@Autonomous(name = "testAuto")
public class testAuto extends LinearOpMode {
    public int tpi = 40;

    testAutoBot testAutoBot;
    @Override
    public void runOpMode() {
        testAutoBot = new testAutoBot(hardwareMap);
        waitForStart();
        testAutoBot.RunToPosition(-48*tpi,-48*tpi,48*tpi,48*tpi);
        while(testAutoBot.leftBack.isBusy()&&opModeIsActive()){
            telemetry.addLine(testAutoBot.leftBack.getCurrentPosition()+" "+testAutoBot.leftFront.getCurrentPosition()+" "+testAutoBot.rightBack.getCurrentPosition()+" "+testAutoBot.rightFront.getCurrentPosition());
        }
        sleep(2000);
        testAutoBot.RunToPosition(4*tpi,4*tpi,-4*tpi,-4*tpi);
        while(opModeIsActive()){
            telemetry.addLine(testAutoBot.leftBack.getCurrentPosition()+" "+testAutoBot.leftFront.getCurrentPosition()+" "+testAutoBot.rightBack.getCurrentPosition()+" "+testAutoBot.rightFront.getCurrentPosition());
        }
    }
}
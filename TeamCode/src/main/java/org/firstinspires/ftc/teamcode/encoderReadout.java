package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
@Autonomous(name = "encoderReadout")
public class encoderReadout extends LinearOpMode {
        public DcMotorEx leftBack, leftFront, rightBack, rightFront;

        public double distance = 24;
        public double tpi = 45;
        @Override
        public void runOpMode() {
            leftBack = hardwareMap.get(DcMotorEx.class, "leftBack");
            leftFront = hardwareMap.get(DcMotorEx.class, "leftFront");
            rightBack = hardwareMap.get(DcMotorEx.class, "rightBack");
            rightFront = hardwareMap.get(DcMotorEx.class, "rightFront");

            leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

            waitForStart();
            while (opModeIsActive()) {
                telemetry.addLine(leftBack.getCurrentPosition() + " " + leftFront.getCurrentPosition() + " " + rightBack.getCurrentPosition() + " " + rightFront.getCurrentPosition());
                telemetry.update();
            }
        }
}

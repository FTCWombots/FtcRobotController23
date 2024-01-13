package org.firstinspires.ftc.teamcode.OPModes;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.hardware.IMU;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.hardware.rev.RevHubOrientationOnRobot;
import org.firstinspires.ftc.robotcore.external.navigation.AngleUnit;
import org.firstinspires.ftc.teamcode.common.RR.drive.SampleMecanumDrive;

@TeleOp(name = "fieldCentric")
public class FieldCentricMecanumTeleOp extends LinearOpMode {
    SampleMecanumDrive dt;
    @Override
    public void runOpMode() throws InterruptedException {
        dt= new SampleMecanumDrive(hardwareMap);

        // Retrieve the IMU from the hardware map
        IMU imu = hardwareMap.get(IMU.class, "imu");
        // Adjust the orientation parameters to match your robot
        IMU.Parameters parameters = new IMU.Parameters(new RevHubOrientationOnRobot(
                RevHubOrientationOnRobot.LogoFacingDirection.UP,
                RevHubOrientationOnRobot.UsbFacingDirection.LEFT));
        // Without this, the REV Hub's orientation is assumed to be logo up / USB forward
        imu.initialize(parameters);

        waitForStart();

        if (isStopRequested()) return;

        while (opModeIsActive()) {
            double y = gamepad1.left_stick_x; // Remember, Y stick value is reversed
            double x = gamepad1.left_stick_y ;
            double rx = -gamepad1.right_stick_x;

            // This button choice was made so that it is hard to hit on accident,
            // it can be freely changed based on preference.
            // The equivalent button is start on Xbox-style controllers.
            if (gamepad1.start) {
                imu.resetYaw();
            }

            double botHeading = imu.getRobotYawPitchRollAngles().getYaw(AngleUnit.RADIANS);

            // Rotate the movement direction counter to the bot's rotation
            double rotX = x * Math.cos(-botHeading) - y * Math.sin(-botHeading);
            double rotY = x * Math.sin(-botHeading) + y * Math.cos(-botHeading);

            rotX = rotX * 1.1;  // Counteract imperfect strafing

            // Denominator is the largest motor power (absolute value) or 1
            // This ensures all the powers maintain the same ratio,
            // but only if at least one is out of the range [-1, 1]
            double den = Math.max(Math.abs(rotY) + Math.abs(rotX) + Math.abs(rx), 1);
            Pose2d pose = new Pose2d(rotX/den,rotY/den,rx/den);
            dt.setDrivePower(pose);

            telemetry.addLine(String.valueOf(pose.getX())+", "+String.valueOf(pose.getY())+", "+String.valueOf(pose.getHeading()));
            telemetry.addLine(String.valueOf(-Math.toDegrees(botHeading)));
            telemetry.update();
        }
    }
}
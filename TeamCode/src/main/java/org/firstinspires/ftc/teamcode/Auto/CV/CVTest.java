package org.firstinspires.ftc.teamcode.Auto.CV;

import com.acmerobotics.dashboard.FtcDashboard;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import org.firstinspires.ftc.robotcore.external.hardware.camera.WebcamName;
import org.firstinspires.ftc.teamcode.common.RR.drive.SampleMecanumDrive;
import org.openftc.easyopencv.OpenCvCamera;
import org.openftc.easyopencv.OpenCvCameraFactory;
import org.openftc.easyopencv.OpenCvCameraRotation;
import org.openftc.easyopencv.OpenCvWebcam;

@Autonomous
public class CVTest extends LinearOpMode {
    SampleMecanumDrive dt;
    OpenCvWebcam webcam;
    String webcamName = "Webcam";
    blueDetector detector;
    blueDetector.Location location;
    @Override
    public void runOpMode() throws InterruptedException {
        dt=new SampleMecanumDrive(hardwareMap);
        int camID = hardwareMap.appContext.getResources().getIdentifier(
                "cameraMonitorViewId", "id",hardwareMap.appContext.getPackageName()
        );
        webcam = OpenCvCameraFactory.getInstance().createWebcam(
                hardwareMap.get(WebcamName.class, webcamName),
                camID
        );
        detector = new blueDetector(telemetry);
        webcam.setPipeline(detector);
        webcam.setMillisecondsPermissionTimeout(5000);
        webcam.openCameraDeviceAsync(new OpenCvCamera.AsyncCameraOpenListener() {
            @Override
            public void onOpened() {
                webcam.startStreaming(1280,720, OpenCvCameraRotation.UPRIGHT);
            }

            @Override
            public void onError(int errorCode) {}
        });
        FtcDashboard.getInstance().startCameraStream(webcam, 0);
        waitForStart();
        location=detector.getLocation();
        if(location == blueDetector.Location.RIGHT){
            telemetry.addLine("right");
        } else if (location == blueDetector.Location.MIDDLE) {
            telemetry.addLine("middle");
        } else if (location == blueDetector.Location.LEFT){
            telemetry.addLine("left");
        } else {
            telemetry.addLine("error");
        }
        telemetry.update();
        while(opModeIsActive()){

        }
    }
}

package org.firstinspires.ftc.teamcode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorEx;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.HardwareMap;

public class testAutoBot {
    public double tpi = 45;
    public DcMotorEx leftBack, leftFront, rightBack, rightFront;
    testAutoBot(HardwareMap hardwareMap){
            leftBack=hardwareMap.get(DcMotorEx.class, "leftBack");
            leftFront=hardwareMap.get(DcMotorEx.class, "leftFront");
            rightBack=hardwareMap.get(DcMotorEx.class, "rightBack");
            rightFront=hardwareMap.get(DcMotorEx.class, "rightFront");

            leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
            rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
    }

    public void RunToPosition(int lb,int lf,int rb,int rf){
        leftBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        leftFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightBack.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);
        rightFront.setMode(DcMotor.RunMode.STOP_AND_RESET_ENCODER);

        leftBack.setTargetPosition(lb);
        leftFront.setTargetPosition(lf);
        rightBack.setTargetPosition(rb);
        rightFront.setTargetPosition(rf);

        leftBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        leftFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightBack.setMode(DcMotor.RunMode.RUN_TO_POSITION);
        rightFront.setMode(DcMotor.RunMode.RUN_TO_POSITION);

        leftBack.setPower(0.3);
        leftFront.setPower(0.3);
        rightBack.setPower(0.3);
        rightFront.setPower(0.3);
    }
}

package org.firstinspires.ftc.teamcode.common.subsystem;

import com.ThermalEquilibrium.homeostasis.Controllers.Feedback.BasicPID;
import com.ThermalEquilibrium.homeostasis.Parameters.PIDCoefficients;
import com.ThermalEquilibrium.homeostasis.Parameters.PIDCoefficientsEx;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;

import org.firstinspires.ftc.teamcode.common.hardware.RobotHardware;
import org.firstinspires.ftc.teamcode.common.util.wPID;
import org.mercurialftc.mercurialftc.scheduler.OpModeEX;
import org.mercurialftc.mercurialftc.scheduler.subsystems.Subsystem;
public class Arm extends Subsystem {
    private final RobotHardware robot = RobotHardware.getInstance();
    private int backdropHeight = 0;
    public int extensionTicks;
    public double armAngle;

    public PIDCoefficients eCoefficients = new PIDCoefficients(0,0,0);
    wPID ePID = new wPID(eCoefficients);


    public Arm (OpModeEX opModeEx){
        super(opModeEx);
    }

    @Override
    public void init() {

    }

    @Override
    public void periodic() {

    }

    @Override
    public void defaultCommandExecute() {

    }

    @Override
    public void close() {

    }
/*
    public void runExtensionToPosition(int in){
        while (ePID.getError()<1){
            double output = ePID.calculate(in, robot.extension.getCurrentPosition());
        }
    }

    public void runArmToAngle(double deg){
        double output = deg/360;
        robot.sLeft.setPosition(output);
        robot.sRight.setPosition(output);
    }

    //TODO: Add Inverse Kinematics
    public void runArmToPosition(int pos){

    }*/
}

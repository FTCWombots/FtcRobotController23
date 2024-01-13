package org.firstinspires.ftc.teamcode.common.util;

import com.ThermalEquilibrium.homeostasis.Controllers.Feedback.BasicPID;
import com.ThermalEquilibrium.homeostasis.Parameters.PIDCoefficients;

public class wPID extends BasicPID {
    public wPID(PIDCoefficients coefficients) {
        super(coefficients);
    }

    public double getError(){
        return previousError;
    }
}

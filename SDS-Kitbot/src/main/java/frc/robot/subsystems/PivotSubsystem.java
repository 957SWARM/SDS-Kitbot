package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.DemandType;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import edu.wpi.first.wpilibj2.command.Command;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.Constants.PivotConstants;

public class PivotSubsystem extends SubsystemBase{


    TalonSRX pivot = new TalonSRX(0);

    public PivotSubsystem(){

        pivot.configSelectedFeedbackSensor(FeedbackDevice.Analog, 			// Local Feedback Source
													0,					// PID Slot for Source [0, 1]
													PivotConstants.PIVOT_DELAY);		
    
        pivot.configMotionAcceleration(100, PivotConstants.PIVOT_DELAY);
        pivot.configMotionCruiseVelocity(100, PivotConstants.PIVOT_DELAY);

        pivot.config_kP(0, PivotConstants.kp);
        pivot.config_kI(0, PivotConstants.ki);
        pivot.config_kD(0, PivotConstants.kd);
        pivot.config_kF(0, PivotConstants.KFF);
    
    }

    public Command stow(){
        return this.run(() -> {
            pivot.set(ControlMode.MotionMagic, PivotConstants.STOW_ANGLE, DemandType.ArbitraryFeedForward, 0);
        });
    }
    
    public Command intake(){
        return this.run(() -> {
            pivot.set(ControlMode.MotionMagic, PivotConstants.INTAKE_ANGLE, DemandType.ArbitraryFeedForward, 0);
        });
    }
    public Command score(){
        return this.run(() -> {
            pivot.set(ControlMode.MotionMagic, PivotConstants.SCORE_ANGLE, DemandType.ArbitraryFeedForward, 0);
        });
    }
}

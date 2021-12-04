// Copyright (c) FIRST and other WPILib contributors.
// Open Source Software; you can modify and/or share it under the terms of
// the WPILib BSD license file in the root directory of this project.

package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.FeedbackDevice;
import com.ctre.phoenix.motorcontrol.NeutralMode;
import com.ctre.phoenix.motorcontrol.StatusFrameEnhanced;
import com.ctre.phoenix.motorcontrol.VelocityMeasPeriod;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.RobotMap;

public class DriveTrain extends SubsystemBase {

  private static final int TIMEOUT_MS = 0;
  public static WPI_TalonSRX backleftMotor = RobotMap.leftBackDriveMotor;
  public static WPI_TalonSRX backrightMotor = RobotMap.rightBackDriveMotor;
  public static WPI_TalonSRX frontleftMotor = RobotMap.leftFrontDriveMotor;
  public static WPI_TalonSRX frontrightMotor = RobotMap.rightFrontDriveMotor;

  /** Creates a new DriveTrain. */
  public DriveTrain() {
    backleftMotor.setNeutralMode(NeutralMode.Coast);
    backrightMotor.setNeutralMode(NeutralMode.Coast);
    frontleftMotor.setNeutralMode(NeutralMode.Coast);
    frontrightMotor.setNeutralMode(NeutralMode.Coast);

    backleftMotor.setInverted(false);
    backrightMotor.setInverted(true);
    frontleftMotor.setInverted(false);
    frontrightMotor.setInverted(true);

    frontleftMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1);
    frontleftMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    frontleftMotor.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_10Ms);
    frontleftMotor.configVelocityMeasurementWindow(10);
    frontleftMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 5, 10);
    
    backleftMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1);
    backleftMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    backleftMotor.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_10Ms);
    backleftMotor.configVelocityMeasurementWindow(10);
    backleftMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 5, 10);

    frontrightMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1);
    frontrightMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    frontrightMotor.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_10Ms);
    frontrightMotor.configVelocityMeasurementWindow(10);
    frontrightMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 5, 10);

    backrightMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_2_Feedback0, 1);
    backrightMotor.configSelectedFeedbackSensor(FeedbackDevice.IntegratedSensor);
    backrightMotor.configVelocityMeasurementPeriod(VelocityMeasPeriod.Period_10Ms);
    backrightMotor.configVelocityMeasurementWindow(10);
    backrightMotor.setStatusFramePeriod(StatusFrameEnhanced.Status_12_Feedback1, 5, 10);

    frontleftMotor.set(ControlMode.Follower, backleftMotor.getDeviceID());

    frontleftMotor.configNominalOutputForward(0, TIMEOUT_MS);
    frontleftMotor.configNominalOutputReverse(0, TIMEOUT_MS);
    frontleftMotor.configPeakOutputForward(1, TIMEOUT_MS);
    frontleftMotor.configPeakOutputReverse(-1, TIMEOUT_MS);

    frontrightMotor.configNominalOutputForward(0, TIMEOUT_MS);
    frontrightMotor.configNominalOutputReverse(0, TIMEOUT_MS);
    frontrightMotor.configPeakOutputForward(1, TIMEOUT_MS);
    frontrightMotor.configPeakOutputReverse(-1, TIMEOUT_MS);

    frontleftMotor.configNeutralDeadband(0.001,TIMEOUT_MS);
    backleftMotor.configNeutralDeadband(0.001,TIMEOUT_MS);
    frontrightMotor.configNeutralDeadband(0.001,TIMEOUT_MS);
    backrightMotor.configNeutralDeadband(0.001,TIMEOUT_MS);

    frontleftMotor.setSensorPhase(true);
    frontrightMotor.setSensorPhase(false);
    backleftMotor.setSensorPhase(true);
    backrightMotor.setSensorPhase(false);
  }
  
  public static void drive(double throttle, double rotate) {
    frontleftMotor.set(throttle + rotate);
    frontrightMotor.set(throttle - rotate);

    backleftMotor.set(throttle + rotate);
    backrightMotor.set(throttle - rotate);
  }

  public void stop() {
    drive(0, 0);
  }

  @Override
  public void periodic() {
    // This method will be called once per scheduler run
  }

public void setDefaultCommand() {
}
}

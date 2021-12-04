package frc.robot;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class RobotMap {
    public static final int BACK_LEFT_MOTOR = 1;
    public static final int BACK_RIGHT_MOTOR = 2;
    public static final int FRONT_LEFT_MOTOR = 3;
    public static final int FRONT_RIGHT_MOTOR = 4;

    /*public static WPI_TalonFX leftMotor = new WPI_TalonFX(LEFT_MOTOR);
    public static WPI_TalonFX rightMotor = new WPI_TalonFX(RIGHT_MOTOR);*/

    public static WPI_TalonSRX leftBackDriveMotor = new WPI_TalonSRX(BACK_LEFT_MOTOR);
    public static WPI_TalonSRX rightBackDriveMotor = new WPI_TalonSRX(BACK_RIGHT_MOTOR);
    public static WPI_TalonSRX leftFrontDriveMotor = new WPI_TalonSRX(FRONT_LEFT_MOTOR);
    public static WPI_TalonSRX rightFrontDriveMotor = new WPI_TalonSRX(FRONT_RIGHT_MOTOR);
}

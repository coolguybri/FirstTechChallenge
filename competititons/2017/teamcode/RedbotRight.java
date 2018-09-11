package org.firstinspires.ftc.teamcode;


import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.Disabled;
import com.qualcomm.robotcore.hardware.CRServo;
import com.qualcomm.robotcore.eventloop.opmode.OpMode;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.util.ElapsedTime;
import com.qualcomm.robotcore.util.Range;
import com.qualcomm.robotcore.hardware.ColorSensor;

import android.app.Activity;
import android.graphics.Color;
import android.view.View;

@Autonomous(name="Redbot Right Arm")

public class RedbotRight extends OpMode {
    
    
    // Declare OpMode members.
    private ElapsedTime runtime = new ElapsedTime();
    MecamWheels wheels = new MecamWheels();
    JewelSensor leftColor = new JewelSensor();
    // JewelSensor rightColor = new JewelSensor();
    Forklift Lift = new Forklift();
    Grabber glyphGrabber = new Grabber();
    String jewelColor = null;
    String targetColor = null;
    JewelArm armL = new JewelArm();
    // JewelArm armR = new JewelArm();
    String color = null;
    
    
    /*
     * Code to run ONCE when the driver hits INIT
     */
    public void init() {
        wheels.initWheels(this);
        telemetry.addData("Wheels", "Initialized");
        leftColor.initSensor(this);
        // rightColor.initSensor(this);
        telemetry.addData("Color Sensor", "Initialized");
        Lift.initLift(this);
        telemetry.addData("Forklift", "Initialized");
        glyphGrabber.initGrabber(this);
        telemetry.addData("Grabber", "Initialized");
        
        // init to raise jewel arm (R & L)
        armL.initJewelArm(this, "left");
        // armR.initJewelArm(this, "right");
        armL.moveJewelArmAuto(this, "left", "up");
        // armR.moveJewelArmAuto(this, "right", "up");
        telemetry.addData("Jewel Arm", "Initialized");
        telemetry.update();
        
        
    }
    
    /*
     * Code to run REPEATEDLY after the driver hits INIT, but before they hit PLAY
     */
    @Override
    public void init_loop() {
    }

    /*
     * Code to run ONCE when the driver hits PLAY
     */
    @Override
    public void start() {
        runtime.reset();
    }
    
     /*
     * Code to run REPEATEDLY after the driver hits PLAY but before they hit STOP
     */
    @Override
    public void loop() {

        
    // drop right arm
    // armR.moveJewelArmAuto(this, "left", "down");
    
    // color = rightColor.GetColor(this);
    
    /*
    // if blue drive forward
    if (color == "blue") {
        wheels.moveBot(this, "forward", .5);
        armR.moveJewelArmAuto(this, "left", "up");
        wheels.moveBot(this, "forward", 1.5);
    
    } else {
        wheels.moveBot(this, "backward", .5);
        armR.moveJewelArmAuto(this, "left", "up");
        wheels.moveBot(this, "forward", 2);
    }
    */
    
    wheels.moveBot(this, "forward", 2);

    // open pincher
    glyphGrabber.openPincher(this);
    
    // back up
    wheels.moveBot(this, "back", .25);
    
    
    
    stop();
        
    }
    
    /*
     * Code to run ONCE after the driver hits STOP
     */
    @Override
    public void stop() {
    }
    
}
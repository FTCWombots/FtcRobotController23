package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.sfdev.assembly.state.StateMachine;
import com.sfdev.assembly.state.StateMachineBuilder;

@TeleOp(name = "sftest")
public class SFTest extends LinearOpMode{
enum States {
     FIRST,
     SECOND,
     THIRD
};

     @Override
     public void runOpMode() throws InterruptedException {
          final boolean[] check1 = new boolean[1];
          final boolean[] check2 = new boolean[1];

          StateMachine machine = new StateMachineBuilder()
            .state(States.FIRST)
            .onEnter( () -> {
                    System.out.println( "Entering the first state" );
                    check1[0] = true;
               })
                  .transition( () ->  check1[0] == true ) // transition when check1 == true
                       .onExit( () -> check2[0] = false ) // setting checkx2 to false

                       .state(States.SECOND)
            .onEnter( () -> System.out.println( "Entering the second state" ) )
                       .transition( () -> check2[0] == false) // if check2 is false transition

                       .state(States.THIRD)
            .onEnter( () -> System.out.println( "In the third state " ) )
                       .build();

               waitForStart();

        machine.start();

                while(opModeIsActive()) { // autonomous loop
                    machine.update();
               }
          }
     }
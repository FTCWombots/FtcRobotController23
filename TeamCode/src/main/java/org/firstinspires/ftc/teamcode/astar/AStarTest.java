package org.firstinspires.ftc.teamcode.astar;

import static java.lang.System.currentTimeMillis;
import static java.lang.System.nanoTime;

import com.qualcomm.robotcore.eventloop.opmode.Autonomous;
import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;

import java.util.List;

@Autonomous(name = "AStarTest", group = "PathfindingTests")
public class AStarTest extends LinearOpMode {
    @Override
    public void runOpMode() throws InterruptedException {
        waitForStart();
        double sT=currentTimeMillis();
        Node initialNode = new Node(2, 1);
        Node finalNode = new Node(140, 140);
        int rows = 143;
        int cols = 143;
        AStar aStar = new AStar(rows, cols, initialNode, finalNode);
        int[][] blocksArray = new int[][]{{1, 3}, {2, 3}, {3, 3}};
        aStar.setBlocks(blocksArray);
        List<Node> path = aStar.findPath();
        for (Node node : path) {
            System.out.println(node);
        }
        double eT=currentTimeMillis();
        telemetry.addLine(String.valueOf(eT-sT));
        telemetry.update();
        while(opModeIsActive()){}
    }
}

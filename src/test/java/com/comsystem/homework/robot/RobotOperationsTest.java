package com.comsystem.homework.robot;

import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;
import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class RobotOperationsTest {

    @Test
    void excavateStonesForDays() {
        RobotOperations planner = new RobotOperations();

        // Test for even number of days
        RobotPlan evenDaysPlan = planner.excavateStonesForDays(5);
        assertEquals(5, evenDaysPlan.numberOfDays());
        assertEquals(16, evenDaysPlan.numberOfStones());

        // Test for odd number of days
        RobotPlan oddDaysPlan = planner.excavateStonesForDays(6);
        assertEquals(6, oddDaysPlan.numberOfDays());
        assertEquals(32, oddDaysPlan.numberOfStones());

    }

    @Test
    void daysRequiredToCollectStones() {
        RobotOperations planner = new RobotOperations();

        // Test for even number of days
        RobotPlan test1 = planner.daysRequiredToCollectStones(15);
        List<RobotAction> exprectedPlan = Arrays.asList(
                RobotAction.DIG, RobotAction.CLONE,
                RobotAction.DIG, RobotAction.CLONE,
                RobotAction.DIG, RobotAction.CLONE,
                RobotAction.DIG);
        assertEquals(7, test1.numberOfDays());
        assertEquals(exprectedPlan, test1.robotActions());


        RobotPlan test2 = planner.daysRequiredToCollectStones(17);
        exprectedPlan = Arrays.asList(
                RobotAction.DIG, RobotAction.CLONE,
                RobotAction.CLONE, RobotAction.CLONE,
                RobotAction.CLONE, RobotAction.DIG);
        assertEquals(6, test2.numberOfDays());
        assertEquals(exprectedPlan, test2.robotActions());


    }
}
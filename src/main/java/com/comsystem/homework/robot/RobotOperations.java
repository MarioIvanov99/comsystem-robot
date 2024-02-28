package com.comsystem.homework.robot;


import com.comsystem.homework.model.RobotAction;
import com.comsystem.homework.model.RobotPlan;

import java.util.ArrayList;
import java.util.List;

public class RobotOperations {

    private List<Integer> breakdownIntoPowersOfTwo(int num) {
        List<Integer> powers = new ArrayList<>();
        int power = 0;
        while (num > 0) {
            if ((num & 1) == 1) {
                powers.add((int) Math.pow(2, power));
            }
            num >>= 1;
            power++;
        }
        return powers;
    }

    /**
     * An algorithm that converts a number of days into an action plan.
     * @param days the number of days that the robot can work
     * @return The action plan <em>must maximize</em> the number of stones that the robot will dig. In other words, this
     *         algorithm must try to achieve the highest value of {@link RobotPlan#numberOfStones} possible for the
     *         number of provided days. The value of {@link RobotPlan#numberOfDays} is equal to the input
     *         days parameter
     * @see RobotPlan
     */
    public RobotPlan excavateStonesForDays(int days) {
        /*
        // Code assuming CLONE is +1 instead of *2
        // days is divided by 2 and works for odd numbers because Java always rounds down
        int daysCloning = days / 2;
        int daysGathering = days - daysCloning;

        List<RobotAction> actions = new ArrayList<>();

        // Add CLONE actions for daysCloning
        for (int i = 0; i < daysCloning; i++) {
            actions.add(RobotAction.CLONE);
        }

        // Add DIG actions for daysGathering
        for (int i = 0; i < daysGathering; i++) {
            actions.add(RobotAction.DIG);
        }

        //Starts with 1 robot initially
        int totalRocks = (daysCloning + 1) * daysGathering;*/

        int daysCloning = days - 1;
        int totalRocks = 1;
        List<RobotAction> actions = new ArrayList<>();

         // Add CLONE actions for daysCloning
        for (int i = 0; i<daysCloning; i++) {
            totalRocks *= 2;
            actions.add(RobotAction.CLONE);
        }

        // Add DIG action
        actions.add(RobotAction.DIG);

        return new RobotPlan(days, totalRocks, actions);
    }

    /**
     * An algorithm that converts a number of stones into an action plan. Essentially this algorithm is the inverse of
     * {@link #excavateStonesForDays(int)}.
     * @param numberOfStones the number of stones the robot has to collect
     * @return The action plan <em>must minimize</em> the number of days necessary for the robot to dig the
     *         provided number of stones. In other words, this algorithm must try to achieve the lowest value of
     *         {@link RobotPlan#numberOfDays} possible for the number of provided stones. The value of
     *         {@link RobotPlan#numberOfStones} is equal to the numberOfStones parameter
     * @see RobotPlan
     */


    public RobotPlan daysRequiredToCollectStones(int numberOfStones) {

        // Breakdown number into powers of 2
        List<Integer> listOfPowers = breakdownIntoPowersOfTwo(numberOfStones);
        List<RobotAction> actions = new ArrayList<>();
        int numRobots = 1;
        int numDays= 0;

        for(int i = 0; i < listOfPowers.size(); i++){
            // For each number get appropriate number of robots to dig
            while (numRobots < listOfPowers.get(i)) {
                numRobots *= 2;
                actions.add(RobotAction.CLONE);
                numDays++;
            }
            if(numRobots == listOfPowers.get(i)){
                actions.add(RobotAction.DIG);
                numDays++;
            }
        }
        return new RobotPlan(numDays, numberOfStones, actions);
    }

}

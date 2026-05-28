// RoadRepairSolution.java
package HackerRankCodeRunner.Problems.ActiveTraders;

import HackerRankCodeRunner.Problems.HackerRankSolution;

import java.io.PrintWriter;
import java.util.*;

public class ActiveTradersSolution extends HackerRankSolution {

    @Override
    public void solve(Scanner in, PrintWriter out) {
        int n              = readInt(in);
        String[] customers = readStringArray(in, n);

        printArray(out, mostActive(customers));
    }

    //current version
//    private String[] mostActive(String[] customers) {
//        Map<String, Integer> seen = new HashMap<>();
//        int activeThresholdPercentage = 5;
//
//        for(String customer:customers)
//            seen.put(customer,seen.getOrDefault(customer,0) + 1);
//
//        List<String> mostActiveCustomers = new ArrayList<>();
//        for(Map.Entry<String, Integer> seenCustomer:seen.entrySet())
//        {
//            int noOfTrades = seenCustomer.getValue();
//            double percentageTrades = ((double) noOfTrades / customers.length)*100;
//            if(percentageTrades>=activeThresholdPercentage)
//                mostActiveCustomers.add(seenCustomer.getKey());
//        }
//
//        return mostActiveCustomers.stream().sorted().toArray(String[]::new);
//    }

    //optimized version
    private String[] mostActive(String[] customers) {
        Map<String, Integer> tradesCount = new HashMap<>();
        int activeThresholdPercentage = 5;

        for(String customer:customers)
            tradesCount.put(customer,tradesCount.getOrDefault(customer,0) + 1);

        return tradesCount
                .entrySet()
                .stream()
                .filter(x -> x.getValue() * 100 >= activeThresholdPercentage * customers.length)
                .map(Map.Entry::getKey)
                .sorted()
                .toArray(String[]::new);
    }


    @Override
    public String getTestCasesDirectoryPath() {
        return "src/HackerRankCodeRunner/Problems/ActiveTraders/TestCases";
    }

}
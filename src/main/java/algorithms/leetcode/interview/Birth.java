package algorithms.leetcode.interview;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Birth {
    public static void read(List<DayInfo> inputList){
        HashMap<Integer, HashMap<Integer, Integer>> yearMap = new HashMap<>();

        for(int i=0;i<inputList.size();i++){
            int year = inputList.get(i).year;
            int month = inputList.get(i).month;
            int numBirth = inputList.get(i).nBirth;

            HashMap<Integer, Integer> monthMap = yearMap.get(year);
            if(monthMap!=null){
                if(monthMap.keySet().contains(month)){
                    monthMap.put(month, monthMap.get(month)+numBirth);
                }else{
                    monthMap.put(month, numBirth);
                }
            }else{
                monthMap = new HashMap<>();
                monthMap.put(month, numBirth);
                yearMap.put(year, monthMap );
            }
        }
        HashMap<Integer, HashMap<Integer, Double>> result = calc(yearMap);
    }

    public static HashMap<Integer, HashMap<Integer, Double>> calc(HashMap<Integer, HashMap<Integer, Integer>> yearMap){
        HashMap<Integer, HashMap<Integer, Double>> prob = new HashMap<>(12);

        for(int i=0;i<12;i++){
            prob.put(i+1, new HashMap<Integer, Double>());
        }

        for(Map.Entry year : yearMap.entrySet()){
            HashMap<Integer, Integer> monthMap = (HashMap<Integer, Integer>)year.getValue();

            int sum = 0;
            for(Map.Entry month: monthMap.entrySet()){
                sum += (Integer) month.getValue();
            }

            for(Map.Entry<Integer, Integer> month: monthMap.entrySet()){
                double eachProbInYear = month.getValue().doubleValue()/(double)sum;
                HashMap<Integer, Double> yearProb =  prob.get(month.getKey());
                yearProb.put((Integer) year.getKey(), eachProbInYear);
                prob.put((Integer) month.getKey(), yearProb);
            }
        }

        return prob;
    }

    public static void main(String[] args) {
        DayInfo dayInfo1 = new DayInfo(1990, 1,1,100);
        DayInfo dayInfo2 = new DayInfo(1990, 1,2,200);
        DayInfo dayInfo3 = new DayInfo(1990, 2,1,300);
        DayInfo dayInfo4 = new DayInfo(1991, 1,1,400);

        List<DayInfo> inputList = new ArrayList<>();

        inputList.add(dayInfo1);
        inputList.add(dayInfo2);
        inputList.add(dayInfo3);
        inputList.add(dayInfo4);

        read(inputList);
    }
}


class DayInfo{
    int year;
    int month;
    int day;
    int nBirth;

    public DayInfo(int year, int month, int day, int nBirth) {
        this.year = year;
        this.month = month;
        this.day = day;
        this.nBirth = nBirth;
    }
}
package algorithms.leetcode.array;

import java.util.HashMap;

public class NinehunadardAndEleven {
    public static void main(String[] args) {

    }

    int[] persons;
    int[] times;
    HashMap<Integer, Integer> time2Person;
    public NinehunadardAndEleven(int[] persons, int[] times) {
        this.persons = persons;
        this.times = times;
        int max = 0;

        if(persons.length == 0) {
            return;
        }
        HashMap<Integer, Integer> scoreMap = new HashMap<>();
        time2Person = new HashMap<>();
        int prePerson = persons[0];
        for(int i=0; i< times.length; i++) {
            int score = scoreMap.getOrDefault(persons[i], 0);
            max = Math.max(max, score + 1);
            int currentPerson;
            if (max > score +1) {
                currentPerson = prePerson;
            }else {
                currentPerson = persons[i];
                prePerson = persons[i];
            }
            time2Person.put(times[i], currentPerson);
            scoreMap.put(persons[i], score+1);
        }
    }

    public int q(int t) {
        if(times.length == 0) {
            return -1;
        }
        int left = 0;
        int right = times.length-1;
        int mid = (left +right)/2;
        while (left < right) {
            mid = (left +right)/2;
            if (times[mid]<= t) {
                left = mid +1;
            }else {
                right = mid;
            }
        }
        if(times[left]<=t) {
            return time2Person.get(times[left]);
        }else {
            return time2Person.get(times[left-1]);
        }

    }
}

package dataStructures.Algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SlotsAlgorithm {
    /*
     Algorithm
     1. Get the minimum working start time of the given staff's -> Let me assume as 8 AM
     2. Get the minimum working end time of the given staff's -> Let me assume as 6 PM
     3. Form a list for the duration
     */
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        List<List<Interval>> staffWithWorkingList = new ArrayList<>();
        System.out.println("Enter number of staff");
        int n = in.nextInt();
        for(int i=0;i<n;i++){
            List<Interval> list = new ArrayList<>();
            System.out.println("Enter Staff "+(i+1)+" working hours startTime followed by endtime");
            int start = in.nextInt();
            int end = in.nextInt();
            System.out.println("Enter number breaks ");
            int breaks = in.nextInt();
            for(int j=0;j<breaks;j++){
                System.out.println("Enter break starttime");
                int breakStartTime = in.nextInt();
                System.out.println("Enter break endtime");
                int breakEndTime = in.nextInt();
                if(breakStartTime > start){
                    list.add(new Interval(start, breakStartTime));
                    if(breakEndTime < end){
                        list.add(new Interval(breakEndTime, end));
                    }
                }
            }
            staffWithWorkingList.add(list);
        }
        processStaff(staffWithWorkingList);
    }

    private static void processStaff(List<List<Interval>> staffWithWorkingList) {
        for(List<Interval> list : staffWithWorkingList){
            list.forEach(staff -> System.out.println("Start -"+staff.start+","+"End -"+staff.end));
            System.out.println("------------------->");
        }
    }
}
class Interval{
    int start, end;
    Interval(int start, int end){
        this.start = start;
        this.end = end;
    }
}

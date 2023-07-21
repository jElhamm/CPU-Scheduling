package com.cpu_scheduler_2;

import java.util.ArrayList;
import java.util.List;

public class SJF_Scheduling 
{
    public static void main( String[] args )
    {
        // Create processes
        List<Process> ProcessList = new ArrayList<>();
        ProcessList.add(new Process(1, 0, 5));
        ProcessList.add(new Process(2, 1, 3));
        ProcessList.add(new Process(3, 2, 8));
        ProcessList.add(new Process(4, 3, 6));

        int processesSize = ProcessList.size();
        int[] completionTime = new int[processesSize];
        int[] waitingTime = new int[processesSize];
        int[] turnaroundTime = new int[processesSize];

        // Sorting processes based on arrival time
        for (int i = 0; i < processesSize - 1; i++) {
            for (int j = i + 1; j < processesSize; j++) {
                if (ProcessList.get(i).getArrivalTime() > ProcessList.get(j).getArrivalTime()) {
                    Process tempProcess = ProcessList.get(i);
                    ProcessList.set(i, ProcessList.get(j));
                    ProcessList.set(j, tempProcess);
                }
            }
        }

        // Find the start time of each process
        int currentTime = 0;         
        for (int i = 0; i < processesSize; i++) {
            Process currentProcess = ProcessList.get(i);
            completionTime[i] = currentTime + currentProcess.getBurstTime();
            currentTime += currentProcess.getBurstTime();
        }
        
        // Calculation of waiting time and travel time
        for (int i = 0; i < processesSize; i++) {
            waitingTime[i]    = completionTime[i] - ProcessList.get(i).getArrivalTime();
            turnaroundTime[i] = waitingTime[i] + ProcessList.get(i).getBurstTime();
        }

         // Calculate averages
        int sumWaitingTime = 0;
        int sumTurnaroundTime = 0;
        for (int i = 0; i < processesSize; i++) {
            waitingTime[i]    = completionTime[i] - ProcessList.get(i).getArrivalTime();
            turnaroundTime[i] = waitingTime[i] + ProcessList.get(i).getBurstTime();
            sumWaitingTime += waitingTime[i];
            sumTurnaroundTime += turnaroundTime[i];
        }
        double avgWaitingTime    = (double) sumWaitingTime / processesSize;      /*Average waiting time in decimal*/
        double avgTurnaroundTime = (double) sumTurnaroundTime / processesSize;   /*Average end time in decimal*/

         // Display the result
        System.out.println("\n                                # output scheduling:\n");
        System.out.println("PID\tArrival Time\tBurst Time\tCompletion Time \tWaiting Time\tTurnaround Time");
        for (int i = 0; i < ProcessList.size(); i++) {
            Process newProcess = ProcessList.get(i);
            System.out.println(newProcess.getPidProcess()+"\t\t"+newProcess.getArrivalTime()+"  \t\t"+newProcess.getBurstTime()+"\t\t"+newProcess.getCompletionTime()+"\t\t"+newProcess.getWaitingTime()+"\t\t"+newProcess.getTurnaroundTime());
        }
        System.out.println("\n                                ## Average Waiting Time: " + avgWaitingTime);
        System.out.println("                                ### Average Turnaround Time: " + avgTurnaroundTime + "\n");
    }
}
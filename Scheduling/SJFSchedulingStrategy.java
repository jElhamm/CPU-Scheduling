/**
 * SJF scheduling strategy:
 * In this algorithm, processes are arranged and executed based on CPU Burst in ascending order.
 */

import java.util.List;

public class SJFSchedulingStrategy implements ISchedulingStrategy {
    @Override
    public void schedule(List<Process> processes) {
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println("\n  ***  Executing processes using SJF scheduling strategy:  ***  \n");
        
        // Sort the processes based on arrival time
        int processesSize = processes.size();
        for (int i = 0; i < processesSize - 1; i++) {
            for (int j = i + 1; j < processesSize; j++) {
                if (processes.get(i).getArrivalTime() > processes.get(j).getArrivalTime()) {
                    Process tempProcess = processes.get(i);
                    processes.set(i, processes.get(j));
                    processes.set(j, tempProcess);
                }
            }
        }
        int currentTime = 0;
        for (Process process : processes) {
            // Wait until the process arrives
            if (currentTime < process.getArrivalTime()) {
                currentTime = process.getArrivalTime();
            }
            System.out.print("         Executing process: " + process.getName());
            currentTime += process.getBurstTime();
            System.out.println(" ==> " + " finished at time " + currentTime);
        }
        System.out.println("-----------------------------------------------------------------------\n");
    }
}

/**
 * Priority scheduling strategy:
 * In this algorithm, processes are executed based on priority
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PrioritySchedulingStrategy implements ISchedulingStrategy {
    
    private class ProcessComparator implements Comparator<Process> {
        @Override
        public int compare(Process p1, Process p2) {
            if (p1.getPriority() < p2.getPriority()) {
                return -1;
            } else if (p1.getPriority() > p2.getPriority()) {
                return 1;
            }
            // If priorities are equal, compare by arrival time
            if (p1.getArrivalTime() < p2.getArrivalTime()) {
                return -1;
            } else if (p1.getArrivalTime() > p2.getArrivalTime()) {
                return 1;
            }
            return 0;
        }
    }
    
    @Override
    public void schedule(List<Process> processes) {
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println("\n  ***  Executing processes using Priority Scheduling strategy:  ***  \n");
        
        // Check for negative priorities
        for (Process process : processes) {
            if (process.getPriority() < 0) {
                throw new IllegalArgumentException("Invalid priority value!");
            }
        }
        
        List<Process> sortedProcesses = new ArrayList<>(processes);
        sortedProcesses.sort(new ProcessComparator());

        int currentTime = 0;
        for (Process process : sortedProcesses) {
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
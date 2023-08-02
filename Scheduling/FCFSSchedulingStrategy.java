/**
 * FCFS Scheduling Strategy:
 * This scheduling strategy executes processes in the order they arrive.
 * It maintains a ready queue (implemented as a LinkedList) to hold the processes.
 * The algorithm starts with an empty ready queue and a current time of 0.
 * After all processes have been executed, the algorithm completes.
 */

import java.util.LinkedList;
import java.util.List;

public class FCFSSchedulingStrategy implements ISchedulingStrategy {
    @Override
    public void schedule(List<Process> processes) {
        System.out.println("\n********************************************************************");
        System.out.println("\n  ***  Executing processes using FCFS scheduling strategy:  ***  \n");
        LinkedList<Process> readyQueue = new LinkedList<>(processes);
        int currentTime = 0;
        while (!readyQueue.isEmpty()) {
            Process process = readyQueue.poll();
            // Wait until the process arrives
            if (currentTime < process.getArrivalTime()) {
                currentTime = process.getArrivalTime();
            }
            System.out.print("         Executing process: " + process.getName());
            currentTime += process.getBurstTime();
            System.out.println(" ==> " + " finished at time " + currentTime);
        }
        System.out.println("********************************************************************\n");
    }
    
}

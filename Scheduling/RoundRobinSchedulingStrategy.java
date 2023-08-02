/**
 * Round Robin scheduling strategy:
 * In this algorithm, each process in each round is processed for a certain amount of time called time quantum.
 */

import java.util.LinkedList;
import java.util.List;

public class RoundRobinSchedulingStrategy implements ISchedulingStrategy {
    private int timeQuantum;

    public RoundRobinSchedulingStrategy(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }
    @Override
    public void schedule(List<Process> processes) {
        System.out.println("\n-----------------------------------------------------------------------");
        System.out.println("\n  ***  Executing processes using Round Robin scheduling strategy:  ***  \n");

        LinkedList<Process> readyQueue = new LinkedList<>(processes);
        int currentTime = 0;
        while (!readyQueue.isEmpty()) {
            Process process = readyQueue.poll();
            // Wait until the process arrives
            if (currentTime < process.getArrivalTime()) {
                currentTime = process.getArrivalTime();
            }
            System.out.print("         Executing process: " + process.getName());
            // Execute the process for the time quantum or until it finishes
            int remainingTime = process.getBurstTime();
            while (remainingTime > 0) {
                if (remainingTime <= timeQuantum) {
                    currentTime += remainingTime;
                    remainingTime = 0;
                } else {
                    currentTime += timeQuantum;
                    remainingTime -= timeQuantum;
                    readyQueue.offer(process); // Add the process back to the queue
                }
            }
            System.out.println(" ==> " + " finished at time " + currentTime);
        }
        System.out.println("-----------------------------------------------------------------------\n");
    }

    public void setTimeQuantum(int timeQuantum) {
        this.timeQuantum = timeQuantum;
    }
    public int getTimeQuantum() {
        return this.timeQuantum;
    }
}

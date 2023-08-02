/**
 * multi-level scheduling strategy:
 * It divides processes into multiple priority queues based on their priority.
 * The algorithm executes processes in a round-robin fashion, starting from the highest priority queue and moving to the next queue cyclically.
 */

import java.util.LinkedList;
import java.util.List;

class MultiLevelSchedulingStrategy implements ISchedulingStrategy {
    private int numQueues;

    public MultiLevelSchedulingStrategy(int numQueues) {
        this.numQueues = numQueues;
    }

    @Override
    public void schedule(List<Process> processes) {
        System.out.println("\n  ***  Executing processes using Multi-Level Scheduling strategy:  ***  \n");

        LinkedList<Process>[] queues = new LinkedList[numQueues];
        for (int i = 0; i < numQueues; i++) {
            queues[i] = new LinkedList<>();
        }
        for (Process process : processes) {
            int priority = process.getPriority();
            if (priority >= 0 && priority < numQueues) {
                queues[priority].add(process);
            } else {
                queues[numQueues - 1].add(process); // Add to the lowest priority queue
            }
        }

        int currentTime = 0;
        int currentQueue = 0;
        while (true) {
            LinkedList<Process> currentQueueProcesses = queues[currentQueue];
            if (!currentQueueProcesses.isEmpty()) {
                Process process = currentQueueProcesses.poll();
                if (currentTime < process.getArrivalTime()) {
                    currentTime = process.getArrivalTime();
                }
                System.out.print("         Executing process: " + process.getName());
                currentTime += process.getBurstTime();
                System.out.println(" ==> " + " finished at time " + currentTime);
            }
            boolean allQueuesEmpty = true;
            for (int i = 0; i < numQueues; i++) {
                if (!queues[i].isEmpty()) {
                    allQueuesEmpty = false;
                    break;
                }
            }
            if (allQueuesEmpty) {
                break;
            }
            currentQueue = (currentQueue + 1) % numQueues;
        }
        System.out.println("-----------------------------------------------------------------------\n");
    }
    public void setNumQueues(int timeQuantum) {
        this.numQueues = timeQuantum;
    }
    public int getNumQueues() {
        return this.numQueues;
    }
}
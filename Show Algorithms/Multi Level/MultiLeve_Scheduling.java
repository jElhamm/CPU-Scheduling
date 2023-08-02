/**
 * MultiLeve Scheduling :
 * The multiLeve_scheduling class represents a multi-level priority scheduling algorithm.
 *  It maintains three separate queues for processes with different priorities:
 *       highPriorityQueue, mediumPriorityQueue, and lowPriorityQueue.
 **/

import java.util.ArrayList;
import java.util.List;

public class multiLeve_scheduling {
    private List<Process> lowPriorityQueue;
    private List<Process> mediumPriorityQueue;
    private List<Process> highPriorityQueue;

    public multiLeve_scheduling() {
        lowPriorityQueue = new ArrayList<Process>();
        mediumPriorityQueue = new ArrayList<Process>();
        highPriorityQueue = new ArrayList<Process>();
    }
    public void addProcess(Process process) {
        if (process.getPriority() > 0 && process.getPriority() <= 3) {
            highPriorityQueue.add(process);
        } else if (process.getPriority() >= 4 && process.getPriority() <= 6) {
            mediumPriorityQueue.add(process);
        } else if (process.getPriority() >= 7 && process.getPriority() <= 9) {
            lowPriorityQueue.add(process);
        } else {
            System.out.println("Invalid priority for process: " + process.getName());
        }
    }
    public void runScheduler() {
        while (!isLowPriorityQueueEmpty() || !isMediumPriorityQueueEmpty() || !isHighPriorityQueueEmpty()) {
            if (!isHighPriorityQueueEmpty()) {
                execute(highPriorityQueue);
            } else if (!isMediumPriorityQueueEmpty()) {
                execute(mediumPriorityQueue);
            } else {
                execute(lowPriorityQueue);
            }
        }
    }
    private void execute(List<Process> queue) {
        Process process = queue.get(0);
        System.out.println("----------------------------------------------------");
        System.out.println("|  Executing process: " + process.getName() + "                           |");
        int burstTime = process.getBurstTime();
        while (burstTime > 0) {
            System.out.println("|  Remaining burst time for process " + process.getName() + ": " + burstTime + "          |");
            burstTime--;
            process.setBurstTime(burstTime);
        }
        System.out.println("|  Process " + process.getName() + " executed." + "                            |");
        queue.remove(0);
    }

    public boolean isLowPriorityQueueEmpty() {
        return lowPriorityQueue.isEmpty();
    }
    public boolean isMediumPriorityQueueEmpty() {
        return mediumPriorityQueue.isEmpty();
    }
    public boolean isHighPriorityQueueEmpty() {
        return highPriorityQueue.isEmpty();
    }
    public List<Process> getHighPriorityQueue() {
        return highPriorityQueue;
    }
    public List<Process> getMediumPriorityQueue() {
        return mediumPriorityQueue;
    }
    public List<Process> getLowPriorityQueue() {
        return lowPriorityQueue;
    }
}
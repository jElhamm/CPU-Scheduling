/**
 * Priority Scheduling :
 * The Priority Scheduling algorithm is a CPU scheduling algorithm where each process is assigned a priority, and the scheduler selects the process with the highest priority for execution. 
 * In this algorithm, processes are sorted based on their priority, and the process with the highest priority is given the CPU first.
 **/

import java.util.*;

public class Priority_Scheduling 
{
    public static void main( String[] args )
    {
        // Create processes
        ArrayList<Process> processList = new ArrayList<>();
        processList.add(new Process(1, 0, 3, 3));
        processList.add(new Process(2, 3, 5, 2));
        processList.add(new Process(3, 5, 1, 1));
        processList.add(new Process(4, 9, 7, 4));

        // Sort processes based on priority 
        // (Bubble Sort)
        for (int i=0; i < processList.size()-1; i++) {
            for (int j=0; j < processList.size()-i-1; j++) {
                if (processList.get(j).getPriority() > processList.get(j+1).getPriority()) {
                    // Swap two processes
                    Process newTemp = processList.get(j);
                    processList.set(j, processList.get(j + 1));
                    processList.set(j + 1, newTemp);
                }
            }
        }

        // Calculate execution time and waiting time for each process
        int currentTime = 0;
        for (int i=0; i < processList.size(); i++) {
            Process newProcess = processList.get(i);
            if (currentTime < newProcess.getArrivalTime()) {
                currentTime = newProcess.getArrivalTime();
            }
            int waitingTime    = currentTime - newProcess.getArrivalTime();         /*Calculation of waiting time */
            int completionTime = currentTime + newProcess.getBurstTime();           /*Calculation of completion time */
            int turnaroundTime = completionTime - newProcess.getArrivalTime();      /*Calculation of turnaround time*/
            newProcess.setWaitingTime(waitingTime);
            newProcess.setCompletionTime(completionTime);
            newProcess.setTurnaroundTime(turnaroundTime);
            currentTime = completionTime;       
        }

        // Calculate averages
        double avgWaitingTime = 0;
        double avgTurnaroundTime = 0;
        for (int i=0; i < processList.size(); i++) {
            Process newProcess = processList.get(i);
            avgWaitingTime += newProcess.getWaitingTime();
            avgTurnaroundTime += newProcess.getTurnaroundTime();
        }
        avgWaitingTime    = avgWaitingTime / processList.size(); /*avgWaitingTime = avgWaitingTime + (totalWaitingTime / processes.size()) */
        avgTurnaroundTime = avgTurnaroundTime / processList.size(); /*avgTurnaroundTime = avgTurnaroundTime + (totalTurnaroundTime / processes.size()); */

        // Display the result
        System.out.println("\n                                # output scheduling:\n");
        System.out.println("PID\tArrival Time\tBurst Time\tCompletion Time\t  Process priority \tWaiting Time\tTurnaround Time");
        for (int i=0; i < processList.size(); i++) {
            Process newProcess = processList.get(i);
            System.out.println(newProcess.getPidProcess()+"\t\t"+newProcess.getArrivalTime()+"  \t\t"+newProcess.getBurstTime()+"\t\t"+newProcess.getCompletionTime()+"\t\t"+newProcess.getPriority()+"\t\t"+newProcess.getWaitingTime()+"\t\t"+newProcess.getTurnaroundTime());
        }
        System.out.println("\n                                ## Average Waiting Time: " + avgWaitingTime);
        System.out.println("                                ### Average Turnaround Time: " + avgTurnaroundTime + "\n");
    }
}
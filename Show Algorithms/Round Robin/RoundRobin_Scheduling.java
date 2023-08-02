/**
 * Round Robin scheduling strategy:
 * In this algorithm, each process in each round is processed for a certain amount of time called time quantum.
 **/

import java.util.*;

public class RoundRobin_Scheduling 
{
    public static void main( String[] args )
    {
        // Create processes
        ArrayList<Process> processList = new ArrayList<>();
        processList.add(new Process(1, 0, 3));
        processList.add(new Process(2, 3, 5));
        processList.add(new Process(3, 5, 1));
        processList.add(new Process(4, 9, 7));

        int quantumTime = 6;
        int currentTime = 0;
        boolean completed = false;

        // Implementation of Round Robin algorithm
        for (int i = 0; i < processList.size(); i++) {
            Process runningProcesses = processList.get(i);
            if (!runningProcesses.isCompleted()) {
                completed = false;
                int remainingTime = runningProcesses.getBurstTime() - runningProcesses.getExecutionTime();
                int executionTime = Math.min(quantumTime, remainingTime);  /*This line is to determine the execution time of the process */
                runningProcesses.execute(executionTime);
                currentTime += executionTime;   /*To update the current time */
                // Check the status of the process
                if (runningProcesses.isCompleted()) {
                    runningProcesses.setCompletionTime(currentTime);
                    runningProcesses.setTurnaroundTime(runningProcesses.getCompletionTime() - runningProcesses.getArrivalTime());
                    runningProcesses.setWaitingTime(runningProcesses.getTurnaroundTime() - runningProcesses.getBurstTime());
                }
            }
        }

        // Calculate averages
        double avgWaitingTime = 0;
        double avgTurnaroundTime = 0;
        for (int i = 0; i < processList.size(); i++) {
            Process process = processList.get(i);
            avgWaitingTime += process.getWaitingTime();
            avgTurnaroundTime += process.getTurnaroundTime();
        }
        avgWaitingTime = avgWaitingTime / processList.size(); /*avgWaitingTime = avgWaitingTime + (totalWaitingTime / processes.size()) */
        avgTurnaroundTime = avgTurnaroundTime / processList.size(); /*avgTurnaroundTime = avgTurnaroundTime + (totalTurnaroundTime / processes.size()); */

        // Display the result
        System.out.println("\n                                # output scheduling:\n");
        System.out.println("PID\tArrival Time\tBurst Time\tCompletion Time \tWaiting Time\tTurnaround Time");
        for (int i = 0; i < processList.size(); i++) {
            Process newProcess = processList.get(i);
            System.out.println(newProcess.getPidProcess()+"\t\t"+newProcess.getArrivalTime()+"  \t\t"+newProcess.getBurstTime()+"\t\t"+newProcess.getCompletionTime()+"\t\t"+newProcess.getWaitingTime()+"\t\t"+newProcess.getTurnaroundTime());
        }
        System.out.println("\n                                ## Average Waiting Time: " + avgWaitingTime);
        System.out.println("                                ### Average Turnaround Time: " + avgTurnaroundTime + "\n");
    }
}

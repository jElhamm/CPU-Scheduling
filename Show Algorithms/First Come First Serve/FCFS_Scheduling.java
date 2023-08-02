/**
 * FCFS Scheduling :
 * The FCFS Scheduling algorithm is a simple scheduling algorithm used in operating systems to schedule processes for execution on a CPU. 
 * It works on the principle that the process that arrives first is scheduled first and gets the CPU for execution until it completes.
 **/

import java.util.*;

public class FCFS_Scheduling 
{
    public static void main( String[] args )
    {
        // Create processes
        ArrayList<Process> ProcessList = new ArrayList<>();
        ProcessList.add(new Process(1, 0, 3));
        ProcessList.add(new Process(2, 3, 5));
        ProcessList.add(new Process(3, 5, 1));
        ProcessList.add(new Process(4, 9, 7));

        // Sorting processes based on entry time
        int sizeProcess = ProcessList.size();
        boolean swapped;
        for (int i = 0; i < sizeProcess - 1; i++) {
            swapped = false;
            for (int j = 0; j < sizeProcess - i - 1; j++) {
                 if (ProcessList.get(j).getArrivalTime() > ProcessList.get(j + 1).getArrivalTime()) {
                    Process temp = ProcessList.get(j);
                    ProcessList.set(j, ProcessList.get(j + 1));
                    ProcessList.set(j + 1, temp);
                    swapped = true;
                }
            }
            if (swapped == true) {
                break;
            } 
        }   

        // Placement of order of processes with FCFS algorithm
        int currentTime = 0;              
        for (int i = 0; i < ProcessList.size(); i++) {
            Process NEWProcess = ProcessList.get(i);
            NEWProcess.completionTime = currentTime + NEWProcess.getBurstTime();
            NEWProcess.turnaroundTime = NEWProcess.getCompletionTime() - NEWProcess.getArrivalTime();
            NEWProcess.waitingTime = NEWProcess.getTurnaroundTime() - NEWProcess.getBurstTime();
            currentTime = NEWProcess.getCompletionTime(); 
        }

        // Calculate averages
        double avgWaitingTime = 0;
        double avgTurnaroundTime = 0;
        for (int i = 0; i < ProcessList.size(); i++) {
            Process new_process = ProcessList.get(i);
            avgWaitingTime += new_process .getWaitingTime();
            avgTurnaroundTime += new_process .getTurnaroundTime();
        }
        avgWaitingTime = avgWaitingTime / ProcessList.size(); /*avgWaitingTime = avgWaitingTime + (totalWaitingTime / processes.size()) */
        avgTurnaroundTime = avgTurnaroundTime / ProcessList.size(); /*avgTurnaroundTime = avgTurnaroundTime + (totalTurnaroundTime / processes.size()); */

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
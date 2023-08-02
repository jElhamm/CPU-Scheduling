/**
 * In this section, an example of how this project works is shown. 
 * You can change this part according to your project. 
 **/

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            CPUScheduler scheduler = new CPUScheduler();
            System.out.println("\n####################################################################################################");
            System.out.println("#  In the program below, you can schedule the CPU with different algorithms and use this program.  #");
            System.out.println("#                                Implemented algorithms:                                           #");
            System.out.println("#                                  1. SJF Scheduling                                               #");
            System.out.println("#                                  2. FCFS Scheduling                                              #");
            System.out.println("#                                  3. Priority Scheduling                                          #");
            System.out.println("#                                  4. Round Robin Scheduling                                       #");
            System.out.println("#                                  5. Multi-Level Scheduling                                       #");
            System.out.println("####################################################################################################");
            System.out.print("   Select a scheduling algorithm: ");
            int choice = scanner.nextInt();
            
            System.out.print("\n---------------------------------------\n  Enter the number of processes: ");
            int numProcesses = scanner.nextInt();
            List<Process> processes = new ArrayList<>(numProcesses);
            if (choice == 1 || choice == 2 || choice == 4 || choice == 5){
                for (int i = 1; i <= numProcesses; i++) {
                    System.out.println("---------------------------------------\n  Enter details for Process P" + i + ":");
                    System.out.print("   Arrival Time: ");
                    int arrivalTime = scanner.nextInt();
                    System.out.print("   Burst Time: ");
                    int burstTime = scanner.nextInt();
                    processes.add(new Process("P" + i, arrivalTime, burstTime));
                }
            } else if (choice == 3) {
                for (int i=1; i <= numProcesses; i++) {
                    System.out.println("---------------------------------------\n  Enter details for Process P" + i + ":");
                    System.out.print("   Arrival Time: ");
                    int arrivalTime = scanner.nextInt();
                    System.out.print("   Burst Time: ");
                    int burstTime = scanner.nextInt();
                    System.out.print("   Priority: ");
                    int priority = scanner.nextInt();
                    processes.add(new Process("P" + i, arrivalTime, burstTime, priority));
                }
                
            } else {
                System.out.print("  ( ! The selection option is not available ! )  ");
            }
            switch (choice) {
                case 1:
                    scheduler.setSchedulingStrategy(new SJFSchedulingStrategy());
                    break;
                case 2:
                    scheduler.setSchedulingStrategy(new FCFSSchedulingStrategy());
                    break;
                case 3:
                    scheduler.setSchedulingStrategy(new PrioritySchedulingStrategy());
                    break;
                case 4:
                    System.out.println("\n---------------------------------------------------------------");
                    System.out.print("  Enter time quantum for Round Robin Scheduling: ");
                    int timeQuantum = scanner.nextInt();
                    scheduler.setSchedulingStrategy(new RoundRobinSchedulingStrategy(timeQuantum));
                    break;
                case 5:
                    System.out.println("\n---------------------------------------------------------------");
                    System.out.print("  Enter the number of queues for Multi-Level Scheduling: ");
                    int numQueues = scanner.nextInt();
                    scheduler.setSchedulingStrategy(new MultiLevelSchedulingStrategy(numQueues));
                    break;
                default:
                    System.out.println("\n---------------------------------------------------------------");
                    System.out.println("  ( ! Invalid choice. Exiting... ! )  ");
                    return;
            }
            scheduler.execute(processes);
            scanner.close();

        } catch (Exception e) {
            System.out.println("\n  ( ! An error occurred: " + e.getMessage() + " ! )  \n");
        }
    }
}
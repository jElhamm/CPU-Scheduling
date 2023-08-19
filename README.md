# CPU Scheduling

   This repository contains implementations of various [*(CPU scheduling Algorithms)*](https://www.futurelearn.com/info/courses/computer-systems/0/steps/53513) in Java. 
   The implemented algorithms include:

   * [First-Come, First-Served (FCFS)](https://www.javatpoint.com/os-fcfs-scheduling)
   * [Shortest Job First (SJF)](https://www.javatpoint.com/os-sjf-scheduling)
   * [Priority Scheduling](https://www.javatpoint.com/os-priority-scheduling)
   * [Round Robin (RR)](https://www.javatpoint.com/os-round-robin-scheduling-algorithm)
   * [Multi-Level (MLQ)](https://www.javatpoint.com/multilevel-queue-scheduling-in-operating-system)

## Performance of Algorithms

   1. FCFS:

       * This Algorithm Schedules processes based on their arrival times.
       * The process that arrives first gets executed first, and subsequent processes wait in a queue until it's their turn.
       * It operates under the assumption that all processes are equally important.
       * [*More Information*](https://www.geeksforgeeks.org/first-come-first-serve-cpu-scheduling-non-preemptive/)

   2. SJF:

       * This Algorithm Schedules processes based on their burst times.
       * The process with the shortest burst time is executed first, minimizing the average waiting time.
       * It can be either *preemptive* or *non-preemptive*
       * [*More Information*](https://www.studytonight.com/operating-system/shortest-job-first)

   4. RR:

       * This Algorithm allocates a fixed time slice *(Quantum)* to each process in a cyclic manner.
       * Each process gets a chance to execute for the defined time quantum before being preempted and placed back in the ready queue.
       * It ensures fairness by giving equal opportunities to all processes and prevents starvation.
       * [*More Information*](https://www.scaler.com/topics/round-robin-scheduling-in-os/)

   3. Priority:

       * This Algorithm assigns priorities to processes based on certain criteria.
       * The process with the highest priority is executed first.
       * It can be either *preemptive* or *non-preemptive*.
       * [*More Information*](https://www.geeksforgeeks.org/program-for-priority-cpu-scheduling-set-1/)

   5. Multi-Level:

       * This Algorithm divides the ready queue into multiple separate queues, each with its own Scheduling Algorithm.
       * Processes are assigned to different queues based on specified criteria.
       * Each queue can use a different *Scheduling Algorithm* to manage its processes.
       * [*More Information*](https://www.geeksforgeeks.org/multilevel-queue-mlq-cpu-scheduling/)

## References

   * [Scheduling (computing)](https://en.wikipedia.org/wiki/Scheduling_(computing))
   * [CPU Scheduling in Operating Systems](https://www.geeksforgeeks.org/cpu-scheduling-in-operating-systems/)
   * [Preemptive and Non-Preemptive Scheduling](https://www.geeksforgeeks.org/preemptive-and-non-preemptive-scheduling/)
   * Operating System Concepts Book by Abraham Silberschatz.
   * Modern Operating Systems Book by Andrew Tanenbaum.
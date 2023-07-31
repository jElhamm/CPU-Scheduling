# CPU Scheduling Algorithms

This repository contains implementations of various CPU scheduling algorithms in Java. The implemented algorithms include:

  1. First-Come, First-Served (FCFS)
  2. Shortest Job First (SJF)
  3. Priority Scheduling
  4. Round Robin (RR)
  5. Multi-Level

Each algorithm is implemented as a separate Java class in the `src` directory. You can find the source code and example usage in their respective files.

## Usage

To use these algorithms, you can simply copy the desired Java class into your project and instantiate an object of that class. Each algorithm typically provides a `schedule()` method, which takes input parameters (such as process arrival times and burst times) and returns the scheduling result.

Make sure to check the individual Java class files for detailed information on how to use each algorithm.

## Performance of Algorithms

Here's a brief explanation of the functionality of each CPU scheduling algorithm:

   1. First-Come, First-Served (FCFS):

       * This algorithm schedules processes based on their arrival times.
       * The process that arrives first gets executed first, and subsequent processes wait in a queue until it's their turn.
       * It operates under the assumption that all processes are equally important.

   2. Shortest Job First (SJF):

       * This algorithm schedules processes based on their burst times.
       * The process with the shortest burst time is executed first, minimizing the average waiting time.
       * It can be either preemptive (allowing the currently executing process to be interrupted) or non-preemptive (once a process starts executing, it runs to completion).

   3. Priority Scheduling:

       * This algorithm assigns priorities to processes based on certain criteria (such as priority values or process characteristics).
       * The process with the highest priority is executed first.
       * It can be either preemptive or non-preemptive.

   4. Round Robin (RR):

       * This algorithm allocates a fixed time slice (quantum) to each process in a cyclic manner.
       * Each process gets a chance to execute for the defined time quantum before being preempted and placed back in the ready queue.
       * It ensures fairness by giving equal opportunities to all processes and prevents starvation.

   5. Multi-Level:

       * This algorithm divides the ready queue into multiple separate queues, each with its own scheduling algorithm.
       * Processes are assigned to different queues based on specified criteria (e.g., process priority, process type).
       * Each queue can use a different scheduling algorithm (such as FCFS, SJF, or Priority Scheduling) to manage its processes.

Each algorithm has its own advantages and disadvantages, and their suitability depends on factors like system requirements, process characteristics, and scheduling goals.

Please note that the provided explanation is a high-level overview of each algorithm. For detailed implementation and usage instructions, you can refer to the individual Java class files in the repository.
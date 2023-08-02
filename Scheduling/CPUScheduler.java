package com.cpu_scheduler;

import java.util.List;

public class CPUScheduler {
    private ISchedulingStrategy strategy;

    public void execute(List<Process> processes) {
        if (processes.isEmpty()) {
            System.out.println("  No processes to execute.  ");
            return;
        }
        if (strategy == null) {
            System.out.println("  No scheduling strategy set.  ");
            return;
        }
        strategy.schedule(processes);
    }
    public void setSchedulingStrategy(ISchedulingStrategy strategy) {
        this.strategy = strategy;
    }
    public ISchedulingStrategy getSchedulingStrategy() {
        return this.strategy;
    }
}

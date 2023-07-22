package com.cpu_scheduling;

public class Process {
    private   int pidProcess; 
    protected int arrivalTime;  
    protected int burstTime; 
    protected int completionTime; 
    protected int waitingTime; 
    protected int turnaroundTime; 
    private   int executionTime;

    public Process(int pidProcess, int arrivalTime, int burstTime) {
        this.pidProcess = pidProcess;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.executionTime = 0;
        this.completionTime = 0;
        this.turnaroundTime = 0;
        this.waitingTime = 0;
    }
    
    public boolean isCompleted() {
        if (executionTime >= burstTime) {
            return true;
        } else {
            return false;
        }
    }
    public void execute(int executionTime) {
        this.executionTime += executionTime;
    }
    public void setCompletionTime(int completionTime) {
        this.completionTime = completionTime;
    }
    public void setTurnaroundTime(int turnaroundTime) {
        this.turnaroundTime = turnaroundTime;
    }
    public void setWaitingTime(int waitingTime) {
        this.waitingTime = waitingTime;
    }
    
    public int getPidProcess() {
        return this.pidProcess;
    }
    public int getArrivalTime() {
        return this.arrivalTime;
    }
    public int getBurstTime() {
        return this.burstTime;
    }
    public int getCompletionTime() {
        return this.completionTime;
    }
    public int getWaitingTime() {
        return this.waitingTime;
    }
    public int getTurnaroundTime() {
        return this.turnaroundTime;
    }
    public int getExecutionTime() {
        return this.executionTime;
    }
}

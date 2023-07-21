package com.cpu_scheduling;

public class Process {
    private   int pidProcess; 
    protected int arrivalTime; 
    protected int burstTime; 
    protected int completionTime; 
    protected int waitingTime;
    protected int turnaroundTime; 

    public Process(int pidProcess, int arrivalTime, int burstTime) {
        this.pidProcess = pidProcess;
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
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
}
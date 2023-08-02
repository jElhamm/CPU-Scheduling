package com.cpu_scheduler;

public class Process {
    private String name;
    private int arrivalTime;
    private int burstTime;
    private int priority;

    public Process(String name, int arrivalTime, int burstTime, int priority) {
        this.name = name;
        if (arrivalTime < 0 || burstTime <= 0 || priority < 0) {
            throw new IllegalArgumentException("  ( ! Invalid process parameters ! )  ");
        }
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
        this.priority = priority;
    }
    public Process(String name, int arrivalTime, int burstTime) {
        this.name = name;
        if (arrivalTime < 0 || burstTime <= 0 || priority < 0) {
            throw new IllegalArgumentException("  ( ! Invalid process parameters ! )  ");
        }
        this.arrivalTime = arrivalTime;
        this.burstTime = burstTime;
    }
    
    // Implement Comparable interface to support priority-based sorting
    public int compareTo(Process other) {
        return Integer.compare(this.priority, other.getPriority());
    }
    // Getters and setters...
    public void setArrivalTime(int arrivalTime) {
        if (arrivalTime < 0) {
            throw new IllegalArgumentException("Invalid arrival time");
        }
        this.arrivalTime = arrivalTime;
    }
    public void setBurstTime(int burstTime) {
        if (burstTime <= 0) {
            throw new IllegalArgumentException("Invalid burst time");
        }
        this.burstTime = burstTime;
    }
    public void setPriority(int priority) {
        if (priority < 0) {
            throw new IllegalArgumentException("Invalid priority");
        }
        this.priority = priority;
    }
    public int getPriority() {
        return this.priority;
    }
    public String getName() {
        return this.name;
    }
    public int getArrivalTime() {
        return this.arrivalTime;
    }
    public int getBurstTime() {
        return this.burstTime;
    }
}
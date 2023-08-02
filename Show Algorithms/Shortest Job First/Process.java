public class Process {
    private int pidProcess;
    private int arrivalTime;
    private int burstTime;
    private int completionTime;
    private int waitingTime;
    private int turnaroundTime;
    
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
    public int getWaitingTime() {
        return completionTime - arrivalTime - burstTime;
    }
    public int getCompletionTime() {
        return arrivalTime + burstTime + waitingTime;
    }
    public int getTurnaroundTime() {
        return this.turnaroundTime;
    }
}
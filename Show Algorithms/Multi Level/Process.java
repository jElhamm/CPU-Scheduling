public class Process {
    private String name;
    private int priority;
    private int burstTime;

    public Process(String inputName, int inputPriority, int inputBurstTime) {
        this.name = inputName;
        this.priority = inputPriority;
        this.burstTime = inputBurstTime;
    }

    public void setBurstTime(int inputBurstTime) {
        this.burstTime = inputBurstTime;
    }
    public String getName() {
        return name;
    }
    public int getPriority() {
        return priority;
    }
    public int getBurstTime() {
        return burstTime;
    }
}

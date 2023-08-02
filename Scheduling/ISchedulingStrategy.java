import java.util.List;

public interface ISchedulingStrategy {
    void schedule(List<Process> processes);
}
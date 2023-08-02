public class App 
{
    public static void main( String[] args )
    {
        multiLeve_scheduling scheduler = new multiLeve_scheduling();
        scheduler.addProcess(new Process("P1", 2, 5));
        scheduler.addProcess(new Process("P2", 8, 3));
        scheduler.addProcess(new Process("P3", 5, 4));
        scheduler.addProcess(new Process("P4", 1, 2));
        scheduler.runScheduler();
        System.out.println("----------------------------------------------------");
    }
}

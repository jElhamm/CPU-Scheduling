# Strategy Design Pattern

   The Strategy design pattern is a behavioral design pattern that allows you to define a family of algorithms, encapsulate each one as an object, and make them interchangeable at runtime. 
   It lets the algorithm vary independently from clients that use it.

## Intent

The Strategy design pattern provides a way to select the algorithm or behavior of an object dynamically at runtime. It defines a set of algorithms/strategies that can be used interchangeably by client objects. The selection of a specific strategy is determined by the client based on its needs.

## Structure

The main components of the Strategy design pattern are:

   * Context: It represents the object that uses a strategy. It maintains a reference to the current strategy object and delegates the execution of the algorithm to the strategy.
   * Strategy: It defines the interface or abstract base class for all the concrete strategies. It declares the common method(s) that should be implemented by each strategy.
   * Concrete Strategies: These are the concrete implementations of the strategy interface. Each concrete strategy implements the algorithm(s) defined in the strategy interface.

## Benefits

   * Provides a flexible alternative to subclassing: Instead of defining multiple subclasses to handle different variations of an algorithm, the Strategy pattern allows you to encapsulate each variation as  a separate strategy object. This reduces the need for subclass proliferation.
   * Allows the algorithm to vary independently: By encapsulating the algorithm in a strategy object, you can easily swap one strategy with another at runtime without affecting the client code.
   * Promotes single responsibility: Each strategy encapsulates a specific algorithm, promoting separation of concerns and making the code easier to understand and maintain.
   * Supports open/closed principle: Adding new strategies does not require changing the existing code, making it easy to extend the system with new behaviors.

## Usage

The Strategy design pattern is commonly used in scenarios where you have a set of related algorithms or behaviors that need to be dynamically selected at runtime.

## Example Explanation

The provided code implements a CPU Scheduler program using the Strategy design pattern. It allows the user to select different scheduling algorithms (SJF, FCFS, Priority, Round Robin, Multi-Level) for executing a list of processes. The CPUScheduler class acts as the context and maintains a reference to the current scheduling strategy object. The ISchedulingStrategy interface defines the common method schedule() that is implemented by each concrete strategy (SJFSchedulingStrategy, FCFSSchedulingStrategy, etc.). The client code (in the Main class) selects the desired strategy based on user input and executes the processes using the chosen algorithm.
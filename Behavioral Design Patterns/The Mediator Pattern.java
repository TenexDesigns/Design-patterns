The Mediator Pattern is a behavioral design pattern that promotes loose coupling between a set of interacting objects by centralizing their communication through a mediator object. It helps to reduce the direct dependencies between components, making the system more maintainable and flexible. The mediator acts as a coordinator, managing the interactions and communication between the objects.

**Key Concepts:**

1. **Mediator:** An interface or class that defines the communication protocol and methods for components to interact with each other.

2. **Concrete Mediator:** An implementation of the mediator interface that manages the interactions and keeps track of the components.

3. **Colleague:** Objects that communicate through the mediator rather than directly with each other. They are unaware of each other's existence.

**Example of Mediator Pattern:**

Let's consider an example of an air traffic control system. Airplanes need to communicate with each other to avoid collisions, but they shouldn't directly communicate. Instead, they communicate through the air traffic control (ATC) system, which acts as the mediator.

```java
// Mediator
interface ATCMediator {
    void registerAirplane(Airplane airplane);
    void sendMessage(String message, Airplane sender);
}

// Concrete Mediator
class ConcreteATCMediator implements ATCMediator {
    private List<Airplane> airplanes = new ArrayList<>();

    public void registerAirplane(Airplane airplane) {
        airplanes.add(airplane);
    }

    public void sendMessage(String message, Airplane sender) {
        for (Airplane airplane : airplanes) {
            if (airplane != sender) {
                airplane.receiveMessage(message);
            }
        }
    }
}

// Colleague
class Airplane {
    private ATCMediator mediator;
    private String name;

    public Airplane(ATCMediator mediator, String name) {
        this.mediator = mediator;
        this.name = name;
        mediator.registerAirplane(this);
    }

    public void sendMessage(String message) {
        mediator.sendMessage(message, this);
    }

    public void receiveMessage(String message) {
        System.out.println(name + " received: " + message);
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        ATCMediator mediator = new ConcreteATCMediator();
        Airplane airplane1 = new Airplane(mediator, "Flight 1");
        Airplane airplane2 = new Airplane(mediator, "Flight 2");

        airplane1.sendMessage("Flight 2, please adjust your altitude.");
        airplane2.sendMessage("Copy that. Adjusting altitude.");
    }
}
```

In this example, the `ATCMediator` interface defines the methods for registering airplanes and sending messages. The `ConcreteATCMediator` implements these methods and keeps track of registered airplanes. The `Airplane` class communicates through the mediator rather than directly with each other.

The Mediator Pattern is useful in scenarios where multiple objects need to communicate with each other but maintaining direct connections between them would lead to a complex and tightly coupled system. It centralizes the communication logic, making it easier to manage and maintain.





--------------------------------------------------------------------------------------------------------------------


  # The Mediator Pattern in Java

## Introduction

The Mediator pattern is a behavioral design pattern that reduces coupling between components of a program by making them communicate indirectly, through a special mediator object. It defines an object that encapsulates how a set of objects interact [Source 0](https://www.baeldung.com/java-mediator-pattern), [Source 10](https://en.wikipedia.org/wiki/Mediator_pattern).

This pattern promotes loose coupling by keeping objects from referring to each other explicitly, and it lets you vary their interaction independently. This can help in situations where multiple objects need to interact with each other to process a request, but direct communication may create a complex system [Source 4](https://howtodoinjava.com/design-patterns/behavioral/mediator-pattern/).

## Implementation

To implement the Mediator pattern in Java, you typically create an interface for the mediator and concrete classes for the objects that will communicate through the mediator.

Here is a simple example of implementing the Mediator pattern in Java:

```java
public interface Mediator {
    void sendMessage(String message, Colleague colleague);
    void addColleague(Colleague colleague);
}

public abstract class Colleague {
    protected Mediator mediator;

    public Colleague(Mediator m) {
        mediator = m;
    }

    public abstract void send(String message);
    public abstract void receive(String message);
}

public class ConcreteColleagueA extends Colleague {
    public ConcreteColleagueA(Mediator m) {
        super(m);
    }

    public void send(String message) {
        mediator.sendMessage(message, this);
    }

    public void receive(String message) {
        System.out.println("ColleagueA received: " + message);
    }
}
```

In this example, `Mediator` is the mediator interface, `Colleague` is the abstract class for the objects that will communicate through the mediator, and `ConcreteColleagueA` is a concrete colleague class [Source 2](https://www.digitalocean.com/community/tutorials/mediator-design-pattern-java).

## Usage

The Mediator pattern is useful when the communication logic between objects is complex, as it provides a central point of communication that takes care of communication logic. It can also help reduce coupling between various components of a program [Source 2](https://www.digitalocean.com/community/tutorials/mediator-design-pattern-java).

However, if the number of mediators grows, it could become hard to maintain them. As such, the Mediator pattern should not be used just to achieve loose coupling [Source 2](https://www.digitalocean.com/community/tutorials/mediator-design-pattern-java). 

A real-world example of the Mediator pattern is an air traffic control room, where the control room works as a mediator for communication between different flights. Another example is a chat application, where a hub where all participants connect serves as the mediator [Source 4](https://howtodoinjava.com/design-patterns/behavioral/mediator-pattern/).

In conclusion, the Mediator pattern is a useful tool for reducing coupling and managing complex interactions between objects. However, it should be used judiciously, keeping in mind the potential for increased complexity in the mediator itself [Source 0](https://www.baeldung.com/java-mediator-pattern).
                                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                               
                                                                                                                                                                                                                                                               



















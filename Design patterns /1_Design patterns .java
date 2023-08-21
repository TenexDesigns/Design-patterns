Design patterns in software engineering are general, reusable solutions to commonly occurring problems within a specific context in software design. They represent a template for how to solve a problem that can be used in many different situations. Design patterns are formalized best practices that a programmer can use to solve common problems when designing an application or system [Source 0](https://en.wikipedia.org/wiki/Software_design_pattern).

Design patterns are typically divided into three types:

1. **Creational patterns**: These patterns deal with object creation mechanisms, trying to create objects in a manner suitable to the situation.

2. **Structural patterns**: These patterns deal with object composition or the structure of classes. They help ensure that when one part of a system changes, the entire structure of the system doesn't need to change.

3. **Behavioral patterns**: These patterns deal with communication between objects, how objects interact, and distribute work. They focus on the interaction between objects and how they cooperate to perform a task [Source 1](https://www.freecodecamp.org/news/the-basic-design-patterns-all-developers-need-to-know/).

Here are a few examples of these design patterns in Java:

**Singleton Pattern (Creational)**: This pattern restricts the instantiation of a class and ensures that only one instance of the class exists in the Java virtual machine.

```java
public class Singleton {
   private static Singleton instance = new Singleton();

   //make the constructor private so that this class cannot be instantiated
   private Singleton(){}

   //Get the only object available
   public static Singleton getInstance(){
      return instance;
   }

   public void showMessage(){
      System.out.println("Hello World!");
   }
}
```

**Adapter Pattern (Structural)**: This pattern works as a bridge between two incompatible interfaces. It involves a single class called adapter which is responsible for communication between two independent or incompatible interfaces.

```java
// Existing way requests are implemented
class OldRequest {
   public void request() {
      System.out.println("Old Request, don't change me!");
   }
}

// New standard for requests
interface NewRequest {
   public void request();
}

// adapter wrapper
class Adapter implements NewRequest {
   private OldRequest adaptee;

   public Adapter(OldRequest adaptee) {
      this.adaptee = adaptee;
   }

   public void request() {
      adaptee.request();
   }
}
```

**Observer Pattern (Behavioral)**: This pattern is used when there is one-to-many relationship between objects such as if one object is modified, its dependent objects are to be notified automatically.

```java
public class Subject {
   private List<Observer> observers = new ArrayList<Observer>();
   private int state;

   public int getState() {
      return state;
   }

   public void setState(int state) {
      this.state = state;
      notifyAllObservers();
   }

   public void attach(Observer observer){
      observers.add(observer);       
   }

   public void notifyAllObservers(){
      for (Observer observer : observers) {
         observer.update();
      }
   }    
}
```

Design patterns can speed up the development process by providing tested, proven development paradigms. Reusing design patterns helps to prevent subtle issues that can cause major problems, and it improves code readability for coders and architects familiar with the patterns [Source 0](https://en.wikipedia.org/wiki/Software_design_pattern). However, they are not a silver bullet and should be used only when they fit the problem at hand. Misuse of design patterns can result in unnecessary complexity and poor performance.





Design patterns can be complex, but they are a great tool for solving common programming problems. Here are a few more examples in Java:

**Prototype Pattern (Creational)**: This pattern is used when the type of objects to create is determined by a prototypical instance, which is cloned to produce new objects.

```java
public class Prototype implements Cloneable {
    public Prototype clone() {
        try {
            return (Prototype) super.clone();
        } catch (CloneNotSupportedException e) {
            return null;
        }
    }
}
```

In the above example, the Prototype class implements the Cloneable interface, and overrides the clone() method from the Object class. This makes it possible to create new objects by cloning the Prototype instance [Source 10](https://www.baeldung.com/java-pattern-prototype).

**Strategy Pattern (Behavioral)**: This pattern is used when a class behavior or its algorithm can be changed at run time.

```java
interface Strategy {
    int doOperation(int num1, int num2);
}

class OperationAdd implements Strategy {
    public int doOperation(int num1, int num2) {
        return num1 + num2;
    }
}

class Context {
    private Strategy strategy;

    public Context(Strategy strategy){
        this.strategy = strategy;
    }

    public int executeStrategy(int num1, int num2){
        return strategy.doOperation(num1, num2);
    }
}
```

In the code above, we define a Strategy interface with a method doOperation(). We then create a concrete class implementing the Strategy interface. A Context class is defined which uses a Strategy [Source 11](https://www.digitalocean.com/community/tutorials/strategy-design-pattern-in-java-example-tutorial).

**Flyweight Pattern (Structural)**: This pattern is used to reduce the number of objects created and to decrease memory footprint and increase performance.

```java
class Coffee {
    private final String flavor;

    public Coffee(String flavor) {
        this.flavor = flavor;
    }

    public String getFlavor() {
        return this.flavor;
    }
}

class CoffeeFactory {
    private Map<String, Coffee> flavors = new HashMap<>();

    public Coffee getCoffeeFlavor(String flavor) {
        Coffee coffee = flavors.get(flavor);
        if (coffee == null) {
            coffee = new Coffee(flavor);
            flavors.put(flavor, coffee);
        }
        return coffee;
    }

    public int getTotalCoffeeFlavorsMade() {
        return flavors.size();
    }
}
```

In the example above, a Coffee object is created only if it doesn't already exist in the CoffeeFactory's flavors map. If it does exist, the Coffee object in the map is returned. This reduces the number of Coffee objects that need to be created [Source 0](https://www.digitalocean.com/community/tutorials/java-design-patterns-example-tutorial).

These are just a few examples of design patterns in Java. Each pattern has its own strengths and weaknesses, and the choice of which pattern to use depends on the specific requirements of the software being developed. These patterns can provide a powerful toolkit for software developers, allowing them to solve common problems in a robust and efficient manner [Source 5](https://www.freecodecamp.org/news/the-basic-design-patterns-all-developers-need-to-know/).
                                                                                                                                                                                                                                                                                                                                                                                    
 There are many design patterns in software engineering. Here are additional examples:

**Factory Pattern (Creational)**: This pattern provides a way to encapsulate a group of individual factories that have a common theme without specifying their concrete classes.

```java
public interface Animal {
    void speak();
}

public class Dog implements Animal {
    public void speak() {
        System.out.println("Woof!");
    }
}

public class Cat implements Animal {
    public void speak() {
        System.out.println("Meow!");
    }
}

public class AnimalFactory {
    public Animal getAnimal(String type) {
        if ("Dog".equalsIgnoreCase(type)) {
            return new Dog();
        } else if ("Cat".equalsIgnoreCase(type)) {
            return new Cat();
        }
        return null;
    }
}
```

In the code above, `AnimalFactory` is a factory class that creates and returns instances of various types of `Animal` [Source 2](https://www.baeldung.com/java-creational-design-patterns).

**Chain of Responsibility Pattern (Behavioral)**: This pattern creates a chain of receiver objects for a request. This pattern decouples sender and receiver of a request based on type of request.

```java
public interface Handler {
    void setNext(Handler handler);
    void handleRequest(String request);
}

public class ConcreteHandler1 implements Handler {
    private Handler next;

    @Override
    public void setNext(Handler handler) {
        this.next = handler;
    }

    @Override
    public void handleRequest(String request) {
        if ("request1".equals(request)) {
            System.out.println("ConcreteHandler1 handling request1");
        } else if (next != null) {
            next.handleRequest(request);
        }
    }
}
```

In the code above, `ConcreteHandler1` is a handler that can handle a request or pass it to the next handler in the chain [Source 3](https://stackoverflow.com/questions/1673841/examples-of-gof-design-patterns-in-javas-core-libraries).

**Facade Pattern (Structural)**: This pattern hides the complexities of the system and provides an interface to the client from where the client can access the system.

```java
public class Facade {
    private final Subsystem1 subsystem1;
    private final Subsystem2 subsystem2;

    public Facade(Subsystem1 subsystem1, Subsystem2 subsystem2) {
        this.subsystem1 = subsystem1;
        this.subsystem2 = subsystem2;
    }

    public void operation()                                                                                                                                                                                                                                                                                                                                                                                   
                                                                                                                                                                                                                                                                                                                      
                                                                                                                                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                                                                                                                    
                                                                                                                                                                                                                                                                                                                                                                                    


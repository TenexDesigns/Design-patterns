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

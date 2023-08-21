Certainly, here are a few more design patterns along with code samples in Java:

**13. Chain of Responsibility Pattern:**
This pattern creates a chain of handler objects, where each handler is responsible for processing a specific kind of request.

```java
abstract class Handler {
    private Handler successor;

    void setSuccessor(Handler successor) {
        this.successor = successor;
    }

    abstract void handleRequest(int request);
}

class ConcreteHandlerA extends Handler {
    void handleRequest(int request) {
        if (request < 10) {
            System.out.println("Handled by ConcreteHandlerA");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

class ConcreteHandlerB extends Handler {
    void handleRequest(int request) {
        if (request >= 10 && request < 20) {
            System.out.println("Handled by ConcreteHandlerB");
        } else if (successor != null) {
            successor.handleRequest(request);
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Handler handlerA = new ConcreteHandlerA();
        Handler handlerB = new ConcreteHandlerB();

        handlerA.setSuccessor(handlerB);

        handlerA.handleRequest(5);  // Output: Handled by ConcreteHandlerA
        handlerA.handleRequest(15); // Output: Handled by ConcreteHandlerB
        handlerA.handleRequest(25); // No handler can handle this request
    }
}
```

**14. Interpreter Pattern:**
This pattern defines a grammar for interpreting sentences in a language and provides an interpreter for the language.

```java
interface Expression {
    boolean interpret(String context);
}

class TerminalExpression implements Expression {
    private String data;

    TerminalExpression(String data) {
        this.data = data;
    }

    public boolean interpret(String context) {
        return context.contains(data);
    }
}

class OrExpression implements Expression {
    private Expression expr1;
    private Expression expr2;

    OrExpression(Expression expr1, Expression expr2) {
        this.expr1 = expr1;
        this.expr2 = expr2;
    }

    public boolean interpret(String context) {
        return expr1.interpret(context) || expr2.interpret(context);
    }
}

public class Main {
    public static void main(String[] args) {
        Expression robert = new TerminalExpression("Robert");
        Expression john = new TerminalExpression("John");
        Expression orExpression = new OrExpression(robert, john);

        System.out.println("John is a friend: " + orExpression.interpret("John"));
        System.out.println("Julie is a friend: " + orExpression.interpret("Julie"));
    }
}
```

**15. Iterator Pattern:**
This pattern provides a way to access the elements of a collection sequentially without exposing its underlying representation.

```java
import java.util.ArrayList;
import java.util.List;

interface Iterator<T> {
    boolean hasNext();
    T next();
}

class ConcreteIterator<T> implements Iterator<T> {
    private List<T> elements;
    private int position = 0;

    ConcreteIterator(List<T> elements) {
        this.elements = elements;
    }

    public boolean hasNext() {
        return position < elements.size();
    }

    public T next() {
        if (hasNext()) {
            T element = elements.get(position);
            position++;
            return element;
        }
        return null;
    }
}

public class Main {
    public static void main(String[] args) {
        List<String> names = new ArrayList<>();
        names.add("Alice");
        names.add("Bob");
        names.add("Charlie");

        Iterator<String> iterator = new ConcreteIterator<>(names);
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }
}
```

These additional examples showcase the Chain of Responsibility, Interpreter, and Iterator patterns. Each pattern addresses specific design challenges and contributes to code organization and maintainability.




Certainly, here are a few more design patterns along with code samples in Java:

**16. Command Pattern:**
This pattern turns a request into a stand-alone object that contains all information about the request. It decouples sender and receiver of a request.

```java
interface Command {
    void execute();
}

class Light {
    void turnOn() {
        System.out.println("Light is on");
    }

    void turnOff() {
        System.out.println("Light is off");
    }
}

class LightOnCommand implements Command {
    private Light light;

    LightOnCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOn();
    }
}

class LightOffCommand implements Command {
    private Light light;

    LightOffCommand(Light light) {
        this.light = light;
    }

    public void execute() {
        light.turnOff();
    }
}

class RemoteControl {
    private Command command;

    void setCommand(Command command) {
        this.command = command;
    }

    void pressButton() {
        command.execute();
    }
}

public class Main {
    public static void main(String[] args) {
        Light light = new Light();
        Command lightOn = new LightOnCommand(light);
        Command lightOff = new LightOffCommand(light);

        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setCommand(lightOn);
        remoteControl.pressButton();  // Output: Light is on

        remoteControl.setCommand(lightOff);
        remoteControl.pressButton();  // Output: Light is off
    }
}
```

**17. Visitor Pattern:**
This pattern separates the algorithm from the object structure on which it operates. It allows you to add new operations to existing object structures without modifying those structures.

```java
interface Visitor {
    void visit(Element element);
}

class ConcreteVisitor implements Visitor {
    public void visit(Element element) {
        System.out.println("ConcreteVisitor visited " + element);
    }
}

interface Element {
    void accept(Visitor visitor);
}

class ConcreteElement implements Element {
    public void accept(Visitor visitor) {
        visitor.visit(this);
    }
}

public class Main {
    public static void main(String[] args) {
        Visitor visitor = new ConcreteVisitor();
        Element element = new ConcreteElement();
        element.accept(visitor);  // Output: ConcreteVisitor visited ConcreteElement@hashcode
    }
}
```

**18. Memento Pattern:**
This pattern allows an object's state to be saved externally so that it can be restored to that state later. It's useful for implementing undo mechanisms and managing snapshots of an object's state.

```java
class Memento {
    private String state;

    Memento(String state) {
        this.state = state;
    }

    String getState() {
        return state;
    }
}

class Originator {
    private String state;

    void setState(String state) {
        this.state = state;
    }

    Memento saveStateToMemento() {
        return new Memento(state);
    }

    void restoreStateFromMemento(Memento memento) {
        state = memento.getState();
    }
}

class Caretaker {
    private Memento memento;

    Memento getMemento() {
        return memento;
    }

    void setMemento(Memento memento) {
        this.memento = memento;
    }
}

public class Main {
    public static void main(String[] args) {
        Originator originator = new Originator();
        Caretaker caretaker = new Caretaker();

        originator.setState("State 1");
        caretaker.setMemento(originator.saveStateToMemento());

        originator.setState("State 2");
        System.out.println("Current State: " + originator.getState());

        originator.restoreStateFromMemento(caretaker.getMemento());
        System.out.println("Restored State: " + originator.getState());
    }
}
```

These examples demonstrate the Command, Visitor, and Memento patterns. Each pattern serves a unique purpose in improving code structure and maintaining flexibility.







Certainly, here are a few more design patterns along with code samples in Java:

**19. State Pattern:**
This pattern allows an object to change its behavior when its internal state changes. It encapsulates different behaviors in separate classes and allows the object to switch between these behaviors based on its state.

```java
interface State {
    void doAction(Context context);
}

class StateA implements State {
    public void doAction(Context context) {
        System.out.println("State A");
        context.setState(new StateB());
    }
}

class StateB implements State {
    public void doAction(Context context) {
        System.out.println("State B");
        context.setState(new StateA());
    }
}

class Context {
    private State state;

    Context() {
        state = new StateA();
    }

    void setState(State state) {
        this.state = state;
    }

    void doAction() {
        state.doAction(this);
    }
}

public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        context.doAction();  // Output: State A
        context.doAction();  // Output: State B
        context.doAction();  // Output: State A
    }
}
```

**20. Strategy Pattern:**
This pattern defines a family of interchangeable algorithms or behaviors and allows a client to choose one of them at runtime. It helps achieve a higher level of flexibility by encapsulating these algorithms separately from the client code.

```java
interface Strategy {
    int execute(int a, int b);
}

class AddStrategy implements Strategy {
    public int execute(int a, int b) {
        return a + b;
    }
}

class SubtractStrategy implements Strategy {
    public int execute(int a, int b) {
        return a - b;
    }
}

class Context {
    private Strategy strategy;

    void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    int executeStrategy(int a, int b) {
        return strategy.execute(a, b);
    }
}

public class Main {
    public static void main(String[] args) {
        Context context = new Context();

        context.setStrategy(new AddStrategy());
        System.out.println("Addition: " + context.executeStrategy(5, 3));  // Output: Addition: 8

        context.setStrategy(new SubtractStrategy());
        System.out.println("Subtraction: " + context.executeStrategy(5, 3));  // Output: Subtraction: 2
    }
}
```

**21. Observer Pattern (Java's Built-in):**
Java has a built-in Observer Pattern implementation using the `java.util.Observable` class and `java.util.Observer` interface.

```java
import java.util.Observable;
import java.util.Observer;

class ConcreteObserver implements Observer {
    public void update(Observable o, Object arg) {
        System.out.println("Updated: " + arg);
    }
}

public class Main {
    public static void main(String[] args) {
        Observable observable = new Observable();
        Observer observer = new ConcreteObserver();
        observable.addObserver(observer);

        observable.setChanged();
        observable.notifyObservers("Something has changed");
    }
}
```

**22. Proxy Pattern (Java's Built-in):**
Java also has a built-in Proxy Pattern implementation using the `java.lang.reflect.Proxy` class and `java.lang.reflect.InvocationHandler` interface.

```java
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

interface Subject {
    void doAction();
}

class RealSubject implements Subject {
    public void doAction() {
        System.out.println("RealSubject: Performing action");
    }
}

class ProxyHandler implements InvocationHandler {
    private Object realSubject;

    ProxyHandler(Object realSubject) {
        this.realSubject = realSubject;
    }

    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("Proxy: Before action");
        Object result = method.invoke(realSubject, args);
        System.out.println("Proxy: After action");
        return result;
    }
}

public class Main {
    public static void main(String[] args) {
        RealSubject realSubject = new RealSubject();
        ProxyHandler proxyHandler = new ProxyHandler(realSubject);

        Subject proxySubject = (Subject) Proxy.newProxyInstance(
            Subject.class.getClassLoader(),
            new Class[] { Subject.class },
            proxyHandler
        );

        proxySubject.doAction();
    }
}
```

These examples showcase the State, Strategy, and built-in Observer and Proxy patterns in Java. Each pattern has its unique use cases and advantages in improving software design and architecture.





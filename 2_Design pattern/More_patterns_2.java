Sure, here are a few more design patterns along with code samples in Java:

**4. Singleton Pattern:**
Ensures a class has only one instance and provides a global point of access to that instance.

```java
public class Singleton {
    private static Singleton instance;

    private Singleton() {
        // Private constructor to prevent instantiation
    }

    public static Singleton getInstance() {
        if (instance == null) {
            instance = new Singleton();
        }
        return instance;
    }

    public void showMessage() {
        System.out.println("Hello from Singleton!");
    }

    public static void main(String[] args) {
        Singleton singleton = Singleton.getInstance();
        singleton.showMessage();  // Output: Hello from Singleton!
    }
}
```

**5. Proxy Pattern:**
Provides a surrogate or placeholder for another object to control access to it.

```java
interface Image {
    void display();
}

class RealImage implements Image {
    private String filename;

    RealImage(String filename) {
        this.filename = filename;
        loadFromDisk();
    }

    private void loadFromDisk() {
        System.out.println("Loading " + filename);
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }
}

class ProxyImage implements Image {
    private RealImage realImage;
    private String filename;

    ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) {
            realImage = new RealImage(filename);
        }
        realImage.display();
    }
}

public class Main {
    public static void main(String[] args) {
        Image image = new ProxyImage("image.jpg");
        image.display();
    }
}
```

**6. Command Pattern:**
Turns a request into a stand-alone object that contains all information about the request.

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

These additional examples showcase the Singleton, Proxy, and Command patterns. Each pattern addresses specific design concerns and helps in achieving modular, maintainable, and flexible code.







Certainly, here are a few more design patterns along with code samples in Java:

**7. Decorator Pattern:**
Allows behavior to be added to individual objects, either statically or dynamically, without affecting the behavior of other objects from the same class.

```java
interface Coffee {
    String getDescription();
    double cost();
}

class SimpleCoffee implements Coffee {
    public String getDescription() {
        return "Simple coffee";
    }

    public double cost() {
        return 2.0;
    }
}

class MilkDecorator implements Coffee {
    private Coffee coffee;

    MilkDecorator(Coffee coffee) {
        this.coffee = coffee;
    }

    public String getDescription() {
        return coffee.getDescription() + ", milk";
    }

    public double cost() {
        return coffee.cost() + 0.5;
    }
}

public class Main {
    public static void main(String[] args) {
        Coffee simpleCoffee = new SimpleCoffee();
        System.out.println("Simple Coffee: " + simpleCoffee.getDescription() + ", Cost: " + simpleCoffee.cost());

        Coffee milkCoffee = new MilkDecorator(new SimpleCoffee());
        System.out.println("Milk Coffee: " + milkCoffee.getDescription() + ", Cost: " + milkCoffee.cost());
    }
}
```

**8. Composite Pattern:**
Composes objects into tree structures to represent part-whole hierarchies.

```java
import java.util.ArrayList;
import java.util.List;

interface Component {
    void operation();
}

class Leaf implements Component {
    public void operation() {
        System.out.println("Leaf operation");
    }
}

class Composite implements Component {
    private List<Component> components = new ArrayList<>();

    void add(Component component) {
        components.add(component);
    }

    public void operation() {
        System.out.println("Composite operation");
        for (Component component : components) {
            component.operation();
        }
    }
}

public class Main {
    public static void main(String[] args) {
        Component leaf = new Leaf();
        Component composite = new Composite();
        composite.add(leaf);

        composite.operation();
    }
}
```

**9. Template Method Pattern:**
Defines the structure of an algorithm but allows subclasses to provide implementations for certain steps.

```java
abstract class Template {
    void templateMethod() {
        step1();
        step2();
    }

    abstract void step1();
    abstract void step2();
}

class ConcreteTemplate extends Template {
    void step1() {
        System.out.println("ConcreteTemplate Step 1");
    }

    void step2() {
        System.out.println("ConcreteTemplate Step 2");
    }
}

public class Main {
    public static void main(String[] args) {
        Template template = new ConcreteTemplate();
        template.templateMethod();
    }
}
```

These additional examples showcase the Decorator, Composite, and Template Method patterns. Each pattern has its own distinct purpose and benefits in terms of code structure and flexibility.















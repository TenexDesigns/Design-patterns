The Command Pattern is a behavioral design pattern that turns a request or simple operation into a stand-alone object. This allows you to parameterize objects with operations, delay execution, queue requests, and log them. It also provides a way to decouple sender and receiver, which is useful in scenarios where multiple actions need to be performed in response to a single command.

**Key Concepts:**

1. **Command:** An interface or abstract class that declares an `execute()` method. Concrete command classes implement this method, encapsulating the action to be performed.

2. **Receiver:** The object that performs the actual action associated with a command. It's not aware of the command's details.

3. **Invoker:** The object that holds the command and triggers its execution. It can manage a queue of commands.

**Example of Command Pattern:**

Let's consider a simple example of a remote control for a TV. The remote control has buttons for turning the TV on, off, and changing the channel. Here's how the Command Pattern can be applied:

```java
// Command (Interface)
interface Command {
    void execute();
}

// Concrete Commands
class TurnOnCommand implements Command {
    private TV tv;

    public TurnOnCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOn();
    }
}

class TurnOffCommand implements Command {
    private TV tv;

    public TurnOffCommand(TV tv) {
        this.tv = tv;
    }

    public void execute() {
        tv.turnOff();
    }
}

class ChangeChannelCommand implements Command {
    private TV tv;
    private int newChannel;

    public ChangeChannelCommand(TV tv, int newChannel) {
        this.tv = tv;
        this.newChannel = newChannel;
    }

    public void execute() {
        tv.changeChannel(newChannel);
    }
}

// Receiver
class TV {
    public void turnOn() {
        System.out.println("TV is turned on");
    }

    public void turnOff() {
        System.out.println("TV is turned off");
    }

    public void changeChannel(int newChannel) {
        System.out.println("Channel changed to " + newChannel);
    }
}

// Invoker
class RemoteControl {
    private Command command;

    public void setCommand(Command command) {
        this.command = command;
    }

    public void pressButton() {
        command.execute();
    }
}

// Client Code
public class Client {
    public static void main(String[] args) {
        TV tv = new TV();
        Command turnOn = new TurnOnCommand(tv);
        Command turnOff = new TurnOffCommand(tv);
        Command changeChannel = new ChangeChannelCommand(tv, 5);

        RemoteControl remote = new RemoteControl();

        remote.setCommand(turnOn);
        remote.pressButton();

        remote.setCommand(changeChannel);
        remote.pressButton();

        remote.setCommand(turnOff);
        remote.pressButton();
    }
}
```

In this example, the Command Pattern allows you to encapsulate the actions (turning the TV on, off, changing the channel) as command objects. The remote control (`Invoker`) can be configured with different commands, and when the user presses a button, the corresponding command is executed, without the remote control needing to know the details of the actions or the TV.

The Command Pattern is useful when you want to decouple objects that send requests from objects that perform the actions. It's commonly used in scenarios like GUI applications, undo-redo functionality, and queuing tasks for background processing.






  

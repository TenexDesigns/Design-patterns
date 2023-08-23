# Builder Pattern in Java

## Introduction

The Builder pattern is a creational design pattern that allows for the step-by-step creation of complex objects using the correct sequence of actions. The construction is controlled by a director object that only needs to know the type of object it is to create [Source 11](https://refactoring.guru/design-patterns/builder/java/example).

This pattern is especially useful when you need to create an object with lots of possible configuration options. It provides a clear separation between the construction and representation of an object. It also allows for better control over the construction process and supports the construction of complex and composite objects [Source 2](https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java).

## Implementation

To implement the Builder pattern in Java, you would:

1. Create a static nested class (the builder) inside the class of the object that the builder will construct.
2. Provide the builder with a public constructor that takes the minimum required parameters to construct a valid object.
3. Add setter methods to the builder for all optional parameters. Each setter returns the builder itself, so that the setters can be chained.
4. Add a build method to the builder that returns a constructed object.

Here's a simple example:

```java
public class Computer {
    // required parameters
    private String HDD;
    private String RAM;

    // optional parameters
    private boolean isGraphicsCardEnabled;
    private boolean isBluetoothEnabled;

    private Computer(ComputerBuilder builder) {
        this.HDD = builder.HDD;
        this.RAM = builder.RAM;
        this.isGraphicsCardEnabled = builder.isGraphicsCardEnabled;
        this.isBluetoothEnabled = builder.isBluetoothEnabled;
    }

    // Builder Class
    public static class ComputerBuilder {
        // required parameters
        private String HDD;
        private String RAM;

        // optional parameters
        private boolean isGraphicsCardEnabled;
        private boolean isBluetoothEnabled;

        public ComputerBuilder(String HDD, String RAM) {
            this.HDD = HDD;
            this.RAM = RAM;
        }

        public ComputerBuilder setGraphicsCardEnabled(boolean isGraphicsCardEnabled) {
            this.isGraphicsCardEnabled = isGraphicsCardEnabled;
            return this;
        }

        public ComputerBuilder setBluetoothEnabled(boolean isBluetoothEnabled) {
            this.isBluetoothEnabled = isBluetoothEnabled;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}
```

In this example, `ComputerBuilder` is a static nested class inside `Computer`. It constructs a `Computer` object step-by-step [Source 2](https://www.digitalocean.com/community/tutorials/builder-design-pattern-in-java).

## Usage

The Builder pattern is commonly used in Java code, especially for classes that require many parameters to initialize. It's useful when you want to encapsulate the construction logic of a complex object, particularly when the object creation involves a specific sequence of steps that shouldn't be mixed [Source 4](https://howtodoinjava.com/design-patterns/creational/builder-pattern-in-java/).

The Builder pattern also promotes immutability, as the object is fully initialized when it's created and does not expose any setters. This can be particularly useful in multi-threaded environments where mutable objects can lead to issues [Source 3](https://www.edureka.co/blog/builder-design-pattern/).

However, the Builder pattern can lead to a lot of code duplication, as the setter methods in the Builder class are similar to the ones in the class it builds. Tools like Project Lombok can help reduce this boilerplate [Source 6](https://www.baeldung.com/lombok-builder).




The Strategy pattern is a behavioral design pattern that allows you to define a family of interchangeable algorithms or behaviors and make them interchangeable without altering the client code that uses them. This pattern is particularly useful when you want to provide different ways to accomplish a task and want to allow the client to choose the appropriate strategy dynamically.

Here's how the Strategy pattern works:

1. **Context**: This is the class that uses the strategy. It maintains a reference to the strategy object and delegates the task to the strategy.

2. **Strategy**: This is the interface or abstract class that defines the common interface for all concrete strategies. It declares the method(s) that represent the algorithms or behaviors.

3. **ConcreteStrategy**: These are the classes that implement the Strategy interface. Each concrete strategy provides a specific implementation of the algorithm or behavior.

Now, let's implement the Strategy pattern in Java:

```java
// Strategy interface
interface PaymentStrategy {
    void pay(int amount);
}

// ConcreteStrategy classes
class CreditCardPayment implements PaymentStrategy {
    private String cardNumber;
    private String name;

    public CreditCardPayment(String cardNumber, String name) {
        this.cardNumber = cardNumber;
        this.name = name;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using credit card " + cardNumber);
    }
}

class PayPalPayment implements PaymentStrategy {
    private String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    @Override
    public void pay(int amount) {
        System.out.println("Paid $" + amount + " using PayPal account " + email);
    }
}

// Context class
class ShoppingCart {
    private PaymentStrategy paymentStrategy;

    public void setPaymentStrategy(PaymentStrategy paymentStrategy) {
        this.paymentStrategy = paymentStrategy;
    }

    public void checkout(int amount) {
        if (paymentStrategy != null) {
            paymentStrategy.pay(amount);
        } else {
            System.out.println("No payment strategy set.");
        }
    }
}

// Example usage
public class Main {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();

        // Use credit card payment strategy
        cart.setPaymentStrategy(new CreditCardPayment("1234-5678-9012-3456", "John Doe"));
        cart.checkout(100);

        // Use PayPal payment strategy
        cart.setPaymentStrategy(new PayPalPayment("john.doe@example.com"));
        cart.checkout(50);
    }
}
```

In this example, we have the `PaymentStrategy` interface that defines the common payment method. The concrete strategy classes `CreditCardPayment` and `PayPalPayment` implement the payment behavior. The `ShoppingCart` class is the context that uses the payment strategy.

By setting different payment strategies in the `ShoppingCart`, the client code can choose the appropriate payment method dynamically without affecting the context or the client code that uses the context. This allows for more flexibility and easier addition of new payment methods in the future.


  







---------------------------------------------------------------------------------------------------------


The Strategy Pattern is a behavioral design pattern that allows you to define a family of algorithms, encapsulate each one as a separate class, and make them interchangeable at runtime. It enables the client to choose the algorithm dynamically without tightly coupling the client code to a specific implementation. This pattern promotes loose coupling, flexibility, and extensibility in your code [Source 0](https://www.baeldung.com/java-strategy-pattern), [Source 2](https://www.digitalocean.com/community/tutorials/strategy-design-pattern-in-java-example-tutorial).

Here's a step-by-step implementation of the Strategy Pattern in Java:

1. Define the Strategy interface:
```java
public interface PaymentStrategy {
    void pay(double amount);
}
```

2. Create concrete strategy classes that implement the Strategy interface:
```java
public class CreditCardStrategy implements PaymentStrategy {
    private String cardNumber;
    private String expirationDate;
    private String cvv;
    
    public CreditCardStrategy(String cardNumber, String expirationDate, String cvv) {
        this.cardNumber = cardNumber;
        this.expirationDate = expirationDate;
        this.cvv = cvv;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using credit card: " + cardNumber);
    }
}

public class PaypalStrategy implements PaymentStrategy {
    private String email;
    private String password;
    
    public PaypalStrategy(String email, String password) {
        this.email = email;
        this.password = password;
    }
    
    @Override
    public void pay(double amount) {
        System.out.println("Paying " + amount + " using PayPal account: " + email);
    }
}
```

3. Create a context class that uses the Strategy interface:
```java
public class ShoppingCart {
    private List<Item> items;
    
    public ShoppingCart() {
        this.items = new ArrayList<>();
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public void removeItem(Item item) {
        items.remove(item);
    }
    
    public double calculateTotal() {
        double total = 0;
        for (Item item : items) {
            total += item.getPrice();
        }
        return total;
    }
    
    public void pay(PaymentStrategy paymentStrategy) {
        double amount = calculateTotal();
        paymentStrategy.pay(amount);
    }
}
```

4. Use the Strategy pattern in the client code:
```java
public class StrategyPatternDemo {
    public static void main(String[] args) {
        ShoppingCart cart = new ShoppingCart();
        cart.addItem(new Item("Item 1", 10));
        cart.addItem(new Item("Item 2", 20));
        
        PaymentStrategy creditCardStrategy = new CreditCardStrategy("1234567890", "12/24", "123");
        cart.pay(creditCardStrategy);
        
        PaymentStrategy paypalStrategy = new PaypalStrategy("example@example.com", "password");
        cart.pay(paypalStrategy);
    }
}
```

In this example:

- The `PaymentStrategy` interface defines the common method `pay()` that all concrete strategies must implement.
- `CreditCardStrategy` and `PaypalStrategy` are concrete implementations of the `PaymentStrategy` interface.
- The `ShoppingCart` class represents the context and contains a list of items. It has methods to add, remove, calculate the total price of items, and perform the payment using the selected strategy.
- In the `StrategyPatternDemo` main method, we create a `ShoppingCart` object and add some items. We then create different payment strategies (`CreditCardStrategy` and `PaypalStrategy`) and pass them to the `pay()` method of the `ShoppingCart` object [Source 0](https://www.baeldung.com/java-strategy-pattern), [Source 2](https://www.digitalocean.com/community/tutorials/strategy-design-pattern-in-java-example-tutorial).

The Strategy Pattern is useful when you have a family of algorithms or behaviors that need to be dynamically selected at runtime. It allows you to encapsulate these algorithms into separate classes, making them interchangeable and easy to extend [Source 1](https://www.freecodecamp.org/news/the-strategy-pattern-explained-using-java-bc30542204e0/), [Source 5](https://www.developer.com/design/implementing-strategy-patterns-in-java/).



















  

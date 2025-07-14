# Research Work: "OOP is Dead"?

---

## Goal

To develop a deeper understanding of Object-Oriented Programming (OOP) by examining real-world perspectives—especially
its advantages, limitations, and alternatives. You will analyze examples from multiple languages (Java, C++, C, Python,
JavaScript), compare paradigms, and reflect on how and when OOP works best.

---

## Instructions

0. Team work!! This project is better suited for team work. Have each member work on a part of this. Everyone still
   needs to make your own submission.

1. **Watch the Talk (Required Start Point)**  
   Watch this talk:  
   ["OOP is Dead: Data-Oriented Design in Practice" by Stoyan Stefanov](https://youtu.be/yy8jQgmhbAU?si=n6rGwJcgMhE4NPF8)

2. **Understand Alternatives to OOP (New First Task)**  
   Before diving into examples, research the main **alternatives to object-oriented programming**, and briefly explain
   what each of them is:
    - **Procedural Programming**: Code is organized around procedures or routines. It focuses on step-by-step
      instructions and function calls (e.g., C).
    - **Functional Programming**: Emphasizes immutability, stateless functions, and higher-order functions (e.g.,
      Haskell, parts of JavaScript and Python).
    - **Data-Oriented Design (DOD)**: Focuses on organizing data for memory efficiency and performance, especially
      important in games and simulations. Logic is separated from data.

   Provide:
    - A short paragraph (~3–5 sentences) describing each paradigm.
    - A 5–10 line code snippet (in any language) showing what that style looks like.

3. **Do Guided Research**
    - Use **Google** and **ChatGPT** to research these two key questions:
        - When is OOP a *good* choice? Give at least 2 examples in **Java** and 1 each in **other languages** like C++,
          Python, or JavaScript.
        - When is OOP a *bad* choice? Again, give at least 2 Java examples and 1 in another language (C, JavaScript, or
          C++).
    - For each example, explain:
        - What the code is trying to do
        - Why OOP helped or hurt in this case
        - What alternative design might work better (e.g., procedural, functional, or data-oriented design)

4. **Code Snippets**
    - Include a **code snippet (10–20 lines)** for each example (good or bad).
    - Annotate the code with short comments explaining key points.

5. **Reflection**
    - Write a **short paragraph** (~150–200 words) answering:  
      "After doing this research, what do you think is the biggest misunderstanding students have about OOP?"
    - Reflect on what surprised you or challenged your assumptions.

---

## Submission Format

Answer the question below with the following sections:

# CSS 143 OOP Research Homework
## Name: Simon Espinar
## Section: CSS 143

---

Note: Research and code generation from Google Gemini

## 1. Alternatives to OOP
### Procedural Programming
In this method, programs are structured as a sequence of instructions or steps, organized into
procedures. It focuses on breaking down a programming task into a collection of variables and
routines that perform operations on these variables. Data and operations on that data are often
kept separate. Usually, the program is executed using a top-down approach in which functions are
called in a specific order to achieve a desired outcome. This paradigm is characterized by
explicit control flow, where the programmer defines the exact steps the program should take.

#### Example (using C): 

```
#include <stdio.h> // Standard input/output library

// Procedure (function) to calculate the area of a rectangle
float calculateRectangleArea(float length, float width) {
return length * width;
}

// Procedure (function) to display results
void displayArea(float area) {
printf("The calculated area is: %.2f\n", area);
}

// Main procedure where the program execution begins
int main() {
float rectLength = 10.5; // Data variable
float rectWidth = 5.0;   // Data variable
float area;              // Data variable

    // Step 1: Calculate the area by calling a procedure
    area = calculateRectangleArea(rectLength, rectWidth);

    // Step 2: Display the calculated area by calling another procedure
    displayArea(area);

    return 0; // Indicate successful execution
}
```
### Functional Programming
Functional programming is a paradigm that treats computation as the evaluation of mathematical
functions and avoids changing state and mutable data. It emphasizes immutability, meaning data,
once created, cannot be altered, and functions always produce the same output for the same input
(pure functions). Programs are constructed by composing functions, with a focus on "what to
compute" rather than "how to compute it." This approach often leads to more concise, predictable,
and easily testable code, especially in concurrent and parallel environments.

#### Example (using Python):

```
from functools import reduce

# Pure function: takes input, produces output, no side effects
def multiply(x, y):
    return x * y

# Pure function: squares a number
def square(x):
    return x * x

# Higher-order function: takes a function as an argument
def apply_function_to_list(func, data_list):
    return [func(item) for item in data_list] # Uses list comprehension (functional style)

# Main execution
if __name__ == "__main__":
    numbers = [1, 2, 3, 4, 5]

    # Use map (higher-order function) to apply 'square' to each element
    # Returns an iterator, convert to list for viewing
    squared_numbers = list(map(square, numbers))
    print(f"Squared numbers: {squared_numbers}") # Output: [1, 4, 9, 16, 25]

    # Use filter (higher-order function) to get even numbers
    even_numbers = list(filter(lambda x: x % 2 == 0, numbers))
    print(f"Even numbers: {even_numbers}")   # Output: [2, 4]

    # Use reduce (higher-order function) to multiply all elements
    product = reduce(multiply, numbers)
    print(f"Product of numbers: {product}") # Output: 120

    # Demonstrate our custom higher-order function
    doubled_numbers = apply_function_to_list(lambda x: x * 2, numbers)
    print(f"Doubled numbers (custom HOF): {doubled_numbers}") # Output: [2, 4, 6, 8, 10]
```

### Data-Oriented Design
Data-Oriented Design (DOD) is a programming approach that prioritizes the organization and
manipulation of data to maximize performance on modern computer hardware. Unlike paradigms that
focus on objects or procedures, DOD emphasizes how data is laid out in memory for efficient
processing by the CPU cache. It encourages arranging data in contiguous blocks (e.g., "structure
of arrays" instead of "array of structures") to reduce cache misses and improve throughput. The
core idea is to design your data first, considering its transformations, rather than designing
around abstract entities or behaviors.

```java
import java.util.Arrays; // Using arrays for more direct DOD feel

// Data: Immutable Position component
record Position(float x, float y) {}

// Data: Immutable Velocity component
record Velocity(float vx, float vy) {}

public class MinimalDodExample {
    public static void main(String[] args) {
        // Data storage (conceptual "Structure of Arrays")
        Position[] positions = { new Position(0, 0), new Position(5, 2) };
        Velocity[] velocities = { new Velocity(1, 0.5f), new Velocity(-0.5f, 1.2f) };
        float deltaTime = 0.1f;

        // Logic (a "system" operating on data)
        for (int i = 0; i < positions.length; i++) {
            Position oldPos = positions[i];
            Velocity vel = velocities[i];
            positions[i] = new Position(oldPos.x() + vel.vx() * deltaTime,
                                        oldPos.y() + vel.vy() * deltaTime);
        }

        // Output (demonstrates updated data)
        System.out.println(Arrays.toString(positions));
    }
}
```

---

## 2. Good Uses of OOP
### Java Example 1: Abstraction/Inheritance/Polymorphism
Explanation: Inheritance allows new classes (subclasses/child classes) to derive properties and behaviors from
existing classes (superclasses/parent classes). This promotes the "Don't Repeat Yourself" (DRY) principle, reducing code duplication and saving

Abstraction focuses on showing only the essential features of an object while hiding the underlying
complex implementation details. In Java, this is achieved through abstract classes and interfaces. It allows developers to work at
a higher level of conceptualization, reducing cognitive load and improving code clarity.

``` Java
// Parent Class (Abstraction & Inheritance)
abstract class Shape {
private String color; // Encapsulated data

    public Shape(String color) {
        this.color = color;
    }

    // Abstract method (Polymorphism)
    public abstract double getArea();

    // Common behavior (Encapsulation)
    public String getColor() {
        return color;
    }

    public void display() {
        System.out.println("This is a " + color + " shape.");
    }
}

// Child Class (Inheritance, Encapsulation, Polymorphism)
class Circle extends Shape {
private double radius; // Encapsulated data

    public Circle(String color, double radius) {
        super(color); // Call to parent constructor
        this.radius = radius;
    }

    // Polymorphic implementation of getArea()
    @Override
    public double getArea() {
        return Math.PI * radius * radius;
    }

    // Specific behavior
    public double getRadius() {
        return radius;
    }
}

// Another Child Class
class Rectangle extends Shape {
private double width;
private double height;

    public Rectangle(String color, double width, double height) {
        super(color);
        this.width = width;
        this.height = height;
    }

    @Override
    public double getArea() {
        return width * height;
    }
}

public class OOPShapeExample {
public static void main(String[] args) {
// Polymorphism in action: treating different Shapes uniformly
Shape circle = new Circle("Red", 5.0);
Shape rectangle = new Rectangle("Blue", 4.0, 6.0);

        List<Shape> shapes = new java.util.ArrayList<>();
        shapes.add(circle);
        shapes.add(rectangle);

        for (Shape s : shapes) {
            s.display(); // Common behavior
            System.out.println("Area: " + s.getArea()); // Polymorphic call
            // s.getRadius(); // ERROR: Cannot call Circle specific method on a Shape reference
        }
    }
}
```

Why it's a good choice:

Modeling Real-World Entities: Shape, Circle, and Rectangle naturally map to
real-world geometric concepts, with their own properties (color, radius, width) and behaviors (calculating area, displaying info).

Inheritance: Circle and Rectangle reuse the color property and display() method from Shape,
reducing code duplication.

Polymorphism: The getArea() method behaves differently for Circle and Rectangle but can be called
uniformly through a Shape reference, allowing you to process a List of Shapes without knowing their
exact type.

Encapsulation: The color, radius, width, and height are private, and access is controlled via public
getter methods, protecting internal data.

Abstraction: The Shape class abstracts the common concept of a shape, focusing on what all shapes do
(have a color, have an area) rather than how they do it.

This is the best use of OOP. No other approaches would have worked better.


### Java Example 2: Abstraction

Code:
```
// Abstract Class: defines the common interface and some common implementation
abstract class Animal {
private String name; // Common data

    public Animal(String name) {
        this.name = name;
    }

    // Abstract method: "what" an animal does (makes a sound), not "how"
    public abstract void makeSound();

    // Concrete method: common behavior implemented here
    public String getName() {
        return name;
    }
}

// Concrete Class: implements the abstract behavior
class Dog extends Animal {
public Dog(String name) {
super(name);
}

    @Override
    public void makeSound() {
        System.out.println(getName() + " barks!"); // Specific implementation
    }
}

public class AbstractionExample {
public static void main(String[] args) {
// We can treat a Dog as an Animal (abstraction in action)
Animal myDog = new Dog("Buddy");
myDog.makeSound(); // Calls Dog's specific makeSound()
System.out.println("My animal's name is: " + myDog.getName());
}
}
```
#### What this program is doing

- Defines an Abstract Animal Class: It creates a blueprint for what an "Animal" is. It has a name (common data) and declares that all animals must be able to makeSound(), but it doesn't specify how they make that sound (that's left abstract). It also provides a concrete getName() method that all animals will inherit.

- Defines a Concrete Dog Class: This class extends Animal, meaning a Dog is an Animal. It provides a specific implementation for the makeSound() method, defining that a dog "barks!".

- Creates and Uses a Dog Object: In the main method, an instance of Dog named "Buddy" is created. Crucially, it's referred to by its abstract type Animal (Animal myDog = new Dog("Buddy");).

- Demonstrates Polymorphic Behavior: When myDog.makeSound() is called, even though myDog is referenced as an Animal, the specific makeSound() implementation from the Dog class is executed, resulting in "Buddy barks!" being printed. It then prints the animal's name using the inherited getName() method.

Why it's a good choice: Abstraction focuses on showing only the essential features of an object while hiding the underlying
complex implementation details. In Java, this is achieved through abstract classes and interfaces. It allows developers to work at
a higher level of conceptualization, reducing cognitive load and improving code clarity.

### Other Language Example (C++/Python/JS): Encapsulation

```
Code: // C++ Example: Encapsulation
class BankAccount {
private:
double balance; // Private: cannot be accessed directly from outside

public:
BankAccount(double initialBalance) : balance(initialBalance) {}

    void deposit(double amount) { // Public: controlled access to modify balance
        if (amount > 0) {
            balance += amount;
        }
    }

    double getBalance() const { // Public: controlled access to read balance
        return balance;
    }
};

// Usage:
// BankAccount myAccount(100.0);
// myAccount.deposit(50.0);
// double currentBalance = myAccount.getBalance();
// myAccount.balance = 200.0; // ERROR: 'balance' is private!
```

Why it's a good choice: C++ classes explicitly support public, private, and protected access specifiers. You
can define member variables (data) and member functions (methods) within a class, precisely
controlling what parts are accessible from outside.

---

## 3. Bad Uses of OOP
### Java Example 1: Cache Inefficiency
Code:
```
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

// Simple OOP object
class Point3D {
double x, y, z;

    public Point3D(double x, double y, double z) {
        this.x = x; this.y = y; this.z = z;
    }
}

public class OopCacheIssue {
public static void main(String[] args) {
final int NUM_POINTS = 1_000_000;
List<Point3D> points = new ArrayList<>(NUM_POINTS);
ThreadLocalRandom random = ThreadLocalRandom.current();

        // Fill with scattered objects
        for (int i = 0; i < NUM_POINTS; i++) {
            points.add(new Point3D(random.nextDouble(), random.nextDouble(), random.nextDouble()));
        }

        long startTime = System.nanoTime();
        double sumX = 0;

        // Iterating and accessing scattered data
        for (Point3D p : points) {
            sumX += p.x; // Accessing only one field, but entire object may be loaded
        }

        long durationMs = (System.nanoTime() - startTime) / 1_000_000;
        System.out.println("Sum of X: " + sumX);
        System.out.println("Time taken (OOP objects): " + durationMs + " ms");

        // In contrast, a primitive array (DOD-like) would be:
        // double[] xCoords = new double[NUM_POINTS];
        // ... fill xCoords ...
        // for (double x : xCoords) { sumX += x; } // Far more cache-friendly
    }
}
```
This Java program, OopCacheIssue, demonstrates a potential performance bottleneck related to CPU
cache efficiency when working with object-oriented programming (OOP) constructs, specifically
comparing it to how a more "data-oriented design" (DOD) approach might perform.

It defines a simple class Point3D that represents a point in 3D space with x, y, and z coordinates,
all of type double. This is a typical OOP object. It creates 1,000,000 points. An ArrayList named
points is created to store these Point3D objects. ThreadLocalRandom is used to generate random
double values. The program iterates 1,000,000 times. In each iteration, a new Point3D object is
created with random x, y, and z values. These newly created objects are added to the points
ArrayList. Crucially, because each Point3D is a separate object allocated on the heap, they are
likely to be scattered in memory, not necessarily contiguous.

The program then iterates through the points ArrayList using an enhanced for-loop. Inside the loop,
only p.x (the x-coordinate) is accessed and added to sumX.

The commented-out section provides a hint about how a data-oriented design (DOD) approach would
differ. Instead of an array of Point3D objects, it suggests using a double[] xCoords, a primitive
array that would store only the x-coordinates contiguously in memory. It notes that this would be
"Far more cache-friendly."

With OOP, objects can be scattered across memory, leading to more CPU cache misses when iterating
through collections of complex objects. This is where Data-Oriented Design (DOD) often highlights a
weakness of typical OOP.

### Java Example 2: Increased Memory Consumption
Code:
```
import java.util.ArrayList;
import java.util.List;

class TinyObject {
byte value; // Just 1 byte of actual data
// No other fields
}

public class OopMemoryOverhead {
public static void main(String[] args) {
final int NUM_ELEMENTS = 1_000_000;

        // OOP Approach: Many small objects
        List<TinyObject> objects = new ArrayList<>(NUM_ELEMENTS);
        for (int i = 0; i < NUM_ELEMENTS; i++) {
            objects.add(new TinyObject()); // Each add creates a new object
        }
        // System.gc(); // Can try to hint GC, but unreliable for measurement

        // Conceptual DOD Approach: Primitives (no object overhead per element)
        // byte[] primitives = new byte[NUM_ELEMENTS];
        // (No direct allocation here to keep snippet focused on OOP side)

        System.out.println("Created " + NUM_ELEMENTS + " TinyObject instances.");
        System.out.println("Estimated memory for OOP objects (highly simplified):");
        // Each TinyObject:
        // ~12-16 bytes (object header) + 1 byte (value) + 4/8 bytes (reference in List)
        // (actual size depends on JVM, alignment, compressed ordinary object pointers, etc.)
        System.out.println("  ~" + (NUM_ELEMENTS * 24 / (1024 * 1024)) + " MB (rough estimate, includes List reference storage)");
        // In contrast, byte[] primitives would be ~1 MB (1 byte * 1M elements) + array overhead
    }
}
```
The program demonstrates the concept of object overhead in Java (and other object-oriented languages).
Objects are not "free": Even a tiny object like TinyObject that holds only 1 byte of
application-specific data incurs significant additional memory costs. This cost comes from:

- Object Header: Every Java object on the heap has an object header. This header contains essential
runtime information used by the JVM for garbage collection, locking, type identification, etc.
Its size can vary but is typically 12-16 bytes on a 64-bit JVM.

- Padding/Alignment: JVMs often align objects in memory to addresses that are multiples of 8 or 16
bytes for performance reasons. This means an object might take up slightly more space than the sum
of its fields and header if it needs to be padded to the next alignment boundary.

- References: When you store objects in a collection like ArrayList, the ArrayList doesn't store the
objects themselves directly but rather references (pointers) to those objects on the heap. Each
reference also consumes memory (4 or 8 bytes).

When you have millions of very small objects, the cumulative overhead of object headers and
references can quickly become much larger than the actual data you're trying to store. This can lead
to higher memory consumption and potentially more frequent garbage collection cycles, impacting
performance.

In conclusion, each object carries some overhead (object header, references), and deep object
hierarchies can lead to more memory usage than simple data structures.

### Other Language Example (C/C++/JS): [Title]
[Code + Explanation]

```#include <iostream>
#include <vector>
#include <chrono>

// Object-Oriented (OOP) Point: Dynamically allocated, scattered
class PointOOP {
public:
    double x, y;
    PointOOP(double x_val, double y_val) : x(x_val), y(y_val) {}
};

// Data-Oriented (DOD) Point: Value type, contiguous in vector
struct PointDOD {
    double x, y;
};

int main() {
    const int NUM_POINTS = 10'000'000;

    // OOP Approach: Vector of pointers to dynamically allocated objects
    std::vector<PointOOP*> oop_points;
    oop_points.reserve(NUM_POINTS);
    for (int i = 0; i < NUM_POINTS; ++i) {
        oop_points.push_back(new PointOOP(i, i)); // Bad: many 'new' calls, scattered
    }

    auto start_oop = std::chrono::high_resolution_clock::now();
    double sum_x_oop = 0.0;
    for (const auto& p : oop_points) {
        sum_x_oop += p->x; // Pointer indirection, poor cache
    }
    auto end_oop = std::chrono::high_resolution_clock::now();
    std::cout << "OOP Time: "
              << std::chrono::duration<double, std::milli>(end_oop - start_oop).count()
              << " ms\n";

    // Clean up memory for OOP approach (important!)
    for (PointOOP* p : oop_points) {
        delete p;
    }

    // DOD Approach: Vector of structs (contiguous data)
    std::vector<PointDOD> dod_points;
    dod_points.reserve(NUM_POINTS);
    for (int i = 0; i < NUM_POINTS; ++i) {
        dod_points.push_back({(double)i, (double)i}); // Good: single allocation, contiguous
    }

    auto start_dod = std::chrono::high_resolution_clock::now();
    double sum_x_dod = 0.0;
    for (const auto& p : dod_points) {
        sum_x_dod += p.x; // Direct access, good cache
    }
    auto end_dod = std::chrono::high_resolution_clock::now();
    std::cout << "DOD Time: "
              << std::chrono::duration<double, std::milli>(end_dod - start_dod).count()
              << " ms\n";

    return 0;
}
```

This C++ program is designed to demonstrate and compare the performance implications of two different
data storage strategies: a traditional Object-Oriented Programming (OOP) approach involving many
small, dynamically allocated objects versus a Data-Oriented Design (DOD) approach using a contiguous
array of plain data structures.

This program highlights the performance trade-off between OOP and DoD. OOP with many small,
dynamically allocated objects provides great flexibility and polymorphism, but can lead to poor
performance for data-intensive operations due to high memory allocation overhead as well as fragmented
memory, which leads to frequent CPU cache misses.

Data-Oriented Design (like PointDOD in std::vector) prioritizes performance by arranging data in a
way that is highly efficient for the CPU's cache, leading to reduced memory allocation overhead, 
contiguous memory layout, maximizing CPU cache hits and direct data access.

---

## 4. Reflection

The biggest misunderstanding about object-oriented programming among college students may be
believing OOP is always the best or only "right" way to program and failing to understand its true
purpose and when other paradigms might be more suitable.

Thinking that OOP is the primary paradigm for structuring code can lead to the belief that every
problem, no matter how simple or data-centric, must be solved using classes, objects, inheritance,
and polymorphism. They might try to shoehorn an object model onto problems where a simpler procedural,
functional, or data-oriented approach would be clearer, more efficient, or easier to maintain.

In reality, OOP's main purpose is to solve complexity. Students learn the "what" of OOP (classes,
objects, inheritance, polymorphism, encapsulation, abstraction) but not the "why." They don't have
enough experience with large, complex, and evolving procedural codebases to truly appreciate the
problems OOP aims to solve: managing complexity, promoting modularity, reusability, and
maintainability in large-scale software projects.

---

## Tips

- Consider real-world domains like game development, GUIs, data processing, or simulation.
- Use ChatGPT to explore what “data-oriented design” or “component-based design” looks like in games, UIs, or systems
  programming.
- Be critical: OOP isn’t bad—but it’s not a hammer for every nail.

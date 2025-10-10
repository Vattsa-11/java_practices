# STEP W6 Homework Solutions Summary

## Problem 1: Light and LED Multiple Constructors (Problem1.java)
**Topic:** Constructor Chaining with this() and super()
- **Light class:** Demonstrates constructor chaining using `this()` to call other constructors
- **LED class:** Shows both `this()` and `super()` constructor calls
- **Key concepts:** Constructor chaining, inheritance, print statements to trace constructor calls

## Problem 2: Tool Access Levels (Problem2.java)
**Topic:** Access Modifiers in Inheritance
- **Tool class:** Contains private, protected, public, and default fields
- **Hammer class:** Tests field accessibility from child class
- **Key concepts:** Access modifiers, getter methods for private fields, inheritance access rules

## Problem 3: Game and Card Game Objects (Problem3.java)
**Topic:** Overriding Object Methods
- **Game class:** Overrides toString(), equals(), and hashCode()
- **CardGame class:** Extends Game and properly overrides these methods using super calls
- **Key concepts:** Method overriding, proper equals/hashCode implementation, super method calls

## Problem 4: Food Preparation Template (Problem4.java)
**Topic:** Template Method Pattern
- **Food class:** Abstract class with template method prepare() calling wash(), cook(), serve()
- **Pizza/Soup classes:** Implement specific steps for each food type
- **Key concepts:** Template method pattern, abstract methods, algorithm skeleton

## Problem 5: Math Operations Inheritance (Problem5.java)
**Topic:** Inheritance with Method Overloading
- **BasicMath class:** Multiple overloaded calculate() methods with different parameters
- **AdvancedMath class:** Inherits all methods and adds more overloaded versions
- **Key concepts:** Method overloading, inheritance of overloaded methods, parameter differentiation

## Problem 6: Weather System Hierarchy (Problem6.java)
**Topic:** Complete Inheritance Implementation
- **Multilevel inheritance:** Weather → Storm → Thunderstorm
- **Hierarchical inheritance:** Weather → Sunshine
- **Key concepts:** Constructor chaining, method overriding, polymorphism, multilevel/hierarchical inheritance

## How to Run:
1. Open command prompt/PowerShell
2. Navigate to the "STEP W6 hw" folder
3. Compile: `javac ProblemX.java`
4. Run: `java ProblemX`

All files are working and demonstrate the required concepts with simple, clear examples.
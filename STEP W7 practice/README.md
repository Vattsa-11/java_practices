# STEP W7 Practice - Polymorphism Problems

## Practice Problems Overview

### Problem 1: GameBattle.java - Method Overloading (Compile-time Polymorphism)
**Concepts:** Method signatures, parameter differences, compile-time resolution
- Multiple `attack()` methods with different parameters
- Basic attack, weapon attack, critical hits, team attacks
- Demonstrates how compiler chooses correct method based on parameters

### Problem 2: SocialMediaDemo.java - Method Overriding (Runtime Polymorphism)
**Concepts:** Method overriding, @Override annotation, runtime polymorphism
- Base `SocialMediaPost` class with `share()` method
- `InstagramPost` and `TwitterPost` override `share()` with platform-specific behavior
- Array of base references calling overridden methods

### Problem 3: FoodDelivery.java - Dynamic Method Dispatch
**Concepts:** Runtime method resolution, object type vs reference type
- `Restaurant` base class with `prepareFood()` and `estimateTime()`
- `PizzaPlace` and `SushiBar` override methods with specific implementations
- Single reference variable pointing to different object types

### Problem 4: UniversitySystem.java - Upcasting Adventures
**Concepts:** Safe upcasting, inherited member access, compile-time limitations
- `Person` base class with `introduce()` and `getContactInfo()`
- `Student` and `Professor` subclasses with specific methods
- Demonstrates upcasting safety and access limitations

### Problem 5: EntertainmentHub.java - Mastering Downcasting
**Concepts:** Explicit downcasting, ClassCastException risks, subclass access
- `Entertainment` base class with `start()` and `stop()`
- `Movie` and `Game` subclasses with specific features
- Shows explicit casting and potential runtime errors

### Problem 6: SmartHome.java - Safe Downcasting with instanceof
**Concepts:** instanceof operator, safe type checking, robust polymorphic code
- `SmartDevice` base class with basic device operations
- `SmartLight`, `SmartThermostat`, `SmartSpeaker` with specific features
- Uses instanceof for safe downcasting and type-specific operations

## How to Run:
1. Navigate to "STEP W7 practice" folder
2. Compile: `javac FileName.java`
3. Run: `java ClassName`

## Learning Progression:
1. **Overloading** → Multiple methods, same name, different parameters
2. **Overriding** → Child classes redefine parent methods
3. **Dynamic Dispatch** → JVM chooses method at runtime based on object type
4. **Upcasting** → Safe automatic conversion to parent reference
5. **Downcasting** → Explicit conversion to child reference (risky)
6. **Safe Downcasting** → Using instanceof to prevent runtime errors

## Time Challenge: Complete all 6 in 60 minutes!

## Key Takeaways:
- **Compile-time Polymorphism**: Method overloading (which method?)
- **Runtime Polymorphism**: Method overriding (whose implementation?)
- **Upcasting**: Always safe, but limits access
- **Downcasting**: Potentially unsafe, enables full access
- **instanceof**: Your safety net for downcasting
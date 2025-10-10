// Quick Reference Guide for Polymorphism Practice Problems

/*
POLYMORPHISM QUICK REFERENCE

1. METHOD OVERLOADING (Compile-time Polymorphism)
   - Same method name, different parameters
   - Compiler decides which method to call
   - Example: attack(int), attack(int, String), attack(int, String, boolean)

2. METHOD OVERRIDING (Runtime Polymorphism)
   - Child class redefines parent method
   - @Override annotation recommended
   - JVM calls method based on actual object type

3. DYNAMIC METHOD DISPATCH
   - Method resolution at runtime
   - Reference type vs Object type
   - Parent reference → Child object = Child's overridden method called

4. UPCASTING
   - Child → Parent reference (automatic, safe)
   - Can access inherited members only
   - Student s = new Student(); Person p = s; ✅

5. DOWNCASTING
   - Parent → Child reference (explicit, risky)
   - Can access child-specific members
   - Person p = new Student(); Student s = (Student) p; ⚠️

6. SAFE DOWNCASTING
   - Use instanceof to check type first
   - Prevents ClassCastException
   - if (obj instanceof ChildClass) { ChildClass c = (ChildClass) obj; }

TESTING ORDER:
1. GameBattle.java       - Method overloading basics
2. SocialMediaDemo.java  - Method overriding intro
3. FoodDelivery.java     - Dynamic dispatch understanding
4. UniversitySystem.java - Upcasting safety
5. EntertainmentHub.java - Downcasting risks
6. SmartHome.java        - Safe downcasting mastery

COMPILE & RUN:
javac FileName.java
java ClassName
*/
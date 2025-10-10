// Practice Problem 1: Access Modifiers - The Four Levels of Security
// package com.company.security;

public class AccessModifierDemo {
    private int privateField;
    String defaultField;
    protected double protectedField;
    public boolean publicField;

    // Constructor
    public AccessModifierDemo(int priv, String def, double prot, boolean pub) {
        this.privateField = priv;
        this.defaultField = def;
        this.protectedField = prot;
        this.publicField = pub;
    }
    private void privateMethod() {
        System.out.println("Private method called");
    }
    void defaultMethod() {
        System.out.println("Default method called");
    }
    protected void protectedMethod() {
        System.out.println("Protected method called");
    }
    public void publicMethod() {
        System.out.println("Public method called");
    }
    public void testInternalAccess() {
        System.out.println("privateField: " + privateField);
        System.out.println("defaultField: " + defaultField);
        System.out.println("protectedField: " + protectedField);
        System.out.println("publicField: " + publicField);
        privateMethod();
        defaultMethod();
        protectedMethod();
        publicMethod();
    }
    public static void main(String[] args) {
        AccessModifierDemo obj = new AccessModifierDemo(1, "default", 2.5, true);
        // System.out.println(obj.privateField); // Error: private
        System.out.println(obj.defaultField); // OK: same package
        System.out.println(obj.protectedField); // OK: same package
        System.out.println(obj.publicField); // OK: public
        // obj.privateMethod(); // Error: private
        obj.defaultMethod(); // OK
        obj.protectedMethod(); // OK
        obj.publicMethod(); // OK
        obj.testInternalAccess();
    }
}

class SamePackageTest {
    public static void testAccess() {
        AccessModifierDemo obj = new AccessModifierDemo(2, "test", 3.5, false);
        // System.out.println(obj.privateField); // Error: private
        System.out.println(obj.defaultField); // OK
        System.out.println(obj.protectedField); // OK
        System.out.println(obj.publicField); // OK
        // obj.privateMethod(); // Error: private
        obj.defaultMethod(); // OK
        obj.protectedMethod(); // OK
        obj.publicMethod(); // OK
    }
}

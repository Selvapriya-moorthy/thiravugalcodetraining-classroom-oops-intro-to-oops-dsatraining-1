// QUESTION 1: SMART HOME SYSTEM
// --------------------

abstract class Device {
    private String deviceName;
    private boolean powerStatus;

    public Device(String deviceName) {
        this.deviceName = deviceName;
        this.powerStatus = false;
    }
    public String getDeviceName() {
        return deviceName;
    }

    public boolean isPowerOn() {
        return powerStatus;
    }

    public void turnOn() {
        powerStatus = true;
    }

    public void turnOff() {
        powerStatus = false;
    }
    public abstract void displayStatus();
}
class Light extends Device {

    public Light(String name) {
        super(name);
    }
    @Override
    public void displayStatus() {
        System.out.println("Light [" + getDeviceName() + "] is " +
                (isPowerOn() ? "ON" : "OFF"));
    }
}

class Thermostat extends Device {
    private int temperature;

    public Thermostat(String name, int temp) {
        super(name);
        this.temperature = temp;
    }

    @Override
    public void displayStatus() {
        System.out.println("Thermostat [" + getDeviceName() + "] is " +
                (isPowerOn() ? "ON" : "OFF") +
                " | Temp: " + temperature + "°C");
    }
}


// --------------------
// QUESTION 2: PAYMENT SYSTEM (SOLID)
// --------------------

interface PaymentMethod {
    void processPayment(double amount);
}

class CreditCardPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("₹" + amount + " paid using Credit Card");
    }
}

class PayPalPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("₹" + amount + " paid using PayPal");
    }
}

class UPIPayment implements PaymentMethod {
    public void processPayment(double amount) {
        System.out.println("₹" + amount + " paid using UPI");
    }
}

class PaymentProcessor {
    public void makePayment(PaymentMethod method, double amount) {
        method.processPayment(amount);
    }
}


// --------------------
// QUESTION 3: NOTIFICATION SYSTEM (SOLID)
// --------------------

interface EmailSender {
    void sendEmail(String message);
}

interface SMSSender {
    void sendSMS(String message);
}

interface PushNotificationSender {
    void sendPushNotification(String message);
}

class EmailNotification implements EmailSender {
    public void sendEmail(String message) {
        System.out.println("Email Sent: " + message);
    }
}

class SMSNotification implements SMSSender {
    public void sendSMS(String message) {
        System.out.println("SMS Sent: " + message);
    }
}

class MobileAppNotification implements PushNotificationSender {
    public void sendPushNotification(String message) {
        System.out.println("Push Notification: " + message);
    }
}


// --------------------
// MAIN CLASS
// --------------------

public class assignment3{

    public static void main(String[] args) {

        // -------- QUESTION 1 --------
        System.out.println("---- SMART HOME SYSTEM ----");

        Device light = new Light("Hall");
        Device thermostat = new Thermostat("Bedroom", 24);

        light.turnOn();
        thermostat.turnOn();

        light.displayStatus();
        thermostat.displayStatus();

        light.turnOff();
        light.displayStatus();


        // -------- QUESTION 2 --------
        System.out.println("\n---- PAYMENT SYSTEM ----");

        PaymentProcessor processor = new PaymentProcessor();

        processor.makePayment(new CreditCardPayment(), 2000);
        processor.makePayment(new PayPalPayment(), 1500);
        processor.makePayment(new UPIPayment(), 750);


        // -------- QUESTION 3 --------
        System.out.println("\n---- NOTIFICATION SYSTEM ----");

        new EmailNotification().sendEmail("Welcome User!");
        new SMSNotification().sendSMS("Your OTP is 5678");
        new MobileAppNotification().sendPushNotification("New Message Received");
    }
}
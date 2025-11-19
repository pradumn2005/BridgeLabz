import java.util.function.Consumer;

public class SmartLightingAutomation {

    // Functional interface representing a lighting behavior
    interface LightBehavior extends Consumer<String> {
        // Inherits void accept(String roomName)
    }

    public static void activateLight(String room, LightBehavior behavior) {
        behavior.accept(room);
    }

    public static void main(String[] args) {
        // Behavior 1: Motion Detection Trigger
        LightBehavior motionTrigger = (room) -> {
            System.out.println(room + ": Motion detected. Setting lights to a bright reading mode.");
        };

        // Behavior 2: Time of Day Trigger (Evening)
        LightBehavior timeTrigger = (room) -> {
            System.out.println(room + ": It's evening. Setting lights to warm, ambient 40% intensity.");
        };

        // Behavior 3: Voice Command Trigger (Party Mode)
        LightBehavior voiceTrigger = (room) -> {
            System.out.println(room + ": Voice command 'Party'. Activating dynamic color cycling.");
        };

        System.out.println("--- Automation Test ---");
        activateLight("Living Room", motionTrigger);
        activateLight("Kitchen", timeTrigger);
        activateLight("Bedroom", voiceTrigger);
    }
}

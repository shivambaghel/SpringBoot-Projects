package Command;

public class Exercise {
    
    public void run () {
        
        // Create devices
        Light light = new Light();
        Fan fan = new Fan();

        // Create commands
        Command lightOn = new LightCommands.LightOnCommand(light);
        Command lightOff = new LightCommands.LightOffCommand(light);
        Command fanOn = new FanCommands.FanOnCommand(fan);
        Command fanOff = new FanCommands.FanOffCommand(fan);

        // Create remote control
        RemoteControl remoteControl = new RemoteControl();
        remoteControl.setLightOnCommand(lightOn);
        remoteControl.setLightOffCommand(lightOff);
        remoteControl.setFanOnCommand(fanOn);
        remoteControl.setFanOffCommand(fanOff);

        // Test the functionality
        remoteControl.pressLightOnButton(); // Output: The light is on.
        remoteControl.pressLightOffButton(); // Output: The light is off.
        remoteControl.pressFanOnButton(); // Output: The fan is on.
        remoteControl.pressFanOffButton(); // Output: The fan is off.
    }
}
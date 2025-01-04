package Command;

public class FanCommands {

    public static class FanOnCommand implements Command {
        
        private Fan fan;

        public FanOnCommand(Fan fan) {
            this.fan = fan;
        }

        @Override
        public void execute() {
            fan.turnOn();
        }
    }

    public static class FanOffCommand implements Command {
        
        private Fan fan;

        public FanOffCommand(Fan fan) {
            this.fan = fan;
        }

        @Override
        public void execute() {
            fan.turnOff();
        }
    }
}
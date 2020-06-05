package patterns.command;

/**
 * The Command for turning on the light - ConcreteCommand #1
 */
class SwitchOnCommand implements Command {
    private final Light light;

    public SwitchOnCommand(Light light) {
        this.light = light;
    }

    @Override
    public void execute() {
        light.turnOn();
    }
}

package Mediator;

public interface Mediator {
    void registerAirplane(Airplane airplane);
    void handleTakeoffRequest(Airplane airplane);
    void handleLandingRequest(Airplane airplane);
}
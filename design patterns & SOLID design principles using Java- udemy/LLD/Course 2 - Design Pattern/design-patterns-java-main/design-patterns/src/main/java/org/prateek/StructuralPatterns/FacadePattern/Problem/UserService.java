package org.prateek.StructuralPatterns.FacadePattern.Problem;

// Microservice for User Management
class UserService {
    public String getUserDetails(String userId) {
        // Simulate fetching user details
        return "User details for userId: " + userId;
    }
}
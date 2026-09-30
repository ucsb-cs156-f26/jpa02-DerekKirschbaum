package edu.ucsb.cs156.spring.hello;

/**
 * A class with static methods to provide information about the developer.
 */

public class Developer {

    // This class is not meant to be instantiated
    // so we make the constructor private

    private Developer() {}
    
    /**
     * Get the name of the developer
     */

    public static String getName() {
        return "Derek";
    }

    /**
     * Get the github id of the developer
     * @return github id of the developer
     */

    public static String getGithubId() {
        return "DerekKirschbaum";
    }

    /**
     * Get the developers team
     * @return developers team as a Java object
     */
    
    public static Team getTeam() {
        Team team = new Team("staff");
        team.addMember("Daniel");
        team.addMember("Derek");
        team.addMember("Keigo");
        team.addMember("Phill");
        team.addMember("Wendy");
        team.addMember("Victor");
        return team;
    }
}

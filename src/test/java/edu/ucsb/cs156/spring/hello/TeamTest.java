package edu.ucsb.cs156.spring.hello;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TeamTest {

    Team team;

    @BeforeEach
    public void setup() {
        team = new Team("test-team");    
    }

    @Test
    public void getName_returns_correct_name() {
        assertEquals("test-team", team.getName());
        assertEquals(List.of(), team.getMembers());
    }

    @Test
    public void default_constructor_creates_empty_team() {
        Team emptyTeam = new Team();
        assertEquals("", emptyTeam.getName());
        assertEquals(List.of(), emptyTeam.getMembers());
    }

    @Test
    public void addMember_preserves_members_in_order() {
        team.addMember("Daniel");
        team.addMember("Derek");
        assertEquals(List.of("Daniel", "Derek"), team.getMembers());
    }

    @Test
    public void setName_replaces_name() {
        team.setName("new-team");
        assertEquals("new-team", team.getName());
    }

    @Test
    public void setMembers_replaces_members() {
        team.addMember("Daniel");
        team.setMembers(new ArrayList<>(List.of("Keigo", "Phill", "Wendy", "Victor")));
        assertEquals(List.of("Keigo", "Phill", "Wendy", "Victor"), team.getMembers());
    }

    @Test
    public void equals_returns_true_for_same_instance() {
        assertTrue(team.equals(team));
    }

    @Test
    public void equals_returns_false_for_null() {
        assertFalse(team.equals(null));
    }

    @Test
    public void equals_returns_false_for_other_type() {
        assertFalse(team.equals("test-team"));
    }

    @Test
    public void equals_returns_true_for_matching_name_and_members() {
        team.addMember("Daniel");
        Team other = new Team("test-team");
        other.addMember("Daniel");
        assertTrue(team.equals(other));
        assertTrue(other.equals(team));
        assertEquals(team.hashCode(), other.hashCode());
    }

    @Test
    public void equals_returns_false_for_different_name() {
        Team other = new Team("other-team");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_members() {
        Team other = new Team("test-team");
        other.addMember("Derek");
        assertFalse(team.equals(other));
    }

    @Test
    public void equals_returns_false_for_different_member_order() {
        team.addMember("Daniel");
        team.addMember("Derek");
        Team other = new Team("test-team");
        other.addMember("Derek");
        other.addMember("Daniel");
        assertFalse(team.equals(other));
    }

    @Test
    public void toString_includes_name_and_members() {
        assertEquals("Team(name=test-team, members=[])", team.toString());
        team.addMember("Wendy");
        team.addMember("Victor");
        assertEquals("Team(name=test-team, members=[Wendy, Victor])", team.toString());
    }

    @Test
    public void hashCode_combines_name_and_members_with_bitwise_or() {
        // "A" hashes to 65 and an empty list hashes to 1: OR is 65, AND is 1.
        Team hashTeam = new Team("A");
        assertEquals(65, hashTeam.hashCode());
        // List.of("B") hashes to 97, so 65 | 97 is 97.
        hashTeam.addMember("B");
        assertEquals(97, hashTeam.hashCode());
    }

}

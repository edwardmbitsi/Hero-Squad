package models;

import org.junit.After;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class SquadTest {
    @Test
    public void NewSquadObjectGetsCorrectlyCreated_true() throws Exception {
        Squad squad = new Squad("Avengers", 10, "greater good");
        assertEquals(true, squad instanceof Squad);
    }

    @Test
    public void SquadInstantiatesWithName_true() throws Exception {
        Squad squad = new Squad("Avengers", 10, "greater good");
        assertEquals("Avengers", squad.getName());

    }
    @Test
    public void SquadInstantiatesWithCause_true() throws Exception {
        Squad squad = new Squad("Avengers", 10, "greater good");
        assertEquals("greater good", squad.getCause());

    }

    @After
    public void tearDown() {
        Squad.clearAllSquads();

    @Test
    public void AllSquadAreCorrectlyReturned_true() {
        Squad squad = new Squad("Avengers", 10, "greater good");
        Squad otherSquad = new Squad("justice league", 7 , "fight crime");
        assertEquals(2, Squad.getAll().size());
    }

    @Test
    public void AllSquadsContainsAllSquads_true() {
        Squad squad = new Squad("Avengers", 10, "greater good");
        Squad otherSquad= new Squad("justice league", 7 , "fight crime");
        assertTrue(Squad.getAll().contains(squad));
        assertTrue(Squad.getAll().contains(otherSquad));
    }

    @Test
    public void getId_squadInstantiateWithAnID_1() throws Exception {
        Squad.clearAllSquads();
        Squad mySquad = new Squad("Avengers", 10, "greater good");
        assertEquals(1, mySquad.getId());

    }
    @Test
    public void findReturnsCorrectSquadWhenMoreThanOneSquadExists() throws Exception {
        Squad squad = new Squad("Avengers", 10, "greater good");
        Squad otherSquad = new Squad("justice league", 7 , "fight crime");
        assertEquals(2, Squad.findById(otherSquad.getId()).getId());
    }


}



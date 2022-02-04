package models;

import org.junit.After;
import org.junit.Test;

import java.time.LocalDateTime;

import static org.junit.Assert.*;

public class HeroTest {
    @Test
    public void NewPostObjectGetsCorrectlyCreated_true() throws Exception {
        Hero hero = new Hero("Ironman", 50, "fly", "Iron");
        assertEquals(true, hero instanceof Hero);
    }

    @Test
    public void HeroInstantiatesWithName_true() throws Exception {
        Hero hero = new Hero("Ironman", 50, "fly", "Iron");
        assertEquals("Ironman", hero.getName());

    }

    @Test
    public void HeroInstantiatesWithPowers_true() throws Exception {
        Hero hero = new Hero("Ironman", 50, "fly", "Iron");
        assertEquals("fly", hero.getPowers());

    }
    @Test
    public void HeroInstantiatesWithWeakness_true() throws Exception {
        Hero hero = new Hero("Ironman", 50, "fly", "Iron");
        assertEquals("Iron", hero.getWeakness());

    }


    @After
    public void tearDown() {
        Hero.clearAllHeros(); //clear out all the posts before each test.
    }

    @Test
    public void AllHerosAreCorrectlyReturned_true() {
        Hero hero = new Hero("Ironman", 50, "fly", "Iron");
        Hero otherHero = new Hero("Hulk", 45 , "green", "temper");
        assertEquals(2, Hero.getAll().size());
    }

    @Test
    public void AllHerosContainsAllHeros_true() {
        Hero hero = new Hero("Ironman", 50, "fly", "Iron");
        Hero otherHero = new Hero("Hulk", 45 , "green", "temper");
        assertTrue(Hero.getAll().contains(hero));
        assertTrue(Hero.getAll().contains(otherHero));
    }

    @Test
    public void getId_heroInstantiateWithAnID_1() throws Exception {
        Hero.clearAllHeros();
        Hero myHero = new Hero("Ironman", 50, "fly", "Iron");
        assertEquals(1, myHero.getId());

    }
    @Test
    public void findReturnsCorrectHeroWhenMoreThanOneHeroExists() throws Exception {
        Hero hero = new Hero("Ironman", 50, "fly", "Iron");
        Hero otherHero = new Hero("Hulk", 45 , "green", "temper");
        assertEquals(2, Hero.findById(otherHero.getId()).getId());
    }

}
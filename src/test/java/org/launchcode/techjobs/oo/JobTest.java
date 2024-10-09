package org.launchcode.techjobs.oo;

import org.junit.Test;

import javax.naming.Name;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job fullJob = new Job("Product test", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(fullJob.getName() instanceof String);
        assertEquals("Product test", fullJob.getName());

        assertTrue(fullJob.getEmployer() instanceof Employer);
        assertEquals("ACME", fullJob.getEmployer().getValue());

        assertTrue(fullJob.getLocation() instanceof Location);
        assertEquals("Desert", fullJob.getLocation().getValue());

        assertTrue(fullJob.getPositionType() instanceof PositionType);
        assertEquals("Quality control", fullJob.getPositionType().getValue());

        assertTrue(fullJob.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence", fullJob.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job fullJob1 = new Job("Product test", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job fullJob2 = new Job("Product test", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        System.out.println(fullJob1.equals(fullJob2));
        assertFalse(fullJob1.equals(fullJob2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job fullJob = new Job("Product test", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertEquals(fullJob.toString().startsWith(System.lineSeparator()), true);
        assertEquals(fullJob.toString().endsWith(System.lineSeparator()), true);
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {

        Job fullJob = new Job("Product test", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        String printString = System.lineSeparator() +
                "ID: " + fullJob.getId() +
                System.lineSeparator() +
                "Name: Product test" +
                System.lineSeparator() +
                "Employer: ACME" +
                System.lineSeparator() +
                "Location: Desert" +
                System.lineSeparator() +
                "Position Type: Quality control" +
                System.lineSeparator() +
                "Core Competency: Persistence" +
                System.lineSeparator();

        assertEquals(printString, fullJob.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {

        Job fullJob = new Job("Product test", new Employer(""), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency(""));

        String printString = System.lineSeparator() +
                "ID: " + fullJob.getId() +
                System.lineSeparator() +
                "Name: Product test" +
                System.lineSeparator() +
                "Employer: Data not available" +
                System.lineSeparator() +
                "Location: Desert" +
                System.lineSeparator() +
                "Position Type: Quality control" +
                System.lineSeparator() +
                "Core Competency: Data not available" +
                System.lineSeparator();

        assertEquals(printString, fullJob.toString());
    }

    @Test
    public void isMissingJob() {
        Job fullJob = new Job("", new Employer(""), new Location(""),
                new PositionType(""), new CoreCompetency(""));

        String printString = "OOPS! This job does not seem to exist.";

        assertEquals(printString, fullJob.toString());
    }
}

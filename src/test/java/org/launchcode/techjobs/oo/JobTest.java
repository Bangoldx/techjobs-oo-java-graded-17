package org.launchcode.techjobs.oo;

import org.junit.Test;

import javax.naming.Name;

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
    public void testJobsForEquality(){
        Job fullJob1 = new Job("Product test", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        Job fullJob2 = new Job("Product test", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(fullJob1.equals(fullJob2));
    }
}

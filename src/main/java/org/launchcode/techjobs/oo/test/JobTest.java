package org.launchcode.techjobs.oo.test;

import org.junit.Test;
import org.launchcode.techjobs.oo.*;

import static org.junit.Assert.*;

public class JobTest {


    @Test
    public void testingEmptyConstructor(){
       Job job1 = new Job();
       Job job2 = new Job();
        assertTrue(job1.getId()==job1.getId());
        assertTrue(job1.getId() == job2.getId()-1);

    }


    @Test
    public void testJobConstructorSetsAllFields(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertEquals("Product tester", job1.getName());
        assertTrue(job1 instanceof Job);
        assertEquals("Product tester", job1.getName());
        assertTrue(job1.getEmployer() instanceof Employer);
        assertEquals("ACME",job1.getEmployer().getValue());
        assertTrue(job1.getLocation() instanceof Location);
        assertEquals("Desert",job1.getLocation().getValue());
        assertTrue(job1.getPositionType() instanceof PositionType);
        assertEquals("Quality control", job1.getPositionType().getValue());
        assertTrue(job1.getCoreCompetency() instanceof CoreCompetency);
        assertEquals("Persistence",job1.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        assertFalse(job1 == job2);
    }

    @Test
    public void testForNewLinesBeforeAndAfter(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        int lastIndex = (job1.toString().length()-1);

        assertTrue(job1.toString().charAt(0)=='\n');
        assertTrue(job1.toString().charAt(lastIndex) == '\n');

    }

    @Test
    public void testingPrintLine(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        String[] beginsWithCategory = job1.toString().trim().split("\n");

        assertTrue(beginsWithCategory[0].startsWith("ID: "));
        assertTrue(beginsWithCategory[1].startsWith("Name: "));
        assertTrue(beginsWithCategory[2].startsWith("Employer: "));
        assertTrue(beginsWithCategory[3].startsWith("Location: "));
        assertTrue(beginsWithCategory[4].startsWith("Position Type: "));
        assertTrue(beginsWithCategory[5].startsWith("Core Competency: "));

        assertTrue(beginsWithCategory[0].endsWith(Integer.toString(job1.getId())));
        assertTrue(beginsWithCategory[1].endsWith(job1.getName()));
        assertTrue(beginsWithCategory[2].endsWith(job1.getEmployer().toString()));
        assertTrue(beginsWithCategory[3].endsWith(job1.getLocation().toString()));
        assertTrue(beginsWithCategory[4].endsWith(job1.getPositionType().toString()));
        assertTrue(beginsWithCategory[5].endsWith(job1.getCoreCompetency().toString()));

    }

//    @Test
//    public void testingUnavailableData(){
//        Job job1 = new Job("Ice cream taster", new Employer(""), new Location("Home"), new PositionType("UX"), new CoreCompetency("Taste"));
//        String[] beginsWithCategory = job1.toString().trim().split("\n");
//        assertTrue(job1.getEmployer().toString().contains("Data Not Available"));
//    }



}
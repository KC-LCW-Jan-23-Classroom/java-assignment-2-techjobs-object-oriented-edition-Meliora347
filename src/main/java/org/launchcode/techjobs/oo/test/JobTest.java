package org.launchcode.techjobs.oo.test;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.JUnit4;
import org.launchcode.techjobs.oo.*;

/**
 * Created by LaunchCode
 */
@RunWith(JUnit4.class)
public class JobTest {

    @Test
   public void testSettingJobId(){
        Job job1 = new Job();
        Job job2 = new Job();
        Assert.assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertTrue(job.getName() instanceof String);
        Assert.assertEquals(job.getName(), "Product tester");
        Assert.assertTrue(job.getEmployer() instanceof Employer);
        Assert.assertEquals(job.getEmployer().getValue(), "ACME");
        Assert.assertTrue(job.getLocation() instanceof Location);
        Assert.assertEquals(job.getLocation().getValue(), "Desert");
        Assert.assertTrue(job.getPositionType() instanceof PositionType);
        Assert.assertEquals(job.getPositionType().getValue(), "Quality control");
        Assert.assertTrue(job.getCoreCompetency() instanceof CoreCompetency);
        Assert.assertEquals(job.getCoreCompetency().getValue(), "Persistence");
    }

    @Test
    public void testJobsForEquality(){
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Assert.assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine(){
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));


        String jobString = job.toString() ;
        Assert.assertEquals(jobString.charAt(0), '\n');
        Assert.assertEquals(jobString.charAt(jobString.lastIndexOf(jobString)), '\n');

    }

    @Test
    public void testToStringContainsCorrectLabelsAndData(){
            Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
            String expectedString = "\nID: " + job.getId() +
                    "\nName: Product tester" +
                    "\nEmployer: ACME" +
                    "\nLocation: Desert" +
                    "\nPosition Type: Quality control" +
                    "\nCore Competency: Persistence" +
                    "\n";
            Assert.assertEquals(expectedString, job.toString());

    }
    @Test
    public void testToStringHandlesEmptyField(){
        Job job = new Job(null, new Employer(null), new Location(null), new PositionType(null), new CoreCompetency(null));
        String expectedString = "\nID: "+ job.getId() +
                "\nName: Data not available" +
                "\nEmployer: Data not available" +
                "\nLocation: Data not available" +
                "\nPosition Type: Data not available" +
                "\nCore Competency: Data not available" +
                "\n";
        Assert.assertEquals(expectedString, job.toString());

    }

}

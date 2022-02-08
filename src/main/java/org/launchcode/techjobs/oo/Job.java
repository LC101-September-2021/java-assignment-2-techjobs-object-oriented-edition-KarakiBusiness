package org.launchcode.techjobs.oo;

import java.lang.reflect.Field;
import java.util.Objects;

public class Job {

    private int id;
    private static int nextId = 1;

    private String name;
    private Employer employer;
    private Location location;
    private PositionType positionType;
    private CoreCompetency coreCompetency;

    // TODO: Add two constructors - one to initialize a unique ID and a second to initialize the
    //  other five fields. The second constructor should also call the first in order to initialize
    //  the 'id' field.

    public Job (String name, Employer employer, Location location, PositionType positionType, CoreCompetency coreCompetency) {
        this();
        this.name = name;
        this.employer = employer;
        this.location = location;
        this.positionType = positionType;
        this.coreCompetency = coreCompetency;
    }

    public Job() {
        id = nextId;
        nextId++;
    }

    // TODO: Add custom equals and hashCode methods. Consider two Job objects "equal" when their id fields
    //  match.

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Job)) return false;
        Job job = (Job) o;
        return getId() == job.getId();
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId());
    }


    // TODO: Add getters for each field EXCEPT nextId. Add setters for each field EXCEPT nextID
    //  and id.


    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Employer getEmployer() {
        return employer;
    }

    public void setEmployer(Employer employer) {
        this.employer = employer;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public PositionType getPositionType() {
        return positionType;
    }

    public void setPositionType(PositionType positionType) {
        this.positionType = positionType;
    }

    public CoreCompetency getCoreCompetency() {
        return coreCompetency;
    }

    public void setCoreCompetency(CoreCompetency coreCompetency) {
        this.coreCompetency = coreCompetency;
    }

//



    @Override
    public String toString(){
        String[] labels = {"ID: ", "Name: ", "Employer: ", "Location: ", "Position Type: ", "Core Competency: "};
        StringBuilder result = new StringBuilder();
        Field[] fields = this.getClass().getDeclaredFields();
        String dataNotAvailable = "Data Not Available";
        result.append("\n");
        int iterator = 0;

        for (Field field : fields) {
            // result.append("  ");
            field.setAccessible(true);
            if (field.getName() != "nextId") {
                try {
                    result.append(labels[iterator]);
                    if ( field.get(this).toString() == "" ) {
                        result.append(dataNotAvailable);
                    } else {
                        result.append(field.get(this));
                    }

                } catch (IllegalAccessException ex) {
                    result = new StringBuilder("data not available");
                }
                result.append("\n");
                iterator++;
            }
        }

        return result.toString();


    }



    // don't do anything
//            }else if(field.getName() == "id") {
//                result.append(field.getName().toUpperCase());
//                result.append(": ");
//            }else{
//                try {
//                    result.append(field.getInt(this));
//                    result.append("\n");
//                } catch (IllegalAccessException e) {
//                    e.printStackTrace();
//                }






}

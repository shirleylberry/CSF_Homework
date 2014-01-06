import java.util.*;
import java.lang.Comparable;


public class Reservations implements Comparable<Reservations>{
    private String name;
    private int time;
    private int numPeople;
    private String website;
    private long phoneNum;
    private int timeReserved;
    private String resType;

    //the constructor for website reservations
    public Reservations(String resType, String name, int time, int numPeople, int timeReserved, String website, long phoneNum){
        super();
        this.resType = resType;
        this.name = name;
        this.time = time;
        this.numPeople = numPeople;
        this.timeReserved = timeReserved;
        this.website = website;
        this.phoneNum = phoneNum;
    }

    //the constructor for phone reservations
    public Reservations(String resType, String name, int time, int numPeople, int timeReserved, long phoneNum){
        this(resType, name, time, numPeople, timeReserved, null, phoneNum);
    }
    //the in-person reservations constructor
    public Reservations(String resType, String name, int time, int numPeople, int timeReserved){
        this(resType, name, time, numPeople, timeReserved, null, 0);
    }
    //Getters and setters for all of the private variables
    public int getNumPeople() {
        return numPeople;
    }

    public void setNumPeople(int numPeople) {
        this.numPeople = numPeople;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public String getWebsite() {
        return website;
    }

    public void setWebsite(String website) {
        this.website = website;
    }

    public long getPhoneNum() {
        return phoneNum;
    }

    public String getResType() {
        return resType;
    }

    public void setResType(String resType) {
        this.resType = resType;
    }

    public void setPhoneNum(long phoneNum) {
        this.phoneNum = phoneNum;
    }

    public int getTimeReserved() {
        return timeReserved;
    }

    public void setTimeReserved(int timeReserved) {
        this.timeReserved = timeReserved;
    }

    public String toString(){
        String resSummary;
        resSummary = "This is a " + getResType() + " reservation.  The name is " + getName() + ", the reservation is at " + getTime()
                + ", and it is for " + getNumPeople() + " people";
        return resSummary;
    }

    public String webToString(){
        String resSummary;
        resSummary = "This is a " + getResType() + " reservation.  The name is " + getName() + ", the reservation is at " + getTime()
                + ", it is for " + getNumPeople() + " people, the phone number is " + getPhoneNum()
                + " and the website is " + getWebsite();
        return resSummary;
    }

    public String phoneToString(){
        String resSummary;
        resSummary = "This is a " + getResType() + " reservation.  The name is " + getName() + ", the reservation is at " + getTime()
                + ", it is for " + getNumPeople() + " people, the phone number is " + getPhoneNum();
        return resSummary;
    }

    public int compareTo(Reservations x){
        return this.time - x.time;
    }

    public int checkSpace(ArrayList<Reservations> x){
        int hour = this.getTime();
        int availSeats = 40;
        for(Reservations i : x){
            if(i.getTime() == hour){
                availSeats -= i.getNumPeople();
            }
        }
        return availSeats;
    }

    public ArrayList<Reservations> deleteRes(ArrayList<Reservations> x, String delName, int delTime){
        for (Reservations i : x){
            if(i.getName().equals(delName) && i.getTime() == delTime){
                x.remove(i);
            }
        }
        return x;
    }
}

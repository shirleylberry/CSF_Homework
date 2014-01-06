import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;
import java.util.Collections;

public class MaitreD {
    public static void main(String[] args){

        ArrayList<Reservations> allRes = new ArrayList<Reservations>();
        Scanner scanner = new Scanner(System.in);
        String request;
        String name;
        String resType = "default";
        int numPeople;
        int time;
        long phoneNum = 0;
        int timeReserved;
        String website;
        int available;

        do {
            System.out.println("Would you like to [a]dd a res, [d]elete a res, [l]ist existing res, or [e]nd the session?");
            request = scanner.next();
            if(request.equals("e")){
                System.out.println("Okay, I'll end the session.");
                break;
            }
            if(request.equals("a")){
                System.out.println("Are you calling[c], making a reservation through our website[w], or are you making it in-person[p]?");
                String type = scanner.next();
                //Take a new reservation from a caller
                System.out.println("What name should I put on the reservation?");
                name = scanner.next();
                System.out.println("What time is the reservation for?");
                time = scanner.nextInt();
                System.out.println("How many people is the reservation for?");
                numPeople = scanner.nextInt();
                System.out.println("What time is it currently?");
                timeReserved = scanner.nextInt();
                //take a new phone reservation
                if(type.equals("c")){
                    System.out.println("What is your phone number?");
                    phoneNum = scanner.nextLong();
                    Reservations newRes = new Reservations(resType, name, time, numPeople, timeReserved, phoneNum);
                    newRes.setResType("c");
                    newRes.setName(name);
                    newRes.setTime(time);
                    newRes.setNumPeople(numPeople);
                    newRes.setTimeReserved(timeReserved);
                    newRes.setPhoneNum(phoneNum);
                    available = newRes.checkSpace(allRes);
                    if(available >= newRes.getNumPeople()){
                        System.out.println("Okay, I made you a new phone reservation:");
                        System.out.println(newRes.phoneToString());
                        allRes.add(newRes);
                    }
                    else{
                        System.out.println("Sorry, that time isn't available.  Try again.");
                    }
                }
                //Take a new website reservation
                else if(type.equals("w")){
                    System.out.println("What is your phone number?");
                    phoneNum = scanner.nextLong();
                    System.out.println("What website are you visiting from?");
                    website = scanner.next();
                    Reservations newRes = new Reservations(resType, name, time, numPeople, timeReserved, website, phoneNum);
                    newRes.setResType("w");
                    newRes.setName(name);
                    newRes.setTime(time);
                    newRes.setNumPeople(numPeople);
                    newRes.setTimeReserved(timeReserved);
                    newRes.setWebsite(website);
                    newRes.setPhoneNum(phoneNum);
                    available = newRes.checkSpace(allRes);
                    if(available >= newRes.getNumPeople()){
                        System.out.println("Okay, I made you a new website reservation:");
                        System.out.println(newRes.webToString());
                        allRes.add(newRes);
                    }
                    else{
                        System.out.println("Sorry, that time isn't available.  Try again.");
                    }
                }
                //Take a basic, in-person reservation
                else if(type.equals("p")){
                    Reservations newRes = new Reservations(resType, name, time, numPeople, timeReserved);
                    newRes.setResType("p");
                    newRes.setName(name);
                    newRes.setTime(time);
                    newRes.setNumPeople(numPeople);
                    newRes.setTimeReserved(timeReserved);
                    available = newRes.checkSpace(allRes);
                    if(available >= newRes.getNumPeople()){
                        System.out.println("Okay, I made you a new in-person reservation:");
                        System.out.println(newRes.toString());
                        allRes.add(newRes);
                    }
                    else if (available + 10 >= newRes.getNumPeople()){
                        System.out.println("You're lucky, we had some in-person reserved seats available:");
                        System.out.println(newRes.phoneToString());
                        allRes.add(newRes);
                    }
                    else{
                        System.out.println("Sorry, that time isn't available for that many people.  Try again.");
                    }
                }
                else{
                    System.out.println("Sorry, I didn't understand that.");
                }
            }

            // request for deletion
            else if (request.equals("d")){
                System.out.println("What reservation would you like to remove?  Please enter the name:");
                String delName = scanner.next();
                System.out.println("and the time:");
                int delTime = scanner.nextInt();
                for (Reservations i : allRes){
                    if(i.getName().equals(delName) && i.getTime() == delTime){
                        allRes.remove(i);
                        break;
                    }
                }
            }

            //request for listings
            else if(request.equals("l")){
                Collections.sort(allRes);
                for (Reservations i : allRes){
                    String type = i.getResType();
                    if(type.equals("c")){
                        System.out.println(i.phoneToString());
                    }
                    else if(type.equals("w")){
                        System.out.println(i.webToString());
                    }
                    else{
                        System.out.println(i.toString());
                    }
                }
            }
            else{
                System.out.println("Sorry, that wasn't a valid request.  Try again.");
            }
        }
        while (!request.equals("e"));
    }
}

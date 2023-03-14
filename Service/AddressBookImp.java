package Service;

import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;


import Exception.InvalidEmailIdException;
import Exception.InvalidMobilNoException;
import Exception.InvalidNameException;
import Interface.iAddressBook;
import Model.Contacts;
import Utility.FileHandlingWriteRead;
import Utility.RegexUtil;

public class AddressBookImp extends AddressBookEdit implements iAddressBook
{
    private static LinkedList<Contacts> linkedList = new LinkedList<>();
    private Scanner SCANNER = new Scanner(System.in);
    public void showCondition()
    {
        System.out.println();
        System.out.println("Enetr your choice");
        System.out.println("1 : Insert the Contacts");
        System.out.println("2 : Display all address in contact book");
        System.out.println("3 : Edit existing contact person using their name");
        System.out.println("4 : Delete existing contact person using their name");
        System.out.println("5 : Ability to search Person in a City or State");
        System.out.println("6 : Ability to view Persons by City or State ");
        System.out.println("7 : Ability to get number of contact persons i.e. count by City or State ");
        System.out.println("8 : Ability to sort the entries in the address book alphabetically by Person’s name ");
        System.out.println("9 : Ability to sort the entries in the address book by City, State, or Zip  ");
        System.out.println("10 : Terminate the application");
        System.out.println("11 : Ability to Read or Write the Address Book with Persons Contact into a File  ");
    }
    //UC13
    public void insertDataIntoAFile(Contacts contacts)
    {
        FileHandlingWriteRead fileHandlingWriteRead = new FileHandlingWriteRead();

            System.out.println("Enter the file name that you want to write the data");
            String fileName = SCANNER.next();
            fileHandlingWriteRead.write(fileName,contacts);
    }

    public void insertContacts(Contacts contacts)throws InvalidNameException,InvalidMobilNoException,InvalidEmailIdException
    {

        AddressBookImp addressBookImp = new AddressBookImp();
        RegexUtil regexUtil = new RegexUtil();


        if(regexUtil.isStartWithCapitalLatter(contacts.getFirstName()))
        {
            if(findDuplication(contacts.getFirstName()))
            {
                if(regexUtil.isStartWithCapitalLatter(contacts.getLastnames()))
                {

                    if(regexUtil.isCheckEmailId(contacts.getEmail()))
                    {
                        String mobileNumber = contacts.getPhoneNumber()+"";
                        if(regexUtil.isCheckMobileNumber(mobileNumber))
                        {

                            linkedList.add(contacts);
                            System.out.println();
                            System.out.println("-------------------------------------------");
                            System.out.println("Contact Added Succesfully in Address Book");
                            System.out.println("-------------------------------------------");

                        }
                    }

                }
            }
            else
            {
                System.out.println();
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
                System.out.println("First name information allready exist");
                System.out.println("!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");

            }

        }


    }
    private static boolean findDuplication(String input)
    {

        for(int i=0; i<linkedList.size();i++)
        {
            if((linkedList.get(i).getFirstName()).equals(input))
            {
                return false;
            }
        }
        return true;
    }

    public void showAllContacts()
    {
        for(int counter=0; counter<linkedList.size(); counter++)
        {


            System.out.println("-- Display "+(counter+1)+" Person in Address Book----------");
            System.out.println(" First name :"+linkedList.get(counter).getFirstName());
            System.out.println(" Last name  :"+linkedList.get(counter).getLastnames());
            System.out.println(" Address    :"+linkedList.get(counter).getAddress());
            System.out.println(" City       :"+linkedList.get(counter).getCity());
            System.out.println(" State      :"+linkedList.get(counter).getState());
            System.out.println(" Email ID   :"+linkedList.get(counter).getEmail());
            System.out.println(" Zip        :"+linkedList.get(counter).getZip());
            System.out.println(" Phone No   :"+linkedList.get(counter).getPhoneNumber());
        }
    }
    public  void editContactByName()
    {
        System.out.println("Enter the first name that you want to edit in address book");
        String checkName = SCANNER.next();
        for(int counter=0; counter<linkedList.size(); counter++)
        {

            if((linkedList.get(counter).getFirstName()).equals(checkName))
            {
                System.out.println("Enter the first name");
                linkedList.get(counter).setFirstName(SCANNER.next());

                System.out.println("Enter the last name");
                linkedList.get(counter).setLastnames(SCANNER.next());

                System.out.println("Enter the address");
                linkedList.get(counter).setAddress(SCANNER.next());

                System.out.println("Enter the city");
                linkedList.get(counter).setCity(SCANNER.next());

                System.out.println("Enter the state");
                linkedList.get(counter).setState(SCANNER.next());


                System.out.println("Enter the email");
                linkedList.get(counter).setEmail(SCANNER.next());

                System.out.println("Enter the zip");
                linkedList.get(counter).setZip(SCANNER.nextInt());

                System.out.println("Enter the phone number");
                linkedList.get(counter).setPhoneNumber(SCANNER.nextLong());
            }

        }
    }
    public  void removeContactByName()
    {
        System.out.println("Enter the first name that you want to delete contact in address book");
        String checkNameForDelete = SCANNER.next();
        for(int counter=0; counter<linkedList.size(); counter++)
        {

            if((linkedList.get(counter).getFirstName()).equals(checkNameForDelete))
            {
                linkedList.remove(counter);
                System.out.println();
                System.out.println("Delete contact Successful");
            }

        }
    }
    private static void displyByState(String input)
    {
        linkedList.stream()
                .filter(n->n.getState().equals(input))
                .forEach(n-> System.out.println("First name "+n.getFirstName()+
                        "Last name "+n.getLastnames()+
                        "Address "+n.getAddress()+
                        "City "+n.getCity()+
                        "State"+n.getState()+
                        "Email ID"+n.getEmail()+
                        " Zip  "+n.getZip()+
                        "Phone No "+n.getPhoneNumber()
                ));


    }
    private static void displyByCity(String input)
    {
        linkedList.stream()
                .filter(n->n.getCity().equals(input))
                .forEach(n-> System.out.println("First name "+n.getFirstName()+
                        "Last name "+n.getLastnames()+
                        "Address "+n.getAddress()+
                        "City "+n.getCity()+
                        "State"+n.getState()+
                        "Email ID"+n.getEmail()+
                        " Zip  "+n.getZip()+
                        "Phone No "+n.getPhoneNumber()
                ));

    }
    private static void searchByState(String input)
    {
        linkedList.stream()
                .filter(n->n.getState().equals(input))
                .forEach(n-> System.out.println(n.getFirstName()));


    }
    private static void searchByCity(String input)
    {
        linkedList.stream()
                .filter(n->n.getCity().equals(input))
                .forEach(n-> System.out.println(n.getFirstName()));


    }
    public void searchPersonBystateOrCity()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter state or city that you want to search person information (State / City)");
        String choice = scan.next();
        if(choice.equals("State")||(choice.equals("state")))
        {
            System.out.println("Enter state that you want search person information :");
            choice = scan.next();
            searchByState(choice);

        }
        else if((choice.equals("City"))||(choice.equals("city")))
        {
            System.out.println("Enter city that you want search person information :");
            choice = scan.next();
            searchByCity(choice);

        }
        else
        {
            System.out.println("Enter the valid choice");
        }
    }
    public void displayPersonBystateOrCity()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter state or city that you want to search person information (State / City)");
        String choice = scan.next();
        if(choice.equals("State")||(choice.equals("state")))
        {
            System.out.println("Enter state that you want search person information :");
            choice = scan.next();
            displyByState(choice);

        }
        else if((choice.equals("City"))||(choice.equals("city")))
        {
            System.out.println("Enter city that you want search person information :");
            choice = scan.next();
            displyByCity(choice);


        }
        else
        {
            System.out.println("Enter the valid choice");
        }
    }
    public void sortByAlphabeticallyByName()
    {
        List<Contacts> list = linkedList.stream()
                .sorted(Comparator.comparing(n->n.getFirstName()))
                .collect(Collectors.toList());

        Collections.sort(list,Comparator.comparing(Contacts::getFirstName));

        list.stream()
                .forEach(n-> System.out.println(n.toString()));

    }

    public void countBycityAndState()
    {

        Scanner scan = new Scanner(System.in);

        System.out.println("Enter state or city that you want to count person (State / City)");
        String choice = scan.next();
        if(choice.equals("State")||(choice.equals("state")))
        {
            System.out.println("Enter state that you want search person information :");
            displayCountState();



        }
        else if((choice.equals("City"))||(choice.equals("city")))
        {

            displayCountCity();


        }
        else
        {
            System.out.println("Enter the valid choice");
        }
    }
    private static void displayCountCity()
    {

        Map<String, Long> map = linkedList.stream()
                .collect(Collectors.groupingBy(Contacts::getCity , Collectors.counting()));
        System.out.println(map);
    }
    private static void displayCountState()
    {
        Map<String, Long> map = linkedList.stream()
                .collect(Collectors.groupingBy(Contacts::getState , Collectors.counting()));
        System.out.println(map);
    }
    public void sortEntriesByCityStateOrZip()
    {
        Scanner scan = new Scanner(System.in);

        System.out.println("Enter state or city that you want to count person (State / City / Zip)");
        String choice = scan.next();
        if(choice.equals("State")||(choice.equals("state")))
        {
            linkedList.stream()
                    .sorted(Comparator.comparing(n->n.getState()))
                    .forEach(n-> System.out.println(n.toString()));

        }
        else if((choice.equals("City"))||(choice.equals("city")))
        {

            linkedList.stream()
                    .sorted(Comparator.comparing(n->n.getCity()))
                    .forEach(n-> System.out.println(n.toString()));


        }
        else if((choice.equals("Zip"))||(choice.equals("zip")))
        {
            linkedList.stream()
                    .sorted(Comparator.comparing(n->n.getZip()))
                    .forEach(n-> System.out.println(n.toString()));
        }
        else
        {
            System.out.println("Enter the valid choice");
        }

    }

}

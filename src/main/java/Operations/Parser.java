package Operations;

import CustomExceptions.DukeException;

import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

/**
 * A class for handling all parsing for Duke. Makes sure that inputs by the user
 * are properly formatted as parameters for other classes.
 */
public class Parser {
    private Scanner scanner = new Scanner(System.in);

    /**
     * Constructor for the Parser object
     */
    public Parser() {
    }

    /**
     * Returns the command that the user has given Duke.
     * @return command The command given by the user to Duke.
     */
    public String getCommand() {
        String command = scanner.next().toLowerCase();
        return command;
    }

    /**
     * Returns the index number requested by the user for commands like 'done' and 'deleted'
     * @return index Index the user wishes to perform operations on.
     */
    public Integer getIndex() {
        String temp = scanner.nextLine().trim();
        int index = Integer.parseInt(temp);
        return index;
    }

    /**
     * Returns the description the user inputs for tasks. Will not accept empty descriptions
     * @return temp The description that the user has specified for the task. Cannot be null.
     * @throws DukeException If temp is empty.
     */
    public String getDescription() throws DukeException {
        String temp = scanner.nextLine().trim();
        if (temp.equals("")) {
            throw new DukeException();
        }
        return temp;
    }

    /**
     * Returns an array of strings that stores the raw description and date Strings to be stored in Duke.
     * @return array An array of String containing the description and date information. Index 0 stores the description,
     *               index 1 stores the date String.
     */
    public String[] getDescriptionWithDate() {
        String[] array = scanner.nextLine().split(" ", 1);
        return array;
    }

    public String[] getDate(String[] ar) {
        String[] array = ar[0].trim().split("/", 2);
        return array;
    }

    /**
     * Returns an array with the task description stored as well as the duration of the task
     * @return array An array of Strings with description and duration both in index 0 of the array
     */

    public String[] getDescriptionWithDuration() {
        String[] array = scanner.nextLine().split(" ", 1);
        return array;
    }

    /**
     * Takes in the array containing both the description as well as the duration and splitting
     * them up
     * @param ar An array containing botht the description and the duration
     * @return array An array containing the description in the 0th index and the duration in the 1st index
     */
    public String[] getDuration(String[] ar) {
        String[] array = ar[0].trim().split("/", 2);
        return array;
    }

    /**
     * Returns a Date object from a raw date that is stored as a String.
     * If the format of the input string is unacceptable, will throw a DukeException and will not return anything.
     * @param by Input String containing the date information.
     * @return A Date object containing the appropriately formatted date.
     * @throws DukeException If by is not in dd/MM/yyyy HH:mm format
     */
    public Date formatDate(String by) throws DukeException{
        try {
            return new SimpleDateFormat("dd/MM/yyyy HH:mm").parse(by);
        } catch (ParseException e) {
            throw new DukeException();
        }
    }


    /**
     * Returns the keyword to be searched for.
     * @return key A string of the keyword to be searched for
     */
    public String getKey() {
        String key = scanner.nextLine().toLowerCase();
        return key;
    }

    public String getRecurrence() {
        return scanner.nextLine().trim().toLowerCase();
    }
}

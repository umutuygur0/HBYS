//-----------------------------------------------------
// Title: Date class
// Author: UMUT UYGUR
// ID: 13474078970
// Section: 1
// Assignment: 3
// Description: This class represents a Date object and provides
////              comparison methods for date operations.
//-----------------------------------------------------
public class Date implements Comparable<Date>
{
    int year;
    int month;
    int day;

    // constructor
    // Precondition: day, month, and year are valid integers.
    // Postcondition: A Date object is created with the specified values.
    Date (int year, int month, int day)
    {
        this.year = year;
        this.month = month;
        this.day = day;
    }
    // overrides the compareto function to compare the dates
    // Summary: Compares the current Date object with another.
    //A formatted string ("dd/mm/yyyy") is returned.
    @Override
    public int compareTo(Date other) {

        if (this.year>other.year){
            return 1;
        }else if(this.year<other.year){
            return -1;
        }else{
            if (this.month>other.month){
                return 1;
            }else if(this.month<other.month){
                return -1;
            }else{
                if (this.day>other.day){
                    return 1;
                }else if(this.day<other.day){
                    return -1;
                }else{
                    return 0;
                }
            }
        }
    }
}
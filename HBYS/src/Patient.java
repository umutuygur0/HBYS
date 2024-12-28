//-----------------------------------------------------
// Title: Patient class
// Author: UMUT UYGUR
// ID: 13474078970
// Section: 1
// Assignment: 3
// Description: This class stores patient details, including their name,
//              assigned doctor, and care team information.
//-----------------------------------------------------
public class Patient implements Comparable<Patient>
{
    BSTREE<String, MedicalStaff> memberTree = new BSTREE<>(); // medicla staff that are responsible for the patients
    String patientName; // name of the patient
    String doctor; // doctor that is responsible for the patient
    int visitDay, visitMonth, visitYear; // visit date
    Date date; // date object to compare visit dates


    // constructor
    Patient (String patientName, String doctor, int visitDay, int visitMonth, int visitYear)
    {
        this.patientName = patientName;
        this.doctor = doctor;
        this.visitDay = visitDay;
        this.visitMonth = visitMonth;
        this.visitYear = visitYear;
        this.date = new Date(visitYear, visitMonth, visitDay);
    }

    // overriden compare to method that compares the patients according to their names
    @Override
    public int compareTo(Patient other) {
        return this.patientName.compareTo(other.patientName);
    }

    // toString method to change the object into the string
    @Override
    public String toString() {
        return patientName + ", " + visitYear + ", " + doctor;
    }
}

//-----------------------------------------------------
// Title: HospitalDB class
// Author: UMUT UYGUR
// ID: 13474078970
// Section: 1
// Assignment: 3
// Description: This class manages the hospital database using
////              binary search trees to store and retrieve patient data.
//-----------------------------------------------------
public class HospitalDB
{
    BSTREE<String, Patient> patienttree; // the tree contains the patient objects according to their names
    BSTREE<Date, String> yeartree; // tree that organizes the patients according to their visit dates contains date as the key and the first trees key as the value
    // Postcondition: Two BSTREE instances are created for patient and date management.
    HospitalDB() // constructor
    {
        this.patienttree = new BSTREE<>();
        this.yeartree = new BSTREE<>();
    }

    // to add a patient // this method adds patients names, the doctors who are responsible for them and their visit date to a patient object
    // Precondition: patientName, doctorName, and date details are valid.
    // Postcondition: The patient is added to both BSTs.
    public void addPatient(String patientName, String doctor, int visitDay, int visitMonth, int visitYear)
    {
        Patient patient = new Patient(patientName, doctor, visitDay, visitMonth, visitYear); // instantiates the person object
        if (patientName.charAt(patientName.length() - 1) == ' ') // this for the typo mistakes to easily compare to patients if they are the same // it removes the last whitespace of the name string
        {
            patientName = patientName.substring(0, patientName.length() - 1);
        }

        // this statement adds the patients to both of the trees if the patient has not benn added before and prints that the patient is added
        if (patienttree.get(patientName) == null)
        {
            patienttree.put(patientName, patient);
            yeartree.put(patient.date, patientName);
            System.out.println("INFO: Patient " + patientName + " has been added");
        }

        // this statement overwrites the patients who were already added to our binary search tree and prints the overwrite message
        else
        {
            patienttree.put(patientName, patient);
            yeartree.put(patient.date, patientName);
            System.out.println("ERROR: Patient " + patientName +" overwritten");
        }

    }

    // to remove a patient according to their names which is the key of our first tree
    public void removePatient(String patientName)
    {
        // checks the tree is null. if it is not null removes the patient object from both of the lists and prints that it has been successfully removed if the removing process is successful
        if (patienttree.get(patientName) != null) {
            yeartree.delete(patienttree.get(patientName).date);
            patienttree.delete(patientName);

            System.out.println("INFO: Patient " + patientName + " has been removed");
        }

        // if the patient does not exist prints error
        else
        {
            System.out.println("ERROR: Patient " + patientName + " does not exist");
        }
    }

    // to add a medical staff member to the care team of a patient according to patients' names, member names and their roles
    public void addMember(String patientName, String memberName, String memberRole)
    {
        // checks if the patients exist if the patients exists adds the member to the patient
        if (patienttree.get(patientName) != null)
        {
            MedicalStaff staff = new MedicalStaff(memberName, memberRole);
            patienttree.get(patientName).memberTree.put(memberName, staff);
            System.out.println("INFO: " + memberName + " has been added to the patient " + patientName);
            patienttree.get(patientName).memberTree.count++;
        }
        // if the patient does not exist does not add the member
        else {
            System.out.println("ERROR: Patient " + patientName + " does not exist");
        }
    }

    // to remove a medical staff member from the care team of a patient
    public void removeMember(String patientName, String memberName)
    {
        // checks the patient if it exist then removes the member
        if (patienttree.get(patientName) != null)
        {
            // checks the member if exists
            if (patienttree.get(patientName).memberTree.get(memberName) != null) {
                patienttree.get(patientName).memberTree.delete(memberName);
                System.out.println("INFO: " + memberName + " has been removed from the patient " + patientName);
                patienttree.get(patientName).memberTree.count--;
            }
            // if the member does not exist prints the error message
            else
            {
                System.out.println("ERROR: Medical staff member " + memberName + " does not exist for patient " + patientName);
            }
        }
    }

    // to show the list of patients
    public void showAllPatients()
    {
        // checks if the tree is empty // if empty prints none
        if (yeartree.size() == 0) {
            System.out.println("---none---");
        }
        else
        {
            // checks all the tree and prints all the patients according to their visit date
            for (Date key : yeartree.keys())
            {
                System.out.println(patienttree.get(yeartree.get(key)));
            }
        }
    }

    // to show detailed information about a particular patient
    public void showPatient(String patientName)
    {
        // if the tree is not null it prints the patients name, their visit date and the doctor who is responsible for that particukar patient and th careteam
        if (patienttree.get(patientName) != null)
        {
            System.out.println(patientName);
            System.out.println(patienttree.get(patientName).visitDay + "/" + patienttree.get(patientName).visitMonth + "/" + patienttree.get(patientName).visitYear);
            System.out.println(patienttree.get(patientName).doctor);
            // if the careteam of the patient doesnt exist prints none
            if (patienttree.get(patientName).memberTree.count == 0)
            {
                System.out.println("--none--");
            }
            // if the member exist check all the care team members and print them
            for (String key : patienttree.get(patientName).memberTree.keys())
            {
                System.out.println(patienttree.get(patientName).memberTree.get(key));
            }
        }
        // if patient doesnt exist prints none
        else
        {
            System.out.println("--none--");
        }
    }

    // query the patients who were seen by a particular doctor
    public void showDoctorPatients(String doctorName)
    {
        boolean b = false; // checks if the doctor is found

        // search for the doctor in the tree
        for (String key : patienttree.keys())
        {
            if (patienttree.get(key).doctor.equals(doctorName))
            { // prints the doctor if it is found and prints the information about the patient
                if (!b)
                {
                    System.out.println(doctorName);
                    b = true;
                }

                System.out.println(patienttree.get(key).patientName + ", " + patienttree.get(key).visitDay + "/" + patienttree.get(key).visitMonth + "/" + patienttree.get(key).visitYear);
            }
        }

        // if the doctor could not be found prints none
        if (!b)
        {
            System.out.println(doctorName);
            System.out.println("--none--");
        }
    }

    // query the patients who visited in a given year
    public void showPatients(int visitYear)
    {
        System.out.println(visitYear); // first it prints the year we are searching
        // if the tree is empty prints none
        if (yeartree.size() == 0) {
            System.out.println("--none--");
        }
        else
        {
            // to reverse its order we use stack because we want these patients to be in reverse order
            Stack<Patient> stack = new Stack<>();
            for (Date key : yeartree.keys())
            {
                if (key.year == visitYear)
                {
                    stack.push(patienttree.get(yeartree.get(key)));
                }
            }

            // checks if the stack is empty and if it is empty it prints none
            if (stack.isEmpty())
            {
                System.out.println("--none--");
            }

            // prints all the patients while empties the stack
            while (!stack.isEmpty())
            {
                Patient person = stack.pop();
                System.out.println(person.patientName + ", " + person.visitDay + "/" + person.visitMonth);
            }
        }
    }
}
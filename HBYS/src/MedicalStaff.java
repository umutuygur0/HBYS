//-----------------------------------------------------
// Title: MedicalStaff class
// Author: UMUT UYGUR
// ID: 13474078970
// Section: 1
// Assignment: 3
// Description: This class represents the medical staff, storing
//              their name and role in the hospital system.
//-----------------------------------------------------
public class MedicalStaff {
    String memberName;
    String memberRole;

    //--------------------------------------------------------
    // Summary: Constructor to initialize the MedicalStaff object.
    // Precondition: name and role are valid strings.
    // Postcondition: A MedicalStaff object is created with the specified values.
    //--------------------------------------------------------
    MedicalStaff (String memberName, String memberRole)
    {
        this.memberName = memberName;
        this.memberRole = memberRole;
    }

    // toString method to change the object into a String
    @Override
    public String toString()
    {
        return memberName + ", " + memberRole;
    }
}

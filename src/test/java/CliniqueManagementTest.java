import com.clinique_management.CliniqueManagement;
import com.clinique_management.FileSystem;
import com.model.Doctor;
import com.model.Patient;
import org.codehaus.jackson.map.ObjectMapper;
import org.codehaus.jackson.type.TypeReference;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

public class CliniqueManagementTest {

    public static final String doctorfilePath = "C:\\Users\\Blackhawkkk1\\IdeaProjects\\Clinique_Management\\src\\main\\resources\\Doctor.json";
    public static final String patientfilePath = "C:\\Users\\Blackhawkkk1\\IdeaProjects\\Clinique_Management\\src\\main\\resources\\Patient.json";

    FileSystem fileSystem;
    ObjectMapper objectMapper;

    @Before
    public void setUp() {
        fileSystem = new FileSystem();
        objectMapper = new ObjectMapper();

    }

    //TEST CASE 1.1
    @Test
    public void givenFile_whenAddDoctorDelail_shouldReturnTrue() {
        try {
            Doctor doctor1 = new Doctor("Nilesh lad", 1111, "skin", "10am");
            Doctor doctor2 = new Doctor("vaibhav mali", 1515, "Corona", "8am");
            Doctor doctor3 = new Doctor("raju pawar", 3333, "Dentist", "12pm");
            Doctor doctor4 = new Doctor("Akshay pawar", 4444, "Orthopaedics", "6pm");
            Doctor doctor5 = new Doctor("kunal patil", 1112, "Surgery", "9pm");

            CliniqueManagement.addInformation(doctor1, doctorfilePath);
            CliniqueManagement.addInformation(doctor2, doctorfilePath);
            CliniqueManagement.addInformation(doctor3, doctorfilePath);
            CliniqueManagement.addInformation(doctor4, doctorfilePath);
            CliniqueManagement.addInformation(doctor5, doctorfilePath);
            ArrayList<Doctor> data = objectMapper
                    .readValue(new File(doctorfilePath), new TypeReference<ArrayList<Doctor>>() {
                    });
            Assert.assertEquals(doctor1.getName(), data.get(0).getName());
            Assert.assertEquals(doctor2.getName(), data.get(1).getName());
            Assert.assertEquals(doctor3.getName(), data.get(2).getName());
            Assert.assertEquals(doctor4.getName(), data.get(3).getName());
            Assert.assertEquals(doctor5.getName(), data.get(4).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //TEST CASE 1.2
    @Test
    public void givenFile_whenAddPatientDelail_shouldReturnTrue() {
        try {
            Patient patient1 = new Patient("KUMAR PATIL", 1, 888888310299L, 20);
            Patient patient2 = new Patient("AKASH PATIL", 2, 9566116980L, 32);
            Patient patient3 = new Patient("PAWAN RAJUL", 3, 4545454545L, 43);
            Patient patient4 = new Patient("NANDU AABA", 4, 1010101010L, 55);
            Patient patient5 = new Patient("ANSAR SHEKH", 5, 5858585860L, 93);
            CliniqueManagement.addInformation(patient1, patientfilePath);
            CliniqueManagement.addInformation(patient2, patientfilePath);
            CliniqueManagement.addInformation(patient3, patientfilePath);
            CliniqueManagement.addInformation(patient4, patientfilePath);
            CliniqueManagement.addInformation(patient5, patientfilePath);

            ArrayList<Patient> data = objectMapper
                    .readValue(new File(patientfilePath), new TypeReference<ArrayList<Patient>>() {
                    });
            Assert.assertEquals(patient1.getName(), data.get(0).getName());
            Assert.assertEquals(patient2.getName(), data.get(1).getName());
            Assert.assertEquals(patient3.getName(), data.get(2).getName());
            Assert.assertEquals(patient4.getName(), data.get(3).getName());
            Assert.assertEquals(patient5.getName(), data.get(4).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
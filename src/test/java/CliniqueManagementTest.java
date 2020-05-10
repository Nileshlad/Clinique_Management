import com.clinique_management.CliniqueManagement;
import com.clinique_management.FileSystem;
import com.model.Doctor;
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
    FileSystem fileSystem;
    ObjectMapper objectMapper;

    @Before
    public void setUp() {
        fileSystem = new FileSystem();
        objectMapper = new ObjectMapper();

    }

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

}
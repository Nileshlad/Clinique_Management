import com.clinique_management.CliniqueManagement;
import com.clinique_management.FileSystem;
import com.model.Appointment;
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
    public static final String AppointmnetpatientfilePath = "C:\\Users\\Blackhawkkk1\\IdeaProjects\\Clinique_Management\\src\\main\\resources\\Appointmnet.json";

    CliniqueManagement cliniqueManagement;
    FileSystem fileSystem;
    ObjectMapper objectMapper;

    @Before
    public void setUp() {
        cliniqueManagement = new CliniqueManagement();
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

            cliniqueManagement.addInformation(doctor1, doctorfilePath);
            cliniqueManagement.addInformation(doctor2, doctorfilePath);
            cliniqueManagement.addInformation(doctor3, doctorfilePath);
            cliniqueManagement.addInformation(doctor4, doctorfilePath);
            cliniqueManagement.addInformation(doctor5, doctorfilePath);
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

            cliniqueManagement.addInformation(patient1, patientfilePath);
            cliniqueManagement.addInformation(patient2, patientfilePath);
            cliniqueManagement.addInformation(patient3, patientfilePath);
            cliniqueManagement.addInformation(patient4, patientfilePath);
            cliniqueManagement.addInformation(patient5, patientfilePath);

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

    //TEST CASE 1.3
    @Test
    public void givenFile_whenSearchDoctorByName_shouldReturnTrue() {
       try {
           String doctorName = "Nilesh lad";
           boolean isDoctorName = cliniqueManagement.searchDoctorByName(doctorName, doctorfilePath);
           Assert.assertTrue(isDoctorName);
       }catch (NullPointerException e){
           e.printStackTrace();
       }

    }

    //TEST CASE 1.4
    @Test
    public void givenFile_whenSearchDoctorByName_shouldReturnFlase() {
       try {
           String doctorName = "Nil lad";
           boolean isDoctorName = cliniqueManagement.searchDoctorByName(doctorName, doctorfilePath);
           Assert.assertFalse(isDoctorName);
       }catch (NullPointerException e){
           e.printStackTrace();
       }
    }

    //TEST CASE 1.5
    @Test
    public void givenFile_whenSearchDoctorById_shouldReturnTrue() {
        int doctorId = 1111;
        boolean isDoctorId = cliniqueManagement.searchDoctorById(doctorId, doctorfilePath);
        Assert.assertTrue(isDoctorId);
    }

    //TEST CASE 1.6
    @Test
    public void givenFile_whenSearchDoctorById_shouldReturnFlase() {
        int doctorId = 11111;
        boolean isDoctorId = cliniqueManagement.searchDoctorById(doctorId, doctorfilePath);
        Assert.assertFalse(isDoctorId);
    }

    //TEST CASE 1.7
    @Test
    public void givenFile_whenSearchDoctorBySpecialization_shouldReturnTrue() {
        try {
            String doctorSpecialist = "Dentist";
            boolean isDoctorSpecialist = cliniqueManagement.searchDoctorBySpecialization(doctorSpecialist, doctorfilePath);
            Assert.assertTrue(isDoctorSpecialist);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }
    //TEST CASE 1.7
    @Test
    public void givenFile_whenSearchDoctorBySpecialization_shouldReturnFlase() {
        try {
            String doctorSpecialist = "Dentist123";
            boolean isDoctorSpecialist = cliniqueManagement.searchDoctorBySpecialization(doctorSpecialist, doctorfilePath);
            Assert.assertFalse(isDoctorSpecialist);
        } catch (NullPointerException e) {
            e.printStackTrace();
        }

    }

    //TEST CASE 1.8
    @Test
    public void givenFile_whenSearchDoctorByAvailability_shouldReturnTrue() {
        try {
            String doctorAvailability = "12pm";
            boolean isDoctorAvailability = cliniqueManagement.searchDoctorByAvailability(doctorAvailability, doctorfilePath);
            Assert.assertTrue(isDoctorAvailability);
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }
    //TEST CASE 1.9
    @Test
    public void givenFile_whenSearchDoctorByAvailability_shouldReturnFlase() {
        try {
            String doctorAvailability = "152pm";
            boolean isDoctorAvailability = cliniqueManagement.searchDoctorByAvailability(doctorAvailability, doctorfilePath);
            Assert.assertFalse(isDoctorAvailability);
        }catch (NullPointerException e){
            e.printStackTrace();
        }

    }

    //TEST CASE 1.11
    @Test
    public void givenFile_whenSearchPatientByName_shouldReturnTrue() {
        try {
            String patientName = "KUMAR PATIL";
            boolean isPatientName = cliniqueManagement.searchPatientByName(patientName, patientfilePath);
            Assert.assertTrue(isPatientName);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    //TEST CASE 1.12
    @Test
    public void givenFile_whenSearchPatientByName_shouldReturnFlase() {
        try {
            String patientName = "KUMARPATIL";
            boolean isPatientName = cliniqueManagement.searchPatientByName(patientName, patientfilePath);
            Assert.assertFalse(isPatientName);
        }catch (NullPointerException e){
            e.printStackTrace();
        }
    }

    //TEST CASE 1.13
    @Test
    public void givenFile_whenSearchPatientById_shouldReturnTrue() {
        int id = 2;
        boolean isId = cliniqueManagement.searchPatientById(id, patientfilePath);
        Assert.assertTrue(isId);
    }

    //TEST CASE 1.14
    @Test
    public void givenFile_whenSearchPatientById_shouldReturnFlase() {
        int id = 20;
        boolean isId = cliniqueManagement.searchPatientById(id, patientfilePath);
        Assert.assertFalse(isId);
    }

    //TEST CASE 1.15
    @Test
    public void givenFile_whenSearchPatientByMobileNumber_shouldReturnTrue() {
        long mobileNumber = 9566116980L;
        boolean isPatientName = cliniqueManagement.searchPatientByMobileNumber(mobileNumber, patientfilePath);
        Assert.assertTrue(isPatientName);
    }

    //TEST CASE 1.16
    @Test
    public void givenFile_whenSearchPatientByMobileNumber_shouldReturnFalse() {
        long mobileNumber = 919566116980L;
        boolean isPatientName = cliniqueManagement.searchPatientByMobileNumber(mobileNumber, patientfilePath);
        Assert.assertFalse(isPatientName);
    }

    //TEST CASE 1.18
    @Test
    public void givenFile_whenAppointmentDelail_shouldReturnTrue() {
        try {
            Appointment appointment1 = new Appointment("Nilesh lad","kunal patil","10am");
            Appointment appointment2 = new Appointment("vaibhav mali", "shankar khare", "8am");
            Appointment appointment3 = new Appointment("raju pawar", "kushal lad", "12pm");
            Appointment appointment4 = new Appointment("Akshay pawar","pawan patil", "6pm");

            cliniqueManagement.addInformation(appointment1, doctorfilePath);
            cliniqueManagement.addInformation(appointment2, doctorfilePath);
            cliniqueManagement.addInformation(appointment3, doctorfilePath);
            cliniqueManagement.addInformation(appointment4, doctorfilePath);
            ArrayList<Doctor> data = objectMapper
                    .readValue(new File(AppointmnetpatientfilePath), new TypeReference<ArrayList<Doctor>>() {
                    });
            Assert.assertEquals(appointment1.getDoctorName(), data.get(0).getName());
            Assert.assertEquals(appointment2.getDoctorName(), data.get(1).getName());
            Assert.assertEquals(appointment3.getDoctorName(), data.get(2).getName());
            Assert.assertEquals(appointment4.getDoctorName(), data.get(3).getName());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

}
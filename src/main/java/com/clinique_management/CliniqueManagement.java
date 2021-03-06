package com.clinique_management;


import com.model.Doctor;
import com.model.Patient;
import com.service.ICliniqueManagementService;

import java.io.IOException;
import java.util.ArrayList;

public class CliniqueManagement implements ICliniqueManagementService {

   //object
    FileSystem fileSystem = new FileSystem();

    //add information in patient and doctor
    @Override
    public <E> void addInformation(E data, String filePath) {
        try {
            ArrayList<E> readData = fileSystem.readFile(filePath);
            readData.add(data);
            fileSystem.writeFile(readData, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //search information in  doctor name
    @Override
    public boolean searchDoctorByName(String doctorName, String filePath) {
        try {
            ArrayList<Doctor> readData = fileSystem.readDoctorFile(filePath);
            for (Doctor doctorsData : readData) {
                if (doctorsData.getName().equals(doctorName))
                    return true;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    // search information in doctor id
    @Override
    public boolean searchDoctorById(int doctorId, String doctorfilePath) {
        try {
            ArrayList<Doctor> readData = fileSystem.readDoctorFile(doctorfilePath);
            for (Doctor doctorsData : readData) {
                if (doctorsData.getId() == doctorId) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //search information in doctor specialization
    @Override
    public boolean searchDoctorBySpecialization(String doctorSpecialist, String doctorfilePath) {
        try {
            ArrayList<Doctor> readData = fileSystem.readDoctorFile(doctorfilePath);
            for (Doctor doctorsData : readData) {
                if (doctorsData.getSpecialization().equals(doctorSpecialist)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //search doctor by  availability
    @Override
    public boolean searchDoctorByAvailability(String doctorAvailability, String doctorfilePath) {
        try {
            ArrayList<Doctor> readData = fileSystem.readDoctorFile(doctorfilePath);
            for (Doctor doctorsData : readData) {
                if (doctorsData.getAvailability().equals(doctorAvailability)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //search Patient By Name
    @Override
    public boolean searchPatientByName(String patientName, String patientFilePath) {
        try {
            ArrayList<Patient> readData = fileSystem.readPatientFile(patientFilePath);
            for (Patient patientData : readData) {
                if (patientData.getName().equals(patientName)) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //search Patient By Mobile Number
    public boolean searchPatientByMobileNumber(long mobileNumber, String patientfilePath) {
        try {
            ArrayList<Patient> readData = fileSystem.readPatientFile(patientfilePath);
            for (Patient patientData : readData) {
                if (patientData.getMobileNumbre() == mobileNumber) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    public boolean searchPatientById(int id, String patientfilePath) {
        try {
            ArrayList<Patient> readData = fileSystem.readPatientFile(patientfilePath);
            for (Patient patientData : readData) {
                if (patientData.getId() == id) {
                    return true;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return false;
    }

    //
    @Override
    public boolean viewReport(Patient patient, String patientFilePath) throws IOException {
        ArrayList<Patient> patientArrayList = fileSystem.readFile(patientFilePath);
        for (Patient patient1 : patientArrayList) {
            if (patient1.getName().equalsIgnoreCase(patient.getName()))
            {
                                return true;
            }
        }
        return false;
    }
}

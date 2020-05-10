package com.clinique_management;


import com.model.Doctor;
import com.model.Patient;
import com.service.ICliniqueManagementService;

import java.io.IOException;
import java.util.ArrayList;

public class CliniqueManagement implements ICliniqueManagementService {


    @Override
    public static <E> void addInformation(E data, String filePath) {
        try {
            FileSystem fileSystem = new FileSystem();
            ArrayList<E> readData = fileSystem.readFile(filePath);
            readData.add(data);
            fileSystem.writeFile(readData, filePath);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

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
}

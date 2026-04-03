package com.chandru.Stream_API_Hospital_Patient.model;

import java.util.*;
import java.util.stream.Collectors;

public class PatientService {

	// 1. Get all admitted patients
	public List<Patient> getAdmittedPatients(List<Patient> list) {
		return list.stream().filter(Patient::getAdmitted).collect(Collectors.toList());
	}

	// 2. Group by disease
	public Map<String, List<Patient>> getGroupByDisease(List<Patient> list) {
		return list.stream().collect(Collectors.groupingBy(Patient::getDisease));
	}

	// 3. Count admitted vs non-admitted
	public Map<Boolean, List<Patient>> getAdmittedVsNonAdmitted(List<Patient> list) {
		return list.stream().collect(Collectors.partitioningBy(Patient::getAdmitted));
	}

	// 4. Highest bill patient
	public Optional<Patient> getPatientWithHighestBill(List<Patient> list) {
		return list.stream().max(Comparator.comparingDouble(Patient::getAmount));
	}

	// 5. Average bill amount
	public double getAverageBillAmount(List<Patient> list) {
		return list.stream().collect(Collectors.averagingDouble(Patient::getAmount));
	}

	// 6. Names of patients above age 60
	public List<String> getPatientNamesAbove60(List<Patient> list) {
		return list.stream().filter(p -> p.getAge() > 60).map(Patient::getName).collect(Collectors.toList());
	}

	// 7. Map disease -> list of patient names
	public Map<String, List<String>> getDiseaseToPatientNames(List<Patient> list) {
		return list.stream().collect(
				Collectors.groupingBy(Patient::getDisease, Collectors.mapping(Patient::getName, Collectors.toList())));
	}
}

//package com.chandru.Stream_API_Hospital_Patient.model;
//
//import java.util.List;
//import java.util.Map;
//import java.util.stream.Collectors;
//
//public class PatientService {
//	// 1.get all admitted patients
//	public List<Patient> getAdmittedPatients(List<Patient> list) {
//		return list.stream().filter(Patient::getAdmitted).collect(Collectors.toList());
//	}
//
//	// 2.group patients by the disease
//	public Map<String, List<Patient>> getGroupByDesiase(List<Patient> list) {
//		return list.stream().collect(Collectors.groupingBy(Patient::getDisease));
//	}
//
//	// 3.get the admitted vs non-admitted patient
//	public long getAdmittedNonAdmitted(List<Patient>list){
//		return list.stream().filter(Patient::getAdmitted).count();
//		
//	//4.find the patient with the highest bill
//	public Optional<Patient>getPatientWithHighestBill(List<Patient>list){
//		return list.stream().max(Comparator.comparingDouble(Product::getPrice));
//	}
//	
//	//5.calculate average bill amount
//	public List<Patient> getAverageBillAmount(List<Patient>list){
//		return list.stream().collect(Collector.averagingDouble(Patient::getPrice));
//	}
//	
//	//6.get the name of the patient above 60
//	public List<Patient> getPatientNameAbove60Age(List<Patient>list){
//		return list.stream().filter(p->p.getAge()>60);
//	}
//	
//	//7.create a map of disease to list of patient name
//	public Map<String,String> getDiseaseName(List<Patient>list){
//		return list.stream().collect(Collectors.groupingBy(Patient::getDisease)).collect(Collector.collect(Patient::getName));
//	}
//	}
//
//}

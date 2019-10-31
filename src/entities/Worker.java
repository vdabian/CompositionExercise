package entities;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import entities.enums.workerLevel;

public class Worker {

	private String name;
	private workerLevel level;
	private Double baseSalary;
	private Departament departament;
	private List<HourContract> contracts = new ArrayList<>();
	
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public workerLevel getLevel() {
		return level;
	}

	public void setLevel(workerLevel level) {
		this.level = level;
	}

	public Double getBaseSalary() {
		return baseSalary;
	}

	public void setBaseSalary(Double baseSalary) {
		this.baseSalary = baseSalary;
	}

	public Departament getDepartament() {
		return departament;
	}

	public void setDepartament(Departament departament) {
		this.departament = departament;
	}

	public List<HourContract> getContracts() {
		return contracts;
	}

	public Worker() {
		
	}

	public Worker(String name, workerLevel level, Double baseSalary, Departament departament) {
		this.name = name;
		this.level = level;
		this.baseSalary = baseSalary;
		this.departament = departament;
	}
	
	public void addContract(HourContract contract) {
		contracts.add(contract);
	}
	
	public void removeContract(HourContract contract) {
		contracts.remove(contract);
	}
	
	public void income(int year, int month) {
		double sum = baseSalary;
		Calendar cal = Calendar.getInstance();
		for (HourContract c : contracts) {
			cal.setTime(c.getDate());
			int c_year = cal.get(Calendar.YEAR);
		    int c_month = cal.get(Calendar.MONTH);
			if (year == c_year && month == c_month) {
				sum += c.TotalValue();
			}
		}
		
	}
	
}

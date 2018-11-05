package com.cg.payroll.beans;

import javax.persistence.Embeddable;

@Embeddable
public class Salary {
	private double basicSalary, hra, conveyenceAllowance, otherAllowance, personalAllowance;
	private double monthlyTax, epf, companyPf, gratuity, grossSalary, netSalary;
	
	public Salary() {
		super();
	}
	
	public Salary(double basicSalary, double epf, double companyPf,
			double gratuity) {
		super();
		this.basicSalary = basicSalary;
		this.epf = epf;
		this.companyPf = companyPf;
		this.gratuity = gratuity;
	}
	
	public Salary(double basicSalary, double epf, double companyPf) {
		super();
		this.basicSalary = basicSalary;
		this.epf = epf;
		this.companyPf = companyPf;
	}	

	public Salary(double basicSalary, double hra, double conveyenceAllowance,
			double otherAllowance, double personalAllowance, double monthlyTax,
			double epf, double companyPf, double gratuity, double grossSalary,
			double netSalary) {
		super();
		this.basicSalary = basicSalary;
		this.hra = hra;
		this.conveyenceAllowance = conveyenceAllowance;
		this.otherAllowance = otherAllowance;
		this.personalAllowance = personalAllowance;
		this.monthlyTax = monthlyTax;
		this.epf = epf;
		this.companyPf = companyPf;
		this.gratuity = gratuity;
		this.grossSalary = grossSalary;
		this.netSalary = netSalary;
	}

	public double getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(double basicSalary) {
		this.basicSalary = basicSalary;
	}

	public double getHra() {
		return hra;
	}

	public void setHra(double hra) {
		this.hra = hra;
	}

	public double getConveyenceAllowance() {
		return conveyenceAllowance;
	}

	public void setConveyenceAllowance(double conveyenceAllowance) {
		this.conveyenceAllowance = conveyenceAllowance;
	}

	public double getOtherAllowance() {
		return otherAllowance;
	}

	public void setOtherAllowance(double otherAllowance) {
		this.otherAllowance = otherAllowance;
	}

	public double getPersonalAllowance() {
		return personalAllowance;
	}

	public void setPersonalAllowance(double personalAllowance) {
		this.personalAllowance = personalAllowance;
	}

	public double getMonthlyTax() {
		return monthlyTax;
	}

	public void setMonthlyTax(double monthlyTax) {
		this.monthlyTax = monthlyTax;
	}

	public double getEpf() {
		return epf;
	}

	public void setEpf(double epf) {
		this.epf = epf;
	}

	public double getCompanyPf() {
		return companyPf;
	}

	public void setCompanyPf(double companyPf) {
		this.companyPf = companyPf;
	}

	public double getGratuity() {
		return gratuity;
	}

	public void setGratuity(double gratuity) {
		this.gratuity = gratuity;
	}

	public double getGrossSalary() {
		return grossSalary;
	}

	public void setGrossSalary(double grossSalary) {
		this.grossSalary = grossSalary;
	}

	public double getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(double netSalary) {
		this.netSalary = netSalary;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(basicSalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(companyPf);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(conveyenceAllowance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(epf);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(gratuity);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(grossSalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(hra);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(monthlyTax);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(netSalary);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(otherAllowance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(personalAllowance);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Salary other = (Salary) obj;
		if (Double.doubleToLongBits(basicSalary) != Double
				.doubleToLongBits(other.basicSalary))
			return false;
		if (Double.doubleToLongBits(companyPf) != Double
				.doubleToLongBits(other.companyPf))
			return false;
		if (Double.doubleToLongBits(conveyenceAllowance) != Double
				.doubleToLongBits(other.conveyenceAllowance))
			return false;
		if (Double.doubleToLongBits(epf) != Double.doubleToLongBits(other.epf))
			return false;
		if (Double.doubleToLongBits(gratuity) != Double
				.doubleToLongBits(other.gratuity))
			return false;
		if (Double.doubleToLongBits(grossSalary) != Double
				.doubleToLongBits(other.grossSalary))
			return false;
		if (Double.doubleToLongBits(hra) != Double.doubleToLongBits(other.hra))
			return false;
		if (Double.doubleToLongBits(monthlyTax) != Double
				.doubleToLongBits(other.monthlyTax))
			return false;
		if (Double.doubleToLongBits(netSalary) != Double
				.doubleToLongBits(other.netSalary))
			return false;
		if (Double.doubleToLongBits(otherAllowance) != Double
				.doubleToLongBits(other.otherAllowance))
			return false;
		if (Double.doubleToLongBits(personalAllowance) != Double
				.doubleToLongBits(other.personalAllowance))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Salary [basicSalary=" + basicSalary + ", hra=" + hra + ", conveyenceAllowance=" + conveyenceAllowance + ", otherAllowance=" + otherAllowance + ", personalAllowance=" + personalAllowance + ", monthlyTax=" + monthlyTax + ", epf=" + epf + ", companyPf=" + companyPf + ", gratuity=" + gratuity + ", grossSalary=" + grossSalary + ", netSalary=" + netSalary + "]";
	}
	
	
}

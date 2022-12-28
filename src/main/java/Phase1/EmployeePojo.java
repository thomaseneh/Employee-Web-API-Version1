package Phase1;

import java.util.Objects;

public class EmployeePojo implements Comparable<EmployeePojo>{
	int id;
	String name;
	String email;
	String department;
	
	public EmployeePojo() {
		super();
	}

	
	
	public EmployeePojo(int id, String name, String email, String department) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.department = department;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	public String getDepartment() {
		return department;
	}



	public void setDepartment(String department) {
		this.department = department;
	}



	@Override
	public String toString() {
		return "EmployeePojo [id=" + id + ", name=" + name + ", email=" + email + ", department=" + department + "]";
	}



	@Override
	public int hashCode() {
		return Objects.hash(department, email, id, name);
	}



	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		EmployeePojo other = (EmployeePojo) obj;
		return Objects.equals(department, other.department) && Objects.equals(email, other.email) && id == other.id
				&& Objects.equals(name, other.name);
	}



	@Override
	public int compareTo(EmployeePojo others) {
		return this.id - others.id;
	}

	
}

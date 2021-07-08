package entities;

public class Employee {
	
	//atributos:
	private Integer id;
	private String name;
	private Double salary;
	
	//construtores:
	public Employee () {
		
	}
	
	public Employee (Integer id, String name, Double salary) {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}
	
	// métodos get e set:
	
	//get (p/ aceder o atributo)
	public Integer getId() {
		return id;
	}
	
	//set ( p/ alterar o atributo)
	public void setId (Integer id) {
		this.id = id;
	}
	
	public String getName () {
		return name;
	}
	
	public void setName (String name) {
		this.name = name;
	}
	
	public Double getSalary () {
		return salary;
	}
	
	public void setSalary (Double salary) {
		this.salary = salary;
	}
	
	
	//métodos:
	//aumentar salário:
	public void increaseSalary (double percentage) {
		salary = salary + salary * percentage/100;
	}
	 
	public String toString() {
		return id + ", " + name + ", " + String.format("%.2f", salary);
		
	}

}

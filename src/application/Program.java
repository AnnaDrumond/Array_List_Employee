package application;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;
import java.util.Scanner;

import entities.Employee;

public class Program {

	public static void main(String[] args) {
		// aula 94 - 96 - listas.
		//https://www.youtube.com/watch?v=Xj-osdBe3TE

		Locale.setDefault(Locale.US);
		Scanner sc = new Scanner(System.in);

		// PART 1 - LENDO OS DADOS:

		// este "list" � o nome da vari�vel que podia ser qualquer outro nome.
		List<Employee> list = new ArrayList<>();

		System.out.print("How many employees will be registered? ");
		int quantity = sc.nextInt();

		for (int i = 1; i <= quantity; i++) {
			
			System.out.println("\nEmplyoee #" + i + ":");
			System.out.print("Id: ");
			Integer id = sc.nextInt();
			
			while (hasId(list, id)) {
				System.out.print("Id already taken. Try again: ");
				id = sc.nextInt();
			}
			
			System.out.print("Name: ");
			sc.nextLine();
			String name = sc.nextLine();
			System.out.print("Salary: ");
			Double salary = sc.nextDouble();
			
			// Primeiro, vou criar um objeto employee e instanciar o mesmo na mem�ria, com os dados id, name e salary
			Employee employee = new Employee(id, name, salary);
			list.add(employee);
			// ou poderia usar : list.add(new Employee(id, name, salary));

		}

		// PART 2 - ATUALIZANDO SAL�RIO DO FUNCION�RIO ESCOLHIDO:

		System.out.println("\nEnter the employee id that will have salary increase : ");
		int idSalary = sc.nextInt();
		
		Employee employee = list.stream().filter(x -> x.getId() == idSalary).findFirst().orElse(null);
		/*
		 * Preciso declararar uma vari�vel do tipo Employee //vou converter a lista para
		 * stream (que aceita express�es com opera��es lambda)- depois coloco um filter
		 * para receber o predicado - E depois entra o comando - depois entra o comando
		 * para achar o 1� elemento, que � o findFirst Este comando retorna um
		 * "optional string", depois entra o orElse, para se o elemento que eu busco nao
		 * existir, me retornar "null"
		 */

		if (employee == null) {
			System.out.println("This id does not exist!");
		} else {
			System.out.println("Enter the percentage: ");
			double percentage = sc.nextDouble();
			employee.increaseSalary(percentage);
		}
		
		/* Se eu usar a fun��o que est� no coment�rio de bloco, aqui ao inv�s do comando acima
		 * eu terei de usar:
		 * int idSalary = sc.nextInt();
		 * Integer position = positionId(list, idSalary);
		 * if (position == null){
		 * 	   System.out.println("This id does not exist!");
		 * } else {
		 * 	   System.out.println("Enter the percentage: ");
				double percentage = sc.nextDouble();
				list.get(position).increaseSalary(percentage);
		 * }
		 */

		// PART 3 - LISTANDO EMPREGADOS:
		System.out.println("\nList of employees:");

		// Agora um for each para exibir/imprimir a lista final:
		for (Employee object : list) {
			System.out.println(object);
		}

		sc.close();
	}

	// esta vari�vel list abaixo, n�o se confunde com a que tem dentro do main, s�o escopos diferentes e por isso vari�veis diferentes
	public static boolean hasId(List<Employee> list, int id) {
		Employee emp = list.stream().filter(x -> x.getId() == id).findFirst().orElse(null);
		return emp != null;
	}
	
	/* Esta fun��o poderia ser usada no lugar da linha 56.
	 * 
	 * public Integer positionId(List <Employee> list, in id){
	 * 		for (int i = 0 ; i < list.size(); i++){
	 *           if (list.get(i).getId() == id){
	 *           // o get � para pegar o elemento da posi��o i da lista, e o getID � para pegar o id deste elemento//
	 * 				return i;
	 * 			 }
	 *  	}
	 *  	return null;
	 *  }
	 */

}

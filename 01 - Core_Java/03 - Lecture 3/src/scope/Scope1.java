package scope;

public class Scope1 {

	public static void main(String[] args) {
		
		/*
		 * 1. Use a variable after initiating or atleast declaring(Java does not initialize variables automatically with default garbage values) it.
		 * 2. We cannot declare more than one local variables with same name
		 * 3. Name of local and global variables should not be same
		 * 4. If a variable name is used in the global varaible, we can not use it in local varaibles inside the global scope
		 * 5. We can use the same variable name once the scope of previous variable has ended
		 * 6. Java does not allow to reuse a variable name unless it's scope has ended
		 */
		
		int i; // scope of i is the whole main method and we can not declare it again in the main method's scope. Not even in any local scope
		// Java allocated a 4 byte memory(int) and then named it 'i'. This 4 byte memory is our actual variable which we call 'i'
		i = 10; // Java did not put any garabage value as default in our variable. Now, after initializing it with 10, java put 10 in our variable
		// variable is actually the storage which we give name to using variable names
		// So, uninitialized variables does not hold any values
		
		if(i == 10) {
//			int i = 232; // cannot use this i as i is already used to declare another variable in the outer scope
			// We cannot use any name for our variable that can cause confusion between variables of outer, inner and current scope
			// If the scopes are not related to each other, then we can use it.
			int n = 23; // n is a local variable in this if() scope. Outside the scope it is not valid;
			System.out.println(n);
		} else {
			int n = 230; // It is valid
			System.out.println(n);
		}
		
		if(i == 10) {
			int n = 20; // It is allowed as the previous if() scope is not related to this one
			System.out.println(n);
		}
		
		int n = 4; // This is valid, since the scope of previous n's(local variables) has ended and java will not get confused as previous n's are not there.
		// So, it knows which n to use
		System.out.println(n);
		
		i = 1;
		while(i <= n) {
			int j = 1;
			while(j <= i) {
				System.out.print(j);
				j++;
			}
			System.out.println();
			i++;
		}
//		for(int i = 1; i <= 10; i++) { // here too i is not allowed to be re declared
//			System.out.println(i + " ");
//		}

	}

}

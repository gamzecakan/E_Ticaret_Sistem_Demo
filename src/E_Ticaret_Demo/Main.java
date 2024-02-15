package E_Ticaret_Demo;

		public class Main {
		    public static void main(String[] args) {
		        UserManager userManager = new UserManager();
		
		        userManager.register("Rabia", "Çakmak", "rabiacakmak@douloop.com", "98765"); // success
		        userManager.register("Zeynep", "Varilci", "zeynepvarilci@douloop.com", "12345");
		        userManager.register("Gamze","Çakan", "gamzecakan@douloop.com","123456");
		        userManager.login("tubacakan@douloop.com","123456");
		    }
		}

	

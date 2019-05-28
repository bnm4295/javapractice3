package NoNameTel;
import java.util.*;
import java.io.*;

public class Manage {


	public static void main(String[] args) throws IOException {
		// To change location of the text file
		String file_name = "C:\\Users\\David\\Desktop\\ProvincialDirectory.txt";

		ReadFile file = new ReadFile(file_name);
		String[] dir = file.OpenFile();
		BST<String, Region> w = new BST();
		BST<String, DirectoryEntry> v = new BST();
		BST<String, DirectoryEntry> k = new BST();
		BST<String, DirectoryEntry> n = new BST();
		BST<String, DirectoryEntry> all = new BST();

		// Put the text file data into a BST
		for (int j = 0; j < dir.length; j++) {
			if (j == 1 || j == 8 || j == 15) {
				w.insert((dir[j].substring(0, 25)).trim(),(new Region(dir[j].substring(26, 29))));
			} else if (j > 1 && j <= 6) {
				all.insert((dir[j].substring(0, 13)).trim(),
						(new DirectoryEntry((dir[j]).substring(14, 23),(dir[j]).substring(24, 43), (dir[j]).substring(44, 58), (dir[j]).substring(59, 67))));
				v.insert((dir[j].substring(0, 13)).trim(),
						(new DirectoryEntry((dir[j]).substring(14, 23),(dir[j]).substring(24, 43), (dir[j]).substring(44, 58), (dir[j]).substring(59, 67))));
			} else if (j > 8 && j <= 13) {
				all.insert((dir[j].substring(0, 13)).trim(),
						(new DirectoryEntry((dir[j]).substring(14, 23),(dir[j]).substring(24, 43), (dir[j]).substring(44, 58), (dir[j]).substring(59, 67))));
				k.insert((dir[j].substring(0, 13)).trim(),
						(new DirectoryEntry((dir[j]).substring(14, 23),(dir[j]).substring(24, 43), (dir[j]).substring(44, 58), (dir[j]).substring(59, 67))));
			} else if (j > 15 && j <= 16) {
				all.insert((dir[j].substring(0, 13)).trim(),
						(new DirectoryEntry((dir[j]).substring(14, 23),(dir[j]).substring(24, 43), (dir[j]).substring(44, 58), (dir[j]).substring(59, 67))));
				n.insert((dir[j].substring(0, 13)).trim(),
						(new DirectoryEntry((dir[j]).substring(14, 23),(dir[j]).substring(24, 43), (dir[j]).substring(44, 58), (dir[j]).substring(59, 67))));
			}
		}

		Scanner scan = new Scanner(System.in);

		int q = 0;

		while (q == 0) {// Infinite while loop until argument changes
			// Menu Interface
			System.out
					.println("\nWelcome to the Provincial Directory. Enter\n1 To print all customers in Province\n2 To view area codes in the Province\n"
							+ "3 To select Metro-Area Directory\n4 To view customers of Metro-Area directory in Province\n5 Exit");
			System.out.println();
			int i = scan.nextInt();

			if (i < 1 || i > 5) {// Checks range
				System.out.println('\n' + "Error in Input. Enter one of the following.");
			}
			if (i == 1) { // sort the whole provincial directory
				all.inOrderTraversal();
			}

			if (i == 2) {// sort the metro area codes
				w.inOrderTraversal();
			}

			if (i == 3) {//Changes information within specific metro areas
				String metroArea = "";
				System.out.println("Enter Name of Metro area : ");
				metroArea = scan.next();
				if (w.check(metroArea) == true) {// check if metro area given is within the BST
					int z = 0;
					while (z == 0) {// Infinite while loop until argument changes
						// Menu option for metro area
						System.out.println("\nWelcome to the "
										+ metroArea
										+ " Directory. Enter\n1 To add new customer\n2 To change phone number\n"
										+ "3 To delete customer\n4 To print the metro area\n5 To print a customer\n6 To exit");
						int l = scan.nextInt();
							InputStreamReader reader = new InputStreamReader(System.in);
							BufferedReader console = new BufferedReader(reader);
				            if(l<1 || l>6){//Checks range
				                System.out.println('\n' + "Error in Input. Enter one of the following.");
				                }
							if (l == 1) { // Add new customer to metro area
								System.out.println("Please input name: ");
								String name = console.readLine();
								if (metroArea.equals("Vancouver") && (name.equals("Who") || v.check(name)==false)){
									System.out.println("Please input initials: ");
									String initial = console.readLine();
									System.out.println("Please input telephone number: ");
									String telephone = console.readLine();
									System.out.println("Please input the address ");
									String address = console.readLine();
									System.out.println("Please input the city");
									String city = console.readLine();
									all.insert(name, new DirectoryEntry(initial, telephone, address,city));
									v.insert(name, new DirectoryEntry(initial, telephone, address,city));		
								}else if(metroArea.equals("Kelowna") && k.check(name) == false){
									System.out.println("Please input initials: ");
									String initial = console.readLine();
									System.out.println("Please input telephone number: ");
									String telephone = console.readLine();
									System.out.println("Please input the address ");
									String address = console.readLine();
									System.out.println("Please input the city");
									String city = console.readLine();
									all.insert(name, new DirectoryEntry(initial, telephone, address,city));
									k.insert(name, new DirectoryEntry(initial, telephone, address,city));
								}else if(metroArea.equals("Nelson") && n.check(name) == false ){
									System.out.println("Please input initials: ");
									String initial = console.readLine();
									System.out.println("Please input telephone number: ");
									String telephone = console.readLine();
									System.out.println("Please input the address ");
									String address = console.readLine();
									System.out.println("Please input the city");
									String city = console.readLine();
									all.insert(name, new DirectoryEntry(initial, telephone, address,city));
									n.insert(name, new DirectoryEntry(initial, telephone, address,city));	
								}else {
									System.out.println("Customer is not in directory.");
								}
								
							}else if(l==2){// Edit telephone number
								System.out.println("Please input name: ");
								String name = console.readLine();	
								System.out.println("Please input new telephone number: ");
								String telephone = console.readLine();
								if(metroArea.equals("Vancouver")){
									all.get(name).setTelephone(telephone);
									v.get(name).setTelephone(telephone);
								}else if(metroArea.equals("Kelowna")){
									all.get(name).setTelephone(telephone);
									k.get(name).setTelephone(telephone);
								}else if(metroArea.equals("Nelson")){
									all.get(name).setTelephone(telephone);
									n.get(name).setTelephone(telephone);
								}																		
							}else if(l==3){// delet customer information
								System.out.println("Please input name: ");
								String name = console.readLine();
								if(metroArea.equals("Vancouver") && v.check(name)==true){
									all.delete(name);
									v.delete(name);
								}else if(metroArea.equals("Kelowna") && k.check(name)==true){
									all.delete(name);
									k.delete(name);
								}else if(metroArea.equals("Nelson") && n.check(name)==true){
									all.delete(name);
									n.delete(name);
								}else{
									System.out.println("Customer does not exist. ");
								}
								
							}else if(l==4){ // print specific metro area directory
								if(metroArea.compareTo("Vancouver")==0){
									v.inOrderTraversal();
								}else if(metroArea.compareTo("Kelowna")==0){
									k.inOrderTraversal();
								}else if(metroArea.compareTo("Nelson")==0){
									n.inOrderTraversal();
								}	
							}else if(l==5){// search for a specific customer within metro area
								System.out.println("Please input name: ");
								String name = console.readLine();	
								if(metroArea.equals("Vancouver")){
									v.search(name);
								}else if(metroArea.equals("Kelowna")){
									k.search(name);
								}else if(metroArea.equals("Nelson")){
									n.search(name);
								}												
								
							}else if(l==6){
								z=1;
							}
						}
				}else{
					System.out.println("Directory not found");
				}
		}
	



			if (i==4){// sort customer within each metro area and print it all out
				w.search("Kelowna");
				k.inOrderTraversal();
				w.search("Nelson");
				n.inOrderTraversal();
				w.search("Vancouver");
				v.inOrderTraversal();
			}
			if (i == 5) {// Infinite while loop terminates after k=1
				q = 1;
			}

		}
	}
}

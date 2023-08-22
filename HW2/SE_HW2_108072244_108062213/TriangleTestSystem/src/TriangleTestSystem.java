import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;
public class TriangleTestSystem {
	private static int a;
	private static int b;
	private static int c;
	public static void main(String[] args) {
		while (true){
			String str;
			while(true) {
				System.out.println("Would you like to leave?(y/n)");
				Scanner myObj=new Scanner(System.in);
				str=myObj.nextLine();
				if(str.equals("y") || str.equals("n"))break;
			}
			if(str.equals("y"))break;
			System.out.println("Please input the value of a:");
			a=GetInput();
			System.out.println("Please input the value of b:");
			b=GetInput();
			System.out.println("Please input the value of c:");
			c=GetInput();
			if(!checkLen(a,b,c))continue;
			checkTriangle(a,b,c);
		}
		System.out.println("Thank you! Bye!");
	}
	/*Check whether three sides are in the permitted value range
	 *@param a, b, c
	 *@return true if all three sides are legal, false if at least one of three sides is illegal
	 *Example: checkLen(-1,5,10): return false
	 *Time Estimate:O(n)
	 */
	public static boolean checkLen(int a,int b,int c) {
		int cnt=0;
		ArrayList arr = new ArrayList();
		if(a<1 || a>200) {
			arr.add("a");
			cnt+=1;
		}
		if(b<1 || b>200) {
			arr.add("b");
			cnt+=1;
		}
		if(c<1 || c>200) {
			arr.add("c");
			cnt+=1;
		}
		if(cnt>1) {
			Iterator it = arr.iterator();
			System.out.print("Values of ");
			while(it.hasNext()) {
				System.out.print(it.next());
				if(it.hasNext())System.out.print(", ");
			}
			System.out.println(" are not in the range of permitted value.");
			return false;
		}else if(cnt==1) {
			Iterator it = arr.iterator();
			System.out.print("Value of ");
			System.out.print(it.next());
			System.out.println(" is not in the range of permitted value.");
			return false;
		}else {
			return true;
		}
	}
	/*Given the three sides, check which kind of triangles is belong to
	 *@param a, b, c
	 *@return no return value
	 *Example: checkTriangle(5,5,10): output error message("NotATriangle"), checkTriangle
	 *Time Estimate:O(1)
	 */
	public static void checkTriangle(int a,int b,int c) {
		if(a+b<=c || a+c<=b || b+c<=a) {
			System.out.println("NotATriangle");
			return;
		}if(a==b && b==c) {
			System.out.println("Equilateral");
		}else if(a==b || a==c || b==c) {
			System.out.println("Isosceles");
		}else {
			System.out.println("Scalene");
		}
	}
	/*Get the value of a side
	 *@param no parameter
	 *@return the integer value of a side
	 *Example: GetInput():user inputs 3, then return 3
	 *Time Estimate:O(1)
	 */
	public static int GetInput() {
		Scanner myObj=new Scanner(System.in);
		String str=myObj.nextLine();
		int num;
		while(true) {
			try {
				num=Integer.parseInt(str);
				break;
			}
			catch (NumberFormatException e){
				System.out.println("Invalid format for an integer. Please input the value again:");
				str=myObj.nextLine();
			}
		}
		return num;
	}
}

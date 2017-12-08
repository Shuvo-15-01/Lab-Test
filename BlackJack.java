import java.util.Scanner;
public class BlackJack {
	
	public static int turns(String s){
		if(s=="hit") return 2;
		else return 1;
	}
	
	
	public static int card1(){
		int p=37;
		int card=p%11;
		p=p*p;
		return card;
	}
	public static int card2(){
		int q=43;
		int card=q%11;
		q=q*q;
		return card;
	}
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		System.out.println("Welcome toMitchell's blackjack program!");
		int a= card1(),b=card2();
		int ans1=0,ans2=0;
		System.out.println("You get a " +  a + "and a " + b);
		ans1=a+b;
		System.out.println("Your total is " +  ans1);
		a= card1();
		b=card2();
		ans2=ans2+a;
		System.out.println("The dealer has a " +  a + "showing, and a hidden card");
		System.out.println("His total is hidden, too.");
		int turn=1;
		Scanner sc= new Scanner(System.in);
		String s="a";
		//String s1="hit";
		int n=1;
		while(true){
			if(ans1>20){
				n=0;
				
				System.out.println("Dealer Win!");
				break;
			}
			if(ans2>20){
				n=0;
				System.out.println("Dealer total is " +  ans2);
				System.out.println("You Win!");
				break;
			}
			
			int f=1;
			if(turn==1){
				System.out.println("Would you like to 'hit' or 'stay'?");
				s=sc.nextLine();
			}
			System.out.println(s);
			char ss[]=s.toCharArray();
			if(ss[0]=='h'){
				turn=1;
				a= card1();
				System.out.println("You drew a " + a);
				ans1=ans1+a;
				System.out.println("Your total is " +  ans1);
			}
			else if(ans2<17){
				if(f==1) {
					System.out.println("Okay,dealer's turn.");
					a= card2();
					ans2=ans2+a;
					System.out.println("His hidden card was "+a);
					System.out.println("His total was "+ans2);
					f=0;	
				}
				else {
					System.out.println("Dealer choose to hit.");
					a= card2();
					ans2=ans2+a;
					System.out.println("He draws a "+a);
					System.out.println("His total is " +  ans2);
				}
				
			}
			else {
				System.out.println("Dealer stays.");
				System.out.println("Dealer total is " +  ans2);
				System.out.println("Your total is " +  ans1);
				break;
			}
		}
		if(n==1 && ans1>ans2) System.out.println("You Win!");
		else if(n==1) System.out.println("Dealer Win!");
		
	}

}

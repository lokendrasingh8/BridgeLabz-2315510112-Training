package Rock_paper_scissors;
import java.util.Scanner;
import java.util.Random;
import java.util.HashMap;
public class RockPaperScissors {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);	
		HashMap<String,Integer> map=new HashMap<>(); 
		map.put("User Wins", 0);
        map.put("Computer Wins", 0);
        map.put("Tie", 0);		
		while(true) {
			String[] choice= {"Rock","Paper","Scissors"};			
			String computerChoice=computerChoice(choice);			
			String userChoice=userChoice(choice);		
			System.out.println(winner(computerChoice,userChoice,map));		
			System.out.println("Do you want to play again-0 or Exit-1");		
			int again=sc.nextInt();
			if(again==1) {
				int totalScore=map.get("Tie")+map.get("User Wins")+map.get("Computer Wins");
				System.out.println("Final ScoreCard: "+map);
				System.out.println("Tie%: "+ (map.get("Tie")*100.0)/totalScore);
				System.out.println("User Wins%: "+ (map.get("User Wins")*100.0)/totalScore);
				System.out.println("Computer Wins%: "+ (map.get("Computer Wins")*100.0)/totalScore);				
				break;
			}
		}
	}
	public static String computerChoice(String[] choice) {
		Random random=new Random();
		return choice[random.nextInt(3)];
	}	
	public static String userChoice(String[] choice) {
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter Your Choice: 0-Rock 1-paper 2-Scissors ");
		int userChoice=sc.nextInt();
		return choice[userChoice];
	}	
	public static String winner(String computerChoice,String userChoice,HashMap<String,Integer> map) {
		System.out.println("Computer choose: "+computerChoice);
		System.out.println("User choose: "+userChoice);
			
		if(computerChoice.equals("Rock") && userChoice.equals("Paper")||computerChoice.equals("Scissors") && userChoice.equals("Rock")||computerChoice.equals("Paper") && userChoice.equals("Scissors")) {
			map.put("User Wins", map.get("User Wins") + 1);
			return "User Wins";
		}
		if(computerChoice.equals("Paper") && userChoice.equals("Rock")||computerChoice.equals("Rock") && userChoice.equals("Scissors")||computerChoice.equals("Scissors") && userChoice.equals("Paper")) {
			map.put("Computer Wins", map.get("Computer Wins") + 1);
			return "Computer Wins";
		}	
		map.put("Tie",map.get("Tie")+1);
		return "It's a Tie";		
	}
}

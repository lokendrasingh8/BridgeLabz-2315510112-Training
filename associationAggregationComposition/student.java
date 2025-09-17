package associationAggregationComposition;
import java.util.*;
public class student {
	int id;
	String name;
	String gender;
	HashMap<course,Character> grades=new HashMap<>();
	
	student(int id,String name,String gender,HashMap<course,Character> grades){
		this.id=id;
		this.name=name;
		this.gender=gender;
		this.grades=grades;		
	}
	
	public void gradeCalculate() {
		System.out.println(this.grades);
	}
}
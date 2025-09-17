package associationAggregationComposition;
import java.util.*;
public class faculty {
	
	String name;
	int id;
	String deptarment;
	course c;
	
	faculty(String name,int id,String department,course c){
		this.name=name;
		this.id=id;
		this.deptarment=department;
		this.c=c;
	}
	
	public void grading(course c) {
		System.out.println(c.credit);
	}
}

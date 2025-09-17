package associationAggregationComposition;
import java.util.*;
public class course {
	
	String name;
	int courseId;
	int credit;
	
	course(String name,int courseId,int credit){
		this.name=name;
		this.courseId=courseId;
		this.credit=credit;
	}
	
	public void display() {
		System.out.println(this.name);
	}

}

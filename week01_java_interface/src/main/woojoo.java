package main;

public class Woojoo implements Hero, Student{
	String deadMessage;
	
	woojoo(){
		this.deadMessage = "으앙우주쥬금";
	}
	@override
	public  void eat(){}
	@override
	public int attack(){
		eat();
		return damgeNumb;
		
	}
	public interface Student{
		public void eat();
	}
	
}

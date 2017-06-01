package main;

public abstract Hero {
	public String attackMessage = "Attack!";
	public String deadMessage = "으앙쥬금";
	
	public default int attack();
	
	public default void dead() {
		System.out.println(deadMessage);
	}
}

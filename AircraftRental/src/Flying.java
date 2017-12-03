
public class Flying {
	protected String name;
	protected String startTime;
	protected String endTime;
	protected String flyingDate;
	protected String airCraft;
	protected static double totalFee;
	
	public Flying(String name, String startTime, String endTime, String flyingDate, String airCraft, double totalFee) {
		
		this.name = name;
		this.startTime = startTime;
		this.endTime = endTime;
		this.flyingDate = flyingDate;
		this.airCraft = airCraft;
		Flying.totalFee = totalFee;

	}
}

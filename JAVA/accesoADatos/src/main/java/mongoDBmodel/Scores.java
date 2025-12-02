package mongoDBmodel;

public class Scores {

	private double score;
	private String type;
	
	@Override
	public String toString() {
		return "Score [score=" + score + ", type=" + type + "]";
	}
	public Scores() {
		super();
		this.score = score;
		this.type = type;
	}
	public double getScore() {
		return score;
	}
	public void setScore(double score) {
		this.score = score;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}

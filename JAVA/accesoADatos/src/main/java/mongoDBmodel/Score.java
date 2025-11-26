package mongoDBmodel;

public class Score {

	private String score;
	private String type;
	
	@Override
	public String toString() {
		return "Score [score=" + score + ", type=" + type + "]";
	}
	public Score() {
		super();
		this.score = score;
		this.type = type;
	}
	public String getScore() {
		return score;
	}
	public void setScore(String score) {
		this.score = score;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	
}

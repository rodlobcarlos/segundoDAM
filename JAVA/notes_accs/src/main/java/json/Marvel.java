package json;

public class Marvel {

	private String name;
	private String publisher;
	private String alter_ego;
	private String first_appearance;
	private String characters;
	
	@Override
	public String toString() {
		return "Marvel [name=" + name + ", publisher=" + publisher + ", alter_ego=" + alter_ego + ", first_appearance="
				+ first_appearance + ", characters=" + characters + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getPublisher() {
		return publisher;
	}
	public void setPublisher(String publisher) {
		this.publisher = publisher;
	}
	public String getAlter_ego() {
		return alter_ego;
	}
	public void setAlter_ego(String alter_ego) {
		this.alter_ego = alter_ego;
	}
	public String getFirst_appearance() {
		return first_appearance;
	}
	public void setFirst_appearance(String first_appearance) {
		this.first_appearance = first_appearance;
	}
	public String getCharacters() {
		return characters;
	}
	public void setCharacters(String characters) {
		this.characters = characters;
	}
	public Marvel(String name, String publisher, String alter_ego, String first_appearance, String characters) {
		super();
		this.name = name;
		this.publisher = publisher;
		this.alter_ego = alter_ego;
		this.first_appearance = first_appearance;
		this.characters = characters;
	}

	
}

package language.listener.pack;

public class ContextDefinition {
	
	
	private String type ;
	private String name ;
	
	@Override
	public String toString() {
		return "ContextDefinition [type=" + type + ", name=" + name + "]";
	}

	public ContextDefinition(String type , String name) {
		this.type = type ;
		this.name = name ;
	}
	
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
}

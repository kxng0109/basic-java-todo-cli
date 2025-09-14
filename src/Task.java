public class Task {
	private String description;
	private boolean isCompleted;
	private static final String key = "~@!#sdfdb90";
	
	Task(String description){
		this.description = description;
		this.isCompleted = false;
	}

	Task(String description, boolean isCompleted){
		this.description = description;
		this.isCompleted = isCompleted;
	}

	public String getDescription(){
		return description;
	}

	public boolean getCompleted(){
		return isCompleted;
	}

	public void setDescription(String description){
		this.description = description;
	}

	public void setCompleted(){
		this.isCompleted = true;
	}

	//For writing to the file
	public String toFileString(){
		return description + key + isCompleted;
	}

	/**For reading from the file and creating the Task objects.
		*Returns null if the task saved in the file is malformed,
	 	*else returns a complete new Task object.
	 **/
	public static Task fromFileString(String savedTask){
		String[] parts = savedTask.split(key, 2);
		if(parts.length < 2) return null;
		String description = parts[0];
		boolean isCompleted = Boolean.parseBoolean(parts[1]);
		return new Task(description, isCompleted);
	}
}

Constraint ctt = new Constraint() {
	public void validate(Component comp, Object value) throws WrongValueException {
		if (value.toLowerCase().contains("delete") == true 
			|| value.toLowerCase().contains("update") == true
			|| value.toLowerCase().contains("drop") == true
			|| value.toLowerCase().contains("alter") == true
			|| value.toLowerCase().contains("select") == true
			|| value.toLowerCase().contains("view") == true
			|| value.toLowerCase().contains("table") == true
			|| value.toLowerCase().contains("=") == true
			|| value.toLowerCase().contains("'") == true
			|| value.toLowerCase().contains(";") == true
			|| value.toLowerCase().contains("`") == true
			|| value.toLowerCase().contains("|") == true
			|| value.toLowerCase().contains("into") == true)
			
				throw new WrongValueException(comp, "Some keyword not allow!");
	}
	
};


public class UserInterface implements UserInterfaceGeneral {
    //TODO improve the regex, to accept most inputs.
	@Override
    public String readFromUser(String output) {
        System.out.println(output);
        String input = System.console().readLine();
        input = input.replaceAll("\"","");
        return input;
	}
    @Override
    public String readFromUser() {
        String input = System.console().readLine();
        input = input.replaceAll("\"","");
        return input;
    }

	@Override
    public char getUserAnswer(String aBunchOfChoices) {
		System.out.println(aBunchOfChoices);
		char response = readFromUser().toUpperCase().charAt(0);
		return response;
	}

	//for mocking
	private char getUserAnswer(String aBunchOfChoices, UserInterface ui) {
		System.out.println(aBunchOfChoices);
		char response = ui.readFromUser().toUpperCase().charAt(0);
		return response;
	}

}

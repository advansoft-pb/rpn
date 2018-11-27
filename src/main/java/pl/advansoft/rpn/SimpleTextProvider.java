package pl.advansoft.rpn;

public class SimpleTextProvider implements TextProvider {

	private final String text;

	public SimpleTextProvider(String text) {
		this.text = text;
	}

	@Override
	public String getText() {
		return text;
	}
}

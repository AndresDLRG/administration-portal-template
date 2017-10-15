package andresdlrg.admin.portal.template.dto.datatables;

public class Search {

	private String value;
	private boolean regex;

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public boolean isRegex() {
		return regex;
	}

	public void setRegex(boolean regex) {
		this.regex = regex;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Search [");
		if (value != null) {
			builder.append("value=");
			builder.append(value);
			builder.append(", ");
		}
		builder.append("regex=");
		builder.append(regex);
		builder.append("]");
		return builder.toString();
	}

}

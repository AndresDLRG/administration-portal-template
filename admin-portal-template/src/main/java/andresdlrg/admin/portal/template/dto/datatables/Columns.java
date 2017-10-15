package andresdlrg.admin.portal.template.dto.datatables;

public class Columns {

	private String data;
	private String name;
	private boolean searchable;
	private boolean orderable;
	private Search search;
	private boolean regex;

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public boolean isSearchable() {
		return searchable;
	}

	public void setSearchable(boolean searchable) {
		this.searchable = searchable;
	}

	public boolean isOrderable() {
		return orderable;
	}

	public void setOrderable(boolean orderable) {
		this.orderable = orderable;
	}

	public Search getSearch() {
		return search;
	}

	public void setSearch(Search search) {
		this.search = search;
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
		builder.append("Columns [");
		if (data != null) {
			builder.append("data=");
			builder.append(data);
			builder.append(", ");
		}
		if (name != null) {
			builder.append("name=");
			builder.append(name);
			builder.append(", ");
		}
		builder.append("searchable=");
		builder.append(searchable);
		builder.append(", orderable=");
		builder.append(orderable);
		builder.append(", ");
		if (search != null) {
			builder.append("search=");
			builder.append(search);
			builder.append(", ");
		}
		builder.append("regex=");
		builder.append(regex);
		builder.append("]");
		return builder.toString();
	}

}

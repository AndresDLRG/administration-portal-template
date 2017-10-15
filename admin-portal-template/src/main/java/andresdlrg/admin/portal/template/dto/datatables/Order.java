package andresdlrg.admin.portal.template.dto.datatables;

public class Order {

	private int column;
	private String dir;

	public int getColumn() {
		return column;
	}

	public void setColumn(int column) {
		this.column = column;
	}

	public String getDir() {
		return dir;
	}

	public void setDir(String dir) {
		this.dir = dir;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Order [column=");
		builder.append(column);
		builder.append(", ");
		if (dir != null) {
			builder.append("dir=");
			builder.append(dir);
		}
		builder.append("]");
		return builder.toString();
	}

}

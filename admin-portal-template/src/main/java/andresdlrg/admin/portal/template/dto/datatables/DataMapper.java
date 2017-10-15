package andresdlrg.admin.portal.template.dto.datatables;

public class DataMapper {

	private String fieldName;
	private Class<?> clazz;

	public DataMapper(String fieldName, Class<?> clazz) {
		super();
		this.fieldName = fieldName;
		this.clazz = clazz;
	}

	public String getFieldName() {
		return fieldName;
	}

	public void setFieldName(String fieldName) {
		this.fieldName = fieldName;
	}

	public Class<?> getClazz() {
		return clazz;
	}

	public void setClazz(Class<?> clazz) {
		this.clazz = clazz;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("DataMapper [");
		if (fieldName != null) {
			builder.append("fieldName=");
			builder.append(fieldName);
			builder.append(", ");
		}
		if (clazz != null) {
			builder.append("clazz=");
			builder.append(clazz);
		}
		builder.append("]");
		return builder.toString();
	}

}

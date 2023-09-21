package statics;

public enum ReporterType {
    PROFESSIONAL("Chuyên nghiệp"),
    CAREER("Nghiệp dư"),
    COLLABORATORS("Cộng tác viên");

    public String value;

    ReporterType(String value) {
        this.value = value;
    }

}

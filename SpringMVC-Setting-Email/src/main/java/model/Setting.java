package model;

public class Setting {
    private String language;
    private int pageSize;
    private int spamsFilter;
    private String signature;

    public Setting() {
    }

    public Setting(String language, int pageSize, int spamsFilter, String signature) {
        this.language = language;
        this.pageSize = pageSize;
        this.spamsFilter = spamsFilter;
        this.signature = signature;
    }

    public String getLanguage() {
        return language;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getSpamsFilter() {
        return spamsFilter;
    }

    public String getSignature() {
        return signature;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setSpamsFilter(int spamsFilter) {
        this.spamsFilter = spamsFilter;
    }

    public void setSignature(String signature) {
        this.signature = signature;
    }

    public String viewSpamsFilter(int spamsFilter) {
        String str;
        if (spamsFilter == 1) {
            str = "Yes";
        } else {
            str = "No";
        }
        return str;
    }
}
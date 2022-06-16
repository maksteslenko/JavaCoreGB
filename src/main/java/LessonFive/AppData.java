package LessonFive;

public class AppData {
    private String[] header;
    private Integer[][] data;

    public AppData(String[] header, Integer[][] data) {
        this.header = header;
        this.data = data;
    }

    public AppData() {

    }

    public String[] getHeader() {
        return header;
    }

    public void setHeader(String[] header) {
        this.header = header;
    }

    public Integer[][] getData() {
        return data;
    }

    public void setData(Integer[][] data) {
        this.data = data;
    }
}

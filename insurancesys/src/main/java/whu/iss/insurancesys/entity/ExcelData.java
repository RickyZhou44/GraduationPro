package whu.iss.insurancesys.entity;

import java.util.List;

/**
 * @author RickZhou
 *         Created by RickZhou on 2019/3/12 0012.
 */
public class ExcelData {
    private String filename;
    //表头数据
    private String[] head;
    //数据
    private List<String[]> data;

    public String[] getHead() {
        return head;
    }

    public void setHead(String[] head) {
        this.head = head;
    }

    public void setData(List<String[]> data) {
        this.data = data;
    }

    public String getFilename() {
        return filename;
    }

    public void setFilename(String filename) {
        this.filename = filename;
    }

    public List<String[]> getData(){
        return data;
    }
}

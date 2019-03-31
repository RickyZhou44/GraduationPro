package whu.iss.insurancesys.entity.SettlementParamEntities;

/**
 * @author RickZhou
 * Create by RickZhou on 2019/3/26
 */
//此类用于封装附件的相关信息数据
public class AttachInfo {
    private String path;//附件的目录绝对路径
    private String name;//文件名字
    private String size;//附件的大小

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }
}

package whu.iss.insurancesys.dto;

/**
 * @author RickZhou
 *         Created by RickZhou on 2018/4/18 0018.
 */
/*
* 用于后端数据封装，前后端数据传输*/
public class ResultInfo {
    private boolean result;
    private Object data;
    private String reason;

    public boolean isResult() {
        return result;
    }

    public void setResult(boolean result) {
        this.result = result;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }
}

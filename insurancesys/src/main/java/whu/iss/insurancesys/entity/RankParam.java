package whu.iss.insurancesys.entity;


public class RankParam {

  private long id;
  private String code;
  private String name;
  private String type;
  private long level;
  private String content;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public String getCode() {
    return code;
  }

  public void setCode(String code) {
    this.code = code;
  }


  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }


  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }


  public long getLevel() {
    return level;
  }

  public void setLevel(long level) {
    this.level = level;
  }


  public String getContent() {
    return content;
  }

  public void setContent(String content) {
    this.content = content;
  }

}

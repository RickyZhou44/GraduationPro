package whu.iss.insurancesys.entity;


public class UploadParam {

  private long id;
  private long photoMax;
  private long singleFileMax;
  private long singleFolderMax;


  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }


  public long getPhotoMax() {
    return photoMax;
  }

  public void setPhotoMax(long photoMax) {
    this.photoMax = photoMax;
  }


  public long getSingleFileMax() {
    return singleFileMax;
  }

  public void setSingleFileMax(long singleFileMax) {
    this.singleFileMax = singleFileMax;
  }


  public long getSingleFolderMax() {
    return singleFolderMax;
  }

  public void setSingleFolderMax(long singleFolderMax) {
    this.singleFolderMax = singleFolderMax;
  }

}

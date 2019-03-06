package whu.iss.insurancesys.entity;

public class UploadParam {
    private Integer id;

    private Integer photoMax;

    private Integer singleFileMax;

    private Integer singleFolderMax;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhotoMax() {
        return photoMax;
    }

    public void setPhotoMax(Integer photoMax) {
        this.photoMax = photoMax;
    }

    public Integer getSingleFileMax() {
        return singleFileMax;
    }

    public void setSingleFileMax(Integer singleFileMax) {
        this.singleFileMax = singleFileMax;
    }

    public Integer getSingleFolderMax() {
        return singleFolderMax;
    }

    public void setSingleFolderMax(Integer singleFolderMax) {
        this.singleFolderMax = singleFolderMax;
    }
}
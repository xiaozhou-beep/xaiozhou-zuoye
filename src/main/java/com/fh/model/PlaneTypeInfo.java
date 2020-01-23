package com.fh.model;

/**
 * @ClassName PlaneTypeInfo
 * @Description: TODO
 * @Author 马传洲
 * @Date 2020/1/15
 * @Version V1.0
 **/
public class PlaneTypeInfo   {
    //t_plane_type(机型表)
    private Integer id;// 机型id
    private String name;// 机型名称
    private Integer type;// 机型类型(比如1代表大型，2代表中型，3代表小型)

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }
}

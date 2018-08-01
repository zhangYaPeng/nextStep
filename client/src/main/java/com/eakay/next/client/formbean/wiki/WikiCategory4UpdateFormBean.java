package com.eakay.next.client.formbean.wiki;

import javax.validation.constraints.NotNull;
import java.io.Serializable;

public class WikiCategory4UpdateFormBean implements Serializable {

    private static final long serialVersionUID = -6187055146770471563L;



    @NotNull
    private Integer id;


    private String title;


    private Integer sort;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getSort() {
        return sort;
    }

    public void setSort(Integer sort) {
        this.sort = sort;
    }
}

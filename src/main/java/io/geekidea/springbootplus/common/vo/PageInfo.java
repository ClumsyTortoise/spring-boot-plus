/*
 * Copyright 2019-2029 geekidea(https://github.com/geekidea)
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package io.geekidea.springbootplus.common.vo;

import com.alibaba.fastjson.annotation.JSONField;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonProperty;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.extern.slf4j.Slf4j;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

/**
 * @author geekidea
 * @date 2018-11-08
 */
@ApiModel("分页")
@Data
@Slf4j
public class PageInfo<T> implements Serializable {
    private static final long serialVersionUID = -1683800405530086022L;

    @ApiModelProperty(value = "总行数",position = 1)
    @JSONField(name = "current")
    @JsonProperty("current")
    private long current;

    @ApiModelProperty(value = "每页查询几条",position = 2)
    @JSONField(name = "size")
    @JsonProperty("size")
    private long size;

    @ApiModelProperty(value = "当前页的数量",position = 3)
    @JSONField(name = "pageCount")
    @JsonProperty("pageCount")
    private long pageCount;

    @ApiModelProperty(value = "总页数",position = 4)
    @JSONField(name = "pages")
    @JsonProperty("pages")
    private long pages;

    @ApiModelProperty(value = "总行数",position = 5)
    @JSONField(name = "total")
    @JsonProperty("total")
    private long total = 0;

    @ApiModelProperty(value = "数据列表",position = 6)
    @JSONField(name = "records")
    @JsonProperty("records")
    private List<T> records;

    public static <T> PageInfo<T>  build(IPage<T> page) {

//        log.info("总数 ----------------> " + page.getTotal());
//        log.info("当前页 ----------------> " + page.getCurrent());
//        log.info("每页查询几条 ----------------> " + page.getSize());
//        log.info("总页数 ----------------> " + page.getPages());
//        log.info("当前页的数量 ----------------> " + page.getRecords().size());

        PageInfo<T> pageInfo = new PageInfo<>();
        pageInfo.setCurrent(page.getCurrent());
        pageInfo.setSize(page.getSize());
        pageInfo.setPageCount(page.getRecords().size());
        pageInfo.setPages(page.getPages());
        pageInfo.setTotal(page.getTotal());
        pageInfo.setRecords(page.getRecords());
        return pageInfo;
    }



    @Override
    public String toString() {
        return "PageInfo{" +
                ", current=" + current +
                ", size=" + size +
                ", pageCount=" + pageCount +
                ", pages=" + pages +
                ", total=" + total +
                ", records=" + records +
                '}';
    }

}

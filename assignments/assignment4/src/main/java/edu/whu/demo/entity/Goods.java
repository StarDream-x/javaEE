package edu.whu.demo.entity;


import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiParam;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
@ApiModel(description = "商品实体")
public class Goods {

    @ApiModelProperty("商品id")
    long id;

    @ApiModelProperty("商品名称")
    String name;

    @ApiModelProperty("商品价格")
    double price;



}

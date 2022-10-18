package edu.whu.demo.controller;

import edu.whu.demo.entity.Goods;
import edu.whu.demo.service.GoodService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(description = "商品管理")
@RestController
@RequestMapping("goods")
public class GoodsController {

    @Autowired
    GoodService goodService;

    @ApiOperation("根据id查询商品")
    @GetMapping("/{id}")
    public ResponseEntity<Goods> getGoods(@ApiParam("商品id")@PathVariable long id){
        Goods result = goodService.getGoods(id);
        if(result==null){
            return ResponseEntity.noContent().build();
        }
        else{
            return ResponseEntity.ok(result);
        }
    }

    @ApiOperation("根据条件查询商品")
    @GetMapping("")
    public ResponseEntity<List<Goods>> findGoods(@ApiParam("商品名称")String name, @ApiParam("商品价格")Double price){
        List<Goods> result = goodService.findGoods(name,price);
        return ResponseEntity.ok(result);
    }

    @ApiOperation("添加商品")
    @PostMapping("")
    public ResponseEntity<Goods> addGoods(@RequestBody Goods goods){
        Goods goods1 = goodService.addGoods(goods);
        return ResponseEntity.ok(goods1);
    }

    @ApiOperation("修改商品")
    @PutMapping("/{id}")
    public ResponseEntity<Void> updateGoods(@PathVariable long id,@RequestBody Goods goods){
        goodService.updateGoods(id,goods);
        return ResponseEntity.ok().build();
    }

    @ApiOperation("删除商品")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteGoods(@PathVariable long id){
        goodService.deleteGoods(id);
        return ResponseEntity.ok().build();
    }



}

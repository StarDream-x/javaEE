package edu.whu.demo.service;

import edu.whu.demo.entity.Goods;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class GoodService {

    private Map<Long, Goods> goodsMap = Collections.synchronizedMap(new HashMap<Long,Goods>());


    public Goods addGoods(Goods goods){
        goodsMap.put(goods.getId(),goods);
        return goods;
    }

    public Goods getGoods(long id){return goodsMap.get(id);}

    public List<Goods> findGoods(String name, Double price){//,double price
        List<Goods> result = new ArrayList<>();
        for(Goods goods: goodsMap.values()){
            if(name!=null && !goods.getName().contains(name)){
                continue;
            }
//            if(price!=null && goods.getPrice() > price){
//                continue;
//            }
            result.add(goods);
        }
        return  result;
    }

    public void updateGoods(long id,Goods goods){
        Goods goods1 = goodsMap.get(id);
        goods1.setName(goods.getName());
        goods1.setPrice(goods.getPrice());
        goodsMap.put(id,goods1);
    }

    public void deleteGoods(long id){
        goodsMap.remove(id);
    }
}

package com.czxy.controller;

import com.czxy.domain.Product;
import com.czxy.service.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {


    @Resource
    private ProductService productService;


    //商品详情页面跳到购物车页面



    //左边
    @GetMapping("/left/{id}")
    public ResponseEntity<List<Product>> findLeft(@PathVariable("id") String cid){
        try {
            List<Product> products = productService.upProducts(cid);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }



    //通过商品id
    @GetMapping("/byId/{id}")
    public ResponseEntity<Product> findById(@PathVariable("id") String pid){
        try {
            Product product = productService.findById(pid);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //通过分类查找分类下商品
    @GetMapping("/findVo/{cid}")
    public ResponseEntity<List<Product>> findVo(@PathVariable("cid") String cid){
        try {
            List<Product> allProduct = productService.findAllProduct(cid);
            return ResponseEntity.ok(allProduct);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    /**
     * 生活箱包
     */
    @RequestMapping("/findBoxByCid")
    public ResponseEntity<List<Product>> findBoxByCid() {

        try {
            List<Product> list = productService.findBoxByCid();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * 耳机音响
     */
    @RequestMapping("/findHeadsetByCid")
    public ResponseEntity<List<Product>> findHeadsetByCid() {

        try {
            List<Product> list = productService.findHeadsetByCid();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    /**
     * 健康儿童
     */
    @RequestMapping("/findChildByCid")
    public ResponseEntity<List<Product>> findChildByCid() {

        try {
            List<Product> list = productService.findChildByCid();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * 查询配件
     */
    @RequestMapping("/findPartByCid")
    public ResponseEntity<List<Product>> findPartByCid() {

        try {
            List<Product> list = productService.findPartByCid();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * 查询配件
     */
    @RequestMapping("/findPartByCid01")
    public ResponseEntity<List<Product>> findPartByCid01() {

        try {
            List<Product> list = productService.findPartByCid01();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    /**
     * 查询路由器
     */
    @RequestMapping("/findRouterByCid")
    public ResponseEntity<List<Product>> findRouterByCid() {

        try {
            List<Product> list = productService.findRouterByCid();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * 查询路由器
     */
    @RequestMapping("/findRouterByCid01")
    public ResponseEntity<List<Product>> findRouterByCid01() {

        try {
            List<Product> list = productService.findRouterByCid01();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    /**
     * 查询家电
     */
    @RequestMapping("/findFurnitureByCid")
    public ResponseEntity<List<Product>> findFurnitureByCid() {

        try {
            List<Product> list = productService.findFurnitureByCid();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * 查询家电
     */
    @RequestMapping("/findFurnitureByCid01")
    public ResponseEntity<List<Product>> findFurnitureByCid01() {

        try {
            List<Product> list = productService.findFurnitureByCid01();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    /**
     * 查询电脑
     *
     * @return
     */
    @RequestMapping("/findPcByCid")
    public ResponseEntity<List<Product>> findPcByCid() {

        try {
            List<Product> list = productService.findPcByCid();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    /**
     * 查询电脑
     *
     * @return
     */
    @RequestMapping("/findPcByCid01")
    public ResponseEntity<List<Product>> findPcByCid01() {

        try {
            List<Product> list = productService.findPcByCid01();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    /**
     * 查询电视6条
     *
     * @return
     */
    @RequestMapping("/findTvByCid01")
    public ResponseEntity<List<Product>> findTvByCid01() {

        try {
            List<Product> list = productService.findTvByCid01();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    /**
     * 查询电视6条
     *
     * @return
     */
    @RequestMapping("/findTvByCid")
    public ResponseEntity<List<Product>> findTvByCid() {

        try {
            List<Product> list = productService.findTvByCid();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    /**
     * 查询所有cid为1，2的手机后6条
     *
     * @return
     */
    @RequestMapping("/findProductByCid01")
    public ResponseEntity<List<Product>> findProductByCid01() {
        try {
            List<Product> list = productService.findProductByCid01();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }


    /**
     * 查询所有cid为1，2的手机前六条
     *
     * @return
     */
    @RequestMapping("/findProductByCid")
    public ResponseEntity<List<Product>> findProductByCid() {
        try {
            List<Product> list = productService.findProductByCid();
            return ResponseEntity.ok(list);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

    //通过名字查询该商品
    @GetMapping("/findByNameToInfo/{name}")
    public ResponseEntity<Product> findByNameToInfo(@PathVariable("name") String name){
        try {
            Product product = productService.findByNametoInfo(name);
            return ResponseEntity.ok(product);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }



    //通过名字模糊查询
    @GetMapping("/fproduct/{name}")
    public ResponseEntity<List<Product>> findByProduct(@PathVariable("name") String pname){
        try {
            List<Product> products = productService.findProducts(pname);
            return ResponseEntity.ok(products);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}


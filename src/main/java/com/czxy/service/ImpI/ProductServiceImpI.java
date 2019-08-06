package com.czxy.service.ImpI;

import com.czxy.dao.ProductMapper;
import com.czxy.domain.Product;
import com.czxy.service.ProductService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import javax.annotation.Resource;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpI  implements ProductService{

    @Resource
    private ProductMapper productMapper;


    @Override
    public List<Product> findProducts(String pname) {

        List<Product> products = productMapper.ByNamefindProduct("%"+ pname +"%");
        return products;
    }

    @Override
    public Product findByNametoInfo(String pname) {

        Example ex=new Example(Product.class);

        Example.Criteria criteria = ex.createCriteria();

        criteria.andEqualTo("pname",pname);

        List<Product> products = productMapper.selectByExample(ex);

        if (!products.isEmpty()){
            return products.get(0);
        }
        return null;
    }

    @Override
    public Product findById(String pid) {
        Product product = productMapper.selectByPrimaryKey(pid);
        return product;
    }



    @Override
    public List<Product> findAllProduct(String cid) {
        Example ex=new Example(Product.class);
        Example.Criteria criteria = ex.createCriteria();
        criteria.andEqualTo("cid",cid);
        List<Product> products = productMapper.selectByExample(ex);
        return products;
    }

    @Override
    public List<Product> upProducts(String cid) {
        return productMapper.upProduct(cid);
    }


    @Override
    public List<Product> dowmProducts(String cid) {
        return productMapper.downProduct(cid);
    }

    /**
     * 健康儿童
     */
    @Override
    public List<Product> findChildByCid() {
        return productMapper.findChildByCid();
    }

    /**
     * 耳机音响
     */
    @Override
    public List<Product> findHeadsetByCid() {
        return productMapper.findHeadsetByCid();
    }

    /**
     * 生活箱包
     */
    @Override
    public List<Product> findBoxByCid() {
        return productMapper.findBoxByCid();
    }



    /**
     * 查询配件
     */
    @Override
    public List<Product> findPartByCid() {
        return productMapper.findPartByCid();
    }


    /**
     * 查询配件
     */
    @Override
    public List<Product> findPartByCid01() {
        return productMapper.findPartByCid01();
    }



    /**
     * 查询所有cid为1，2的手机
     *
     * @return
     */
    @Override
    public List<Product> findProductByCid() {
        return productMapper.findProductByCid();
    }

    /**
     * 查询所有cid为1，2的手机
     *
     * @return
     */
    @Override
    public List<Product> findProductByCid01() {
        return productMapper.findProductByCid01();
    }

    /**
     * 查询电视
     *
     * @return
     */
    @Override
    public List<Product> findTvByCid() {
        return productMapper.findTvByCid();
    }

    /**
     * 查询电视
     *
     * @return
     */
    @Override
    public List<Product> findTvByCid01() {
        return productMapper.findTvByCid01();
    }

    /**
     * 查询笔记本
     */
    @Override
    public List<Product> findPcByCid() {
        return productMapper.findPcByCid();
    }

    /**
     * 查询笔记本
     */
    @Override
    public List<Product> findPcByCid01() {
        return productMapper.findPcByCid01();
    }

    /**
     * 查询家电
     */
    @Override
    public List<Product> findFurnitureByCid() {
        return productMapper.findFurnitureByCid();
    }

    /**
     * 查询家电
     */
    @Override
    public List<Product> findFurnitureByCid01() {
        return productMapper.findFurnitureByCid01();
    }

    /**
     * 查询路由器
     */
    @Override
    public List<Product> findRouterByCid() {
        return productMapper.findRouterByCid();
    }

    /**
     * 查询路由器
     */
    @Override
    public List<Product> findRouterByCid01() {
        return productMapper.findRouterByCid01();
    }
}

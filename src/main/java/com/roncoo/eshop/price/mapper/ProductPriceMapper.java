package com.roncoo.eshop.price.mapper;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import com.roncoo.eshop.price.model.ProductPrice;
/**
 * 商品价格mapper
 * @author dream
 *
 */
@Mapper
public interface ProductPriceMapper {
	@Insert("INSERT INTO product_price(value,product_id) VALUES(#{value},#{productId})")  
	public void add(ProductPrice productPrice);
	
	@Update("UPDATE product_price SET value=#{value},product_id=#{productId} WHERE id=#{id}")  
	public void update(ProductPrice productPrice);
	
	@Delete("DELETE FROM product_price WHERE id=#{id}")  
	public void delete(Long id);
	
	@Select("SELECT * FROM product_price WHERE id=#{id}")
	@Results({
		@Result(column="product_id",property = "productId")
	})
	public ProductPrice findById(Long id);
	
	@Select("SELECT * FROM product_price WHERE product_id=#{productId}")  
	@Results({
		@Result(column="product_id",property = "productId")
	})
	public ProductPrice findByProductId(Long productId);
}

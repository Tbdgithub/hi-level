1. mike 买的商品名称和消费额
SELECT  b.name,c.name, a.number*c.price FROM `Sale` a ,`Customer` b ,`Product` c
WHERE a.customer_id=b.id AND a.product_id=c.id AND  a.customer_id=1

2.所有销售商品的平均价格
SELECT  AVG(c.price) FROM `Sale` a ,`Product` c
WHERE c.id=a.product_id
3.mike 买的商品的平均价格

SELECT  AVG(b.price) FROM `Sale` a ,`Product` b  ,`Customer` c
WHERE a.product_id=b.id AND a.customer_id=c.id
AND c.name='mike'

4. mike 买的商品的平均销售额


SELECT  AVG(b.price*a.number) FROM `Sale` a ,`Product` b  ,`Customer` c
WHERE a.product_id=b.id AND a.customer_id=c.id
AND c.name='mike'

5. 每个顾客的平均销售额,从高到低排序

SELECT c.name,  AVG(b.price*a.number) FROM `Sale` a ,`Product` b  ,`Customer` c
WHERE a.product_id=b.id AND a.customer_id=c.id
GROUP BY c.id
ORDER BY AVG(b.price*a.number) DESC

6. 销售额最高的前两名顾客名称及销售额
SELECT NAME, avergae FROM

  (SELECT c.name,  AVG(b.price*a.number) avergae FROM `Sale` a ,`Product` b  ,`Customer` c
  WHERE a.product_id=b.id AND a.customer_id=c.id
  GROUP BY c.id
   ORDER BY AVG(b.price*a.number) DESC ) b
ORDER BY b.avergae DESC LIMIT 2

7.销售额大于平均销售额的交易id,顾客名称，销售额

SELECT a.id, c.name,  b.price*a.number FROM `Sale` a ,`Product` b  ,`Customer` c
WHERE a.product_id=b.id AND a.customer_id=c.id
      AND b.price*a.number >
          (SELECT AVG(price*number) FROM `Sale` a, `Product` b WHERE a.product_id=b.id)
 8.价格大于本类平均价格的商品名称

SELECT product_type,price FROM Product a
WHERE a.price>
      (SELECT AVG(price) FROM Product b WHERE a.product_type=b.product_type
      GROUP BY b.product_type
      )







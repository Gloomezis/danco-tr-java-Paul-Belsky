1. SELECT model,speed, hd FROM pc
WHERE price<500;

2. SELECT DISTINCT maker FROM product 
WHERE  type ='printer';

3. SELECT model, hd,screen FROM laptop
Where price>1000;

4. SELECT * FROM printer
Where color='y';

5. SELECT model, speed, hd FROM pc WHERE price < 600.0 and cd='12õ' OR cd = '24x';

6. SELECT product.maker ,laptop.speed FROM product
 INNER JOIN laptop ON product.model=laptop.model
 WHERE laptop.hd>=10;

7.
 (SELECT laptop.model , price   FROM laptop
 INNER JOIN  product ON laptop.model=product.model
 WHERE  product.maker = 'Fourth')
 UNION
 (SELECT pc.model , price   FROM pc
 INNER JOIN product ON pc.model=product.model
 WHERE  product.maker = 'Fourth')
 UNION
 (SELECT printer.model , price   FROM printer
 INNER JOIN product ON printer.model=product.model
 WHERE  product.maker = 'Fourth');
 
8.TODO
SELECT DISTINCT maker FROM product
where type = 'pc'
NOT IN
(SELECT DISTINCT maker
from product
WHERE type = 'laptop');

9.
SELECT DISTINCT maker FROM product
INNER JOIN pc ON product.model=pc.model
WHERE pc.speed>=35;

10. 
SELECT model,price  FROM printer
WHERE price =(SELECT MAX(price) FROM printer);

11.
SELECT AVG(speed) FROM pc;

12.
SELECT AVG(speed) FROM laptop
WHERE price>1000;

13.
SELECT AVG(pc.speed) from pc
inner join product on
product.model=pc.model
where product.maker = 'A';

14
SELECT speed, AVG(price) FROM pc
GROUP BY speed;

15.
SELECT hd FROM pc
GROUP BY hd
HAVING COUNT(model)>1;

16.
SELECT DISTINCT one.model AS model , two.model AS model, one.speed,one.ram FROM pc AS one
INNER JOIN pc AS two ON
one.speed=two.speed AND one.ram=two.ram AND one.model>two.model;

17.
SELECT DISTINCT pd.type, lp.model, lp.speed FROM laptop AS lp
INNER JOIN product AS pd ON
lp.model=pd.model
WHERE lp.speed<(SELECT MIN(pc.speed) FROM pc);

18. 
SELECT pd.maker, pt.price FROM printer AS pt
INNER JOIN product AS pd ON
pt.model=pd.model
WHERE pt.price = (SELECT MIN(price) FROM printer  WHERE color='y' ) AND pt.color='y';

19.
SELECT pd.maker, AVG(lp.screen) AS AVG_SC from laptop AS lp
INNER JOIN product AS pd ON
pd.model=lp.model
GROUP BY pd.maker;

20.
SELECT pd.maker, count(pc.model) AS pc_models from pc 
INNER JOIN product AS pd ON
pd.model=pc.model
GROUP BY maker
HAVING count(pc.model)>3;

// ALTERNATIVE

SELECT maker, count(model) AS pc_models from product 
WHERE type = 'pc'
GROUP BY maker
HAVING COUNT(model)>3;

21.
SELECT pd.maker, MAX(pc.price) AS Max_price from pc
INNER JOIN product AS pd ON
pd.model=pc.model
GROUP BY pd.maker;

22.
SELECT speed , AVG(price) FROM pc
WHERE speed>600
GROUP BY speed;

23.
SELECT DISTINCT maker FROM product
INNER JOIN pc ON
product.model=pc.model
WHERE pc.speed>=750 AND maker IN
(SELECT maker FROM product
INNER JOIN laptop ON
product.model=laptop.model
WHERE  laptop.speed>=750);

24. 
SELECT model FROM
(SELECT model,price FROM pc
UNION
SELECT model,price FROM laptop
UNION
SELECT model,price FROM printer) AS all_max_price
WHERE price=(SELECT MAX(price) FROM (
SELECT price FROM pc
UNION
SELECT price FROM laptop
UNION
SELECT price FROM printer) AS all_price
);
//1 Getting all price. 2. Finding max price 3. Searching max price in all model separeted

25.
SELECT DISTINCT maker FROM Product 
WHERE type = 'printer' AND maker IN
(SELECT maker FROM Product 
 WHERE model IN
(SELECT model  FROM pc
WHERE speed = (SELECT MAX(speed) FROM (SELECT speed  FROM pc 
                                       WHERE ram=(SELECT MIN(ram) FROM pc
                                                  )
                                       ) AS p
               )
)
)

//another version

SELECT DISTINCT maker FROM product WHERE model IN(
SELECT model FROM pc
WHERE ram=(SELECT MIN(ram) from pc) and speed =(SELECT MAX(speed) FROM pc WHERE ram=(SELECT MIN(ram) FROM pc
)
)
) AND maker IN(SELECT maker FROM product
WHERE type='printer');



TODO List
1. payment sequence diagram    ***OK***
2. discount rule match sequence diagram    ***OK***
3. auto generate checkout activity diagram   ***OK***
4. Log in sequence diagram   ***OK***
5. Discout rule management sequence diagram   ***OK***


## Discout Rules:
（单一商品指互相没有联系得商品，商品组指互相关联的商品捆绑）
所有促销方式都有：生效时间（包括：一天内的起止时间段，以周为单位的时间段（每周几到每周几），有效的商品对象（单种类商品，组合捆绑商品））

分析：经过促销规则匹配前后，有：
- 输入：商品集合；
- 输出：商品匹配促销的集合，对于每一个匹配后的集合有：单价与总额，赠送品（抵扣券或真实商品）；

1. 买X件减Y元；可选商品组(G)或单一商品(P)；
2. 买X件打Y折；可选：全场商品、商品组、单一商品；
3. 买X件享受特价；可选商品组或单一商品；
4. 买X件送Y件；固定商品、任意商品；
5. 满X元打Y折；
6. 满X元加Y元送Z件商品；
7. 满X元送Y元优惠券；是否累加；赠送或当场抵现；

# TODO List
1. 添加商品
  - 单件添加
  - 更新数量
2. 移除商品
  - 减少数量
  - 完全删除
3. 匹配规则
4. 结算支付业务


# ***NOTICE***:
Defferences between class ViewSideGood and SaledGood
| SaledGood | ViewSideGood     |Solution|
| :------------- | :------------- |:------------- |
|String goodID|String goodID|keeping same|
|  LocalDateTime saledDate     |      ||
|double sum|||
|double price // saledPrice|double goodPrice // original price|default setter saledPrice|
|String orderID||
|List<String> RuleID||

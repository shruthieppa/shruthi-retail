### Author: Eppa Shruthi
+++++++++++++++++++
A retailer offers a rewards program to its customers, awarding points based on each recorded 
purchase.
A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for 
every dollar spent over $50 in each transaction
(e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
Given a record of every transaction during a three month period, calculate the reward points earned 
for each customer per month and total. 
+++++++++++++++++++
-> Created Services using spring doc open API 3(Swagger) spring boot
-> Instead of using DB just used hashmap for this coding in repository.
-> Customer Service will provide customers CRUD operations by id.
-> Order Service will provide orders CRUD operations by id.
-> Rewards Service will provide rewards of each customer by orderId, total orders, 
    orders for each month

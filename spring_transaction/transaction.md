spring事务 只做了事务管理
jdbc事务
mysql事务
总结:事务本身由数据库实现

PlatformTransactionManager

1. PlatformTransactionManager接口     -- 平台事务管理器.(真正管理事务的类)。该接口有具体的实现类，根据不同的持久层框架，需要选择不同的实现类！ 
2. TransactionDefinition接口          -- 事务定义信息.(事务的隔离级别,传播行为,超时,只读)
3. TransactionStatus接口              -- 事务的状态（是否新事务、是否已提交、是否有保存点、是否回滚）
 
4. 总结：上述对象之间的关系：平台事务管理器真正管理事务对象.根据事务定义的信息TransactionDefinition 进行事务管理，在管理事务中产生一些状态.将状态记录到TransactionStatus中
 
5. PlatformTransactionManager接口中实现类和常用的方法


事务1: 原子性(A)     操作不可分割 要么都成功要么都失败
2:一致性(C)     
3:隔离性(I)
(由于锁的机制 会引发一些并发问题)

 4:持久性(D)

事务并发问题:
在事务的并发操作中可能会出现一些问题：
l 脏读：一个事务读取到另一个事务未提交的数据。
l 不可重复读：一个事务因读取到另一个事务已提交的数据。导致对同一条记录读取两次以上的结果不一致。update操作
l 幻读：一个事务因读取到另一个事务已提交的数据。导致对同一张表读取两次以上的结果不一致。insert、delete操作

隔离级别

现在来看看MySQL数据库为我们提供的四种隔离级别（由低到高）：
① Read uncommitted (读未提交)：最低级别，任何情况都无法保证。
② Read committed (读已提交)：可避免脏读的发生。
③ Repeatable read (可重复读)：可避免脏读、不可重复读的发生。mysql 在这个级别的时候就可以将幻读给解决了 mysql默认隔离级别就是RR
Serializable (串行化)：可避免脏读、不可重复读、幻读的发生。


spring 事务有两种 
编程事事务,
声明式事务
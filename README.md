# Flashsale-System

## Introduction
This project presents a high-performance shopping system, expertly developed in Java using Spring Boot. Designed to handle high traffic volumes, this system showcases robustness and efficiency, ideal for demanding e-commerce environments.


## Demos
#### Homepage:
<img width="1916" alt="image" src="https://github.com/JackyTang0516/Flashsale-System/assets/111934442/3f3057be-9107-4a8a-886b-608660d1e480">
<img width="1917" alt="image" src="https://github.com/JackyTang0516/Flashsale-System/assets/111934442/15d0aa5f-3e5e-48e0-9a19-b1354127a39d">

#### Flashsale event detailed page:
<img width="1916" alt="image" src="https://github.com/JackyTang0516/Flashsale-System/assets/111934442/db0c6124-d355-4e0b-a1ed-cdf39e411bb0">
<img width="1915" alt="image" src="https://github.com/JackyTang0516/Flashsale-System/assets/111934442/3a1cc43c-c91f-432a-b047-6b9004e5b465">
<img width="1916" alt="image" src="https://github.com/JackyTang0516/Flashsale-System/assets/111934442/9ff9bc3e-9e53-4e82-9397-79f40d8e0c40">

#### Successfully snagged the product:
<img width="1918" alt="image" src="https://github.com/JackyTang0516/Flashsale-System/assets/111934442/f55d54bc-9ac0-457f-bc26-62457bda9710">

#### Order created, awaiting payment:
<img width="1915" alt="image" src="https://github.com/JackyTang0516/Flashsale-System/assets/111934442/b23c37f1-e157-4525-8459-23735c25a565">

#### Prompt with payment is successful:
<img width="1918" alt="image" src="https://github.com/JackyTang0516/Flashsale-System/assets/111934442/369e518a-8bd3-4b9e-b2c3-3d3daf131d9b">

#### Order closed, payment timeout:
<img width="1917" alt="image" src="https://github.com/JackyTang0516/Flashsale-System/assets/111934442/09cede89-b628-49c9-abf8-93d486769c0a">


## Key Features and Technologies

### High Scalability: 
- Leveraging the power of Java and Spring Boot, the system is engineered to scale seamlessly with increasing traffic demands.

### Data Replication and Caching:

- Implemented data replication from MySQL to Redis.
- Adopted Lua Script for optimized data processing.
- Cached essential goods information, significantly reducing data access latency.
- Achieved a reduction in server response time, enhancing overall performance.

### Performance Enhancement with RocketMQ:

- Integrated RocketMQ for efficient message queuing.
- Employed cache warm-up strategies and asynchronous processing.
- Resulted in an increase in user traffic, demonstrating the system's capacity to handle larger user bases effectively.

### Flow Control and Rate Limiting with Sentinel:

- Utilized Sentinel for sophisticated flow control and rate limiting.
- Managed a high-performance, multithreading web server capable of handling over 600 Queries Per Second (QPS).

## How to start:
### 1. Start MySQL and initilized the tables:
```
 sudo /usr/local/mysql/support-files/mysql.server start
```
- password:12345678, configure the application.properties and generatorConfig.xml
  
- Run seckill_activity.sql to create the tables

### 2. Start Redis by running the following commands in the directory:
```
redis-server
```
### 3. Start RocketMQ by running following commands in the directory:
```
mqnamesrv & 
```
```
mqbroker -n localhost:9876 autoCreateTopic=true
```
```
cat nohup.out
```
### 4. Redirect to the homepage:
```
localhost:8085/seckills
```

- The port can be configured in application.properties.

### * To restart RocketMQ, run the following commands in the directory:
```
sh bin/mqshutdown broker
```
```
sh bin/mqshutdown namesrv
```
### * To restart Nacos:
```
sh startup.sh -m standalone
```
```
sh shutdown.sh        
```

### * To set the messageDelayLevels for locked-items(before payment is successful):
- 1s 5s 10s 30s 1m 2m 3m 4m 5m 6m 7m 8m 9m 10m 20m 30m 1h 2h
- rocketMQService.sendDelayMessage("pay_check", JSON.toJSONString(order), 4);

## Stress Testing (using JMeter)
- Open the terminal then run:
```
jmeter
```

<img width="995" alt="image" src="https://github.com/JackyTang0516/Flashsale-System/assets/111934442/5d563b56-dc4e-474f-a3bd-c2339634c3c2">
<img width="1342" alt="image" src="https://github.com/JackyTang0516/Flashsale-System/assets/111934442/d638f3f0-b347-42f5-82af-03ba42429f18">
<img width="989" alt="image" src="https://github.com/JackyTang0516/Flashsale-System/assets/111934442/f8d996d7-df39-4ace-9395-c4ca5c4ea1c2">


## Conclusion
- This shopping system stands as a testament to high-efficiency web development, with a focus on scalability, performance, and reliability. It's an exemplary model for modern e-commerce platforms seeking to thrive in high-demand scenarios.



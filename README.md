# MYGO接口

#### 1. 项目概述

提供 API 接口供开发者调用的平台，基于 Spring Boot 后端 + React 前端的 全栈微服务项目。
管理员可以接入并发布接口、统计分析各接口调用情况；用户可以注册登录并开通接口调用权限、
浏览接口、在线调试，还能使用 客户端 SDK 轻松在代码中调用接口

#### 2. 项目架构

##### 2.1项目结构

![项目结构](https://github.com/MegumiN152/MYGO-API/assets/104641621/3c08c0b9-99c9-4936-be0e-4587e6cadfa0)

##### 2.2 后端模块

* yuapi-backend：后端服务，提供用户、接口等基本操作。
* yuapi-common：项目公共模块，包含一些公用的实体类和接口。
* yuapi-gateway：api网关，后端的入口，作服务转发、用户鉴权、统一日志、服务接口调用计数，统一业务处理。
* yuapi-interface：平台提供的接口服务（可更新扩展）
* yuapi-client-sdk：提供给开发者的SDK，方便后端调用并使项目结构更简洁。

##### 2.3 项目流程

用户登录后通过浏览器浏览接口并调用接口发出请求，请求发到后端服务器，经过sdk客户端对请求进行签名认证并把请求发送给API网关。网关对请求进行鉴权、统一日志和对接口检查，若通过则将请求发送到接口服务后端，接口服务返回调用结果，网关会对结果进行日志处理和处理调用成功后的一系列业务。

##### 2.4 项目技术栈

* Spring Boot
* MySQL数据库
* Mybatis-Plus
* Dubbo分布式
* SpringCloud Gateway
* Swagger 、Knife4j
* Hutool、Apache Common Utils、Gson、RestTemplate、MyBatis X等工具库

#### 3. 使用说明

##### 3.1 普通用户使用

* 用户登录
  ![注册](https://github.com/MegumiN152/MYGO-API/assets/104641621/2af777ef-07aa-4692-a320-6230d3c40283)
* 查看接口  
  ![查询接口](https://github.com/MegumiN152/MYGO-API/assets/104641621/9bce8980-d594-418d-9329-5f782b06c353)
* 调用接口
  ![接口详细信息](https://github.com/MegumiN152/MYGO-API/assets/104641621/9335b52b-db81-4bde-983c-db1417b6e35d)
* 返回结果
  ![调用接口](https://github.com/MegumiN152/MYGO-API/assets/104641621/5200dd61-9473-4889-8b0d-bc553dc36933)

##### 3.2管理员使用

普通用户的使用也适用于管理员

* 查看接口

![接口管理](https://github.com/MegumiN152/MYGO-API/assets/104641621/12704a85-4476-4909-bb80-3e906f357831)

管理员可以上线接口，下线接口，删除接口

* 修改和添加接口
  ![修改接口](https://github.com/MegumiN152/MYGO-API/assets/104641621/40c86d36-f066-4204-ad1d-c01355b97be4)
* 搜索接口
  ![查询接口](https://github.com/MegumiN152/MYGO-API/assets/104641621/9a38a8e1-5115-4848-984f-ecaacf89c76b)
* 查看接口分析
  ![接口分析](https://github.com/MegumiN152/MYGO-API/assets/104641621/89d25f12-0b31-4222-9214-d97620a27302)

#### 4. 功能介绍

##### 4.1数据库表设计

* 用户表

 ```  
create table user
(
    id           bigint auto_increment comment 'id'
        primary key,
    userName     varchar(256)                           null comment '用户昵称',
    userAccount  varchar(256)                           not null comment '账号',
    userAvatar   varchar(1024)                          null comment '用户头像',
    gender       tinyint                                null comment '性别',
    userRole     varchar(256) default 'user'            not null comment '用户角色：user / admin',
    userPassword varchar(512)                           not null comment '密码',
    accessKey    varchar(512)                           not null comment 'accessKey',
    secretKey    varchar(512)                           not null comment 'secreKey',
    createTime   datetime     default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime   datetime     default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete     tinyint      default 0                 not null comment '是否删除',
    constraint uni_userAccount
        unique (userAccount)
)
    comment '用户';  
 ```

* 接口表

```
create table interface_info
(
    id             bigint auto_increment comment '主键'
        primary key,
    name           varchar(256)                       not null comment '名称',
    description    varchar(256)                       null comment '描述',
    url            varchar(512)                       not null comment '接口地址',
    requestHeader  text                               null comment '请求头',
    responseHeader text                               null comment '响应头',
    status         int      default 0                 not null comment '接口状态（0-关闭，1-开启）',
    method         varchar(256)                       not null comment '请求类型',
    userId         bigint                             not null comment '创建人',
    createTime     datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime     datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete       tinyint  default 0                 not null comment '是否删除(0-未删, 1-已删)',
    requestParams  text                               null comment '请求参数'
)
    comment '接口信息';
```

* 接口用户表

```
create table user_interface_info
(
    id              bigint auto_increment comment '主键'
        primary key,
    userId          bigint                             not null comment '调用用户 id',
    interfaceInfoId bigint                             not null comment '接口id',
    totalNum        int      default 0                 not null comment '总调用次数',
    leftNum         int      default 0                 not null comment '剩余调用次数',
    status          int      default 0                 not null comment '0-正常，1禁用',
    createTime      datetime default CURRENT_TIMESTAMP not null comment '创建时间',
    updateTime      datetime default CURRENT_TIMESTAMP not null on update CURRENT_TIMESTAMP comment '更新时间',
    isDelete        tinyint  default 0                 not null comment '是否删除(0-未删, 1-已删)'
)
    comment '用户调用接口关系';
```

##### 4.2 用户功能设计

+ 普通用户可以继续登录、注册、退出。
+ 管理员可以进行登录、退出、增加用户、删除用户、修改用户、查询用户。
  管理员权限是使用 **注解和aop** 实现

```
    @Around("@annotation(authCheck)")
    public Object doInterceptor(ProceedingJoinPoint joinPoint, AuthCheck authCheck) throws Throwable {
        List<String> anyRole = Arrays.stream(authCheck.anyRole()).filter(StringUtils::isNotBlank).collect(Collectors.toList());
        String mustRole = authCheck.mustRole();
        RequestAttributes requestAttributes = RequestContextHolder.currentRequestAttributes();
        HttpServletRequest request = ((ServletRequestAttributes) requestAttributes).getRequest();
        // 当前登录用户
        User user = userService.getLoginUser(request);
        // 拥有任意权限即通过
        if (CollectionUtils.isNotEmpty(anyRole)) {
            String userRole = user.getUserRole();
            if (!anyRole.contains(userRole)) {
                throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
            }
        }
        // 必须有所有权限才通过
        if (StringUtils.isNotBlank(mustRole)) {
            String userRole = user.getUserRole();
            if (!mustRole.equals(userRole)) {
                throw new BusinessException(ErrorCode.NO_AUTH_ERROR);
            }
        }
        // 通过权限校验，放行
        return joinPoint.proceed();
    }
```

##### 4.2 接口功能设计

* 用户可以查看并调用接口
* 管理员可以添加接口、删除接口、修改接口、查看接口、上线接口、下线接口。

##### 4.3 安全调用接口功能设计

本项目使用API签名认证方法来实现安全调用接口功能。

* 签名的生成

```
    private Map<String, String> getHeaderMap(String body)   {
        HashMap<String, String> hashMap = new HashMap<>();
        hashMap.put("accessKey", accesskey);
        hashMap.put("nonce", RandomUtil.randomNumbers(4));
        try {
            hashMap.put("body",  URLEncoder.encode(body,"utf-8"));
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
        hashMap.put("timestamp", String.valueOf(System.currentTimeMillis() / 1000));
        hashMap.put("sign", SignUtils.getSign(body, secretkey));
        return hashMap;
    }
    public static  String getSign(String object,String secretKey){
        //使用SHA256算法的Disgeter
        Digester md5=new Digester(DigestAlgorithm.SHA256);
        String content=object+"."+secretKey;
        return md5.digestHex(content);

    }
    public  String getChickenSoup(){
        HttpResponse execute = HttpRequest.get(GATEWAY_HOST + "/api/txt/chickSoup/")
                .addHeaders(getHeaderMap("")).body("").execute();
        return execute.body();
    }
```

* 验证签名
  在网关校验签名

```
//        3. 用户鉴权（判断ak，sk是否合法）
        HttpHeaders headers = request.getHeaders();
        String accessKey = headers.getFirst("accessKey");
        String body = null;
        try {
            if (headers.getFirst("body")!=null){
                body = URLDecoder.decode(headers.getFirst("body"),"utf-8");
            }
        } catch (UnsupportedEncodingException e) {
            throw new RuntimeException(e);
        }
        String nonce = headers.getFirst("nonce");
        String timestamp = headers.getFirst("timestamp");
        String sign = headers.getFirst("sign");

        User invokeUser = null;
        try {
            invokeUser = innerUserService.getInvokeUser(accessKey);
        } catch (Exception e) {
            log.error("getInvokeUser错误", e);
        }
        if (invokeUser == null) {
            return handleInvokeError(response);
        }

        if (Long.parseLong(nonce) > 10000L) {
            return handleNoAuth(response);
        }
        //时间和当前时间不超过 5分钟
        long currentTime = System.currentTimeMillis() / 1000;
        long FIVE_MINUTES = 60 * 5L;
        if ((currentTime - Long.parseLong(timestamp)) >= FIVE_MINUTES) {
            return handleNoAuth(response);
        }
        String secretKey = invokeUser.getSecretKey();
        String serverSign = SignUtils.getSign(body, secretKey);
        if (sign == null || !sign.equals(serverSign)) {
            return handleNoAuth(response);
        }
```


本项目实现了sdk的开发来简化后端的调用

```
@Configuration
@ConfigurationProperties(prefix = "yuapi.client")
@Data
@ComponentScan
public class YuApiClientConfig {
    private String accessKey;
    private String secretKey;
    @Bean
    public YuApiClient hhApiClient(){
     return new YuApiClient(accessKey,secretKey);
    }
}
```

##### 4.4 接口服务功能设计

* 获取b站热搜集合
  ![获取b站热搜](https://github.com/MegumiN152/MYGO-API/assets/104641621/91519d0f-94a1-40bc-993d-b9d46b99682c)
* 获取随机食物名称
  ![吃什么](https://github.com/MegumiN152/MYGO-API/assets/104641621/cb02257b-f959-454f-9f9a-8ee5427574da)
* 60s读懂世界
  ![60s读懂世界](https://github.com/MegumiN152/MYGO-API/assets/104641621/cece0128-3dbb-4de7-9712-2f32fb73af91)
* 输入ip获取该ip的具体信息
  ![ip信息](https://github.com/MegumiN152/MYGO-API/assets/104641621/1c7c2f41-579c-4421-86a2-8640bf315f56)

##### 4.5 用户接口功能设计

* 调用接口前查询用户是否还有调用次数
* 调用接口后更新用户接口表
* 根据调用次数统计出调用次数排名前三的接口

#### 5. 联系方式

* 邮箱：3105755134@qq.com

本项目集成了mybatis的三种实现方式

1、通过配置xml的方式操作数据
2、通过继承mapper接口操作数据，mapper接口操作数据有多种方式，如 tk.mybatis、mybatis-plus,本项目使用mybatis-plus
3、通过注解方式操作数据，例如使用 @SelectProvider注解动态拼装sql查询数据，适用于复杂的sql查询

xml实现参考		XmlMybatisSysRoleController.java
实体实现参考	EntityMybatisPlusUserController.java
注解实现		AnnotationMybatisScoreController.java

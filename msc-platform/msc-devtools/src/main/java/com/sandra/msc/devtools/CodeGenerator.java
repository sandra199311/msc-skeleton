package com.sandra.msc.devtools;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.PackageConfig;
import com.baomidou.mybatisplus.generator.config.StrategyConfig;
import com.baomidou.mybatisplus.generator.config.TemplateConfig;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

/**
 * 
 * 自动代码生成器
 *
 * @author sandra
 * @date 2019年12月26日
 */
public class CodeGenerator {

    public static void main(final String[] args) {

        final String author = "sandra";
        final String tableNames = "business_process_inst,approval_record";
        final String modelName = "authserver";
        final String packageParent = "com.sandra.msc";

        final String dbUrl = "jdbc:mysql://192.168.12.2:3306/rms_flow?useUnicode=true"
                + "&characterEncoding=UTF-8&autoReconnect=true" + "&useSSL=false&zeroDateTimeBehavior=convertToNull";
        final String dbUsername = "root";
        final String dbPassword = "123456";
        final String dbDriverName = "com.mysql.cj.jdbc.Driver";

        // 代码生成器
        final AutoGenerator mpg = new AutoGenerator();

        // 全局配置
        final GlobalConfig gc = new GlobalConfig();
        final String projectPath = System.getProperty("user.dir");
        gc.setOutputDir(projectPath + "/src/main/java");
        gc.setAuthor(author);
        gc.setOpen(false);
        gc.setSwagger2(true); //实体属性 Swagger2 注解

        // 自定义文件命名，注意 %s 会自动填充表实体属性！
        gc.setMapperName("%sMapper");
        gc.setXmlName("%sMapper");
        gc.setServiceName("I%sService");
        gc.setServiceImplName("%sServiceImpl");
        gc.setControllerName("%sController");

        gc.setBaseResultMap(true);//mapper文件中是否生成BaseResultMap
        gc.setBaseColumnList(true);
        mpg.setGlobalConfig(gc);

        // 数据源配置
        final DataSourceConfig dsc = new DataSourceConfig();
        dsc.setUrl(dbUrl);
        // dsc.setSchemaName("public");
        dsc.setDriverName(dbDriverName);
        dsc.setUsername(dbUsername);
        dsc.setPassword(dbPassword);
        mpg.setDataSource(dsc);

        // 包配置
        final PackageConfig pc = new PackageConfig();
        pc.setModuleName(modelName);
        pc.setParent(packageParent);
        mpg.setPackageInfo(pc);

        // 策略配置
        final StrategyConfig strategy = new StrategyConfig();

        //命名策略
        strategy.setNaming(NamingStrategy.underline_to_camel);
        strategy.setColumnNaming(NamingStrategy.underline_to_camel);
        strategy.setRestControllerStyle(true);
        strategy.setControllerMappingHyphenStyle(true);
        // 设置公共父类，不需要
        //        strategy.setSuperControllerClass("com.baomidou.ant.common.BaseController");

        //实体类自动继承Entity,不需要也可以
        //        strategy.setSuperEntityClass("com.baomidou.ant.common.BaseEntity");
        //        strategy.setSuperEntityColumns("id");
        //Boolean类型字段是否移除is前缀（默认 false）
        strategy.setEntityBooleanColumnRemoveIsPrefix(true);
        strategy.setEntityLombokModel(true);
        strategy.setInclude(tableNames.split(","));
        //        strategy.setTablePrefix(pc.getModuleName() + "_");
        mpg.setStrategy(strategy);

        // 配置模板
        final TemplateConfig templateConfig = new TemplateConfig();
        // 配置自定义输出模板
        //指定自定义模板路径，注意不要带上.ftl/.vm, 会根据使用的模板引擎自动识别
        templateConfig.setEntity("templates/entity.java");
        templateConfig.setMapper("templates/mapper.java");
        templateConfig.setService("templates/service.java");
        templateConfig.setServiceImpl("templates/serviceImpl.java");
        templateConfig.setController("templates/controller.java");
        templateConfig.setXml("templates/mapper.xml");
        mpg.setTemplate(templateConfig);
        mpg.setTemplateEngine(new FreemarkerTemplateEngine());

        //        // 自定义配置
        //        final InjectionConfig cfg = new InjectionConfig() {
        //
        //            @Override
        //            public void initMap() {
        //
        //                // to do nothing
        //            }
        //        };
        //
        //        // 如果模板引擎是 freemarker
        //        final String templatePath = "templates/mapper.xml.ftl";
        //        // 如果模板引擎是 velocity
        //        //        final String templatePath = "/templates/mapper.xml.vm";
        //
        //        // 自定义输出配置(xml生成目录)
        //        final List<FileOutConfig> focList = new ArrayList<>();
        //        // 自定义配置会被优先输出
        //        focList.add(new FileOutConfig(templatePath) {
        //
        //            @Override
        //            public String outputFile(final TableInfo tableInfo) {
        //
        //                // 自定义输出文件名 ， 如果你 Entity 设置了前后缀、此处注意 xml 的名称会跟着发生变化！！
        //                return projectPath + "/src/java/resources/mapper/" + tableInfo.getEntityName() + "Mapper"
        //                        + StringPool.DOT_XML;
        //            }
        //        });
        //
        //        cfg.setFileOutConfigList(focList);
        //        mpg.setCfg(cfg);

        //生成代码
        mpg.execute();
    }

}

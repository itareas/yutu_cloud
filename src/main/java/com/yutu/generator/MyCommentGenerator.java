package com.yutu.generator;

import org.mybatis.generator.api.CommentGenerator;
import org.mybatis.generator.api.IntrospectedColumn;
import org.mybatis.generator.api.IntrospectedTable;
import org.mybatis.generator.api.dom.java.*;
import org.mybatis.generator.api.dom.xml.XmlElement;
import org.mybatis.generator.config.PropertyRegistry;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Properties;
import java.util.Set;

import static org.mybatis.generator.internal.util.StringUtility.isTrue;

/**
 * @Author: zhaobc
 * @Date: 2019-12-16 10:31
 * @Description: mybatis generator 自定义comment生成器.
 */
public class MyCommentGenerator implements CommentGenerator {
    /**
     * @Author: zhaobc
     * @Date: 2019-12-16 10:35
     * @Description: 内部配置文件
     */
    private Properties properties;

    /**
     * @Author: zhaobc
     * @Date: 2019-12-16 10:35
     * @Description: 作者
     */
    private String author;

    /**
     * @Author: zhaobc
     * @Date: 2019-12-16 10:36
     * @Description: 注释生成器取消日期
     */
    private boolean suppressDate;

    /**
     * @Author: zhaobc
     * @Date: 2019-12-16 10:36
     * @Description: 注释生成器禁止所有注释
     */
    private boolean suppressAllComments;

    /**
     * @Author: zhaobc
     * @Date: 2019-12-16 10:36
     * @Description: 当前时间
     */
    private String datetime;

    public MyCommentGenerator() {
        super();
        properties = new Properties();
        //author = System.getProperties().getProperty("user.name");
        author="zhaobc";
        suppressDate = false;
        suppressAllComments = false;
        datetime = (new SimpleDateFormat("yyyy-MM-dd HH:mm")).format(new Date());
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-16 10:37
     * @Description: 从该配置中的任何属性添加此实例的属性CommentGenerator配置。这个方法将在任何其他方法之前被调用。
     */
    @Override
    public void addConfigurationProperties(Properties properties) {
        this.properties.putAll(properties);
        suppressDate = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_DATE));
        suppressAllComments = isTrue(properties.getProperty(PropertyRegistry.COMMENT_GENERATOR_SUPPRESS_ALL_COMMENTS));
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-16 10:53
     * @Description: java属性注解
     * */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append("* @Author: "+this.author);
        field.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Date "+this.datetime);
        field.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Description: ");
        sb.append(introspectedColumn.getRemarks());
        field.addJavaDocLine(sb.toString().replace("\n", " "));
        field.addJavaDocLine("**/");
    }

    /**
     * @Author: zhaobc
     * @Date: 2019-12-16 11:38
     * @Description: 属性注释
     */
    @Override
    public void addFieldComment(Field field, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        field.addJavaDocLine("/**");
        sb.append("* @Author: "+this.author);
        field.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Date "+this.datetime);
        field.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Description: ");
        sb.append(introspectedTable.getFullyQualifiedTable());
        field.addJavaDocLine(sb.toString().replace("\n", " "));
        field.addJavaDocLine("**/");
    }

    @Override
    public void addModelClassComment(TopLevelClass topLevelClass, IntrospectedTable introspectedTable) {

    }

    /**
    * @Author: zhaobc
    * @Date: 2019-12-16 11:40
    * @Description: 类注释位置
    **/
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        innerClass.addJavaDocLine("/**");
        sb.append("* @Author: "+this.author);
        innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Date "+this.datetime);
        innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Description: ");
        innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
        innerClass.addJavaDocLine("**/");
    }

    /**
    * @Author: zhaobc
    * @Date: 2019-12-16 11:41
    * @Description: 类注释位置
    **/
    @Override
    public void addClassComment(InnerClass innerClass, IntrospectedTable introspectedTable, boolean b) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        innerClass.addJavaDocLine("/**");
        sb.append("* @Author: "+this.author);
        innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Date "+this.datetime);
        innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Description: ");
        innerClass.addJavaDocLine(sb.toString().replace("\n", " "));
        innerClass.addJavaDocLine("**/");
    }

    /**
    * @Author: zhaobc
    * @Date: 2019-12-16 11:42
    * @Description: 枚举注释位置
    **/
    @Override
    public void addEnumComment(InnerEnum innerEnum, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        innerEnum.addJavaDocLine("/**");
        sb.append("* @Author: "+this.author);
        innerEnum.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Date "+this.datetime);
        innerEnum.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Description: ");
        innerEnum.addJavaDocLine(sb.toString().replace("\n", " "));
        innerEnum.addJavaDocLine("**/");
    }

    /**
    * @Author: zhaobc
    * @Date: 2019-12-16 11:43
    * @Description: Get方法注释位置
    **/
    @Override
    public void addGetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) { }

    /**
    * @Author: zhaobc
    * @Date: 2019-12-16 11:43
    * @Description: Set方法注释位置
    **/
    @Override
    public void addSetterComment(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn) { }

    /**
    * @Author: zhaobc
    * @Date: 2019-12-16 11:43
    * @Description: 通方法的注释，这里主要是XXXMapper.java里面的接口方法的注释
    **/
    @Override
    public void addGeneralMethodComment(Method method, IntrospectedTable introspectedTable) {
        if (suppressAllComments) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        method.addJavaDocLine("/**");
        sb.append("* @Author: "+this.author);
        method.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Date "+this.datetime);
        method.addJavaDocLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Description: ");
        method.addJavaDocLine(sb.toString().replace("\n", " "));
        method.addJavaDocLine("**/");
    }

    /**
    * @Author: zhaobc
    * @Date: 2019-12-16 11:44
    * @Description: 给Java文件加注释，这个注释是在文件的顶部，也就是package上面。
    **/
    @Override
    public void addJavaFileComment(CompilationUnit compilationUnit) {
        StringBuilder sb = new StringBuilder();
        compilationUnit.addFileCommentLine("/**");
        sb.append("* @Author: "+this.author);
        compilationUnit.addFileCommentLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Date "+this.datetime);
        compilationUnit.addFileCommentLine(sb.toString().replace("\n", " "));
        sb.setLength(0);
        sb.append("* @Description: ");
        compilationUnit.addFileCommentLine(sb.toString().replace("\n", " "));
        compilationUnit.addFileCommentLine("**/");
    }

    /**
    * @Author: zhaobc
    * @Date: 2019-12-16 11:46
    * @Description: Mybatis的Mapper.xml文件里面的注释
    **/
    @Override
    public void addComment(XmlElement xmlElement) {

    }

    /**
    * @Author: zhaobc
    * @Date: 2019-12-16 11:46
    * @Description: 为调用此方法作为根元素的第一个子节点添加注释。
    **/
    @Override
    public void addRootComment(XmlElement xmlElement) {

    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {

    }

    @Override
    public void addGeneralMethodAnnotation(Method method, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {

    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {

    }

    @Override
    public void addFieldAnnotation(Field field, IntrospectedTable introspectedTable, IntrospectedColumn introspectedColumn, Set<FullyQualifiedJavaType> set) {

    }

    @Override
    public void addClassAnnotation(InnerClass innerClass, IntrospectedTable introspectedTable, Set<FullyQualifiedJavaType> set) {

    }
}

package org.example.Test;


import org.example.Member;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.util.Optional;

/**
 * @author Kelvin范显
 * @createDate 2019年03月25日
 */

@RunWith(SpringRunner.class)
@SpringBootTest(classes={Member.class})// 指定启动类
public class BaseTest {

    /**
     * -------------------
     * <com.ruoyi.base.BaseTest#print>
     * test print
     * </com.ruoyi.base.BaseTest#print>
     * -------------------
     * @param info
     */
    public void print(Object info) {
        StackTraceElement[] stacks = (new Throwable()).getStackTrace();
        StackTraceElement stack = Optional.ofNullable(stacks[1]).orElse(stacks[0]);
        System.out.println("\n-------------------\n"
                +"<"+stack.getClassName() + "#" + stack.getMethodName()+">\n"
                +info.toString()+"\n"
                +"</"+stack.getClassName() + "#" + stack.getMethodName()+">\n"
                +"-------------------\n");
    }


    public static void main(String[] args) {
        new BaseTest().print("test print");
    }
}
package pers.demo.asa.vwe.common.generator;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description:
 * @Author jet.xie
 * @Date: Created at 12:16 2019/10/29.
 */
public class CodeGeneratorTest {
    public static void main(String[] args) {
        String[] first = {"2", "3"};
        String[] concat = CodeGenerator.concat(first, "1");
        for (String ele : concat) {
            System.out.println(ele);
        }
    }
}
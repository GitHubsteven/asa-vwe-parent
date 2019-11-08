package pers.demo.asa.vwe.common.generator.support;

import com.baomidou.mybatisplus.core.toolkit.StringUtils;

import java.util.*;
import java.util.stream.Collectors;

/**
 * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
 * @Description: vmg的生成辅助类
 * @Author jet.xie
 * @Date: Created at 16:25 2019/11/6.
 */
public class VMGUtils {
    /**
     * 构建生成文件的路径
     *
     * @param usrDir      userDir的路径
     * @param modules     模块路径链，入parent,submodule
     * @param srcMain     主包名，如src/main/java,src/main/resources
     * @param packageName 包名，如com.sun.javax
     * @param moduleName  直接的子模块名称，如wms,vms,oms，可以为空
     * @param dirPackage  最后的包，如model,service,controller
     * @return 文件的生成路径
     */
    public static String buildPath(String usrDir, String[] modules, String srcMain,
                                   String packageName, String moduleName, String dirPackage) {
        List<String> totalPath = new ArrayList<>();
        totalPath.add(usrDir);
        if (modules == null)
            throw new IllegalArgumentException("modules不能为空!");
        for (String module : modules) {
            if (!usrDir.contains(module) && !totalPath.contains(module)) totalPath.add(module);
        }
        totalPath.add(srcMain);
        String[] packagePaths = packageName.split("\\.");
        Collections.addAll(totalPath, packagePaths);
        totalPath.add(moduleName);
        Collections.addAll(totalPath, dirPackage.split("\\."));
        String pathTmp = totalPath.stream().filter(StringUtils::isNotEmpty)
                .collect(Collectors.joining("/"));
        //去除//和.
        pathTmp = pathTmp.replaceAll("//", "/");
        return pathTmp;
    }

    public static String buildPath(String usrDir, String[] modules, String srcMain,
                                   String packageName, String dirPackage) {
        return buildPath(usrDir, modules, srcMain, packageName, null, dirPackage);
    }


    /**
     * 数组拼接
     *
     * @param first  第一个数组
     * @param append 后续数组
     * @param <T>    类型
     * @return 拼接后的数组
     */
    @SuppressWarnings("unchecked")
    public static <T> T[] concat(T[] first, T... append) {
        if (append == null || append.length == 0) return first;
        if (first == null || first.length == 0) return append;
        Object[] result = new Object[first.length + append.length];
        System.arraycopy(first, 0, result, 0, first.length);
        System.arraycopy(append, 0, result, first.length, append.length);
        return (T[]) Arrays.copyOf(result, result.length, first.getClass());
    }

    public static <T> boolean addNotNull(Collection<T> dataSet, T ele) {
        if (ele == null) return false;
        return dataSet.add(ele);
    }
}
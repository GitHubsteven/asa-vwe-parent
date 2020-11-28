//package pers.demo.asa.vwe.blog.stater.service;
//
//import com.baomidou.mybatisplus.core.metadata.IPage;
//import com.baomidou.mybatisplus.core.metadata.OrderItem;
//import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
//import org.junit.Assert;
//import org.junit.Test;
//import org.springframework.beans.factory.annotation.Autowired;
//import pers.demo.asa.vwe.blog.model.BlogModel;
//import pers.demo.asa.vwe.blog.service.IBlogService;
//import pers.demo.asa.vwe.blog.stater.BaseTest;
//
//import java.text.SimpleDateFormat;
//import java.util.Collections;
//import java.util.Date;
//
///**
// * @version 1.0.0 COPYRIGHT © 2001 - 2019 VOYAGE ONE GROUP INC. ALL RIGHTS RESERVED.
// * @Description:
// * @Author jet.xie
// * @Date: Created at 21:04 2019/11/8.
// */
//public class BlogServiceTest extends BaseTest {
//    @Autowired
//    private IBlogService iBlogService;
//
//    @Test
//    public void testGetById() {
//        BlogModel blog = iBlogService.getById(1);
//        System.out.println(blog.getContent());
//    }
//
//    @Test
//    public void testSave() {
//        BlogModel blogModel = new BlogModel();
//        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("YYYYMMDDHHmmSS");
//        String label = simpleDateFormat.format(new Date());
//        String finalLabel = label.substring(label.length() - 4);
//        blogModel.setTitle("title" + finalLabel)
//                .setAuthor("asa.x")
//                .setContent("content " + finalLabel)
//                .setCreator("BlogServiceTest")
//                .setModifier("BlogServiceTest");
////        boolean save = iBlogService.save(blogModel);
////        Assert.assertTrue(save);
//    }
//
//
//    @Test
//    public void testUpdate() {
//        BlogModel blogModel = new BlogModel();
//        blogModel.setId(1);
//        blogModel
//                .setModifier("BlogServiceTest-update");
//        boolean update = iBlogService.updateById(blogModel);
//        Assert.assertTrue(update);
//    }
//
//    @Test
//    public void testSelectWithPage() {
//        Page<BlogModel> page = new Page<>();
//        page.setCurrent(1L).setSize(10).setOrders(Collections.singletonList(OrderItem.desc("id")));
//        BlogModel checkModel = new BlogModel();
//        checkModel.setAuthor("asa.x");
//        checkModel.setTitle("2");
//        IPage<BlogModel> pageResult = iBlogService.selectBlogPage(page, checkModel);
//        System.out.println(pageResult.getRecords().size());
//    }
//}
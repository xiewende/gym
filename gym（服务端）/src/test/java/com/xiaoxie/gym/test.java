package com.xiaoxie.gym;

import com.mysql.cj.protocol.x.Notice;
import com.xiaoxie.gym.competition.mapper.JudgeMapper;
import com.xiaoxie.gym.competition.pojo.Judge;
import com.xiaoxie.gym.place.mapper.AnnouncementMapper;
import com.xiaoxie.gym.place.mapper.FieldRentInfoMapper;
import com.xiaoxie.gym.place.pojo.FieldRentInfo;
import com.xiaoxie.gym.place.pojo.FieldRentInfoExample;
import com.xiaoxie.gym.place.util.GetUser;
import com.xiaoxie.gym.place.util.ReturnMsg;
import com.xiaoxie.gym.place.util.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;
import org.springframework.web.client.RestTemplate;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * @create 2020-05-27  23:03
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class test {

    @Autowired
    private AnnouncementMapper announcementMapper;
    @Autowired
    private JudgeMapper judgeMapper;
    @Autowired
    private FieldRentInfoMapper fieldRentInfoMapper;

    @Test
    public void test1(){
        /*Announcement announcement = new Announcement();
        announcement.setAnnouncementAuthor("xiaoxie");
        announcement.setAnnouncementConten("you are good");
        announcement.setAnnouncementTime(new Date());
        announcement.setAnnouncementTitle("today");
        announcement.setAnnouncementDelelte(0);
        announcementMapper.insert(announcement);
        System.out.println("ddd");*/

        FieldRentInfoExample fieldRentInfoExample = new FieldRentInfoExample();
        FieldRentInfoExample.Criteria criteria = fieldRentInfoExample.createCriteria();
        criteria.andDeleteTagEqualTo(0);
        List<FieldRentInfo> fieldRentInfos = fieldRentInfoMapper.selectByExample(fieldRentInfoExample);
        System.out.println(fieldRentInfos.size());


    }

    @Test
    public void test2(){
        Judge judge = new Judge();
        judge.setCreateTime(new Date());
        judge.setName("小米");
        judge.setDeleted(0);
        judge.setPhotoUrl("http:baidu,com");
        judge.setProfile("good");
        judge.setSpecialities("coding");
        judge.setUpdateTime(new Date());
        judgeMapper.insert(judge);
    }

    @Test
    public void test3(){
        try {
            String str = "2020-05-30 15:30:00";
            Date currentTime = new Date();
            System.out.println(currentTime);
            SimpleDateFormat ft = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
            Date rentBegin = ft.parse(str);
            System.out.println(rentBegin);
        }catch (Exception e){
            e.printStackTrace();
        }

    }


    @Test
    public void test4(){
        try {
            RestTemplate restTemplate = new RestTemplate();
            //将指定的url返回的参数自动封装到自定义好的对应类对象中
           // ReturnMsg returnMsg = restTemplate.getForObject("http://47.116.67.43:8001//user/{id}", ReturnMsg.class,5);
            User user = GetUser.getUser(5);
          /*  System.out.println(user);
            System.out.println(user.getMsg());
            User data = user.getData();*/
            System.out.println(user.getName());
            System.out.println(user.getPhone());
        }catch (HttpClientErrorException e){
            System.out.println("http客户端请求出错了！");
            //开发中可以使用统一异常处理，或者在业务逻辑的catch中作响应
        }
    }
}

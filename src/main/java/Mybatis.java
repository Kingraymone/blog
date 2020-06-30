import top.king.mapper.RoleMapper;
import top.king.mapper.UserMapper;
import top.king.model.Role;
import top.king.model.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.InputStream;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Mybatis {
    public static void main(String[] args) {
        try {
            String resources = "mybatis.xml";
            InputStream resourceAsStream = Resources.getResourceAsStream(resources);
            SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(resourceAsStream);
            SqlSession sqlSession = sqlSessionFactory.openSession();
            UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
            RoleMapper roleMapper = sqlSession.getMapper(RoleMapper.class);
            Map<String,Integer> map = new HashMap<>(4);
            map.put("id",1);
            Role role = roleMapper.selectRoleById(2);
            List<User> users = userMapper.selectUsers();
            System.out.println(users);
            System.out.println(role);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
